package com.michellosier;

public class Main {

    public static void main(String[] args) {

        byte byteA = 10;
        short shortA = 2400;
        int intA = 64000;

        long longValue = (50_000L + (10L * (byteA + shortA + intA)));

        System.out.println("longValue: " + longValue);

    }
}