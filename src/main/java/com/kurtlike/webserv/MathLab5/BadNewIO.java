package com.kurtlike.webserv.MathLab5;

import com.kurtlike.webserv.MathLab5.pojo.Dot;
import com.kurtlike.webserv.MathLab5.pojo.Dots;
import com.kurtlike.webserv.MathLab5.pojo.XValue;

import java.util.ArrayList;

public class BadNewIO implements GoodOldIO {
    ArrayList<Dot> inDots;
    ArrayList<Dot> outDots;
    Dots packDots= new Dots();
    Solver solver= new Solver();

    @Override
    public void setDotsForInterpolate(ArrayList<Dot> dots) {
        this.inDots=dots;
    }

    @Override
    public XValue getXValue(XValue xValue) {
        XValue yValue = new XValue();
        yValue.xValue= solver.newtone(xValue.xValue,inDots);
        return yValue;
    }

    @Override
    public Dots getDotsForDraw() {
        packDots.setDots(outDots);
        return packDots;
    }

    @Override
    public boolean solve() {
        outDots=solver.solve(inDots);
        return false;
    }
}
