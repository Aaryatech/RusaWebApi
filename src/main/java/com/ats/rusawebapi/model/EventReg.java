package com.ats.rusawebapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventReg {
	
	@Id	
	private int newsblogsId;
		
	private String eventLocation;
	
	private Date eventDateFrom;
	
	private Date eventDateTo;
	
	private String eventContactPerson;
	
	private String eventContactNumber;
		
	private String featuredImage;
		
	private String downloadPdf;
	
	private int isActive;
	
	private int delStatus;
	
	private int exInt1;
	
	private int exInt2;	
	
	private String heading;
	
	private String descriptions;
	
	private String pageMetaTitle;
	
	private String pageMetaDescription;
	
	private String pageMetaKeyword;
	
	private int languageId;	

	private int userId;
	
	private String regDate;	
	
	private int statusApproval;
		
	private String doc1;
	
	private int doc2;	
	
	private String name;

	public int getNewsblogsId() {
		return newsblogsId;
	}

	public void setNewsblogsId(int newsblogsId) {
		this.newsblogsId = newsblogsId;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Date getEventDateFrom() {
		return eventDateFrom;
	}

	public void setEventDateFrom(Date eventDateFrom) {
		this.eventDateFrom = eventDateFrom;
	}

	public Date getEventDateTo() {
		return eventDateTo;
	}

	public void setEventDateTo(Date eventDateTo) {
		this.eventDateTo = eventDateTo;
	}

	public String getEventContactPerson() {
		return eventContactPerson;
	}

	public void setEventContactPerson(String eventContactPerson) {
		this.eventContactPerson = eventContactPerson;
	}

	public String getEventContactNumber() {
		return eventContactNumber;
	}

	public void setEventContactNumber(String eventContactNumber) {
		this.eventContactNumber = eventContactNumber;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	public String getDownloadPdf() {
		return downloadPdf;
	}

	public void setDownloadPdf(String downloadPdf) {
		this.downloadPdf = downloadPdf;
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

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getPageMetaTitle() {
		return pageMetaTitle;
	}

	public void setPageMetaTitle(String pageMetaTitle) {
		this.pageMetaTitle = pageMetaTitle;
	}

	public String getPageMetaDescription() {
		return pageMetaDescription;
	}

	public void setPageMetaDescription(String pageMetaDescription) {
		this.pageMetaDescription = pageMetaDescription;
	}

	public String getPageMetaKeyword() {
		return pageMetaKeyword;
	}

	public void setPageMetaKeyword(String pageMetaKeyword) {
		this.pageMetaKeyword = pageMetaKeyword;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getStatusApproval() {
		return statusApproval;
	}

	public void setStatusApproval(int statusApproval) {
		this.statusApproval = statusApproval;
	}

	public String getDoc1() {
		return doc1;
	}

	public void setDoc1(String doc1) {
		this.doc1 = doc1;
	}

	public int getDoc2() {
		return doc2;
	}

	public void setDoc2(int doc2) {
		this.doc2 = doc2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EventReg [newsblogsId=" + newsblogsId + ", eventLocation=" + eventLocation + ", eventDateFrom="
				+ eventDateFrom + ", eventDateTo=" + eventDateTo + ", eventContactPerson=" + eventContactPerson
				+ ", eventContactNumber=" + eventContactNumber + ", featuredImage=" + featuredImage + ", downloadPdf="
				+ downloadPdf + ", isActive=" + isActive + ", delStatus=" + delStatus + ", exInt1=" + exInt1
				+ ", exInt2=" + exInt2 + ", heading=" + heading + ", descriptions=" + descriptions + ", pageMetaTitle="
				+ pageMetaTitle + ", pageMetaDescription=" + pageMetaDescription + ", pageMetaKeyword="
				+ pageMetaKeyword + ", languageId=" + languageId + ", userId=" + userId + ", regDate=" + regDate
				+ ", statusApproval=" + statusApproval + ", doc1=" + doc1 + ", doc2=" + doc2 + ", name=" + name + "]";
	}

	
}
