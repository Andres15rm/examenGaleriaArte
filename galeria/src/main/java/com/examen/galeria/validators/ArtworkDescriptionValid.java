package com.examen.galeria.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ArtworkDescriptionValid implements ConstraintValidator<ArtworkDescriptionValidator, String>  {

	@Override
    public void initialize(ArtworkDescriptionValidator constraintAnnotation) {
    }
	
	@Override
	public boolean isValid(String valor, ConstraintValidatorContext context) {
		if (valor == null || valor.trim().isEmpty()) {

            return false;
        }

        String[] palabras = valor.trim().split("\s+");

        return palabras.length >= 5;
	}

}
