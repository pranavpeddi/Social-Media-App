package com.Pranav.SocialMediaApp.Domain;


import javax.persistence.*;

@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long FID;

    private String name;

    @ManyToOne
    private User user;


    public long getFID() {
        return FID;
    }

    public void setFID(long FID) {
        this.FID = FID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
