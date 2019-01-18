package com.ats.rusawebapi.model.mst;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	private String catName;
	
	private String catCode;
	
	private String catDesc;
	
	private Date catAddDate;
	
	private Date catEditDate;
	
	private int catSortNo;
	
	private String catRemark;
	
	private int sectionId;
	
	private int userId;
	
	private int isActive;
	
	private int delStatus;
	
	//total 12 fields 17 Jan 2019
	
	@Transient
	Info info;
	

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
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

	public String getCatCode() {
		return catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public Date getCatAddDate() {
		return catAddDate;
	}

	public void setCatAddDate(Date catAddDate) {
		this.catAddDate = catAddDate;
	}

	public Date getCatEditDate() {
		return catEditDate;
	}

	public void setCatEditDate(Date catEditDate) {
		this.catEditDate = catEditDate;
	}

	public int getCatSortNo() {
		return catSortNo;
	}

	public void setCatSortNo(int catSortNo) {
		this.catSortNo = catSortNo;
	}

	public String getCatRemark() {
		return catRemark;
	}

	public void setCatRemark(String catRemark) {
		this.catRemark = catRemark;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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
		return "Category [catId=" + catId + ", catName=" + catName + ", catCode=" + catCode + ", catDesc=" + catDesc
				+ ", catAddDate=" + catAddDate + ", catEditDate=" + catEditDate + ", catSortNo=" + catSortNo
				+ ", catRemark=" + catRemark + ", sectionId=" + sectionId + ", userId=" + userId + ", isActive="
				+ isActive + ", delStatus=" + delStatus + ", info=" + info + "]";
	}
	
	
}
