package com.kurtlike.webserv.MathLab6;

import com.kurtlike.webserv.MathLab6.pojo.Answer;
import com.kurtlike.webserv.MathLab6.pojo.Dot;
import com.kurtlike.webserv.MathLab6.pojo.MethodAnswer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Test implements GoodOldIO{
    @Override
    public HashMap<Integer,String> getFunctions() {
        HashMap<Integer,String> func = new HashMap<>();
        func.put(1,"ass we can");
        return func;
    }

    @Override
    public void setChosenFunction(int function) {

    }

    @Override
    public void setInterval(double left, double right) {

    }

    @Override
    public void setAccuracy(double accuracy) {

    }

    @Override
    public void setStep(int n) {

    }

    @Override
    public Answer getAnswer() {

       ArrayList<Dot> dots= new ArrayList<>();
       dots.add(new Dot(1,2));
       dots.add(new Dot(2,3));
       dots.add(new Dot(3,4));
       MethodAnswer methodAnswer = new MethodAnswer("ass we can",dots , new ArrayList<>(dots.stream().map(it -> new Dot(it.x +1,it.y +1)).collect(Collectors.toList())));
       ArrayList<MethodAnswer> methodAnswers = new ArrayList<>();
       methodAnswers.add(methodAnswer);

       Answer answer = new Answer();
       answer.setAnswers(methodAnswers);
       return answer;
    }
}
