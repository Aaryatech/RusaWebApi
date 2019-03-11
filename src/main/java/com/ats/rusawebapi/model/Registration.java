package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_registration")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reg_id")
	private int reg_id;
	
	@Column(name="user_uuid")
	private String user_uuid;
	
	@Column(name="user_type")
	private int user_type;
	
	@Column(name="emails")
	private String emails;
	
	@Column(name="alternate_email")
	private String alternate_email;

	@Column(name="user_password")
	private String user_password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="aishe_code")
	private String aishe_code;
	
	@Column(name="college_name")
	private String college_name;
	
	@Column(name="unversity_name")
	private String unversity_name;
	
	@Column(name="designation_name")
	private String designation_name;

	@Column(name="department_name")
	private String department_name;
	@Column(name="mobile_number")
	private String mobile_number;
	
	@Column(name="authorized_person")
	private String authorized_person;
	
	@Column(name="dob")
	private String dob;
	@Column(name="image_name")
	private String image_name;
	@Column(name="token_id")
	private String token_id;
	@Column(name="register_via")
	private String register_via;
	
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="add_date")
	private String addDate;
	
	@Column(name="edit_date")
	private String editDate;
	
	@Column(name="added_by_user_id")
	private int addedByUserId;
	
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

	public int getReg_id() {
		return reg_id;
	}

	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getAlternate_email() {
		return alternate_email;
	}

	public void setAlternate_email(String alternate_email) {
		this.alternate_email = alternate_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAishe_code() {
		return aishe_code;
	}

	public void setAishe_code(String aishe_code) {
		this.aishe_code = aishe_code;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getUnversity_name() {
		return unversity_name;
	}

	public void setUnversity_name(String unversity_name) {
		this.unversity_name = unversity_name;
	}

	public String getDesignation_name() {
		return designation_name;
	}

	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAuthorized_person() {
		return authorized_person;
	}

	public void setAuthorized_person(String authorized_person) {
		this.authorized_person = authorized_person;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}

	public String getRegister_via() {
		return register_via;
	}

	public void setRegister_via(String register_via) {
		this.register_via = register_via;
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

	@Override
	public String toString() {
		return "Registration [reg_id=" + reg_id + ", user_uuid=" + user_uuid + ", user_type=" + user_type + ", emails="
				+ emails + ", alternate_email=" + alternate_email + ", user_password=" + user_password + ", name="
				+ name + ", aishe_code=" + aishe_code + ", college_name=" + college_name + ", unversity_name="
				+ unversity_name + ", designation_name=" + designation_name + ", department_name=" + department_name
				+ ", mobile_number=" + mobile_number + ", authorized_person=" + authorized_person + ", dob=" + dob
				+ ", image_name=" + image_name + ", token_id=" + token_id + ", register_via=" + register_via
				+ ", isActive=" + isActive + ", delStatus=" + delStatus + ", addDate=" + addDate + ", editDate="
				+ editDate + ", addedByUserId=" + addedByUserId + ", editByUserId=" + editByUserId + ", exInt1="
				+ exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + "]";
	}

	
	

}
