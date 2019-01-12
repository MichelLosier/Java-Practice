package com.michellosier.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

//all methods should be void returning and print to stdout
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CLIOption {
    public enum Action {GET, SET}
    Action action();
    String longName();
    String shortName();
    String description();
}

public class CLIParser{

    private Class classReference;
    private Object objectReference;

    public CLIParser(Object obj){
        this.objectReference = obj;
        this.classReference = obj.getClass();
    }

    public void invokeMethodByArguments(String action, String option){
        Method[] methods = classReference.getMethods();

        for (Method method : methods){
            Annotation annotation = method.getAnnotation(CLIOption.class);
            CLIOption cliOptionAnnotation =  (CLIOption) annotation;

            if (cliOptionAnnotation instanceof CLIOption){
                if (cliOptionAnnotation.action().toString().equals(action)
                        && (cliOptionAnnotation.shortName().equals(option) || cliOptionAnnotation.longName().equals(option))
                        ){
                    try{
                        method.invoke(this.objectReference);
                    } catch(Exception e){
                        System.out.println(e);
                    }

                }
            }
        }
    }

    public void listAllOptions(){
        Method[] methods = classReference.getMethods();

        for (Method method : methods){
            Annotation annotation = method.getAnnotation(CLIOption.class);
            CLIOption cliOptionAnnotation =  (CLIOption) annotation;

            if (cliOptionAnnotation instanceof CLIOption){
                System.out.printf("action: %s, long: %s, short: %s, description: %s\n", cliOptionAnnotation.action().toString(),cliOptionAnnotation.longName(), cliOptionAnnotation.shortName(), cliOptionAnnotation.description());
            }
        }
    }

}