package com.kurtlike.webserv.MathLab6.pojo;

import java.util.ArrayList;
import java.util.HashMap;

public class OnloadUpdateForms {
    public OnloadUpdateForms(HashMap<Integer,String> functions) {
        this.functions = functions;
    }
    private HashMap<Integer,String> functions;
    public void cleanAndAddAllFunctions(HashMap<Integer,String> newFunctions){
        functions.clear();
        functions.putAll(newFunctions);
    }
    public HashMap<Integer,String> getFunctions() {
        return functions;
    }

}
