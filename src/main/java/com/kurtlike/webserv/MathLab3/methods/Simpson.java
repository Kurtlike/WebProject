package com.kurtlike.webserv.MathLab3.methods;

public class Simpson extends AbstractMethod implements Method {

    @Override
    public double solve(double left, double right, int counter) {
        double solution=0;
        double psolution=0;
        double di = (right - left) / counter;
        for (double i = left; i < right-2*di; i += di) {

            psolution+=di/3*(function.fun(i)+4*function.fun(i+di)+function.fun(i+di+di))/2;
        }
        counter++;
        while (!isEnd){
            solution = 0;
            di = (right - left) / counter;
            for (double i = left; i < right; i += di) {
                solution += di/3*(function.fun(i)+4*function.fun(i+di)+function.fun(i+di+di))/2;
            }
            if (Math.abs(solution - psolution) > accuracy) {
                counter++;
                psolution=solution;
            }
            else{
                isEnd=true;
                finalAccuracy=Math.abs(solution-psolution);
            }
        }
        return solution;
    }
}
