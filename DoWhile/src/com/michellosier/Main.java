package com.michellosier;

public class Main {

    public static void main(String[] args) {

        int number = 4;
        int finishNumber = 20;
        int count = 0;

        while (number <= finishNumber && count < 5){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            count++;
            System.out.println("Even number " + number);
        }

        System.out.println("Total number of events found: " + count);
    }

    public static boolean isEvenNumber(int n){
        if((n%2) == 0){
            return true;
        }
        return false;
    }
}
