package com.ats.rusawebapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name = "t_newsblogs_description")
public class NewsBlogDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="newsblogs_desc_id")
	private int newsblogsDescId;
	
	@Column(name="newsblogs_id")
	private int newsblogsId;
	
	@Column(name="heading")
	private String heading;
	
	@Column(name="descriptions")
	private String descriptions;
	
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="page_meta_title")
	private String pageMetaTitle;
	
	@Column(name="page_meta_description")
	private String pageMetaDescription;
	
	@Column(name="page_meta_keyword")
	private String pageMetaKeyword;
	
	@Column(name="ex_date1")
	private String exDate1;
	
	
	@Column(name="ex_float1")
	private float exFloat1;
	
	@Column(name="ex_text1")
	private String exText1;
	
	@Column(name="date_transaction")
	private String dateTransaction;
	
	@Column(name="ex_int1")
	private int exInt1;
		
	@Column(name="ex_var1")
	private String exVar1;

	
	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getNewsblogsDescId() {
		return newsblogsDescId;
	}

	public void setNewsblogsDescId(int newsblogsDescId) {
		this.newsblogsDescId = newsblogsDescId;
	}

	public int getNewsblogsId() {
		return newsblogsId;
	}

	public void setNewsblogsId(int newsblogsId) {
		this.newsblogsId = newsblogsId;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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

	@Override
	public String toString() {
		return "NewsBlogDescription [newsblogsDescId=" + newsblogsDescId + ", newsblogsId=" + newsblogsId + ", heading="
				+ heading + ", descriptions=" + descriptions + ", languageId=" + languageId + ", pageId=" + pageId
				+ ", pageMetaTitle=" + pageMetaTitle + ", pageMetaDescription=" + pageMetaDescription
				+ ", pageMetaKeyword=" + pageMetaKeyword + ", exDate1=" + exDate1 + ", exFloat1=" + exFloat1
				+ ", exText1=" + exText1 + ", dateTransaction=" + dateTransaction + ", exInt1=" + exInt1 + ", exVar1="
				+ exVar1 + ", getPageId()=" + getPageId() + ", getNewsblogsDescId()=" + getNewsblogsDescId()
				+ ", getNewsblogsId()=" + getNewsblogsId() + ", getHeading()=" + getHeading() + ", getDescriptions()="
				+ getDescriptions() + ", getLanguageId()=" + getLanguageId() + ", getPageMetaTitle()="
				+ getPageMetaTitle() + ", getPageMetaDescription()=" + getPageMetaDescription()
				+ ", getPageMetaKeyword()=" + getPageMetaKeyword() + ", getExDate1()=" + getExDate1()
				+ ", getExFloat1()=" + getExFloat1() + ", getExText1()=" + getExText1() + ", getDateTransaction()="
				+ getDateTransaction() + ", getExInt1()=" + getExInt1() + ", getExVar1()=" + getExVar1()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
