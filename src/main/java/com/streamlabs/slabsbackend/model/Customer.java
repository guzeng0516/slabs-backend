package com.streamlabs.slabsbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "firstname")
    private String firstname;

    @Column(name = "twitch_code")
    private String twitchCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setTwitchCode(String twitchCode) {
        this.twitchCode = twitchCode;
    }

    public String getTwitchCode() {
        return twitchCode;
    }
}