package com.isaachome.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public  void addAccount(){
        System.out.println(getClass() + " : DOING MY DB WORK : An Account Added");
    }
}
