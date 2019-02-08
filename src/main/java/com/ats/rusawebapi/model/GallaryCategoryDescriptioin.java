package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_gallery_cat_description")
public class GallaryCategoryDescriptioin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gallery_cat_desc_id")
	private int galleryCatDescId;
	
	@Column(name="gallery_cat_id")
	private int galleryCatId;
	
	@Column(name="cat_name")
	private String cateName;
	
	@Column(name="cat_desc")
	private String catDesc;
	
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_date1")
	private String exDate1;
	
	@Column(name="ex_float1")
	private float exFloat1;
	
	@Column(name="ex_text1")
	private String exText1;

	public int getGalleryCatDescId() {
		return galleryCatDescId;
	}

	public void setGalleryCatDescId(int galleryCatDescId) {
		this.galleryCatDescId = galleryCatDescId;
	}

	public int getGalleryCatId() {
		return galleryCatId;
	}

	public void setGalleryCatId(int galleryCatId) {
		this.galleryCatId = galleryCatId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
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

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}
 

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExDate1() {
		return exDate1;
	}

	public void setExDate1(String exDate1) {
		this.exDate1 = exDate1;
	}

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public String getExText1() {
		return exText1;
	}

	public void setExText1(String exText1) {
		this.exText1 = exText1;
	}

	@Override
	public String toString() {
		return "GallaryCategoryDescriptioin [galleryCatDescId=" + galleryCatDescId + ", galleryCatId=" + galleryCatId
				+ ", cateName=" + cateName + ", catDesc=" + catDesc + ", languageId=" + languageId + ", exInt1="
				+ exInt1 + ", exVar1=" + exVar1 + ", exDate1=" + exDate1 + ", exFloat1=" + exFloat1 + ", exText1="
				+ exText1 + "]";
	}
	
	

}
