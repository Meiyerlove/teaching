package org.yeeku.model;

public class HistoryStudent implements java.io.Serializable{
	
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
	private String majorname;
	private String pyxing;
	private String pyname;
    private String SCN;
    private String birthday;
    private String program;
    private String assistant;
    
    private Score score;
    
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
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
	public void setSCN(String scn) {
		SCN = scn;
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
	public String getAssistant() {
		return assistant;
	}
	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
}
