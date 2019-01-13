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
        target = "foo",
        description = "Get the value of foo"
    )
    public void getFooCLI(){
        System.out.println(this.foo);
    }

    public String getFoo(){
        return this.foo;
    }

    @CLIOption(
        action = CLIOption.Action.GET,
        target = "bar",
        description = "Get the value of bar"
    )
    public void getBarCLI(){
        System.out.println(this.bar);
    }

    public void getBarCLI(int times){
        for (int i = times; i == 0; i--){
            getBarCLI();
        }
    }

    public String getBar(){
        return this.bar;
    }

    @CLIOption(
            action = CLIOption.Action.SET,
            target = "foo",
            description = "Set value of foo"
    )
    public void setFooCLI(
            @CLIParam(longName="value", shortName="v", value="string") String f){
       setFoo(f);
       System.out.println(this.foo);
    }

    public void setFoo(String f){
        this.foo = f;
    }

    public void setBar(String b){
        this.bar = b;
    }

}
