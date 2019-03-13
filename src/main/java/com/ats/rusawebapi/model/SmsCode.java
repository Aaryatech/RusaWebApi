package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_sms_code")
public class SmsCode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sms_code_id")
	private int smsCodeId;
	
	@Column(name="user_uuid")
	private String userUuid;
	
	@Column(name="sms_code")
	private String smsCode;
	
	@Column(name="date_sent")
	private String dateSent;
	
	@Column(name="sms_type")
	private int smsType;

	public int getSmsCodeId() {
		return smsCodeId;
	}

	public void setSmsCodeId(int smsCodeId) {
		this.smsCodeId = smsCodeId;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getDateSent() {
		return dateSent;
	}

	public void setDateSent(String dateSent) {
		this.dateSent = dateSent;
	}

	public int getSmsType() {
		return smsType;
	}

	public void setSmsType(int smsType) {
		this.smsType = smsType;
	}

	@Override
	public String toString() {
		return "smsCode [smsCodeId=" + smsCodeId + ", userUuid=" + userUuid + ", smsCode=" + smsCode + ", dateSent="
				+ dateSent + ", smsType=" + smsType + "]";
	}

	
	
}
