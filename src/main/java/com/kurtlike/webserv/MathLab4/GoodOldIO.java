package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.FunctionObject;

import java.util.ArrayList;

public interface GoodOldIO {
    public void setDotsForApproximate(double[][] dots);
    public ArrayList<FunctionObject> getFunctionObjects();
    public String getBestFunction();
    public String getBestMethodName();
    public double getPierceKoef();
    public boolean solve();
}