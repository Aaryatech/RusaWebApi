package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logo")
public class Logo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="logo_main")
	private String logoMain;
	@Column(name="logo2")
	private String logo2;
	@Column(name="logo3")
	private String logo3;
	@Column(name="add_date")
	private String addDate;
	@Column(name="edit_date")
	private int editDate;
	@Column(name="added_by_user_id")
	private int addedByUserId;
	@Column(name="edit_by_user_id")
	private int editByUserId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogoMain() {
		return logoMain;
	}
	public void setLogoMain(String logoMain) {
		this.logoMain = logoMain;
	}
	public String getLogo2() {
		return logo2;
	}
	public void setLogo2(String logo2) {
		this.logo2 = logo2;
	}
	public String getLogo3() {
		return logo3;
	}
	public void setLogo3(String logo3) {
		this.logo3 = logo3;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public int getEditDate() {
		return editDate;
	}
	public void setEditDate(int editDate) {
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
	@Override
	public String toString() {
		return "Logo [id=" + id + ", logoMain=" + logoMain + ", logo2=" + logo2 + ", logo3=" + logo3 + ", addDate="
				+ addDate + ", editDate=" + editDate + ", addedByUserId=" + addedByUserId + ", editByUserId="
				+ editByUserId + "]";
	}
	
	
}
