package com.michellosier.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

//all methods should be void returning and print to stdout
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CLIOption {
    String action();
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
            invokeMethodByCommand(command);
        } catch(Exception e){
            System.out.println(e);
        }

    }

    private void invokeMethodByCommand(CLICommand command){
        Method matchedCLIMethod;
        HashMap<String,String> arguments = command.getArguments();
        Object[] sortedArguments = new Object[arguments.size()];


        Method[] classMethods = classReference.getMethods();
        ArrayList<Method> cliMethods = findMethodsByActionAndTarget(classMethods, command);

        if (cliMethods.size() > 0){
            matchedCLIMethod = (cliMethods.size() > 1) ? matchMethodByParamLength(cliMethods, command) : cliMethods.get(0);
        } else {
            System.out.println("Could not find command");
            return;
        }

        if (arguments.size() > 0) {
            sortedArguments = sortCLIArguments(matchedCLIMethod, arguments).toArray();
        }

        try {
            matchedCLIMethod.invoke(this.objectReference, sortedArguments);
        } catch(Exception e){
            System.out.println("invoke method: " + e);
        }
    }

    private ArrayList<Method> findMethodsByActionAndTarget(Method[] methods, CLICommand command){
        String action = command.getAction();
        String target = command.getTarget();
        ArrayList<Method> matchingMethods = new ArrayList<Method>();

        for (Method method : methods){
            Annotation annotation = method.getAnnotation(CLIOption.class);
            CLIOption cliOptionAnnotation =  (CLIOption) annotation;

            if (cliOptionAnnotation instanceof CLIOption){
                if (cliOptionAnnotation.action().equals(action)
                        && (cliOptionAnnotation.target().equals(target))
                        ){
                    matchingMethods.add(method);
                }
            }
        }
        return matchingMethods;
    }

    private Method matchMethodByParamLength(ArrayList<Method> methods, CLICommand command) {
        int argumentLength = command.getArguments().size();
        Method foundMethod = null;

        for (Method method : methods){
            if (method.getParameterCount() == argumentLength){
                foundMethod = method;
                break;
            }
        }
        return foundMethod;
    }

    private ArrayList<String> sortCLIArguments(Method method, HashMap<String, String> arguments){
        ArrayList<String> sortedArguments = new ArrayList<String>();
        Annotation[][] methodParamAnnotations = method.getParameterAnnotations();

        for (int i = 0; i < methodParamAnnotations.length; i++){
            Annotation[] paramAnnotations = methodParamAnnotations[i];
            for (Annotation annotation : paramAnnotations){
                CLIParam cliParam = (CLIParam) annotation;

                if(arguments.get(cliParam.longName()) != null){
                    sortedArguments.add(arguments.get(cliParam.longName()));
                    arguments.remove(cliParam.longName());
                } else if (arguments.get(cliParam.shortName()) != null){

                    sortedArguments.add(arguments.get(cliParam.shortName()));
                    arguments.remove(cliParam.shortName());
                }
            }
        }

        return sortedArguments;
    }

    public void listAllOptions(){
        Method[] methods = classReference.getMethods();

        for (Method method : methods){
            Annotation methodAnnotation = method.getAnnotation(CLIOption.class);
            CLIOption cliOptionAnnotation =  (CLIOption) methodAnnotation;

            Annotation[][] paramAnnotations = method.getParameterAnnotations();


            if (cliOptionAnnotation instanceof CLIOption){
                System.out.printf("<%s %s> \"%s\"\n",
                        cliOptionAnnotation.action(),cliOptionAnnotation.target(),
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