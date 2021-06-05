package com.zmp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String roleName;

}
