package com.kurtlike.webserv.MathLab3.methods;

@SuppressWarnings("Duplicates")
public class Simpson extends AbstractMethod implements Method {

    @Override
    public double solve(double left, double right, int counter) {
        double solution = 0;
        double psolution = 0;
        double di = (right - left) / counter;
//        for (double i = left; i < right-2*di; i += di) {
//
//            psolution+=di/3*(function.fun(i)+4*function.fun(i+di)+function.fun(i+di+di))/2;
//        }
//        counter++;
//        while (!isEnd){
//            solution = 0;
//            di = (right - left) / 2 / counter;
//            for (double i = left; i < right-2*di; i += di) {
//                solution += di/3*(function.fun(i)+4*function.fun(i+di)+function.fun(i+di+di))/2;
//            }

        psolution = function.fun(left);
        int j = 1;
        for (double p = left + di; p <= right; p += di) {
            psolution += (j % 2 == 1) ? 4 * function.fun(p) : 2 * function.fun(p);
            j++;
        }
        psolution*=di/3;
        counter++;

        while (!isEnd) {
            di  = (right - left) / counter;
            solution = function.fun(left);
            j = 1;
            for (double p = left + di; p <= right; p += di) {
                solution += (j % 2 == 1) ? 4 * function.fun(p) : 2 * function.fun(p);
                j++;
            }
            solution*=di/3;
            if (Math.abs(solution - psolution) > accuracy) {
                counter*=2;
                psolution = solution;
            } else {
                isEnd = true;
                finalAccuracy = Math.abs(solution - psolution);
                innercounter = counter;
            }
        }

        return solution;
    }
}
