package com.zmp.communication;

import com.zmp.model.Experiment;
import com.zmp.model.PartResult;

import java.net.Socket;
import java.util.List;

/**
 * class that holds all necessary data for successfully starting a new Experiment
 * and receiving results
 */
public class ConnectionHandler {

    private static Connection connection;

    private static List<PartResult> results;

    private static Experiment experiment;

    private static Socket clientSocket;

    private static int port = 8081;

    public static List<PartResult> getResults() {
        return results;
    }

    public static void setResults(List<PartResult> results) {
        ConnectionHandler.results = results;
    }

    public static Socket getClientSocket() {
        return clientSocket;
    }

    public static void setClientSocket(Socket clientSocket) {
        ConnectionHandler.clientSocket = clientSocket;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        ConnectionHandler.port = port;
    }

    public static Experiment getExperiment() {
        return experiment;
    }

    public static void setExperiment(Experiment experiment) {
        ConnectionHandler.experiment = experiment;
    }

    public static Connection getConnection() {
        return connection;
    }
    public static void setConnection(Connection connection) {
        ConnectionHandler.connection = connection;
    }
}
