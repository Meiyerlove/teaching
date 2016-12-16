package org.yeeku.model;

import java.util.Date;

public class ManualRecord {
	
	private int id;
	
	private String emplID;
	
	private String emplName;
	
	private String subject;
	
	private String teacherID;
	
	private String teacherName;
	
	private int roomID;
	
	private String roomNO;
	
	private Date recordTime;
	
	private String recordTimeFormat;
	
	private Date payTime;

	private String status;
	
	private String cellPhone;
	
	private String reasonType;

	private String note;
	
	private Boolean contained;
	
	private int lessonNumber;
	
	private String lessonDate;
	
	private String operBy;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmplID() {
		return emplID;
	}

	public void setEmplID(String emplID) {
		this.emplID = emplID;
	}

	public String getEmplName() {
		return emplName;
	}

	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomNO() {
		return roomNO;
	}

	public void setRoomNO(String roomNO) {
		this.roomNO = roomNO;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
	public String getRecordTimeFormat() {
		return recordTimeFormat;
	}

	public void setRecordTimeFormat(String recordTimeFormat) {
		this.recordTimeFormat = recordTimeFormat;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Boolean getContained() {
		return contained;
	}

	public void setContained(Boolean contained) {
		this.contained = contained;
	}

	public int getLessonNumber() {
		return lessonNumber;
	}

	public void setLessonNumber(int lessonNumber) {
		this.lessonNumber = lessonNumber;
	}

	public String getLessonDate() {
		return lessonDate;
	}

	public void setLessonDate(String lessonDate) {
		this.lessonDate = lessonDate;
	}

	public String getOperBy() {
		return operBy;
	}

	public void setOperBy(String operBy) {
		this.operBy = operBy;
	}
}
