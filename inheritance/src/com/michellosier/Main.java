package com.michellosier;

public class Main {

    public static void main(String[] args) {
	    Animal animal = new Animal("Animal", 1, 1, 5, 5);

	    Dog dog = new Dog("Yorkie", 20, 30, 2,4,1, 16, "long");
	    dog.eat();
	    dog.walk();
	    dog.run();
    }
}
