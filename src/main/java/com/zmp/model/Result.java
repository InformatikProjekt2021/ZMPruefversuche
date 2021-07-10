package com.zmp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="result")
public class Result  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "resultId", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<PartResult> partResultId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PartResult> getPartResultId() {
        return partResultId;
    }

    public void setPartResultId(List<PartResult> partResultId) {
        this.partResultId = partResultId;
    }
}
