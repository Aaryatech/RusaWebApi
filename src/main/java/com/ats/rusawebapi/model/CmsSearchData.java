package com.ats.rusawebapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CmsSearchData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cms_page_id")
	private int cmsPageId;

	@Column(name = "module_id")
	private int moduleId;
	
	@Column(name = "heading")
	private String heading; 
	
	@Column(name = "page_desc")
	private String pageDesc;
	
	@Column(name = "add_date")
	private Date addDate;
	
	@Column(name = "edit_date")
	private Date editDate;
	
	@Column(name = "page_name")
	private String pageName; 
	
	@Column(name = "page_slug")
	private String pageSlug;

	
	public int getCmsPageId() {
		return cmsPageId;
	}

	public void setCmsPageId(int cmsPageId) {
		this.cmsPageId = cmsPageId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getPageDesc() {
		return pageDesc;
	}

	public void setPageDesc(String pageDesc) {
		this.pageDesc = pageDesc;
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

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageSlug() {
		return pageSlug;
	}

	public void setPageSlug(String pageSlug) {
		this.pageSlug = pageSlug;
	}

	@Override
	public String toString() {
		return "CmsSearchData [cmsPageId=" + cmsPageId + ", moduleId=" + moduleId + ", heading=" + heading
				+ ", pageDesc=" + pageDesc + ", addDate=" + addDate + ", editDate=" + editDate + ", pageName="
				+ pageName + ", pageSlug=" + pageSlug + "]";
	}
	
	

}
