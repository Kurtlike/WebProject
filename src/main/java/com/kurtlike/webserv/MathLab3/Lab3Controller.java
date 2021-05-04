package com.kurtlike.webserv.MathLab3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lab3Controller {
    GoodOldIO goodOldIO = new Test();
    @GetMapping(value = "/getOnload")
    public OnloadUpdateForms onloadUpdate(){
        return new OnloadUpdateForms(goodOldIO.getMethods(), goodOldIO.getFunctions());
    }
    @PostMapping(value = "/getAnswer")
    public Answer getAnswer(@RequestBody RequestForAnswer requestForAnswer){
        System.out.println(requestForAnswer.getSelectedMethod());
      goodOldIO.setChosenMethod(requestForAnswer.getSelectedMethod());
      goodOldIO.setChosenFunction(requestForAnswer.getSelectedFunction());
      goodOldIO.setBorders(requestForAnswer.getLeftBorder(), requestForAnswer.getRightBorder());
      goodOldIO.setAccuracy(requestForAnswer.getAccuracy());
      Answer answer = new Answer();
      answer.setAnswer(goodOldIO.getAnswer());
      answer.setNumberOfIterations(goodOldIO.getNumberOfDivisions());
      return answer;
    }
}
