package com.kurtlike.webserv.controllers;

import com.kurtlike.webserv.entitysPOJO.Anomaly;
import com.kurtlike.webserv.DAOs.AnomalyDAO;
import com.kurtlike.webserv.service.AnomalyService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SCPMainController {
    @Autowired
    AnomalyService anomalyService;

    @PostMapping(value = "/getSCPArticle")
    public Anomaly getSCPArticle(@RequestBody String name) throws ParseException {
        String nameSCP = getStringFromJSON(name, "name" );
        return anomalyService.getByName(nameSCP);
    }

    @GetMapping("/getSCPArticleTitles")
    public ArrayList<String> getSCPTitles(){
        ArrayList<String> titles = new ArrayList<>();
        titles.add("SCP-002");
        titles.add("SCP-003");
        titles.add("SCP-004");
        titles.add("SCP-005");
        titles.add("SCP-006");
        titles.add("SCP-007");
        titles.add("SCP-008");

        return titles;
    }
    private String getStringFromJSON(String json, String param) throws ParseException {
        Object obj = new JSONParser().parse(json);
        JSONObject jo = (JSONObject) obj;
        return (String) jo.get(param);
    }

}
