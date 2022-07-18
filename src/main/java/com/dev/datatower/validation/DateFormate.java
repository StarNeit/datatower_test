package com.dev.datatower.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD , TYPE, METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy = DateFormateValidator.class)
@Documented
public @interface DateFormate {

  String message() default "older than 18 years old";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
  
}
