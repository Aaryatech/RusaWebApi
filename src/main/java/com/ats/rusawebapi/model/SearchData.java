package com.ats.rusawebapi.model;

import java.util.List;

public class SearchData {
	
	 List<CmsSearchData> cmsSerchList;
	 List<FaqSearchData> faqSerchList;
	 List<NewsSearchData> newsSerchList;
	 List<GallerySearchData> gallerySerchList;
	 List<DocumentSearchData> documentSerchList;
	 
	public List<CmsSearchData> getCmsSerchList() {
		return cmsSerchList;
	}

	public void setCmsSerchList(List<CmsSearchData> cmsSerchList) {
		this.cmsSerchList = cmsSerchList;
	}

	public List<FaqSearchData> getFaqSerchList() {
		return faqSerchList;
	}

	public void setFaqSerchList(List<FaqSearchData> faqSerchList) {
		this.faqSerchList = faqSerchList;
	}

	public List<NewsSearchData> getNewsSerchList() {
		return newsSerchList;
	}

	public void setNewsSerchList(List<NewsSearchData> newsSerchList) {
		this.newsSerchList = newsSerchList;
	}

	public List<GallerySearchData> getGallerySerchList() {
		return gallerySerchList;
	}

	public void setGallerySerchList(List<GallerySearchData> gallerySerchList) {
		this.gallerySerchList = gallerySerchList;
	}

	public List<DocumentSearchData> getDocumentSerchList() {
		return documentSerchList;
	}

	public void setDocumentSerchList(List<DocumentSearchData> documentSerchList) {
		this.documentSerchList = documentSerchList;
	}

	@Override
	public String toString() {
		return "SearchData [cmsSerchList=" + cmsSerchList + ", faqSerchList=" + faqSerchList + ", newsSerchList="
				+ newsSerchList + ", gallerySerchList=" + gallerySerchList + ", documentSerchList=" + documentSerchList
				+ "]";
	}
	 

}
