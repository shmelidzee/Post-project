package com.post.domain.enums;

public enum ParcelType {
    LETTER("������"),
    WRAPPER("���������"),
    PACKAGE("�������"),
    POSTCARD("��������");

    private final String value;

    private ParcelType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}