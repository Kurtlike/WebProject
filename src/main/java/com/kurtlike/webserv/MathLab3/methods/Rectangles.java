package com.kurtlike.webserv.MathLab3.methods;

public abstract class Rectangles extends AbstractMethod implements Method {
   abstract public double getCurrentRectangleValue(double x, double dx);

   public void solve(){
       isEnd=false;
       answer = 0;
       panswer=0;
       double di = (rightBorder - leftBorder) / counter;
       for (double i = leftBorder; i < rightBorder; i += di) {
           panswer += getCurrentRectangleValue(i,di);
       }
       counter++;

       while(!isEnd) {
           answer = 0;
           di = (rightBorder - leftBorder) / counter;
           for (double i = leftBorder; i < rightBorder; i += di) {
               answer += getCurrentRectangleValue(i,di);
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
