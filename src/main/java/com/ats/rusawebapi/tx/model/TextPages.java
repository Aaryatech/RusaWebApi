package com.ats.rusawebapi.tx.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ats.rusawebapi.model.mst.Info;

@Entity
@Table(name = "t_text_pages")
public class TextPages {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="text_page_id")
	private int textPageId;
	
	private int sectionId;
	
	private int catId;
	private int subCatId;
	
	private String pageValue;
	
	private int isHyperlink;//0 no 1 yes
	private String hyperlinkValue;
	
	private int hyperlinkType;
	
	private String textColor;
	private float textSize;
	
	
	private int isBullet;//0 no 1 yes
	private String bulletType;
	
	private int languageId;

	public int getTextPageId() {
		return textPageId;
	}

	public void setTextPageId(int textPageId) {
		this.textPageId = textPageId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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

	public String getPageValue() {
		return pageValue;
	}

	public void setPageValue(String pageValue) {
		this.pageValue = pageValue;
	}

	public int getIsHyperlink() {
		return isHyperlink;
	}

	public void setIsHyperlink(int isHyperlink) {
		this.isHyperlink = isHyperlink;
	}

	public String getHyperlinkValue() {
		return hyperlinkValue;
	}

	public void setHyperlinkValue(String hyperlinkValue) {
		this.hyperlinkValue = hyperlinkValue;
	}

	public int getHyperlinkType() {
		return hyperlinkType;
	}

	public void setHyperlinkType(int hyperlinkType) {
		this.hyperlinkType = hyperlinkType;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public float getTextSize() {
		return textSize;
	}

	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}

	public int getIsBullet() {
		return isBullet;
	}

	public void setIsBullet(int isBullet) {
		this.isBullet = isBullet;
	}

	public String getBulletType() {
		return bulletType;
	}

	public void setBulletType(String bulletType) {
		this.bulletType = bulletType;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	
	
	@Transient
	Info info;
	
	
	private int exInt1;
	private int exInt2;
	private int exInt3;

	private String exVar1;
	private String exVar2;
	private String exVar3;

	private String exDate1;
	private String exDate2;

	private float exFloat1;
	private float exFloat2;
	private float exFloat3;
	
	private String exVar4;
	private String exVar5;


	private String pageAddDate;
	
	private String pageDatetime;
	
	private int isActive;
	private int userId;
	private int delStatus;
	
	public int getPageSortNo() {
		return pageSortNo;
	}

	public void setPageSortNo(int pageSortNo) {
		this.pageSortNo = pageSortNo;
	}


	private int pageSortNo;
	
	
	
	
	
	
	
	

	public String getPageAddDate() {
		return pageAddDate;
	}

	public void setPageAddDate(String pageAddDate) {
		this.pageAddDate = pageAddDate;
	}

	public String getPageDatetime() {
		return pageDatetime;
	}

	public void setPageDatetime(String pageDatetime) {
		this.pageDatetime = pageDatetime;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "TextPages [textPageId=" + textPageId + ", sectionId=" + sectionId + ", catId=" + catId + ", subCatId="
				+ subCatId + ", pageValue=" + pageValue + ", isHyperlink=" + isHyperlink + ", hyperlinkValue="
				+ hyperlinkValue + ", hyperlinkType=" + hyperlinkType + ", textColor=" + textColor + ", textSize="
				+ textSize + ", isBullet=" + isBullet + ", bulletType=" + bulletType + ", languageId=" + languageId
				+ ", info=" + info + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3=" + exInt3 + ", exVar1="
				+ exVar1 + ", exVar2=" + exVar2 + ", exVar3=" + exVar3 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2
				+ ", exFloat1=" + exFloat1 + ", exFloat2=" + exFloat2 + ", exFloat3=" + exFloat3 + ", exVar4=" + exVar4
				+ ", exVar5=" + exVar5 + ", pageAddDate=" + pageAddDate + ", pageDatetime=" + pageDatetime
				+ ", isActive=" + isActive + ", userId=" + userId + ", delStatus=" + delStatus + ", pageSortNo="
				+ pageSortNo + "]";
	}
	

}
