package com.kurtlike.webserv.MathLab6;

import com.kurtlike.webserv.MathLab6.Functions.Function;
import com.kurtlike.webserv.MathLab6.pojo.Dot;
import com.kurtlike.webserv.MathLab6.pojo.MethodAnswer;

import java.util.ArrayList;

public class Solver {
    public MethodAnswer euler(Function func, double a, double b, double y0, double h){
        double n=(b-a)/h;
        MethodAnswer ans = new MethodAnswer();
        ans.setMethodName("Эйлера");
        ArrayList<Dot> dots = new ArrayList<>();
        Dot dot = new Dot(a, y0);
        dots.add(dot);
        double y;
        for(int i=1; i<=n; i++){
            y= dots.get(i-1).y+h*func.fun(dots.get(i-1).x,dots.get(i-1).y);
            dot = new Dot(a+i*h,y);
            dots.add(dot);
        }
        ans.setNumberSolution(dots);
        dots = new ArrayList<>();
        for(int i=0; i<=n;i++){
            dot = new Dot(a+i*h,func.inFun(a+i*h,0));
            dots.add(dot);
        }
        ans.setExactSolution(dots);
        return ans;
    }
    public MethodAnswer adams(Function func, double a, double b, double y0, double h){
        int n = (int) ((b-a)/h);
        MethodAnswer ans = new MethodAnswer();
        ans.setMethodName("Адамса");
        ArrayList<Dot> dots = new ArrayList<>();
        Dot dot = new Dot(a, y0);
        dots.add(dot);
        double k1, k2, k3, k4, y=y0, x=a+h;
        for(int i =0; i<4;i++){
            k1=h*func.fun(x, y);
            k2=h*func.fun(x+h/2, y+0.5*k1);
            k3=h*func.fun(x+h/2, y+0.5*k2);
            k4=h*func.fun(x+h, y+k3);
            y = y + (k1 + 2*k2 + 2*k3 + k4)/6;
            dot = new Dot(x,y);
            dots.add(dot);
            x+=h;
        }
        for(int i=5; i<n; i++){
            y=dots.get(i-1).y+(h/24)*(55*dots.get(i-1).x-59*dots.get(i-2).x+37*dots.get(i-3).x-9*dots.get(i-4).x);
            dot = new Dot(x,y);
            dots.add(dot);
            x+=h;
        }
        ans.setNumberSolution(dots);
        dots = new ArrayList<>();
        for(int i=0; i<=n;i++){
            dot = new Dot(a+i*h,func.inFun(a+i*h,0));
            dots.add(dot);
        }
        ans.setExactSolution(dots);
    return ans;
    }

}
