package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class DashboardCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="contact_count")
	private int contactCount;
	
	@Column(name="new_user_count")
	private int newUserCount;
		 
	@Column(name="collage_user_count")
	private int collageUserCount;
	
	@Column(name="univercity_user_count")
	private int univercityUserCount;
	
	@Column(name="individual_user_count")
	private int individualUserCount;

	public int getContactCount() {
		return contactCount;
	}

	public void setContactCount(int contactCount) {
		this.contactCount = contactCount;
	}

	public int getNewUserCount() {
		return newUserCount;
	}

	public void setNewUserCount(int newUserCount) {
		this.newUserCount = newUserCount;
	}

	public int getCollageUserCount() {
		return collageUserCount;
	}

	public void setCollageUserCount(int collageUserCount) {
		this.collageUserCount = collageUserCount;
	}

	public int getUnivercityUserCount() {
		return univercityUserCount;
	}

	public void setUnivercityUserCount(int univercityUserCount) {
		this.univercityUserCount = univercityUserCount;
	}

	public int getIndividualUserCount() {
		return individualUserCount;
	}

	public void setIndividualUserCount(int individualUserCount) {
		this.individualUserCount = individualUserCount;
	}

	@Override
	public String toString() {
		return "DashboardCount [contactCount=" + contactCount + ", newUserCount=" + newUserCount + ", collageUserCount="
				+ collageUserCount + ", univercityUserCount=" + univercityUserCount + ", individualUserCount="
				+ individualUserCount + "]";
	}
	 
	
	

}
