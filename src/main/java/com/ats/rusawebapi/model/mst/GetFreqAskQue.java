package com.ats.rusawebapi.model.mst;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetFreqAskQue {

	@Id
	private int faqId;

	private int catId;

	private int subCatId;

	private String faqQue;

	private String faqAns;

	private int faqSortNo;

	private String faqRemark;

	private String faqAddDate;

	private String faqEditDate;

	private String faqDate;

	private int userId;

	private int isActive;

	private int delStatus;

	@Transient
	Info info;

	private int exInt1;
	private int exInt2;
	private int exInt3;

	private String exVar1;
	private String exVar2;
	private String exVar3;
	private String exVar4;
	private String exVar5;

	private String exDate1;
	private String exDate2;

	private float exFloat1;
	private float exFloat2;
	private float exFloat3;

	//#
	private String catName;
	private String catCode;
	private String catDesc;

	private String subCatName;
	private String subCatCode;
	private String subCatDesc;

}
