package ru.pcs.crowdfunding.tran.services;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OperationValidator.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidOperation {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default  {};
}
