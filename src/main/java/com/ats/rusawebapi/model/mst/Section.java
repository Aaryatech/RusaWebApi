package com.ats.rusawebapi.model.mst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_section")
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="section_name")
	private String sectionName;
	
	@Column(name="section_no")
	private String sectionNo;
	
	@Column(name="section_desc")
	private String sectionDesc;
	
	@Column(name="section_add_date")
	private String sectionAddDate;
	
	@Column(name="section_edit_date")
	private String sectionEditDate;
	
	@Column(name="sec_sort_no")
	private String sectionSortNo;
	
	@Column(name="section_remark")
	private String sectionRemark;
	
	@Column(name="sec_date_time")
	private String sectionDateTime;;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;

	public int getSectionId() {
		return sectionId;
	}
	//
	
	
	@Transient
	Info info;
	

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}


	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}

	public String getSectionDesc() {
		return sectionDesc;
	}

	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}

	public String getSectionAddDate() {
		return sectionAddDate;
	}

	public void setSectionAddDate(String sectionAddDate) {
		this.sectionAddDate = sectionAddDate;
	}

	public String getSectionEditDate() {
		return sectionEditDate;
	}

	public void setSectionEditDate(String sectionEditDate) {
		this.sectionEditDate = sectionEditDate;
	}

	public String getSectionSortNo() {
		return sectionSortNo;
	}

	public void setSectionSortNo(String sectionSortNo) {
		this.sectionSortNo = sectionSortNo;
	}

	public String getSectionRemark() {
		return sectionRemark;
	}

	public void setSectionRemark(String sectionRemark) {
		this.sectionRemark = sectionRemark;
	}

	public String getSectionDateTime() {
		return sectionDateTime;
	}

	public void setSectionDateTime(String sectionDateTime) {
		this.sectionDateTime = sectionDateTime;
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

	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", sectionName=" + sectionName + ", sectionNo=" + sectionNo
				+ ", sectionDesc=" + sectionDesc + ", sectionAddDate=" + sectionAddDate + ", sectionEditDate="
				+ sectionEditDate + ", sectionSortNo=" + sectionSortNo + ", sectionRemark=" + sectionRemark
				+ ", sectionDateTime=" + sectionDateTime + ", userId=" + userId + ", isActive=" + isActive
				+ ", delStatus=" + delStatus + "]";
	}

	
	
	
	
	
	
	
	
	

}
