package org.yeeku.model;

import java.util.Date;

public class Adjust implements java.io.Serializable{
	
	private Integer id;
	private String classname;
	private String subjectname;
	private String teachername;
	private String classroom;
	private String newlcassroom;
	//private Date datebefore;
	private String datebefore;
	private String starttimebefore;
	private String endtimebefore;
	private String tknumber;
	//private Date dateafter;
	private String dateafter;
	private String starttimeafter;
	private String endtimeafter;
	private String reason;
	private String edureason;
	private String deanreason;
	
	private Integer status;
	private String s_status;
	private int v_id;
	private String publishdate;
	
	public String getS_status() {
		return s_status;
	}
	public void setS_status(String s_status) {
		this.s_status = s_status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
//	public Date getDatebefore() {
//		return datebefore;
//	}
//	public void setDatebefore(Date datebefore) {
//		this.datebefore = datebefore;
//	}
	public String getStarttimebefore() {
		return starttimebefore;
	}
	public void setStarttimebefore(String starttimebefore) {
		this.starttimebefore = starttimebefore;
	}
	public String getEndtimebefore() {
		return endtimebefore;
	}
	public void setEndtimebefore(String endtimebefore) {
		this.endtimebefore = endtimebefore;
	}
//	public Date getDateafter() {
//		return dateafter;
//	}
//	public void setDateafter(Date dateafter) {
//		this.dateafter = dateafter;
//	}
	public String getStarttimeafter() {
		return starttimeafter;
	}
	public void setStarttimeafter(String starttimeafter) {
		this.starttimeafter = starttimeafter;
	}
	public String getEndtimeafter() {
		return endtimeafter;
	}
	public void setEndtimeafter(String endtimeafter) {
		this.endtimeafter = endtimeafter;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getTknumber() {
		return tknumber;
	}
	public void setTknumber(String tknumber) {
		this.tknumber = tknumber;
	}
	public String getEdureason() {
		return edureason;
	}
	public void setEdureason(String edureason) {
		this.edureason = edureason;
	}
	public String getDeanreason() {
		return deanreason;
	}
	public void setDeanreason(String deanreason) {
		this.deanreason = deanreason;
	}
	public String getNewlcassroom() {
		return newlcassroom;
	}
	public void setNewlcassroom(String newlcassroom) {
		this.newlcassroom = newlcassroom;
	}
	public String getDatebefore() {
		return datebefore;
	}
	public void setDatebefore(String datebefore) {
		this.datebefore = datebefore;
	}
	public String getDateafter() {
		return dateafter;
	}
	public void setDateafter(String dateafter) {
		this.dateafter = dateafter;
	}
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	
}
