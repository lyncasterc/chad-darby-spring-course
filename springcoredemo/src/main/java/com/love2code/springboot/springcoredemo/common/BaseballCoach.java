package com.love2code.springboot.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // this is the default implementation that Spring will use for autowiring
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "hit some balls with the stick. thats it.";
    }
}
