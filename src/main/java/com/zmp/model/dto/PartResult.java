package com.zmp.model.dto;

import javax.persistence.*;

@Entity
@Table(name="part_result")
public class PartResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String time;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private Result resultId;

    @ManyToOne
    @JoinColumn(name = "experiment_id")
    private Experiment experimentId;

    @Column
    private float position;

    @Column(name = "fine_stretching")
    private float fineStretching;

    @Column
    private float renewal;

    @Column(name = "travers_path")
    private float traversPath;

    @Column(name = "applied_Force")
    private float appliedForce;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public float getFineStretching() {
        return fineStretching;
    }

    public void setFineStretching(float fineStretching) {
        this.fineStretching = fineStretching;
    }

    public float getRenewal() {
        return renewal;
    }

    public void setRenewal(float renewal) {
        this.renewal = renewal;
    }

    public float getTraversPath() {
        return traversPath;
    }

    public void setTraversPath(float traversPath) {
        this.traversPath = traversPath;
    }

    public float getAppliedForce() {
        return appliedForce;
    }

    public void setAppliedForce(float appliedForce) {
        this.appliedForce = appliedForce;
    }
}
