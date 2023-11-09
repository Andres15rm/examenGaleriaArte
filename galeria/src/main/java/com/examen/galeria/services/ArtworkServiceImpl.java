package com.examen.galeria.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.examen.galeria.exceptions.ArtistNotFoundException;
import com.examen.galeria.exceptions.ArtworkCreationException;
import com.examen.galeria.model.ArtistDTO;
import com.examen.galeria.model.ArtworkDTO;

public class ArtworkServiceImpl implements ArtworkService {

	ArrayList<ArtworkDTO> obras = new ArrayList<>();
	
	ArtworkDTO ar = new ArtworkDTO(1, "Titulo1", "hola soy la descripción uno", 1);
	ArtworkDTO ar2 = new ArtworkDTO(2, "Titulo2", "hola soy la descripción dos", 2);
	ArtworkDTO ar3 = new ArtworkDTO(3, "Titulo3", "hola soy la descripción tres", 1);
	ArtworkDTO ar4 = new ArtworkDTO(4, "Titulo4", "hola soy la descripción cuatro", 3);
	
	@Autowired
    ArtistServiceImpl listaArtistas;
	
	public ArtworkServiceImpl() {

		obras.add(ar);
		obras.add(ar2);
		obras.add(ar3);
		obras.add(ar4);
	}
	
	@Override
	public ArrayList<ArtworkDTO> getAllArtworks() {
		
		return obras;
	}
	
	@Override
	public ArrayList<ArtworkDTO> getAllArtworks(Integer artistId) {
		ArrayList<ArtworkDTO> listaObras = new ArrayList<>();
		for (ArtworkDTO lista : obras) {
            if (lista.getArtistId().equals(artistId)) {
                listaObras.add(lista);
            }
        }
		
		if(listaObras.isEmpty()) {
			throw new ArtistNotFoundException("No existe obras del artista con id: " + artistId);
		}
		
		return listaObras;
	}

	@Override
	public void createArtwork(ArtworkDTO artworkDTO) {
		
		
		
		boolean artistaExiste=false;
		for (ArtistDTO artista : listaArtistas.artists) {
			if(artista.getId().equals(artworkDTO.getArtistId())) {
				artistaExiste=true;
				break;
			}
		}
		if (!artistaExiste) {
			throw new ArtworkCreationException("El artista con id " + artworkDTO.getArtistId() + " no existe");
		}
		
		for (ArtworkDTO obra : obras) {
			if(obra.getArtistId().equals(artworkDTO.getArtistId())&&obra.getTitle().equals(artworkDTO.getTitle())) {
				throw new ArtworkCreationException("El artista con id " + artworkDTO.getArtistId() + " ya tiene una obra con el título: " + artworkDTO.getTitle());
			}
		}
		
		obras.add(artworkDTO);
	}

	
}
