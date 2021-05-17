package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.FunctionObject;

import java.util.ArrayList;

public class Test implements GoodOldIO {
    double[][] dots;
    FunctionObject functionObject = new FunctionObject();
    @Override
    public void setDotsForApproximate(double[][] dots) {
        this.dots = dots;
    }

    @Override
    public ArrayList<FunctionObject> getFunctionObjects() {
        functionObject.setACoefficients(new double[]{0, 1.2, 2.2, 0, 1.2});
        functionObject.setFunctionName("bestFunc");
        functionObject.setMethodName("bestMethd");
        ArrayList<FunctionObject> arrayList = new ArrayList<>();
        arrayList.add(functionObject);
        return arrayList;
    }
    @Override
    public String getBestFunction() {
        return "bestFunc";
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
