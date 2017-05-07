package com.scratchpad.dataformat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WatsonTraits {

	@JsonProperty("id")
	private String id;

	@JsonProperty("value")
	private double value;

	public WatsonTraits(String id, double value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
