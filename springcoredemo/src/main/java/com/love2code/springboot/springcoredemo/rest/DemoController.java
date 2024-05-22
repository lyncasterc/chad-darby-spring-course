package com.love2code.springboot.springcoredemo.rest;

import com.love2code.springboot.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    // field injection - no longer in favor
    // this is not recommended because it makes testing harder

    // @Autowired
    // private Coach myCoach;


    /*

    this is an example of constructor injection
     this is recommended for required dependencies
     Spring will inject CricketCoach since its the only Coach implementation
     this is autowired automatically (@Autowired is optional) when there is only one constructor

     if there is more than one implementation of the interface, you need to use @Qualifier to specify which implementation to use with the



     */

    public DemoController(@Qualifier("swimCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }

    // you can also use @Primary to specify the default implementation
    // right now the default implementation is BaseballCoach
    /*public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }*/

    // example of setter injection
    // this is recommended for optional dependencies
    // needs the @Autowired annotation to enable automatic injection
   /* @Autowired
    public void setMyCoach(Coach myCoach) {
        this.myCoach = myCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
