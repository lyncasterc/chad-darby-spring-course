package com.love2code.springboot.springcoredemo.config;

import com.love2code.springboot.springcoredemo.common.Coach;
import com.love2code.springboot.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfig {
    // to define a bean, it must be of the interface type

    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
