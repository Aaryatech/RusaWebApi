package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_reg_prev_record")
public class PreviousRegRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prev_id")
	private int prevId;
	
	@Column(name="reg_id")
	private int regId;
	
	@Column(name="record")
	private String record;
	
	@Column(name="last_update")
	private String lastUpdate;
	
	@Column(name="extra_var1")
	private String extraVar1;
	
	@Transient
	private boolean isError;
	
	@Transient
	private String message;

	public int getPrevId() {
		return prevId;
	}

	public void setPrevId(int prevId) {
		this.prevId = prevId;
	}
 

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getExtraVar1() {
		return extraVar1;
	}

	public void setExtraVar1(String extraVar1) {
		this.extraVar1 = extraVar1;
	}

	 

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PreviousRegRecord [prevId=" + prevId + ", regId=" + regId + ", record=" + record + ", lastUpdate="
				+ lastUpdate + ", extraVar1=" + extraVar1 + ", isError=" + isError + ", message=" + message + "]";
	}
	
	
 

}
