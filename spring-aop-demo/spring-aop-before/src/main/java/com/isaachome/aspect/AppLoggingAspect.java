package com.isaachome.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AppLoggingAspect {

    // it is where we add all of our related advices for logging

    // let's start with @Before advice
    @Before("execution(public  void addAccount())")
    public  void  beforeAddAccountAdvice(){
        System.out.println("==========> Executing @Before on addAccount()");
    }
}
