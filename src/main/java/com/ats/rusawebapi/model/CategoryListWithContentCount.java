package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryListWithContentCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="cat_desc")
	private String catDesc;
	
	@Column(name="img_count")
	private int imgCount;
	    
	@Column(name="video_count")
	private int videoCount;
	  
	@Column(name="category_count")
	private int categoryCount;
	
	@Column(name="page_slug")
	private String pageSlug;
	
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

	public int getImgCount() {
		return imgCount;
	}

	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}

	public int getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(int videoCount) {
		this.videoCount = videoCount;
	}
 

	public int getCategoryCount() {
		return categoryCount;
	}

	public void setCategoryCount(int categoryCount) {
		this.categoryCount = categoryCount;
	}

	public String getPageSlug() {
		return pageSlug;
	}

	public void setPageSlug(String pageSlug) {
		this.pageSlug = pageSlug;
	}

	@Override
	public String toString() {
		return "CategoryListWithContentCount [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc
				+ ", imgCount=" + imgCount + ", videoCount=" + videoCount +  ", categoryCount=" + categoryCount + ", pageSlug=" + pageSlug + "]";
	}
	 
	
	

}
