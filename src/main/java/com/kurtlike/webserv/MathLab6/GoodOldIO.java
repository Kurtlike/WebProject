package com.kurtlike.webserv.MathLab6;


import com.kurtlike.webserv.MathLab6.pojo.Answer;

import java.util.ArrayList;
import java.util.HashMap;

public interface GoodOldIO {
    public HashMap<Integer,String> getFunctions();
    public void setChosenFunction(int function);
    public void setInterval(double left, double right);
    public void setAccuracy(double accuracy);
    public void setStep(double step);
    public Answer getAnswer();

}
