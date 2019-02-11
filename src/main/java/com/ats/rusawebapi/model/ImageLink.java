package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_image_links")
public class ImageLink {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="cate_group")
	private String cateGroup;
	
	@Column(name="title_name")
	private String titleName;
	
	@Column(name="url_link")
	private String urlLink;
	
	@Column(name="slider_image")
	private String sliderImage;
	
	@Column(name="sort_order")
	private int sortOrder;
	
	@Column(name="add_date")
	private String addDate;
	
	@Column(name="edit_date")
	private String editDate;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
	@Column(name="edit_by_user_id")
	private int editByUserId;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="int_1")
	private int int1;
	@Column(name="int_2")
	private int int2;
	
	@Column(name="var1")
	private String var1;
	
	@Column(name="var2")
	private String var2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCateGroup() {
		return cateGroup;
	}

	public void setCateGroup(String cateGroup) {
		this.cateGroup = cateGroup;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getUrlLink() {
		return urlLink;
	}

	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}

	public String getSliderImage() {
		return sliderImage;
	}

	public void setSliderImage(String sliderImage) {
		this.sliderImage = sliderImage;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
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

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public String getVar1() {
		return var1;
	}

	public void setVar1(String var1) {
		this.var1 = var1;
	}

	public String getVar2() {
		return var2;
	}

	public void setVar2(String var2) {
		this.var2 = var2;
	}

	@Override
	public String toString() {
		return "ImageLink [id=" + id + ", cateGroup=" + cateGroup + ", titleName=" + titleName + ", urlLink=" + urlLink
				+ ", sliderImage=" + sliderImage + ", sortOrder=" + sortOrder + ", addDate=" + addDate + ", editDate="
				+ editDate + ", addedByUserId=" + addedByUserId + ", editByUserId=" + editByUserId + ", isActive="
				+ isActive + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2 + ", var1=" + var1
				+ ", var2=" + var2 + ", getId()=" + getId() + ", getCateGroup()=" + getCateGroup() + ", getTitleName()="
				+ getTitleName() + ", getUrlLink()=" + getUrlLink() + ", getSliderImage()=" + getSliderImage()
				+ ", getSortOrder()=" + getSortOrder() + ", getAddDate()=" + getAddDate() + ", getEditDate()="
				+ getEditDate() + ", getAddedByUserId()=" + getAddedByUserId() + ", getEditByUserId()="
				+ getEditByUserId() + ", getIsActive()=" + getIsActive() + ", getDelStatus()=" + getDelStatus()
				+ ", getInt1()=" + getInt1() + ", getInt2()=" + getInt2() + ", getVar1()=" + getVar1() + ", getVar2()="
				+ getVar2() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
