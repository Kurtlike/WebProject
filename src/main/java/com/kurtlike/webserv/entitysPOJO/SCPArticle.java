package com.kurtlike.webserv.entitysPOJO;

public class SCPArticle {
    public SCPArticle(String text, String picUrl, String number, String SCPClass) {
        this.text = text;
        this.picUrl = picUrl;
        this.number = number;
        this.SCPClass = SCPClass;
    }

    private String text;
    private String picUrl;
    private String number;
    private String SCPClass;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSCPClass() {
        return SCPClass;
    }

    public void setSCPClass(String SCPClass) {
        this.SCPClass = SCPClass;
    }
}
