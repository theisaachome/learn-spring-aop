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

    @Before("execution(public void com.isaachome.dao.AccountDAO.addAccount())")
    public  void beforeAccountDAOAddAccountAdvice(){
        System.out.println("==========> Executing @Before on addAccount() from AccountADO");
    }

    // method that start with add in any class.
    @Before("execution(public void add*())")
    public  void anyMethodThatStartWithAdd(){
        System.out.println("==========> Executing @Before on method start with Add.");
    }

    // match method  with String return type
    @Before("execution(String add*())")
    public  void matchStringReturnType(){
        System.out.println("==========> Executing @Before on method that return String type.");
    }
    // match method  with String return type
    @Before("execution(boolean is*())")
    public  void isMember(){
        System.out.println("==========> Executing @Before on method that return Boolean type.");
    }
}
