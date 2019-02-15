package com.ats.rusawebapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FaqSearchData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "faq_id")
	private int faqId;

	@Column(name = "module_id")
	private int moduleId;
	
	@Column(name = "faq_que")
	private String faqQue; 
	
	@Column(name = "faq_ans")
	private String faqAns;
	
	@Column(name = "add_date")
	private Date addDate;
	
	@Column(name = "edit_date")
	private Date editDate;

	@Column(name = "page_name")
	private String pageName; 
	
	@Column(name = "page_slug")
	private String pageSlug;
	
	public int getFaqId() {
		return faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
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
		return "FaqSearchData [faqId=" + faqId + ", moduleId=" + moduleId + ", faqQue=" + faqQue + ", faqAns=" + faqAns
				+ ", addDate=" + addDate + ", editDate=" + editDate + ", pageName=" + pageName + ", pageSlug="
				+ pageSlug + "]";
	}
	
	

}
