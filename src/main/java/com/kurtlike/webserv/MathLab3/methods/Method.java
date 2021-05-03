package com.kurtlike.webserv.MathLab3.methods;

import com.kurtlike.webserv.MathLab3.functions.Function;

public interface Method {
    public void resolve();
    public void setFunction(Function f);
    public double solve(double left, double right, int counter);
    public void setBorders(double left, double right);
    public void setAccuracy(double accuracy);
    public double getAccuracy();
    public void setStartingNumberOfIterations(int n);
    public double getAnswer();
    public int getNumberOfDivisions();
}
