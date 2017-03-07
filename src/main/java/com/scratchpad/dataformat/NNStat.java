package com.scratchpad.dataformat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NNStat implements Comparable<NNStat> {

	@JsonProperty("m")
	private int m;

	@JsonProperty("lambda")
	private int lambda;

	@JsonProperty("validation")
	private double validation;

	@JsonProperty("testing")
	private double testing;

	@JsonProperty("training")
	private double training;

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getLambda() {
		return lambda;
	}

	public void setLambda(int lambda) {
		this.lambda = lambda;
	}

	public double getValidation() {
		return validation;
	}

	public void setValidation(double validation) {
		this.validation = validation;
	}

	public double getTesting() {
		return testing;
	}

	public void setTesting(double testing) {
		this.testing = testing;
	}

	public double getTraining() {
		return training;
	}

	public void setTraining(double training) {
		this.training = training;
	}

	@JsonIgnoreProperties
	public String getAsJson(NNStat nnStat) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(nnStat);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int compareTo(NNStat o) {
		int result = 0;
		if (o != null) {
			if (this.getValidation() != o.getValidation()) {
				result = (int) (this.getValidation()*100 - o.getValidation()*100);
			} else {
				result = (int) (this.getTesting()*100 - o.getTesting()*100);
			}
		} else {
			throw new IllegalArgumentException();
		}
		return result;
	}

}
