package com.love2code.springboot.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // this is the default implementation that Spring will use for autowiring
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "hit some balls with the stick. thats it.";
    }

    /*
    *   Lifecycle methods
    *
    * @PostConstruct is used to define a method that should be called immediately after the bean's initialization
    *
    * you can see the sout in the log when the application starts
    *
    * @PreDestroy is used to define a method that should be called immediately before the bean is destroyed
    *
    * when you stop the application, you will see the sout in the log just before the application stops
    *
    * for prototype scoped beans, spring doesnt call the @PreDestroy method because id does not manage the complete lifecycle of a prototype bean
    * */
    @PostConstruct
    public void init() {
        System.out.println("BaseballCoach: inside init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("BaseballCoach: inside destroy method");
    }
}
