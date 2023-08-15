package com.post.domain.entities.enums;

public enum ParcelState {
    DECORATED("Оформлен"),
    SENT_TO_DEPARTMENT("Отправлен в отдел"),
    SENT_FROM_DEPARTMENT("Отправлен клиенту"),
    DELIVERED("Доставлен"),
    RECEIVED("Получен");

    private final String value;

    private ParcelState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}