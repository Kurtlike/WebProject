package com.kurtlike.webserv.MathLab3;

public class RequestForAnswer {
    private String selectedFunction;
    private String selectedMethod;
    private double leftBorder;
    private double rightBorder;
    private double accuracy;
    private int n;

    public String getSelectedFunction() {
        return selectedFunction;
    }

    public void setSelectedFunction(String selectedFunction) {
        this.selectedFunction = selectedFunction;
    }

    public String getSelectedMethod() {
        return selectedMethod;
    }

    public void setSelectedMethod(String selectedMethod) {
        this.selectedMethod = selectedMethod;
    }

    public double getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(double rightBorder) {
        this.rightBorder = rightBorder;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
