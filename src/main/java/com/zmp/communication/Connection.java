package com.zmp.communication;

import com.zmp.model.PartResult;
import com.zmp.model.Result;
import com.zmp.repositories.ResultRepository;
import com.zmp.services.PartResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Connection extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;
    private static List<String> messages;

    @Autowired
    private PartResultService partResultService;
    private ResultRepository resultRepository;

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

    public PartResult readStream(){
        PartResult partResult = null;
        Result result = null;
        try {
            while(true) {
                String data = in.readUTF();
                data = data.replaceAll(",",".");
                System.out.println(data);
                String[] params = data.split(";");

                double[] converted = new double[6];
                for(int i = 0; i<params.length;i++){
                    try{
                        converted[i] = Double.parseDouble(params[i]);
                        System.out.println(converted[i]);
                    }catch (Exception e){
                        System.out.println(" Parsing failed:"+ e.getMessage());
                    }
                }
                System.out.println("All parsed");
                result = new Result();
                System.out.println("Result created");
                partResult = new PartResult(converted[0],result,ConnectionHandler.getExperiment(),converted[4],
                        converted[5],converted[3],converted[2],converted[1]);
                System.out.println("Partresult created");
                System.out.println(partResult.toString());

            }
        } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
        } catch( NullPointerException e) {System.out.println("End of message");
        } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}

        return partResult;
    }

    public Connection (Socket aClientSocket) {
        try {
            messages = new ArrayList<>();
            this.clientSocket = aClientSocket;
            in = new DataInputStream ( clientSocket.getInputStream());
            out = new DataOutputStream (clientSocket.getOutputStream());
            this.start();
        } catch( IOException e) {System. out. println(" Connection:"+ e.getMessage());}
    }

    public void run(){
    }
}