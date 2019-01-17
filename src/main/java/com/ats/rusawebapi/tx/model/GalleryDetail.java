package com.ats.rusawebapi.tx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_gallery_detail")
public class GalleryDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gallery_detail_id")
	private int galleryDetailId;
	
	@Column(name="photo_name")
	private String photoName;
	
	@Column(name="photo_caption")
	private String photoCaption;
	
	@Column(name="photo_description")
	private String photoDescription;
	
	@Column(name="gallery_head_id")
	private int galleryHeadId;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="date")
	private String date;

	

	public int getGalleryDetailId() {
		return galleryDetailId;
	}

	public void setGalleryDetailId(int galleryDetailId) {
		this.galleryDetailId = galleryDetailId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoCaption() {
		return photoCaption;
	}

	public void setPhotoCaption(String photoCaption) {
		this.photoCaption = photoCaption;
	}

	public String getPhotoDescription() {
		return photoDescription;
	}

	public void setPhotoDescription(String photoDescription) {
		this.photoDescription = photoDescription;
	}

	public int getGalleryHeadId() {
		return galleryHeadId;
	}

	public void setGalleryHeadId(int galleryHeadId) {
		this.galleryHeadId = galleryHeadId;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GalleryDetail [galleryDetailId=" + galleryDetailId + ", photoName=" + photoName + ", photoCaption="
				+ photoCaption + ", photoDescription=" + photoDescription + ", galleryHeadId=" + galleryHeadId
				+ ", isActive=" + isActive + ", delStatus=" + delStatus + ", date=" + date + ", getGalleryDetailId()="
				+ getGalleryDetailId() + ", getPhotoName()=" + getPhotoName() + ", getPhotoCaption()="
				+ getPhotoCaption() + ", getPhotoDescription()=" + getPhotoDescription() + ", getGalleryHeadId()="
				+ getGalleryHeadId() + ", getIsActive()=" + getIsActive() + ", getDelStatus()=" + getDelStatus()
				+ ", getDate()=" + getDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	

}
