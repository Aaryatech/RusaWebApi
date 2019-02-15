package com.ats.rusawebapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CategoryList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="cat_desc")
	private String catDesc;
	
	@Column(name="slug_name")
	private String slugName;
	    
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="parent_id")
	private int parentId;
	
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="sub_cat_count")
	private int subCatCount;
	
	@Column(name="cat_sort_no")
	private int catSortNo;

	@Column(name="external_url")
	private String externalUrl;
	
	@Column(name="external_url_target")
	private String externalUrlTarget;
	
	@Transient
	List<SubCategoryList> subCatList;

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

	public String getSlugName() {
		return slugName;
	}

	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getCatSortNo() {
		return catSortNo;
	}

	public void setCatSortNo(int catSortNo) {
		this.catSortNo = catSortNo;
	}

	public List<SubCategoryList> getSubCatList() {
		return subCatList;
	}

	public void setSubCatList(List<SubCategoryList> subCatList) {
		this.subCatList = subCatList;
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getSubCatCount() {
		return subCatCount;
	}

	public void setSubCatCount(int subCatCount) {
		this.subCatCount = subCatCount;
	}

	@Override
	public String toString() {
		return "CategoryList [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc + ", slugName="
				+ slugName + ", pageId=" + pageId + ", parentId=" + parentId + ", sectionId=" + sectionId
				+ ", subCatCount=" + subCatCount + ", catSortNo=" + catSortNo + ", externalUrl=" + externalUrl
				+ ", externalUrlTarget=" + externalUrlTarget + ", subCatList=" + subCatList + "]";
	}
	
	
}
