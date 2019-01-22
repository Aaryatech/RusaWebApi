package com.ats.rusawebapi.model.mst;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

public class GetSubCategory {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_cat_id")
	
	private int subCatId;
	
	private int catId;
	
	private String subCatName;
	
	private String subCatCode;
	
	private String subCatDesc;
	
	private String SubCatAddDate;
	
	private String subCatEditDate;
	
	private int subCatSortNo;
	
	private String subCatRemark;
	
	private int sectionId;
	
	private int userId;
	
	private int isActive;
	
	private int delStatus;
	
	//total 13 fields 17 Jan 2019
	

	@Transient
	Info info;
	
	
	private int exInt1;
	private int exInt2;
	private int exInt3;

	private String exVar1;
	private String exVar2;
	private String exVar3;

	private String exDate1;
	private String exDate2;

	private float exFloat1;
	private float exFloat2;
	private float exFloat3;
	
	private String exVar4;
	private String exVar5;
	//total 13 fields 18 Jan 2019
	
	private String catName;
	private String catCode;
	private String catDesc;

}
