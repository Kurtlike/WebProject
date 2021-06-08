package com.kurtlike.webserv.MathLab6.Functions;

public class Function0 implements Function {
    @Override
    public double fun(double x, double y) {
        return x;
    }

    @Override
    public double inFun(double x, double y) {
        return Math.pow(x,2)/2;
    }
}
