package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "event_registration")
public class EventRegistrationForApp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="event_reg_id")
	private int eventRegId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="reg_date")
	private String regDate;
	
	@Column(name="newsblogs_id")
	private int newsblogsId;
	
	@Column(name="status_approval")
	private int statusApproval;
	
	@Column(name="approval_date")
	private String approvalDate;
	
	@Column(name="approve_by")
	private int approveBy;
	
	@Column(name="doc1")
	private String doc1;
	
	@Column(name="doc2")
	private int doc2;	
	
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
	private boolean isError;
	
	@Transient
	private String message;
	
	public int getEventRegId() {
		return eventRegId;
	}

	public void setEventRegId(int eventRegId) {
		this.eventRegId = eventRegId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getNewsblogsId() {
		return newsblogsId;
	}

	public void setNewsblogsId(int newsblogsId) {
		this.newsblogsId = newsblogsId;
	}

	public int getStatusApproval() {
		return statusApproval;
	}

	public void setStatusApproval(int statusApproval) {
		this.statusApproval = statusApproval;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public int getApproveBy() {
		return approveBy;
	}

	public void setApproveBy(int approveBy) {
		this.approveBy = approveBy;
	}

	public String getDoc1() {
		return doc1;
	}

	public void setDoc1(String doc1) {
		this.doc1 = doc1;
	}

	public int getDoc2() {
		return doc2;
	}

	public void setDoc2(int doc2) {
		this.doc2 = doc2;
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

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EventRegistrationForApp [eventRegId=" + eventRegId + ", userId=" + userId + ", regDate=" + regDate
				+ ", newsblogsId=" + newsblogsId + ", statusApproval=" + statusApproval + ", approvalDate="
				+ approvalDate + ", approveBy=" + approveBy + ", doc1=" + doc1 + ", doc2=" + doc2 + ", isActive="
				+ isActive + ", delStatus=" + delStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1="
				+ exVar1 + ", exVar2=" + exVar2 + ", isError=" + isError + ", message=" + message + "]";
	}

	 
	
	
}
