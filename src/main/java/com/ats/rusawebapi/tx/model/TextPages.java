package com.ats.rusawebapi.tx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int textSize;
	
	
	private int isBullet;//0 no 1 yes
	private int bulletType;
	
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

	public int getTextSize() {
		return textSize;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	public int getIsBullet() {
		return isBullet;
	}

	public void setIsBullet(int isBullet) {
		this.isBullet = isBullet;
	}

	public int getBulletType() {
		return bulletType;
	}

	public void setBulletType(int bulletType) {
		this.bulletType = bulletType;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "TextPages [textPageId=" + textPageId + ", sectionId=" + sectionId + ", catId=" + catId + ", subCatId="
				+ subCatId + ", pageValue=" + pageValue + ", isHyperlink=" + isHyperlink + ", hyperlinkValue="
				+ hyperlinkValue + ", hyperlinkType=" + hyperlinkType + ", textColor=" + textColor + ", textSize="
				+ textSize + ", isBullet=" + isBullet + ", bulletType=" + bulletType + ", languageId=" + languageId
				+ "]";
	}
	

}
