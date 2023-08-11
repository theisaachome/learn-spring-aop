package com.isaachome;

import com.isaachome.config.AppConfig;
import com.isaachome.dao.AccountDAO;
import com.isaachome.dao.MembershipDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class MainApp
{
    public static void main( String[] args )
    {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // get the bean from spring container
        AccountDAO accountBean = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        // call the business method
//        accountBean.addAccount();
        accountBean.addMember();
        membershipDAO.addAccount();
        membershipDAO.isMember();
        // close the context
        context.close();
    }
}
