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
        func.put(0,"ass we can");
        func.put(1,"ass we cant");
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
    public void setStep(double step) {

    }

    @Override
    public Answer getAnswer() {

       ArrayList<Dot> dots= new ArrayList<>();
       dots.add(new Dot(1,2));
       dots.add(new Dot(2,3));
       dots.add(new Dot(3,4));
       MethodAnswer methodAnswer = new MethodAnswer();
       methodAnswer.setMethodName("ass we canMethod");
       methodAnswer.setExactSolution(dots);
       methodAnswer.setNumberSolution(new ArrayList<>(dots.stream().map(it -> new Dot(it.x -1,it.y +1)).collect(Collectors.toList())));

       MethodAnswer methodAnswer2 = new MethodAnswer();
       methodAnswer2.setMethodName("ass we canMethod");
       methodAnswer2.setExactSolution(new ArrayList<>(dots.stream().map(it -> new Dot(it.x -3,it.y +3)).collect(Collectors.toList())));
       methodAnswer2.setNumberSolution(new ArrayList<>(dots.stream().map(it -> new Dot(it.x -4,it.y +4)).collect(Collectors.toList())));
       ArrayList<MethodAnswer> methodAnswers = new ArrayList<>();

       methodAnswers.add(methodAnswer);
       methodAnswers.add(methodAnswer2);
       Answer answer = new Answer();
       answer.setAnswers(methodAnswers);
       return answer;
    }
}
