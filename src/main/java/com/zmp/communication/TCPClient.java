package com.zmp.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

    private static final String ResultData = "0,200000;8,157118;0,014524;0,014524;13,530519;0,000000";

        private static void read (DataInputStream inputStream) throws IOException {
            int i=0;
            try {
                while (true) {
                    double data = inputStream.readDouble();
                    if(i == 3){
                        break;
                    }
                    System.out.println("Client received: " + data);
                    i++;
                }
            } catch (UnknownHostException e) {
                System.out.println(" Sock:" + e.getMessage());
            } catch (EOFException e) {
                System.out.println(" EOF:" + e.getMessage());
            }
        }

    private static void write (DataOutputStream dataOutputStream) throws IOException {
        try {
            dataOutputStream.writeUTF(ResultData);
            System.out.println("Client sends: " + ResultData);
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
            read(in);
            System.out.println("writing..");
            write(out);
            s.close();
        }catch (UnknownHostException e){
            System.out.println(" Sock:"+ e.getMessage());
        }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
        }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());}
    }
}