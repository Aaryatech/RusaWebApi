package com.ats.rusawebapi.model.frontend;

import java.util.List;

import com.ats.rusawebapi.model.DocumentUpload;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.ImageListByCategory;
import com.ats.rusawebapi.model.NewsDetails;
import com.ats.rusawebapi.model.TestImonial;

public class PageContent {
	
	private int pageId;
	private String pageName;
	private String slugName;
	private int sectioinId;
	List<CmsContent> cmsContentList;
	List<FaqContent> faqContentList;
	List<DocumentUpload> documentUploadList;
	List<TestImonial> testImonialList;
	List<GallaryDetail> gallaryDetailList;
	List<NewsDetails> detailNewsList;
	List<TestImonial> successList;
	List<TestImonial> teamList;

	List<ImageListByCategory> imageListByCategory;
	
	List<GallaryDetail> videoList; 
	
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	 
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public List<CmsContent> getCmsContentList() {
		return cmsContentList;
	}
	public void setCmsContentList(List<CmsContent> cmsContentList) {
		this.cmsContentList = cmsContentList;
	}
	public List<FaqContent> getFaqContentList() {
		return faqContentList;
	}
	public void setFaqContentList(List<FaqContent> faqContentList) {
		this.faqContentList = faqContentList;
	}
	
	public String getSlugName() {
		return slugName;
	}
	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}
	public List<DocumentUpload> getDocumentUploadList() {
		return documentUploadList;
	}
	public void setDocumentUploadList(List<DocumentUpload> documentUploadList) {
		this.documentUploadList = documentUploadList;
	}
	public int getSectioinId() {
		return sectioinId;
	}
	public void setSectioinId(int sectioinId) {
		this.sectioinId = sectioinId;
	}
	
	public List<TestImonial> getTestImonialList() {
		return testImonialList;
	}
	public void setTestImonialList(List<TestImonial> testImonialList) {
		this.testImonialList = testImonialList;
	}
	public List<GallaryDetail> getGallaryDetailList() {
		return gallaryDetailList;
	}
	public void setGallaryDetailList(List<GallaryDetail> gallaryDetailList) {
		this.gallaryDetailList = gallaryDetailList;
	}
	public List<NewsDetails> getDetailNewsList() {
		return detailNewsList;
	}
	public void setDetailNewsList(List<NewsDetails> detailNewsList) {
		this.detailNewsList = detailNewsList;
	}
	public List<TestImonial> getSuccessList() {
		return successList;
	}
	public void setSuccessList(List<TestImonial> successList) {
		this.successList = successList;
	}
	public List<TestImonial> getTeamList() {
		return teamList;
	}
	public void setTeamList(List<TestImonial> teamList) {
		this.teamList = teamList;
	}
	public List<ImageListByCategory> getImageListByCategory() {
		return imageListByCategory;
	}
	public void setImageListByCategory(List<ImageListByCategory> imageListByCategory) {
		this.imageListByCategory = imageListByCategory;
	}
	
	public List<GallaryDetail> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<GallaryDetail> videoList) {
		this.videoList = videoList;
	}
	 
	@Override
	public String toString() {
		return "PageContent [pageId=" + pageId + ", pageName=" + pageName + ", slugName=" + slugName + ", sectioinId="
				+ sectioinId + ", cmsContentList=" + cmsContentList + ", faqContentList=" + faqContentList
				+ ", documentUploadList=" + documentUploadList + ", testImonialList=" + testImonialList
				+ ", gallaryDetailList=" + gallaryDetailList + ", detailNewsList=" + detailNewsList + ", successList="
				+ successList + ", teamList=" + teamList + ", imageListByCategory=" + imageListByCategory
				+ ", videoList=" + videoList + "]";
	}
	

}
