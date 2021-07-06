package com.zmp.model.dto;

public class ExperimentData {
    private String Zeit_s;
    private String Kraft_N;
    private String Traversenweg_mm;
    private String Verlaengerung_mm;
    private String Position_mm;
    private String Feindehnung_mm;

    @Override
    public String toString() {
        return "ExperimentData{" +
                "Zeit_s='" + Zeit_s + '\'' +
                ", Kraft_N='" + Kraft_N + '\'' +
                ", Traversenweg_mm='" + Traversenweg_mm + '\'' +
                ", Verlaengerung_mm='" + Verlaengerung_mm + '\'' +
                ", Position_mm='" + Position_mm + '\'' +
                ", Feindehnung_mm='" + Feindehnung_mm + '\'' +
                '}';
    }

    public ExperimentData(String zeit_s, String kraft_N, String traversenweg_mm, String verlaengerung_mm,
                          String position_mm, String feindehnung_mm) {
        Zeit_s = zeit_s;
        Kraft_N = kraft_N;
        Traversenweg_mm = traversenweg_mm;
        Verlaengerung_mm = verlaengerung_mm;
        Position_mm = position_mm;
        Feindehnung_mm = feindehnung_mm;
    }

    public String getZeit_s() {
        return Zeit_s;
    }

    public void setZeit_s(String zeit_s) {
        Zeit_s = zeit_s;
    }

    public String getKraft_N() {
        return Kraft_N;
    }

    public void setKraft_N(String kraft_N) {
        Kraft_N = kraft_N;
    }

    public String getTraversenweg_mm() {
        return Traversenweg_mm;
    }

    public void setTraversenweg_mm(String traversenweg_mm) {
        Traversenweg_mm = traversenweg_mm;
    }

    public String getVerlaengerung_mm() {
        return Verlaengerung_mm;
    }

    public void setVerlaengerung_mm(String verlaengerung_mm) {
        Verlaengerung_mm = verlaengerung_mm;
    }

    public String getPosition_mm() {
        return Position_mm;
    }

    public void setPosition_mm(String position_mm) {
        Position_mm = position_mm;
    }

    public String getFeindehnung_mm() {
        return Feindehnung_mm;
    }

    public void setFeindehnung_mm(String feindehnung_mm) {
        Feindehnung_mm = feindehnung_mm;
    }
}
