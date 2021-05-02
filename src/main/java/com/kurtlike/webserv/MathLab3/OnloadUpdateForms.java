package com.kurtlike.webserv.MathLab3;

import java.util.ArrayList;

public class OnloadUpdateForms {
    private ArrayList<String> methods = new ArrayList<>();
    private ArrayList<String> functions = new ArrayList<>();
    public void addAllMethods(ArrayList<String> newMethods){
        methods.addAll(newMethods);
    }
    public void cleanAndAddAllMethods(ArrayList<String> newMethods){
        methods.clear();
        methods.addAll(newMethods);
    }
    public void cleanAndAddAllFunctions(ArrayList<String> newFunctions){
        functions.clear();
        functions.addAll(newFunctions);
    }

    public ArrayList<String> getFunctions() {
        return functions;
    }

    public ArrayList<String> getMethods() {
        return methods;
    }
}
