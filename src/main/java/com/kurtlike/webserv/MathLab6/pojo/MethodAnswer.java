package com.kurtlike.webserv.MathLab6.pojo;

import java.util.ArrayList;
    public class MethodAnswer{
        private String methodName;
        private ArrayList<Dot> exactSolution;
        private ArrayList<Dot> numberSolution;

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public ArrayList<Dot> getExactSolution() {
            return exactSolution;
        }

        public void setExactSolution(ArrayList<Dot> exactSolution) {
            this.exactSolution = exactSolution;
        }

        public ArrayList<Dot> getNumberSolution() {
            return numberSolution;
        }

        public void setNumberSolution(ArrayList<Dot> numberSolution) {
            this.numberSolution = numberSolution;
        }
    }
