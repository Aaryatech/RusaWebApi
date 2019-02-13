package com.ats.rusawebapi.model.frontend;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CmsContent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cms_page_id")
	private int cmsPageId;
	
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="parent_menu")
	private int parentMenu;
	
	@Column(name="page_order")
	private int pageOrder;
	
	@Column(name="featured_image")
	private String featuredImage;
	
	@Column(name="featured_image_alignment")
	private String featuredImageAlignment;
	
	@Column(name="download_pdf")
	private String downloadPdf;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="add_date")
	private Date addDate;
	
	@Column(name="edit_date")
	private Date editDate;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
	@Column(name="edit_by_user_id")
	private int editByUserId;
	
	@Column(name="heading")
	private String heading;
	
	@Column(name="smallheading")
	private String smallheading;
	
	@Column(name="page_desc")
	private String pageDesc;
	
	@Column(name="language_id")
	private int languageId;

	public int getCmsPageId() {
		return cmsPageId;
	}

	public void setCmsPageId(int cmsPageId) {
		this.cmsPageId = cmsPageId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(int parentMenu) {
		this.parentMenu = parentMenu;
	}

	public int getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(int pageOrder) {
		this.pageOrder = pageOrder;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	public String getFeaturedImageAlignment() {
		return featuredImageAlignment;
	}

	public void setFeaturedImageAlignment(String featuredImageAlignment) {
		this.featuredImageAlignment = featuredImageAlignment;
	}

	public String getDownloadPdf() {
		return downloadPdf;
	}

	public void setDownloadPdf(String downloadPdf) {
		this.downloadPdf = downloadPdf;
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

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getSmallheading() {
		return smallheading;
	}

	public void setSmallheading(String smallheading) {
		this.smallheading = smallheading;
	}

	public String getPageDesc() {
		return pageDesc;
	}

	public void setPageDesc(String pageDesc) {
		this.pageDesc = pageDesc;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "CmsContent [cmsPageId=" + cmsPageId + ", pageId=" + pageId + ", parentMenu=" + parentMenu
				+ ", pageOrder=" + pageOrder + ", featuredImage=" + featuredImage + ", featuredImageAlignment="
				+ featuredImageAlignment + ", downloadPdf=" + downloadPdf + ", isActive=" + isActive + ", delStatus="
				+ delStatus + ", addDate=" + addDate + ", editDate=" + editDate + ", addedByUserId=" + addedByUserId
				+ ", editByUserId=" + editByUserId + ", heading=" + heading + ", smallheading=" + smallheading
				+ ", pageDesc=" + pageDesc + ", languageId=" + languageId + "]";
	}
	
	

}
