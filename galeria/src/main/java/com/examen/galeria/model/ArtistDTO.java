package com.examen.galeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
	
	Integer id; //Identificador unico del artista
	String name; //Nombre del artista
}
