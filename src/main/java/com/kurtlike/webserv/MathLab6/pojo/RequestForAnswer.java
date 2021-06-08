package com.kurtlike.webserv.MathLab6.pojo;

public class RequestForAnswer {
    private int selectedFunction;
    private double leftBorder;
    private double rightBorder;
    private double Y0;
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

    public double getY0() {
        return Y0;
    }

    public void setY0(double Y0) {
        this.Y0 = Y0;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
