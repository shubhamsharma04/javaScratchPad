package com.scratchpad.dataformat;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author opensam
 *
 */
public class MsgObject implements Comparable<MsgObject>{
	
	private long id;
	
	@JsonProperty("msg")
	private String msg;
	
	@JsonProperty("pId")
	private int pId;
	
	@JsonProperty("proposedId")
	private int proposedId;
	
	@JsonProperty("agreedId")
	private int agreedId;
	
	@JsonProperty("isDeliverable")
	private boolean isDeliverable;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getProposedId() {
		return proposedId;
	}

	public void setProposedId(int proposedId) {
		this.proposedId = proposedId;
	}

	public int getAgreedId() {
		return agreedId;
	}

	public void setAgreedId(int agreedId) {
		this.agreedId = agreedId;
	}

	public boolean isDeliverable() {
		return isDeliverable;
	}

	public void setDeliverable(boolean isDeliverable) {
		this.isDeliverable = isDeliverable;
	}
	
	@JsonIgnoreProperties
	public String getAsJson(MsgObject msgObject) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			result = mapper.writeValueAsString(msgObject);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agreedId;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isDeliverable ? 1231 : 1237);
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + pId;
		result = prime * result + proposedId;
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
		MsgObject other = (MsgObject) obj;
		if (id != other.id)
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}

	@Override
	public int compareTo(MsgObject o) {
		int result = 0;
		if (this.getAgreedId() == o.getAgreedId()) {
			result = this.getpId() - o.getpId();
		} else {
			result = this.getAgreedId() - o.getAgreedId();
		}
		return result;
	}

}
