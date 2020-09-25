package guru.springpractise.msscbeerservice.web.mapper;

import org.mapstruct.Mapper;

import guru.springpractise.msscbeerservice.domain.Beer;
import guru.springpractise.msscbeerservice.web.model.BeerDto;

/** 
 * Created by Pratap on Sep 24, 2020
 */

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	BeerDto beerToBeerDto(Beer beer);
	Beer beerDtoToBeer(BeerDto dto);
}
