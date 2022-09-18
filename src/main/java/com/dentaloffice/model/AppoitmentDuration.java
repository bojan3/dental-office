package com.dentaloffice.model;

public enum AppoitmentDuration {
    LONG(60),
    SHORT(30);

    private final int duration;

    private AppoitmentDuration(int duration) {
        this.duration = duration;
    }

    public int toInt() {
        return duration;
    }
}
