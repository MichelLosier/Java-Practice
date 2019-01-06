package com.michellosier;

public class Main {

    public static void main(String[] args) {
        double firstNum = 20.0;
        double secondNum = 80.0;

        double thirdNum = (firstNum + secondNum) * 25;

        double remainder = thirdNum % 40;

        if(remainder <= 20)
            System.out.println("Total was over the limit");
    }
}
