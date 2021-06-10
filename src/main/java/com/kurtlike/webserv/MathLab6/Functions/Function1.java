package com.kurtlike.webserv.MathLab6.Functions;

public class Function1 implements Function {
    @Override
    public double fun(double x, double y) {
        return x+x*x;
    }

    @Override
    public double inFun(double x, double y) {
        return Math.pow(x,3)/3+x*x/2;
    }
}