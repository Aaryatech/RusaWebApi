package com.ats.rusawebapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocumentSearchData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doc_id")
	private int docId;

	@Column(name = "module_id")
	private int moduleId;
	
	@Column(name = "file_name")
	private String fileName; 
	 
	@Column(name = "add_date")
	private Date addDate;
	
	@Column(name = "edit_date")
	private Date editDate;

	@Column(name = "page_name")
	private String pageName; 
	
	@Column(name = "page_slug")
	private String pageSlug;
	
	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageSlug() {
		return pageSlug;
	}

	public void setPageSlug(String pageSlug) {
		this.pageSlug = pageSlug;
	}

	@Override
	public String toString() {
		return "DocumentSearchData [docId=" + docId + ", moduleId=" + moduleId + ", fileName=" + fileName + ", addDate="
				+ addDate + ", editDate=" + editDate + ", pageName=" + pageName + ", pageSlug=" + pageSlug + "]";
	}
	
	

}
