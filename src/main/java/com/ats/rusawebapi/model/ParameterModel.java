package com.ats.rusawebapi.model;

public class ParameterModel {
	
	private int regId;
	private String userOtp;
	private String uuid;

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public String getUserOtp() {
		return userOtp;
	}

	public void setUserOtp(String userOtp) {
		this.userOtp = userOtp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "ParameterModel [regId=" + regId + ", userOtp=" + userOtp + ", uuid=" + uuid + "]";
	}
	
	
	

}
