package org.yeeku.model;

import java.util.ArrayList;
import java.util.List;

public class StudentAssistantVo {
	private Integer id;
	private String sid;
	private String name;
	private String email;
	private String cellphone;
	private String classid;
	private String classname;
	private String grade;
	private String jzfid;
	private String jzfname;
	private String jzfcellphone;
	private String jzmid;
	private String jzmname;
	private String jzmcellphone;
	private String note;
	private String idcard;
	private Integer sex;
	private String tempsex;
	private String majorname;
	private String pyxing;
	private String pyname;
    private String SCN;
    private String birthday;
    private String program;
    private String assistant;
    private String ielts;
    private String status;
    private String s_status;
    private Integer examstatus;//是否参加当前类型的考试  1，参加   2，没有参加
    private List<String> resultList=new ArrayList<String>();//当前类型的考试成绩
    private String zk;
	private String zkbz;
	private String zkbk;
	private String zkbkbz;
	private String cx;
	private String cxbz;
	private String bqk;
	private String bqkbz;
	private String qt;
	private String qtbz;
	private String tempResult;
	private String tempColor;
    private Score score;
    private Number count;
    private Integer classId;
    private Double baifenscore;
    private Integer dividestatus;
    private String tempzk;
    private String tempzkbk;
    private String tempbqk;
    private String tempqt;
    
    private Integer a_id;
	private String a_aname;
	private String a_email;
	private String a_aid;
	private String a_cellphone;
	private String a_classname;
	private Integer a_classnameid;
	private Integer a_sex;
	private String a_classroom;
	private Integer a__status; 
	private String a_s_status;
	private String a_tempsex;
	private String office_phone;	//辅导员办公电话
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getJzfid() {
		return jzfid;
	}
	public void setJzfid(String jzfid) {
		this.jzfid = jzfid;
	}
	public String getJzfname() {
		return jzfname;
	}
	public void setJzfname(String jzfname) {
		this.jzfname = jzfname;
	}
	public String getJzfcellphone() {
		return jzfcellphone;
	}
	public void setJzfcellphone(String jzfcellphone) {
		this.jzfcellphone = jzfcellphone;
	}
	public String getJzmid() {
		return jzmid;
	}
	public void setJzmid(String jzmid) {
		this.jzmid = jzmid;
	}
	public String getJzmname() {
		return jzmname;
	}
	public void setJzmname(String jzmname) {
		this.jzmname = jzmname;
	}
	public String getJzmcellphone() {
		return jzmcellphone;
	}
	public void setJzmcellphone(String jzmcellphone) {
		this.jzmcellphone = jzmcellphone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getTempsex() {
		return tempsex;
	}
	public void setTempsex(String tempsex) {
		this.tempsex = tempsex;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
	public String getPyxing() {
		return pyxing;
	}
	public void setPyxing(String pyxing) {
		this.pyxing = pyxing;
	}
	public String getPyname() {
		return pyname;
	}
	public void setPyname(String pyname) {
		this.pyname = pyname;
	}
	public String getSCN() {
		return SCN;
	}
	public void setSCN(String sCN) {
		SCN = sCN;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getAssistant() {
		return assistant;
	}
	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}
	public String getIelts() {
		return ielts;
	}
	public void setIelts(String ielts) {
		this.ielts = ielts;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getS_status() {
		return s_status;
	}
	public void setS_status(String s_status) {
		this.s_status = s_status;
	}
	public Integer getExamstatus() {
		return examstatus;
	}
	public void setExamstatus(Integer examstatus) {
		this.examstatus = examstatus;
	}
	public List<String> getResultList() {
		return resultList;
	}
	public void setResultList(List<String> resultList) {
		this.resultList = resultList;
	}
	public String getZk() {
		return zk;
	}
	public void setZk(String zk) {
		this.zk = zk;
	}
	public String getZkbz() {
		return zkbz;
	}
	public void setZkbz(String zkbz) {
		this.zkbz = zkbz;
	}
	public String getZkbk() {
		return zkbk;
	}
	public void setZkbk(String zkbk) {
		this.zkbk = zkbk;
	}
	public String getZkbkbz() {
		return zkbkbz;
	}
	public void setZkbkbz(String zkbkbz) {
		this.zkbkbz = zkbkbz;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getCxbz() {
		return cxbz;
	}
	public void setCxbz(String cxbz) {
		this.cxbz = cxbz;
	}
	public String getBqk() {
		return bqk;
	}
	public void setBqk(String bqk) {
		this.bqk = bqk;
	}
	public String getBqkbz() {
		return bqkbz;
	}
	public void setBqkbz(String bqkbz) {
		this.bqkbz = bqkbz;
	}
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
	}
	public String getQtbz() {
		return qtbz;
	}
	public void setQtbz(String qtbz) {
		this.qtbz = qtbz;
	}
	public String getTempResult() {
		return tempResult;
	}
	public void setTempResult(String tempResult) {
		this.tempResult = tempResult;
	}
	public String getTempColor() {
		return tempColor;
	}
	public void setTempColor(String tempColor) {
		this.tempColor = tempColor;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public Number getCount() {
		return count;
	}
	public void setCount(Number count) {
		this.count = count;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Double getBaifenscore() {
		return baifenscore;
	}
	public void setBaifenscore(Double baifenscore) {
		this.baifenscore = baifenscore;
	}
	public Integer getDividestatus() {
		return dividestatus;
	}
	public void setDividestatus(Integer dividestatus) {
		this.dividestatus = dividestatus;
	}
	public String getTempzk() {
		return tempzk;
	}
	public void setTempzk(String tempzk) {
		this.tempzk = tempzk;
	}
	public String getTempzkbk() {
		return tempzkbk;
	}
	public void setTempzkbk(String tempzkbk) {
		this.tempzkbk = tempzkbk;
	}
	public String getTempbqk() {
		return tempbqk;
	}
	public void setTempbqk(String tempbqk) {
		this.tempbqk = tempbqk;
	}
	public String getTempqt() {
		return tempqt;
	}
	public void setTempqt(String tempqt) {
		this.tempqt = tempqt;
	}
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	public String getA_aname() {
		return a_aname;
	}
	public void setA_aname(String a_aname) {
		this.a_aname = a_aname;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}
	public String getA_aid() {
		return a_aid;
	}
	public void setA_aid(String a_aid) {
		this.a_aid = a_aid;
	}
	public String getA_cellphone() {
		return a_cellphone;
	}
	public void setA_cellphone(String a_cellphone) {
		this.a_cellphone = a_cellphone;
	}
	public String getA_classname() {
		return a_classname;
	}
	public void setA_classname(String a_classname) {
		this.a_classname = a_classname;
	}
	public Integer getA_classnameid() {
		return a_classnameid;
	}
	public void setA_classnameid(Integer a_classnameid) {
		this.a_classnameid = a_classnameid;
	}
	public Integer getA_sex() {
		return a_sex;
	}
	public void setA_sex(Integer a_sex) {
		this.a_sex = a_sex;
	}
	public String getA_classroom() {
		return a_classroom;
	}
	public void setA_classroom(String a_classroom) {
		this.a_classroom = a_classroom;
	}
	public Integer getA__status() {
		return a__status;
	}
	public void setA__status(Integer a__status) {
		this.a__status = a__status;
	}
	public String getA_s_status() {
		return a_s_status;
	}
	public void setA_s_status(String a_s_status) {
		this.a_s_status = a_s_status;
	}
	public String getA_tempsex() {
		return a_tempsex;
	}
	public void setA_tempsex(String a_tempsex) {
		this.a_tempsex = a_tempsex;
	}
	public String getOffice_phone() {
		return office_phone;
	}
	public void setOffice_phone(String office_phone) {
		this.office_phone = office_phone;
	}
}