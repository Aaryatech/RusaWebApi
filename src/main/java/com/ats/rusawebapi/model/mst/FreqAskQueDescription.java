package com.ats.rusawebapi.model.mst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_faq_description")
public class FreqAskQueDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "faq_desc_id")
	private int faqDescId;

	@Column(name = "faq_id")
	private int faqId;
	
	@Column(name = "language_id")
	private int languageId; 
	
	@Column(name = "cat_id")
	private int catId;
	
	@Column(name = "sub_cat_id")
	private int subCatId;
	
	@Column(name = "faq_que")
	private String faqQue;
	
	@Column(name = "faq_ans")
	private String faqAns;

	public int getFaqDescId() {
		return faqDescId;
	}

	public void setFaqDescId(int faqDescId) {
		this.faqDescId = faqDescId;
	}

	public int getFaqId() {
		return faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}
  
	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getFaqQue() {
		return faqQue;
	}

	public void setFaqQue(String faqQue) {
		this.faqQue = faqQue;
	}

	public String getFaqAns() {
		return faqAns;
	}

	public void setFaqAns(String faqAns) {
		this.faqAns = faqAns;
	}

	@Override
	public String toString() {
		return "FreqAskQueDescription [faqDescId=" + faqDescId + ", faqId=" + faqId + ", languageId=" + languageId
				+ ", catId=" + catId + ", subCatId=" + subCatId + ", faqQue=" + faqQue + ", faqAns=" + faqAns + "]";
	}
	 
	

}
