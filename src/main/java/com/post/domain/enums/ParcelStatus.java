package com.post.domain.enums;

public enum ParcelStatus {
    DECORATED("��������"),
    SENT_TO_DEPARTMENT("��������� � �����"),
    SENT_FROM_DEPARTMENT("��������� �������"),
    DELIVERED("���������"),
    RECEIVED("�������");

    private final String value;

    private ParcelStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}