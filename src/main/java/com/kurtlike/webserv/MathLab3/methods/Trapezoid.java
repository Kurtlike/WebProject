package com.kurtlike.webserv.MathLab3.methods;

@SuppressWarnings("ALL")
public class Trapezoid extends AbstractMethod implements Method{

    @Override
    public double solve(double left, double right, int counter) {
        double solution=0;
        double psolution=0;
        double i1;
        double di = (right - left) / counter;
        for (double i = left; i < right; i += di) {
           psolution+=di*(function.fun(i)+function.fun(i+di))/2;
        }
        counter++;

        while (!isEnd){
            solution = 0;
            di = (right - left) / counter;
            for (double i = left; i < right; i += di) {
                solution += di*(function.fun(i)+function.fun(i+di))/2;
            }
            if (Math.abs(solution - psolution) > accuracy) {
                counter*=2;
                psolution=solution;
            }
            else{
                isEnd=true;
                finalAccuracy=Math.abs(solution-psolution);
                innercounter=counter;
            }
        }
        return solution;
    }
}
