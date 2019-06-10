package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_university")
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uni_id")
	private int uniId;
	
	@Column(name="uni_name")
	private String uniName;
	
	@Column(name="del_status")
	private int delStatus;

	public int getUniId() {
		return uniId;
	}

	public void setUniId(int uniId) {
		this.uniId = uniId;
	}

	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "University [uniId=" + uniId + ", uniName=" + uniName + ", delStatus=" + delStatus + "]";
	}
	
	

}
