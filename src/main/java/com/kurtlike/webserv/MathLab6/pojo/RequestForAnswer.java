package com.kurtlike.webserv.MathLab6.pojo;

public class RequestForAnswer {
    private int selectedFunction;
    private double leftBorder;
    private double rightBorder;
    private double yNull;
    private double step;

    public int getSelectedFunction() {
        return selectedFunction;
    }

    public void setSelectedFunction(int selectedFunction) {
        this.selectedFunction = selectedFunction;
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

    public double getYNull() {
        return yNull;
    }

    public void setYNull(double yNull) {
        this.yNull = yNull;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
