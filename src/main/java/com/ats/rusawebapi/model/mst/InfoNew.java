package com.ats.rusawebapi.model.mst;

public class InfoNew {
	
	private boolean isError;
	
	private String msg;
	
	private String retmsg;
	
	
	
	

	public String getRetmsg() {
		return retmsg;
	}

	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InfoNew [isError=" + isError + ", msg=" + msg + ", retmsg=" + retmsg + "]";
	}

 

}
