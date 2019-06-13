package com.ats.rusawebapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_upload_doc")
public class UploadDocument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="doc_id")
	private int docId;
	
	@Column(name="reg_id")
	private int regId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="extra_int1")
	private int extraInt1;
	
	@Column(name="extra_varchar1")
	private String extraVarchar1;
	
	@Column(name="upload_date_time")
	private String uploadDateTime;
	
	@Column(name="doc_size")
	private long docSize;
	
	@Column(name="type_name")
	private String typeName;

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getExtraInt1() {
		return extraInt1;
	}

	public void setExtraInt1(int extraInt1) {
		this.extraInt1 = extraInt1;
	}

	public String getExtraVarchar1() {
		return extraVarchar1;
	}

	public void setExtraVarchar1(String extraVarchar1) {
		this.extraVarchar1 = extraVarchar1;
	}

	public String getUploadDateTime() {
		return uploadDateTime;
	}

	public void setUploadDateTime(String uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}

	public long getDocSize() {
		return docSize;
	}

	public void setDocSize(long docSize) {
		this.docSize = docSize;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "UploadDocument [docId=" + docId + ", regId=" + regId + ", title=" + title + ", fileName=" + fileName
				+ ", typeId=" + typeId + ", delStatus=" + delStatus + ", extraInt1=" + extraInt1 + ", extraVarchar1="
				+ extraVarchar1 + ", uploadDateTime=" + uploadDateTime + ", docSize=" + docSize + ", typeName="
				+ typeName + "]";
	}
	
	
	
	

}
