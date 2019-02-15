package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_contact_us")
public class ContactUs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="contact_name")
	private String contactName;
		

	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="message")
	private String message;
	
	@Column(name="topic")
	private String topic;
	
	@Column(name="user_agent")
	private String userAgent;
	
	@Column(name="add_date")
	private String addDate;
	
	@Column(name="status")
	private int status;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="status_by_admin")
	private int statusByAdmin;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="ex_int1")
	private int exInt1;
	
	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_var1")
	private String exVar1;
	
	@Column(name="ex_var2")
	private String exVar2;
	
	@Column(name="del_status")
	private int delStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
	

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remar) {
		this.remark = remar;
	}

	public int getStatusByAdmin() {
		return statusByAdmin;
	}

	public void setStatusByAdmin(int statusByAdmin) {
		this.statusByAdmin = statusByAdmin;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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

	
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", contactName=" + contactName + ", emailId=" + emailId + ", mobileNo="
				+ mobileNo + ", message=" + message + ", topic=" + topic + ", userAgent=" + userAgent + ", addDate="
				+ addDate + ", status=" + status + ", remark=" + remark + ", statusByAdmin=" + statusByAdmin
				+ ", ipAddress=" + ipAddress + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVar1=" + exVar1
				+ ", exVar2=" + exVar2 + ", delStatus=" + delStatus + "]";
	}

	

	
}
