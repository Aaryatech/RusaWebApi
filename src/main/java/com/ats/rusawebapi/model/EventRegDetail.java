package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventRegDetail {

	@Id	
	private int eventRegId;
	
	private int userId;
	
	private String regDate;
	
	private int newsblogsId;
	
	private int statusApproval;
	
	private String approvalDate;
	
	private int approveBy;
	
	private String doc1;
	
	private int doc2;	
	
	private int isActive;
	
	private int delStatus;
	
	private int exInt1;
	
	private int exInt2;
	
	private String exVar1;
	
	private String exVar2;

}
