package com.ats.rusawebapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class EventView {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "newsblogs_id")
	private int newsblogsId;

	@Column(name = "heading")
	private String heading; 
	
	@Column(name = "module_id")
	private int moduleId;
	
	@Column(name = "descriptions")
	private String descriptions;
	
	@Column(name = "add_date")
	private String addDate;
	
	@Column(name="event_location")
	private String eventLocation;
	
	@Column(name="event_date_from")
	private String eventDateFrom;
	
	@Column(name="event_contact_person")
	private String eventContactPerson;
	
	@Column(name="event_contact_number")
	private String eventContactNumber;
	
	@Column(name = "edit_date")
	private String editDate;

	@Column(name="ex_int2")
	private int exInt2;
	
	/*
	 * @Transient private int totalApplied;
	 * 
	 * @Transient private int totalApprove;
	 */
	
	public int getNewsblogsId() {
		return newsblogsId;
	}

	public void setNewsblogsId(int newsblogsId) {
		this.newsblogsId = newsblogsId;
	}


	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDateFrom() {
		return eventDateFrom;
	}

	public void setEventDateFrom(String eventDateFrom) {
		this.eventDateFrom = eventDateFrom;
	}

	public String getEventContactPerson() {
		return eventContactPerson;
	}

	public void setEventContactPerson(String eventContactPerson) {
		this.eventContactPerson = eventContactPerson;
	}

	public String getEventContactNumber() {
		return eventContactNumber;
	}

	public void setEventContactNumber(String eventContactNumber) {
		this.eventContactNumber = eventContactNumber;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	
	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	@Override
	public String toString() {
		return "EventView [newsblogsId=" + newsblogsId + ", heading=" + heading + ", moduleId=" + moduleId
				+ ", descriptions=" + descriptions + ", addDate=" + addDate + ", eventLocation=" + eventLocation
				+ ", eventDateFrom=" + eventDateFrom + ", eventContactPerson=" + eventContactPerson
				+ ", eventContactNumber=" + eventContactNumber + ", editDate=" + editDate + ", exInt2=" + exInt2 + "]";
	}


	




}
