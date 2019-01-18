package com.ats.rusawebapi.tx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "t_gallery_header")
public class Galleryheader {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gallery_header_id")
	private int galleryHeaderId;
	
	@Column(name="gallery_title")
	private String galleryTitle;
	
	@Column(name="gallery_add_date")
	private String galleryAddDate;
	
	@Column(name="gallery_edit_date")
	private String galleryEditDate;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="gallery_header_description")
	private String galleryHeaderDescription;
	
	@Column(name="gallery_sort_no")
	private String gallerySortNo;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;

	
	@Transient
	List<GalleryDetail> detailList;
	
	
	
	
	
	
	

	public int getGalleryHeaderId() {
		return galleryHeaderId;
	}

	public void setGalleryHeaderId(int galleryHeaderId) {
		this.galleryHeaderId = galleryHeaderId;
	}

	public String getGalleryTitle() {
		return galleryTitle;
	}

	public void setGalleryTitle(String galleryTitle) {
		this.galleryTitle = galleryTitle;
	}

	public String getGalleryAddDate() {
		return galleryAddDate;
	}

	public void setGalleryAddDate(String galleryAddDate) {
		this.galleryAddDate = galleryAddDate;
	}

	public String getGalleryEditDate() {
		return galleryEditDate;
	}

	public void setGalleryEditDate(String galleryEditDate) {
		this.galleryEditDate = galleryEditDate;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getGalleryHeaderDescription() {
		return galleryHeaderDescription;
	}

	public void setGalleryHeaderDescription(String galleryHeaderDescription) {
		this.galleryHeaderDescription = galleryHeaderDescription;
	}

	public String getGallerySortNo() {
		return gallerySortNo;
	}

	public void setGallerySortNo(String gallerySortNo) {
		this.gallerySortNo = gallerySortNo;
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

	public List<GalleryDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<GalleryDetail> detailList) {
		this.detailList = detailList;
	}

	@Override
	public String toString() {
		return "Galleryheader [galleryHeaderId=" + galleryHeaderId + ", galleryTitle=" + galleryTitle
				+ ", galleryAddDate=" + galleryAddDate + ", galleryEditDate=" + galleryEditDate + ", catId=" + catId
				+ ", subCatId=" + subCatId + ", galleryHeaderDescription=" + galleryHeaderDescription
				+ ", gallerySortNo=" + gallerySortNo + ", userId=" + userId + ", isActive=" + isActive + ", delStatus="
				+ delStatus + ", detailList=" + detailList + ", getGalleryHeaderId()=" + getGalleryHeaderId()
				+ ", getGalleryTitle()=" + getGalleryTitle() + ", getGalleryAddDate()=" + getGalleryAddDate()
				+ ", getGalleryEditDate()=" + getGalleryEditDate() + ", getCatId()=" + getCatId() + ", getSubCatId()="
				+ getSubCatId() + ", getGalleryHeaderDescription()=" + getGalleryHeaderDescription()
				+ ", getGallerySortNo()=" + getGallerySortNo() + ", getUserId()=" + getUserId() + ", getIsActive()="
				+ getIsActive() + ", getDelStatus()=" + getDelStatus() + ", getDetailList()=" + getDetailList()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
	
	
}
