package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "t_registration")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reg_id")
	private int regId;
	
	@Column(name="user_uuid")
	private String userUuid;
	
	@Column(name="user_type")
	private int userType;
	
	@Column(name="emails")
	private String emails;
	
	@Column(name="alternate_email")
	private String alternateEmail;

	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="name")
	private String name;
	
	@Column(name="aishe_code")
	private String aisheCode;
	
	@Column(name="college_name")
	private String collegeName;
	
	@Column(name="unversity_name")
	private String unversityName;
	
	@Column(name="designation_name")
	private String designationName;

	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="authorized_person")
	private String authorizedPerson;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="token_id")
	private String tokenId;
	
	@Column(name="register_via")
	private String registerVia;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="add_date")
	private String addDate;
	
	@Column(name="edit_date")
	private String editDate;
		
	@Column(name="edit_by_user_id")
	private int editByUserId;

	@Column(name="ex_int1")
	private int exInt1;
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="email_code")
	private String emailCode;
	
	@Column(name="email_verified")
	private int emailVerified;
	
	@Column(name="sms_code")
	private String smsCode;
	
	@Column(name="sms_verified")
	private int smsVerified;
	
	@Column(name="edit_by_adminuser_id")
	private int editByAdminuserId;
	
	@Transient
	private String msg;
	
	@Transient
	private boolean isError;

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAisheCode() {
		return aisheCode;
	}

	public void setAisheCode(String aisheCode) {
		this.aisheCode = aisheCode;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUnversityName() {
		return unversityName;
	}

	public void setUnversityName(String unversityName) {
		this.unversityName = unversityName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAuthorizedPerson() {
		return authorizedPerson;
	}

	public void setAuthorizedPerson(String authorizedPerson) {
		this.authorizedPerson = authorizedPerson;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getRegisterVia() {
		return registerVia;
	}

	public void setRegisterVia(String registerVia) {
		this.registerVia = registerVia;
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

	public int getEditByUserId() {
		return editByUserId;
	}

	public void setEditByUserId(int editByUserId) {
		this.editByUserId = editByUserId;
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

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public int getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(int emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public int getSmsVerified() {
		return smsVerified;
	}

	public void setSmsVerified(int smsVerified) {
		this.smsVerified = smsVerified;
	}

	public int getEditByAdminuserId() {
		return editByAdminuserId;
	}

	public void setEditByAdminuserId(int editByAdminuserId) {
		this.editByAdminuserId = editByAdminuserId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	@Override
	public String toString() {
		return "Registration [regId=" + regId + ", userUuid=" + userUuid + ", userType=" + userType + ", emails="
				+ emails + ", alternateEmail=" + alternateEmail + ", userPassword=" + userPassword + ", name=" + name
				+ ", aisheCode=" + aisheCode + ", collegeName=" + collegeName + ", unversityName=" + unversityName
				+ ", designationName=" + designationName + ", departmentName=" + departmentName + ", mobileNumber="
				+ mobileNumber + ", authorizedPerson=" + authorizedPerson + ", dob=" + dob + ", imageName=" + imageName
				+ ", tokenId=" + tokenId + ", registerVia=" + registerVia + ", isActive=" + isActive + ", delStatus="
				+ delStatus + ", addDate=" + addDate + ", editDate=" + editDate + ", editByUserId=" + editByUserId
				+ ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2
				+ ", emailCode=" + emailCode + ", emailVerified=" + emailVerified + ", smsCode=" + smsCode
				+ ", smsVerified=" + smsVerified + ", editByAdminuserId=" + editByAdminuserId + ", msg=" + msg
				+ ", isError=" + isError + "]";
	}
	
	
	 
}
