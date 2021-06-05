package com.zmp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "userId")
    private List<Experiment> experiments;

    private long roleId;
}
