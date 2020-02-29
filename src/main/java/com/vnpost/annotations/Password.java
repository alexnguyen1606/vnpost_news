package com.vnpost.annotations;
import com.vnpost.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default "password is wrong !!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
