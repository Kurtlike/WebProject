package com.kurtlike.webserv.MathLab5;

import com.kurtlike.webserv.MathLab5.pojo.Dot;
import com.kurtlike.webserv.MathLab5.pojo.Dots;
import com.kurtlike.webserv.MathLab5.pojo.XValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BadNewIO implements GoodOldIO {
    ArrayList<Dot> inDots;
    ArrayList<Dot> outDots;
    Dots packDots= new Dots();
    Solver solver= new Solver();
    String methodName;
    @Override
    public void setDotsForInterpolate(ArrayList<Dot> dots) {
        Collections.sort(dots, (o1, o2) -> {
            if (o1.x > o2.x) {
                return 1;
            } else {
                return -1;
            }
        });
        this.inDots=dots;
    }
    @Override
    public void setMethodName(String methodName) {
        System.out.println(methodName);
        this.methodName=methodName;
    }

    @Override
    public XValue getXValue(XValue xValue) {
        XValue yValue = new XValue();
        switch (methodName){
            case "Полином Лагранжа":
                yValue.xValue= solver.lagrange(xValue.xValue,inDots);
                break;
            case "Полином Ньютона":
                yValue.xValue= solver.newtone(xValue.xValue,inDots);
                break;
        }
        yValue.xValue= solver.lagrange(xValue.xValue,inDots);
        return yValue;
    }

    @Override
    public Dots getDotsForDraw() {
        packDots.setDots(outDots);
        return packDots;
    }

    @Override
    public boolean solve() {
        outDots=solver.solve(inDots, methodName);
        return false;
    }
}
