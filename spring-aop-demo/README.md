

## Development Process @Before

1. Create target Object : AccountDAO
2. Create Spring Config class
3. Create MainApp
4. Create Aspect with @Before advice

1.Create target Object 
```java
@Component
public class AccountDAO {

    public  void addAccount(){
        System.out.println(getClass() + " : DOING MY DB WORK : An Account Added");
    }
}

```
----
2.Create Spring Config class
```java

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.isaachome.dao")
public class AppConfig {
}

```
---
3.Create MainApp
```java
 public class MainApp
{
    public static void main( String[] args )
    {
        // read spring config java class
        AnnotationConfigApplicationContext context = 
        new AnnotationConfigApplicationContext(AppConfig.class);
        // get the bean from spring container
        AccountDAO accountBean = context.getBean("accountDAO", AccountDAO.class);
        // call the business method
        accountBean.addAccount();
        // close the context
        context.close();
    }
}

```

4.Create Logging Aspect 

```java

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

```

## PointCut in Action

### Specific class's method
```java
  @Before("execution(public void com.isaachome.dao.AccountDAO.addAccount())")
    public  void beforeAccountDAOAddAccountAdvice(){
        System.out.println("==========> Executing @Before on addAccount() from AccountADO");
    }
```

### Method that start with Add using wildcard

```java
    // method that start with add in any class.
    @Before("execution(public void add*())")
    public  void anyMethodThatStartWithAdd(){
        System.out.println("==========> Executing @Before on method start with Add.");
    }
```
### Match method with String return type
```java
 // match method  with String return type
    @Before("execution(String add*())")
    public  void matchStringReturnType(){
        System.out.println("==========> Executing @Before on method that return String type.");
    }
```
### Match method with Boolean return type
```java 
    // match method  with String return type
    @Before("execution(boolean is*())")
    public  void isMember(){
        System.out.println("==========> Executing @Before on method that return Boolean type.");
    }
```