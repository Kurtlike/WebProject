package com.kurtlike.webserv.MathLab5;


import com.kurtlike.webserv.MathLab5.pojo.Dot;
import com.kurtlike.webserv.MathLab5.pojo.Dots;
import com.kurtlike.webserv.MathLab5.pojo.XValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("lab5")
public class Lab5Controller {
    GoodOldIO goodOldIO = new Test();
    @PostMapping(value = "/getAnswer")
    public Dots setDotsForApproximate(@RequestBody Dots dots){
        goodOldIO.setDotsForInterpolate(dots.getDots());
        goodOldIO.solve();
        return  goodOldIO.getDotsForDraw();
    }
    @PostMapping(value = "/getXValue")
    public XValue getXValue(@RequestBody XValue xValue){

        return goodOldIO.getXValue(xValue);
    }
}
