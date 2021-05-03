package com.kurtlike.webserv.MathLab3;

import java.util.ArrayList;

public interface GoodOldIO {
    public ArrayList<String> getFunctions();
    public ArrayList<String> getMethods();
    public void setChosenFunction(String function);
    public void setChosenMethod(String method);
    public void setBorders(double left, double right);
    public void setAccuracy(double accuracy);
    public void setStartingNumberOfIterations(int n);
    public double getAnswer();
    public int getNumberOfDivisions();
    public double getAccuracy();
}
