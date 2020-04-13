package com.myproject.connections.utility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.myproject.connections.utility.impl.UniqueEmailValidator;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueEmail {

	public String message() default "There is already a user registered with this email!";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default{};
 

}