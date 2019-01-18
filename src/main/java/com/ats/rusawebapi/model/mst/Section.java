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
	
	private int exInt1;
	
	private int exInt2;

	private int exInt3;
	
	private String exVar1;
	
	private String exVar2;
	
	private String exVar3;
	
	private String exVar4;
	
	private String exVar5;
	
	private String exDate1;
	
	private String exDate2;

	private float exFloat1;
	
	private float exFloat2;
	
	private float exFloat3;
	
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

	public int getExInt3() {
		return exInt3;
	}

	public void setExInt3(int exInt3) {
		this.exInt3 = exInt3;
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

	public String getExVar3() {
		return exVar3;
	}

	public void setExVar3(String exVar3) {
		this.exVar3 = exVar3;
	}

	public String getExVar4() {
		return exVar4;
	}

	public void setExVar4(String exVar4) {
		this.exVar4 = exVar4;
	}

	public String getExVar5() {
		return exVar5;
	}

	public void setExVar5(String exVar5) {
		this.exVar5 = exVar5;
	}

	public String getExDate1() {
		return exDate1;
	}

	public void setExDate1(String exDate1) {
		this.exDate1 = exDate1;
	}

	public String getExDate2() {
		return exDate2;
	}

	public void setExDate2(String exDate2) {
		this.exDate2 = exDate2;
	}

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	public float getExFloat2() {
		return exFloat2;
	}

	public void setExFloat2(float exFloat2) {
		this.exFloat2 = exFloat2;
	}

	public float getExFloat3() {
		return exFloat3;
	}

	public void setExFloat3(float exFloat3) {
		this.exFloat3 = exFloat3;
	}

	@Override
	public String toString() {
		return "Section [sectionId=" + sectionId + ", sectionName=" + sectionName + ", sectionNo=" + sectionNo
				+ ", sectionDesc=" + sectionDesc + ", sectionAddDate=" + sectionAddDate + ", sectionEditDate="
				+ sectionEditDate + ", sectionSortNo=" + sectionSortNo + ", sectionRemark=" + sectionRemark
				+ ", sectionDateTime=" + sectionDateTime + ", userId=" + userId + ", isActive=" + isActive
				+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exVar4=" + exVar4
				+ ", exVar5=" + exVar5 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2 + ", exFloat1=" + exFloat1
				+ ", exFloat2=" + exFloat2 + ", exFloat3=" + exFloat3 + ", info=" + info + "]";
	}

	

	
	
	
	
	
	
	

}
