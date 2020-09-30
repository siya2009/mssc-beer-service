package guru.springpractise.msscbeerservice.web.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.Any;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import guru.springpractise.msscbeerservice.bootstrap.BeerLoader;
import guru.springpractise.msscbeerservice.services.BeerService;
import guru.springpractise.msscbeerservice.web.model.BeerDto;
import guru.springpractise.msscbeerservice.web.model.BeerStyleEnum;


/** 
 * Created by Pratap on Sep 13, 2020
 */

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	BeerService beerService;
	
	@Test
	void getBeerById() throws Exception {
		
		given(beerService.getById(any())).willReturn(getValidBeerDto());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" +UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
											   .andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@Test
	void saveNewBeer() throws Exception {
		BeerDto beerDto = getValidBeerDto();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	
	@Test
	void updateBeerById() throws Exception {
		given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());
		
		BeerDto beerDto = getValidBeerDto();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" +UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	
	
	BeerDto getValidBeerDto() {
		return BeerDto.builder()
				.beerName("My Beer")
				.beerStyle(BeerStyleEnum.ALE)
				.price(new BigDecimal("2.99"))
				.upc(BeerLoader.BEER_1_UPC)
				.build();
	}

}
