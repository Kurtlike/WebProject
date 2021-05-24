package com.kurtlike.webserv.MathLab3.methods;

public class CenterRectangles extends Rectangles implements Method {

    @Override
    public double getCurrentRectangleValue(double x, double dx) {
        return function.fun((2*x+dx)/2)*dx;
    }
}
