package com.kurtlike.webserv.MathLab4.pojo;

import java.util.ArrayList;

public class Answer {
    private int numberOfBestFunction;
    private String bestMethodName;
    private double PierceKoef;
    private ArrayList<FunctionObject> functionObjects;

    public ArrayList<FunctionObject> getFunctionObjects() {
        return functionObjects;
    }

    public void setFunctionObjects(ArrayList<FunctionObject> functionObjects) {
        this.functionObjects = functionObjects;
    }

    public int getNumberOfBestFunction() {
        return numberOfBestFunction;
    }

    public void setNumberOfBestFunction(int numberOfBestFunction) {
        this.numberOfBestFunction = numberOfBestFunction;
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
