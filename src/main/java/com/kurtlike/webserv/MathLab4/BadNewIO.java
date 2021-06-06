package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.Dot;
import com.kurtlike.webserv.MathLab4.pojo.FunctionObject;

import java.util.ArrayList;

public class BadNewIO implements GoodOldIO {
    ArrayList<Dot> dots;
    ArrayList<FunctionObject> functions;
    String bestMethodName;
    int numberOfBestFunction;
    double r;
    @Override
    public void setDotsForApproximate(ArrayList<Dot> dots) {
        this.dots=dots;
    }

    @Override
    public ArrayList<FunctionObject> getFunctionObjects() {
        return functions;
    }

    @Override
    public int getNumberOfBestFunction() {
        return numberOfBestFunction;
    }

    @Override
    public String getBestMethodName() {
        return bestMethodName;
    }

    @Override
    public double getPierceKoef() {
        return r;
    }

    @Override
    public boolean solve() {
        functions = new ArrayList<>();
        FunctionObject functionObject = new FunctionObject();
        Linear linear = new Linear();

        //Линейная
        linear.solve(dots);
        functionObject.setACoefficients(new double[]{linear.b, linear.a});
        functionObject.setMethodName("Линейная");
        functions.add(functionObject);
        double s = 0;
        for (int i = 0; i < dots.size(); i++) {
            s += ((dots.get(i).y) - (linear.a * dots.get(i).x + linear.b)) * ((dots.get(i).y) - (linear.a * dots.get(i).x + linear.b));
        }
        double xq=0;
        double yq=0;
        for (Dot dot : dots){
            xq+=dot.x;
            yq+=dot.y;
        }
        xq=xq/dots.size();
        yq=yq/dots.size();
        double xp=0, yp=0;
        double xpp=0, ypp=0;
        for (Dot dot : dots){
            xp+=(dot.x-xq)*(dot.y-yq);
//            yp+=dot.y-yq;
            xpp+=(dot.x-xq)*(dot.x-xq);
            ypp+=(dot.y-yq)*(dot.y-yq);
        }
        r=(xp/(Math.sqrt(xpp*ypp)));
        double d1 = Math.sqrt(s / dots.size());
        double d = d1;
        s=0;
        bestMethodName="Линейная";
        numberOfBestFunction=0;


        //Экспоненциальная
        ArrayList<Dot> pDots = new ArrayList<>();
        ArrayList<Dot> helpDots = new ArrayList<>();
        Dot dot1;
        for (Dot dot : dots) {
            if (dot.y > 0) {
                dot1 = new Dot();
                dot1.x = dot.x;
                dot1.y = Math.log(dot.y);
                helpDots.add(dot1);
                pDots.add(dot);
            }
        }
        if (!helpDots.isEmpty()) {
            linear.solve(helpDots);
            if (linear.comp) {
                linear.b = Math.exp(linear.b);
                functionObject = new FunctionObject();
                functionObject.setACoefficients(new double[]{linear.b, linear.a});
                functionObject.setMethodName("Экспоненциальная");
                functions.add(functionObject);
                for (int i = 0; i < pDots.size(); i++) {
                    s += ((pDots.get(i).y) - linear.b * Math.exp(linear.a * pDots.get(i).x)) * ((pDots.get(i).y) - linear.b * Math.exp(linear.a * pDots.get(i).x));
                }
                d = Math.sqrt(s / pDots.size());
                if (d < d1) {
                    d1 = d;
                    bestMethodName="Экспоненциальная";
                    numberOfBestFunction=1;
                }
            }
        }
        s=0;
        helpDots.clear();
        pDots.clear();

        //Логарифмическая
        for (Dot dot : dots) {
            if (dot.x > 0) {
                dot1 = new Dot();
                dot1.y = dot.y;
                dot1.x = Math.log(dot.x);
                helpDots.add(dot1);
                pDots.add(dot);
            }
        }
        if (!helpDots.isEmpty()) {
            linear.solve(helpDots);
            if (linear.comp) {
                functionObject = new FunctionObject();
                functionObject.setACoefficients(new double[]{linear.a, linear.b});
                functionObject.setMethodName("Логарифмическая");
                functions.add(functionObject);
                for (int i = 0; i < pDots.size(); i++) {
                    s += ((pDots.get(i).y) - (linear.a * Math.log(pDots.get(i).x) + linear.b)) * ((pDots.get(i).y) - (linear.a * Math.log(pDots.get(i).x) + linear.b));
                }
                d = Math.sqrt(s / pDots.size());
                if (d < d1) {
                    d1 = d;
                    bestMethodName="Логарифмическая";
                    numberOfBestFunction=2;
                }
            }
            s=0;
            helpDots.clear();
            pDots.clear();
            //Степенная
            for (Dot dot : dots) {
                if (dot.x > 0 && dot.y > 0) {
                    dot1 = new Dot();
                    dot1.y = Math.log(dot.y);
                    dot1.x = Math.log(dot.x);
                    helpDots.add(dot1);
                }
            }
            if (!helpDots.isEmpty()) {
                linear.solve(helpDots);
                if (linear.comp) {
                    linear.b = Math.exp(linear.b);
                    functionObject = new FunctionObject();
                    functionObject.setACoefficients(new double[]{linear.b, linear.a});
                    functionObject.setMethodName("Степенная");
                    functions.add(functionObject);
                    for (int i = 0; i < pDots.size(); i++) {
                        s += ((pDots.get(i).y) - linear.b * Math.pow(pDots.get(i).x, linear.a)) * ((pDots.get(i).y) - linear.b * Math.pow(pDots.get(i).x, linear.a));
                    }
                    d = Math.sqrt(s / pDots.size());
                    if (d < d1) {
                        d1 = d;
                        bestMethodName="Степенная";
                        numberOfBestFunction=3;
                    }
                }
            }
            s=0;
            helpDots.clear();
            pDots.clear();

            //Квадратичная
            Quadratic quadratic = new Quadratic();
            quadratic.solve(dots);
            if (quadratic.comp) {
                functionObject = new FunctionObject();
                functionObject.setACoefficients(new double[]{quadratic.a, quadratic.b, quadratic.c});
                functionObject.setMethodName("Квадратичная");
                functions.add(functionObject);
            }
            for (Dot dot:dots) {

                s += Math.pow((dot.y) - (quadratic.c*dot.x*dot.x+quadratic.b*dot.x+quadratic.a),2);
            }
            d = Math.sqrt(s / dots.size());
            if (d < d1) {
                d1 = d;
                bestMethodName="Квадратичная";
                numberOfBestFunction=4;
            }

            s=0;
            helpDots.clear();
            pDots.clear();
            bestMethodName+="\n отклонение "+d1;
        }
        return true;
    }
}