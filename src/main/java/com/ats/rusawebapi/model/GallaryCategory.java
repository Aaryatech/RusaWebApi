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
@Table(name = "m_gallery_cat")
public class GallaryCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="gallery_cat_id")
	private int galleryCatId;
	
	@Column(name="cate_type")
	private int cateType;
	
	@Column(name="cate_name")
	private String cateName;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="slug_name")
	private String slugName;
	
	@Column(name="gallery_date")
	private String galleryDate;
	
	@Column(name="sort_no")
	private int sortNo;
	 
	@Column(name="parent_id")
	private int parentId;
	
	@Column(name="add_date")
	private String addDate;
	
	@Column(name="edit_date")
	private String editDate;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
	@Column(name="edit_by_user_id")
	private int editByUserId;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;

	@Transient
	List<GallaryCategoryDescriptioin> gallaryCategoryDescriptioinList;
	
	public int getGalleryCatId() {
		return galleryCatId;
	}

	public void setGalleryCatId(int galleryCatId) {
		this.galleryCatId = galleryCatId;
	}

	public int getCateType() {
		return cateType;
	}

	public void setCateType(int cateType) {
		this.cateType = cateType;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getSlugName() {
		return slugName;
	}

	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}

	public String getGalleryDate() {
		return galleryDate;
	}

	public void setGalleryDate(String galleryDate) {
		this.galleryDate = galleryDate;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public List<GallaryCategoryDescriptioin> getGallaryCategoryDescriptioinList() {
		return gallaryCategoryDescriptioinList;
	}

	public void setGallaryCategoryDescriptioinList(List<GallaryCategoryDescriptioin> gallaryCategoryDescriptioinList) {
		this.gallaryCategoryDescriptioinList = gallaryCategoryDescriptioinList;
	}

	@Override
	public String toString() {
		return "GallaryCategory [galleryCatId=" + galleryCatId + ", cateType=" + cateType + ", cateName=" + cateName
				+ ", imageName=" + imageName + ", slugName=" + slugName + ", galleryDate=" + galleryDate + ", sortNo="
				+ sortNo + ", parentId=" + parentId + ", addDate=" + addDate + ", editDate=" + editDate
				+ ", addedByUserId=" + addedByUserId + ", editByUserId=" + editByUserId + ", isActive=" + isActive
				+ ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", gallaryCategoryDescriptioinList=" + gallaryCategoryDescriptioinList + "]";
	}
	
	
	
}
