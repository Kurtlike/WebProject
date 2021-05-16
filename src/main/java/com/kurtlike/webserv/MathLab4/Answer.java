package com.kurtlike.webserv.MathLab4;

public class Answer {
    private String bestFunction;
    private String bestMethodName;
    private double PierceKoef;

    public String getBestFunction() {
        return bestFunction;
    }

    public void setBestFunction(String bestFunction) {
        this.bestFunction = bestFunction;
    }

    public String getBestMethodName() {
        return bestMethodName;
    }

    public void setBestMethodName(String bestMethodName) {
        this.bestMethodName = bestMethodName;
    }

    public double getPierceKoef() {
        return PierceKoef;
    }

    public void setPierceKoef(double pierceKoef) {
        PierceKoef = pierceKoef;
    }
}
