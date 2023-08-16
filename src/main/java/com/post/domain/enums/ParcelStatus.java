package com.post.domain.enums;

public enum ParcelStatus {
    DECORATED("Decorated"),
    SENT_TO_DEPARTMENT("Sent to department"),
    SENT_FROM_DEPARTMENT("Sent to client"),
    DELIVERED("Delivered"),
    RECEIVED("Received");

    private final String value;

    private ParcelStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}