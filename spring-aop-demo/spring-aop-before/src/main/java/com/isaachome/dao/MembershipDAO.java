package com.isaachome.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public  void addAccount(){
        System.out.println(getClass() + " :  Doing MY DB work : Adding Membership DAO.");
    }
    public boolean isMember(){
        System.out.println(getClass() + " :  Doing MY DB work : checking Membership DAO.");
        return  true;
    }
}
