package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PageMetaData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="page_name")
	private String pagName;
	
	@Column(name="page_meta_title")
	private String pageMetaTitle;
	
	@Column(name="page_meta_description")
	private String pageMetaDescription;
	
	@Column(name="page_meta_keyword")
	private String pageMetaKeyword;

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getPagName() {
		return pagName;
	}

	public void setPagName(String pagName) {
		this.pagName = pagName;
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

	@Override
	public String toString() {
		return "PageMetaData [pageId=" + pageId + ", pagName=" + pagName + ", pageMetaTitle=" + pageMetaTitle
				+ ", pageMetaDescription=" + pageMetaDescription + ", pageMetaKeyword=" + pageMetaKeyword + "]";
	}
	
	
	

}
