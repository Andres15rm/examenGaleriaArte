package com.examen.galeria.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = ArtworkDescriptionValid.class)
public @interface ArtworkDescriptionValidator {
	
	String message() default "La descripción de la obra tiene que tener al menos 5 palabras.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
