package com.michellosier;

public class Main {

    public static void main(String[] args) {

        for(int i=2; i <= 8; i++){
            double interest = calculateInterest(10000.0, (double)i);
            System.out.println("10000 with interest rate of " + i + "% is " + String.format("%.2f",interest));
        }

        for(int i=8; i >=2; i--){
            double interest = calculateInterest(10000.0, (double)i);
            System.out.println("10000 with interest rate of " + i + "% is " + String.format("%.2f",interest));
        }

        for(int i = 10, c = 0; i < 50; i++){
            if(isPrime(i)){
                System.out.println(i);
                c++;
                if(c == 3){
                    break;
                }
            }

        }
    }

    public static boolean isPrime(int n) {
        if(n == 1){
            return false;
        }

        for(int i=2; i <= n/2; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static double calculateInterest(double amount, double interestRate){
        return(amount * (interestRate/100));
    }
}
