package com.kurtlike.webserv.MathLab3.methods;

public abstract class Rectangles extends AbstractMethod implements Method {
   abstract public double getCurrentRectangleValue(double x, double dx);

   public double solve(double left, double right, int counter){
       isEnd=false;
       double solution = 0;
       double psolution=0;
       double di = (right - left) / counter;
       for (double i = left; i < right; i += di) {
           psolution += getCurrentRectangleValue(i,di);
       }
       counter++;

       while(!isEnd) {
           solution = 0;
           di = (right - left) / counter;
           for (double i = left; i < right; i += di) {
               solution += getCurrentRectangleValue(i,di);
           }
           System.out.println(solution);
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
