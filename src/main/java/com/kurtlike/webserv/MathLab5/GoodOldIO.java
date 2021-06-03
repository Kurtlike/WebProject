package com.kurtlike.webserv.MathLab5;



import com.kurtlike.webserv.MathLab5.pojo.Dot;
import com.kurtlike.webserv.MathLab5.pojo.Dots;
import com.kurtlike.webserv.MathLab5.pojo.XValue;

import java.util.ArrayList;

public interface GoodOldIO {
    public void setDotsForInterpolate(ArrayList<Dot> dots);
    public XValue getXValue(XValue xValue);
    public Dots getDotsForDraw();
    public boolean solve();
}