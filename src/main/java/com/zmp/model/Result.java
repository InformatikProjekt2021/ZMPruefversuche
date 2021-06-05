package com.zmp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name="result")
public class Result  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "resultId")
    private List<PartResult> partResultId;
}
