package com.kurtlike.webserv.MathLab3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lab3")
public class Lab3Controller {
    GoodOldIO goodOldIO = new BadNewIO();
    @GetMapping(value = "/getOnload")
    public OnloadUpdateForms onloadUpdate(){
        return new OnloadUpdateForms(goodOldIO.getMethods(), goodOldIO.getFunctions());
    }
    @PostMapping(value = "/getAnswer")
    public Answer getAnswer(@RequestBody RequestForAnswer requestForAnswer){
        goodOldIO.setChosenMethod(requestForAnswer.getSelectedMethod());
        goodOldIO.setChosenFunction(requestForAnswer.getSelectedFunction());
        goodOldIO.setBorders(requestForAnswer.getLeftBorder(), requestForAnswer.getRightBorder());
        goodOldIO.setAccuracy(requestForAnswer.getAccuracy());
        goodOldIO.setStartingNumberOfIterations(requestForAnswer.getN());
      Answer answer = new Answer();
      answer.setAnswer(goodOldIO.getAnswer());
      answer.setNumberOfIterations(goodOldIO.getNumberOfDivisions());
      return answer;
    }
}
