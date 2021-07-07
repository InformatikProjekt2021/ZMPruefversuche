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

    @OneToMany(mappedBy = "experimentId")
    private List<PartResult> partResult;

    @Column
    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "test_speed")
    private float testSpeed;

    @Column
    private float height;

    @Column
    private float width;

    @Column(name = "x_axis_time")
    private float xAxisTime;

    @Column(name = "y_axis_force")
    private float yAxisForce;

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

    public float getTestSpeed() {
        return testSpeed;
    }

    public void setTestSpeed(float testSpeed) {
        this.testSpeed = testSpeed;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getxAxisTime() {
        return xAxisTime;
    }

    public void setxAxisTime(float xAxisTime) {
        this.xAxisTime = xAxisTime;
    }

    public float getyAxisForce() {
        return yAxisForce;
    }

    public void setyAxisForce(float yAxisForce) {
        this.yAxisForce = yAxisForce;
    }
}
