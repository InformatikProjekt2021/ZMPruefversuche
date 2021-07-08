package com.zmp.communication;

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
    private static final String[] DataHeaders = {"1.00","2.00","3.00","4.00"};

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
        try {
            for (String str : DataHeaders) {
                out.writeUTF(str);
                System.out.println("Server sends: " + str);
            }
        } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
        } catch( NullPointerException e) {System.out.println(" NullPointer:"+ e.getMessage());
        } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}
        //ExperimentData experimentData = null;
        try {
            while(true) {
                String data = in.readUTF();
                System.out.println("Server Receives: " + data);
                messages.add(data);
                if(messages.size()==2){
                    //experimentData = new ExperimentData(messages.get(0), messages.get(1),messages.get(2),
                      //      messages.get(3),messages.get(4),messages.get(5));
                    System.out.println("Data to built diagram received: " + messages.get(0) + " " + messages.get(1));
                }

            }
        } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
        } catch( NullPointerException e) {System.out.println(" NullPointer:"+ e.getMessage());
        } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}

    }
}