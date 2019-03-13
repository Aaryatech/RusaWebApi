package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_apptoken")
public class AppToken {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="apptoken_id")
	private int apptokenId;
	
	@Column(name="device_name")
	private String deviceName;
	
	@Column(name="mac_id")
	private String macId;
	
	@Column(name="token")
	private String token;
	
	@Column(name="register_id")
	private int registerId;
	
	@Column(name="add_date")
	private String addDate;
	
	@Column(name="extra_int1")
	private int extraInt1;
	
	@Column(name="extra_int2")
	private int extraInt2;
	
	@Column(name="extra_var1")
	private String extraVar1;
	
	@Column(name="extra_var2")
	private String extraVar2;

	public int getApptokenId() {
		return apptokenId;
	}

	public void setApptokenId(int apptokenId) {
		this.apptokenId = apptokenId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public int getExtraInt1() {
		return extraInt1;
	}

	public void setExtraInt1(int extraInt1) {
		this.extraInt1 = extraInt1;
	}

	public int getExtraInt2() {
		return extraInt2;
	}

	public void setExtraInt2(int extraInt2) {
		this.extraInt2 = extraInt2;
	}

	public String getExtraVar1() {
		return extraVar1;
	}

	public void setExtraVar1(String extraVar1) {
		this.extraVar1 = extraVar1;
	}

	public String getExtraVar2() {
		return extraVar2;
	}

	public void setExtraVar2(String extraVar2) {
		this.extraVar2 = extraVar2;
	}

	@Override
	public String toString() {
		return "AppToken [apptokenId=" + apptokenId + ", deviceName=" + deviceName + ", macId=" + macId + ", token="
				+ token + ", registerId=" + registerId + ", addDate=" + addDate + ", extraInt1=" + extraInt1
				+ ", extraInt2=" + extraInt2 + ", extraVar1=" + extraVar1 + ", extraVar2=" + extraVar2 + "]";
	}
	
	
	
}
