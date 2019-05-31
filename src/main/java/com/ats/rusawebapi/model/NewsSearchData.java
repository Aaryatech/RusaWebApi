package com.ats.rusawebapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NewsSearchData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "newsblogs_id")
	private int newsblogsId;

	@Column(name = "module_id")
	private int moduleId;
	
	@Column(name = "heading")
	private String heading; 
	
	@Column(name = "descriptions")
	private String descriptions;
	
	@Column(name = "add_date")
	private Date addDate;
	
	@Column(name = "edit_date")
	private Date editDate;
	
	@Column(name = "page_name")
	private String pageName; 
	
	@Column(name = "page_slug")
	private String pageSlug;
	
	@Column(name = "featured_image")
	private String featuredImage;
	
	public int getNewsblogsId() {
		return newsblogsId;
	}

	public void setNewsblogsId(int newsblogsId) {
		this.newsblogsId = newsblogsId;
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

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

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

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	@Override
	public String toString() {
		return "NewsSearchData [newsblogsId=" + newsblogsId + ", moduleId=" + moduleId + ", heading=" + heading
				+ ", descriptions=" + descriptions + ", addDate=" + addDate + ", editDate=" + editDate + ", pageName="
				+ pageName + ", pageSlug=" + pageSlug + ", featuredImage=" + featuredImage + "]";
	}
	
	
	
}
