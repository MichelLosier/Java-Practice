package com.michellosier.annotations;


public class FooBar {

    private String foo;
    private String bar;

    public FooBar(String f, String b){
        this.foo = f;
        this.bar = b;
    }

    @CLIOption(
        action = CLIOption.Action.GET,
        longName = "foo",
        shortName = "f",
        description = "Get the value of foo"
    )
    public void printFoo(){
        System.out.println(this.foo);
    }

    public String getFoo(){
        return this.foo;
    }

    @CLIOption(
        action = CLIOption.Action.GET,
        longName = "bar",
        shortName = "b",
        description = "Get the value of bar"
    )
    public void printBar(){
        System.out.println(this.bar);
    }

    public String getBar(){
        return this.bar;
    }

    public void setFoo(String f){
        this.foo = f;
    }

    public void setBar(String b){
        this.bar = b;
    }

}
