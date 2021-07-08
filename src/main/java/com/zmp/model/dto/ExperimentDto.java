package com.zmp.model.dto;

public class ExperimentDto {
    private String testspeed;
    private String yAxisForce;
    private String height;
    private String width;

    public String getTestspeed() {
        return testspeed;
    }

    public void setTestspeed(String testspeed) {
        this.testspeed = testspeed;
    }

    public String getyAxisForce() {
        return yAxisForce;
    }

    public void setyAxisForce(String yAxisForce) {
        this.yAxisForce = yAxisForce;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}
