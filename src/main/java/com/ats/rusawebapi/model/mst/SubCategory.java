package com.ats.rusawebapi.model.mst;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_sub_category")
public class SubCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_cat_id")
	
	private int subCatId;
	
	private int catId;
	
	private String subCatName;
	
	private String subCatCode;
	
	private String subCatDesc;
	
	private Date SubCatAddDate;
	
	private Date subCatEditDate;
	
	private int subCatSortNo;
	
	private String subCatRemark;
	
	private int sectionId;
	
	private int userId;
	
	private int isActive;
	
	private int delStatus;
	
	//total 13 fields 17 Jan 2019

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getSubCatCode() {
		return subCatCode;
	}

	public void setSubCatCode(String subCatCode) {
		this.subCatCode = subCatCode;
	}

	public String getSubCatDesc() {
		return subCatDesc;
	}

	public void setSubCatDesc(String subCatDesc) {
		this.subCatDesc = subCatDesc;
	}

	public Date getSubCatAddDate() {
		return SubCatAddDate;
	}

	public void setSubCatAddDate(Date subCatAddDate) {
		SubCatAddDate = subCatAddDate;
	}

	public Date getSubCatEditDate() {
		return subCatEditDate;
	}

	public void setSubCatEditDate(Date subCatEditDate) {
		this.subCatEditDate = subCatEditDate;
	}

	public int getSubCatSortNo() {
		return subCatSortNo;
	}

	public void setSubCatSortNo(int subCatSortNo) {
		this.subCatSortNo = subCatSortNo;
	}

	public String getSubCatRemark() {
		return subCatRemark;
	}

	public void setSubCatRemark(String subCatRemark) {
		this.subCatRemark = subCatRemark;
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
		return "SubCategory [subCatId=" + subCatId + ", catId=" + catId + ", subCatName=" + subCatName + ", subCatCode="
				+ subCatCode + ", subCatDesc=" + subCatDesc + ", SubCatAddDate=" + SubCatAddDate + ", subCatEditDate="
				+ subCatEditDate + ", subCatSortNo=" + subCatSortNo + ", subCatRemark=" + subCatRemark + ", sectionId="
				+ sectionId + ", userId=" + userId + ", isActive=" + isActive + ", delStatus=" + delStatus + "]";
	}
	
	

}
