package com.michellosier;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        this("56789", 0.0, "Default name", "Default address", "default phone");
    }

    public BankAccount(String number, double balance, String customerName, String email, String phoneNumber){
        this.accountNumber = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String email, String phoneNumber){
        this("56789", 0.0, customerName, email, phoneNumber);
    }

    public void setAccountNumber(String number){
        this.accountNumber = number;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return this.balance;
    }

    public void setCustomerName(String name){
        this.customerName = name;
    }
    public String getCustomerName(){
        return this.customerName;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void deposit(double deposit){
        this.balance += deposit;
        System.out.printf("Deposited: %f with a new balance of %f \n", deposit, this.balance);
    }
    public void withdraw(double withdraw){
        double tempBalance = this.balance - withdraw;
        if(tempBalance < 0){
            System.out.printf("Withdraw will overdraft this account by %f \n", tempBalance);
            return;
        }
        this.balance = tempBalance;
    }

}
