package com.ats.rusawebapi.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_languages")
public class Languages {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="languages_id")
	private int languagesId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@Column(name="image")
	private String image;
	
	@Column(name="directory")
	private String directory;
	
	@Column(name="sort_order")
	private int sortOrder;
	 
	@Column(name="languages_status")
	private String languagesStatus;
	
	@Column(name="locale_1")
	private String locale1;

	@Column(name="default_status")
	private int defaultStatus;

	@Column(name="is_active")
	private int isActive;

	public int getLanguagesId() {
		return languagesId;
	}

	public void setLanguagesId(int languagesId) {
		this.languagesId = languagesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getLanguagesStatus() {
		return languagesStatus;
	}

	public void setLanguagesStatus(String languagesStatus) {
		this.languagesStatus = languagesStatus;
	}

	public String getLocale1() {
		return locale1;
	}

	public void setLocale1(String locale1) {
		this.locale1 = locale1;
	}

	public int getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(int defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Languages [languagesId=" + languagesId + ", name=" + name + ", code=" + code + ", image=" + image
				+ ", directory=" + directory + ", sortOrder=" + sortOrder + ", languagesStatus=" + languagesStatus
				+ ", locale1=" + locale1 + ", defaultStatus=" + defaultStatus + ", isActive=" + isActive + "]";
	}
	
	

}
