package guru.springpractise.msscbeerservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * Created by Pratap on Sep 8, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	private UUID id;
	private Integer version;
	
	private OffsetDateTime createdDate;
	private OffsetDateTime lastModifiedDate;
	
	private String beerName;
	
	private BeerStyleEnum beerStyle;
	
	private Long upc;
	
	private BigDecimal price;
	
	private Integer quantityOnHand;
}
