package com.example;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<User> users;
    private final Destination destination;

    @JsonIgnore
    private final LocalDateTime createdAt;

    @JsonIgnore
    private final String description;


    public Trip(List<User> users, Destination destination) {
        this.users = users;
        this.destination = destination;
        this.createdAt = LocalDateTime.now();
        this.description = null;
    }

    public List<User> getUsers() {
        return users;
    }

    public Destination getDestination() {
        return destination;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }
}
