package com.kurtlike.webserv.MathLab3.methods;

import com.kurtlike.webserv.MathLab3.functions.Function;

public abstract class AbstractMethod implements Method{

    Function function;
    int counter;
    boolean isEnd=false;
    double answer, panswer, accuracy, finalAccuracy, leftBorder, rightBorder;

    @Override
    public void setFunction(Function f){
     this.function=f;
    }
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
    public int getNumberOfDivisions() {
        return counter;
    }
}
