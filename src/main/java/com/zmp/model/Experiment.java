package com.zmp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="experiment")
public class Experiment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "experimentId", cascade = CascadeType.MERGE, orphanRemoval=true)
    private List<PartResult> partResult;

    @Column
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "test_speed")
    private double testSpeed;

    @Column
    private double height;

    @Column
    private double width;

    @Column(name = "x_axis_time")
    private double xAxisTime;

    @Column(name = "y_axis_force")
    private double yAxisForce;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PartResult> getPartResult() {
        return partResult;
    }

    public void setPartResult(List<PartResult> partResult) {
        this.partResult = partResult;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public double getTestSpeed() {
        return testSpeed;
    }

    public void setTestSpeed(double testSpeed) {
        this.testSpeed = testSpeed;
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

    public double getxAxisTime() {
        return xAxisTime;
    }

    public void setxAxisTime(double xAxisTime) {
        this.xAxisTime = xAxisTime;
    }

    public double getyAxisForce() {
        return yAxisForce;
    }

    public void setyAxisForce(double yAxisForce) {
        this.yAxisForce = yAxisForce;
    }
}
