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
public class BDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonProperty("01. symbol")
	private String symbol;
	
	@JsonProperty("02. open")
	private double open;
	
	@JsonProperty("03. high")
	private double high;
	
	@JsonProperty("04. low")
	private double low;
	
	@JsonProperty("05. price")
	private double price;
	
	@JsonProperty("06. volume")
	private double volume;
	
	@JsonProperty("07. latest trading day")
	private String  latestTradingDay;
	
	@JsonProperty("08. previous close")
	private double previousClose;
	
	@JsonProperty("09. change")
	private double change;
	
	@JsonProperty("10. change percent")
	private String  changePercent;

}
