package com.scratchpad.dataformat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Hashtag implements Comparable<Hashtag> {

	@JsonProperty("hashtag")
	private String hashtag;

	@JsonProperty("date")
	private int date;

	@JsonProperty("count")
	private int count;
	
	@JsonProperty("dateStr")
	private String dateStr;
	
	public Hashtag(){
		
	}

	public Hashtag(String hashtag, int dayOfYear) {
		this.hashtag = hashtag;
		this.date = dayOfYear;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@JsonIgnoreProperties
	public String getAsJson(Hashtag hashtag) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(hashtag);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + date;
		result = prime * result + ((hashtag == null) ? 0 : hashtag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hashtag other = (Hashtag) obj;
		if (date != other.date)
			return false;
		if (hashtag == null) {
			if (other.hashtag != null)
				return false;
		} else if (!hashtag.equals(other.hashtag))
			return false;
		return true;
	}

	@Override
	public int compareTo(Hashtag o) {
		return o.count - this.count;
	}

	@Override
	public String toString() {
		return this.getAsJson(this);
	}

}
