package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageListByCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gallery_details_id")
	private int galleryDetailsId;
	
	@Column(name="gallery_cat_id")
	private int galleryCatId;
	
	@Column(name="pic_count")
	private int picCount;
	
	@Column(name="cate_name")
	private String cateName;
	
	@Column(name="file_name")
	private String fileName;

	public int getGalleryDetailsId() {
		return galleryDetailsId;
	}

	public void setGalleryDetailsId(int galleryDetailsId) {
		this.galleryDetailsId = galleryDetailsId;
	}

	public int getGalleryCatId() {
		return galleryCatId;
	}

	public void setGalleryCatId(int galleryCatId) {
		this.galleryCatId = galleryCatId;
	}

	public int getPicCount() {
		return picCount;
	}

	public void setPicCount(int picCount) {
		this.picCount = picCount;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "ImageListByCategory [galleryDetailsId=" + galleryDetailsId + ", galleryCatId=" + galleryCatId
				+ ", picCount=" + picCount + ", cateName=" + cateName + ", fileName=" + fileName + "]";
	}
	 
	
	

}
