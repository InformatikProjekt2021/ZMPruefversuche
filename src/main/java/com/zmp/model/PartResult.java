package com.zmp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
}
