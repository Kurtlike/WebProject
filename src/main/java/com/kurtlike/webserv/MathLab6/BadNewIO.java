package com.kurtlike.webserv.MathLab6;

import com.kurtlike.webserv.MathLab6.Functions.Function;
import com.kurtlike.webserv.MathLab6.Functions.Function0;
import com.kurtlike.webserv.MathLab6.Functions.Function1;
import com.kurtlike.webserv.MathLab6.Functions.Function2;
import com.kurtlike.webserv.MathLab6.pojo.Answer;
import com.kurtlike.webserv.MathLab6.pojo.MethodAnswer;

import java.util.ArrayList;
import java.util.HashMap;

public class BadNewIO implements GoodOldIO {
    HashMap<Integer, String> functions= new HashMap<>();
    int function;
    Function func;
    double left, right, y0, step;

    public BadNewIO(){
    functions.put(0,"y'=x");
    functions.put(1,"y'=x+x^2");
    functions.put(2,"y'=y+1");
    }
    @Override
    public HashMap<Integer, String> getFunctions() {
        return functions;
    }

    @Override
    public void setChosenFunction(int function) {
        this.function=function;
        switch (function){
            case 0:
                func= new Function0();
                break;
            case 1:
                func = new Function1();
                break;
            case 2:
                func = new Function2();
                break;
        }

    }

    @Override
    public void setInterval(double left, double right) {
        this.left=left;
        this.right=right;
    }

    @Override
    public void setY0(double y0) {
        this.y0=y0;
    }

    @Override
    public void setStep(double step) {
        this.step=step;
    }

    @Override
    public Answer getAnswer() {
        Solver solver=new Solver();
        Answer answer = new Answer();
        ArrayList<MethodAnswer> list = new ArrayList<>();
        System.out.println(left+ " " + right + " "+ y0 + " "+ step + "\n");
        list.add(solver.euler(func, left, right, y0, step));
        list.add(solver.adams(func, left, right, y0, step));
        answer.setAnswers(list);

        return answer;
    }
}
