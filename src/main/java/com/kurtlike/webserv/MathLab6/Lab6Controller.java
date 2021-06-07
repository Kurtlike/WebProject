package com.kurtlike.webserv.MathLab6;


import com.kurtlike.webserv.MathLab6.pojo.Answer;
import com.kurtlike.webserv.MathLab6.pojo.RequestForAnswer;
import com.kurtlike.webserv.MathLab6.pojo.OnloadUpdateForms;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lab6")
public class Lab6Controller {
    GoodOldIO goodOldIO = new Test();
    @GetMapping(value = "/getOnload")
    public OnloadUpdateForms onloadUpdate(){
        return new OnloadUpdateForms( goodOldIO.getFunctions());
    }

    @PostMapping(value = "/getAnswer")
    public Answer getAnswer(@RequestBody RequestForAnswer requestForAnswer){
        goodOldIO.setChosenFunction(requestForAnswer.getSelectedFunction());
        goodOldIO.setInterval(requestForAnswer.getLeftBorder(), requestForAnswer.getRightBorder());
        goodOldIO.setAccuracy(requestForAnswer.getAccuracy());
        goodOldIO.setStep(requestForAnswer.getStep());
        return goodOldIO.getAnswer();
    }
}
