package com.ats.rusawebapi.model.mst;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_faq")
public class FreqAskQue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "faq_id")
	private int faqId;

	private int catId;

	private int subCatId;

	private String faqQue;

	private String faqAns;

	private int faqSortNo;

	private String faqRemark;

	private Date faqAddDate;

	private Date faqEditDate;

	private Date faqDate;

	private int userId;

	private int isActive;

	private int delStatus;

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

	public Date getFaqAddDate() {
		return faqAddDate;
	}

	public void setFaqAddDate(Date faqAddDate) {
		this.faqAddDate = faqAddDate;
	}

	public Date getFaqEditDate() {
		return faqEditDate;
	}

	public void setFaqEditDate(Date faqEditDate) {
		this.faqEditDate = faqEditDate;
	}

	public Date getFaqDate() {
		return faqDate;
	}

	public void setFaqDate(Date faqDate) {
		this.faqDate = faqDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "FreqAskQue [faqId=" + faqId + ", catId=" + catId + ", subCatId=" + subCatId + ", faqQue=" + faqQue
				+ ", faqAns=" + faqAns + ", faqSortNo=" + faqSortNo + ", faqRemark=" + faqRemark + ", faqAddDate="
				+ faqAddDate + ", faqEditDate=" + faqEditDate + ", faqDate=" + faqDate + ", userId=" + userId
				+ ", isActive=" + isActive + ", delStatus=" + delStatus + "]";
	}
	
	

}
