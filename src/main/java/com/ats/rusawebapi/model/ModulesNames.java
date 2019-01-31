package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_modules_name")
public class ModulesNames {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="multiple_repeat")
	private String multipleRepeat;

	@Column(name="status")
	private int status;

	@Column(name="tales_name")
	private String talesName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMultipleRepeat() {
		return multipleRepeat;
	}

	public void setMultipleRepeat(String multipleRepeat) {
		this.multipleRepeat = multipleRepeat;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTalesName() {
		return talesName;
	}

	public void setTalesName(String talesName) {
		this.talesName = talesName;
	}

	@Override
	public String toString() {
		return "ModulesNames [id=" + id + ", name=" + name + ", multipleRepeat=" + multipleRepeat + ", status=" + status
				+ ", talesName=" + talesName + "]";
	}

	
	
}
