package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.Dot;
import com.kurtlike.webserv.MathLab4.pojo.FunctionObject;

import java.util.ArrayList;

public class Test implements GoodOldIO {
    ArrayList<Dot> dots;
    FunctionObject functionObject = new FunctionObject();
    FunctionObject functionObject2 = new FunctionObject();
    FunctionObject functionObject3 = new FunctionObject();
    @Override
    public void setDotsForApproximate(ArrayList<Dot> dots) {
        this.dots = dots;
    }

    @Override
    public ArrayList<FunctionObject> getFunctionObjects() {
        ArrayList<FunctionObject> arrayList = new ArrayList<>();

        functionObject.setACoefficients(new double[]{0, 1.2, 2.2, 0, 1.2});
        functionObject.setMethodName("bestMethd");
        arrayList.add(functionObject);

        functionObject2.setACoefficients(new double[]{0, 0, 1, 0, 9});
        functionObject2.setMethodName("methd2");
        arrayList.add(functionObject2);

        functionObject3.setACoefficients(new double[]{1, 2, 2});
        functionObject3.setMethodName("methd3");
        arrayList.add(functionObject3);

        return arrayList;
    }

    @Override
    public int getNumberOfBestFunction() {
        return 0;
    }

    @Override
    public String getBestMethodName() {
        return "bestMethd";
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
