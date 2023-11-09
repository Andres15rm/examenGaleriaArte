package com.examen.galeria.model;

import com.examen.galeria.validators.ArtworkDescriptionValidator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtworkDTO {
	
	Integer id; //identificador único de la obra de arte
	String title; //Título de la obra de arte
	
	@ArtworkDescriptionValidator
	String description; //Descripcion de la obra (mínimo 5 palabras)
	
	Integer artistId; //Identificador del artista
}
