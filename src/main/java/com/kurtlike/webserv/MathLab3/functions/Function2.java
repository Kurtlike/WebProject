package com.kurtlike.webserv.MathLab3.functions;


import static java.lang.Math.log;
import static java.lang.Math.sin;

public class Function2 implements Function {
    @Override
    public double fun(double x) {
        return sin(x)/x;
    }
}
