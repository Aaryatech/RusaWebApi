package com.ats.rusawebapi.model.frontend;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FaqContent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "faq_id")
	private int faqId;

	@Column(name = "cat_id")
	private int catId;
	
	@Column(name = "page_id")
	private int pageId; 
	
	@Column(name = "section_id")
	private int sectionId;
	
	@Column(name = "faq_sort_no")
	private int faqSortNo;
	
	@Column(name = "faq_remark")
	private String faqRemark;
	
	@Column(name = "add_date")
	private Date addDate;
	
	@Column(name = "edit_date")
	private Date editDate;
	
	@Column(name = "added_by_user_id")
	private int addedByUserId;
	
	@Column(name = "edit_by_user_id")
	private int editByUserId;
	
	@Column(name = "is_active")
	private int isActive;
	
	@Column(name = "delStatus")
	private int delStatus;
	
	@Column(name = "faq_que")
	private String faqQue;
	
	@Column(name = "faq_ans")
	private String faqAns;
	
	@Column(name = "language_id")
	private int languageId;

	public int getFaqId() {
		return faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getFaqSortNo() {
		return faqSortNo;
	}

	public void setFaqSortNo(int faqSortNo) {
		this.faqSortNo = faqSortNo;
	}

	public String getFaqRemark() {
		return faqRemark;
	}

	public void setFaqRemark(String faqRemark) {
		this.faqRemark = faqRemark;
	}
	@JsonFormat(locale = "ENGLISH", timezone = "Asia/Kolkata", pattern = "MMMM d, yyyy")
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	@JsonFormat(locale = "ENGLISH", timezone = "Asia/Kolkata", pattern = "MMMM d, yyyy")
	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public int getAddedByUserId() {
		return addedByUserId;
	}

	public void setAddedByUserId(int addedByUserId) {
		this.addedByUserId = addedByUserId;
	}

	public int getEditByUserId() {
		return editByUserId;
	}

	public void setEditByUserId(int editByUserId) {
		this.editByUserId = editByUserId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "FaqContent [faqId=" + faqId + ", catId=" + catId + ", pageId=" + pageId + ", sectionId=" + sectionId
				+ ", faqSortNo=" + faqSortNo + ", faqRemark=" + faqRemark + ", addDate=" + addDate + ", editDate="
				+ editDate + ", addedByUserId=" + addedByUserId + ", editByUserId=" + editByUserId + ", isActive="
				+ isActive + ", delStatus=" + delStatus + ", faqQue=" + faqQue + ", faqAns=" + faqAns + ", languageId="
				+ languageId + "]";
	} 
	
	

}
