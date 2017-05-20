package com.scratchpad.dataformat;

public class MsgVO implements Comparable<MsgVO>{

	private String msg;
	
	private int version;

	public MsgVO(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int compareTo(MsgVO o) {
		return o.getVersion() - this.getVersion();
	}
	
	@Override
	public String toString() {
		return  msg;
	}

}
