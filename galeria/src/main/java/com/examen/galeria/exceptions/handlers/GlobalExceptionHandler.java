package com.examen.galeria.exceptions.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.examen.galeria.exceptions.ArtistNotFoundException;
import com.examen.galeria.exceptions.ArtworkCreationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler( ArtistNotFoundException.class )
	public ProblemDetail handleArtistNotFoundException(ArtistNotFoundException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Artist Exception Occurred");
		problemDetail.setType(URI.create("http://com.examen.galeria"));
		problemDetail.setProperty("errorCategory", "Artist");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}
	
	@ExceptionHandler( ArtworkCreationException.class )
	public ProblemDetail handleArtworkCreationException(ArtworkCreationException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setTitle("Artwork Exception Occurred");
		problemDetail.setType(URI.create("http://com.examen.galeria"));
		problemDetail.setProperty("errorCategory", "Artwork");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
	}

}
