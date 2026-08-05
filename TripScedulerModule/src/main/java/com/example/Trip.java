package com.example;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public record Trip(
        String id,
        String destination,
        int participantsCount,
        long timestamp,
        byte[] payload
) {
    public Trip(String destination) {
        this(
                UUID.randomUUID().toString(),
                destination,
                ThreadLocalRandom.current().nextInt(1, 50),
                System.currentTimeMillis(),
                new byte[10 * 1024]
        );
    }
}