package com.kurtlike.webserv.MathLab3.methods;

@SuppressWarnings("ALL")
public class Trapezoid extends AbstractMethod implements Method{

    @Override
    public void solve() {
        answer=0;
        panswer=0;
        double di = (rightBorder - leftBorder) / counter;
        for (double i = leftBorder; i < rightBorder; i += di) {
           panswer+=di*(function.fun(i)+function.fun(i+di))/2;
        }
        counter++;

        while (!isEnd){
            answer = 0;
            di = (rightBorder - leftBorder) / counter;
            for (double i = leftBorder; i < rightBorder; i += di) {
                answer += di*(function.fun(i)+function.fun(i+di))/2;
            }
            if (Math.abs(answer - panswer) > accuracy) {
                counter++;
                panswer=answer;
            }
            else{
                isEnd=true;
                finalAccuracy=Math.abs(answer-panswer);
            }
        }
    }
}
