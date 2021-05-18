package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.Dot;
import com.kurtlike.webserv.MathLab4.pojo.FunctionObject;

import java.util.ArrayList;

public interface GoodOldIO {
    public void setDotsForApproximate(ArrayList<Dot> dots);
    public ArrayList<FunctionObject> getFunctionObjects();
    public int getNumberOfBestFunction();
    public String getBestMethodName();
    public double getPierceKoef();
    public boolean solve();
}