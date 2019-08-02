package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_testimonials_detail")
public class TestimonialDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "test_detail_id")
	private int testDetailId;

	@Column(name = "cate_type")
	private String cateType;

	@Column(name = "test_head_id")
	private int testHeadId;

	@Column(name = "lang_id")
	private int langId;

	@Column(name = "from_name")
	private String fromName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "location")
	private String location;

	@Column(name = "message")
	private String message;

	@Column(name = "sort_no")
	private int sortNo;

	@Column(name = "add_date")
	private String addDate;

	@Column(name = "edit_date")
	private String editDate;

	@Column(name = "added_by_user_id")
	private int addedByUserId;

	@Column(name = "edit_by_user_id")
	private int editByUserId;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "ex_int1")
	private int exInt1;
	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	public int getTestDetailId() {
		return testDetailId;
	}

	public void setTestDetailId(int testDetailId) {
		this.testDetailId = testDetailId;
	}

	public String getCateType() {
		return cateType;
	}

	public void setCateType(String cateType) {
		this.cateType = cateType;
	}

	public int getTestHeadId() {
		return testHeadId;
	}

	public void setTestHeadId(int testHeadId) {
		this.testHeadId = testHeadId;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
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
		return "TestimonialDetail [testDetailId=" + testDetailId + ", cateType=" + cateType + ", testHeadId="
				+ testHeadId + ", langId=" + langId + ", fromName=" + fromName + ", designation=" + designation
				+ ", location=" + location + ", message=" + message + ", sortNo=" + sortNo + ", addDate=" + addDate
				+ ", editDate=" + editDate + ", addedByUserId=" + addedByUserId + ", editByUserId=" + editByUserId
				+ ", isActive=" + isActive + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}
	
	
}
