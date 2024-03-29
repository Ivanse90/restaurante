package com.booking.api.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TurnRest {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;

}
