package guru.springpractise.msscbeerservice.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import guru.springpractise.msscbeerservice.web.model.BeerDto;

/** 
 * Created by Pratap on Sep 28, 2020
 */
public interface BeerService {

	
	BeerDto getById(UUID beerId);
	BeerDto saveNewBeer(BeerDto beerDto);
	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
