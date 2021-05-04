package com.kurtlike.webserv.MathLab3;

import java.util.ArrayList;

public class Test implements GoodOldIO {

    @Override
    public ArrayList<String> getFunctions() {
        ArrayList<String> f = new ArrayList<>();
        f.add("a+b*c");
        f.add("a+b*c-1");
        f.add("a+b*c-1");
        f.add("a+b*c-2");
        return f;
    }

    @Override
    public ArrayList<String> getMethods() {
        ArrayList<String> m = new ArrayList<>();
        m.add("Ma+b*c");
        m.add("Mm+b*c-1");
        m.add("Ma+b*c-1");
        m.add("Ma+b*c-2");
        return m;
    }

    @Override
    public void setChosenFunction(String function) {

    }

    @Override
    public void setChosenMethod(String method) {

    }

    @Override
    public void setBorders(double left, double right) {

    }

    @Override
    public void setAccuracy(double accuracy) {

    }

    @Override
    public void setStartingNumberOfIterations(int n) {

    }

    @Override
    public double getAnswer() {
        return 2;
    }

    @Override
    public int getNumberOfDivisions() {
        return 3;
    }
}
