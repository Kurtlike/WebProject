package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.Dot;

import java.util.ArrayList;

public class Quadratic {

    double a, b, c;
    boolean comp;
    public void solve(ArrayList<Dot> list){
        comp=true;
        double sx=0, sxx=0, sy=0, sxy=0, sxxx=0, sxxxx=0, sxxy=0;
        int n=list.size();
        for(Dot dot : list){
            sx+=dot.x;
            sxx+=dot.x*dot.x;
            sxxx+=dot.x*dot.x*dot.x;
            sxxxx+=dot.x*dot.x*dot.x*dot.x;
            sy+=dot.y;
            sxy+=dot.x*dot.y;
            sxxy+=dot.x*dot.x*dot.y;
        }
        double d=n*(sxx*sxxxx-sxxx*sxxx)-sx*(sx*sxxxx-sxx*sxxx)+sxx*(sx*sxxx-sxx*sxx);
        double d1=sy*(sxx*sxxxx-sxxx*sxxx)-sx*(sxy*sxxxx-sxxy*sxxx)+sxx*(sxy*sxxx-sxxy*sxx);
        double d2=n*(sxy*sxxxx-sxxy*sxxx)-sy*(sx*sxxxx-sxx*sxxx)+sxx*(sx*sxxy-sxx*sxy);
        double d3=n*(sxx*sxxy-sxxx*sxy)-sx*(sx*sxxy-sxx*sxy)+sy*(sx*sxxx-sxx*sxx);
        if(d==0){
            comp=false;
        }
        else {
            a = d1 / d;
            b = d2 / d;
            c = d3 / d;
        }
    }
}
