package com.kurtlike.webserv.MathLab5;

import com.kurtlike.webserv.MathLab5.GoodOldIO;
import com.kurtlike.webserv.MathLab5.pojo.Dot;
import com.kurtlike.webserv.MathLab5.pojo.Dots;
import com.kurtlike.webserv.MathLab5.pojo.XValue;


import java.util.ArrayList;

public class Test implements GoodOldIO {
   Dots dots = new Dots();

    @Override
    public void setDotsForInterpolate(ArrayList<Dot> dots) {
        this.dots.setDots(dots);
    }

    @Override
    public XValue getXValue(XValue xValue) {
        xValue.xValue++;
        return xValue;
    }

    @Override
    public Dots getDotsForDraw() {
        dots.getDots().forEach(dot ->{
            dot.x++;
            dot.y++;
        });
        return dots;
    }

    @Override
    public boolean solve() {
        return true;
    }
}
