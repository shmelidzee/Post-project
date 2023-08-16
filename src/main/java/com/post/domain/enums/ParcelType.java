package com.post.domain.enums;

public enum ParcelType {
    LETTER("Letter"),
    WRAPPER("Wrapper"),
    PACKAGE("Package"),
    POSTCARD("Postcard");

    private final String value;

    private ParcelType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}