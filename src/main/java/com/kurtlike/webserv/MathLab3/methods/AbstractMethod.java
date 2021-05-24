package com.kurtlike.webserv.MathLab3.methods;

import com.kurtlike.webserv.MathLab3.functions.Function;

public abstract class AbstractMethod implements Method{

    Function function;
    int counter, innercounter;
    boolean isEnd=false;
    double answer, accuracy, finalAccuracy, leftBorder, rightBorder;

    @Override
    public void resolve(){
        switch(function.getClass().getName()){
            case "com.kurtlike.webserv.MathLab3.functions.Function1":
                if(rightBorder == 0){
                    rightBorder-= accuracy;
                }
                if(leftBorder == 0){
                    leftBorder += accuracy;
                }
                if(rightBorder*leftBorder<0){
                    double fanswer=solve(leftBorder, 0-accuracy, counter/2);
                    answer = fanswer + solve(0+accuracy, rightBorder, counter/2);
                    innercounter*=2;
                }
                else{
                    answer = solve(leftBorder, rightBorder, counter);
                }
                break;
            case "com.kurtlike.webserv.MathLab3.functions.Function2":
                if(rightBorder == 0){
                    rightBorder-= accuracy;
                }
                if(leftBorder == 0){
                    leftBorder += accuracy;
                }
                if(rightBorder*leftBorder<0){
                    double fanswer=solve(leftBorder, 0-accuracy, counter/2);
                    answer = fanswer + solve(0+accuracy, rightBorder, counter/2);
                    innercounter*=2;
                }
                else{
                    answer = solve(leftBorder, rightBorder, counter);
                }
                break;
            case "com.kurtlike.webserv.MathLab3.functions.Function3":
                answer = solve(leftBorder, rightBorder, counter);
        }
    }

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
        return innercounter;
    }
}
