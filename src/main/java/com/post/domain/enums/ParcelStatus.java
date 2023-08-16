package com.post.domain.enums;

public enum ParcelStatus {
    DECORATED("Оформлен"),
    SENT_TO_DEPARTMENT("Отправлен в отдел"),
    SENT_FROM_DEPARTMENT("Отправлен клиенту"),
    DELIVERED("Доставлен"),
    RECEIVED("Получен");

    private final String value;

    private ParcelStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}