package com.kurtlike.webserv.MathLab3.methods;

public class Simpson extends AbstractMethod implements Method {

    @Override
    public void solve() {
        answer=0;
        panswer=0;
        double di = (rightBorder - leftBorder) / counter;
        for (double i = leftBorder; i < rightBorder-2*di; i += di) {
            panswer+=di/3*(function.fun(i)+4*function.fun(i+di)+function.fun(i+di+di))/2;
        }
        counter++;
        while (!isEnd){
            answer = 0;
            di = (rightBorder - leftBorder) / counter;
            for (double i = leftBorder; i < rightBorder; i += di) {
                answer += di/3*(function.fun(i)+4*function.fun(i+di)+function.fun(i+di+di))/2;
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
