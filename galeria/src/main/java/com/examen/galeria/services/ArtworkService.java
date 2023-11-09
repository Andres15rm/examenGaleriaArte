package com.examen.galeria.services;
import java.util.ArrayList;

import com.examen.galeria.model.*;

public interface ArtworkService {
	
	ArrayList<ArtworkDTO> getAllArtworks();//Retorna una lista con todas las obras de arte.		
		 
	ArrayList<ArtworkDTO> getAllArtworks(Integer artistId); //retorna todas las obras de arte de un artista específico. Este método lanza una excepción personalizada artistNotFoundException si no existen
															//obras de arte creadas de ese artista. No confundir con que el artista que exista en la lista.
	void createArtwork(ArtworkDTO artworkDTO);//Guarda una nueva obra de arte basada en los datos de artworkDTO.

}
