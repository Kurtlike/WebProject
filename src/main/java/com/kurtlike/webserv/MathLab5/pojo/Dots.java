package com.kurtlike.webserv.MathLab5.pojo;

import java.util.ArrayList;

public class Dots {

    private String methodName;
    private ArrayList<Dot> Dots;

    public ArrayList<Dot> getDots() {
        return Dots;
    }

    public void setDots(ArrayList<Dot> dots) {
        Dots = dots;
    }
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

}
