package com.ats.rusawebapi.model.mst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetFreqAskQue {

	@Id
	private int faqId;

	private int catId;

	private int subCatId;

	private String faqQue;

	private String faqAns;

	private int faqSortNo;

	private String faqRemark;

	private String faqAddDate;

	private String faqEditDate;

	private String faqDate;

	private int userId;

	private int isActive;

	private int delStatus;

	@Transient
	Info info;

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

	//#
	private String catName;
	private String catCode;
	private String catDesc;

	private String subCatName;
	private String subCatCode;
	private String subCatDesc;
	public int getFaqId() {
		return faqId;
	}
	public void setFaqId(int faqId) {
		this.faqId = faqId;
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
	public String getFaqQue() {
		return faqQue;
	}
	public void setFaqQue(String faqQue) {
		this.faqQue = faqQue;
	}
	public String getFaqAns() {
		return faqAns;
	}
	public void setFaqAns(String faqAns) {
		this.faqAns = faqAns;
	}
	public int getFaqSortNo() {
		return faqSortNo;
	}
	public void setFaqSortNo(int faqSortNo) {
		this.faqSortNo = faqSortNo;
	}
	public String getFaqRemark() {
		return faqRemark;
	}
	public void setFaqRemark(String faqRemark) {
		this.faqRemark = faqRemark;
	}
	public String getFaqAddDate() {
		return faqAddDate;
	}
	public void setFaqAddDate(String faqAddDate) {
		this.faqAddDate = faqAddDate;
	}
	public String getFaqEditDate() {
		return faqEditDate;
	}
	public void setFaqEditDate(String faqEditDate) {
		this.faqEditDate = faqEditDate;
	}
	public String getFaqDate() {
		return faqDate;
	}
	public void setFaqDate(String faqDate) {
		this.faqDate = faqDate;
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
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
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
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatCode() {
		return catCode;
	}
	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	public String getSubCatCode() {
		return subCatCode;
	}
	public void setSubCatCode(String subCatCode) {
		this.subCatCode = subCatCode;
	}
	public String getSubCatDesc() {
		return subCatDesc;
	}
	public void setSubCatDesc(String subCatDesc) {
		this.subCatDesc = subCatDesc;
	}
	@Override
	public String toString() {
		return "GetFreqAskQue [faqId=" + faqId + ", catId=" + catId + ", subCatId=" + subCatId + ", faqQue=" + faqQue
				+ ", faqAns=" + faqAns + ", faqSortNo=" + faqSortNo + ", faqRemark=" + faqRemark + ", faqAddDate="
				+ faqAddDate + ", faqEditDate=" + faqEditDate + ", faqDate=" + faqDate + ", userId=" + userId
				+ ", isActive=" + isActive + ", delStatus=" + delStatus + ", info=" + info + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", exVar3=" + exVar3 + ", exVar4=" + exVar4 + ", exVar5=" + exVar5 + ", exDate1=" + exDate1
				+ ", exDate2=" + exDate2 + ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2 + ", exFloat3="
				+ exFloat3 + ", catName=" + catName + ", catCode=" + catCode + ", catDesc=" + catDesc + ", subCatName="
				+ subCatName + ", subCatCode=" + subCatCode + ", subCatDesc=" + subCatDesc + "]";
	}
	
	
	
	

}
