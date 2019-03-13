package com.ats.rusawebapi.model;

import java.util.List;

public class HomeData {

	public Logo logoData;
	public BannerImages baner;
	public List<GallaryDetail> videoList;
	public List<GallaryDetail> photoList;
	public List<TestImonial> testimonialList;
	public List<NewsDetails> newsList;
	public List<SocialChannels> socialList;
	public List<CmsSearchData> cmsList;

	public Logo getLogoData() {
		return logoData;
	}

	public void setLogoData(Logo logoData) {
		this.logoData = logoData;
	}

	public BannerImages getBaner() {
		return baner;
	}

	public void setBaner(BannerImages baner) {
		this.baner = baner;
	}

	public List<GallaryDetail> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<GallaryDetail> videoList) {
		this.videoList = videoList;
	}

	public List<GallaryDetail> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<GallaryDetail> photoList) {
		this.photoList = photoList;
	}

	public List<TestImonial> getTestimonialList() {
		return testimonialList;
	}

	public void setTestimonialList(List<TestImonial> testimonialList) {
		this.testimonialList = testimonialList;
	}

	public List<NewsDetails> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsDetails> newsList) {
		this.newsList = newsList;
	}

	public List<SocialChannels> getSocialList() {
		return socialList;
	}

	public void setSocialList(List<SocialChannels> socialList) {
		this.socialList = socialList;
	}

	public List<CmsSearchData> getCmsList() {
		return cmsList;
	}

	public void setCmsList(List<CmsSearchData> cmsList) {
		this.cmsList = cmsList;
	}

	@Override
	public String toString() {
		return "HomeData [logoData=" + logoData + ", baner=" + baner + ", videoList=" + videoList + ", photoList="
				+ photoList + ", testimonialList=" + testimonialList + ", newsList=" + newsList + ", socialList="
				+ socialList + ", cmsList=" + cmsList + "]";
	}

}
