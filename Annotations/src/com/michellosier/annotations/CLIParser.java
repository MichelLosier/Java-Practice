package com.michellosier.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;

//all methods should be void returning and print to stdout
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CLIOption {
    enum Action {GET, SET}
    Action action();
    String target();
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface CLIParam {
    String longName();
    String shortName();
    String value();
}



public class CLIParser{

    private Class classReference;
    private Object objectReference;

    public CLIParser(Object obj){
        this.objectReference = obj;
        this.classReference = obj.getClass();
    }

    public void interpretCommand(String stringCommand){

        try {
            CLICommand command = new CLICommand(stringCommand);
            invokeMethodByArguments(command);
        } catch(Exception e){
            System.out.println(e);
        }

    }

    private void invokeMethodByArguments(CLICommand command){
        String action = command.getAction();
        String target = command.getTarget();
        HashMap<String,String> arguments = command.getArguments();

        Method[] methods = classReference.getMethods();

        for (Method method : methods){
            Annotation annotation = method.getAnnotation(CLIOption.class);
            CLIOption cliOptionAnnotation =  (CLIOption) annotation;

            if (cliOptionAnnotation instanceof CLIOption){
                if (cliOptionAnnotation.action().toString().equals(action)
                        && (cliOptionAnnotation.target().equals(target))
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
            Annotation methodAnnotation = method.getAnnotation(CLIOption.class);
            CLIOption cliOptionAnnotation =  (CLIOption) methodAnnotation;

            Annotation[][] paramAnnotations = method.getParameterAnnotations();


            if (cliOptionAnnotation instanceof CLIOption){
                System.out.printf("%s %s \"%s\"\n",
                        cliOptionAnnotation.action().toString(),cliOptionAnnotation.target(),
                        cliOptionAnnotation.description());
            }

            if (paramAnnotations.length > 0 && paramAnnotations[0].length > 0){
                System.out.printf("%-5s options:\n","");
               for (Annotation[] paramAnnotation : paramAnnotations){
                  for(Annotation annotation : paramAnnotation){
                      CLIParam cliParamAnnotation = (CLIParam) annotation;
                      System.out.printf("%-10s -%s, -%s, expects: %s\n","", cliParamAnnotation.longName(), cliParamAnnotation.shortName(), cliParamAnnotation.value());
                  }
               }
            }
        }
    }

}