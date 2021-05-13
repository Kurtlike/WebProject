package com.kurtlike.webserv.MathLab3.functions;

import static java.lang.Math.pow;

public class Function3 implements Function {
    @Override
    public double fun(double x) {
        return pow(x,3)-3*pow(x,2)+6*x-19;
    }
}
