package com.kurtlike.webserv.MathLab3.methods;

public interface Method {
    public void solve();
    public void setBorders(double left, double right);
    public void setAccuracy(double accuracy);
    public double getAccuracy();
    public void setStartingNumberOfIterations(int n);
    public double getAnswer();
    public int getNumberOfDivisions();
}
