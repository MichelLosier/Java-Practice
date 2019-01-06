package com.michellosier;

public class Main {

    public static void main(String[] args) {
        BankAccount testAccount = new BankAccount("123456789", 0.0,
                "Mike Losier", "mikelosier@gmail.com", "7275437183");


        System.out.printf("Account Number: %s \n", testAccount.getAccountNumber());
        System.out.printf("Balance: %f \n", testAccount.getBalance());
        System.out.printf("Customer Name: %s \n", testAccount.getCustomerName());
        System.out.printf("Email: %s \n", testAccount.getEmail());
        System.out.printf("Phone #: %s \n", testAccount.getPhoneNumber());

        testAccount.deposit(1800.00);
        testAccount.withdraw(900);
        System.out.printf("Balance: %f \n", testAccount.getBalance());
        testAccount.withdraw(1000);
        System.out.printf("Balance: %f \n", testAccount.getBalance());
    }
}
