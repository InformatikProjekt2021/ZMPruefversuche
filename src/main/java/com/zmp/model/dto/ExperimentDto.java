package com.zmp.model.dto;

public class ExperimentDto {
    private double testSpeed;
    private double yAxisForce;
    private double height;
    private double width;
    private Long Id;
    private String date;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTestSpeed() {
        return testSpeed;
    }

    public void setTestSpeed(double testSpeed) {
        this.testSpeed = testSpeed;
    }

    public double getyAxisForce() {
        return yAxisForce;
    }

    public void setyAxisForce(double yAxisForce) {
        this.yAxisForce = yAxisForce;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
