package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPagesModule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="primary_key_id")
	private int primaryKeyId;
	
	@Column(name="page_name")
	private String pageName;
	
	@Column(name="name")
	private String name;
	
	@Column(name="content")
	private String content;
	
	@Column(name="secction_name")
	private String secctionName;
	
	@Column(name="is_active")
	private int isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPrimaryKeyId() {
		return primaryKeyId;
	}

	public void setPrimaryKeyId(int primaryKeyId) {
		this.primaryKeyId = primaryKeyId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSecctionName() {
		return secctionName;
	}

	public void setSecctionName(String secctionName) {
		this.secctionName = secctionName;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "GetPagesModule [id=" + id + ", moduleId=" + moduleId + ", pageId=" + pageId + ", primaryKeyId="
				+ primaryKeyId + ", pageName=" + pageName + ", name=" + name + ", content=" + content
				+ ", secctionName=" + secctionName + ", isActive=" + isActive + "]";
	}


}
