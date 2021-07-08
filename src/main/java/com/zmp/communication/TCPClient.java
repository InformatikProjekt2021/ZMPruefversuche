package com.zmp.communication;

import java.net.*;
import java.io.*;
public class TCPClient {

        private static String[] DataHeaders = {"Zeit_s","Kraft_N","Traversenweg_mm","Verlängerung_mm","Position_mm","Feindehnung_mm"};

    public static void main (String args[]) {
        try{
            int serverPort = 8081;
            Socket s = new Socket ("127.0.0.1", serverPort);
            DataOutputStream out = new DataOutputStream (s.getOutputStream());
            DataInputStream in = new DataInputStream (s.getInputStream());
            for(String str : DataHeaders){
                out.writeUTF (str);
                System.out.println("client Writing");
            }
            s.close();
        }catch (UnknownHostException e){
            System.out.println(" Sock:"+ e.getMessage());
        }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
        }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());}
    }
}