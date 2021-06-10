package com.kurtlike.webserv.MathLab5;

import com.kurtlike.webserv.MathLab5.pojo.Dot;

import java.util.ArrayList;

public class Solver {
    double[] f;
    public ArrayList<Dot> solve(ArrayList<Dot> dots, String methodName){
        f = new double[dots.size()];
        ArrayList<Dot> outDots= new ArrayList();
        setDiffferences(dots);
        double max=dots.get(dots.size()-1).x;
        switch (methodName){
            case "Полином Лагранжа":
                for(double i=dots.get(0).x;i<max;i+=0.05){
                    Dot dot = new Dot();
                    dot.x=i;
                    dot.y=lagrange(i,dots);
                    outDots.add(dot);
                }
                break;
            case "Полином Ньютона":
                for(double i=dots.get(0).x;i<max;i+=0.05){
                    Dot dot = new Dot();
                    dot.x=i;
                    dot.y=newtone(i,dots);
                    outDots.add(dot);
                }
                break;
        }
        return outDots;
    }
    double lagrange(double x, ArrayList<Dot> dots){
        int size = dots.size();
        double sum = 0;
        for(int i = 0; i < size; i++){
            double mul = 1;
            for(int j = 0; j < size; j++){
                if(i != j){
                    mul *= (x- dots.get(j).x)/(dots.get(i).x-dots.get(j).x);
                }
            }
            sum += dots.get(i).y*mul;
        }
        return sum;
    }
    double newtone(double x, ArrayList<Dot> dots){
        double answer = f[0];
        int m=dots.size()-1;
        for(int i=1; i<m;i++) {
            answer = answer * (x - dots.get(i).x) + f[i];
        }
        return answer;
    }
    void setDiffferences(ArrayList<Dot> dots){
        int m=dots.size()-1;
        for(int i=0; i<m; i++) {
            f[i] =dots.get(i).y;
        }
        for(int k=1; k<m; k++) {
            for(int i=0; i<m-k;i++) {
                f[i] = (f[i + 1] - f[i]) / (dots.get(i + k).x - dots.get(i).x);
            }
        }
    }
}