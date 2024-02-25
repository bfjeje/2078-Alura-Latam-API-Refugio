package com.alura.apirefugio.helper;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong refugioCounter = new AtomicLong();
    private static final AtomicLong petCounter = new AtomicLong();

    public static Long generateRefugioId() {
        return refugioCounter.incrementAndGet();
    }

    public static Long generatePetId() {
        return petCounter.incrementAndGet();
    }
}
