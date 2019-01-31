package com.ats.rusawebapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_cms_pages")
public class CMSPages {
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
	private String addDate;
	
	@Column(name="edit_date")
	private String editDate;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
	@Column(name="edit_by_user_id")
	private int editByUserId;

	@Transient
	List<CMSPageDescription> detailList;
	
	
	public List<CMSPageDescription> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<CMSPageDescription> detailList) {
		this.detailList = detailList;
	}

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

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
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

	@Override
	public String toString() {
		return "CMSPages [cmsPageId=" + cmsPageId + ", pageId=" + pageId + ", parentMenu=" + parentMenu + ", pageOrder="
				+ pageOrder + ", featuredImage=" + featuredImage + ", featuredImageAlignment=" + featuredImageAlignment
				+ ", downloadPdf=" + downloadPdf + ", isActive=" + isActive + ", delStatus=" + delStatus + ", addDate="
				+ addDate + ", editDate=" + editDate + ", addedByUserId=" + addedByUserId + ", editByUserId="
				+ editByUserId + ", detailList=" + detailList + ", getDetailList()=" + getDetailList()
				+ ", getCmsPageId()=" + getCmsPageId() + ", getPageId()=" + getPageId() + ", getParentMenu()="
				+ getParentMenu() + ", getPageOrder()=" + getPageOrder() + ", getFeaturedImage()=" + getFeaturedImage()
				+ ", getFeaturedImageAlignment()=" + getFeaturedImageAlignment() + ", getDownloadPdf()="
				+ getDownloadPdf() + ", getIsActive()=" + getIsActive() + ", getDelStatus()=" + getDelStatus()
				+ ", getAddDate()=" + getAddDate() + ", getEditDate()=" + getEditDate() + ", getAddedByUserId()="
				+ getAddedByUserId() + ", getEditByUserId()=" + getEditByUserId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
