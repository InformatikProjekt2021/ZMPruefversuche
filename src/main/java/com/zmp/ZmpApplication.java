package com.zmp;

import com.zmp.communication.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
@EnableWebSecurity
public class ZmpApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZmpApplication.class, args);

        try{
            System.out.println("The server is up");
            int serverPort = 8081;
            ServerSocket listenSocket = new ServerSocket (serverPort);
            while(true) {
                Socket clientSocket = listenSocket.accept();
                System. out.println("Neue Verbindung");
                Connection c = new Connection(clientSocket);
            }
        } catch( IOException e) {System.out.println(" Listen :"+ e.getMessage());}

    }
}
