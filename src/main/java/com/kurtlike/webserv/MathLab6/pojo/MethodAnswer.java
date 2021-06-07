package com.kurtlike.webserv.MathLab6.pojo;

import java.util.ArrayList;
    public class MethodAnswer{
        public MethodAnswer(String methodName, ArrayList<Dot> exactSolution, ArrayList<Dot> numberSolution) {
            this.methodName = methodName;
            this.exactSolution = exactSolution;
            this.numberSolution = numberSolution;
        }

        String methodName;
        ArrayList<Dot> exactSolution;
        ArrayList<Dot> numberSolution;
    }
