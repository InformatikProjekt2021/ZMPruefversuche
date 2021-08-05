package com.zmp.communication;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * simulates the tcp client that sends the experiment results as a file
 * has to be started in order to get a successful Experiment data transmission
 * requires testResultData.txt (filled with correct Test data) to be in the application directory
 * for further Information take the TCP chapter of the documentation into consideration
 */
public class TCPClient {
    private DataInputStream input;

    private DataOutputStream output;

    /**
     * function that reads the experiment input data sent by the server
     * @param inputStream inputstream of tcp connection
     *
     */
    private static void read (DataInputStream inputStream) throws IOException {
        int i=0;
        try {
            while (true) {
                String data = inputStream.readUTF();
                System.out.println("Client received: " + data);
                if(i == 3){
                        break;
                }
                i++;
            }
        } catch (UnknownHostException e) {
            System.out.println(" Sock:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println(" EOF:" + e.getMessage());
        }
    }

    /**
     * function that sends the result file to the Application
     * @param file file that contains the result test data (headerless semicolon separated) the server expects
     * @param output output stream of the connection
     */
    public void sendFile(File file,DataOutputStream output) throws IOException {
        FileInputStream fileIn = new FileInputStream(file);
        byte[] buf = new byte[Short.MAX_VALUE];
        int bytesRead;
        while( (bytesRead = fileIn.read(buf)) != -1 ) {
            output.writeShort(bytesRead);
            output.write(buf,0,bytesRead);
        }
        output.writeShort(-1);
        fileIn.close();
    }

    /**
     * simulation of communication
     */
    public static void main (String[] args) {
            TCPClient client = new TCPClient();
        try{
            int serverPort = 8081;
            Socket s = new Socket ("127.0.0.1", serverPort);
            DataOutputStream out = new DataOutputStream (s.getOutputStream());
            DataInputStream in = new DataInputStream (s.getInputStream());
            String OS = System.getProperty("os.name");
            File file;
            if(OS.contains("Windows")) {
                // INSERT FILE LOCATION HERE
                file = new File("..\\testResultData.txt");
            }else{
                file = new File("../testResultData.txt");
            }
            //read data
            read(in);
            System.out.println("writing..");
            //send result file
            client.sendFile(file,out);
            s.close();
        }catch (UnknownHostException e){
            System.out.println(" Sock:"+ e.getMessage());
        }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
        }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());}
    }
}