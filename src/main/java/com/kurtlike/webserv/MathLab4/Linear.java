package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.Dot;

import java.util.ArrayList;

public class Linear {
    double a=0, b=0;
    boolean comp;
    public void solve(ArrayList<Dot> list){
        comp=true;
        double sx=0, sxx=0, sy=0, sxy=0;
        int n=list.size();
        for(Dot dot : list){
            sx+=dot.x;
            sxx+=dot.x*dot.x;
            sy+=dot.y;
            sxy+=dot.x*dot.y;
        }
        double d=(sxx*n-sx*sx);
        if(d!=0) {
            a = (sxy * n - sx * sy) / d;
            b = (sxx * sy - sx * sxy) / d;
        }
        else{
            comp=false;
        }
    }
}
