package com.michellosier;

public class Main {

    public static void main(String[] args) {
	// write your code here
        if (args.length > 1) {
            for (int i = 0; i < args.length; i++ ){
                System.out.printf("%d. %s%n",(i+1), args[i]);
            }
        } else {
            System.out.println("No Arguments");
        }
    }
}
