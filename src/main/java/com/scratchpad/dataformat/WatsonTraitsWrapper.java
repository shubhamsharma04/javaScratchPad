package com.scratchpad.dataformat;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WatsonTraitsWrapper {

	@JsonProperty("personalityTraits")
	private List<WatsonTraits> personalityTraits;

	public WatsonTraitsWrapper() {
		personalityTraits = new ArrayList<WatsonTraits>();
	}

	public List<WatsonTraits> getPersonalityTraits() {
		return personalityTraits;
	}

	public void setPersonalityTraits(List<WatsonTraits> personalityTraits) {
		this.personalityTraits = personalityTraits;
	}

	@JsonIgnoreProperties
	public String getAsJson(WatsonTraitsWrapper watsonTraitsWrapper) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(watsonTraitsWrapper);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
