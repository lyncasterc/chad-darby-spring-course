package com.love2code.thymeleafdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// this is where the annotation can be applied to
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    // defining attrs to pass to @CourseCode

    public String value() default "LUV";

    public String message() default "must start with LUV";

    public Class<?>[] groups() default { };

    public Class<? extends Payload>[] payload() default  { };
}
