package com.kurtlike.webserv.MathLab3.methods;

public abstract class AbstractMethod implements Method{
    int counter;
    double answer, accuracy, finalAccuracy, leftBorder, rightBorder;

    @Override
    public double getAccuracy() {
        return finalAccuracy;
    }

    @Override
    public void setBorders(double left, double right) {
        leftBorder=left;
        rightBorder=right;
    }

    @Override
    public void setAccuracy(double accuracy) {
        this.accuracy=accuracy;
    }

    @Override
    public void setStartingNumberOfIterations(int n) {
        counter=n;
    }

    @Override
    public double getAnswer() {
        return answer;
    }

    @Override
    public double getNumberOfDivisions() {
        return counter;
    }
}
