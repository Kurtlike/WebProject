package com.kurtlike.webserv.MathLab3.methods;

public class LeftRectangles extends Rectangles implements Method {
    public double getCurrentRectangleValue(double x, double dx){
        return function.fun(x)*dx;
    }
}
