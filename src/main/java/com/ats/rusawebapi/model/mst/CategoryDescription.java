package com.ats.rusawebapi.model.mst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_category_description")
public class CategoryDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_desc_id")
	private int catDescId;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="cat_desc")
	private String catDesc;
	
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="ex_var1")
	private String exVar1;

	public int getCatDescId() {
		return catDescId;
	}

	public void setCatDescId(int catDescId) {
		this.catDescId = catDescId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	@Override
	public String toString() {
		return "CategoryDescription [catDescId=" + catDescId + ", catId=" + catId + ", catName=" + catName
				+ ", catDesc=" + catDesc + ", languageId=" + languageId + ", exVar1=" + exVar1 + "]";
	}
	
	

}
