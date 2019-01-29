package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_section_description")
public class SectionDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sec_desc_id")
	private int secDescId;
	
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="section_name")
	private String sectionName;
	
	@Column(name="section_desc")
	private String sectionDesc;
	
	@Column(name="ex_text")
	private String exText;

	public int getSecDescId() {
		return secDescId;
	}

	public void setSecDescId(int secDescId) {
		this.secDescId = secDescId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionDesc() {
		return sectionDesc;
	}

	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}

	public String getExText() {
		return exText;
	}

	public void setExText(String exText) {
		this.exText = exText;
	}

	@Override
	public String toString() {
		return "SectionDescription [secDescId=" + secDescId + ", sectionId=" + sectionId + ", languageId=" + languageId
				+ ", sectionName=" + sectionName + ", sectionDesc=" + sectionDesc + ", exText=" + exText + "]";
	}
	 
	

}
