package org.yeeku.model;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class ClassroomApply implements java.io.Serializable{
	private int id;
	
	private int clrid;
	private Date createtime;
	private Date applydate;
	private String sapplydate;
	private String applystarttime;
	private String applyendtime;
	private int approvestatus;
	private int approverid;
	private int userid;
	private String user;
	private String roomname;
	private String campus;
	private String approver;
	private String applyreason;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClrid() {
		return clrid;
	}
	public void setClrid(int clrid) {
		this.clrid = clrid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getApplydate() {
		return applydate;
	}
	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}
	public String getApplystarttime() {
		return applystarttime;
	}
	public void setApplystarttime(String applystarttime) {
		this.applystarttime = applystarttime;
	}
	public String getApplyendtime() {
		return applyendtime;
	}
	public void setApplyendtime(String applyendtime) {
		this.applyendtime = applyendtime;
	}

	public int getApprovestatus() {
		return approvestatus;
	}
	public void setApprovestatus(int approvestatus) {
		this.approvestatus = approvestatus;
	}
	public int getApproverid() {
		return approverid;
	}
	public void setApproverid(int approverid) {
		this.approverid = approverid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @param sapplydate the sapplydate to set
	 */
	public void setSapplydate(String sapplydate) {
		this.sapplydate = sapplydate;
	}
	/**
	 * @return the sapplydate
	 */
	public String getSapplydate() {
		return sapplydate;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param roomname the roomname to set
	 */
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	/**
	 * @return the roomname
	 */
	public String getRoomname() {
		return roomname;
	}
	/**
	 * @param campus the campus to set
	 */
	public void setCampus(String campus) {
		this.campus = campus;
	}
	/**
	 * @return the campus
	 */
	public String getCampus() {
		return campus;
	}
	/**
	 * @param approver the approver to set
	 */
	public void setApprover(String approver) {
		this.approver = approver;
	}
	/**
	 * @return the approver
	 */
	public String getApprover() {
		return approver;
	}
	/**
	 * @param applyreason the applyreason to set
	 */
	public void setApplyreason(String applyreason) {
		this.applyreason = applyreason;
	}
	/**
	 * @return the applyreason
	 */
	public String getApplyreason() {
		return applyreason;
	}


	
	


}
