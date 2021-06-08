package com.kurtlike.webserv.MathLab6.Functions;

public class Function2 implements Function {

    @Override
    public double fun(double x, double y) {
        return y+1;
    }

    @Override
    public double inFun(double x, double y) {
        return Math.exp(x)-1;
    }
}
