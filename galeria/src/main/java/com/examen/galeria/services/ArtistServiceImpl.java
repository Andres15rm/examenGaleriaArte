package com.examen.galeria.services;

import java.util.ArrayList;

import com.examen.galeria.model.ArtistDTO;

public class ArtistServiceImpl implements ArtistService {

	ArrayList<ArtistDTO> artists = new ArrayList<>();

	ArtistDTO ar = new ArtistDTO(1, "Goya");
	ArtistDTO ar2 = new ArtistDTO(2, "Picasso");
	ArtistDTO ar3 = new ArtistDTO(3, "Dalí");
	ArtistDTO ar4 = new ArtistDTO(4, "Miró");
	
	public ArtistServiceImpl(){

		artists.add(ar);
		artists.add(ar2);
		artists.add(ar3);
		artists.add(ar4);
	}

	@Override
	public ArtistDTO getArtistById(Integer id) {
		
		for (ArtistDTO artista : artists) {
	        if (artista.getId().equals(id)) {
	            return artista;
	        }
	    }
		return null;
	}
}
