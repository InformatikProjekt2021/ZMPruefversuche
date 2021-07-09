package com.zmp.communication;

import com.zmp.model.PartResult;
import com.zmp.model.Result;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class Connection extends Thread {

    private DataInputStream in;
    private DataOutputStream out;

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
                System.out.println("server receives: "+data);
                String[] params = data.split(";");

                double[] converted = new double[6];
                for(int i = 0; i<params.length;i++){
                    try{
                        converted[i] = Double.parseDouble(params[i]);
                    }catch (Exception e){
                        System.out.println(" Parsing failed:"+ e.getMessage());
                    }
                }
                result = new Result();

                partResult = new PartResult(converted[0],result,ConnectionHandler.getExperiment(),converted[4],
                        converted[5],converted[3],converted[2],converted[1]);

            }
        } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
        } catch( NullPointerException e) {System.out.println("End of message");
        } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}
        return partResult;
    }

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