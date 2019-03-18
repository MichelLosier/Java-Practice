package com.michellosier.learn.springpractice.payroll;

public class OrderNotFoundException extends RuntimeException {
    OrderNotFoundException(Long id){
        super("Could not find order " + id);
    }
}
