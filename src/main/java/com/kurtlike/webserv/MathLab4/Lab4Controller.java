package com.kurtlike.webserv.MathLab4;

import com.kurtlike.webserv.MathLab4.pojo.Answer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lab4")
public class Lab4Controller {
    GoodOldIO goodOldIO = new Test();
    @PostMapping(value = "/getAnswer")
    public Answer setDotsForApproximate(@RequestBody double[][] dots){
        goodOldIO.setDotsForApproximate(dots);
        goodOldIO.solve();
        com.kurtlike.webserv.MathLab4.pojo.Answer answer = new Answer();
        answer.setBestFunction(goodOldIO.getBestFunction());
        answer.setBestMethodName(goodOldIO.getBestMethodName());
        answer.setPierceKoef(goodOldIO.getPierceKoef());
        answer.setFunctionObjects(goodOldIO.getFunctionObjects());
        return answer;
    }


}
