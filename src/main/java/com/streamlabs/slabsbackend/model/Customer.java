package com.streamlabs.slabsbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "twitch_id_token")
    private String twitchIdToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setTwitchIdToken(String twitchIdToken) {
        this.twitchIdToken = twitchIdToken;
    }

    public String getTwitchIdToken() {
        return twitchIdToken;
    }
}