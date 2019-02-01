package com.ats.rusawebapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "m_meta_data")
public class MetaData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="site_title")
	private String siteTitle;
	
	@Column(name="meta_description")
	private String metaDescription;
	
	@Column(name="meta_author")
	private String metaAuthor;
	
	@Column(name="meta_keywords")
	private String metaKeywords;
	
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="add_date")
	private String addDate;
	
	@Column(name="edit_date")
	private String editDate;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
	@Column(name="edit_by_user_id")
	private int editByUserId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSiteTitle() {
		return siteTitle;
	}

	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaAuthor() {
		return metaAuthor;
	}

	public void setMetaAuthor(String metaAuthor) {
		this.metaAuthor = metaAuthor;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}



	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
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

	@Override
	public String toString() {
		return "MetaData [id=" + id + ", siteTitle=" + siteTitle + ", metaDescription=" + metaDescription
				+ ", metaAuthor=" + metaAuthor + ", metaKeywords=" + metaKeywords + ", languageId=" + languageId
				+ ", addDate=" + addDate + ", editDate=" + editDate + ", addedByUserId=" + addedByUserId
				+ ", editByUserId=" + editByUserId + ", getId()=" + getId() + ", getSiteTitle()=" + getSiteTitle()
				+ ", getMetaDescription()=" + getMetaDescription() + ", getMetaAuthor()=" + getMetaAuthor()
				+ ", getMetaKeywords()=" + getMetaKeywords() + ", getLanguageId()=" + getLanguageId()
				+ ", getAddDate()=" + getAddDate() + ", getEditDate()=" + getEditDate() + ", getAddedByUserId()="
				+ getAddedByUserId() + ", getEditByUserId()=" + getEditByUserId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	
}
