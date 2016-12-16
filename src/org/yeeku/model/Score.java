package org.yeeku.model;

import java.util.Date;

public class Score implements java.io.Serializable{
	
	private Integer id;
	private String sid;
	private Integer subjectid;
	private String subjectname;
	private String score;
	private Date examdate;
	private Integer examid;
	private Integer classkey;
	private String exam1;
	private String exam2;
	private String exam3;
	private String exam4;
	private String exam5;
	private String exam6;
	private String exam7;
	private String exam8;
	private Integer phaseid;
	private String ielts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Integer getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Date getExamdate() {
		return examdate;
	}
	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}
	public Integer getExamid() {
		return examid;
	}
	public void setExamid(Integer examid) {
		this.examid = examid;
	}
	public Integer getClasskey() {
		return classkey;
	}
	public void setClasskey(Integer classkey) {
		this.classkey = classkey;
	}
	public String getExam1() {
		return exam1;
	}
	public void setExam1(String exam1) {
		this.exam1 = exam1;
	}
	public String getExam2() {
		return exam2;
	}
	public void setExam2(String exam2) {
		this.exam2 = exam2;
	}
	public String getExam3() {
		return exam3;
	}
	public void setExam3(String exam3) {
		this.exam3 = exam3;
	}
	public String getExam4() {
		return exam4;
	}
	public void setExam4(String exam4) {
		this.exam4 = exam4;
	}
	public String getExam5() {
		return exam5;
	}
	public void setExam5(String exam5) {
		this.exam5 = exam5;
	}
	public String getExam6() {
		return exam6;
	}
	public void setExam6(String exam6) {
		this.exam6 = exam6;
	}
	public String getExam7() {
		return exam7;
	}
	public void setExam7(String exam7) {
		this.exam7 = exam7;
	}
	public String getExam8() {
		return exam8;
	}
	public void setExam8(String exam8) {
		this.exam8 = exam8;
	}
	public Integer getPhaseid() {
		return phaseid;
	}
	public void setPhaseid(Integer phaseid) {
		this.phaseid = phaseid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getIelts() {
		return ielts;
	}
	public void setIelts(String ielts) {
		this.ielts = ielts;
	}
}
