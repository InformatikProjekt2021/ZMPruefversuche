package com.zmp.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class TCPClient {

        private static String[] DataHeaders = {"Zeit_s","Kraft_N","Traversenweg_mm","Verlängerung_mm","Position_mm","Feindehnung_mm"};

        private static void read (DataInputStream inputStream) throws IOException {
            try {
                while (true) {
                    String data = inputStream.readUTF();
                    System.out.println("Client received: " + data);
                }
            } catch (UnknownHostException e) {
                System.out.println(" Sock:" + e.getMessage());
            } catch (EOFException e) {
                System.out.println(" EOF:" + e.getMessage());
            }
        }

    public static void main (String args[]) {
        try{
            int serverPort = 8081;
            Socket s = new Socket ("127.0.0.1", serverPort);
            DataOutputStream out = new DataOutputStream (s.getOutputStream());
            DataInputStream in = new DataInputStream (s.getInputStream());

            for(String str : DataHeaders){
                out.writeUTF (str);
            }
            read(in);
            s.close();
        }catch (UnknownHostException e){
            System.out.println(" Sock:"+ e.getMessage());
        }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
        }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());}
    }
}