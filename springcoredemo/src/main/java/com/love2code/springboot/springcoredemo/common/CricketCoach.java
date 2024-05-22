package com.love2code.springboot.springcoredemo.common;

import org.springframework.stereotype.Component;

// this annotation marks class as a Spring Bean
// spring will create an instance of the class and inject it
// and now spring can inject this as a dependency
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice some cricket stuff idk";
    }
}
