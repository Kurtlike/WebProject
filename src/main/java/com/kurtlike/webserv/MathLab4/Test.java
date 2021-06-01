package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.Dot;
import com.kurtlike.webserv.MathLab4.pojo.FunctionObject;

import java.util.ArrayList;

public class Test implements GoodOldIO {
    ArrayList<Dot> dots;
    FunctionObject functionObject = new FunctionObject();
    FunctionObject functionObject2 = new FunctionObject();
    FunctionObject functionObject3 = new FunctionObject();
    FunctionObject functionObject4 = new FunctionObject();
    FunctionObject functionObject5 = new FunctionObject();
    @Override
    public void setDotsForApproximate(ArrayList<Dot> dots) {
        this.dots = dots;
    }

    @Override
    public ArrayList<FunctionObject> getFunctionObjects() {
        ArrayList<FunctionObject> arrayList = new ArrayList<>();

        functionObject.setACoefficients(new double[]{1, 1.2});
        functionObject.setMethodName("Линейная");
        arrayList.add(functionObject);

        functionObject2.setACoefficients(new double[]{ 1, 9});
        functionObject2.setMethodName("Степенная");
        arrayList.add(functionObject2);

        functionObject3.setACoefficients(new double[]{3, 2});
        functionObject3.setMethodName("Экспоненциальная");
        arrayList.add(functionObject3);

        functionObject4.setACoefficients(new double[]{1, 2});
        functionObject4.setMethodName("Логарифмическая");
        arrayList.add(functionObject4);

        functionObject5.setACoefficients(new double[]{1, 2, 2});
        functionObject5.setMethodName("Квадратичная");
        arrayList.add(functionObject5);


        return arrayList;
    }

    @Override
    public int getNumberOfBestFunction() {
        return 0;
    }

    @Override
    public String getBestMethodName() {
        return "Квадратичная";
    }


    @Override
    public double getPierceKoef() {
        return 43;
    }

    @Override
    public boolean solve(){
        return true;
    };
}
