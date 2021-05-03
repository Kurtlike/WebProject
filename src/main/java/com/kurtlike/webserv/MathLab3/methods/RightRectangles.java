package com.kurtlike.webserv.MathLab3.methods;

public class RightRectangles extends Rectangles implements Method {

    @Override
    public double getCurrentRectangleValue(double x, double dx) {
        return function.fun(x+dx)*dx;
    }
}
