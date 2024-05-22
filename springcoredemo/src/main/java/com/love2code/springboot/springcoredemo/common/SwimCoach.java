package com.love2code.springboot.springcoredemo.common;

// not using the @Component annotation on purpose to demonstrate java configuration
public class SwimCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "swim a lap or something idk dude";
    }
}
