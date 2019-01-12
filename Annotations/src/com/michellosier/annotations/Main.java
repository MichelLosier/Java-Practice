package com.michellosier.annotations;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FooBar fooBar = new FooBar("banana", "orange");

        CLIParser fooBarClI = new CLIParser(fooBar);
        fooBarClI.listAllOptions();
        fooBarClI.invokeMethodByArguments("GET", "foo");
        fooBarClI.invokeMethodByArguments("GET", "bar");

    }
}
