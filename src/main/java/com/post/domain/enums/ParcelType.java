package com.post.domain.enums;

public enum ParcelType {
    LETTER("Письмо"),
    WRAPPER("Бандероль"),
    PACKAGE("Посылка"),
    POSTCARD("Октрытка");

    private final String value;

    private ParcelType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}