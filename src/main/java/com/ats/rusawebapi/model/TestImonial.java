package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_testimonials")
public class TestImonial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="cate_type")
	private String cateType;
	
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="from_name")
	private String fromName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="location")
	private String location;
	
	@Column(name="message")
	private String message;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="sort_no")
	private int sortNo;
	
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
	
	@Column(name="ex_int1")
	private int exInt1;
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCateType() {
		return cateType;
	}

	public void setCateType(String cateType) {
		this.cateType = cateType;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
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

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	@Override
	public String toString() {
		return "TestImonial [id=" + id + ", cateType=" + cateType + ", pageId=" + pageId + ", sectionId=" + sectionId
				+ ", fromName=" + fromName + ", designation=" + designation + ", location=" + location + ", message="
				+ message + ", imageName=" + imageName + ", sortNo=" + sortNo + ", addDate=" + addDate + ", editDate="
				+ editDate + ", addedByUserId=" + addedByUserId + ", editByUserId=" + editByUserId + ", isActive="
				+ isActive + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1="
				+ exVar1 + ", exVar2=" + exVar2 + ", getId()=" + getId() + ", getCateType()=" + getCateType()
				+ ", getPageId()=" + getPageId() + ", getSectionId()=" + getSectionId() + ", getFromName()="
				+ getFromName() + ", getDesignation()=" + getDesignation() + ", getLocation()=" + getLocation()
				+ ", getMessage()=" + getMessage() + ", getImageName()=" + getImageName() + ", getSortNo()="
				+ getSortNo() + ", getAddDate()=" + getAddDate() + ", getEditDate()=" + getEditDate()
				+ ", getAddedByUserId()=" + getAddedByUserId() + ", getEditByUserId()=" + getEditByUserId()
				+ ", getIsActive()=" + getIsActive() + ", getDelStatus()=" + getDelStatus() + ", getExInt1()="
				+ getExInt1() + ", getExInt2()=" + getExInt2() + ", getExVar1()=" + getExVar1() + ", getExVar2()="
				+ getExVar2() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
}
