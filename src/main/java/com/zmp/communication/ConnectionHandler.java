package com.zmp.communication;

import com.zmp.model.Experiment;

public class ConnectionHandler {

    private static Connection connection;

    private static Experiment experiment;

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
