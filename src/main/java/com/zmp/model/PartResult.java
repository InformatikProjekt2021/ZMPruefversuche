package com.zmp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="part_result")
public class PartResult implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double time;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id")
    private Result resultId;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "experiment_id")
    private Experiment experimentId;

    @Column
    private double position;

    @Column(name = "fine_stretching")
    private double fineStretching;

    @Column
    private double renewal;

    @Column(name = "travers_path")
    private double traversPath;

    @Column(name = "applied_Force")
    private double appliedForce;

    public PartResult(){};

    public PartResult(double time, Result resultId, Experiment experimentId,
                      double position, double fineStretching, double renewal, double traversPath, double appliedForce) {

        this.time = time;
        this.resultId = resultId;
        this.experimentId = experimentId;
        this.position = position;
        this.fineStretching = fineStretching;
        this.renewal = renewal;
        this.traversPath = traversPath;
        this.appliedForce = appliedForce;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Result getResultId() {
        return resultId;
    }

    public void setResultId(Result resultId) {
        this.resultId = resultId;
    }

    public Experiment getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Experiment experimentId) {
        this.experimentId = experimentId;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public double getFineStretching() {
        return fineStretching;
    }

    public void setFineStretching(double fineStretching) {
        this.fineStretching = fineStretching;
    }

    public double getRenewal() {
        return renewal;
    }

    public void setRenewal(double renewal) {
        this.renewal = renewal;
    }

    public double getTraversPath() {
        return traversPath;
    }

    public void setTraversPath(double traversPath) {
        this.traversPath = traversPath;
    }

    public double getAppliedForce() {
        return appliedForce;
    }

    public void setAppliedForce(double appliedForce) {
        this.appliedForce = appliedForce;
    }
    @Override
    public String toString() {
        return "PartResult{" +
                "id=" + id +
                ", time=" + time +
                ", resultId=" + resultId +
                ", experimentId=" + experimentId +
                ", position=" + position +
                ", fineStretching=" + fineStretching +
                ", renewal=" + renewal +
                ", traversPath=" + traversPath +
                ", appliedForce=" + appliedForce +
                '}';
    }
}
