package com.post.domain.entities.enums;

public enum ParcelState {
    DECORATED("��������"),
    SENT_TO_DEPARTMENT("��������� � �����"),
    SENT_FROM_DEPARTMENT("��������� �������"),
    DELIVERED("���������"),
    RECEIVED("�������");

    private final String value;

    private ParcelState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}