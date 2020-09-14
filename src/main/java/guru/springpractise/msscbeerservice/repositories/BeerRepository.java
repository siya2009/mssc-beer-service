package guru.springpractise.msscbeerservice.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import guru.springpractise.msscbeerservice.domain.Beer;

/** 
 * Created by Pratap on Sep 13, 2020
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID>{

}
