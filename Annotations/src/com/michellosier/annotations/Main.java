package com.michellosier.annotations;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean exit = false;

        FooBar fooBar = new FooBar("banana", "orange");

        CLIParser fooBarCLI = new CLIParser(fooBar);
        fooBarCLI.listAllOptions();
        fooBarCLI.interpretCommand("GET foo");
        fooBarCLI.interpretCommand("GET bar");

        Scanner input = new Scanner(System.in);

        while(exit == false){
            String nextLine = input.nextLine();
            if(nextLine.matches("exit")) {
                exit = true;
                return;
            }
            fooBarCLI.interpretCommand(nextLine);
        }
        input.close();

    }
}
