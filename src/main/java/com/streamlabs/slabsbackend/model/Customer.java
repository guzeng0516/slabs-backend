package com.streamlabs.slabsbackend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customer")
public class Customer implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "twitch_id_token")
    private String twitchIdToken;

    @Column(name = "streamer_name")
    private String streamerName;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getStreamerName() {
        return streamerName;
    }

    public void setStreamerName(String streamerName) {
        this.streamerName = streamerName;
    }
}