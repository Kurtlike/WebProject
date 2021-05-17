package com.kurtlike.webserv.MathLab4.pojo;

public class FunctionObject {
    private String functionName;
    private String methodName;
    private double[] aCoefficients;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public double[] getACoefficients() {
        return aCoefficients;
    }

    public void setACoefficients(double[] aCoefficient) {
        this.aCoefficients = aCoefficient;
    }
}
