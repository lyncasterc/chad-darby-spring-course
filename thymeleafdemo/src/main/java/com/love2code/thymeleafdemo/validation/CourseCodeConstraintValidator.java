package com.love2code.thymeleafdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        this.coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        return code != null && code.startsWith(coursePrefix);
    }
}

