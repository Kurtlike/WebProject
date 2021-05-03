package com.kurtlike.webserv.MathLab3;

import com.kurtlike.webserv.MathLab3.functions.*;
import com.kurtlike.webserv.MathLab3.methods.*;

import java.util.ArrayList;


public class BadNewIO implements GoodOldIO {
    public BadNewIO(){
        functions=new ArrayList<>();
        functions.add("1/x");
        functions.add("sin(x)/x");
        functions.add("x^3-3*x^2+6*x-19");
        methods=new ArrayList<>();
        methods.add("Левых прямоугольников");
        methods.add("Правых прямоугольников");
        methods.add("Средних прямоугольников");
        methods.add("Трапеций");
        methods.add("Симпсона");
    }
    ArrayList<String> functions;
    ArrayList<String> methods;
    Function function;
    Method method;

    @Override
    public ArrayList<String> getFunctions() {
        return functions;
    }

    @Override
    public ArrayList<String> getMethods() {
        return methods;
    }

    @Override
    public void setChosenFunction(String function) {
        switch (function) {
            case "1/x":
                this.function = new Function1();
                break;
            case "sin(x)/x":
                this.function = new Function2();
                break;
            case "x^3-3*x^2+6*x-19":
                this.function = new Function3();
        }
    }

    @Override
    public void setChosenMethod(String method) {
        switch (method){
            case "Левых прямоугольников":
                this.method= new LeftRectangles();
                break;
            case "Правых прямоугольников":
                this.method= new RightRectangles();
                break;
            case "Средних прямоугольников":
                this.method= new CenterRectangles();
                break;
            case "Трапеций":
                this.method= new Trapezoid();
                break;
            case "Симпсона":
                this.method= new Simpson();
                break;
        }
    }

    @Override
    public void setBorders(double left, double right) {
        method.setBorders(left, right);
    }

    @Override
    public void setAccuracy(double accuracy) {
        method.setAccuracy(accuracy);
    }

    @Override
    public void setStartingNumberOfIterations(int n) {
        method.setStartingNumberOfIterations(n);
    }

    @Override
    public double getAnswer() {
        method.setFunction(function);
        method.resolve();
        return method.getAnswer();
    }

    @Override
    public int getNumberOfDivisions() {
        return method.getNumberOfDivisions();
    }

    @Override
    public double getAccuracy() {
        return method.getAccuracy();
    }
}
