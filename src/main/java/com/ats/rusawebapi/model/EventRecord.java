package com.ats.rusawebapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat; 

@Entity 
public class EventRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="newsblogs_id")
	private int newsblogsId;
	
	@Column(name="heading")
	private String heading;
	
	@Column(name="descriptions")
	private String descriptions;
	
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="featured_image")
	private String featuredImage;
	
	@Column(name="download_pdf")
	private String downloadPdf;
	
	@Column(name="apply")
	private int apply;
	 
	@Column(name="is_feedback")
	private int isFeedback;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="feedback")
	private String feedback;
	
	
	public int getNewsblogsId() {
		return newsblogsId;
	}

	public void setNewsblogsId(int newsblogsId) {
		this.newsblogsId = newsblogsId;
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

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
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

	public int getApply() {
		return apply;
	}

	public void setApply(int apply) {
		this.apply = apply;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIsFeedback() {
		return isFeedback;
	}

	public void setIsFeedback(int isFeedback) {
		this.isFeedback = isFeedback;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "EventRecord [newsblogsId=" + newsblogsId + ", heading=" + heading + ", descriptions=" + descriptions
				+ ", languageId=" + languageId + ", featuredImage=" + featuredImage + ", downloadPdf=" + downloadPdf
				+ ", apply=" + apply + ", isFeedback=" + isFeedback + ", date=" + date + ", feedback=" + feedback + "]";
	}
	
	
	 

}
