package com.ats.rusawebapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class SectionTree {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="section_name")
	private String sectionName;
	
	@Column(name="section_slugname")
	private String sectionSlugname;
	  
	@Column(name="section_desc")
	private String sectionDesc;
	
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="sec_sort_no")
	private int secSortNo;
	
	@Column(name="external_url")
	private String externalUrl;
	
	@Column(name="external_url_target")
	private String externalUrlTarget;
	
	@Transient
	List<CategoryList> catList;

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionSlugname() {
		return sectionSlugname;
	}

	public void setSectionSlugname(String sectionSlugname) {
		this.sectionSlugname = sectionSlugname;
	}

	public String getSectionDesc() {
		return sectionDesc;
	}

	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getSecSortNo() {
		return secSortNo;
	}

	public void setSecSortNo(int secSortNo) {
		this.secSortNo = secSortNo;
	}

	public List<CategoryList> getCatList() {
		return catList;
	}

	public void setCatList(List<CategoryList> catList) {
		this.catList = catList;
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

	@Override
	public String toString() {
		return "SectionTree [sectionId=" + sectionId + ", sectionName=" + sectionName + ", sectionSlugname="
				+ sectionSlugname + ", sectionDesc=" + sectionDesc + ", pageId=" + pageId + ", secSortNo=" + secSortNo
				+ ", externalUrl=" + externalUrl + ", externalUrlTarget=" + externalUrlTarget + ", catList=" + catList
				+ "]";
	}
 
}
