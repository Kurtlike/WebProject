package com.kurtlike.webserv.MathLab6.Functions;

public class Function1 implements Function {
    @Override
    public double fun(double x, double y) {
        return x*y;
    }

    @Override
    public double inFun(double x, double y) {
        return Math.exp(x*x/2);
    }
}