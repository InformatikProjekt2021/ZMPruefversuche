package com.zmp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="experiment")
public class Experiment {

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
}
