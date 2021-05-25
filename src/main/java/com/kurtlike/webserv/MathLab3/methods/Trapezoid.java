package com.kurtlike.webserv.MathLab3.methods;

@SuppressWarnings("ALL")
public class Trapezoid extends AbstractMethod implements Method{

    @Override
    public double solve(double left, double right, int counter) {
        double solution=0;
        double psolution=0;
        double i1;
        double di = (right - left) / counter;
        int step=1;
        System.out.println(step+"\t");
        for (double i = left; i < right; i += di) {
           psolution+=di*(function.fun(i)+function.fun(i+di))/2;
        }
        counter++;
        System.out.println(solution+"\t"+solution);

        while (!isEnd){
            System.out.println(step+"\t");
            solution = 0;
            di = (right - left) / counter;
            for (double i = left; i < right; i += di) {
                solution += di*(function.fun(i)+function.fun(i+di))/2;
            }
            System.out.println(solution+"\t"+(solution-psolution)+"\t");
            step++;

            if (Math.abs(solution - psolution) > accuracy) {
                counter++;
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
