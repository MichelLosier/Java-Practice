package com.michellosier;

public class Main {

    public static void main(String[] args) {

        double feet = 3;
        double inches = 6;

        double conversion = calcFeetAndInchesToCentimeters(feet, inches);
        System.out.println(feet + " ft. " + inches + " in. " + " converts to " + conversion + " cm.");


        inches = 800;

        conversion = calcFeetAndInchesToCentimeters(inches);
        System.out.println(inches + " in. " + " converts to " + conversion + " cm.");
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if((feet >= 0) && (inches >= 0 && inches <= 12)){
            double totalInches = (feet * 12) + inches;
            return (totalInches * 2.54);
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        if(inches >= 0){
            double feet = inches / 12;
            return calcFeetAndInchesToCentimeters(feet, 0.0);
        }
        return -1;
    }




}
