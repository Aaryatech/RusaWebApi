package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_cms_pages_description")
public class CMSPageDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="page_desc_id")
	private int pageDescId;
	
	@Column(name="cms_page_id")
	private int cmsPageId;
	
	@Column(name="heading")
	private String heading;
	
	@Column(name="smallheading")
	private String smallheading;
	
	@Column(name="page_desc")
	private String pageDesc;
	
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="page_meta_title")
	private String pageMetaTitle;
	
	@Column(name="page_meta_description")
	private String pageMetaDescription;
	
	@Column(name="page_meta_keyword")
	private String pageMetaKeyword;
	
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
	
	@Column(name="date_transaction")
	private String dateTransaction;

	public int getPageDescId() {
		return pageDescId;
	}

	public void setPageDescId(int pageDescId) {
		this.pageDescId = pageDescId;
	}

	public int getCmsPageId() {
		return cmsPageId;
	}

	public void setCmsPageId(int cmsPageId) {
		this.cmsPageId = cmsPageId;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getSmallheading() {
		return smallheading;
	}

	public void setSmallheading(String smallheading) {
		this.smallheading = smallheading;
	}

	public String getPageDesc() {
		return pageDesc;
	}

	public void setPageDesc(String pageDesc) {
		this.pageDesc = pageDesc;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getPageMetaTitle() {
		return pageMetaTitle;
	}

	public void setPageMetaTitle(String pageMetaTitle) {
		this.pageMetaTitle = pageMetaTitle;
	}

	public String getPageMetaDescription() {
		return pageMetaDescription;
	}

	public void setPageMetaDescription(String pageMetaDescription) {
		this.pageMetaDescription = pageMetaDescription;
	}

	public String getPageMetaKeyword() {
		return pageMetaKeyword;
	}

	public void setPageMetaKeyword(String pageMetaKeyword) {
		this.pageMetaKeyword = pageMetaKeyword;
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

	public String getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(String dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	@Override
	public String toString() {
		return "CMSPageDescription [pageDescId=" + pageDescId + ", cmsPageId=" + cmsPageId + ", heading=" + heading
				+ ", smallheading=" + smallheading + ", pageDesc=" + pageDesc + ", languageId=" + languageId
				+ ", pageMetaTitle=" + pageMetaTitle + ", pageMetaDescription=" + pageMetaDescription
				+ ", pageMetaKeyword=" + pageMetaKeyword + ", exInt1=" + exInt1 + ", exVar1=" + exVar1 + ", exDate1="
				+ exDate1 + ", exFloat1=" + exFloat1 + ", exText1=" + exText1 + ", dateTransaction=" + dateTransaction
				+ ", getPageDescId()=" + getPageDescId() + ", getCmsPageId()=" + getCmsPageId() + ", getHeading()="
				+ getHeading() + ", getSmallheading()=" + getSmallheading() + ", getPageDesc()=" + getPageDesc()
				+ ", getLanguageId()=" + getLanguageId() + ", getPageMetaTitle()=" + getPageMetaTitle()
				+ ", getPageMetaDescription()=" + getPageMetaDescription() + ", getPageMetaKeyword()="
				+ getPageMetaKeyword() + ", getExInt1()=" + getExInt1() + ", getExVar1()=" + getExVar1()
				+ ", getExDate1()=" + getExDate1() + ", getExFloat1()=" + getExFloat1() + ", getExText1()="
				+ getExText1() + ", getDateTransaction()=" + getDateTransaction() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
