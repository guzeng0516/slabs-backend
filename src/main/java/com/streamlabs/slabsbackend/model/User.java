package com.streamlabs.slabsbackend.model;

import javax.persistence.*;

@Entity
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_name")
    private String user_name;
}