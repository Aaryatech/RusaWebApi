package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubCategoryList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="sub_cat_name")
	private String subCatName;
	
	@Column(name="sub_cat_desc")
	private String subCatDesc;
	
	@Column(name="sub_slug_name")
	private String subSlugName;
	    
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="parent_id")
	private int parentId;
	
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="sub_sort_no")
	private int subSortNo;

	@Column(name="external_url")
	private String externalUrl;
	
	@Column(name="external_url_target")
	private String externalUrlTarget;
	
	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getSubCatDesc() {
		return subCatDesc;
	}

	public void setSubCatDesc(String subCatDesc) {
		this.subCatDesc = subCatDesc;
	}

	public String getSubSlugName() {
		return subSlugName;
	}

	public void setSubSlugName(String subSlugName) {
		this.subSlugName = subSlugName;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getSubSortNo() {
		return subSortNo;
	}

	public void setSubSortNo(int subSortNo) {
		this.subSortNo = subSortNo;
	}

	public String getExternalUrl() {
		return externalUrl;
	}

	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}

	public String getExternalUrlTarget() {
		return externalUrlTarget;
	}

	public void setExternalUrlTarget(String externalUrlTarget) {
		this.externalUrlTarget = externalUrlTarget;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "SubCategoryList [subCatId=" + subCatId + ", subCatName=" + subCatName + ", subCatDesc=" + subCatDesc
				+ ", subSlugName=" + subSlugName + ", pageId=" + pageId + ", parentId=" + parentId + ", sectionId="
				+ sectionId + ", subSortNo=" + subSortNo + ", externalUrl=" + externalUrl + ", externalUrlTarget="
				+ externalUrlTarget + "]";
	}
	
	
	
}
