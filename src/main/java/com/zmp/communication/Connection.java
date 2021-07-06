package com.zmp.communication;

import com.zmp.model.dto.ExperimentData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Connection extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;
    private static List<String> messages;

    public Connection (Socket aClientSocket) {
        try {
            messages = new ArrayList<>();
            this.clientSocket = aClientSocket;
            in = new DataInputStream ( clientSocket.getInputStream());
            this.start();
        } catch( IOException e) {System. out. println(" Connection:"+ e.getMessage());}
    }
    public void run(){
        ExperimentData experimentData = null;
        try {
            while(true) {
                String data = in.readUTF();
                Field[] fields = ExperimentData.class.getFields();
                messages.add(data);
                if(messages.size()==6){
                    experimentData = new ExperimentData(messages.get(0), messages.get(1),messages.get(2),
                            messages.get(3),messages.get(4),messages.get(5));
                }
                System.out.println("Echo: " + data);
            }
        } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
        } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}


        System.out.println("Experiment created: " + experimentData.toString());

    }
}