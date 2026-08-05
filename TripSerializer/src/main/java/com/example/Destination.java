package com.example;

import java.io.Serializable;

public class Destination implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String from;
    private final String to;

    public Destination(String from, String to) {
        this.from = from;
        this.to = to;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
