package com.ats.rusawebapi.model.mst;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_pass")
	private String userPass;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname; 
	
	@Column(name="middlename")
	private String middlename;
	 
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="sort_no")
	private int sortNo;
	
	@Column(name="del_status")
	private int delStatus;

	@Column(name="is_active")
	private int isActive;

	@Column(name="roles")
	private String roles;
	
	@Column(name="lastlogin_date")
	private Date lastloginDate;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Column(name="login_failure_count")
	private int loginFailureCount;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
	@Column(name="edit_by_user_id")
	private int editByUserId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLastloginDate() {
		return lastloginDate;
	}

	public void setLastloginDate(Date lastloginDate) {
		this.lastloginDate = lastloginDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(int loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}
	
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", userEmail="
				+ userEmail + ", firstname=" + firstname + ", lastname=" + lastname + ", middlename=" + middlename
				+ ", fileName=" + fileName + ", sortNo=" + sortNo + ", delStatus=" + delStatus + ", isActive="
				+ isActive + ", roles=" + roles + ", lastloginDate=" + lastloginDate + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", loginFailureCount=" + loginFailureCount + ", addedByUserId="
				+ addedByUserId + ", editByUserId=" + editByUserId + ", getUserId()=" + getUserId() + ", getUserName()="
				+ getUserName() + ", getUserPass()=" + getUserPass() + ", getUserEmail()=" + getUserEmail()
				+ ", getFirstname()=" + getFirstname() + ", getMiddlename()=" + getMiddlename() + ", getFileName()="
				+ getFileName() + ", getSortNo()=" + getSortNo() + ", getDelStatus()=" + getDelStatus()
				+ ", getIsActive()=" + getIsActive() + ", getRoles()=" + getRoles() + ", getLastloginDate()="
				+ getLastloginDate() + ", getCreatedDate()=" + getCreatedDate() + ", getModifiedDate()="
				+ getModifiedDate() + ", getLoginFailureCount()=" + getLoginFailureCount() + ", getLastname()="
				+ getLastname() + ", getAddedByUserId()=" + getAddedByUserId() + ", getEditByUserId()="
				+ getEditByUserId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
}
