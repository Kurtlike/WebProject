package com.kurtlike.webserv.entitysPOJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "scp", name = "anomalies")
public class Anomaly {
    @Id
    private String name;
    @Column(name = "danger_class")
    private String dangerClass;
    @Column(name = "containment_zone")
    private String containment_zone;
    @Column(name = "intelligence")
    private boolean intelligence;
    @Column (name = "status")
    private String status;
    @Column (name = "pic_url")
    private String picUrl;
    @Column (name = "text")
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDangerClass() {
        return dangerClass;
    }

    public void setDangerClass(String dangerClass) {
        this.dangerClass = dangerClass;
    }

    public String getContainment_zone() {
        return containment_zone;
    }

    public void setContainment_zone(String containment_zone) {
        this.containment_zone = containment_zone;
    }

    public boolean isIntelligence() {
        return intelligence;
    }

    public void setIntelligence(boolean intelligence) {
        this.intelligence = intelligence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Anomaly{" +
                "name='" + name + '\'' +
                ", dangerClass=" + dangerClass +
                ", containment_zone='" + containment_zone + '\'' +
                ", intelligence=" + intelligence +
                ", status='" + status + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

