package com.vnpost.annotations;

import com.vnpost.validator.UsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UsernameValidator.class)
public @interface Username {
    String message() default "Username is wrong !!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
