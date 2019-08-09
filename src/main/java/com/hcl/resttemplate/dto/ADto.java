package com.hcl.resttemplate.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ADto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@JsonProperty("Global Quote")
	private BDto globalQuote;

}
