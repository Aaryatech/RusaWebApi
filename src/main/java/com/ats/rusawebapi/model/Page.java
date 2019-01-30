package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_pages")
public class Page {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="page_id")
	private int pageId;
	
	@Column(name="template_id")
	private int templateId;
	
	@Column(name="module_id")
	private int moduleId;
	
	@Column(name="page_name")
	private String pageName;
	
	@Column(name="page_slug")
	private String pageSlug;
	
	@Column(name="externalUrl")
	private String externalUrl;
	
	@Column(name="type_sec_cate")
	private String typeSecCate;
	
	@Column(name="sec_cate_id")
	private int secCateId;

	@Column(name="page_meta_title")
	private String pageMetaTitle;
	
	@Column(name="page_meta_description")
	private String pageMetaDescription;
	
	@Column(name="page_meta_keyword")
	private String pageMetaKeyword;
	
	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
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

	public String getExternalUrl() {
		return externalUrl;
	}

	public void setExternalUrl(String externalUrl) {
		this.externalUrl = externalUrl;
	}

	public String getTypeSecCate() {
		return typeSecCate;
	}

	public void setTypeSecCate(String typeSecCate) {
		this.typeSecCate = typeSecCate;
	}

	public int getSecCateId() {
		return secCateId;
	}

	public void setSecCateId(int secCateId) {
		this.secCateId = secCateId;
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

	@Override
	public String toString() {
		return "Page [pageId=" + pageId + ", templateId=" + templateId + ", moduleId=" + moduleId + ", pageName="
				+ pageName + ", pageSlug=" + pageSlug + ", externalUrl=" + externalUrl + ", typeSecCate=" + typeSecCate
				+ ", secCateId=" + secCateId + ", pageMetaTitle=" + pageMetaTitle + ", pageMetaDescription="
				+ pageMetaDescription + ", pageMetaKeyword=" + pageMetaKeyword + "]";
	}
	
	
}
