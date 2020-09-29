package guru.springpractise.msscbeerservice.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springpractise.msscbeerservice.domain.Beer;
import guru.springpractise.msscbeerservice.repositories.BeerRepository;
import guru.springpractise.msscbeerservice.web.controller.NotFoundException;
import guru.springpractise.msscbeerservice.web.mapper.BeerMapper;
import guru.springpractise.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;

/** 
 * Created by Pratap on Sep 28, 2020
 */
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
	
	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;

	@Override
	public BeerDto getById(UUID beerId) {
		return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
		
		
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle().name());
		beer.setPrice(beerDto.getPrice());
		beer.setUpc(beerDto.getUpc());
		
		return beerMapper.beerToBeerDto(beerRepository.save(beer));
	}

	
}
