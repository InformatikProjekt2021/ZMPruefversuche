package com.zmp.communication;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * simulates the tcp client that sends the experiment results as a file
 */
public class TCPClient {
    private DataInputStream input;

    private DataOutputStream output;

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
                file = new File("C:\\Users\\Samer\\Desktop\\sentFileClient.txt");
            }else{
                file = new File("/../FileToSend.txt");
            }

            read(in);
            System.out.println("writing..");
            client.sendFile(file,out);
            s.close();
        }catch (UnknownHostException e){
            System.out.println(" Sock:"+ e.getMessage());
        }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
        }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());}
    }
}