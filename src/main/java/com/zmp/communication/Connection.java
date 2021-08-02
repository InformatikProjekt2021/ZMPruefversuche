package com.zmp.communication;

import com.zmp.model.PartResult;
import com.zmp.model.Result;
import com.zmp.services.PartResultService;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * class that acts as tcp server on port 8081
 */
public class Connection extends Thread {

    private DataInputStream in;
    private DataOutputStream out;

    /**
     * function to receive a text or csv file from a tcp client
     * @param file received file
     */
    public void receiveFile(File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        byte[] buf = new byte[Short.MAX_VALUE];
        int bytesSent;
        while( (bytesSent = in.readShort()) != -1 ) {
            in.readFully(buf,0,bytesSent);
            fileOut.write(buf,0,bytesSent);
        }
        fileOut.close();
    }

    /**
     * writes the parameter of the current experiment to outputstream
     * @param data parameters of the current experiment
     */
    public void writeStream(Double[] data){
        try{
            for (double d : data) {
                out.writeDouble(d);
                System.out.println("Server writes: "+d);
            }
        } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
        } catch( NullPointerException e) {System.out.println(" NullPointer:"+ e.getMessage());
        } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}
    }

    /**
     * function that actually receives and processes the received file
     * ich line is a partExperiment will be stored in the database and outputfile
     * @param partResultService service to access partResult repository
     */
    public void readStream(PartResultService partResultService){
        PartResult partResult = null;
        Result result = null;
        List<PartResult> listOfResults = new ArrayList<>();
        File file;
        String OS = System.getProperty("os.name");

        result = new Result();
        try {
            if(OS.contains("Windows")) {
                file = new File("..\\receivedFileServer.txt");
            }else{
                file = new File("/../receivedFileServer.txt");
            }

            receiveFile(file);
            System.out.println("File received "+file.length()+" bytes");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String data;
            while ((data = br.readLine()) != null){
                data = data.replaceAll(",",".");
                String[] params = data.split(";");

                double[] converted = new double[6];
                for(int i = 0; i<params.length;i++){
                    try{
                        converted[i] = Double.parseDouble(params[i]);
                    }catch (Exception e){
                        System.out.println(" Parsing failed:"+ e.getMessage());
                    }
                }

                partResult = new PartResult(converted[0],result,ConnectionHandler.getExperiment(),converted[4],
                        converted[5],converted[3],converted[2],converted[1]);

                listOfResults.add(partResult);

                partResultService.save(partResult);
            }
        } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
        } catch( NullPointerException e) {System.out.println("End of message");
        } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}
        ConnectionHandler.getExperiment().setPartResult(listOfResults);
    }

    /**
     * function that creates the connestion
     * @param aClientSocket Socket of the client that wants to connect
     */
    public Connection (Socket aClientSocket) {
        try {
            in = new DataInputStream ( aClientSocket.getInputStream());
            out = new DataOutputStream (aClientSocket.getOutputStream());
            this.start();
        } catch( IOException e) {System. out. println(" Connection:"+ e.getMessage());}
    }

    public void run(){
    }
}