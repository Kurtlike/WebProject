package com.kurtlike.webserv.MathLab3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(value = "/getOnload")
    public OnloadUpdateForms onloadUpdate(){

    }
    
}
