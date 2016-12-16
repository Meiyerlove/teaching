package org.yeeku.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.BeanUtils;
import org.yeeku.JDBCConnection;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Absence;
import org.yeeku.model.Adjust;
import org.yeeku.model.Assistant;
import org.yeeku.model.DifferentPhase;
import org.yeeku.model.EnterApply;
import org.yeeku.model.Exam;
import org.yeeku.model.Exampj;
import org.yeeku.model.HistoryStudent;
import org.yeeku.model.Ielts;
import org.yeeku.model.Jieke;
import org.yeeku.model.Jzletter;
import org.yeeku.model.Kecheng;
import org.yeeku.model.Kechengversion;
import org.yeeku.model.Logging;
import org.yeeku.model.Notice;
import org.yeeku.model.Punish;
import org.yeeku.model.Renke;
import org.yeeku.model.Reward;
import org.yeeku.model.Role;
import org.yeeku.model.Score;
import org.yeeku.model.ScoreNew;
import org.yeeku.model.Student;
import org.yeeku.model.Subject;
import org.yeeku.model.TClass;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;
import org.yeeku.model.Sec_Kecheng;
import org.yeeku.util.BCConvert;
import org.yeeku.util.DateHandle;
import org.yeeku.util.ExcelParser;
import org.yeeku.util.ExcelUtil2007;

import com.alibaba.fastjson.JSONArray;
import com.bw30.zjvote.config.BaseDao;
import com.opensymphony.xwork2.ActionContext;
public class ManageAction extends BaseAction{
	
	private List<Student> studentList;
	private List studentListScore;
	private List majorList;
	private List assistantList;
	private List classList;
	private List subjectList;
	private List teacherList;
	private List kechengList;
	private List kechenglist;
	private List allKechengList;
	private List kechengClass;
	private List absenceList;
	private List kechengversionList;
	private List adjustList;
	private List delayList;
	private List loggingList;
	private List exampjList;
	private File upload;
	private File upload1;
	private String contentType;
	private ExcelParser xslParser;
	private StringBuffer errorLine;
	private String examid;
	private String versions;
	private String prompt;
	private String radid;
	private String kcversions;
	private List roleList;
	private String top;
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}
	public List getKechenglist() {
		return kechenglist;
	}
	public void setKechenglist(List kechenglist) {
		this.kechenglist = kechenglist;
	}
	public List getAllKechengList() {
		return allKechengList;
	}
	public void setAllKechengList(List allKechengList) {
		this.allKechengList = allKechengList;
	}
	public String getVersions() {
		return versions;
	}
	public void setVersions(String versions) {
		this.versions = versions;
	}
	public List getKechengversionList() {
		return kechengversionList;
	}
	public void setKechengversionList(List kechengversionList) {
		this.kechengversionList = kechengversionList;
	}
	public List getKechengClass() {
		return kechengClass;
	}
	public void setKechengClass(List kechengClass) {
		this.kechengClass = kechengClass;
	}
	public List getStudentListScore() {
		return studentListScore;
	}
	public void setStudentListScore(List studentListScore) {
		this.studentListScore = studentListScore;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getUploadContentType() {
		return contentType;
	}
	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}
	public List getMajorList() {
		return majorList;
	}
	public void setMajorList(List majorList) {
		this.majorList = majorList;
	}
	public List getAssistantList() {
		return assistantList;
	}
	public void setAssistantList(List assistantList) {
		this.assistantList = assistantList;
	}
	public List getClassList() {
		return classList;
	}
	public void setClassList(List classList) {
		this.classList = classList;
	}
	public List getStudentList() {
		return studentList;
	}
	public void setStudentList(List studentList) {
		this.studentList = studentList;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload1() {
		return upload1;
	}
	public void setUpload1(File upload1) {
		this.upload1 = upload1;
	}
	public List getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List subjectList) {
		this.subjectList = subjectList;
	}
	public List getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List teacherList) {
		this.teacherList = teacherList;
	}
	public List getKechengList() {
		return kechengList;
	}
	public void setKechengList(List kechengList) {
		this.kechengList = kechengList;
	}
	public List getAbsenceList() {
		return absenceList;
	}
	public void setAbsenceList(List absenceList) {
		this.absenceList = absenceList;
	}
	public List getAdjustList() {
		return adjustList;
	}
	public void setAdjustList(List adjustList) {
		this.adjustList = adjustList;
	}
	public List getLoggingList() {
		return loggingList;
	}
	public void setLoggingList(List loggingList) {
		this.loggingList = loggingList;
	}
	public List getDelayList() {
		return delayList;
	}
	public void setDelayList(List delayList) {
		this.delayList = delayList;
	}
	public List getExampjList() {
		return exampjList;
	}
	public void setExampjList(List exampjList) {
		this.exampjList = exampjList;
	}	
	public List getRoleList() {
		return roleList;
	}
	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}
	
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String toStudentList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		Integer roleid=user.getUserType();
    		//studentList = mgr.getStudentList();
    		//request.setAttribute("studentList", studentList);
//    		if(user.getUserType()==7){
//    			Integer teacherId=user.getId();
//    			Teacher teacher=(Teacher) this.combiz.get(Teacher.class, teacherId);
//    				request.setAttribute("teachername", teacher.getName());
//    		 }
    		request.setAttribute("roleid", roleid);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "studentList";
    }
	
	public String toStudentAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		classList = mgr.getClassList();
    		assistantList = mgr.getAssistantList();
    		
    		request.setAttribute("classList", classList);
    		request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentAdd";
    }

	@SuppressWarnings("unused")
	public String toStudentEdit(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpSession session=ServletActionContext.getRequest().getSession();
    		User user=(User) session.getAttribute("tuser");
    		classList = mgr.getClassList();
    		assistantList = mgr.getAssistantList();
    		Assistant aa = new Assistant();
    		String studentid = request.getParameter("studentid");
    		Student student = new Student();
    		if(null != studentid && !studentid.equals("")){
    			student = (Student) this.combiz.get(Student.class, Integer.valueOf(studentid));
				aa = mgr.getAssistantByName(student.getAssistant());
    		}

    		request.setAttribute("student", student);
    		request.setAttribute("aa", aa);
    		request.setAttribute("classList", classList);
    		request.setAttribute("assistantList", assistantList);
    		if(null!=user){
    			if(user.getUserType()==3){
    				return "toStudentEditJiaowu";
    			}
    			else{
    				return "toStudentEdit";
    			}
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "";
    }
	
	public String doStudentAdd(){
		String returnvalue = "doStudentAdd";
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		
    		String name = request.getParameter("name");
    		String sid = request.getParameter("sid");
    		
            List checkList = mgr.getStudentList(sid);
    		if(null != checkList && checkList.size() > 0){
    			addActionMessage("此学生已经存在，不能再添加");
    			return returnvalue;
    		}
    		
    		String idcard = request.getParameter("idcard");
    		String email = request.getParameter("email");
    		String cellphone = request.getParameter("cellphone");
    		String classname = request.getParameter("classname");
    		String grade = request.getParameter("grade");
    		String jzfid = request.getParameter("jzfid");
    		String jzfname = request.getParameter("jzfname");
    		String jzfcellphone = request.getParameter("jzfcellphone");
    		String jzmid = request.getParameter("jzmid");
    		String jzmname = request.getParameter("jzmname");
    		String jzmcellphone = request.getParameter("jzmcellphone");
    		String note = request.getParameter("note");
    		String sex = request.getParameter("sex");
    		String majorname = request.getParameter("majorname");
    		String pyxing = request.getParameter("pyxing");
    		String pyname = request.getParameter("pyname");
    		String SCN = request.getParameter("SCN");
    		String birthday = request.getParameter("birthday");
    		String program = request.getParameter("program");
    		String assistant = request.getParameter("assistant");
    		Student stu = new Student();
    		try {
    			
    			name = (name != null)?new String(name.getBytes("iso-8859-1"),"utf-8"):name;
    			sid = (sid != null)?new String(sid.getBytes("iso-8859-1"),"utf-8"):sid;
    			idcard = (idcard != null)?new String(idcard.getBytes("iso-8859-1"),"utf-8"):idcard;
    			classname = (classname != null)?new String(classname.getBytes("iso-8859-1"),"utf-8"):classname;
    			majorname = (majorname != null)?new String(majorname.getBytes("iso-8859-1"),"utf-8"):majorname;
    			program = (program != null)?new String(program.getBytes("iso-8859-1"),"utf-8"):program;
    			assistant = (assistant != null)?new String(assistant.getBytes("iso-8859-1"),"utf-8"):assistant;
    			note = (note != null)?new String(note.getBytes("iso-8859-1"),"utf-8"):note;
    			jzmname = (jzmname != null)?new String(jzmname.getBytes("iso-8859-1"),"utf-8"):jzmname;
    			jzfname = (jzfname != null)?new String(jzfname.getBytes("iso-8859-1"),"utf-8"):jzfname;
    			pyxing=(pyxing!=null)?new String(pyxing.getBytes("iso-8859-1"),"utf-8"):pyxing;
    			pyname = (pyname != null)?new String(pyname.getBytes("iso-8859-1"),"utf-8"):pyname;
    			
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		stu.setName(name);
    		stu.setSid(sid);
    		stu.setIdcard(idcard);
    		stu.setEmail(email);
    		stu.setCellphone(cellphone);
    		stu.setClassname(classname);
    		stu.setGrade(grade);
    		stu.setJzfid(jzfid);
    		stu.setJzfname(jzfname);
    		stu.setJzfcellphone(jzfcellphone);
    		stu.setJzmid(jzmid);
    		stu.setJzmname(jzmname);
    		stu.setJzmcellphone(jzmcellphone);
    		stu.setNote(note);
    		stu.setMajorname(majorname);
    		stu.setPyxing(pyxing);
    		stu.setPyname(pyname);
    		stu.setSCN(SCN);
    		stu.setBirthday(birthday);
    		stu.setProgram(program);
    		stu.setAssistant(assistant);
    		stu.setStatus("1");
    		stu.setSex(Integer.valueOf(sex));
    		stu.setDividestatus(0);
//    		if(null != sex && !sex.equals("")){
//    			stu.setSex(Integer.valueOf(sex));
//    		}else{
//    			stu.setSex(null);
//    		}
    		
    		
    		this.combiz.saveOrupate(stu);   	
    		addActionMessage("学生保存成功");
    		
    		
    			User user = new User();
        		user.setUser(sid);
        		user.setPass(idcard.substring(idcard.length()-6,idcard.length()));
        		user.setUserType(8);
        		user.set_status(1);
        		this.combiz.saveOrupate(user);  
    		
    		
    		classList = mgr.getClassList();
    		assistantList = mgr.getAssistantList();
    		
    		request.setAttribute("classList", classList);
    		request.setAttribute("assistantList", assistantList);
    		//roleList = mgr.getRoleList();
    		//request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return returnvalue;
    }
	
	public String doStudentEdit(){
		String returnvalue = "doStudentEdit";
		String returnvaluejaowu = "toStudentEditJiaowu";
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpSession session=ServletActionContext.getRequest().getSession();
    		User user=(User) session.getAttribute("tuser");
    		String name = request.getParameter("name");
    		String sid = request.getParameter("sid");
    		
    		String idcard = request.getParameter("idcard");
    		String email = request.getParameter("email");
    		String cellphone = request.getParameter("cellphone");
    		String classname = request.getParameter("classname");
    		String grade = request.getParameter("grade");
    		String jzfid = request.getParameter("jzfid");
    		String jzfname = request.getParameter("jzfname");
    		String jzfcellphone = request.getParameter("jzfcellphone");
    		String jzmid = request.getParameter("jzmid");
    		String jzmname = request.getParameter("jzmname");
    		String jzmcellphone = request.getParameter("jzmcellphone");
    		String note = request.getParameter("note");
    		String sex = request.getParameter("sex");
    		String majorname = request.getParameter("majorname");
    		String pyxing = request.getParameter("pyxing");
    		String pyname = request.getParameter("pyname");
    		String SCN = request.getParameter("SCN");
    		String birthday = request.getParameter("birthday");
    		String program = request.getParameter("program");
    		String assistant = request.getParameter("assistant");
    		String currentstatus=request.getParameter("status");
    		
    		Student stu = null;	
    		String studentid = request.getParameter("studentid");
    		
    		stu = (Student) this.combiz.get(Student.class, Integer.valueOf(studentid));
    		String _status=stu.getStatus();
    		try {
    			
    			name = (name != null)?new String(name.getBytes("iso-8859-1"),"utf-8"):name;
    			sid = (sid != null)?new String(sid.getBytes("iso-8859-1"),"utf-8"):sid;
    			idcard = (idcard != null)?new String(idcard.getBytes("iso-8859-1"),"utf-8"):idcard;
    			classname = (classname != null)?new String(classname.getBytes("iso-8859-1"),"utf-8"):classname;
    			majorname = (majorname != null)?new String(majorname.getBytes("iso-8859-1"),"utf-8"):majorname;
    			program = (program != null)?new String(program.getBytes("iso-8859-1"),"utf-8"):program;
    			assistant = (assistant != null)?new String(assistant.getBytes("iso-8859-1"),"utf-8"):assistant;
    			note = (note != null)?new String(note.getBytes("iso-8859-1"),"utf-8"):note;
    			jzmname = (jzmname != null)?new String(jzmname.getBytes("iso-8859-1"),"utf-8"):jzmname;
    			jzfname = (jzfname != null)?new String(jzfname.getBytes("iso-8859-1"),"utf-8"):jzfname;
    			
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		stu.setName(name);
    		stu.setSid(sid);
    		stu.setIdcard(idcard);
    		stu.setEmail(email);
    		stu.setCellphone(cellphone);
    		stu.setClassname(classname);
    		stu.setGrade(grade);
    		stu.setJzfid(jzfid);
    		stu.setJzfname(jzfname);
    		stu.setJzfcellphone(jzfcellphone);
    		stu.setJzmid(jzmid);
    		stu.setJzmname(jzmname);
    		stu.setJzmcellphone(jzmcellphone);
    		stu.setNote(note);
    		stu.setMajorname(majorname);
    		stu.setPyxing(pyxing);
    		stu.setPyname(pyname);
    		stu.setSCN(SCN);
    		stu.setBirthday(birthday);
    		stu.setProgram(program);
    		stu.setAssistant(assistant);
    		stu.setDividestatus(0);
    		stu.setStatus(currentstatus);
    		if(null != sex && !sex.equals("")){
    			stu.setSex(Integer.valueOf(sex));
    		}else{
    			stu.setSex(null);
    		}
    		this.combiz.saveOrupate(stu);   	
            User _user=mgr.getUserByName(sid);
            if(_user!=null){
            	_user.setId(_user.getId());
            	_user.set_status(Integer.parseInt(currentstatus));
            	this.combiz.update(_user);
            }
    		addActionMessage("学生保存成功");
    		List<String> teacherlist=mgr.getkechengteacherByclassname(classname);
    		String totalteachername="";
    		for(String teachername :teacherlist){
    			totalteachername+=teachername+",";
    		}
    		if(null != totalteachername && !totalteachername.equals("")){
    			totalteachername=totalteachername.substring(0, totalteachername.length()-1);
    		}
    		TClass tclass=mgr.getClassByName(classname);
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Notice notice=new Notice();
    		if(!currentstatus.equals(_status)){
    				notice.setType(5);
    				notice.setTitle("学生状态通知");		
    				if(currentstatus.equals("1")){
    					notice.setContent(user.getUser()+"将"+name+"学生状态修改为:在校状态");	
    				}else{
    					notice.setContent(user.getUser()+"将"+name+"学生状态修改为:离校状态");	
    				}		
    				Date currDate = new Date();
    				notice.setPublishdate(sdf.format(currDate));
    				notice.setClassid(tclass.getId());
    				notice.setUsername(totalteachername);
    				notice.setNoticetype("4");
    				notice.setStatus(3);
    				this.combiz.save(notice);
    		}
    		request.setAttribute("student", stu);
             
    		classList = mgr.getClassList();
    		assistantList = mgr.getAssistantList();
    		request.setAttribute("classList", classList);
    		request.setAttribute("assistantList", assistantList);
    		//roleList = mgr.getRoleList();
    		//request.setAttribute("roleList", roleList);
    		if(null!=user){
    			if(user.getUserType()==3){
    				return returnvaluejaowu;
    			}
    			else{
    				return returnvalue;
    			}
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public String deleteStudent(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String studentid = request.getParameter("studentid");
    		Student student = (Student) this.combiz.get(Student.class, Integer.valueOf(studentid));
    		this.combiz.delete(student);
    		//roleList = mgr.getRoleList();
    		//Role role = (Role) this.combiz.get(Role.class, useredit.getUserType());
    		//roleList = mgr.getRoleList();
    		//request.setAttribute("useredit", useredit);
    		//request.setAttribute("role", role);
    		//request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "deleteStudent";
    }
	
	public String importStudent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		Integer roleid=user.getUserType();
		errorLine = new StringBuffer("");
		if (upload == null) {
			addActionMessage("请填写好待上传的文件！");
		}
		if (!contentType.equals("application/vnd.ms-excel")) {
			if(contentType.equals("application/octet-stream")){
				//addActionMessage("文件正在使用，不能上传！");
			}else{
				addActionMessage("上传文件格式不正确！");
			}
		}
		try {
			if (!parseXslFile(upload)) {
				//addActionMessage("学生数据导入失败");
				if (errorLine.length() > 0) {
					
				}
				
				request.getSession().setAttribute("errorLine", errorLine);
				
			}else{
				addActionMessage("学生数据导入成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			studentList = mgr.getStudentList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addActionMessage(errorLine.toString());
		//request.setAttribute("studentList", studentList);
		request.setAttribute("roleid", roleid);
		return "result";
	}
	
	private boolean parseXslFile(File file) {
		boolean flag=true;
		try {
			xslParser = new ExcelParser(file);
			Hashtable activeMap = xslParser.getContent(0, 2);
			if (activeMap.isEmpty() || activeMap.size() > 20000) {
				addActionMessage("Excel 中无可用数据或超过最大允许到如导入的限度导入失败。");
				return false;
			}
				for (int i = 0; i < activeMap.size(); i++) {
					Vector row = (Vector) activeMap.get("row" + i);
					if (row.get(1).equals(row.get(2)) && row.get(2) == row.get(3)){
						//有些时候在正常数据之后会有很多行中包含不可见字符,但每个单元格中的不可见字符都相同.
						//所以,如果这三个字段值相同,则认为是非正常行开始了,停止执行该循环.
						errorLine.append("第"+(i+1)+"行课程表1,2,3列内容相等导入失败请确认后导入<br/>");
						flag=false;
						break;
					}
					Student stu = new Student();
					
					stu.setSid((String) row.get(0));
					String sid = (String) row.get(0);
					List checkList = mgr.getStudentList(sid);
					
		    		if(null != checkList && checkList.size() > 0){
		    			errorLine.append("第"+(i+1)+"行学号为"+sid+"的学生已经存在，不能导入添加<br/>");
		    			continue;
		    		}
		    		
					stu.setName((String) row.get(1));
		    		stu.setIdcard((String) row.get(2));
		    		stu.setCellphone((String) row.get(3));
		    		stu.setJzfid((String) row.get(4));
		    		stu.setJzfname((String) row.get(5));
		    		stu.setJzfcellphone((String) row.get(6));
		    		stu.setJzmid((String) row.get(7));
		    		stu.setJzmname((String) row.get(8));
		    		stu.setJzmcellphone((String) row.get(9));
		    		stu.setClassname((String) row.get(10));
		    		stu.setGrade((String) row.get(11));
		    		
		    		String sexStr = (String) row.get(12);
		    		
		    		if(null != sexStr){
		    			if(sexStr.equals("男")){
		    				stu.setSex(1);
		    			}else if(sexStr.equals("女")){
		    				stu.setSex(2);
		    			}else{
		    				stu.setSex(1);
		    			}
		    		}
		    		stu.setAssistant((String) row.get(13));
		    		stu.setMajorname((String) row.get(14));
		    		stu.setPyxing((String) row.get(15));
		    		stu.setPyname((String) row.get(16));
		    		stu.setProgram((String) row.get(17));
		    		stu.setSCN((String) row.get(18));
		    		stu.setEmail((String) row.get(19));
		    		stu.setBirthday((String) row.get(20));
		    		String status = (String) row.get(21);
		    		//System.out.println("status----"+status);
		    		stu.setStatus(status);
		    		stu.setNote(null);
		    		stu.setDividestatus(0);
		    		this.combiz.saveOrupate(stu);
		    		
		    		User user = mgr.getUserByName(stu.getSid());
		    		if(null == user){
		    			user = new User();
		    			user.setUser(stu.getSid());
		    			user.setPass(stu.getIdcard().substring(stu.getIdcard().length()-6, stu.getIdcard().length()));
		    			//user.setEmail(stu.getEmail());
		    			user.setUserType(8);
		    			user.set_status(Integer.parseInt(stu.getStatus()));
		    			//user.setChineseName(stu.getName());
		    			this.combiz.save(user);
		    		}
				}
			if(!flag){
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String toExamAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		classList = mgr.getClassList();
    		assistantList = mgr.getAssistantList();
    		subjectList = mgr.getSubjectList();
    		teacherList = mgr.getTeacherListNew();
    		
    		request.setAttribute("classList", classList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("assistantList", assistantList);
    		request.setAttribute("teacherList", teacherList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExamAdd";
    }
	
	public String defaultSelect(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse response = ServletActionContext.getResponse();
    		response.setContentType("application/json;charset=utf-8");
    		PrintWriter out=response.getWriter();
    		String phaseid=request.getParameter("phaseid");   
    		//考试的科目，即是课程的课程
    		String subjectid=request.getParameter("subjectid");
    		String scoretype=request.getParameter("scoretype");
    		String examtype=request.getParameter("examtype");
    		Integer phaseidNew=Integer.parseInt(phaseid);
    		Integer subjectidNew=Integer.parseInt(subjectid);
    		Integer scoretypeNew=Integer.parseInt(scoretype);
    		Integer examtypeNew=Integer.parseInt(examtype);
    		DifferentPhase dp=new DifferentPhase();
    		
    		Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(subjectid));
    		String subjectname = subject.getName();
    		
    		
    		//根据阶段、科目、正考条件得到考过的考试安排
    		List<Exam> examList=mgr.getExamByPhaseid_Subjectid_Scoretype_Examtype(phaseidNew,subjectidNew,1);
    		
    		//tclassListNew 查询出没有参加该科目，该阶段考试的班级
    		List<TClass> notclassListNew = mgr.getExamByPhaseid_Subjectid(phaseidNew,subjectidNew);
    		//所有班级List
    		List<TClass> allClassList = mgr.getClassList();
    		//返回需要考试得班级
    		List<TClass> classList = new ArrayList();
    		//如果examList有数据，表明接此科目的此个阶段的参加过考试，因为参加过考试， 所以后面的考试的考试安排得按逻辑流程来。
    		//先有正考才会有后来的考试，百分制除外
    		if(null!=examList&&examList.size()>0){
    			//如果考试类型是非百分制或记分单元并且考试类型不是正考时
    			if((scoretypeNew==2 || scoretypeNew==3 || scoretypeNew==4)&&examtypeNew!=1){
    				for (Exam exam : examList) {
    					teacherList = new ArrayList<Teacher>();
    					TClass tclass=(TClass) this.combiz.get(TClass.class, exam.getClasskey());
    					
    					
    					List<Exam> currxamList=mgr.getExamByPhaseid_Subjectid_Classkey(phaseidNew, exam.getSubjectid(), exam.getClasskey());
    					
    					List  kechengList = mgr.getKechengByclassnamesubjectname(subjectname, tclass.getName());
    					Teacher teacher = null;
    					if(null != kechengList && kechengList.size() > 0){
    						String teachername = (String) kechengList.get(0);
    						teacher = mgr.getTeacherByName(teachername);
    					}
    					if(null != teacher){
    						teacherList.add(teacher);
    					}else{
    						teacher = new Teacher();
    						teacher.setId(-1);
    						teacher.setName("...");
    						teacherList.add(teacher);
    					}
    					if(currxamList.get(0).getExamtype() < examtypeNew){	
    						List<Teacher>  teacherTableList = mgr.getTeacherList(); 
    						teacherList.addAll(teacherTableList);
    						tclass.setTeacher_list(teacherList);
    						classList.add(tclass); 
    					}
    				} 
    				out.write(JSONArray.toJSONString(classList));
    			}
    			//当时考试类型是百分制或非百分制或记分单元或百分制考试1.4并且考试类型是正考时
    			else if((scoretypeNew==1||scoretypeNew==2 || scoretypeNew==3 || scoretypeNew==4)&&examtypeNew==1){
    				for (TClass tclass : notclassListNew) {
    					teacherList = new ArrayList<Teacher>();
    					List kechengList = mgr.getKechengByclassnamesubjectname(subjectname, tclass.getName());
    					Teacher teacher = null;
    					if(null != kechengList && kechengList.size() > 0){
    						String teachername = (String) kechengList.get(0);
    						teacher = mgr.getTeacherByName(teachername);
    					}
    					if(null != teacher){
    						teacherList.add(teacher);
    					}else{
    						teacher = new Teacher();
    						teacher.setId(-1);
    						teacher.setName("...");
    						teacherList.add(teacher);
    					}
    					List<Teacher> teacherTableList = mgr.getTeacherList(); 
						teacherList.addAll(teacherTableList);
						
						
						tclass.setTeacher_list(teacherList);
						classList.add(tclass);
    				}
    				out.write(JSONArray.toJSONString(classList));
    			}
    			/*else if(scoretypeNew==1){
        			for (TClass tclass : allClassList) {
    					teacherList = mgr.getTeacherList(); 
						tclass.setTeacher_list(teacherList);
						classList.add(tclass);
    				}
        			out.write(JSONArray.toJSONString(classList));
        		}*/
    		}
    		/***
    		 * 如果examList没有数据，表明接此科目的此个阶段的没有参加过考试，
    		 * 那么接下来所有的班级应该都可以选择来参加此科目的此阶段的考试，当然也只能参考正考
    		 ***/
    		else{
    			if(examtypeNew==1){	
    				for (TClass tclass : allClassList) {
    					teacherList = new ArrayList<Teacher>();
    					List kechengList = mgr.getKechengByclassnamesubjectname(subjectname, tclass.getName());
    					Teacher teacher = null;
    					if(null != kechengList && kechengList.size() > 0){
    						String teachername = (String) kechengList.get(0);
    						teacher = mgr.getTeacherByName(teachername);
    					}
    					if(null != teacher){
    						teacherList.add(teacher);
    					}else{
    						teacher = new Teacher();
    						teacher.setId(-1);
    						teacher.setName("...");
    						teacherList.add(teacher);
    					}
    					List teacherTableList = mgr.getTeacherList(); 
						teacherList.addAll(teacherTableList);
						
    					tclass.setTeacher_list(teacherList);
    					classList.add(tclass);
    				}   			
    				out.write(JSONArray.toJSONString(classList));
    			}
    			//如果不是正考， 则要求先安排正考， 下面的班级列表则没有一个班级列表
    			else{
    				out.print("false");
    			}
    		}
    		out.flush();
    		out.close();

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public String doExamAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		
    		String fromtime = request.getParameter("fromtime").replaceAll("\\s*", "");
    		String title = request.getParameter("examtitle");
    		String phaseid = request.getParameter("phaseid");
    		String edate = request.getParameter("edate");
    		String examtype = request.getParameter("examtype");
    		String totime = request.getParameter("totime").replaceAll("\\s*", "");
    		String classroom = request.getParameter("classroom");
    		String subjectid = request.getParameter("subjectid");
    		String grade = request.getParameter("grade");
    		String program = request.getParameter("program");
    		String scoretype = request.getParameter("scoretype");
    		//String enteringdate = request.getParameter("enteringdate");
    		//String enteringenddate = request.getParameter("enteringenddate");
    		
    		String classidstr = request.getParameter("classid");
    		String tidStr = request.getParameter("tidStr");
    		String tidStr2 = request.getParameter("tidStr2");
    		String enteringdateStr = request.getParameter("enteringdateStr");
    		String enteringenddateStr = request.getParameter("enteringenddateStr");
    		
            try {
            	title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
            	classroom = (classroom != null)?new String(classroom.getBytes("iso-8859-1"),"utf-8"):classroom;
            	program = (program != null)?new String(program.getBytes("iso-8859-1"),"utf-8"):program;
            	grade = (grade != null)?new String(grade.getBytes("iso-8859-1"),"utf-8"):grade;
            	fromtime = BCConvert.qj2bj(fromtime);
            	totime = BCConvert.qj2bj(totime);
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		if(null != classidstr){
    			String classid[] = classidstr.split(",");
    			String tid[] = tidStr.split(",");
    			String tid2[] = tidStr2.split(",");
    			String enteringdateArray[] = enteringdateStr.split(",");
    			String enteringenddateArray[] = enteringenddateStr.split(",");
        		for(int i=0; i<classid.length; i++){
        			Exam exam = new Exam();
        			exam.setClasskey(Integer.valueOf(classid[i]));
        			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        			Date edateD = df.parse(edate);
        			exam.setEdate(edateD);
        			if(null!=examtype&&!examtype.equals("")){       				
        				exam.setExamtype(Integer.valueOf(examtype));
        			}else{
        				exam.setExamtype(1);
        			}
        			exam.setGrade(grade);
        			exam.setProgram(program);
        			/*if(null != enteringdate && !enteringdate.equals("")){
        				Date enteringDateD = df.parse(enteringdate);
            			exam.setEnteringdate(enteringDateD);
        			}
        			if(null != enteringenddate && !enteringenddate.equals("")){
        				Date enteringEndDateD = df.parse(enteringenddate);
            			exam.setEnteringenddate(enteringEndDateD);
        			}*/
        			if(null != enteringdateArray[i] && enteringdateArray[i].equals("dt")){
        				exam.setEnteringdate(null);
        			}else{
        				Date enteringdate = df.parse(enteringdateArray[i]);
        				exam.setEnteringdate(enteringdate);
        			}
        			if(null != enteringenddateArray[i] && enteringenddateArray[i].equals("dt")){
        				exam.setEnteringenddate(null);
        			}else{
        				Date enteringenddate = df.parse(enteringenddateArray[i]);
        				exam.setEnteringenddate(enteringenddate);
        			}
        			exam.setScoretype(Integer.valueOf(scoretype));
        			exam.setFromtime(fromtime);
        			exam.setTotime(totime);
        			exam.setTitle(title);
        			exam.setDisplaystatus(1);
        			exam.setSubjectid(Integer.valueOf(subjectid));
        			exam.setTeacherid(tid[i]);
        			exam.setNeishenyuanid(tid2[i]);
        			exam.setClassroom(classroom);
        			exam.setPhaseid(Integer.valueOf(phaseid));
        			this.combiz.save(exam);
        		}
    		}
    		
    		classList = mgr.getClassList();
    		assistantList = mgr.getAssistantList();
    		subjectList = mgr.getSubjectList();
    		teacherList = mgr.getTeacherList();
    		
    		request.setAttribute("classList", classList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("assistantList", assistantList);
    		request.setAttribute("teacherList", teacherList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doExamAdd";
    }
	

	
	
	public String toExamList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		try {
    			String sort=request.getParameter("sort");
    			String subjectid=request.getParameter("subjectid");
    			JDBCConnection dbcon = new JDBCConnection();
    			Connection con = dbcon.openConnection();
    			Statement sm = con.createStatement();
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    			String current_date=sdf.format(new Date());
         	   	long current_millis=sdf.parse(current_date).getTime();
         	   	DecimalFormat df =new DecimalFormat("#.00"); 
    			String sql = "";
    			if(null!=sort&&sort.equals("asc")&&(null==subjectid||subjectid.equals(""))){
    				sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
        			      " where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid order by e.edate desc";
    				request.setAttribute("sort", "desc");
    			}
    			else if((null==sort||sort.equals(""))&&(null==subjectid||subjectid.equals(""))){
    				sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
    					  " where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid order by e.edate asc";
    				request.setAttribute("sort", "asc");
    			}
    			else if((null==sort||sort.equals("desc"))&&(null==subjectid||subjectid.equals(""))){
    				sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
    						" where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid order by e.edate asc";
    				request.setAttribute("sort", "asc");
    			}
    			else if(null!=sort&&!sort.equals("")&&null!=subjectid&&!subjectid.equals("")){
    				sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
    		    		  " where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and e.subjectid= '" +subjectid+ "' order by e.edate "+sort+"";
    				if(sort.equals("asc")){    					
    					request.setAttribute("sort","desc");
    				}
    				else{
    					request.setAttribute("sort","asc");
    				}
    			}
    			ResultSet rs = sm.executeQuery(sql);
    			List<Exam> examList = new ArrayList<Exam>();
    			DifferentPhase phase=new DifferentPhase();
    			while(rs.next()){
    				       Integer id = rs.getInt("id");
    				      // System.out.println("id----"+id);
                           String title = rs.getString("title");
                           Date edate = rs.getDate("edate"); 
                           Integer teacherid = rs.getInt("teacherid"); 
                           Integer neishenyuanid=rs.getInt("neishenyuanid");
                           Date updateenddate = rs.getDate("updateenddate");
                           Date enteringenddate = rs.getDate("enteringenddate");
                           String classname = rs.getString("classname");
                           String classroom = rs.getString("classroom");
                           Integer phaseid = rs.getInt("phaseid");
                           String subjectname = rs.getString("subjectname");
                           String fromtime = rs.getString("fromtime");
                           Integer examtype = rs.getInt("examtype");
                           Integer scoretype = rs.getInt("scoretype");
                           Integer displaystatus = rs.getInt("displaystatus");
                           Exam exam = new Exam();
                           String examDate=sdf1.format(edate)+" "+fromtime;
                           if(sdf.parse(examDate).getTime()>current_millis){                        	   
                        	   double day=(double)(sdf.parse(examDate).getTime()-current_millis)/(1000*3600*24);
                        	   double result=Double.valueOf(df.format(day));
                        	   if(result>2){
                        		   exam.setStatus("yes");
                        	   }                        
                           } 
                           if(null!=updateenddate&&!updateenddate.equals("")){
                        	   //没有过期
                        	   if(updateenddate.getTime()>=sdf1.parse(current_date).getTime()){                       		   
                        		   long day=(updateenddate.getTime()-sdf1.parse(current_date).getTime())/(1000*3600*24);
                        		   if(day<=3){
                        			   exam.setBackgroundcolor("#a6a600");
                        			   if(day<=1){
                        				   exam.setBackgroundcolor("#ff5151");
                        			   }
                        		   }
                        		   //已经过期，灰色
                        	   }else{
                        		   exam.setBackgroundcolor("#DDD");
                        	   }
                        	   
                           }else{
                        	   //没有过期
                        	   if(enteringenddate.getTime()>=sdf1.parse(current_date).getTime()){                       		   
                        		   long day=(enteringenddate.getTime()-sdf1.parse(current_date).getTime())/(1000*3600*24);
                        		   if(day<=3){
                        			   exam.setBackgroundcolor("#a6a600");
                        			   if(day<=1){
                        				   exam.setBackgroundcolor("#ff5151");
                        			   }
                        		   }
                        		   //已经过期，灰色
                        	   }else{
                        		   exam.setBackgroundcolor("#DDD");
                        	   }
                           }
                           Teacher teacher=mgr.getTeacherByTid(teacherid.toString());
                           if(null == neishenyuanid || neishenyuanid == 0){
                        	   exam.setNeishenyuanname(null);
                           }else{
                        	   Teacher neishenyuan=mgr.getTeacherByTid(String.valueOf(neishenyuanid));  
                               exam.setNeishenyuanname(neishenyuan.getName());
                           }
                          
                           
                           exam.setTeachername(teacher.getName());
                          
                           exam.setId(id);                           
                           exam.setTitle(title);
                           exam.setEdate(edate);
                           exam.setPhaseid(phaseid);
                           exam.setClassname(classname);
                           exam.setClassroom(classroom);
                           exam.setSubjectname(subjectname);
                           exam.setFromtime(fromtime);
                           if(scoretype==1){//百分制   				
                 				String examTypeName=phase.getExamType(examtype);
                 				exam.setScoreTypeName("百分制");
                 				exam.setExamTypeName(examTypeName);              				
                 				}
                           if(scoretype==2){//非百分制   				
                  				String examTypeName=phase.getExamType(examtype);
                  				exam.setScoreTypeName("非百分制");
                  				exam.setExamTypeName(examTypeName);              				
                  				}
                           if(scoretype==3){//记分单元 				
                 				String examTypeName=phase.getExamType(examtype);
                 				exam.setScoreTypeName("记分单元 ");
                 				exam.setExamTypeName(examTypeName);              				
                 				}
                           if(scoretype==4){//非百分制1.4				
                				String examTypeName=phase.getExamType(examtype);
                				exam.setScoreTypeName("非百分制1.4");
                				exam.setExamTypeName(examTypeName);              				
                				}
                           exam.setDisplaystatus(displaystatus);
                           examList.add(exam);
    				}
    			subjectList = mgr.getSubjectList();
    			request.setAttribute("examList", examList);
    			request.setAttribute("subjectid", subjectid);
    			request.setAttribute("subjectList", subjectList);
    			dbcon.closeConnection();
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExamList";
    }
	
	public String lookExamList(){
    	return "lookExamList";
    }
	
	public String toExamListBySubject(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		try {
    			String sort=request.getParameter("sort");
    			String subjectid=request.getParameter("subjectid");
    			JDBCConnection dbcon = new JDBCConnection();
    			Connection con = dbcon.openConnection();
    			Statement sm = con.createStatement();
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    			String current_date=sdf.format(new Date());
         	   	long current_millis=sdf.parse(current_date).getTime();
    			String sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
    			" where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and e.subjectid= '" +subjectid+ "' order by e.edate "+sort+"";


    			ResultSet rs = sm.executeQuery(sql);
    			List<Exam> examList = new ArrayList<Exam>();
    			DifferentPhase phase=new DifferentPhase();
    			while(rs.next()){
				       Integer id = rs.getInt("id");
                    String title = rs.getString("title");
                    Date edate = rs.getDate("edate"); 
                    Date updateenddate = rs.getDate("updateenddate");
                    Date enteringenddate = rs.getDate("enteringenddate");
                    String classname = rs.getString("classname");
                    String classroom = rs.getString("classroom");
                    Integer phaseid = rs.getInt("phaseid");
                    String subjectname = rs.getString("subjectname");
                    String fromtime = rs.getString("fromtime");
                    Integer examtype = rs.getInt("examtype");
                    Integer scoretype = rs.getInt("scoretype");
                    Integer displaystatus = rs.getInt("displaystatus");
                    Exam exam = new Exam();
                    String examDate=sdf1.format(edate)+" "+fromtime;
                    if(sdf.parse(examDate).getTime()>current_millis){                        	   
                 	   long day=(sdf.parse(examDate).getTime()-current_millis)/(1000*3600*24);
                 	   if(day>=2){
                 		   exam.setStatus("yes");
                 	   }                        
                    } 
                    if(null!=updateenddate&&!updateenddate.equals("")){
                 	   //没有过期
                 	   if(updateenddate.getTime()>=sdf1.parse(current_date).getTime()){                       		   
                 		   long day=(updateenddate.getTime()-sdf1.parse(current_date).getTime())/(1000*3600*24);
                 		   if(day<=3){
                 			   exam.setBackgroundcolor("#a6a600");
                 			   if(day<=1){
                 				   exam.setBackgroundcolor("#ff5151");
                 			   }
                 		   }
                 		   //已经过期，灰色
                 	   }else{
                 		   exam.setBackgroundcolor("#DDD");
                 	   }
                 	   
                    }else{
                 	   //没有过期
                 	   if(enteringenddate.getTime()>=sdf1.parse(current_date).getTime()){                       		   
                 		   long day=(enteringenddate.getTime()-sdf1.parse(current_date).getTime())/(1000*3600*24);
                 		   if(day<=3){
                 			   exam.setBackgroundcolor("#a6a600");
                 			   if(day<=1){
                 				   exam.setBackgroundcolor("#ff5151");
                 			   }
                 		   }
                 		   //已经过期，灰色
                 	   }else{
                 		   exam.setBackgroundcolor("#DDD");
                 	   }
                    }
                    exam.setId(id);                           
                    exam.setTitle(title);
                    exam.setEdate(edate);
                    exam.setPhaseid(phaseid);
                    exam.setClassname(classname);
                    exam.setClassroom(classroom);
                    exam.setSubjectname(subjectname);
                    exam.setFromtime(fromtime);
                    if(scoretype==1){//百分制   				
          				String examTypeName=phase.getExamType(examtype);
          				exam.setScoreTypeName("百分制");
          				exam.setExamTypeName(examTypeName);              				
          				}
                    if(scoretype==2){//非百分制   				
           				String examTypeName=phase.getExamType(examtype);
           				exam.setScoreTypeName("非百分制");
           				exam.setExamTypeName(examTypeName);              				
           				}
                    if(scoretype==3){//记分单元 				
          				String examTypeName=phase.getExamType(examtype);
          				exam.setScoreTypeName("记分单元 ");
          				exam.setExamTypeName(examTypeName);              				
          				}
                    exam.setDisplaystatus(displaystatus);
                    examList.add(exam);
				}
    			subjectList = mgr.getSubjectList();
    			request.setAttribute("examList", examList);
    			request.setAttribute("subjectid", subjectid);
    			dbcon.closeConnection();
    			
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExamList";
    }
	
	
	public String toExamListByClass(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		try {
    			String sort=request.getParameter("sort");
    			String classid=request.getParameter("classid");
    			JDBCConnection dbcon = new JDBCConnection();
    			Connection con = dbcon.openConnection();
    			Statement sm = con.createStatement();   			
    			String sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
    			" where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and e.classkey= '" +classid+ "'";
    			request.setAttribute("sort", "desc");

    			ResultSet rs = sm.executeQuery(sql);
    			List<Exam> examList = new ArrayList<Exam>();
    			DifferentPhase phase=new DifferentPhase();
    			while(rs.next()){
    				       Integer id = rs.getInt("id");
                           String title = rs.getString("title");
                           Date edate = rs.getDate("edate");
                           String classname = rs.getString("classname");
                           Integer phaseid = rs.getInt("phaseid");
                           String subjectname = rs.getString("subjectname");
                           String fromtime = rs.getString("fromtime");
                           Integer examtype = rs.getInt("examtype");
                           Integer scoretype = rs.getInt("scoretype");
                           Integer displaystatus = rs.getInt("displaystatus");
                           String classroom=rs.getString("classroom");
                           Integer passnumber=rs.getInt("passnumber");
                           String passrate=rs.getString("passrate");
                           Exam exam = new Exam();
                           exam.setId(id);
                           exam.setTitle(title);
                           exam.setEdate(edate);
                           exam.setPhaseid(phaseid);
                           exam.setClassname(classname);
                           exam.setSubjectname(subjectname);
                           exam.setFromtime(fromtime);
                           exam.setClassroom(classroom);
                           exam.setPassnumber(passnumber);
                           exam.setPassrate(passrate);
                           if(scoretype==1){//百分制   				
                 				String examTypeName=phase.getExamType(examtype);
                 				exam.setScoreTypeName("百分制");
                 				exam.setExamTypeName(examTypeName);              				
                 				}
                           if(scoretype==2){//非百分制   				
                  				String examTypeName=phase.getExamType(examtype);
                  				exam.setScoreTypeName("非百分制");
                  				exam.setExamTypeName(examTypeName);              				
                  				}
                           if(scoretype==3){//记分单元 				
                 				String examTypeName=phase.getExamType(examtype);
                 				exam.setScoreTypeName("记分单元 ");
                 				exam.setExamTypeName(examTypeName);              				
                 				}
                           exam.setDisplaystatus(displaystatus);
                           examList.add(exam);
    				}
    			classList = mgr.getClassList();
    			request.setAttribute("examList", examList);
    			request.setAttribute("classList", classList);
    			request.setAttribute("classid", classid);
    			request.setAttribute("sort", sort);
    			dbcon.closeConnection();
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExamListByClass";
    }
	
	public String checkModifityStatus(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse response = ServletActionContext.getResponse();
    		PrintWriter out=response.getWriter();
    		response.setContentType("text/html;charset=utf-8");
    		try {
    			String examid = request.getParameter("examid");
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    			String current_date=sdf.format(new Date());
         	   	long current_millis=sdf.parse(current_date).getTime(); 
         	   Exam exam = (Exam) this.combiz.get(Exam.class, Integer.parseInt(examid));
               String examDate=sdf1.format(exam.getEdate())+" "+exam.getFromtime();
               if(sdf.parse(examDate).getTime()>current_millis){                        	   
            	   long day=(sdf.parse(examDate).getTime()-current_millis)/(1000*3600*24);
            	   if(day>=2){
            		   out.print("yes");
            	   }                        
               } 
    			out.flush();
    			out.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public String toExamEntering(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		try {
    			String examid = request.getParameter("examid");
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    			String current_date=sdf.format(new Date());
         	   	long current_millis=sdf.parse(current_date).getTime();
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			Teacher teacher = mgr.getTeacherByTid(exam.getTeacherid());
    			exam.setTeachername(teacher.getName());
    			teacher = mgr.getTeacherByTid(exam.getNeishenyuanid());
    			exam.setNeishenyuanname(teacher.getName());
    			//TClass tclass = mgr.getClassByCid(exam.getClassid());
    			TClass tclass = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
    			exam.setClassname(tclass.getName());
    			Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(exam.getSubjectid()));
    			exam.setSubjectname(subject.getName());
    			DifferentPhase phase=new DifferentPhase();
    			 if(exam.getScoretype()==1){//百分制   				
      				String examTypeName=phase.getExamType(exam.getExamtype());
      				exam.setScoreTypeName("百分制");
      				exam.setExamTypeName(examTypeName);              				
      				}
                if(exam.getScoretype()==2){//非百分制   				
       				String examTypeName=phase.getExamType(exam.getExamtype());
       				exam.setScoreTypeName("非百分制");
       				exam.setExamTypeName(examTypeName);              				
       				}
                if(exam.getScoretype()==3){//记分单元 				
      				String examTypeName=phase.getExamType(exam.getExamtype());
      				exam.setScoreTypeName("记分单元 ");
      				exam.setExamTypeName(examTypeName);              				
      				}
                if(exam.getScoretype()==4){//非百分制1.4				
      				String examTypeName=phase.getExamType(exam.getExamtype());
      				exam.setScoreTypeName("非百分制1.4");
      				exam.setExamTypeName(examTypeName);              				
      				}
    			request.setAttribute("exam", exam);   			
    			teacherList = mgr.getTeacherList();
    			request.setAttribute("teacherList", teacherList);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExamEntering";
    }

	public String doExamUpdate(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		try {
    			String examid = request.getParameter("examid");
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			String enteringdate = request.getParameter("enteringdate");
    			String teacherid = request.getParameter("teacherid");
    			String teacher = request.getParameter("teacher");
    			String enteringenddate = request.getParameter("enteringenddate");
    			String updateenddate = request.getParameter("updateenddate");
    			String edate = request.getParameter("edate");
    			String fromtime = request.getParameter("fromtime");
        		String totime = request.getParameter("totime");
        		String classroom = request.getParameter("classroom");
        		String grade = request.getParameter("grade");
        		String program = request.getParameter("program");
    			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    			classroom=new String(classroom.getBytes("iso-8859-1"),"utf-8");
    			grade = (grade != null)?new String(grade.getBytes("iso-8859-1"),"utf-8"):grade;
    			program = (program != null)?new String(program.getBytes("iso-8859-1"),"utf-8"):program;
    			if(null != enteringdate && !enteringdate.equals("")){
    				Date enteringdateD = df.parse(enteringdate);
    				exam.setEnteringdate(enteringdateD);
    			}else{
    				exam.setEnteringdate(null);
    			}
    			if(null != enteringenddate && !enteringenddate.equals("")){
    				Date enteringenddateD = df.parse(enteringenddate);
    				exam.setEnteringenddate(enteringenddateD);
    			}else{
    				exam.setEnteringenddate(null);
    			}
    			if(null != updateenddate && !updateenddate.equals("")){
    				Date updateenddateD = df.parse(updateenddate);
    				exam.setUpdateenddate(updateenddateD);
    			}
    			if(null != edate && !edate.equals("")){
    				Date curredate = df.parse(edate);
    				exam.setEdate(curredate);
    			}else{
    				exam.setUpdateenddate(null);
    			}
    			exam.setTeacherid(teacherid);
    			exam.setClassroom(classroom);
    			exam.setFromtime(fromtime);
    			exam.setTotime(totime);
    			exam.setGrade(grade);
    			exam.setProgram(program);
    			exam.setNeishenyuanid(teacher);
    			this.combiz.update(exam);
    			
    			
    			DifferentPhase phase=new DifferentPhase();
    			String examTypeName="";
    			String scoreTypeName="";
   			 	if(exam.getScoretype()==1){//百分制   				
     				examTypeName=phase.getExamType(exam.getExamtype());
     				scoreTypeName="百分制";              				
     				}
                if(exam.getScoretype()==2){//非百分制   				
            	   	examTypeName=phase.getExamType(exam.getExamtype());
    				scoreTypeName="非百分制";;              				
      				}
                if(exam.getScoretype()==3){//记分单元 				
            	   	examTypeName=phase.getExamType(exam.getExamtype());
    				scoreTypeName="记分单元";              				
     				}
    			Notice notice = new Notice();
    			Subject subject=(Subject) this.combiz.get(Subject.class, exam.getSubjectid());
    			TClass tclass=(TClass) this.combiz.get(TClass.class, exam.getClasskey());
    			String totalteachername="";
    		    List<String> teacherlist=mgr.getKechengByclassnamesubjectname(subject.getName(),tclass.getName());
    		    for(String teachername:teacherlist){
    		    	totalteachername+=teachername+",";
    		    }
    		    totalteachername=totalteachername.substring(0, totalteachername.length()-1);
    		    	notice.setType(5);
    		    	notice.setTitle("考试安排修改通知");
    		    	notice.setContent("用户："+user.getUser()+"修改了"+subject.getName()+"的:"+scoreTypeName+examTypeName+"的信息");			
    		    	Date currDate = new Date();
    		    	notice.setPublishdate(sdf.format(currDate));
    		    	notice.setClassid(tclass.getId());
    		    	notice.setUsername(totalteachername);
    		    	notice.setNoticetype("4");
    		    	notice.setStatus(3);
    		    	this.combiz.save(notice);	
    			request.setAttribute("exam", exam);
    			examid = exam.getId().toString();
    			request.setAttribute("examid", examid);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doExamUpdate";
    }

	public String toExamListTea(){
		try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		try {
    			User user = (User) request.getSession().getAttribute("tuser");
    			if(user.getUserType()==7){
    			Teacher teacher = mgr.getTeacherByName(user.getUser());
    			Date now = new Date();
    			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			String nowStr = df.format(now);
    			JDBCConnection dbcon = new JDBCConnection();
    			Connection con = dbcon.openConnection();
    			Statement sm = con.createStatement();
    			String sql1="select e.id,e.updateenddate from exam e";
    			ResultSet rs = sm.executeQuery(sql1);
    			List<Exam> examList1 = new ArrayList<Exam>();
    			List<Exam> examList2 = new ArrayList<Exam>();
    			DifferentPhase phase=new DifferentPhase();
    			while(rs.next()){
    				Exam examNew1 = new Exam();
    				Date updateenddate=rs.getDate("updateenddate");
    				Integer id = rs.getInt("id");
    				examNew1.setId(id);
    				examNew1.setUpdateenddate(updateenddate);
    				examList1.add(examNew1);
    			}
				for (Exam exam : examList1) {
					/*String sql2 ="";
							if(null!=exam.getUpdateenddate()&&!exam.getUpdateenddate().equals("")){
								 sql2 = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
		    					" where e.id='"+exam.getId()+"' and e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid "+
		    					" and e.enteringdate <= '" + nowStr + "' and e.updateenddate >= '" + nowStr + "' and e.teacherid= '" + teacher.getTid() + "' " ;
							}
							else{
								 sql2 = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
		    					" where e.id='"+exam.getId()+"' and e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid "+
		    					" and e.enteringdate <= '" + nowStr + "' and e.enteringenddate >= '" + nowStr + "' and e.teacherid= '" + teacher.getTid() + "' ";
							}*/
					String sql2 ="SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
					" where e.id='"+exam.getId()+"' and e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and e.teacherid= '" + teacher.getTid() + "' ";
							rs = sm.executeQuery(sql2);
							while(rs.next()){
								Exam examNew2 = new Exam();
								Integer id = rs.getInt("id");
								String title = rs.getString("title");
								Date edate = rs.getDate("edate");
								String classname = rs.getString("classname");
								String subjectname = rs.getString("subjectname");
								String fromtime = rs.getString("fromtime");
								Integer scoretype = rs.getInt("scoretype");
								Integer examtype = rs.getInt("examtype");
								Integer displaystatus = rs.getInt("displaystatus");
								Integer phaseid=rs.getInt("phaseid");
								examNew2.setId(id);
								examNew2.setTitle(title);
								examNew2.setEdate(edate);
								examNew2.setClassname(classname);
								examNew2.setSubjectname(subjectname);
								examNew2.setFromtime(fromtime);
								examNew2.setPhaseid(phaseid);
								if(scoretype==1){//百分制   				
									examNew2.setScoreTypeName("百分制");
									examNew2.setExamTypeName("正考");              				
								}
								if(scoretype==2){//非百分制   				
									String examTypeName=phase.getExamType(examtype);
									examNew2.setScoreTypeName("非百分制");
									examNew2.setExamTypeName(examTypeName);              				
								}
								if(scoretype==3){//记分单元 				
									String examTypeName=phase.getExamType(examtype);
									examNew2.setScoreTypeName("记分单元 ");
									examNew2.setExamTypeName(examTypeName);              				
								}
								if(scoretype==4){//非百分制1.4			
									String examTypeName=phase.getExamType(examtype);
									examNew2.setScoreTypeName("非百分制1.4");
									examNew2.setExamTypeName(examTypeName);              				
								}
								examNew2.setDisplaystatus(displaystatus);
								examList2.add(examNew2);
							}
				}
				Collections.reverse(examList2); 	   
    			request.setAttribute("examList", examList2);
    			dbcon.closeConnection();
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExamListTea";
    }
	
	public String toExamListManage(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		try {
    			User user = (User) request.getSession().getAttribute("tuser");
    			if(user.getUserType()==3||user.getUserType()==4){
    			Date now = new Date();
    			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			String nowStr = df.format(now);
    			JDBCConnection dbcon = new JDBCConnection();
    			Connection con = dbcon.openConnection();
    			Statement sm = con.createStatement();
    			String sql1="select e.id,e.updateenddate from exam e";
    			ResultSet rs = sm.executeQuery(sql1);
    			List<Exam> examList1 = new ArrayList<Exam>();
    			List<Exam> examList2 = new ArrayList<Exam>();
    			DifferentPhase phase=new DifferentPhase();
    			while(rs.next()){
    				Exam examNew1 = new Exam();
    				Date updateenddate=rs.getDate("updateenddate");
    				Integer id = rs.getInt("id");
    				examNew1.setId(id);
    				examNew1.setUpdateenddate(updateenddate);
    				examList1.add(examNew1);
    			}
				for (Exam exam : examList1) {
//					String sql2 ="";
							/*if(null!=exam.getUpdateenddate()&&!exam.getUpdateenddate().equals("")){
								 sql2 = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
		    					" where e.id='"+exam.getId()+"' and e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid "+
		    					" and e.enteringdate <= '" + nowStr + "' and e.updateenddate >= '" + nowStr + "'";
							}
							else{
								 sql2 = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
		    					" where e.id='"+exam.getId()+"' and e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid "+
		    					" and e.enteringdate <= '" + nowStr + "' and e.enteringenddate >= '" + nowStr + "'";
							}*/	
					String sql2 = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
					" where e.id='"+exam.getId()+"' and e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and e.displaystatus in (3,4)";
							rs = sm.executeQuery(sql2);
							while(rs.next()){
								Exam examNew2 = new Exam();
								Integer id = rs.getInt("id");
								String title = rs.getString("title");
								Date edate = rs.getDate("edate");
								String classname = rs.getString("classname");
								String subjectname = rs.getString("subjectname");
								String fromtime = rs.getString("fromtime");
								Integer scoretype = rs.getInt("scoretype");
								Integer examtype = rs.getInt("examtype");
								Integer displaystatus = rs.getInt("displaystatus");
								Integer phaseid=rs.getInt("phaseid");
								examNew2.setId(id);
								examNew2.setTitle(title);
								examNew2.setEdate(edate);
								examNew2.setClassname(classname);
								examNew2.setSubjectname(subjectname);
								examNew2.setFromtime(fromtime);
								examNew2.setPhaseid(phaseid);
								if(scoretype==1){//百分制   	
									String examTypeName=phase.getExamType(examtype);
									examNew2.setScoreTypeName("百分制");
									examNew2.setExamTypeName(examTypeName);              				
								}
								if(scoretype==2){//非百分制   				
									String examTypeName=phase.getExamType(examtype);
									examNew2.setScoreTypeName("非百分制");
									examNew2.setExamTypeName(examTypeName);              				
								}
								if(scoretype==3){//记分单元 				
									String examTypeName=phase.getExamType(examtype);
									examNew2.setScoreTypeName("记分单元 ");
									examNew2.setExamTypeName(examTypeName);              				
								}
								if(scoretype==4){//非百分制1.4 				
									String examTypeName=phase.getExamType(examtype);
									examNew2.setScoreTypeName("非百分制1.4");
									examNew2.setExamTypeName(examTypeName);              				
								}
								examNew2.setDisplaystatus(displaystatus);
								examList2.add(examNew2);
							}
				}
				Collections.reverse(examList2);
    			request.setAttribute("examList",examList2);
    			dbcon.closeConnection();
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExamListManage";
    }
	
	public String cancelRelease(){
		try {			
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String examid = request.getParameter("examid");
			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
			Subject subject=(Subject) this.combiz.get(Subject.class, exam.getSubjectid());
			TClass tclass=(TClass) this.combiz.get(TClass.class, exam.getClasskey());
			Teacher teacher=mgr.getTeacherByTid(exam.getTeacherid());
			exam.setDisplaystatus(3);
			this.combiz.update(exam);
			Logging logging = new Logging();
			logging.setUsername(user.getUser());
			logging.setUsertype(user.getUserType());
			Date now = new Date();
			logging.setOpertime(now);
			if(exam.getScoretype()==1){
				exam.setScoreTypeName("百分制");
				exam.setExamTypeName("");
			}else if(exam.getScoretype()==2){
				exam.setScoreTypeName("非百分制");
				String examTypeName=new DifferentPhase().getExamType(exam.getExamtype());
				exam.setExamTypeName(examTypeName);
			}else{
				exam.setScoreTypeName("积分单元");
				String examTypeName=new DifferentPhase().getExamType(exam.getExamtype());
				exam.setExamTypeName(examTypeName);
			}
			logging.setContent("用户："+user.getUser()+"撤回了:"+tclass.getName()+subject.getName()+"的"+exam.getScoreTypeName()+exam.getExamTypeName()+"成绩");  					
			this.combiz.save(logging);
			String totalteachername="";
			List<String> teacherlist=mgr.getKechengByclassnamesubjectname(subject.getName(),tclass.getName());
			for(String teachername:teacherlist){
				totalteachername+=teachername+",";
			}
			totalteachername=totalteachername.substring(0, totalteachername.length()-1);
		     Notice notice_=null;
		     Date currDate = new Date();
		    	 notice_ = new Notice();
		    	 notice_.setType(5);
		    	 notice_.setTitle("成绩撤回通知");
		    	 notice_.setContent("用户："+user.getUser()+"撤回了:"+tclass.getName()+subject.getName()+"的"+exam.getScoreTypeName()+exam.getExamTypeName()+"成绩"); 
		    	 notice_.setClassid(tclass.getId());
		    	 notice_.setPublishdate(sdf.format(currDate));
		    	 notice_.setNoticetype("4");
		    	 notice_.setUsername(totalteachername);
		    	 notice_.setStatus(3);
		    	 this.combiz.save(notice_);
		} catch (Exception e){
			e.printStackTrace();
		}
		return "cancelRelease";
	}
	
	public String toScoreInput(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    			String examid = request.getParameter("examid");
    			//ScoreNew buttonStatus=mgr.getButtonStatus(Integer.parseInt(examid));
    			//request.setAttribute("buttonStatus",buttonStatus.getButtonstatus());
    			//org.yeeku.model.ScoreNew@12826436
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			Date enteringenddate=exam.getEnteringenddate();//录入截止时间
    			Date updateEnteringenddate=exam.getUpdateenddate();//申请延期
    			Date currentdate=new Date();
    			StringBuilder bolexam=new StringBuilder();
    			Long param;
    			if(null!=updateEnteringenddate&&!updateEnteringenddate.equals("")){
    				param=currentdate.getTime()-updateEnteringenddate.getTime();    				
    			}else{
    				param=currentdate.getTime()-enteringenddate.getTime();
    			}
    			String bol="";//判断录入是否截止
    			//String bolapply="";//判断是否申请延时
    			if(param>0){
    				bol="false";
    				//EnterApply ea= mgr.getExamApply(examid);
    				/*if(null==ea){
    					bolapply="false";
    				}else{
    					bolapply="true";
    				}*/
    			}else{
    				bol="true";
    			}
    			Teacher teacher = mgr.getTeacherByTid(exam.getTeacherid());
    			Teacher neishenyuan = mgr.getTeacherByTid(exam.getNeishenyuanid());
    			exam.setTeachername(teacher.getName());
    			exam.setNeishenyuanname(neishenyuan.getName());
    			Date gettimes=exam.getEnteringenddate();
    			Date date=new Date(gettimes.getTime() - 24*60*60*1000);
    			String dateNew=sdf.format(date);
    			TClass tclass = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
    			exam.setClassname(tclass.getName());
    			Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(exam.getSubjectid()));
    			exam.setSubjectname(subject.getName());
    			DifferentPhase phase=new DifferentPhase();
    			List<String> resultList=new ArrayList<String>();
    			List<String> titleList=new ArrayList<String>();      
    			
    			
    			/*****
    			 * 2016年8月
    			 * 而实际要参加考试的学生只能在score_new 表中通过考试科目subjectid， 考试阶段phaseid， 班级classkey, examtype=1
    			 * 得到原来已经参加这次考试的学生， 
    			 * 这里需要判断下， 如果这个班级 这个科目 这个阶段考试以前没有过考试， 就从学生表中拉取需要参加此次考试的学生， 
    			 * 如果这个班级 这个科目 这个阶段以前有过考试， 这个班级 科目 阶段的正考考试的学生就要参加考试
    			 *********确定要参加考试学生代码段BEGIN*********/
    			JDBCConnection jdbccon = new JDBCConnection();
    			Connection con = jdbccon.openConnection();
    			Statement sm = con.createStatement();
    			String sql = "select * from score_new where subjectid="+exam.getSubjectid()+
    			" and classkey = "+exam.getClasskey()+ " and phaseid = "+exam.getPhaseid()+" and examtype = 1";
    			ResultSet rs = sm.executeQuery(sql);
    			if(rs.next()){
    				rs.previous(); 
    				studentList = new ArrayList();
    				while(rs.next()){
    					String sid = rs.getString("sid");
    					Student student = mgr.getStudentBySid(sid);
    					studentList.add(student);
    				}
    			}else{
    				//需要参加考试的学生是通过学生表student中的班级名称得来的
    				studentList = mgr.getStudentListByClassname(tclass.getName());  
    			}
    			con.close();
    			/**********确定要参加考试学生代码段END*********/
    			
    			
    			
    			
    			StringBuffer sid=new StringBuffer();//全部学生的sid
    			StringBuffer sidNew=new StringBuffer();//参加考试学生的sid
    			if(exam.getScoretype()==1){//百分制   				
      				exam.setScoreTypeName("百分制");
      				exam.setExamTypeName("");
      				}
                if(exam.getScoretype()==2){//非百分制   
	       				String examTypeName=phase.getExamType(exam.getExamtype());
	       				exam.setScoreTypeName("非百分制");
	       				exam.setExamTypeName(examTypeName);
	       				titleList=phase.getShowCurrExamTitle(exam.getExamtype());
	       				if(user.getUserType()==7){
	       					resultList=phase.getFeiBaiFenZhiResultTeacher(exam.getExamtype());
	       				}else{
	       					resultList=phase.getFeiBaiFenZhiResult(exam.getExamtype());
	       				}
       				}
                ////非百分制 1.4
                if(exam.getScoretype()==4){
       				String examTypeName=phase.getExamType(exam.getExamtype());
       				exam.setScoreTypeName("非百分制1.4");
       				exam.setExamTypeName(examTypeName);
       				titleList=phase.getShowCurrExamTitle(exam.getExamtype());
       				if(user.getUserType()==7){
       					resultList=phase.getFeiBaiFenZhiOneFourResultTeacher(exam.getExamtype());
       				}else{
       					resultList=phase.getFeiBaiFenZhiOneFourResult(exam.getExamtype());
       				}
   				}
                
                if(exam.getScoretype()==3){//记分单元 
	      				String examTypeName=phase.getExamType(exam.getExamtype());
	      				exam.setScoreTypeName("记分单元 ");
	      				exam.setExamTypeName(examTypeName);
	      				titleList=phase.getShowCurrExamTitleByOther(exam.getExamtype());
      				}
                
                ScoreNew tempScore=mgr.getButtonStatus(exam.getId());
                if(null==tempScore||null==tempScore.getButtonstatus()){//判断当前考试第几次提交
					request.setAttribute("buttonStatus", null);
				}else if(null!=tempScore.getButtonstatus()){
					request.setAttribute("buttonStatus", tempScore.getButtonstatus());
				}
                

				
				for(int i = 0; i < studentList.size(); i++){
					Student student = (Student) studentList.get(i);
					sid.append(student.getSid());
					sid.append(",");
					//获取该学生该阶段该科目上一次考试的结果成绩，同一科目同一阶段只会有一种得分制考试	    					 
					ScoreNew score = mgr.getScoreForInputNew(student.getSid(), exam.getSubjectid(), exam.getPhaseid());
					if(exam.getExamtype()==1){//当考试类型为正考时返回当前班级所有学生
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());
	    					List<ScoreNew> zkScoreList=null;
	    					if(exam.getScoretype()==1){
	    						zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1,exam.getId());
	    					}else{	    						
	    						zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
	    					}
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}	    					
	    					sidNew.append(student.getSid());
	    					sidNew.append(",");
	    					student.setExamstatus(1);
	    					if(null != zkScoreList && zkScoreList.size() > 0&&exam.getScoretype()!=3){
	    						student.setZk(zkScoreList.get(0).getResult());
	    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
	    					}
	    					else if((null != zkScoreList && zkScoreList.size() > 0&&exam.getScoretype()==3)){
	    						student.setZk(zkScoreList.get(0).getResult());
	    						String result=zkScoreList.get(0).getResult();
	    						if(null!=result){
	    							result=result.replaceAll("\\s*", "");
	    						}
								String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
								if(null!=result&&!result.equals("")&&result.matches(regex)){
								   double a=Double.parseDouble(result);
								   if(a>=70){
									   result="A";
								   }
								   else if(a>=60&&a<=69){
									   result="B";
								   }
								   else if(a>=50&&a<=59){
									   result="C";
								   }
								   else{
									   result="F";
								   }
								   student.setTempzk(result);
								}
	    					}
					}
					else if(exam.getExamtype()==2){//正考-补做   
						List<String> list=new ArrayList<String>();
						list.add("RW");	    						
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
	    					}
						}	
					}else if(exam.getExamtype()==3){ //正考-补考
						List<String> list=new ArrayList<String>();
						List<ScoreNew> zkScoreList;
						List<ScoreNew> zkbzScoreList;
						List<ScoreNew> zkbkScoreList;
						if(exam.getScoretype()==2){							
							list.add("RA");
							list.add("Resit-RA");
							list.add("ABS-RA");
							list.add("DISQ-RA");
							list.add("CHT-RA");
						}else if(exam.getScoretype()==3){
							list.add("F");
							list.add("B");
							list.add("C");
							list.add("ABS-RA");
							list.add("DISQ-RA");
							list.add("CHT-RA");
						}
						else if(exam.getScoretype()==4){
							list.add("RA");
							list.add("Resit-RA");
							list.add("ABS-RA");
							list.add("DISQ-RA");
							list.add("CHT-RA");
						}
						zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(exam.getScoretype()==2){	    						
	    						if(list.contains(score.getResult())){	    						
	    							student.setExamstatus(1);
	    							sidNew.append(student.getSid());
	    							sidNew.append(",");
	    						}
	    					}
	    					else if(exam.getScoretype()==3){	    						
	    						String result=score.getResult();
	    						if(null!=result){
	    							result=result.replaceAll("\\s*", "");
	    						}
								String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
								
								if(null!=result&&!result.equals("")&&result.matches(regex)){
								  double a=Double.parseDouble(result);
								   if(a>=70){
									   result="A";
								   }
								   else if(a>=60&&a<=69){
									   result="B";
									   bolexam.append(student.getSid());
									   bolexam.append(",");
								   }
								   else if(a>=50&&a<=59){
									   result="C";
									   bolexam.append(student.getSid());
									   bolexam.append(",");
								   }
								   else{
									   result="F";
								   }
								}
								if(user.getUserType()==7){
									if(list.contains(result)){	    						
										student.setExamstatus(1);
										sidNew.append(student.getSid());
										sidNew.append(",");
									}

								}
								else{
									
									String resultnew=zkbkScoreList.get(0).getResult();
									if(null!=resultnew&&!resultnew.equals("")&&list.contains(result)){	    						
										student.setExamstatus(1);
										sidNew.append(student.getSid());
										sidNew.append(",");
									}
								}
	    					}
	    					//判断当前学生需不需要参加本次考试
	    					if(exam.getScoretype()==4){	    						
	    						if(list.contains(score.getResult())){	    						
	    							student.setExamstatus(1);
	    							sidNew.append(student.getSid());
	    							sidNew.append(",");
	    						}
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0&&exam.getScoretype()==3){
	    						student.setZk(zkScoreList.get(0).getResult());
	    						if(null!=zkScoreList.get(0).getResult()&&!zkScoreList.get(0).getResult().equals("")){
	    							String result=zkScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=70){
										   result="A";
									   }
									   else if(a>=60&&a<=69){
										   result="B";
									   }
									   else if(a>=50&&a<=59){
										   result="C";
									   }
									   else{
										   result="F";
									   }
									   student.setTempzk(result);
									}
	    						}
	    					}
	    					if(null!=zkScoreList&&zkScoreList.size()>0&&exam.getScoretype()!=3){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0&&exam.getScoretype()!=3){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0&&exam.getScoretype()==3){
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    						if(null!=zkbkScoreList.get(0).getResult()&&!zkbkScoreList.get(0).getResult().equals("")){
	    							String result=zkbkScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(null!=result&&!result.equals("")&&result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=70){
										   result="A";
									   }
									   else if(a>=60&&a<=69){
										   result="B";
									   }
									   else if(a>=50&&a<=59){
										   result="C";
									   }
									   else{
										   result="F";
									   }
									   student.setTempzkbk(result);
									}
	    						}
	    					}
						}	
						
					}else if(exam.getExamtype()==4){//正考-补考-补做 
						List<String> list=new ArrayList<String>();
						list.add("RW");
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){	    						
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
	    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
	    						student.setBaifenscore(zkbkbzScoreList.get(0).getBaifenresult());
	    					}
						}	
					}else if(exam.getExamtype()==5){//重修
						List<String> list=new ArrayList<String>();
						list.add("Resit");
						list.add("ABS");
						list.add("DISQ");
						list.add("CHT");
						list.add("RA");
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
							//获取每一位学生的雅思成绩
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){	    						
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
	    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
	    						student.setCx(cxScoreList.get(0).getResult());
	    						student.setBaifenscore(cxScoreList.get(0).getBaifenresult());
	    					}
						}	
					}else if(exam.getExamtype()==6){//重修-补做
						List<String> list=new ArrayList<String>();
						list.add("RW");
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){	    						
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
	    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
	    						student.setCx(cxScoreList.get(0).getResult());
	    					}
	    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
	    						student.setCxbz(cxbzScoreList.get(0).getResult());
	    						student.setBaifenscore(cxbzScoreList.get(0).getBaifenresult());
	    					}
						}	
					}else if(exam.getExamtype()==7){//毕前考
						List<String> list=new ArrayList<String>();
						if(exam.getScoretype()==2){							
							list.add("P");
						}else if(exam.getScoretype()==3){
							list.add("F");
							list.add("ABS");
							list.add("DQRS");
							list.add("CHT");
						}
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						List<ScoreNew> bqkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),7);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(exam.getScoretype()==2){	    						
	    						if(!list.contains(score.getResult())){	    						
	    							student.setExamstatus(1);
	    							sidNew.append(student.getSid());
	    							sidNew.append(",");
	    						}
	    					}
	    					else if(exam.getScoretype()==3){
	    						String result=score.getResult();
	    						if(null!=result){
	    							result=result.replaceAll("\\s*", "");
	    						}
								String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
								if(null!=result&&!result.equals("")&&result.matches(regex)){
									double a=Double.parseDouble(result);
								  if(a>=50){
									   result="C";
								   }
								   else{
									   result="F";
								   }
								}
								if(list.contains(result)){	    						
	    							student.setExamstatus(1);
	    							sidNew.append(student.getSid());
	    							sidNew.append(",");
	    						}
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0&&exam.getScoretype()==3){
	    						student.setZk(zkScoreList.get(0).getResult());
	    						if(null!=zkScoreList.get(0).getResult()&&!zkScoreList.get(0).getResult().equals("")){
	    							String result=zkScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(null!=result&&!result.equals("")&&result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=70){
										   result="A";
									   }
									   else if(a>=60&&a<=69){
										   result="B";
									   }
									   else if(a>=50&&a<=59){
										   result="C";
									   }
									   else{
										   result="F";
									   }
									   student.setTempzk(result);
									}
	    						}
	    					}
	    					if(null!=zkScoreList&&zkScoreList.size()>0&&exam.getScoretype()!=3){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0&&exam.getScoretype()!=3){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0&&exam.getScoretype()==3){
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    						if(null!=zkbkScoreList.get(0).getResult()&&!zkbkScoreList.get(0).getResult().equals("")){
	    							String result=zkbkScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(null!=result&&!result.equals("")&&result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=70){
										   result="A";
									   }
									   else if(a>=60&&a<=69){
										   result="B";
									   }
									   else if(a>=50&&a<=59){
										   result="C";
									   }
									   else{
										   result="F";
									   }
									   student.setTempzkbk(result);
									}
	    						}
	    					}
	    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
	    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
	    						student.setCx(cxScoreList.get(0).getResult());
	    					}
	    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
	    						student.setCxbz(cxbzScoreList.get(0).getResult());
	    					}
	    					if(null!=bqkScoreList&&bqkScoreList.size()>0&&exam.getScoretype()!=3){	    	    						
	    						student.setBqk(bqkScoreList.get(0).getResult());
	    						student.setBaifenscore(bqkScoreList.get(0).getBaifenresult());
	    					}
	    					if(null!=bqkScoreList&&bqkScoreList.size()>0&&exam.getScoretype()==3){	    	    						
	    						student.setBqk(bqkScoreList.get(0).getResult());
	    						
	    						if(null!=bqkScoreList.get(0).getResult()&&!bqkScoreList.get(0).getResult().equals("")){
	    							String result=bqkScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(null!=result&&!result.equals("")&&result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=50){
										   result="C";
									   }									  
									   else{
										   result="F";
									   }
									   student.setTempbqk(result);
									}
	    						}
	    					}
						}	
					}else if(exam.getExamtype()==8){//毕前考-补做
						List<String> list=new ArrayList<String>();
						list.add("RW");
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						List<ScoreNew> bqkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),7);
						List<ScoreNew> bqkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),8);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){	    						
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
	    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
	    						student.setCx(cxScoreList.get(0).getResult());
	    					}
	    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
	    						student.setCxbz(cxbzScoreList.get(0).getResult());
	    					}
	    					if(null!=bqkScoreList&&bqkScoreList.size()>0){	    	    						
	    						student.setBqk(bqkScoreList.get(0).getResult());
	    					}
	    					if(null!=bqkbzScoreList&&bqkbzScoreList.size()>0){	    	    						
	    						student.setBqkbz(bqkbzScoreList.get(0).getResult());
	    						student.setBaifenscore(bqkbzScoreList.get(0).getBaifenresult());
	    					}
						}	
					}else if(exam.getExamtype()==9){//其它考
						List<String> list=new ArrayList<String>();
						if(exam.getScoretype()==2){							
							list.add("RA");
							list.add("ABS");
							list.add("CHT");
						}else if(exam.getScoretype()==3){
							list.add("F");
						}
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						List<ScoreNew> bqkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),7);
						List<ScoreNew> bqkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),8);
						List<ScoreNew> qtScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),9);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(exam.getScoretype()==2){	    						
	    						if(list.contains(score.getResult())){	    						
	    							student.setExamstatus(1);
	    							sidNew.append(student.getSid());
	    							sidNew.append(",");
	    						}
	    					}
	    					else if(exam.getScoretype()==3){
	    						String result=score.getResult();
	    						if(null!=result){
	    							result=result.replaceAll("\\s*", "");
	    						}
								String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
								if(null!=result&&!result.equals("")&&result.matches(regex)){
									double a=Double.parseDouble(result);
								   if(a>=50){
									   result="C";
								   }
								   else{
									   result="F";
								   }
								}
								if(list.contains(result)){	    						
	    							student.setExamstatus(1);
	    							sidNew.append(student.getSid());
	    							sidNew.append(",");
	    						}
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0&&exam.getScoretype()==3){
	    						student.setZk(zkScoreList.get(0).getResult());
	    						if(null!=zkScoreList.get(0).getResult()&&!zkScoreList.get(0).getResult().equals("")){
	    							String result=zkScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(null!=result&&!result.equals("")&&result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=70){
										   result="A";
									   }
									   else if(a>=60&&a<=69){
										   result="B";
									   }
									   else if(a>=50&&a<=59){
										   result="C";
									   }
									   else{
										   result="F";
									   }
									   student.setTempzk(result);
									}
	    						}
	    					}
	    					if(null!=zkScoreList&&zkScoreList.size()>0&&exam.getScoretype()!=3){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0&&exam.getScoretype()!=3){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0&&exam.getScoretype()==3){
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    						if(null!=zkbkScoreList.get(0).getResult()&&!zkbkScoreList.get(0).getResult().equals("")){
	    							String result=zkbkScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(null!=result&&!result.equals("")&&result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=70){
										   result="A";
									   }
									   else if(a>=60&&a<=69){
										   result="B";
									   }
									   else if(a>=50&&a<=59){
										   result="C";
									   }
									   else{
										   result="F";
									   }
									   student.setTempzkbk(result);
									}
	    						}
	    					}
	    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
	    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
	    						student.setCx(cxScoreList.get(0).getResult());
	    					}
	    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
	    						student.setCxbz(cxbzScoreList.get(0).getResult());
	    					}
	    					if(null!=bqkScoreList&&bqkScoreList.size()>0&&exam.getScoretype()!=3){	    	    						
	    						student.setBqk(bqkScoreList.get(0).getResult());
	    						student.setBaifenscore(bqkScoreList.get(0).getBaifenresult());
	    					}
	    					if(null!=bqkScoreList&&bqkScoreList.size()>0&&exam.getScoretype()==3){	    	    						
	    						student.setBqk(bqkScoreList.get(0).getResult());
	    						
	    						if(null!=bqkScoreList.get(0).getResult()&&!bqkScoreList.get(0).getResult().equals("")){
	    							String result=bqkScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(null!=result&&!result.equals("")&&result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=50){
										   result="C";
									   }									  
									   else{
										   result="F";
									   }
									   student.setTempbqk(result);
									}
	    						}
	    					}
	    					if(null!=bqkbzScoreList&&bqkbzScoreList.size()>0){	    	    						
	    						student.setBqkbz(bqkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=qtScoreList&&qtScoreList.size()>0&&exam.getScoretype()!=3){
	    						student.setQt(qtScoreList.get(0).getResult());
	    						student.setBaifenscore(qtScoreList.get(0).getBaifenresult());
	    					}
	    					if(null!=qtScoreList&&qtScoreList.size()>0&&exam.getScoretype()==3){	    	    						
	    						student.setQt(qtScoreList.get(0).getResult());
	    						
	    						if(null!=qtScoreList.get(0).getResult()&&!qtScoreList.get(0).getResult().equals("")){
	    							String result=qtScoreList.get(0).getResult();
	    							if(null!=result){
		    							result=result.replaceAll("\\s*", "");
		    						}
									String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
									if(null!=result&&!result.equals("")&&result.matches(regex)){
									  double a=Double.parseDouble(result);
									   if(a>=50){
										   result="C";
									   }									  
									   else{
										   result="F";
									   }
									   student.setTempqt(result);
									}
	    						}
	    					}
						}	
					}else if(exam.getExamtype()==10){//其它考-补做
						List<String> list=new ArrayList<String>();
						list.add("RW");
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						List<ScoreNew> bqkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),7);
						List<ScoreNew> bqkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),8);
						List<ScoreNew> qtScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),9);
						List<ScoreNew> qtbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),10);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){	    						
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
	    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
	    						student.setCx(cxScoreList.get(0).getResult());
	    					}
	    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
	    						student.setCxbz(cxbzScoreList.get(0).getResult());
	    					}
	    					if(null!=bqkScoreList&&bqkScoreList.size()>0){	    	    						
	    						student.setBqk(bqkScoreList.get(0).getResult());
	    					}
	    					if(null!=bqkbzScoreList&&bqkbzScoreList.size()>0){	    	    						
	    						student.setBqkbz(bqkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=qtScoreList&&qtScoreList.size()>0){	    	    						
	    						student.setQt(qtScoreList.get(0).getResult());
	    					}
	    					if(null!=qtbzScoreList&&qtbzScoreList.size()>0){	    	    						
	    						student.setQtbz(qtbzScoreList.get(0).getResult());   							
	    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());	    					
	    					}
						}	
					}
					else if(exam.getExamtype()==20){//第二次补考
						List<String> list=new ArrayList<String>();
						list.add("RA");
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> decbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),20);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){	    						
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    					}
	    					if(null!=decbkScoreList&&decbkScoreList.size()>0){	    	    						
	    						student.setDecbk(decbkScoreList.get(0).getResult());
	    						student.setBaifenscore(decbkScoreList.get(0).getBaifenresult());
	    					}
						}	
					}
					
					else if(exam.getExamtype()==21){//其他
						List<String> list=new ArrayList<String>();
						list.add("RA");
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> decbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),20);
						List<ScoreNew> qt2ScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),21);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){	    						
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    					}
	    					if(null!=decbkScoreList&&decbkScoreList.size()>0){	    	    						
	    						student.setDecbk(decbkScoreList.get(0).getResult());
	    					}
	    					if(null!=qt2ScoreList&&qt2ScoreList.size()>0){	    	    						
	    						student.setQt2(qt2ScoreList.get(0).getResult());
	    						student.setBaifenscore(qt2ScoreList.get(0).getBaifenresult());
	    					}
						}	
					}
					else if(exam.getExamtype()==22){//其他-补考
						List<String> list=new ArrayList<String>();
						list.add("RA");
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> decbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),20);
						List<ScoreNew> qt2ScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),21);
						List<ScoreNew> qt2bzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),22);
						if(null!=score){
							//获取每一位学生的雅思成绩
	    					List ieltsList = mgr.getIeltsListBySid(student.getSid());    					   					
	    					if(null != ieltsList && ieltsList.size() > 0){
	    						Ielts ielts = (Ielts) ieltsList.get(0);
	    						student.setIelts(ielts.getTotal());
	    					}else{
	    						student.setIelts(null);
	    					}
	    					//判断当前学生有没有参加本次考试
	    					if(list.contains(score.getResult())){	    						
	    						student.setExamstatus(1);
	    						sidNew.append(student.getSid());
	    						sidNew.append(",");
	    					}
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    					}
	    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
	    						student.setZkbk(zkbkScoreList.get(0).getResult());
	    					}
	    					if(null!=decbkScoreList&&decbkScoreList.size()>0){	    	    						
	    						student.setDecbk(decbkScoreList.get(0).getResult());
	    						
	    					}
	    					if(null!=qt2ScoreList&&qt2ScoreList.size()>0){	    	    						
	    						student.setQt2(qt2ScoreList.get(0).getResult());
	    					}
	    					if(null!=qt2bzScoreList && qt2bzScoreList.size()>0){	    	    						
	    						student.setQt2bz(qt2bzScoreList.get(0).getResult());
	    						student.setBaifenscore(qt2bzScoreList.get(0).getBaifenresult());
	    					}
						}	
					}
					
					
			      }				
				request.setAttribute("exam", exam);
				request.setAttribute("bol", bol);
				request.setAttribute("dateNew", dateNew);
    			request.setAttribute("resultList", resultList);
    			request.setAttribute("titleList", titleList);
    			request.setAttribute("sid", sid);
    			request.setAttribute("sidNew", sidNew.toString());
    			request.setAttribute("studentList", studentList);
    			request.setAttribute("tuser", user);
    			request.setAttribute("bolexam", bolexam.toString());
    		//	request.setAttribute("buttonStatus",buttonStatus);
    			if(exam.getScoretype()==1||exam.getScoretype()==3){
    				return "toScoreInputOther";
    			}
    			
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toScoreInput";
    }
	
	
	public String exportResultExcel(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		try {
    			HttpServletResponse  response = ServletActionContext.getResponse();
        		response.setContentType("text/html;charset=utf-8");
        		PrintWriter out=response.getWriter();
    			String examid = request.getParameter("examid");
    			String param = request.getParameter("param");
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			TClass tclass = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
    			exam.setClassname(tclass.getName());
    			Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(exam.getSubjectid()));
    			exam.setSubjectname(subject.getName());
    			DifferentPhase phase=new DifferentPhase();
    			List<String> titleList=new ArrayList<String>();      			   			
    			studentList = mgr.getStudentListByClassname(tclass.getName());    			
    			if(exam.getScoretype()==1){//百分制   				
      				exam.setScoreTypeName("百分制");
      				exam.setExamTypeName("");
      				titleList=phase.getCurrSubjectResultExcelTileFeibaizhi(exam.getExamtype());
      				}
                if(exam.getScoretype()==2){//非百分制   
       				String examTypeName=phase.getExamType(exam.getExamtype());
       				exam.setScoreTypeName("非百分制");
       				exam.setExamTypeName(examTypeName);
       				if(param.equals("exportCurrResult")){       					
       					titleList=phase.getCurrResultExcelTileFeibaizhi(exam.getExamtype());
       				}else{
       					titleList=phase.getCurrSubjectResultExcelTileFeibaizhi(exam.getExamtype());
       				}
       				}
                if(exam.getScoretype()==3){//记分单元 
      				String examTypeName=phase.getExamType(exam.getExamtype());
      				exam.setScoreTypeName("记分单元 ");
      				exam.setExamTypeName(examTypeName);
      				if(param.equals("exportCurrResult")){       					
       					titleList=phase.getCurrResultExcelTileOther(exam.getExamtype());
       				}else{
       					titleList=phase.getCurrSubjectResultExcelTileOther(exam.getExamtype());
       				}
      				}
				for(int i = 0; i < studentList.size(); i++){
					Student student = (Student) studentList.get(i);
					//获取该学生该阶段该科目上一次考试的结果成绩，同一科目同一阶段只会有一种得分制考试	    					 
					ScoreNew score = mgr.getScoreForInputNew(student.getSid(), exam.getSubjectid(), exam.getPhaseid());
					if(exam.getExamtype()==1){
    					List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);	    					
    					student.setExamstatus(1);
    					if(null != zkScoreList && zkScoreList.size() > 0){
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
    					}	    					    		    				   	    				
					}
					else if(exam.getExamtype()==2){//正考-补做       						
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
	    					//获取之前的所有考试成绩
	    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
	    						student.setZk(zkScoreList.get(0).getResult());
	    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
	    					}
	    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
	    						student.setZkbz(zkbzScoreList.get(0).getResult());
	    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
	    					}
					}else if(exam.getExamtype()==3){ //正考-补考
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						if(null!=score){
	    					if(exam.getScoretype()==3){	    						
	    						String result=score.getResult();
								String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
								if(result.matches(regex)){
								  double a=Double.parseDouble(result);
								   if(a>=70){
									   result="A";
								   }
								   else if(a>=60&&a<=69){
									   result="B";
								   }
								   else if(a>=50&&a<=59){
									   result="C";
								   }
								   else{
									   result="F";
								   }
								}
	    					}
    					//获取之前的所有考试成绩
    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
    						student.setZkbz(zkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
    						student.setZkbk(zkbkScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
    					}
						}	
					}else if(exam.getExamtype()==4){//正考-补考-补做 
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
	    					//获取之前的所有考试成绩
						if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
    						student.setZkbz(zkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
    						student.setZkbk(zkbkScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkbzScoreList.get(0).getBaifenresult());
    					}	
					}else if(exam.getExamtype()==5){//重修
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);	
    					//获取之前的所有考试成绩
						if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
    						student.setZkbz(zkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
    						student.setZkbk(zkbkScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
    						student.setCx(cxScoreList.get(0).getResult());
    						student.setBaifenscore(cxScoreList.get(0).getBaifenresult());
    					}	
					}else if(exam.getExamtype()==6){//重修-补做
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
    					//获取之前的所有考试成绩
						if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
    						student.setZkbz(zkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
    						student.setZkbk(zkbkScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
    						student.setCx(cxScoreList.get(0).getResult());
    						student.setBaifenscore(cxScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
    						student.setCxbz(cxbzScoreList.get(0).getResult());
    						student.setBaifenscore(cxbzScoreList.get(0).getBaifenresult());
    					}
					}else if(exam.getExamtype()==7){//毕前考
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						List<ScoreNew> bqkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),7);
						if(exam.getScoretype()==3){
    						String result=score.getResult();
							String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
							if(result.matches(regex)){
								double a=Double.parseDouble(result);
							  if(a>=50){
								   result="C";
							   }
							   else{
								   result="F";
							   }
							}
    					}
    					//获取之前的所有考试成绩
						if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
    						student.setZkbz(zkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
    						student.setZkbk(zkbkScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
    						student.setCx(cxScoreList.get(0).getResult());
    						student.setBaifenscore(cxScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
    						student.setCxbz(cxbzScoreList.get(0).getResult());
    						student.setBaifenscore(cxbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=bqkScoreList&&bqkScoreList.size()>0){	    	    						
    						student.setBqk(bqkScoreList.get(0).getResult());
    						student.setBaifenscore(bqkScoreList.get(0).getBaifenresult());
    					}	
					}else if(exam.getExamtype()==8){//毕前考-补做;
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						List<ScoreNew> bqkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),7);
						List<ScoreNew> bqkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),8);
    					//获取之前的所有考试成绩
						if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
    						student.setZkbz(zkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
    						student.setZkbk(zkbkScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
    						student.setCx(cxScoreList.get(0).getResult());
    						student.setBaifenscore(cxScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
    						student.setCxbz(cxbzScoreList.get(0).getResult());
    						student.setBaifenscore(cxbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=bqkScoreList&&bqkScoreList.size()>0){	    	    						
    						student.setBqk(bqkScoreList.get(0).getResult());
    						student.setBaifenscore(bqkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=bqkbzScoreList&&bqkbzScoreList.size()>0){	    	    						
    						student.setBqkbz(bqkbzScoreList.get(0).getResult());
    						student.setBaifenscore(bqkbzScoreList.get(0).getBaifenresult());
    					}	
					}else if(exam.getExamtype()==9){//其它考
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						List<ScoreNew> bqkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),7);
						List<ScoreNew> bqkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),8);
						List<ScoreNew> qtScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),9);
	    				if(exam.getScoretype()==3){
	    						String result=score.getResult();
								String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
								if(result.matches(regex)){
									double a=Double.parseDouble(result);
								   if(a>=50){
									   result="C";
								   }
								   else{
									   result="F";
								   }
								}
	    					}
	    					//获取之前的所有考试成绩
	    				if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(zkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
    						student.setZkbz(zkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
    						student.setZkbk(zkbkScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
    						student.setBaifenscore(zkbkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
    						student.setCx(cxScoreList.get(0).getResult());
    						student.setBaifenscore(cxScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
    						student.setCxbz(cxbzScoreList.get(0).getResult());
    						student.setBaifenscore(cxbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=bqkScoreList&&bqkScoreList.size()>0){	    	    						
    						student.setBqk(bqkScoreList.get(0).getResult());
    						student.setBaifenscore(bqkScoreList.get(0).getBaifenresult());
    					}
    					if(null!=bqkbzScoreList&&bqkbzScoreList.size()>0){	    	    						
    						student.setBqkbz(bqkbzScoreList.get(0).getResult());
    						student.setBaifenscore(bqkbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=qtScoreList&&qtScoreList.size()>0){
    						student.setQt(qtScoreList.get(0).getResult());
    						student.setBaifenscore(qtScoreList.get(0).getBaifenresult());
    					}	
					}else if(exam.getExamtype()==10){//其它考-补做
						List<ScoreNew> zkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),1);
						List<ScoreNew> zkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),2);
						List<ScoreNew> zkbkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),3);
						List<ScoreNew> zkbkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),4);
						List<ScoreNew> cxScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),5);
						List<ScoreNew> cxbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),6);
						List<ScoreNew> bqkScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),7);
						List<ScoreNew> bqkbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),8);
						List<ScoreNew> qtScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),9);
						List<ScoreNew> qtbzScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),10);
    					//获取之前的所有考试成绩
    					if(null!=zkScoreList&&zkScoreList.size()>0){	    	    						
    						student.setZk(zkScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbzScoreList&&zkbzScoreList.size()>0){	    	    						
    						student.setZkbz(zkbzScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkScoreList&&zkbkScoreList.size()>0){	    	    						
    						student.setZkbk(zkbkScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=zkbkbzScoreList&&zkbkbzScoreList.size()>0){	    	    						
    						student.setZkbkbz(zkbkbzScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxScoreList&&cxScoreList.size()>0){	    	    						
    						student.setCx(cxScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=cxbzScoreList&&cxbzScoreList.size()>0){	    	    						
    						student.setCxbz(cxbzScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=bqkScoreList&&bqkScoreList.size()>0){	    	    						
    						student.setBqk(bqkScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=bqkbzScoreList&&bqkbzScoreList.size()>0){	    	    						
    						student.setBqkbz(bqkbzScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=qtScoreList&&qtScoreList.size()>0){	    	    						
    						student.setQt(qtScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
    					if(null!=qtbzScoreList&&qtbzScoreList.size()>0){	    	    						
    						student.setQtbz(qtbzScoreList.get(0).getResult());
    						student.setBaifenscore(qtbzScoreList.get(0).getBaifenresult());
    					}
					}	
				}	
				String[] cellTitle = new String[titleList.size()];
				titleList.toArray(cellTitle);
				String content="";
    			if(param.equals("exportCurrResult")){
    				if(exam.getScoretype()==2){
    					content=new ExcelUtil2007().exportCurrResultExcelFeibaifenzhi(cellTitle,studentList,exam);
    				}else{
    					content=new ExcelUtil2007().exportCurrResultExcelJifendanyuanAndBaifenzhi(cellTitle,studentList,exam);
    				}
    			}else{
    				if(exam.getScoretype()==2){
    					content=new ExcelUtil2007().exportCurrSubjectResultExcelFeibaifenzhi(cellTitle,studentList,exam);
    				}else{
    					content=new ExcelUtil2007().exportCurrSubjectResultExcelJifendanyuanAndBaifenzhi(cellTitle,studentList,exam);
    				}
    			}
    			if(content.equals("false")){
    				out.print("导出失败");
    			}else{
    				//response.reset();
    				out.print(content);
    			}
    			out.flush();
        		out.close();
    		} catch (Exception e) {

    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	
	public String downloadExcel() {
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String content=request.getParameter("content");
		content=null!=content&&!content.equals("")?new String(content.getBytes("ISO8859-1"), "utf-8"):content;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        OutputStream fos = null;
        InputStream fis = null;        
      //如果是从服务器上取就用这个获得系统的绝对路径方法。 
        String filepath = "D:/download/"+content;
//      response.setContentType("application/vnd.ms-excel");
//      response.setHeader("Content-disposition","attachment;filename=" + URLEncoder.encode(filepath, "utf-8"));
        response.setHeader( "Content-Disposition", "attachment;filename=" + new String( filepath.getBytes("gb2312"), "ISO8859-1" ) );
        System.out.println("文件路径"+filepath);
        File uploadFile = new File(filepath);
        	fis = new FileInputStream(uploadFile);
            bis = new BufferedInputStream(fis);
            fos = response.getOutputStream();
            bos = new BufferedOutputStream(fos);
            //这个就就是弹出下载对话框的关键代码
            int bytesRead = 0;
            //输入流进行先读，然后用输出流去写，唯一不同的是我用的是缓冲输入输出流
            byte[] buffer = new byte[1024*8192];
            while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush();
            fis.close();
            bis.close();
            fos.close();
            bos.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        return null;
	}


	public String doScoreInput(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    			String examid = request.getParameter("examid");
    			String buttonStatus = request.getParameter("buttonStatus");
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			Subject subject=(Subject) this.combiz.get(Subject.class, exam.getSubjectid());
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			String sid = request.getParameter("sid");
    			String sidArray[] = sid.split(",");
    			for(int i = 0; i < sidArray.length; i++){
    				String parametername = "score"+sidArray[i];
    				String studentscore = "";
    				String baifenparam = "";
    				String baifenresult = "";
    				if(exam.getScoretype()==3){    					
    					 studentscore = request.getParameter(parametername);
    				}
    				else if(exam.getScoretype()==2){
    					 studentscore = request.getParameter(parametername);
	   					 baifenparam = "baifenresult"+sidArray[i];
	   					 baifenresult = request.getParameter(baifenparam);
    				}else{
    					studentscore = request.getParameter(parametername);
    				}
    				if(null==studentscore||studentscore.equals("")){
    					studentscore=null;
    				}
    				String sidtemp = sidArray[i];
    				List<ScoreNew> currentScoreList=new ArrayList<ScoreNew>();
    				ScoreNew score=null;
    				if(exam.getExamtype()==1){
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),1);    					
    				}else if(exam.getExamtype()==2){   				
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),2);
    				}else if(exam.getExamtype()==3){  
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),3);
    				}else if(exam.getExamtype()==4){   
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),4);
    				}else if(exam.getExamtype()==5){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),5);
    				}else if(exam.getExamtype()==6){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),6);
    				}else if(exam.getExamtype()==7){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),7);
    				}else if(exam.getExamtype()==8){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),8);
    				}else if(exam.getExamtype()==9){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),9);
    				}else if(exam.getExamtype()==10){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),10);
    				}
    				if(null!=currentScoreList&&currentScoreList.size()>0){
    					score=currentScoreList.get(0);
    				}else{
    					score= new ScoreNew();
    				}

    				if(user.getUserType()==3&&null!=studentscore&&!studentscore.equals("")&&null!=currentScoreList.get(0).getResult()&&!currentScoreList.get(0).getResult().equals("")&&!currentScoreList.get(0).getResult().equals(studentscore)){
						Logging logging = new Logging();
						logging.setUsername(user.getUser());
						logging.setUsertype(user.getUserType());
						Date now = new Date();
						logging.setOpertime(now);
						logging.setContent("用户："+user.getUser()+"修改了学号:"+sidtemp+"的成绩");  					
						this.combiz.save(logging);
						
						/*Student student=mgr.getStudentBySid(sidtemp);
						TClass tclass=mgr.getClassByName(student.getClassname());
						String totalteachername="";
						 List<String> teacherlist=mgr.getKechengByclassnamesubjectname(subject.getName(),tclass.getName());
						 for(String teachername:teacherlist){
							 totalteachername+=teachername+",";
						 }
						 if(null!=totalteachername&&!totalteachername.equals("")){							 
							 totalteachername=totalteachername.substring(0, totalteachername.length()-1);
						 }
						Notice notice = new Notice();
						notice.setPublisherid(user.getUserType());
						Date currDate = new Date();
						notice.setPublishdate(sdf.format(currDate));
						notice.setStatus(3);
						notice.setTitle("成绩修改通知");
						notice.setUsername(totalteachername);						
						notice.setContent("用户："+user.getUser()+"修改了学号:"+sidtemp+"的成绩");
						notice.setType(5);
						notice.setNoticetype("4");
						notice.setClassid(tclass.getId());
					    this.combiz.save(notice);*/
					}
    				doScoreInputTempHandle(score, exam, sidtemp, studentscore,buttonStatus,baifenresult);    			
    				
    				}	
    			if(user.getUserType() == 3){
    				return "doScoreInputManage";
    			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return "doScoreInput";
    }
	
	
	public void doScoreInputTempHandle(ScoreNew score,Exam exam,String sidtemp,String studentscore,String buttonStatus,String baifenresult){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		score.setClasskey(exam.getClasskey());
		score.setExamdate(sdf.format(exam.getEdate()));
		score.setExamid(exam.getId());
		score.setSid(sidtemp);
		score.setSubjectid(exam.getSubjectid());
		score.setPhaseid(exam.getPhaseid());
		score.setResult(studentscore);
		if(null!=baifenresult&&!baifenresult.equals("")){
			score.setBaifenresult(Double.parseDouble(baifenresult));	
		}
		score.setExamtype(exam.getExamtype());
		score.setScoretype(exam.getScoretype());
		score.setMajor(exam.getTitle());
		if(null!=buttonStatus&&buttonStatus.equals("1")){
			score.setButtonstatus(Integer.parseInt(buttonStatus));
		}
		else if(null!=buttonStatus&&buttonStatus.equals("2")){
			score.setButtonstatus(Integer.parseInt(buttonStatus));
			if(user.getUserType()==3||user.getUserType()==4){				
				exam.setDisplaystatus(3);
			}
			else{
				exam.setDisplaystatus(5);
			}
			this.combiz.update(exam);
		}
		else{
			score.setButtonstatus(null);
		}			
		this.combiz.saveOrupate(score);	
		
		Logging logging = new Logging();
		logging.setUsername(user.getUser());
		logging.setUsertype(user.getUserType());
		Date now = new Date();
		logging.setOpertime(now);
		if(user.getUserType()==7){			
			if(null==buttonStatus||buttonStatus.equals("")){
				logging.setContent("用户："+user.getUser()+"保存了学号:"+sidtemp+"的成绩");
			}else if(buttonStatus.equals("1")||buttonStatus.equals("2")){
				logging.setContent("用户："+user.getUser()+"提交了学号:"+sidtemp+"的成绩");
			}	
			this.combiz.save(logging);		
		}
		/*Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
		Teacher teacher = mgr.getTeacherByTid(exam.getTeacherid());
		exam.setTeachername(teacher.getName());
		//TClass tclass = mgr.getClassByCid(exam.getClassid());
		TClass tclass = (TClass) this.combiz.get(TClass.class, Integer.valueOf(exam.getClassid()));
		exam.setClassname(tclass.getName());
		Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(exam.getSubjectid()));
		exam.setSubjectname(subject.getName());
		request.setAttribute("exam", exam);
		
		teacherList = mgr.getTeacherList();
		request.setAttribute("teacherList", teacherList);
		
		studentList = mgr.getStudentListByClassname(tclass.getName());
		request.setAttribute("studentList", studentList);
		
		List indexList = new ArrayList();
		for(int i = 1; i<= exam.getExamtype(); i++){
			indexList.add(i);
		}
		request.setAttribute("indexList", indexList);*/
		
	}
	
	/*
	 * 对成绩提交的各种判断
	 * */
	public String doHandleInput(){
		try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    			String examid = request.getParameter("examid");
    			String buttonStatus = request.getParameter("buttonStatus");
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			Teacher teacher = mgr.getTeacherByTid(exam.getTeacherid());
    			Teacher neishenyuan = mgr.getTeacherByTid(exam.getNeishenyuanid());
    			exam.setTeachername(teacher.getName());
    			exam.setNeishenyuanname(neishenyuan.getName());
    			String sid = request.getParameter("sid");
    			String sidArray[] = sid.split(",");
    			List<Student> studentList=new ArrayList<Student>();
    			List<String> resultList=new ArrayList<String>();//成绩
    			TClass tclass = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
    			exam.setClassname(tclass.getName());
    			Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(exam.getSubjectid()));
    			exam.setSubjectname(subject.getName());
    			DifferentPhase phase=new DifferentPhase();
    			String sidNewOther="";//出现不一致成绩，返回所有学生sid,适应于正考
    			String bol="true";//判断是否出现不一致成绩
    			if(exam.getScoretype()==1){//百分制   				
      				exam.setScoreTypeName("百分制");
      				exam.setExamTypeName("");              				
      				}
                if(exam.getScoretype()==2){//非百分制   
	       				String examTypeName=phase.getExamType(exam.getExamtype());
	       				exam.setScoreTypeName("非百分制");
	       				exam.setExamTypeName(examTypeName);
	       				if(user.getUserType()==7){
	       					resultList=phase.getFeiBaiFenZhiResultTeacher(exam.getExamtype());
	       				}else{
	       					resultList=phase.getFeiBaiFenZhiResult(exam.getExamtype());
	       				}
       				}
                if(exam.getScoretype()==3){//记分单元 
      				String examTypeName=phase.getExamType(exam.getExamtype());
      				exam.setScoreTypeName("记分单元 ");
      				exam.setExamTypeName(examTypeName);              				
      				}
                
                if(exam.getScoretype()==4){//非百分制1.4
       				String examTypeName=phase.getExamType(exam.getExamtype());
       				exam.setScoreTypeName("非百分制1.4");
       				exam.setExamTypeName(examTypeName);
       				if(user.getUserType()==7){
       					resultList=phase.getFeiBaiFenZhiOneFourResultTeacher(exam.getExamtype());
       				}else{
       					resultList=phase.getFeiBaiFenZhiOneFourResult(exam.getExamtype());
       				}
   				}
                
                //此时第二次提交，需比对第一次
    			if(null!=buttonStatus&&buttonStatus.equals("1")){
    					if(exam.getExamtype()==1){    							
    						//返回第一次提交的正考成绩，与前台获取的第二次正考成绩做比对
    						for(int i = 0; i < sidArray.length; i++){
    							String parametername = "score"+sidArray[i];
    							String studentscore = request.getParameter(parametername);
    							String sidtemp = sidArray[i];
    							List<ScoreNew> zkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),1);
    							String score=zkScoreList.get(0).getResult();
    							Student student=mgr.getStudentBySid(sidtemp);
    							if(null!=score&&!score.equals(studentscore)){
    								sidNewOther=sidNewOther+sidArray[i]+",";
    								student.setZk(score);
    								student.setTempResult(studentscore);
    								student.setExamstatus(1);
    								studentList.add(student);
    								student.setTempColor("red");
    								bol="false";
    							}else if(null!=score&&score.equals(studentscore)){
    								sidNewOther=sidNewOther+sidArray[i]+",";
    								student.setZk(score);
    								student.setTempResult(studentscore);
    								student.setExamstatus(1);
    								studentList.add(student);
    							}else{
    								studentList.add(student);
    							}	    				   	    				
    						}
	    						//两次成绩全部相同
	    						if(bol.equals("true")){	    							
	    							for(int i = 0; i < sidArray.length; i++){
	    								String parametername = "score"+sidArray[i];
	    								String studentscore = request.getParameter(parametername);
	    								String sidtemp = sidArray[i];
	    								List<ScoreNew> zkScoreList=null;
	    								if(exam.getScoretype()==1){
	    		    						zkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),1,exam.getId());
	    		    					}else{	    						
	    		    						zkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),1);
	    		    					}
	    								doScoreInputTempHandle(zkScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
	    							}
	    						}    						   						
    					}
    					
    					else if(exam.getExamtype()==2){//判断两次成绩						
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> zkbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),2);
			    				String score=zkbzScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setZkbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setZkbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同,直接保存数据库
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> zkbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),2);
    								doScoreInputTempHandle(zkbzScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}
    	    					
    					}else if(exam.getExamtype()==3){ //正考-补考;
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> zkbkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),3);
			    				String score=zkbkScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setZkbk(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setZkbk(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> zkbkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),3);
    								doScoreInputTempHandle(zkbkScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}
	
    					}else if(exam.getExamtype()==4){//正考-补考-补做 
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> zkbkbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),4);
			    				String score=zkbkbzScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setZkbkbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setZkbkbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> zkbkbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),4);
    								doScoreInputTempHandle(zkbkbzScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}

    					}else if(exam.getExamtype()==5){//重修
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> cxScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),5);
			    				String score=cxScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setCx(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setCx(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> cxScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),5);
    								doScoreInputTempHandle(cxScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}
	
    					}else if(exam.getExamtype()==6){//重修-补做
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> cxbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),6);
			    				String score=cxbzScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setCxbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setCxbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> cxbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),6);
    								doScoreInputTempHandle(cxbzScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}
    	    					
    					}else if(exam.getExamtype()==7){//毕前考
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> bqkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),7);
			    				String score=bqkScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setBqk(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setBqk(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> bqkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),7);
    								doScoreInputTempHandle(bqkScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}
	
    					}else if(exam.getExamtype()==8){//毕前考-补做
    						for(int i = 0; i < sidArray.length; i++){
    							System.out.println(i);
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> bqkbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),8);
			    				String score=bqkbzScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setBqkbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setBqkbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> bqkbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),8);
    								doScoreInputTempHandle(bqkbzScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}
	
    					}else if(exam.getExamtype()==9){//其它考
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> qtScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),9);
			    				String score=qtScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				System.out.println(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setQt(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setQt(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> qtScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),9);
    								doScoreInputTempHandle(qtScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}
	
    					}else if(exam.getExamtype()==10){//其它考-补做
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> qtbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),10);
			    				String score=qtbzScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setQtbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setQtbz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> qtbzScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),10);
    								doScoreInputTempHandle(qtbzScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}
	
    					}
    					
    					else if(exam.getExamtype()==20){//第二次补考
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> decbkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),20);
			    				String score = decbkScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setDecbk(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setDecbk(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> decbkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),20);
    								doScoreInputTempHandle(decbkScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}

    					}
    					else if(exam.getExamtype()==21){//其他2
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> qt2ScoreList = mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),21);
			    				String score = qt2ScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setQt2(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setQt2(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> qt2ScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),21);
    								doScoreInputTempHandle(qt2ScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}

    					}
    					
    					else if(exam.getExamtype()==22){//其他2补考
    						for(int i = 0; i < sidArray.length; i++){
			    				String parametername = "score"+sidArray[i];
			    				String studentscore = request.getParameter(parametername);
			    				String sidtemp = sidArray[i];
			    				List<ScoreNew> qt2bkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),22);
			    				String score = qt2bkScoreList.get(0).getResult();
			    				Student student=mgr.getStudentBySid(sidtemp);
			    				if(null!=score&&!score.equals(studentscore)){
			    					sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setQt2bz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    	student.setTempColor("red");
	    					    	bol="false";
	    					    }else if(null!=score&&score.equals(studentscore)){
	    					    	sidNewOther=sidNewOther+sidArray[i]+",";
	    					    	student.setQt2bz(score);
	    					    	student.setTempResult(studentscore);
	    					    	student.setExamstatus(1);
	    					    	studentList.add(student);
	    					    }else{
	    					    	studentList.add(student);
	    					    }	    				   	    				
    						}
    						//两次成绩全部相同
    						if(bol.equals("true")){	    							
    							for(int i = 0; i < sidArray.length; i++){
    								String parametername = "score"+sidArray[i];
    								String studentscore = request.getParameter(parametername);
    								String sidtemp = sidArray[i];
    								List<ScoreNew> decbkScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),22);
    								doScoreInputTempHandle(decbkScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    							}
    						}

    					}
    				
    				
    			}else{//第一次提交
    				
    				if(null==buttonStatus||buttonStatus.equals("")){
        				buttonStatus="1";
        			}
    				
    				for(int i = 0; i < sidArray.length; i++){
    					String parametername = "score"+sidArray[i];
    					String baifenparam = "baifenresult"+sidArray[i];
    					String studentscore = request.getParameter(parametername);
    					String baifenresult = request.getParameter(baifenparam);
    					String sidtemp = sidArray[i];
    					List<ScoreNew> currentScoreList=new ArrayList<ScoreNew>();
    					ScoreNew score=null;
    					if(exam.getExamtype()==1){   				
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),1);
    					}else if(exam.getExamtype()==2){   				
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),2);
    					}else if(exam.getExamtype()==3){  
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),3);
    					}else if(exam.getExamtype()==4){   
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),4);
    					}else if(exam.getExamtype()==5){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),5);
    					}else if(exam.getExamtype()==6){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),6);
    					}else if(exam.getExamtype()==7){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),7);
    					}else if(exam.getExamtype()==8){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),8);
    					}else if(exam.getExamtype()==9){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),9);
    					}else if(exam.getExamtype()==10){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),10);
    					}
    					else if(exam.getExamtype()==20){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),20);
    					}
    					else if(exam.getExamtype()==21){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),21);
    					}
    					else if(exam.getExamtype()==22){   						
    						currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),22);
    					}
    					if(null!=currentScoreList&&currentScoreList.size()>0){
    						score=currentScoreList.get(0);
    					}else{
    						score= new ScoreNew();
    					}
    					doScoreInputTempHandle(score, exam, sidtemp, studentscore,buttonStatus,baifenresult);
    				}
    				
    		}
    			if(bol.equals("false")){
    				request.setAttribute("studentList", studentList);
    				request.setAttribute("exam", exam);
    				request.setAttribute("resultList", resultList);
    				request.setAttribute("sidNewOther", sidNewOther);
    				request.setAttribute("sid", sid);
    				return "toScoreCompare";
    			}
    			
    			if(user.getUserType() == 3 || user.getUserType() == 4){
    				return "doScoreInputManage";
    			}
    			
    			request.setAttribute("examid", examid);
    			
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doHandleInput";
    }
	
	/*
	 * 两次成绩比对一致后直接保存
	 * */
	public String doScoreHandle(){
		try{
	    		HttpServletRequest request = ServletActionContext.getRequest();
	    		User user = (User) request.getSession().getAttribute("tuser");
    			String examid = request.getParameter("examid");
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			String sid = request.getParameter("sid");
    			String sidArray[] = sid.split(",");
    			for(int i = 0; i < sidArray.length; i++){
    				String parametername = "score"+sidArray[i];
    				String studentscore = request.getParameter(parametername);						
    				String sidtemp = sidArray[i];	    					   		    					    	
    				List<ScoreNew> currentScoreList=new ArrayList<ScoreNew>();
    				if(exam.getExamtype()==1){   				
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),1);
    				}else if(exam.getExamtype()==2){   				
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),2);
    				}else if(exam.getExamtype()==3){  
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),3);
    				}else if(exam.getExamtype()==4){   
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),4);
    				}else if(exam.getExamtype()==5){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),5);
    				}else if(exam.getExamtype()==6){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),6);
    				}else if(exam.getExamtype()==7){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),7);
    				}else if(exam.getExamtype()==8){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),8);
    				}else if(exam.getExamtype()==9){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),9);
    				}else if(exam.getExamtype()==10){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),10);
    				}else if(exam.getExamtype()==20){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),20);
    				}else if(exam.getExamtype()==21){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),21);
    				}else if(exam.getExamtype()==22){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),22);
    				}
    				doScoreInputTempHandle(currentScoreList.get(0), exam, sidtemp, studentscore,"2","");	    				   	    				
    			}   						   						

    			if(user.getUserType() == 3 || user.getUserType() == 4){
    				return "doScoreInputManage";
    			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doScoreHandle";
    }
	
	public String doPublicInput(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    			String examid = request.getParameter("examid");
    			User user = (User) request.getSession().getAttribute("tuser");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			Subject subject=(Subject) this.combiz.get(Subject.class, exam.getSubjectid());
    			String currentsubject=subject.getName();
    			String currentexamtype=new DifferentPhase().getExamType(exam.getExamtype());
    			String currentscoretype="";
    			String currentphase="";
    			if(exam.getScoretype()==1){
    				currentscoretype="百分制";
    			}
    			else if(exam.getScoretype()==2){
    				currentscoretype="非百分制";
    			}
    			else{
    				currentscoretype="记分单元";
    			}
    			if(exam.getPhaseid()==0){
    				currentphase="无";
    			}
    			else if(exam.getPhaseid()==1){
    				currentphase="Assessment1";
    			}
    			else if(exam.getPhaseid()==2){
    				currentphase="Assessment2";
    			}
    			else if(exam.getPhaseid()==3){
    				currentphase="Assessment3";
    			}
    			else if(exam.getPhaseid()==4){
    				currentphase="Assessment4";
    			}
    			else{
    				currentphase="Assessment5";
    			}
    			exam.setDisplaystatus(4);//把这次考试的成绩状态置为已发布
    			this.combiz.update(exam);    			
    			String sid = request.getParameter("sid");
    			String sidNew = request.getParameter("sidNew");
    			String sidArray[] = sid.split(",");
    			String sidNewArray[] = sidNew.split(",");
    			Boolean bol=false;
    			double passnumber = 0D;
    			for(int i = 0; i < sidArray.length; i++){
    				String parametername = "score"+sidArray[i];
    				String studentscore = "";
    				String baifenparam = "";
    				String baifenresult = "";
    				if(exam.getScoretype()==3){    					
    					 studentscore = request.getParameter(parametername);
    					 if(null!=studentscore&&!studentscore.equals("")&&(studentscore.equalsIgnoreCase("A") || studentscore.equalsIgnoreCase("B") || studentscore.equalsIgnoreCase("C"))){
    						 passnumber = passnumber + 1;
    					 }
    				}
    				else if(exam.getScoretype()==2){
    					 studentscore = request.getParameter(parametername);
	   					 baifenparam = "baifenresult"+sidArray[i];
	   					 baifenresult = request.getParameter(baifenparam);
	   					if(null!=studentscore&&!studentscore.equals("")&&studentscore.equalsIgnoreCase("P")){
	   						System.out.println(studentscore);
	   						 passnumber = passnumber + 1;
	   					}
    				}else{
    					studentscore = request.getParameter(parametername);
    					if(null!=studentscore&&!studentscore.equals("")){
    						double baifen = 0;
    						baifen = Double.valueOf(studentscore);
    						if(baifen>=60){    							
    							passnumber = passnumber + 1;
    						}
	   					}
    				}
    				if(null==studentscore||studentscore.equals("")){
    					studentscore=null;
    				}
    				String sidtemp = sidArray[i];
    				List<ScoreNew> currentScoreList=new ArrayList<ScoreNew>();
    				ScoreNew score=null;
    				if(exam.getExamtype()==1){   				
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),1);
    				}else if(exam.getExamtype()==2){   				
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),2);
    				}else if(exam.getExamtype()==3){  
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),3);
    				}else if(exam.getExamtype()==4){   
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),4);
    				}else if(exam.getExamtype()==5){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),5);
    				}else if(exam.getExamtype()==6){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),6);
    				}else if(exam.getExamtype()==7){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),7);
    				}else if(exam.getExamtype()==8){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),8);
    				}else if(exam.getExamtype()==9){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),9);
    				}else if(exam.getExamtype()==10){   						
    					currentScoreList=mgr.getScore(sidtemp, exam.getSubjectid(), exam.getPhaseid(),10);
    				}
//    				if(null!=currentScoreList&&currentScoreList.size()>0){
    					score=currentScoreList.get(0);
    					String currResult=currentScoreList.get(0).getResult();
//    				}else{
//    					score= new ScoreNew();
//    				}
    		
    				score.setClasskey(exam.getClasskey());
    				score.setExamdate(sdf.format(exam.getEdate()));
    				score.setExamid(exam.getId());
    				score.setSid(sidtemp);
    				score.setSubjectid(exam.getSubjectid());
    				score.setPhaseid(exam.getPhaseid());
    				score.setResult(studentscore);
    				if(null!=baifenresult&&!baifenresult.equals("")){
    					score.setBaifenresult(Double.parseDouble(baifenresult));	
    				}
    				score.setExamtype(exam.getExamtype());
    				score.setScoretype(exam.getScoretype());
    				score.setMajor(exam.getTitle());			
    				this.combiz.saveOrupate(score);
    				Logging logging = new Logging();
    				logging.setUsername(user.getUser());
    				logging.setUsertype(user.getUserType());
    				Date now = new Date();
    				logging.setOpertime(now);
    				if(null!=currResult&&!currResult.equals("")&&null!=studentscore&&!studentscore.equals("")&&currResult.equals(studentscore)){   					
    					logging.setContent("用户："+user.getUser()+"发布了学号:"+sidtemp+"的"+currentphase+"-"+currentsubject+"-"+currentscoretype+"-"+currentexamtype+"成绩");
    				}else{
    					bol=true;
    					logging.setContent("用户："+user.getUser()+"修改并发布了学号:"+sidtemp+"的"+currentphase+"-"+currentsubject+"-"+currentscoretype+"-"+currentexamtype+"成绩");
    				}
    				this.combiz.save(logging);
    		      
    			}

  		         Integer classkey=exam.getClasskey();
  		         TClass tclass=(TClass) this.combiz.get(TClass.class , classkey);
  		         String totalteachername="";
				 List<String> teacherlist=mgr.getKechengByclassnamesubjectname(subject.getName(),tclass.getName());
				 for(String teachername:teacherlist){
					 totalteachername+=teachername+",";
				 }
				 if(null!=totalteachername&&!totalteachername.equals("")){					 
					 totalteachername=totalteachername.substring(0, totalteachername.length()-1);
				 }
			     /*Notice notice_=null;
			     Date currDate = new Date();
			     DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    	 notice_ = new Notice();
			    	 notice_.setType(5);
			    	 notice_.setTitle("成绩修改通知");
			    	 if(bol){			    		 
			    		 notice_.setContent("用户："+user.getUser()+"修改并发布了"+subject.getName()+"的"+currentphase+"-"+currentsubject+"-"+currentscoretype+"-"+currentexamtype+"成绩");
			    	 }else{
			    		 notice_.setContent("用户："+user.getUser()+"发布了"+subject.getName()+"的"+currentphase+"-"+currentsubject+"-"+currentscoretype+"-"+currentexamtype+"成绩");
			    	 }
			    	 notice_.setClassid(tclass.getId());
			    	 notice_.setPublishdate(df.format(currDate));
			    	 notice_.setUsername(totalteachername);
			    	 notice_.setNoticetype("4");
			    	 notice_.setStatus(3);
			    	 this.combiz.save(notice_);*/
    			// 计算通过考试人数 start
    			double passnumberD = passnumber/sidNewArray.length;
    			BigDecimal b = new BigDecimal(passnumberD);  
    			double passrateD = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
    			passrateD = passrateD * 100;
    			Integer passrateI = (int) passrateD;
    			String passrate = passrateI + "%";
    			exam.setPassnumber((int)passnumber );
    			exam.setPassrate(passrate);
    			this.combiz.update(exam);
    			// 计算通过考试人数 end
    			
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doPublicInput";
    }
	
	public String toClassList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		classList = mgr.getClassList();
    		List classListNew = new ArrayList();
    		for(int i = 0 ; i < classList.size(); i++){
    			TClass cla = (TClass) classList.get(i);
    			if(null == cla.getAssistantid() || 0 == cla.getAssistantid()){
    				cla.setAssistant(null);
    			}else{
    				Assistant assistant = (Assistant) this.combiz.get(Assistant.class, cla.getAssistantid());
        			cla.setAssistant(assistant);
    			}
    			classListNew.add(cla);
    		}
    		request.setAttribute("classListNew", classListNew);

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toClassList";
    }
	
	public String toAdjustClassAssistant(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String classid =  request.getParameter("classid");
    		TClass cla = (TClass) this.combiz.get(TClass.class, Integer.valueOf(classid));
    		if(null == cla.getAssistantid() || 0 == cla.getAssistantid()){
				cla.setAssistant(null);
			}else{
				Assistant assistant = (Assistant) this.combiz.get(Assistant.class, cla.getAssistantid());
    			cla.setAssistant(assistant);
			}
    		request.setAttribute("cla", cla);
    		assistantList = mgr.getAssistantList();
    		request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toAdjustClassAssistant";
    }
	
	public String doAdjustClassAssistant(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String assistantid =  request.getParameter("assistantid");
    		String classid =  request.getParameter("classid");
    		TClass cla = (TClass) this.combiz.get(TClass.class, Integer.valueOf(classid));
    		if(null != assistantid && !assistantid.equals("")){
    			Assistant assistant = (Assistant) this.combiz.get(Assistant.class, Integer.valueOf(assistantid));
    			cla.setAssistantid(Integer.valueOf(assistantid));
    			this.combiz.saveOrupate(cla);
    			
    			String classname = cla.getName();
    			
    			JDBCConnection dbcon = new JDBCConnection();
    			Connection con = dbcon.openConnection();
    			Statement sm = con.createStatement();
    			String sql = "update student set assistant = '"+assistant.getName()+"' where classname = '"+classname+"'";
    			sm.executeUpdate(sql);
    			dbcon.closeConnection();
    		}else{
    			cla.setAssistant(null);
    			this.combiz.saveOrupate(cla);
    			
                String classname = cla.getName();
    			JDBCConnection dbcon = new JDBCConnection();
    			Connection con = dbcon.openConnection();
    			Statement sm = con.createStatement();
    			String sql = "update student set assistant = null where classname = '"+classname+"'";
    			sm.executeUpdate(sql);
    			dbcon.closeConnection();
    		}
    		
    		/*if(null == cla.getAssistantid() || 0 == cla.getAssistantid()){
				cla.setAssistant(null);
			}else{
				Assistant assistant = (Assistant) this.combiz.get(Assistant.class, cla.getAssistantid());
    			cla.setAssistant(assistant);
    			
    			String classname = cla.getName();
    			JDBCConnection dbcon = new JDBCConnection();
    			Connection con = dbcon.openConnection();
    			Statement sm = con.createStatement();
    			String sql = "update student set assistant = '"+assistant.getName()+"' where classname = '"+classname+"'";
    			sm.executeUpdate(sql);
    			dbcon.closeConnection();
			}*/
    		request.setAttribute("cla", cla);
    		assistantList = mgr.getAssistantList();
    		request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doAdjustClassAssistant";
    }
	
	public String toMyExamList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		
    		List<Exam> examList = new ArrayList<Exam>();
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
    		String sql = "";
    		if(user.getUserType() == 3 || user.getUserType() == 4 || user.getUserType() == 5){
    			sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
				" where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and ( e.displaystatus = 4 or e.displaystatus = 3 ) ";
    			if(!sql.equals("")){
    				ResultSet rs = sm.executeQuery(sql);
        			while(rs.next()){
        				       Integer id = rs.getInt("id");
                               String title = rs.getString("title");
                               Date edate = rs.getDate("edate");
                               String classname = rs.getString("classname");
                               String subjectname = rs.getString("subjectname");
                               String fromtime = rs.getString("fromtime");
                               Integer examtype = rs.getInt("examtype");
                               Integer scoretype = rs.getInt("scoretype");
                               Integer displaystatus = rs.getInt("displaystatus");
                               Integer passnumber = rs.getInt("passnumber");
                               String passrate = rs.getString("passrate");
                               Exam exam = new Exam();
                               exam.setId(id);
                               exam.setTitle(title);
                               exam.setEdate(edate);
                               exam.setClassname(classname);
                               exam.setSubjectname(subjectname);
                               exam.setFromtime(fromtime);
                               exam.setExamtype(examtype);
                               exam.setScoretype(scoretype);
                               exam.setDisplaystatus(displaystatus);
                               exam.setPassnumber(passnumber);
                               exam.setPassrate(passrate);
                               examList.add(exam);
        				}
    			}
			}
    		
    		
    		if(user.getUserType() == 6){
    			String username = user.getUser();
    			Assistant assistant = mgr.getAssistantByName(username);
    			Integer assistantid = assistant.getId();
    			sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
				" where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and e.displaystatus = 4 and tt.assistantid = "+assistantid;
    			
    			if(!sql.equals("")){
    				ResultSet rs = sm.executeQuery(sql);
        			while(rs.next()){
        				       Integer id = rs.getInt("id");
                               String title = rs.getString("title");
                               Date edate = rs.getDate("edate");
                               String classname = rs.getString("classname");
                               String subjectname = rs.getString("subjectname");
                               String fromtime = rs.getString("fromtime");
                               Integer examtype = rs.getInt("examtype");
                               Integer scoretype = rs.getInt("scoretype");
                               Integer displaystatus = rs.getInt("displaystatus");
                               Integer passnumber = rs.getInt("passnumber");
                               String passrate = rs.getString("passrate");
                               Exam exam = new Exam();
                               exam.setId(id);
                               exam.setTitle(title);
                               exam.setEdate(edate);
                               exam.setClassname(classname);
                               exam.setSubjectname(subjectname);
                               exam.setFromtime(fromtime);
                               exam.setExamtype(examtype);
                               exam.setScoretype(scoretype);
                               exam.setDisplaystatus(displaystatus);
                               exam.setPassnumber(passnumber);
                               exam.setPassrate(passrate);
                               examList.add(exam);
        				}
    			}
			}
    		
    		if(user.getUserType() == 7){
    			String username = user.getUser();
    			//String sqlteacher = "select distinct classname, subjectname, from kecheng where teacher ='"+username+"'";
    			/*String sqlteacher = "select distinct classname, subjectname,vid ,isvalid from kecheng kc, kechengversion kcv where kc.v_id = kcv.id " 
                                    +" and kcv.isvalid = 1 and teacher ='"+username+"'";*/
    			String sqlteacher = "select distinct classname, subjectname,isvalid from kecheng kc, kechengversion kcv where kc.v_id = kcv.id " 
    					+" and kcv.isvalid = 1 and teacher ='"+username+"'";
    			ResultSet rsteacher = sm.executeQuery(sqlteacher);
    			List renkeList = new ArrayList();
    			Renke renke =null;
    			while(rsteacher.next()){
    				String classname = rsteacher.getString("classname");
    				String subjectname = rsteacher.getString("subjectname");	
    			    renke = new Renke();
    				renke.setClassname(classname);
    				renke.setSubjectname(subjectname);
    				renkeList.add(renke);
    			}
    			
    			for (int i = 0; i < renkeList.size(); i++) {
					Renke rk = (Renke) renkeList.get(i);
					/*sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt "
							+ " where e.subjectid = s.id and e.classkey = tt.id and e.displaystatus = 4  and e.teacherid = t.tid and s.name = '"
							+ rk.getSubjectname()
							+ "' and tt.tname = '"
							+ rk.getClassname() + "'";*/
					sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname FROM exam e, teacher t, subject s , tclass tt  "
							+ " where e.subjectid = s.id and e.classkey = tt.id and e.displaystatus = 4  and e.teacherid = t.tid and s.name = '"
							+ rk.getSubjectname()
							+ "' and tt.tname = '"
							+ rk.getClassname() + "'";
					ResultSet rs = sm.executeQuery(sql);
					while (rs.next()) {
						Integer id = rs.getInt("id");
						String title = rs.getString("title");
						Date edate = rs.getDate("edate");
						String classname = rs.getString("classname");
						String subjectname = rs.getString("subjectname");
						String fromtime = rs.getString("fromtime");
						Integer examtype = rs.getInt("examtype");
						Integer scoretype = rs.getInt("scoretype");
						Integer displaystatus = rs.getInt("displaystatus");
						Integer passnumber = rs.getInt("passnumber");
                        String passrate = rs.getString("passrate");
						Exam exam = new Exam();
						exam.setId(id);
						exam.setTitle(title);
						exam.setEdate(edate);
						exam.setClassname(classname);
						exam.setSubjectname(subjectname);
						exam.setFromtime(fromtime);
						exam.setExamtype(examtype);
						exam.setScoretype(scoretype);
						exam.setDisplaystatus(displaystatus);
						 exam.setPassnumber(passnumber);
                         exam.setPassrate(passrate);
						examList.add(exam);
					}
				}

    			
    			
			}
    			request.setAttribute("examList", examList);
    			dbcon.closeConnection();

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toMyExamList";
    }
	
	public String toScore(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		try {
    			String examid = request.getParameter("examid");
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			Teacher teacher = mgr.getTeacherByTid(exam.getTeacherid());
    			exam.setTeachername(teacher.getName());
    			//TClass tclass = mgr.getClassByCid(exam.getClassid());
    			TClass tclass = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
    			exam.setClassname(tclass.getName());
    			Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(exam.getSubjectid()));
    			exam.setSubjectname(subject.getName());
    			request.setAttribute("exam", exam);
    			
    			teacherList = mgr.getTeacherList();
    			request.setAttribute("teacherList", teacherList);
    			
    			User user = (User) request.getSession().getAttribute("tuser");
    			Integer examtype = exam.getExamtype();
    			
    			studentList = mgr.getStudentListByClassname(tclass.getName());

    			studentListScore =  new ArrayList();
    			for(int i = 0; i < studentList.size(); i++){
    				Student student = (Student) studentList.get(i);
    				Score score = mgr.getScoreForInput(student.getSid(), exam.getSubjectid(), exam.getPhaseid());
    				if(null != score){
    					if(exam.getDisplaystatus() < 3){
        					if(!user.getUser().equals(teacher.getName())){
        						if(examtype == 1){
            						score.setExam1(null);
            					}
            					if(examtype == 2){
            						score.setExam2(null);
            					}
            					if(examtype == 3){
            						score.setExam3(null);
            					}
            					if(examtype == 4){
            						score.setExam4(null);
            					}
            					if(examtype == 5){
            						score.setExam5(null);
            					}
            					if(examtype == 6){
            						score.setExam6(null);
            					}
            					if(examtype == 7){
            						score.setExam7(null);
            					}
            					if(examtype == 8){
            						score.setExam8(null);
            					}
        					}
        				}
    				}
    				
    				student.setScore(score);
    				studentListScore.add(student);
    				
    			}
    			request.setAttribute("studentList", studentList);
    			request.setAttribute("studentListScore", studentListScore);
    			String sid = "";
    			if(null != studentList && studentList.size() > 0){
    				for(int i = 0; i < studentList.size(); i++){
        				Student stu = (Student) studentList.get(i);
        				sid = sid + stu.getSid()+",";
        			}
    			}
    			request.setAttribute("sid", sid);
    			
    			List indexList = new ArrayList();
    			for(int i = 1; i<= exam.getExamtype(); i++){
    				indexList.add(i);
    			}
    			request.setAttribute("indexList", indexList);
    			request.setAttribute("maxindex", indexList.size());
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toScore";
    }
	

	
	public String importKecheng(){
		HttpServletRequest request = ServletActionContext.getRequest();
		errorLine = new StringBuffer("");
	    radid=request.getParameter("reversion"); 
	    
		if (upload == null) {
			addActionMessage("请填写好待上传的文件！");
		}
		if (!contentType.equals("application/vnd.ms-excel")) {
			if(contentType.equals("application/octet-stream")){
				//addActionMessage("文件正在使用，不能上传！");
			}else{
				addActionMessage("上传文件格式不正确！");
			}
		}
		try {
			if (!parseXslFileKecheng(upload)) {
				//addActionMessage("课程数据导入失败");
				if (errorLine.length() > 0) {
					
				}
				
				request.getSession().setAttribute("errorLine", errorLine);
				
			}else{
				addActionMessage("课程数据导入成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List kechengList=new ArrayList(); 
		try {
				//kechengList = mgr.getKechengList();	
				kechenglist = mgr.getKechengListByVid(Integer.parseInt(radid));	
			   if(kechenglist!=null && kechenglist.size()>0 ){
				  for(int i=0;i<kechenglist.size();i++){
					  Object object[] = (Object[]) kechenglist.get(i);
					  Kecheng kecheng=(Kecheng) object[0];
					  kechengList.add(kecheng);  
			     }  
			   }
				request.setAttribute("sa", radid);
			   // kechengversionList= mgr.getKechengversionList();
				kechengversionList= mgr.getKechengversionList(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addActionMessage(errorLine.toString());
		request.setAttribute("kechengList", kechengList);
		request.setAttribute("kechengversionList", kechengversionList);
		return "result";
	}
	
	private boolean parseXslFileKecheng(File file) {
		boolean flag=true;
		try {
			xslParser = new ExcelParser(file);
			Hashtable activeMap = xslParser.getContent(0, 2);
			if (activeMap.isEmpty() || activeMap.size() > 20000) {
				addActionMessage("Excel 中无可用数据或超过最大允许到如导入的限度.");
				return false;
			}
				for (int i = 0; i < activeMap.size(); i++) {
					Vector row = (Vector) activeMap.get("row" + i);
					if (row.get(1).equals(row.get(2)) && row.get(2) == row.get(3)){
						//有些时候在正常数据之后会有很多行中包含不可见字符,但每个单元格中的不可见字符都相同.
						//所以,如果这三个字段值相同,则认为是非正常行开始了,停止执行该循环.
						errorLine.append("第"+(i+1)+"行课程表1,2,3列内容相等导入失败请确认后导入<br/>");
						flag=false;
						break;
					}
					Kecheng kechneg=mgr.getKecheng((String) row.get(1),(String) row.get(2), (String) row.get(3), (String) row.get(4),(String) row.get(6),Integer.parseInt(radid));
		    	   if(null != kechneg){
		    			errorLine.append("第"+(i+1)+"行课程表数据已经存在不能导入添加<br/>");
		    			continue;
		    		}
						Kecheng kecheng = new Kecheng();
						kecheng.setGrade(Integer.valueOf(row.get(0).toString()));
						kecheng.setClassname((String) row.get(1));
						kecheng.setSubjectname((String) row.get(2));
						kecheng.setWeekday((String) row.get(3));
						kecheng.setStarttime((String) row.get(4));
						kecheng.setEndtime((String) row.get(5));
						kecheng.setTeacher((String) row.get(6));
						kecheng.setCampus((String) row.get(7));
						kecheng.setClassroom((String) row.get(8));
						kecheng.setWeek(Integer.valueOf(row.get(9).toString()));
						kecheng.setSemester((String) row.get(10));
						kecheng.setV_id(Integer.valueOf(radid));
					    this.combiz.save(kecheng); 
				 }
				if(!flag ){
					return false;
				}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public String toKechengList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest(); 
     		String sa = request.getParameter("versions");
    		 System.out.println("sa-----------"+sa);
    		 Integer v_id = null;
    		 if(sa=="" || sa==null){
//    			// kechengList = mgr. getKechengList(); 
//    			     
//    			 List kechenglist=new ArrayList();
//    			 for(int i=0;i<kechengList.size();i++){
//    				 Object object[] = (Object[]) kechengList.get(i);
//    				 Kecheng kecheng=(Kecheng) object[0];
//    				 kechenglist.add(kecheng);
//    				 request.setAttribute("kechengList", kechenglist);
//    			 }
//    			  request.setAttribute("sa", 0);
    			 
    			 
    			 allKechengList=mgr.getAllkechenglist1();
    			  for(int i=0;i<allKechengList.size();i++){
    				 Object object[] = (Object[]) allKechengList.get(0);
    				 Kecheng kecheng=(Kecheng) object[0];
    				 v_id=kecheng.getV_id();
    			 }
    			 kechengList = mgr. getKechengList(v_id);
    			 request.setAttribute("sa", v_id);
    		  }
    		 else{
    			 kechengList = mgr.getKechengList(Integer.parseInt(sa));
    			 request.setAttribute("sa", sa);
    		   }
    		 request.setAttribute("kechengList", kechengList);
    		//kechengversionList= mgr.getKechengversionList();
    		kechengversionList= mgr.getKechengversionList(1);
    		request.setAttribute("kechengversionList", kechengversionList);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toKechengList";
    }
	public String getVersionKecheng(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String version=request.getParameter("version");
		System.out.println("verson---"+version);
			try {
				List kechengList=new ArrayList(); 
				kechenglist = mgr.getKechengListByVid(Integer.parseInt(version));
				//System.out.println(kechenglist!=null && kechenglist.size()>0);
				  if(kechenglist!=null && kechenglist.size()>0 ){
					  for(int i=0;i<kechenglist.size();i++){
						  Object object[] = (Object[]) kechenglist.get(i);
						  Kecheng kecheng=(Kecheng) object[0];
						  kechengList.add(kecheng);  
				     }  
				    }
					response.setContentType("application/json;charset=utf-8");
					PrintWriter outprintWriter =response.getWriter();
					outprintWriter.write(JSONArray.toJSONString(kechengList));
					outprintWriter.flush();
					outprintWriter.close();
				  
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	
	}
	
	public String toMyStudentList(){
    	try{
//    		HttpServletRequest request = ServletActionContext.getRequest();
//    		
//    		User user = (User) request.getSession().getAttribute("tuser");
//    		if(user.getUserType() == 6){
//    			String assisantname = user.getUser();
//    			studentList =  mgr.getStudentListByAssistantname(assisantname);
//    		}
//    		request.setAttribute("studentList", studentList);
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		Integer roleid=user.getUserType();

    		request.setAttribute("roleid", roleid);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toMyStudentList";
    }
	
	public String toStudentDetail(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String studentid = request.getParameter("studentid");
    		Student student = null;
    		//if(user.getUserType() == 6){
    			student = (Student) this.combiz.get(Student.class, Integer.valueOf(studentid));
    		//}
    		request.setAttribute("student", student);
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentDetail";
    }
	
	public String saveStudentInfo(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String mobile=request.getParameter("mobile");
    		String studentid = request.getParameter("studentid");
    		String fatherName = request.getParameter("fatherName");
    		String fatherMobile = request.getParameter("fatherMobile");
    		String motherName = request.getParameter("motherName");
    		String motherMobile = request.getParameter("motherMobile");
    		Student student = null;
    		fatherName = (fatherName != null)?new String(fatherName.getBytes("iso-8859-1"),"utf-8"):fatherName;
    		motherName = (motherName != null)?new String(motherName.getBytes("iso-8859-1"),"utf-8"):motherName;
    		student = (Student) this.combiz.get(Student.class, Integer.valueOf(studentid));
    		student.setCellphone(mobile);
    		student.setJzfcellphone(fatherMobile);
    		student.setJzfname(fatherName);
    		student.setJzmcellphone(motherMobile);
    		student.setJzmname(motherName);
    		this.combiz.saveOrupate(student);
    		student = (Student) this.combiz.get(Student.class, Integer.valueOf(studentid));
    		request.setAttribute("student", student);
    		addActionMessage("保存成功");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "saveStudentInfo";
    }
	
	public String toChangeStudentPassword(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String studentid = request.getParameter("studentid");
    		Student student = (Student) this.combiz.get(Student.class, Integer.valueOf(studentid));
    		String sid=student.getSid();
    		User user=mgr.getUserByName(sid);
    		request.setAttribute("student", user);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toChangeStudentPassword";
    }
	
	public String doStudentModify(){
		String returnvalue = "doStudentModify";
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String password = request.getParameter("password");
    		roleList = mgr.getRoleList();
    		request.setAttribute("roleList", roleList);
    		
    		User user = null;
    		
    		String userid = request.getParameter("userid");
    		if(null != userid && !userid.equals("")){
    			user = (User) this.combiz.get(User.class, Integer.valueOf(userid));
    		}else{
    			user = new User();
    		}
    		
    		
    		try {
    			password = new String(password.getBytes("iso-8859-1"),"utf-8");
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		user.setPass(password);
    		
    		this.combiz.saveOrupate(user); 
    		user = (User) this.combiz.get(User.class, Integer.valueOf(userid));
    		request.setAttribute("student", user);
    		addActionMessage("用户保存成功");

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return returnvalue;
    }
	
	public String toMyAbsenceList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String username = user.getUser();
    		String content=request.getParameter("content");
    		absenceList = new ArrayList();
    		subjectList = new ArrayList();
    		classList = new ArrayList();
    		JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			PreparedStatement stam=null;
			ResultSet rs=null;
			String sql="";
			
			if(user.getUserType() == 5){ 
    			/*学生主管查看所有班级*/
				classList=mgr.getClassList();
    			/*学生主管查看所有科目*/
				subjectList=mgr.getSubjectList();
				/*学生主管查看所有考勤记录*/
				List absenceList1=mgr.getAbsenceList();
				for(int i = 0 ; i < absenceList1.size(); i++){
					Absence absence = (Absence) absenceList1.get(i);
					TClass tclass=(TClass) this.combiz.get(TClass.class, absence.getClassid());
					//System.out.println(absence.getSid());
					List temp = mgr.getStudentList(absence.getSid());
					Student student=null;
					if(null != temp && temp.size() > 0){
					  student = (Student) temp.get(0);
						if(student!=null){
							absence.setStudentname(student.getName());
							absence.setStudent(student);
							absence.setClassname(tclass.getName());
							
						}	
					}
					if(student==null){
						continue;
					}
					Subject subject = (Subject) this.combiz.get(Subject.class, absence.getSubjectid());
					absence.setSubjectname(subject.getName());
					absenceList.add(absence);
				}
    		}
			
			else if(user.getUserType() == 6){
    			Assistant assistant = mgr.getAssistantByName(username);
    			/*当前辅导员所带的班级*/
    			classList = mgr.getClassListByAssistantid(assistant.getId());
    			/*当前辅导员所带班级的所有科目*/
    			sql="select s.id,s.name from " +
    				"(select distinct k.subjectname from assistant as assis,tclass as c,kecheng k,kechengversion kv,subject s where assis.id=c.assistantid and k.classname=c.tname and assis.name='"+username+"' and kv.id=k.v_id and kv.isvalid=1 )" +
    				"as oneselect,subject s " +
    				"where oneselect.subjectname=s.name";
    			stam=con.prepareStatement(sql);
    			rs=stam.executeQuery();
    			while(rs.next()){	
						Subject subject = new Subject();
						int tempsubjectid=rs.getInt("id");
						String subjectname=rs.getString("name");
						subject.setName(subjectname);
						subject.setId(tempsubjectid);
						subjectList.add(subject);
				}
    			if(null != classList && classList.size() > 0){
    				for(int i = 0 ; i < classList.size(); i++){
    					TClass cla = (TClass) classList.get(i);
    					List tempList = mgr.getAbsenceListByClassid(cla.getId());
    					if(null != tempList && tempList.size() > 0){    						
    						for(int j = 0 ; j < tempList.size(); j++){
    							Absence absence = (Absence) tempList.get(j);
    							TClass tclass=(TClass) this.combiz.get(TClass.class, absence.getClassid());
    							//System.out.println("tclass--"+tclass.getName());
    							//List temp = mgr.getStudentListBysidclassName(absence.getSid(),tclass.getName());
    							List temp = mgr.getStudentListBysidclassName(absence.getSid());
    							if(temp.size()!=0){
    								if(null != temp && temp.size() > 0){
    									Student student = (Student) temp.get(0);
    									System.out.println("student---"+student.getName());
    									absence.setStudentname(student.getName());
    									absence.setClassname(tclass.getName());
    									absence.setStudent(student);
    								}
    								Subject subject = (Subject) this.combiz.get(Subject.class, absence.getSubjectid());
    								absence.setSubjectname(subject.getName());
    								absenceList.add(absence);	
    							}
    						}
    					}
    				}
    				
    			}
    		}
    		
    		if(user.getUserType() == 7){
    			/*当前老师所代课的班级*/
    			List<String> tclassnameList = mgr.getDistinctKechengListByTeacher(user.getUser());
    			if(null!=tclassnameList&&tclassnameList.size()>0){   					
    				for (String tclassname : tclassnameList) {
    					TClass tclass=mgr.getClassByName(tclassname);
    					if(null!=tclass){   						
    						classList.add(tclass);
    					}
    				}
    			}
    			/*当前老师所有代课科目*/
    			sql="SELECT s.id,s.name FROM " +
				"(SELECT DISTINCT k.subjectname FROM teacher AS teac,kecheng AS k,kechengversion as kv WHERE teac.name=k.teacher AND k.teacher='"+username+"' and kv.id=k.v_id and kv.isvalid=1)" +
				" AS oneselect,SUBJECT AS s " +
				"WHERE oneselect.subjectname=s.name";
    			stam=con.prepareStatement(sql);
    			rs=stam.executeQuery();
    			while(rs.next()){						
					Subject subject = new Subject();
					int tempsubjectid=rs.getInt("id");
					String subjectname=rs.getString("name");
					subject.setName(subjectname);
					subject.setId(tempsubjectid);
					subjectList.add(subject);
    			}
    			/*当前老师代课班级所有学生的考勤记录*/
    			List absenceListNew = mgr.getAbsenceListByTeachername(user.getUser());
    			for(int k = 0 ; k < absenceListNew.size(); k++){
					Absence absence = (Absence) absenceListNew.get(k);
					TClass tclass=(TClass) this.combiz.get(TClass.class, absence.getClassid());
					List temp = mgr.getStudentList(absence.getSid());
					if(null != temp && temp.size() > 0){
						Student student = (Student) temp.get(0);
						absence.setClassname(tclass.getName());
						absence.setStudentname(student.getName());
						absence.setStudent(student);
					}
					Subject subject = (Subject) this.combiz.get(Subject.class, absence.getSubjectid());
					absence.setSubjectname(subject.getName());
					absenceList.add(absence);
				}
    		}
    		if(content!=null && content.equals("delete")){
    			addActionMessage("删除成功");
    		}
    		request.setAttribute("classList", classList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("absenceList", absenceList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toMyAbsenceList";
    }
	
	public String findAbsenceByCondition(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String classid=request.getParameter("classid");
    		
    		String sid=request.getParameter("sid");
    		String name=request.getParameter("name");
    		String subjectid=request.getParameter("subjectid");
    		String status=request.getParameter("status");
    		String date=request.getParameter("date");
    		String username = user.getUser();
    		absenceList = new ArrayList();
    		subjectList = new ArrayList();
    		classList = new ArrayList();
    		JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			ResultSet rs=null;
			Statement sm =null;
			String teachername_="";
			if(user.getUserType()==7){
				teachername_=user.getUser();
			}
			String sql="";			
			if(user.getUserType() == 5){ 
    			/*学生主管查看所有班级*/
				classList=mgr.getClassList();
    			/*学生主管查看所有科目*/
				subjectList=mgr.getSubjectList();
    		}
			
			else if(user.getUserType() == 6){
    			Assistant assistant = mgr.getAssistantByName(username);
    			/*当前辅导员所带的班级*/
    			classList = mgr.getClassListByAssistantid(assistant.getId());
    			/*当前辅导员所带班级的所有科目*/
    			sql=" SELECT s.id,s.name FROM " +
    				"(SELECT DISTINCT k.subjectname FROM assistant AS assis,tclass AS c,kecheng k,SUBJECT s WHERE assis.id=c.assistantid AND k.classname=c.tname AND assis.name='"+username+"') " +
    				"AS oneselect,SUBJECT s " +
    				"WHERE oneselect.subjectname=s.name";
    			sm = con.createStatement();
				rs = sm.executeQuery(sql);
    			while(rs.next()){						
						Subject subject = new Subject();
						int tempsubjectid=rs.getInt("id");
						String subjectname=rs.getString("name");
						subject.setName(subjectname);
						subject.setId(tempsubjectid);
						subjectList.add(subject);
				}
    		}
    		
    		else if(user.getUserType() == 7){ 
    			/*当前老师所代课的班级*/
    			List<String> tclassnameList = mgr.getDistinctKechengListByTeacher(user.getUser());
    			if(null!=tclassnameList&&tclassnameList.size()>0){   					
    				for (String tclassname : tclassnameList) {
    					TClass tclass=mgr.getClassByName(tclassname);
    					if(null!=tclass){   						
    						classList.add(tclass);
    					}
    				}
    			}
    			/*当前老师所有代课科目*/
    			sql="SELECT s.id,s.name FROM " +
    				"(SELECT DISTINCT k.subjectname FROM teacher AS teac,kecheng AS k WHERE teac.name=k.teacher AND k.teacher='"+username+"')" +
    				" AS oneselect,SUBJECT AS s " +
    				"WHERE oneselect.subjectname=s.name";
    			sm = con.createStatement();
				rs = sm.executeQuery(sql);
    			while(rs.next()){						
						Subject subject = new Subject();
						int tempsubjectid=rs.getInt("id");
						String subjectname=rs.getString("name");
						subject.setName(subjectname);
						subject.setId(tempsubjectid);
						subjectList.add(subject);
				}
    		}
    		
    		List objList=mgr.getAbsenceByCondition(teachername_,classid,sid,name,subjectid,status,date);
    		absenceList=new ArrayList<Absence>();
    		List<Integer> classidList=new ArrayList<Integer>();
    		if(null != objList && objList.size() > 0){
    			/*筛选属于当前角色所带班级的所有学生的考勤记录病统计*/
    			if(null != classList && classList.size() > 0){
    				for(int i = 0 ; i < classList.size(); i++){
    					TClass cla = (TClass) classList.get(i);
    					classidList.add(cla.getId());
    				}   				
    				for(int i = 0 ; i < objList.size(); i++){
    					Object[] obj = (Object[]) objList.get(i);
    					/*当前角色所带班级的classid是否包含当前classid*/
    					if(classidList.contains((Integer)obj[2])){    						
    						Absence absence=new Absence();
    						Integer late=0;
    						Integer early=0;
    						Integer truant=0;
    						Integer leave=0;
    						 List temp=null;
    						 TClass tc=null;
    			    		if(null!=classid&&!classid.equals("")){
    			    		    tc=(TClass) this.combiz.get(TClass.class, Integer.parseInt(classid));	
    			    		  // temp=  mgr.getStudentListBysidclassName((String)obj[0], tc.getName());
    			    		 //   System.out.println("(String)obj[0]---"+(String)obj[0]);
    			    		   temp=  mgr.getStudentListBysidclassName((String)obj[0]);
    			    		}else{
    			    			//System.out.println((Integer)obj[2]);
    			    		   tc=(TClass) this.combiz.get(TClass.class, (Integer)obj[2]);
    			    		  // temp=  mgr.getStudentListBysidclassName((String)obj[0], tc.getName());
    			    		   temp=  mgr.getStudentListBysidclassName((String)obj[0]);
    			    		}
							if(null != temp && temp.size() > 0){
								Student student = (Student) temp.get(0);
								absence.setStudentname(student.getName());
								absence.setSid(student.getSid());
								absence.setStudent(student);
								absence.setClassname(tc.getName());
								//List<Absence> tempAbsenceList=mgr.getAbsenceListBySid((String)obj[0]);
								List<Absence> tempAbsenceList=mgr.getAbsenceListBySid(teachername_,(String)obj[0],classid,subjectid,status,date);
								if(null != tempAbsenceList && tempAbsenceList.size() > 0){							
									for (Absence absence2 : tempAbsenceList) {
										System.out.println(absence2.getId());
										if(absence2.getType()==1){
											late+=1;
										}
										else if(absence2.getType()==2){
											truant+=1;
										}
										else if(absence2.getType()==4){
											early+=1;
										}
										else if(absence2.getType()==3){
											leave+=1;
											//early+=1;
										}
/*    										else if(absence2.getType()==5){
    											late+=1;
    											early+=1;
    										}
*/    									}
									absence.setLate(late);
									absence.setTruant(truant);
									absence.setEarly(early);
									absence.setLeave(leave);
								}else{
									absence.setLate(0);
									absence.setTruant(0);
									absence.setEarly(0);
									absence.setLeave(0);
								}
							}
							Subject subject = (Subject) this.combiz.get(Subject.class, (Integer)obj[1]);
							absence.setSubjectname(subject.getName());
							absenceList.add(absence);
    					}
    				}
    			}
			}
       
    		request.setAttribute("classList", classList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("absenceList", absenceList);
    		request.setAttribute("classid", classid);
    		request.setAttribute("sid", sid);
    		request.setAttribute("name", name);
    		request.setAttribute("subjectid", subjectid);
    		request.setAttribute("status", status);
    		request.setAttribute("date", date);
    		request.setAttribute("condition", "filter");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "findAbsenceByCondition";
    }
	
	public String lookAbsenceDetail(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String studentsid=request.getParameter("studentsid");
    		String name=request.getParameter("studentname");
    		String classid_=request.getParameter("classid_");
    		String subjectid_=request.getParameter("subjectid_");
    		String status_=request.getParameter("status_");
    		String date=request.getParameter("times");
    		//TClass tcl=mgr.getClassByName(classname);
    		//List<Absence> absenceList = mgr.getAbsenceListBySid(studentsid);
    		//List<Absence> absenceList = mgr.getAbsenceListBySid(studentsid,tcl.getId())
    		String username = user.getUser();
    		subjectList = new ArrayList();
    		classList = new ArrayList();
    		JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			PreparedStatement stam=null;
			ResultSet rs=null;
			String sql="";
			String teachername_="";
			if(user.getUserType()==7){
				teachername_=user.getUser();
			}
			if(user.getUserType() == 5){ 
    			/*学生主管查看所有班级*/
				classList=mgr.getClassList();
    			/*学生主管查看所有科目*/
				subjectList=mgr.getSubjectList();
    		}
    		/*for (Absence absence : absenceList) {				
    			Subject subject = (Subject) this.combiz.get(Subject.class, absence.getSubjectid());
    			Student student=mgr.getStudentBySid(absence.getSid());
    			absence.setStudent(student);
    			absence.setSubjectname(subject.getName()); 
    			absence.setClassname(tcl.getName());
			}*/
			
			
			else if(user.getUserType() == 6){
    			Assistant assistant = mgr.getAssistantByName(username);
    			/*当前辅导员所带的班级*/
    			classList = mgr.getClassListByAssistantid(assistant.getId());
    			/*当前辅导员所带班级的所有科目*/
    			sql="select s.id,s.name from " +
    				"(select distinct k.subjectname from assistant as assis,tclass as c,kecheng k,subject s where assis.id=c.assistantid and k.classname=c.tname and assis.name='"+username+"' )" +
    				"as oneselect,subject s " +
    				"where oneselect.subjectname=s.name";
    			stam=con.prepareStatement(sql);
    			rs=stam.executeQuery();
    			while(rs.next()){	
						Subject subject = new Subject();
						int tempsubjectid=rs.getInt("id");
						String subjectname=rs.getString("name");
						subject.setName(subjectname);
						subject.setId(tempsubjectid);
						subjectList.add(subject);
				}
    		}
    		
    		if(user.getUserType() == 7){
    			/*当前老师所代课的班级*/
    			List<String> tclassnameList = mgr.getDistinctKechengListByTeacher(user.getUser());
    			if(null!=tclassnameList&&tclassnameList.size()>0){   					
    				for (String tclassname : tclassnameList) {
    					TClass tclass=mgr.getClassByName(tclassname);
    					if(null!=tclass){   						
    						classList.add(tclass);
    					}
    				}
    			}
    			/*当前老师所有代课科目*/
    			sql="SELECT s.id,s.name FROM " +
				"(SELECT DISTINCT k.subjectname FROM teacher AS teac,kecheng AS k WHERE teac.name=k.teacher AND k.teacher='"+username+"')" +
				" AS oneselect,SUBJECT AS s " +
				"WHERE oneselect.subjectname=s.name";
    			stam=con.prepareStatement(sql);
    			rs=stam.executeQuery();
    			while(rs.next()){						
					Subject subject = new Subject();
					int tempsubjectid=rs.getInt("id");
					String subjectname=rs.getString("name");
					subject.setName(subjectname);
					subject.setId(tempsubjectid);
					subjectList.add(subject);
    			}
    			
    			
    			
    		}
    		
    		List objList=mgr.getAbsenceByCondition(teachername_,classid_,studentsid,name,subjectid_,status_,date);
    		absenceList=new ArrayList<Absence>();
    		List temp=  mgr.getStudentListBysidclassName(studentsid);
    		Student student=null;
    		 if(null != temp && temp.size() > 0){
			   student = (Student) temp.get(0);
    		if(null != objList && objList.size() > 0){  				
    				for(int i = 0 ; i < objList.size(); i++){
    					Object[] obj = (Object[]) objList.get(i);
    					/*当前角色所带班级的classid是否包含当前classid*/
								List<Absence> tempAbsenceList=mgr.getAbsenceListBySid(teachername_,(String)obj[0],classid_,subjectid_,status_,date);
								if(null != tempAbsenceList && tempAbsenceList.size() > 0){							
									for (Absence absence2 : tempAbsenceList) {
										absence2.setStudent(student);
										TClass tcl=(TClass) this.combiz.get(TClass.class, absence2.getClassid());
										absence2.setClassname(tcl.getName());
										Integer subjectid=absence2.getSubjectid();
										Subject sub=(Subject) this.combiz.get(Subject.class, subjectid);
										String subjectname=sub.getName();
										absence2.setSubjectname(subjectname);
										absenceList.add(absence2);	
   									} 	
						}
    				}
    			 }
    		 }   		
     		request.setAttribute("sid",studentsid);
    	    request.setAttribute("name",name);
    	    request.setAttribute("classid",classid_);
    	    request.setAttribute("subjectid",subjectid_);
    	    request.setAttribute("status",status_);
    	    request.setAttribute("date",date);
    	    
    		request.setAttribute("classList", classList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("absenceList", absenceList);
    		request.setAttribute("condition", "detail");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "lookAbsenceDetail";
    }
	
	public String doAbsenceStatus(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String username = user.getUser();
    		String absenceid = request.getParameter("absenceid");
    		Absence absence = (Absence) this.combiz.get(Absence.class, Integer.valueOf(absenceid));
    		absence.setType(3);
    		this.combiz.update(absence);
    		
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doAbsenceStatus";
    }
	
	public String toKaoqin(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
//    		String kechengid = request.getParameter("kechengid");
//    		String agers=request.getParameter("agers");
//    		if(agers!=null && agers.equals("1")){
//    			Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));
//    			String classname = kecheng.getClassname();
//    			studentList = mgr.getStudentListByClassname(classname);	
//    		}
//    		if(agers!=null && agers.equals("2")){
//    			Sec_Kecheng sec_kecheng = (Sec_Kecheng) this.combiz.get(Sec_Kecheng.class, Integer.valueOf(kechengid));
//    			String classname1=sec_kecheng.getClassname();
//    			studentList = mgr.getStudentListByClassname(classname1);
//    		}
//    		request.setAttribute("studentList", studentList);
//    		request.setAttribute("kechengid", kechengid);
    		//request.setAttribute("assistantList", assistantList);
    		String kechengid = request.getParameter("kechengid");
    		String agers=request.getParameter("agers");
    		Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));
    		String classname = kecheng.getClassname();
    		studentList = mgr.getStudentListByClassname(classname);	
    		request.setAttribute("studentList", studentList);
    		request.setAttribute("kechengid", kechengid);
    		request.setAttribute("agers", agers);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toKaoqin";
    }
	
	public String doKaoqin(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String checkbox[] = request.getParameterValues("check_box1");
    		User user = (User) request.getSession().getAttribute("tuser");
    		String kechengid = request.getParameter("kechengid");
    		Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));
    		System.out.println(kecheng.getSubjectname());
    		Subject subject = mgr.getSubjectByName(kecheng.getSubjectname());
    		TClass cal = mgr.getClassByName(kecheng.getClassname());
    		
    		if(null != checkbox && checkbox.length > 0){ //迟到
    			for(int i = 0; i < checkbox.length; i++){
    				Absence absence = new Absence();
    				Date now = new Date();
    				absence.setAbsencedate(now);
    				absence.setClassid(cal.getId());
    				absence.setSid(checkbox[i]);
    				Student student = (Student) mgr.getStudentList(checkbox[i]).get(0);
    				absence.setStudentname(student.getName());
    				absence.setSubjectid(subject.getId());
    				absence.setSubjectname(kecheng.getSubjectname());
    				absence.setTeachername(kecheng.getTeacher());
    				absence.setType(1);
    				this.combiz.save(absence);
    			}
    		}
    		
    		String checkbox2[] = request.getParameterValues("check_box2");//缺席旷课
    		if(null != checkbox2 && checkbox2.length > 0){
    			for(int i = 0; i < checkbox2.length; i++){
    				Absence absence = new Absence();
    				Date now = new Date();
    				absence.setAbsencedate(now);
    				absence.setClassid(cal.getId());
    				absence.setSid(checkbox2[i]);
    				Student student = (Student) mgr.getStudentList(checkbox2[i]).get(0);
    				absence.setStudentname(student.getName());
    				absence.setSubjectid(subject.getId());
    				absence.setSubjectname(kecheng.getSubjectname());
    				absence.setTeachername(kecheng.getTeacher());
    				absence.setType(2);
    				this.combiz.save(absence);
    			}
    		}
    		String checkbox3[] = request.getParameterValues("check_box3");//早退
    		if(null != checkbox3 && checkbox3.length > 0){
    			for(int i = 0; i < checkbox3.length; i++){
    				Absence absence = new Absence();
    				Date now = new Date();
    				absence.setAbsencedate(now);
    				absence.setClassid(cal.getId());
    				absence.setSid(checkbox3[i]);
    				Student student = (Student) mgr.getStudentList(checkbox3[i]).get(0);
    				absence.setStudentname(student.getName());
    				absence.setSubjectid(subject.getId());
    				absence.setSubjectname(kecheng.getSubjectname());
    				absence.setTeachername(kecheng.getTeacher());
    				absence.setType(4);
    				this.combiz.save(absence);
    			}
    		}
    		if(user.getUserType()==6){
    			String checkbox4[]=request.getParameterValues("check_box4");
    			if(null!=checkbox4 && checkbox4.length>0){
    				for(int i=0;i<checkbox4.length;i++){
    					Absence absence = new Absence();
        				Date now = new Date();
        				absence.setAbsencedate(now);
        				absence.setClassid(cal.getId());
        				absence.setSid(checkbox4[i]);
        				Student student = (Student) mgr.getStudentList(checkbox4[i]).get(0);
        				absence.setStudentname(student.getName());
        				absence.setSubjectid(subject.getId());
        				absence.setSubjectname(kecheng.getSubjectname());
        				absence.setTeachername(kecheng.getTeacher());
        				absence.setType(3);
        				this.combiz.save(absence);
    				}
    			}
    		}
    		
    		String classname = kecheng.getClassname();
    		studentList = mgr.getStudentListByClassname(classname);
    		
    		request.setAttribute("studentList", studentList);
    		request.setAttribute("kechengid", kechengid);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doKaoqin";
    }
	
	
	public String dobelate(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String checkbox[] = request.getParameterValues("checkbox1");
    		User user = (User) request.getSession().getAttribute("tuser");
    		
    		String kechengid = request.getParameter("kechengid");
    		
    		Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));
    		
    		Subject subject = mgr.getSubjectByName(kecheng.getSubjectname());
    		
    		TClass cal = mgr.getClassByName(kecheng.getClassname());
    		//String studentid = request.getParameter("studentid");
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    		if(null != checkbox && checkbox.length > 0){
    			for(int i = 0; i < checkbox.length; i++){
    				Absence absence = new Absence();
    				Date now = new Date();
    				absence.setAbsencedate(now);
    				absence.setClassid(cal.getId());
    				absence.setSid(checkbox[i]);
    				Student student = (Student) mgr.getStudentList(checkbox[i]).get(0);
    				absence.setStudentname(student.getName());
    				absence.setSubjectid(subject.getId());
    				absence.setSubjectname(kecheng.getSubjectname());
    				absence.setTeachername(kecheng.getTeacher());
    				absence.setType(1);
    				this.combiz.save(absence);
    			}
    		}
    		//String kechengid = request.getParameter("kechengid");
    		//Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));
    		String classname = kecheng.getClassname();
    		studentList = mgr.getStudentListByClassname(classname);
    		
    		request.setAttribute("studentList", studentList);
    		request.setAttribute("kechengid", kechengid);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "dobelate";
    }
	
	public String doabsence(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String checkbox[] = request.getParameterValues("checkbox1");
    		User user = (User) request.getSession().getAttribute("tuser");
    		//String studentid = request.getParameter("studentid");
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    		
            String kechengid = request.getParameter("kechengid");
    		Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));
    		TClass cal = mgr.getClassByName(kecheng.getClassname());
    		Subject subject = mgr.getSubjectByName(kecheng.getSubjectname());
    		//String studentid = request.getParameter("studentid");
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    		if(null != checkbox && checkbox.length > 0){
    			for(int i = 0; i < checkbox.length; i++){
    				Absence absence = new Absence();
    				Date now = new Date();
    				absence.setAbsencedate(now);
    				absence.setClassid(cal.getId());
    				absence.setSid(checkbox[i]);
    				Student student = (Student) mgr.getStudentList(checkbox[i]).get(0);
    				absence.setStudentname(student.getName());
    				absence.setSubjectid(subject.getId());
    				absence.setSubjectname(kecheng.getSubjectname());
    				absence.setTeachername(kecheng.getTeacher());
    				absence.setType(2);
    				this.combiz.save(absence);
    			}
    		}
    		
    		String classname = kecheng.getClassname();
    		studentList = mgr.getStudentListByClassname(classname);
    		
    		request.setAttribute("studentList", studentList);
    		request.setAttribute("kechengid", kechengid);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doabsence";
    }
	
	
	public String toRewardPunishList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			Student student = new Student();
			List rewardList = new ArrayList();
			if (user.getUserType() == 5) {
				rewardList = mgr.getRewardList();
			}
			List punishList = new ArrayList();
			if (user.getUserType() == 5) {
				punishList = mgr.getPunishList();
			}
			request.setAttribute("rewardList", rewardList);
			request.setAttribute("punishList", punishList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toRewardPunishList";
    }
	
	public String toPunishAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toPunishAdd";
    }
	
	public String doPunishAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String sid = request.getParameter("sid");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String reason = request.getParameter("reason");
            try {	
    			name = (name != null)?new String(name.getBytes("iso-8859-1"),"utf-8"):name;
    			sid = (sid != null)?new String(sid.getBytes("iso-8859-1"),"utf-8"):sid;
    			title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
    			reason = (reason != null)?new String(reason.getBytes("iso-8859-1"),"utf-8"):reason;
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			
			Punish punish = new Punish();
			punish.setSid(sid);
			punish.setName(name);
			punish.setTitle(title);
			punish.setReason(reason);
			Date now = new Date();
			punish.setPdate(now);
			this.combiz.save(punish);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doPunishAdd";
    }
	
	public String toPunishEdit(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String punishid = request.getParameter("punishid");
			Punish punish = (Punish) this.combiz.get(Punish.class, Integer.valueOf(punishid));
			request.setAttribute("punish", punish);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toPunishEdit";
    }
	
	public String doPunishUpdate(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String punishid = request.getParameter("punishid");
			Punish punish = (Punish) this.combiz.get(Punish.class, Integer.valueOf(punishid));
			
			String sid = request.getParameter("sid");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String reason = request.getParameter("reason");
            try {	
    			name = (name != null)?new String(name.getBytes("iso-8859-1"),"utf-8"):name;
    			sid = (sid != null)?new String(sid.getBytes("iso-8859-1"),"utf-8"):sid;
    			title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
    			reason = (reason != null)?new String(reason.getBytes("iso-8859-1"),"utf-8"):reason;
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

			punish.setSid(sid);
			punish.setName(name);
			punish.setTitle(title);
			punish.setReason(reason);
			Date now = new Date();
			punish.setPdate(now);
			this.combiz.update(punish);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doPunishUpdate";
    }
	
	public String deletePunish(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String punishid = request.getParameter("punishid");
			Punish punish = (Punish) this.combiz.get(Punish.class, Integer.valueOf(punishid));
			this.combiz.delete(punish);	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "deletePunish";
    }
	
	public String toRewardAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toRewardAdd";
    }
	
	public String doRewardAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String sid = request.getParameter("sid");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String reason = request.getParameter("reason");
            try {	
    			name = (name != null)?new String(name.getBytes("iso-8859-1"),"utf-8"):name;
    			sid = (sid != null)?new String(sid.getBytes("iso-8859-1"),"utf-8"):sid;
    			title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
    			reason = (reason != null)?new String(reason.getBytes("iso-8859-1"),"utf-8"):reason;
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			
			Reward reward = new Reward();
			reward.setSid(sid);
			reward.setName(name);
			reward.setTitle(title);
			reward.setReason(reason);
			Date now = new Date();
			reward.setRdate(now);
			this.combiz.save(reward);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doRewardAdd";
    }
	
	public String toRewardEdit(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String rewardid = request.getParameter("rewardid");
			Reward reward = (Reward) this.combiz.get(Reward.class, Integer.valueOf(rewardid));
			request.setAttribute("reward", reward);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toRewardEdit";
    }
	
	public String doRewardUpdate(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String rewardid = request.getParameter("rewardid");
			Reward reward = (Reward) this.combiz.get(Reward.class, Integer.valueOf(rewardid));
			String sid = request.getParameter("sid");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String reason = request.getParameter("reason");
            try {	
    			name = (name != null)?new String(name.getBytes("iso-8859-1"),"utf-8"):name;
    			sid = (sid != null)?new String(sid.getBytes("iso-8859-1"),"utf-8"):sid;
    			title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
    			reason = (reason != null)?new String(reason.getBytes("iso-8859-1"),"utf-8"):reason;
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			
			//Reward reward = new Reward();
			reward.setSid(sid);
			reward.setName(name);
			reward.setTitle(title);
			reward.setReason(reason);
			Date now = new Date();
			reward.setRdate(now);
			this.combiz.update(reward);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doRewardUpdate";
    }
	
	public String deleteReward(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String rewardid = request.getParameter("rewardid");
			Reward reward = (Reward) this.combiz.get(Reward.class, Integer.valueOf(rewardid));
			this.combiz.delete(reward);	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "deleteReward";
    }
	
	public String cancelPunish(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String punishid = request.getParameter("punishid");
			Punish punish = (Punish) this.combiz.get(Punish.class, Integer.valueOf(punishid));
			Date now = new Date();
			punish.setCanceldate(now);
			punish.setIscancel(true);
			this.combiz.update(punish);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "cancelPunish";
    }
	
	public String importReward(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		errorLine = new StringBuffer("");
		if (upload == null) {
			addActionMessage("请填写好待上传的文件！");
		}
		if (!contentType.equals("application/vnd.ms-excel")) {
			if(contentType.equals("application/octet-stream")){
				addActionMessage("文件正在使用，不能上传！");
			}else{
				addActionMessage("上传文件格式不正确！");
			}
		}
		try {
			if (!parseXslFileReward(upload)) {
				addActionMessage("奖励数据导入失败");
				if (errorLine.length() > 0) {
					
				}
				request.getSession().setAttribute("errorLine", errorLine);
				
			}else{
				addActionMessage("奖励数据导入成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List rewardList = new ArrayList();
			if (user.getUserType() == 5) {
				rewardList = mgr.getRewardList();
			}
			List punishList = new ArrayList();
			if (user.getUserType() == 5) {
				punishList = mgr.getPunishList();
			}
			request.setAttribute("rewardList", rewardList);
			request.setAttribute("punishList", punishList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addActionMessage(errorLine.toString());
		request.setAttribute("kechengList", kechengList);
		return "result";
	}
	
	private boolean parseXslFileReward(File file) {
		try {
			xslParser = new ExcelParser(file);
			Hashtable activeMap = xslParser.getContent(0, 2);
			if (activeMap.isEmpty() || activeMap.size() > 20000) {
				addActionMessage("Excel 中无可用数据或超过最大允许到如导入的限度.");
				return false;
			}
				for (int i = 0; i < activeMap.size(); i++) {
					Vector row = (Vector) activeMap.get("row" + i);
					if (row.get(1).equals(row.get(2)) && row.get(2) == row.get(3)){
						//有些时候在正常数据之后会有很多行中包含不可见字符,但每个单元格中的不可见字符都相同.
						//所以,如果这三个字段值相同,则认为是非正常行开始了,停止执行该循环.
						break;
					}
					Reward reward = new Reward();
					reward.setSid((String) row.get(0));
					reward.setName((String) row.get(1));
					String rewarddate = (String) row.get(2);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try{
						reward.setRdate(df.parse(rewarddate));
					}catch(Exception e){
						errorLine.append("第"+(i+1)+"行日期格式不对，请检查改正后再导入<br/>");
						e.printStackTrace();
					}
					reward.setTitle((String) row.get(3));
					reward.setReason((String) row.get(4));
		    		this.combiz.save(reward);
				}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String importPunish(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		errorLine = new StringBuffer("");
		if (upload1 == null) {
			addActionMessage("请填写好待上传的文件！");
		}
		if (!contentType.equals("application/vnd.ms-excel")) {
			if(contentType.equals("application/octet-stream")){
				//addActionMessage("文件正在使用，不能上传！");
			}else{
				addActionMessage("上传文件格式不正确！");
			}
		}
		try {
			if (!parseXslFilePunish(upload1)) {
				addActionMessage("处分数据导入失败");
				if (errorLine.length() > 0) {
					
				}
				request.getSession().setAttribute("errorLine", errorLine);
				
			}else{
				addActionMessage("处分数据导入成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List rewardList = new ArrayList();
			if (user.getUserType() == 5) {
				rewardList = mgr.getRewardList();
			}
			List punishList = new ArrayList();
			if (user.getUserType() == 5) {
				punishList = mgr.getPunishList();
			}
			request.setAttribute("rewardList", rewardList);
			request.setAttribute("punishList", punishList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addActionMessage(errorLine.toString());
		return "result";
	}
	
	private boolean parseXslFilePunish(File file) {
		try {
			xslParser = new ExcelParser(file);
			Hashtable activeMap = xslParser.getContent(0, 2);
			if (activeMap.isEmpty() || activeMap.size() > 20000) {
				addActionMessage("Excel 中无可用数据或超过最大允许到如导入的限度.");
				return false;
			}
				for (int i = 0; i < activeMap.size(); i++) {
					Vector row = (Vector) activeMap.get("row" + i);
					if (row.get(1).equals(row.get(2)) && row.get(2) == row.get(3)){
						//有些时候在正常数据之后会有很多行中包含不可见字符,但每个单元格中的不可见字符都相同.
						//所以,如果这三个字段值相同,则认为是非正常行开始了,停止执行该循环.
						break;
					}
					Punish punish = new Punish();
					punish.setSid((String) row.get(0));
					punish.setName((String) row.get(1));
					String pdate = (String) row.get(2);
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					try{
						punish.setPdate(df.parse(pdate));
					}catch(Exception e){
						errorLine.append("第"+(i+1)+"行日期格式不对，请检查改正后再导入<br/>");
						e.printStackTrace();
					}
					punish.setTitle((String) row.get(3));
					punish.setReason((String) row.get(4));
		    		this.combiz.save(punish);
				}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String toAssistantIeltsList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
    		User user = (User) request.getSession().getAttribute("tuser");
    		//String studentid = request.getParameter("studentid");
    		String param=request.getParameter("param");
    		if(null!=param&&param.equals("1")){   			
    			request.getSession().removeAttribute("message");
    		}
    		
    		
    		Student student = new Student();
    		List ieltsList = new ArrayList();
    		List ieltsListNew = new ArrayList();
    		if(user.getUserType() == 6){
    			Assistant assistant = mgr.getAssistantByName(user.getUser());
    			classList = mgr.getClassListByAssistantid(assistant.getId());
    			if(null != classList && classList.size() > 0){
    				String classid = "";
    				for(int  i = 0 ; i < classList.size(); i++){
    					TClass cal = (TClass) classList.get(i);
    					classid = classid + cal.getId() + ",";
    				}
    				classid = classid.substring(0, classid.length() - 1);
    				ieltsList = mgr.getIeltsListInClassid(classid);
    			}
    		}
    		if(null != ieltsList && ieltsList.size() >0){
    			for(int i = 0; i < ieltsList.size(); i++){
    				Ielts ielts = (Ielts) ieltsList.get(i);
    				//Student stu = (Student) mgr.getStudentListFromIelts(ielts.getSid()).get(0);
    				List<Student> stu =mgr.getStudentList(ielts.getSid());
    				if(null!=stu&&stu.size()>0){
    					String classname=stu.get(0).getClassname();
    					TClass tcl=mgr.getClassByName(classname);
    					Integer tclid=tcl.getId();
    					Integer ielts_classid=ielts.getClassid();
//    					if(tclid.equals(ielts_classid)){
    						ielts.setStudent(stu.get(0));
    						TClass tclass=(TClass) this.combiz.get(TClass.class, ielts.getClassid());
    						//ielts.setStudent(stu);
    						ielts.setTclass(tclass.getName());
    						ieltsListNew.add(ielts);	
//    					}
    				}
    			}
    			
    		}
    		request.setAttribute("ieltsList", ieltsListNew);
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toAssistantIeltsList";
    }
	
	public String doCheckIelts(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
    	try{
    		User user = (User) request.getSession().getAttribute("tuser");
    		String ieltsid = request.getParameter("ieltsid");
    		Ielts ielts = (Ielts) this.combiz.get(Ielts.class, Integer.valueOf(ieltsid));
    		ielts.setStatus(2);
    		this.combiz.update(ielts);
    		session.setAttribute("message", "审核成功");
    	}catch(Exception e){
    		session.setAttribute("message", "审核失败");
    		e.printStackTrace();
    	}
    	return "doCheckIelts";
    }
	
	public String toStudentListTeacher(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		
    		studentList = new ArrayList();
    		if(user.getUserType() == 7){
    			List list = mgr.getKechengListClassByTeacher(user.getUser());
    			if(null != list && list.size() > 0){
    				for(int i = 0 ; i < list.size(); i++){
    					String classname = (String) list.get(i);
            			List studentListTemp =  mgr.getStudentListByClassname(classname);
            			studentList.addAll(studentListTemp);
    				}
    			}
    		}
    		request.setAttribute("studentList", studentList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentListTeacher";
    }
	
	public String toAdjustKecheng(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String name=user.getUser();
    		//String  kcversions=request.getSession().getAttribute("kcversions");
    			//request.setAttribute("kcversions", kcversions);
    		//classList = mgr.getClassList();
    		//subjectList = mgr.getSubjectList();
    		//kechengClass=mgr.getKechengListClassByTeacher(name);
    		//subjectList=mgr.getKechengListClassByTeacher1(name);
    		//kechengList=mgr.getKengchenglistClassRoom(name);
//    		request.setAttribute("classList", classList);
//    		request.setAttribute("subjectList", subjectList);
//    		request.setAttribute("kechengClass",kechengClass);
//    		request.setAttribute("subjectList", subjectList);
    		
    		
    		
//    		if(kcversions=="" || kcversions==null){
//    			kechengList=mgr.getKechengList(name);
//    			request.setAttribute("sa", 1);
//    		}	
//    	  if(kcversions!=null && kcversions.equals("1")){
//    		 kechengList=mgr.getKechengList(name);
// 			request.setAttribute("sa", 1);
//    	   }
//    	  if(kcversions!=null&& kcversions.equals("2")){
//    		 kechengList = mgr.getSec_KechengList();	
//    		 request.setAttribute("sa", 2);
//    	  }
//    		kechengversionList= mgr.getKechengversionList();
//    		 request.setAttribute("kechengList", kechengList);
//    		request.setAttribute("kechengversionList", kechengversionList);
     			allKechengList=mgr.getAllkechenglist(name);
     			Integer  v_id=(Integer) allKechengList.get(0);
     			List kecheng_List = mgr. getKechengList(name,v_id);
     			List kechengList=new ArrayList();
     			if(kecheng_List!=null && kecheng_List.size()>0){
     				 Kecheng kecheng=null;
     				for(int i=0;i<kecheng_List.size();i++){
     					kecheng=new Kecheng();
     					Object object[]=(Object[])kecheng_List.get(i);
     					kecheng.setClassname((String) object[0]);
     					kecheng.setSubjectname((String) object[1]);
     					kecheng.setClassroom((String) object[2]);
     					kecheng.setId((Integer) object[3]);
     					kechengList.add(kecheng);
     				}
     				
     			}
     		    request.setAttribute("sa", v_id);
     		    request.setAttribute("kechengList", kechengList);
     		    kechengversionList= mgr.getKechengversionList(v_id);
     		    List classrooms = mgr.getAllClassRoom();
     		    request.setAttribute("classrooms", classrooms);
     		    request.setAttribute("kechengversionList", kechengversionList);	
      	 }catch(Exception e){
      		e.printStackTrace();
      	  }
      	 return "toAdjustKecheng";
      }
    
	
	public String toReplaceAdjustKecheng(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String versionid=request.getParameter("versionid");
		User user = (User) request.getSession().getAttribute("tuser");
		String name=user.getUser();
		try {
			//kechengList=mgr.getKechengList(name,Integer.parseInt(versionid));
			List kecheng_List = mgr. getKechengList(name,Integer.parseInt(versionid));
 			List kechengList=new ArrayList();
 			if(kecheng_List!=null && kecheng_List.size()>0){
 				 Kecheng kecheng=null;
 				for(int i=0;i<kecheng_List.size();i++){
 					kecheng=new Kecheng();
 					Object object[]=(Object[])kecheng_List.get(i);
 					kecheng.setClassname((String) object[0]);
 					kecheng.setSubjectname((String) object[1]);
 					kecheng.setClassroom((String) object[2]);
 					kecheng.setId((Integer) object[3]);
 					kechengList.add(kecheng);
 				}
 				
 			}
			response.setContentType("application/json;charset=utf-8");
			PrintWriter outPrintWriter = response.getWriter();
			outPrintWriter.write(JSONArray.toJSONString(kechengList));
			outPrintWriter.flush();
			outPrintWriter.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		
	}
	public String getendtime(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String versionid=request.getParameter("versionid");
		User user = (User) request.getSession().getAttribute("tuser");;
    	String className=request.getParameter("className");
    	String classSubject=request.getParameter("classSubject");
    	String classRoom=request.getParameter("classRoom");
    	String version=request.getParameter("version");
    	String startTime=request.getParameter("startTime");
		String name=user.getUser();
		try {
			Kecheng kecheng = mgr.getKechengByStartime(user.getUser(),className,classSubject,classRoom,startTime,Integer.parseInt(version));
			response.setContentType("application/json;charset=utf-8");
			PrintWriter outPrintWriter = response.getWriter();
			outPrintWriter.write(JSONArray.toJSONString(kecheng));
			outPrintWriter.flush();
			outPrintWriter.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	
	
	
    public String toAdjustKechengcheck(){
    	HttpServletRequest request = ServletActionContext.getRequest();
    	HttpServletResponse response=ServletActionContext.getResponse();
    	String classroomsid=request.getParameter("classroomsid");
    	String className=request.getParameter("className");
    	String classSubject=request.getParameter("classSubject");
    	String classRoom=request.getParameter("classRoom");
    	String kechengid=request.getParameter("kechengid");
    	String version=request.getParameter("version");
    	  try {
    		  User user = (User) request.getSession().getAttribute("tuser");
    		  //kechengList=mgr.getKechengList(name, Integer.parseInt(classroomsid),Integer.parseInt(version));
    		  //List kecheng_List = mgr.getKechengby_subject_class_room(user.getUser(), className, classSubject, classRoom, Integer.parseInt(version));
    		
    		 Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));
    		  
    		 List kechengList=new ArrayList();
    		 if(kecheng!=null){
    			 Kecheng kechengNew=new Kecheng();
    			 //for(int i=0;i<kecheng_List.size();i++){
 				 //Object object[]=(Object[])kecheng_List.get(i);
    			 kechengNew.setStarttime(kecheng.getStarttime());
    			 kechengNew.setEndtime(kecheng.getEndtime());
 				 kechengList.add(kechengNew);
	 				//} 
    		 }

			response.setContentType("application/json;charset=utf-8");
			PrintWriter outPrintWriter = response.getWriter();
			outPrintWriter.write(JSONArray.toJSONString(kechengList));
			outPrintWriter.flush();
			outPrintWriter.close();
		} catch (Exception e) {	
			e.printStackTrace();
		}
    	return null;
    }
	public String doAdjustAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String kcversions=request.getParameter("kcversions");
    		User user = (User) request.getSession().getAttribute("tuser");
    		String classRoom=request.getParameter("classRoom");
    		String classSubject=request.getParameter("classSubject");
    		String className=request.getParameter("className");
    		String starttime = request.getParameter("starttime");
    		String endtime = request.getParameter("endtime");
    		String classnewroom = request.getParameter("classnewroom");
    		String datebefore = request.getParameter("datebefore");
    		String dateafter = request.getParameter("dateafter");
    		String starttimeafter = request.getParameter("starttimeafter");
    		String endtimeafter = request.getParameter("endtimeafter");
    		String reason=request.getParameter("reason");
    		try {
    			classRoom = (classRoom != null)?new String(classRoom.getBytes("iso-8859-1"),"utf-8"):classRoom;
    			classSubject = (classSubject != null)?new String(classSubject.getBytes("iso-8859-1"),"utf-8"):classSubject;
    			className = (className != null)?new String(className.getBytes("iso-8859-1"),"utf-8"):className;
    			classnewroom = (classnewroom != null)?new String(classnewroom.getBytes("iso-8859-1"),"utf-8"):classnewroom;
    			reason = (reason != null)?new String(reason.getBytes("iso-8859-1"),"utf-8"):reason;
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	    String nowResult=dateFormat.format(new Date());
    	    String str=nowResult.substring(0, 4);
    	    String str1=nowResult.substring(5, 7);
    	    String str2=nowResult.substring(8, 10);
    	    String tk=str+str1+str2;
    	    String tknumber="";
    	    JDBCConnection dbcon = new JDBCConnection();
		    int count=dbcon.count();
		    if(count<9){
				tknumber="TK"+tk+"0"+(count+1);	
			  System.out.println("tknumber---"+tknumber);
			}else{
				tknumber="TK"+tk+(count+1);
			}
    	    adjustList=mgr.getAdjustList();
    		Adjust adjust = new Adjust();
    		adjust.setTeachername(user.getUser());
    		adjust.setClassroom(classRoom);
    		adjust.setNewlcassroom(classnewroom);
    		adjust.setClassname(className);
    		adjust.setSubjectname(classSubject);
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    		adjust.setDatebefore(datebefore);
    		adjust.setStarttimebefore(starttime);
    		adjust.setEndtimebefore(endtime);
    		adjust.setDateafter(dateafter);
    		adjust.setStarttimeafter(starttimeafter);
    		adjust.setEndtimeafter(endtimeafter);
    	    adjust.setTknumber(tknumber);
    		adjust.setReason(reason);  		
    		adjust.setStatus(1);
    		adjust.setS_status("等待教务审批");
	        if(null != kcversions && kcversions.equals("1")){
	        	adjust.setV_id(1);
    		}else{
    			adjust.setV_id(Integer.valueOf(kcversions));
    		}
    		this.combiz.save(adjust);
    		classList = mgr.getClassList();
    		subjectList = mgr.getSubjectList();
    		request.setAttribute("classList", classList);
    		request.setAttribute("subjectList", subjectList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doAdjustAdd";
    }
	
	public String toAdjustList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		if(user.getUserType()==2){ //是院长
    			//adjustList = mgr.getAdjustList();
    			adjustList=mgr.getAdjustList(2);
    			request.setAttribute("adjustList", adjustList); 
    		}else{ //是教务主管
    			//adjustList = mgr.getAdjustList();
    			adjustList = mgr.getAdjustList(1);
    			request.setAttribute("adjustList", adjustList); 
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toAdjustList";
    }
	public String lookAdjustList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		Integer roleid=user.getUserType();
		try {
		if(user.getUserType()==7){
			String username=user.getUser();
			String teachername="";
			teacherList = mgr.getTeacherList(username);
			for (Object teach : teacherList) {
				teachername=((Teacher) teach).getName();
				request.setAttribute("teachername", teachername);
			}
		 }
		request.setAttribute("roleid", roleid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "lookAdjustList";
		
	}
	
	public String approveAdjust(){
//    	try{
//    		HttpServletRequest request = ServletActionContext.getRequest();
//    		User user = (User) request.getSession().getAttribute("tuser");
//    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//    		String adjustid = request.getParameter("adjustid");
//    		Adjust adjust = (Adjust) this.combiz.get(Adjust.class, Integer.valueOf(adjustid));
//    		adjust.setStatus(2);//是2教务主管同意
//    		this.combiz.update(adjust);
//    		
//    		Notice noticeClass = new Notice();
//    		noticeClass.setTitle("调课通知");
//    		noticeClass.setContent("你的班级课程: "+adjust.getClassname()+" "+adjust.getSubjectname()+",原计划在"+df.format(adjust.getDatebefore())+" 上课换到"+df.format(adjust.getDateafter())+" "+adjust.getStarttimeafter()+" 上课");
//    		Date now = new Date();
//    		noticeClass.setPublishdate(now);
//    		noticeClass.setPublisherid(1);
//    		TClass cal = mgr.getClassByName(adjust.getClassname());
//    		noticeClass.setClassid(cal.getId());
//    		this.combiz.save(noticeClass);
//    		
//    		Notice noticeTeacher = new Notice();
//    		noticeTeacher.setTitle("调课通知");
//    		noticeTeacher.setContent("你申请的班级课程: "+adjust.getClassname()+" "+adjust.getSubjectname()+",原计划在"+df.format(adjust.getDatebefore())+" 上课换到"+df.format(adjust.getDateafter())+" "+adjust.getStarttimeafter()+" 上课审批通过");
//    		noticeTeacher.setPublishdate(now);
//    		noticeTeacher.setPublisherid(1);
//    		noticeTeacher.setUsername(adjust.getTeachername());
//    		this.combiz.save(noticeTeacher);
//    			
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dataformate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String adjustid = request.getParameter("param");
	    String param1=request.getParameter("param1");
	    String content=request.getParameter("content");
	    content = (content != null)?new String(content.getBytes("iso-8859-1"),"utf-8"):content;
	    Adjust adjust = (Adjust) this.combiz.get(Adjust.class, Integer.valueOf(adjustid));
	    Integer usertype=user.getUserType();
	    Date now = new Date();
	    TClass cal = mgr.getClassByName(adjust.getClassname());
	    if(user.getUserType()==3){//教务主管
		 if(null!=param1 && param1.equals("agree")){
			adjust.setEdureason(content);
			adjust.setStatus(2);//是2教务主管同意
			adjust.setPublishdate(dataformate.format(new Date()));
		    adjust.setS_status("教务主管同意");
    		this.combiz.update(adjust);	
    		/*Notice noticeTeacher = new Notice();
    		noticeTeacher.setTitle("调课通知");
    		noticeTeacher.setContent(adjust.getTeachername()+"申请的班级课程: "+adjust.getClassname()+" "+adjust.getSubjectname()+",原计划在"+adjust.getDatebefore()+" 上课换到"+adjust.getDateafter()+" "+adjust.getStarttimeafter()+" 上课审批通过");
    		noticeTeacher.setClassid(cal.getId());
    		noticeTeacher.setType(5);
    		noticeTeacher.setNoticetype("4");
    		noticeTeacher.setPublishdate(dataformate.format(now));		
    		noticeTeacher.setPublisherid(usertype);
    		noticeTeacher.setUsername(adjust.getTeachername());
    		noticeTeacher.setStatus(1); //教务主管同意
    		this.combiz.save(noticeTeacher);*/
		 }else{
			adjust.setStatus(3);//是3教务主管拒绝
			adjust.setEdureason(content);
			String s_status="教务主管拒绝";
		    adjust.setS_status(s_status);
		    adjust.setPublishdate(dataformate.format(new Date()));
	    	this.combiz.update(adjust);
			Notice notice = new Notice();
			notice.setTitle("调课通知");
			notice.setType(5);
			notice.setClassid(cal.getId());
			notice.setContent(adjust.getTeachername()+"申请的班级课程: "+adjust.getClassname()+" "+adjust.getSubjectname()+",原计划在"+adjust.getDatebefore()+" "+adjust.getStarttimebefore()+" 上课换到"+adjust.getDateafter()+" "+adjust.getStarttimeafter()+" 上课未通过审核");
			notice.setPublishdate(dataformate.format(now));
			notice.setPublisherid(usertype);
			notice.setNoticetype("4");
			notice.setUsername(adjust.getTeachername());
			notice.setStatus(2); //教务主管拒绝
			this.combiz.save(notice);	 
		   }
		}else{
		    if(null!=param1 && param1.equals("agree")){
				adjust.setDeanreason(content);
				adjust.setStatus(4);//4院长同意
				String s_status="申请成功";
			    adjust.setS_status(s_status);
			    adjust.setPublishdate(dataformate.format(new Date()));
	    		this.combiz.update(adjust);	
	    		Notice noticeTeacher = new Notice();
	    		noticeTeacher.setTitle("调课通知");
	    		noticeTeacher.setType(5);
	    		noticeTeacher.setClassid(cal.getId());
	    		noticeTeacher.setContent(adjust.getTeachername()+"申请的班级课程: "+adjust.getClassname()+" "+adjust.getSubjectname()+",原计划在"+adjust.getDatebefore()+" "+adjust.getStarttimebefore()+" 上课换到"+adjust.getDateafter()+" "+adjust.getStarttimeafter()+" 上课审批通过");
	    		noticeTeacher.setPublishdate(dataformate.format(now));
	    		noticeTeacher.setPublisherid(usertype);
	    		noticeTeacher.setNoticetype("4");
	    		noticeTeacher.setUsername(adjust.getTeachername());
	    		noticeTeacher.setStatus(3); //院长同意
	    		this.combiz.save(noticeTeacher);
			 }else{
				adjust.setStatus(5);//5是院长拒绝
				adjust.setDeanreason(content);
				String s_status="院长拒绝";
			    adjust.setS_status(s_status);
			    adjust.setPublishdate(dataformate.format(new Date()));
		    	this.combiz.update(adjust);
				Notice notice = new Notice();
				notice.setTitle("调课通知");
				notice.setType(5);
				notice.setContent(adjust.getTeachername()+"申请的班级课程: "+adjust.getClassname()+" "+adjust.getSubjectname()+",原计划在"+adjust.getDatebefore()+" "+adjust.getStarttimebefore()+" 上课换到"+adjust.getDateafter()+" "+adjust.getStarttimeafter()+" 上课未通过审核");
				notice.setPublishdate(dataformate.format(now));
				notice.setPublisherid(usertype);
				notice.setUsername(adjust.getTeachername());
				notice.setNoticetype("4");
				notice.setClassid(cal.getId());
				notice.setStatus(4);//院长不同意
				this.combiz.save(notice);	 
		   }
	
		 }
		}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "approveAdjust";
    }
	
	/*public String rejectAdjust(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		DateFormat dataformate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String adjustid = request.getParameter("adjustid");
    		Adjust adjust = (Adjust) this.combiz.get(Adjust.class, Integer.valueOf(adjustid));
    		
    		adjust.setStatus(3);
    		adjust.setPublishdate(dataformate.format(new Date()));
    		this.combiz.update(adjust);
    		Notice notice = new Notice();
    		notice.setTitle("调课通知");
    		notice.setContent("你申请的调课: "+adjust.getClassname()+",原计划在"+adjust.getDatebefore()+" 换到"+adjust.getDateafter()+"未通过");
    		Date now = new Date();
    		//notice.setPublishdate(now);
    		notice.setPublishdate(dataformate.format(now));
    		notice.setPublisherid(1);
    		notice.setUsername(adjust.getTeachername());
    		this.combiz.save(notice);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "rejectAdjust";
    }*/
	
	public String toLoggingList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		loggingList = mgr.getLoggingList();
    		request.setAttribute("loggingList", loggingList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toLoggingList";
    }
	
	public String toAllStudentList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		studentList = mgr.getStudentList();
    		request.setAttribute("studentList", studentList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toAllStudentList";
    }
	
	public String toTeacherList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		teacherList = mgr.getTeacherList();
    		request.setAttribute("teacherList", teacherList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toTeacherList";
    }
	
	public String toClassListJiaowu(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		classList = mgr.getClassList();
    		
    		request.setAttribute("classList", classList);

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toClassListJiaowu";
    }
	
	/*public String toClassListJiaowu(){
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			List<String> classnamelist=mgr.getClassnameList();
			request.setAttribute("classnamelist", classnamelist);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "toClassListJiaowu";
	}*/
	
	
	/*public String toStudentListLiuji(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String classname = request.getParameter("classname");
    		classname=(null!=classname)?new String(classname.getBytes("iso-8859-1"),"utf-8"):classname;
    		List studentList=mgr.getStudentListByClassname(classname);
    		request.setAttribute("studentList", studentList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentListLiuji";
    }*/
	
	
	public String doLiuji(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String sidarray[] = request.getParameterValues("checkbox1");
    		String classname = request.getParameter("liujiclassname");
    		String jzx = request.getParameter("jzx");
    		for(int i = 0; i < sidarray.length; i++){
    			Student student = (Student) mgr.getStudentList(sidarray[i]).get(0);
    			HistoryStudent historyStudent = new HistoryStudent();
    			BeanUtils.copyProperties(student, historyStudent );
    			//BeanUtils.copyProperties(historyStudent, student );
    			//historyStudent.setId(null);
    	
    			HistoryStudent historyStudent1 = null;
    			historyStudent1 = (HistoryStudent) this.combiz.get(HistoryStudent.class, Integer.valueOf(student.getId()));
    			if(null == historyStudent1){
    				this.combiz.save(historyStudent);
    			}
    			
    			student.setDividestatus(1);
    			this.combiz.update(student);
    		    Student stu=new Student();
    		    stu.setSid(student.getSid());
    		    stu.setName(student.getName());
    		    stu.setEmail(student.getEmail());
    		    stu.setCellphone(student.getCellphone());
    		    stu.setJzfid(student.getJzfid());
    		    stu.setJzfname(student.getJzfname());
    		    stu.setIdcard(student.getIdcard());
    		    stu.setJzfcellphone(student.getJzfcellphone());
    		    stu.setSex(student.getSex());
    		    stu.setPyxing(student.getPyxing());
    		    stu.setPyname(student.getPyname());
    		    stu.setSCN(student.getSCN());
    		    stu.setBirthday(student.getBirthday());
    		    stu.setProgram(student.getProgram());
    		    stu.setJzmid(student.getJzmid());
    		    stu.setJzmname(student.getJzmname());
    		    stu.setJzmcellphone(student.getJzmcellphone());
    		    stu.setAssistant(student.getAssistant());
    		    stu.setMajorname(student.getMajorname());
    		    stu.setGrade(student.getGrade());
    		    stu.setStatus(student.getStatus());
    		    stu.setClassname(classname);
    		    this.combiz.save(stu);
    			Jzletter jzletter = new Jzletter();
    			jzletter.setTitle(classname);
    			jzletter.setContent(jzx);
    			jzletter.setSid(sidarray[i]);
    			Date now = new Date();
    			jzletter.setSendtime(now);
    			this.combiz.save(jzletter);
    		}
    		
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doLiuji";
    }
	
	public String toKebiao(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		List<Kechengversion> kechengVersionList=mgr.getKechengversionList(1);//获取所有有效版本
    		if(user.getUserType()==6){//辅导员
    			Assistant assistant=mgr.getAssistantByName(user.getUser());
    			List<TClass> tclassList=mgr.getClassListByAssistantid(assistant.getId());
    			List kebiaoList = new ArrayList();
    			if(null!=kechengVersionList&&kechengVersionList.size()>0){    				
    				kebiaoList=findFudaoyuanKebiaoList(kechengVersionList,assistant.getName());
    				request.setAttribute("versionId", kechengVersionList.get(0).getId());
    			}
    			request.setAttribute("kebiao", 1);
    			request.setAttribute("tclassList", tclassList);
    			request.setAttribute("classId", tclassList.get(0).getId());
    			request.setAttribute("kechengVersionList", kechengVersionList);
    			request.setAttribute("kebiaoList", kebiaoList);
    			return "toKebiaoFudaoyuan";
    			
    		}
    		
    		if(user.getUserType()==7){//老师
    			
    			Teacher teacher=mgr.getTeacherByName(user.getUser());
    			List kebiaoList = new ArrayList();
    			if(null!=kechengVersionList&&kechengVersionList.size()>0){    				
    				kebiaoList=findTeacherKebiaoList(kechengVersionList,teacher);
    				request.setAttribute("versionId", kechengVersionList.get(0).getId());
    			} 			
    			request.setAttribute("kebiaoList", kebiaoList);
    			request.setAttribute("kechengVersionList", kechengVersionList);
    			return "toKebiaoTeacher";
    			
    		}
    		
    		if(user.getUserType()==8){//学生
    			
    			Student student = (Student) mgr.getStudentList(user.getUser()).get(0);
        		String classname = student.getClassname();
        		List kebiaoList = new ArrayList();
        		if(null!=kechengVersionList&&kechengVersionList.size()>0){    				
    				kebiaoList=findStudentKebiaoList(kechengVersionList,classname);
    				request.setAttribute("versionId", kechengVersionList.get(0).getId());
    			} 
	    		request.setAttribute("kebiaoList", kebiaoList);
	    		request.setAttribute("kechengVersionList", kechengVersionList);
	    		return "toKebiao";
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public List findStudentKebiaoList(List<Kechengversion> kechengVersion,String classname){
		try {
			List kebiaoList = new ArrayList();
			for(int i = 1; i <= 5; i++){
    			List cellList = new ArrayList();
    			for(int j = 1; j <= 5; j++){
    				Jieke jieke = new Jieke();
    				jieke.setLessonid(i);
    				jieke.setWeekdayid(j);
    				String fromtime = "8:00";
    				if(i == 1){
    					fromtime = "8:00";
    				}else if(i == 2){
    					fromtime = "10:00";
    				}else if(i == 3){
    					fromtime = "13:20";
    				}else if(i == 4){
    					fromtime = "15:10";
    				}else if(i == 5){
    					fromtime = "18:00";
    				}
    				
    				String weekday = "Monday";
    				DateHandle dh = new DateHandle();
    				String date = dh.getCurrentFriday();
    				if(j == 1){
    					weekday = "Monday";
    					date = dh.getCurrentMonday();
    				}else if(j == 2){
    					weekday = "Tuesday";
    					date = dh.getCurrentTuesday();
    				}else if(j == 3){
    					weekday = "Wednesday";
    					date = dh.getCurrentWednesday();
    				}else if(j == 4){
    					weekday = "Thursday";
    					date = dh.getCurrentThursday();
    				}else if(j == 5){
    					date = dh.getCurrentFriday();
    					weekday = "Friday";
    				}
    				List adjustList = mgr.getAdjustListNew(classname, date, fromtime,kechengVersion.get(0).getId());
    				
    				
    				Kecheng kecheng = mgr.getKechengjiekeNew(classname, fromtime, weekday,kechengVersion.get(0).getId());
    				if(null != adjustList && adjustList.size() > 0){
    					kecheng = null;
    				}
    				List adjustListAfter = mgr.getAdjustListAfterNew(classname, date, fromtime,kechengVersion.get(0).getId());
    				if(null != adjustListAfter && adjustListAfter.size() > 0){
    					Adjust adjust = (Adjust) adjustListAfter.get(0);
    					kecheng = new Kecheng();
    					kecheng.setClassname(adjust.getClassname());
    					kecheng.setSubjectname(adjust.getSubjectname());
    					kecheng.setTeacher(adjust.getTeachername());
    					kecheng.setWeekday(weekday);
    					kecheng.setStarttime(adjust.getStarttimeafter());
    					kecheng.setEndtime(adjust.getEndtimeafter());
    				}
    				cellList.add(kecheng);
    			}
    			kebiaoList.add(cellList);
    		}
			return kebiaoList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List findFudaoyuanKebiaoList(List<Kechengversion> kechengVersion,String assistantName){
		try{
		List kebiaoList = new ArrayList();
		for(int i = 1; i <= 5; i++){
			List cellList = new ArrayList();
			for(int j = 1; j <= 5; j++){
				Jieke jieke = new Jieke();
				jieke.setLessonid(i);
				jieke.setWeekdayid(j);
				String fromtime = "8:00";
				if(i == 1){
					fromtime = "8:00";
				}else if(i == 2){
					fromtime = "10:00";
				}else if(i == 3){
					fromtime = "13:20";
				}else if(i == 4){
					fromtime = "15:10";
				}else if(i == 5){
					fromtime = "18:00";
				}
				
				String weekday = "Monday";
				DateHandle dh = new DateHandle();
				String date = dh.getCurrentFriday();
				if(j == 1){
					weekday = "Monday";
					date = dh.getCurrentMonday();
				}else if(j == 2){
					weekday = "Tuesday";
					date = dh.getCurrentTuesday();
				}else if(j == 3){
					weekday = "Wednesday";
					date = dh.getCurrentWednesday();
				}else if(j == 4){
					weekday = "Thursday";
					date = dh.getCurrentThursday();
				}else if(j == 5){
					date = dh.getCurrentFriday();
					weekday = "Friday";
				}
				List adjustList = mgr.getAdjustList(assistantName, date, fromtime,kechengVersion.get(0).getId());
				
				
				Kecheng kecheng = mgr.getKechengjieke(assistantName, fromtime, weekday,kechengVersion.get(0).getId());
				if(null != adjustList && adjustList.size() > 0){
					kecheng = null;
				}
				List adjustListAfter = mgr.getAdjustListAfter(assistantName, date, fromtime,kechengVersion.get(0).getId());
				if(null != adjustListAfter && adjustListAfter.size() > 0){
					Adjust adjust = (Adjust) adjustListAfter.get(0);
					kecheng = new Kecheng();
					kecheng.setClassname(adjust.getClassname());
					kecheng.setSubjectname(adjust.getSubjectname());
					kecheng.setTeacher(adjust.getTeachername());
					kecheng.setWeekday(weekday);
					kecheng.setStarttime(adjust.getStarttimeafter());
					kecheng.setEndtime(adjust.getEndtimeafter());
				}
				cellList.add(kecheng);
			}
			kebiaoList.add(cellList);
		}
		return kebiaoList;
		
		}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
	}
	
	public List findTeacherKebiaoList(List<Kechengversion> kechengVersion,Teacher teacher){
		List kebiaoList = new ArrayList();
		try {
				if(null!=kechengVersion&&kechengVersion.size()>0){
    				for(int i = 1; i <= 5; i++){
    	    			List cellList = new ArrayList();
    	    			for(int j = 1; j <= 5; j++){
    	    				Jieke jieke = new Jieke();
    	    				jieke.setLessonid(i);
    	    				jieke.setWeekdayid(j);
    	    				String fromtime = "8:00";
    	    				if(i == 1){
    	    					fromtime = "8:00";
    	    				}else if(i == 2){
    	    					fromtime = "10:00";
    	    				}else if(i == 3){
    	    					fromtime = "13:20";
    	    				}else if(i == 4){
    	    					fromtime = "15:10";
    	    				}else if(i == 5){
    	    					fromtime = "18:00";
    	    				}
    	    				
    	    				String weekday = "Monday";
    	    				DateHandle dh = new DateHandle();
    	    				String date = dh.getCurrentFriday();
    	    				if(j == 1){
    	    					weekday = "Monday";
    	    					date = dh.getCurrentMonday();
    	    				}else if(j == 2){
    	    					weekday = "Tuesday";
    	    					date = dh.getCurrentTuesday();
    	    				}else if(j == 3){
    	    					weekday = "Wednesday";
    	    					date = dh.getCurrentWednesday();
    	    				}else if(j == 4){
    	    					weekday = "Thursday";
    	    					date = dh.getCurrentThursday();
    	    				}else if(j == 5){
    	    					date = dh.getCurrentFriday();
    	    					weekday = "Friday";
    	    				}
    	    				List adjustList = mgr.getAdjustList(teacher.getName(), date, fromtime,kechengVersion.get(0).getId());   	    				    	    				
    	    				Kecheng kecheng = mgr.getKechengjieke(teacher.getName(),fromtime,weekday,kechengVersion.get(0).getId());
    	    				if(null != adjustList && adjustList.size() > 0){
    	    					kecheng = null;
    	    				}   	    				
    	    				List adjustListAfter = mgr.getAdjustListAfter(teacher.getName(), date, fromtime,kechengVersion.get(0).getId());
    	    				if(null != adjustListAfter && adjustListAfter.size() > 0){
    	    					Adjust adjust = (Adjust) adjustListAfter.get(0);
    	    					kecheng = new Kecheng();
    	    					kecheng.setClassname(adjust.getClassname());
    	    					kecheng.setSubjectname(adjust.getSubjectname());
    	    					kecheng.setTeacher(adjust.getTeachername());
    	    					kecheng.setWeekday(weekday);
    	    					kecheng.setStarttime(adjust.getStarttimeafter());
    	    					kecheng.setEndtime(adjust.getEndtimeafter());
    	    				}
    	    				cellList.add(kecheng);
    	    			}
    	    			kebiaoList.add(cellList);
    	    		}
				}
		} catch (Exception e) {

		}
		return kebiaoList;
	}
	
	public String doDelayInput(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    			String examid = request.getParameter("examid");
    			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(examid));
    			
    			String enteringupdatedate = request.getParameter("enteringupdatedate");
    			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    			/*Date enteringupdatedateD = df.parse(enteringupdatedate);
    			
    			exam.setUpdateenddate(enteringupdatedateD);
    			this.combiz.update(exam);*/
    			String reason = request.getParameter("reason");
    			
    			EnterApply enterApply = new EnterApply();
    			enterApply.setExamid(exam.getId());
    			enterApply.setUsername(user.getUser());
    			enterApply.setReason(reason);
    			Date now = new Date();
    			enterApply.setApplytime(df.format(now));
    			enterApply.setUpdatedate(enteringupdatedate);
    			enterApply.setStatus(0);
    			this.combiz.save(enterApply);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return "doDelayInput";
    }
	
	public String toDelayList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		//String prompt=request.getParameter("prompt");
    		//System.out.println("prompt----"+prompt);
    		//if(prompt!=null && !prompt.equals("") && prompt.equals("1")){
    		  //  addActionError("无法匹配对应的老师,发送成绩延时通知失败!");
    		//}
    		delayList = mgr.getDelayList();
    		List delayListNew = new ArrayList();
    		for(int i = 0; i < delayList.size(); i++){
    			EnterApply ea = (EnterApply) delayList.get(i);
    			Exam exam = (Exam) this.combiz.get(Exam.class, ea.getExamid());
    			Subject subject = (Subject) this.combiz.get(Subject.class, exam.getSubjectid());
    			exam.setSubjectname(subject.getName());
    			TClass cla = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
    			if(null == cla){
    				exam.setClassname("");
    			}else{
    				exam.setClassname(cla.getName());
    			}
    			
    			ea.setExam(exam);
    			delayListNew.add(ea);
    		}
    		request.setAttribute("delayList", delayListNew);
    		if(user.getUserType()==2){
    			return "toDelayList";
    		}else{
    			return "toDelayListJiaowu";
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public String approveDelay(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    		String delayid = request.getParameter("delayid");
    		String content = request.getParameter("content");
    		String updatedate = request.getParameter("enteringupdatedate");
    		content = (content != null)?new String(content.getBytes("iso-8859-1"),"utf-8"):content;
    		EnterApply ea = (EnterApply) this.combiz.get(EnterApply.class, Integer.valueOf(delayid));
    		if(user.getUserType()==3||user.getUserType()==4){
    		ea.setStatus(2);
    		ea.setAdvice(content);
    		}
    		else if(user.getUserType()==2){
    		ea.setStatus(1);
    		if(null!=updatedate&&!updatedate.equals("")){   			
    			ea.setUpdatedate(updatedate);
    		}
    		/*通知*/
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Exam exam = (Exam) this.combiz.get(Exam.class, ea.getExamid());
    		DifferentPhase phase=new DifferentPhase();
			String examTypeName="";
			String scoreTypeName="";
			 	if(exam.getScoretype()==1){//百分制   				
 				examTypeName=phase.getExamType(exam.getExamtype());
 				scoreTypeName="百分制";              				
 				}
            if(exam.getScoretype()==2){//非百分制   				
        	   	examTypeName=phase.getExamType(exam.getExamtype());
				scoreTypeName="非百分制";;              				
  				}
            if(exam.getScoretype()==3){//记分单元 				
        	   	examTypeName=phase.getExamType(exam.getExamtype());
				scoreTypeName="记分单元";              				
 				}
	    
            Subject subject=(Subject) this.combiz.get(Subject.class, exam.getSubjectid());
			TClass tclass=(TClass) this.combiz.get(TClass.class, exam.getClasskey());
			Teacher teacher=mgr.getTeacherByTid(exam.getTeacherid());
			String teacher_name="";
			if(null !=teacher){
				teacher_name=teacher.getName();
			}
			String totalteachername="";
            List<String> teacherlist=mgr.getKechengByclassnamesubjectname(subject.getName(),tclass.getName());
            for(String teachername:teacherlist){
            	totalteachername+=teachername+",";
            }
		     Notice notice_=null;
		    for (String str : teacherlist) {
		    	 if(teacher_name.equals(str)){
		    		 continue;
		    	 }
		      }
		  //  if(!totalteachername.equals("")){
		       if(!totalteachername.equals("")){   
		    	   totalteachername=totalteachername.substring(0,totalteachername.length()-1)+","+teacher_name;   	
		       }else{
		    	   totalteachername=teacher_name;
		       }
		    	//String totalname=totalteachername+teacher_name;
		    	notice_ = new Notice();
		    	notice_.setType(5);
		    	notice_.setTitle("成绩延时通知");
		    	notice_.setContent("用户："+user.getUser()+"同意了"+subject.getName()+scoreTypeName+examTypeName+"的录入成绩延长时间,理由:"+content);
		    	notice_.setClassid(tclass.getId());
		    	notice_.setPublishdate(sdf.format(new Date()));
		    	notice_.setUsername(totalteachername);
		    	notice_.setStatus(3);
		    	this.combiz.save(notice_);
		 /*   }else{
		    	 prompt="1";
		    	 request.setAttribute("prompt", prompt);	
		    	 return "approveDelay";

		    }*/
		    	
/*		    if(!totalteachername.equals("")){
		    	totalteachername=totalteachername.substring(0,totalteachername.length()-1)+","+teacher_name;   	
		    	String totalname=totalteachername+teacher_name;
		    	notice_ = new Notice();
		    	notice_.setType(5);
		    	notice_.setTitle("成绩延时通知");
		    	notice_.setContent("用户："+user.getUser()+"同意了"+subject.getName()+scoreTypeName+examTypeName+"的录入成绩延长时间,理由:"+content);
		    	notice_.setClassid(tclass.getId());
		    	notice_.setPublishdate(sdf.format(new Date()));
		    	notice_.setUsername(totalteachername);
		    	notice_.setStatus(3);
		    	this.combiz.save(notice_);
		    }else{
		    	prompt="1";
		    	request.setAttribute("prompt", prompt);	
		    	return "approveDelay";
		    	
		    }
*/		    	 
		    	 
		    }
    		this.combiz.update(ea);
    		String enteringupdatedate = ea.getUpdatedate();
    		Date enteringupdatedateD = df.parse(enteringupdatedate);
			Exam exam = (Exam) this.combiz.get(Exam.class, Integer.valueOf(ea.getExamid()));
			exam.setUpdateenddate(enteringupdatedateD);
			this.combiz.update(exam);	
	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "approveDelay";
    }
	
	public String toExampjList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		exampjList = mgr.getExampjList();
    		request.setAttribute("exampjList", exampjList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExampjList";
    }
	
	public String toExampjAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		teacherList = mgr.getTeacherList();
    		subjectList = mgr.getSubjectList();
    		classList = mgr.getClassList();
    		
    		request.setAttribute("teacherList", teacherList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("classList", classList);
    		//request.setAttribute("exampjList", exampjList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toExampjAdd";
    }
	
	public String doExampjAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		
    		String title = request.getParameter("title");
    		String teachername = request.getParameter("teachername");
    		String classname = request.getParameter("classname");
    		String subjectname = request.getParameter("subjectname");
    		
    		try {	
    			title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
    			teachername = (teachername != null)?new String(teachername.getBytes("iso-8859-1"),"utf-8"):teachername;
    			classname = (classname != null)?new String(classname.getBytes("iso-8859-1"),"utf-8"):classname;
    			subjectname = (subjectname != null)?new String(subjectname.getBytes("iso-8859-1"),"utf-8"):subjectname;
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		Exampj exampj = new Exampj();
    		exampj.setTitle(title);
    		exampj.setTeachername(teachername);
    		exampj.setClassname(classname);
    		exampj.setSubjectname(subjectname);
    		exampj.setIsopen(1);
    		this.combiz.save(exampj);
    		
    		
    		request.setAttribute("teacherList", teacherList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("classList", classList);
    		//request.setAttribute("exampjList", exampjList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doExampjAdd";
    }
	
	public String openScore(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		
    		String exampjid = request.getParameter("exampjid");
    		Exampj exampj = (Exampj) this.combiz.get(Exampj.class, Integer.valueOf(exampjid));
    		exampj.setIsopen(2);
    		this.combiz.update(exampj);
    		//request.setAttribute("exampjList", exampjList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "openScore";
    }
	
	public String closeScore(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		
    		String exampjid = request.getParameter("exampjid");
    		Exampj exampj = (Exampj) this.combiz.get(Exampj.class, Integer.valueOf(exampjid));
    		exampj.setIsopen(1);
    		this.combiz.update(exampj);
    		//request.setAttribute("exampjList", exampjList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "closeScore";
    }
	
	public String toMyExampjList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		Student student = (Student) mgr.getStudentList(user.getUser()).get(0);
    		exampjList = mgr.getMyExampjList(student.getClassname());
    		request.setAttribute("exampjList", exampjList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toMyExampjList";
    }
	
	public String toDistributeClass(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toDistributeClass";
    }
	
	public String distributeClass(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		errorLine = new StringBuffer("");
		if (upload == null) {
			addActionMessage("请填写好待上传的文件！");
		}
		if (!contentType.equals("application/vnd.ms-excel")) {
			if(contentType.equals("application/octet-stream")){
				//addActionMessage("文件正在使用，不能上传！");
			}else{
				addActionMessage("上传文件格式不正确！");
			}
		}
		try {
			if (!parseDistributeClass(upload)) {
				addActionMessage("大一升大二分班学生入失败");
				if (errorLine.length() > 0) {
					
				}
				request.getSession().setAttribute("errorLine", errorLine);
				
			}else{
				addActionMessage("大一升大二分班学生导入成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		addActionMessage(errorLine.toString());
		return "result";
	}
	
	private boolean parseDistributeClass(File file) {
		try {
			xslParser = new ExcelParser(file);
			Hashtable activeMap = xslParser.getContent(0, 2);
			if (activeMap.isEmpty() || activeMap.size() > 20000) {
				addActionMessage("Excel 中无可用数据或超过最大允许到如导入的限度.");
				return false;
			}
				for (int i = 0; i < activeMap.size(); i++) {
					Vector row = (Vector) activeMap.get("row" + i);
					if (row.get(1).equals(row.get(2)) && row.get(2) == row.get(3)){
						//有些时候在正常数据之后会有很多行中包含不可见字符,但每个单元格中的不可见字符都相同.
						//所以,如果这三个字段值相同,则认为是非正常行开始了,停止执行该循环.
						break;
					}
					String sid = (String) row.get(0);
					HistoryStudent historyStudent = new HistoryStudent();
					List studentList = mgr.getStudentList(sid);
					if(null != studentList && studentList.size() > 0){
						Student student = new Student();
						student = (Student) studentList.get(0);
						BeanUtils.copyProperties(student, historyStudent);
						//this.combiz.saveOrupate(historyStudent);
						this.combiz.save(historyStudent);
						student.setClassname((String) row.get(2));
						student.setProgram((String) row.get(3));
						student.setMajorname((String) row.get(4));
						student.setSCN((String) row.get(5));
						this.combiz.update(student);
					}else{
						errorLine.append("第"+(i+1)+"行学号为"+sid+"的学生不存在，请检查改正后再导入<br/>");
					}
				}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public String toFbClassListJiaowu(){
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			classList = mgr.getClassList();
			
			request.setAttribute("classList", classList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "toFbClassListJiaowu";
	}
	
	
	public void selectassistantname(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {
			PrintWriter out=response.getWriter();
			String selectname=request.getParameter("selectname");
			TClass tclass=mgr.getClassByName(selectname);
			Integer assistantid=tclass.getAssistantid();
			Assistant assistant=(Assistant) this.combiz.get(Assistant.class, assistantid);
			String assistantname=assistant.getName();
			if(assistantname!=null){
				out.write(JSONArray.toJSONString(assistant));
			}else{
				out.print(false);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String toStudentListLiuji(){
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String classid = request.getParameter("classid");
			TClass cal = (TClass) this.combiz.get(TClass.class, Integer.valueOf(classid));
			studentList = mgr.getStudentListByClassname_(cal.getName());
			request.setAttribute("studentList", studentList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "toStudentListLiuji";
	}
	public String fbToStudentListLiuji(){
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			String classid = request.getParameter("classid");
			TClass cal = (TClass) this.combiz.get(TClass.class, Integer.valueOf(classid));
			//studentList = mgr.getStudentListByClassname(cal.getName());
			studentList = mgr.getStudentListByClassname_(cal.getName());
            //classList = mgr.getClassList();
            List classlist= mgr.getClassListexceptById(Integer.parseInt(classid));
			request.setAttribute("classlist", classlist);
			request.setAttribute("studentList", studentList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "fbToStudentListLiuji";
	}
	public String updatestudenttclas(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String studentid=request.getParameter("studentid");
		String selectclassname=request.getParameter("selectclassname");
		String assistnant=request.getParameter("assistantname");
		String[] studentids=studentid.split(",");
		for(int i=0;i<studentids.length;i++){                        
			Student student=(Student) this.combiz.get(Student.class, Integer.valueOf(studentids[i]));
			student.setDividestatus(1);
			this.combiz.update(student);
			Student stu=new Student();
 		    stu.setSid(student.getSid());
 		    stu.setName(student.getName());
 		    stu.setEmail(student.getEmail());
 		    stu.setCellphone(student.getCellphone());
 		    stu.setJzfid(student.getJzfid());
 		    stu.setJzfname(student.getJzfname());
 		    stu.setIdcard(student.getIdcard());
 		    stu.setJzfcellphone(student.getJzfcellphone());
 		    stu.setSex(student.getSex());
 		    stu.setPyxing(student.getPyxing());
 		    stu.setPyname(student.getPyname());
 		    stu.setSCN(student.getSCN());
 		    stu.setBirthday(student.getBirthday());
 		    stu.setProgram(student.getProgram());
 		    stu.setJzmid(student.getJzmid());
 		    stu.setJzmname(student.getJzmname());
 		    stu.setJzmcellphone(student.getJzmcellphone());
 		    stu.setMajorname(student.getMajorname());
 		    stu.setGrade(student.getGrade());
 		    stu.setStatus(student.getStatus());
 		    stu.setAssistant(assistnant);
 		    stu.setDividestatus(0);
 		    stu.setClassname(selectclassname);
 		    this.combiz.save(stu);
		}
		return "updatestudenttclas";
		
	}
	
	public String toCheckScoreList(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("tuser");
			Teacher teacher=mgr.getTeacherByName(user.getUser());
			DifferentPhase phase=new DifferentPhase();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<Exam> examList=mgr.getExamByNeishenyuanId(teacher.getTid());
			if(null!=examList&&examList.size()>0){
				for (Exam exam : examList) {
					TClass tclass = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
	    			exam.setClassname(tclass.getName());
	    			Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(exam.getSubjectid()));
	    			exam.setSubjectname(subject.getName());
	    			exam.setTime(sdf.format(exam.getEdate()));
						if(exam.getScoretype()==1){//百分制   				
							exam.setScoreTypeName("百分制");
							exam.setExamTypeName("正考");              				
						}
						if(exam.getScoretype()==2){//非百分制   				
							String examTypeName=phase.getExamType(exam.getExamtype());
							exam.setScoreTypeName("非百分制");
							exam.setExamTypeName(examTypeName);              				
						}
						if(exam.getScoretype()==3){//记分单元 				
							String examTypeName=phase.getExamType(exam.getExamtype());
							exam.setScoreTypeName("记分单元 ");
							exam.setExamTypeName(examTypeName);              				
						}
						if(exam.getScoretype()==4){//记分单元 				
							String examTypeName=phase.getExamType(exam.getExamtype());
							exam.setScoreTypeName("非百分制1.4 ");
							exam.setExamTypeName(examTypeName);              				
						}
				}
			}
			request.setAttribute("examList", examList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toCheckScoreList";
	}
	
	public String toCheckScore(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			String examid=request.getParameter("examid");
			Exam exam=(Exam) this.combiz.get(Exam.class, Integer.parseInt(examid));
			Teacher teacher = mgr.getTeacherByTid(exam.getTeacherid());
			Teacher neishenyuan = mgr.getTeacherByTid(exam.getNeishenyuanid());
			exam.setTeachername(teacher.getName());
			exam.setNeishenyuanname(neishenyuan.getName());
			TClass tclass = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
			exam.setClassname(tclass.getName());
			Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(exam.getSubjectid()));
			exam.setSubjectname(subject.getName());
			DifferentPhase phase=new DifferentPhase();  			   			
			if(exam.getScoretype()==1){//百分制   				
  				exam.setScoreTypeName("百分制");
  				exam.setExamTypeName("正考");
  				}
            if(exam.getScoretype()==2){//非百分制   
   				String examTypeName=phase.getExamType(exam.getExamtype());
   				exam.setScoreTypeName("非百分制");
   				exam.setExamTypeName(examTypeName);
   				}
            if(exam.getScoretype()==3){//记分单元 
  				String examTypeName=phase.getExamType(exam.getExamtype());
  				exam.setScoreTypeName("记分单元 ");
  				exam.setExamTypeName(examTypeName);
  				}
			List<Student> studentList = null;
			
			/*****
			 * 而实际要参加考试的学生只能在score_new 表中通过考试科目subjectid， 考试阶段phaseid， 班级classkey, examtype=1
			 * 得到原来已经参加这次考试的学生， 
			 * 这里需要判断下， 如果这个班级 这个科目 这个阶段考试以前没有过考试， 就从学生表中拉取需要参加此次考试的学生， 
			 * 如果这个班级 这个科目 这个阶段以前有过考试， 这个班级 科目 阶段的正考考试的学生就要参加考试
			 *********确定要参加考试学生代码段BEGIN*********/
			JDBCConnection jdbccon = new JDBCConnection();
			Connection con = jdbccon.openConnection();
			Statement sm = con.createStatement();
			String sql = "select * from score_new where subjectid="+exam.getSubjectid()+
			" and classkey = "+exam.getClasskey()+ " and phaseid = "+exam.getPhaseid()+" and examtype = 1";
			ResultSet rs = sm.executeQuery(sql);
			if(rs.next()){
				rs.previous(); 
				studentList = new ArrayList();
				while(rs.next()){
					String sid = rs.getString("sid");
					Student student = mgr.getStudentBySid(sid);
					studentList.add(student);
				}
			}else{
				//需要参加考试的学生是通过学生表student中的班级名称得来的
				studentList = mgr.getStudentListByClassname(tclass.getName());  
			}
			con.close();
			/**********确定要参加考试学生代码段END*********/
			
			
			for (Student student : studentList) {				
				List<ScoreNew> currentScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),exam.getExamtype()); 
				if(null!=currentScoreList&&currentScoreList.size()>0){
					ScoreNew score=currentScoreList.get(0);
					if(exam.getScoretype()==3&&(exam.getExamtype()==1||exam.getExamtype()==3)){
						String result=score.getResult();
						if(null!=result){
							result=result.replaceAll("\\s*", "");
						}
						String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
						if(null!=result&&!result.equals("")&&result.matches(regex)){
						  double a=Double.parseDouble(result);
						   if(a>=70){
							   result="A";
						   }
						   else if(a>=60&&a<=69){
							   result="B";
						   }
						   else if(a>=50&&a<=59){
							   result="C";
						   }
						   else{
							   result="F";
						   }
						   student.setTempzk(result);
						}
					}
					else if(exam.getScoretype()==3&&(exam.getExamtype()==7||exam.getExamtype()==9)){
						String result=score.getResult();
						if(null!=result){
							result=result.replaceAll("\\s*", "");
						}
						String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
						if(null!=result&&!result.equals("")&&result.matches(regex)){
						  double a=Double.parseDouble(result);
						  if(a>=50){
							   result="C";
						   }									  
						   else{
							   result="F";
						   }
						   student.setTempzk(result);
						}
					}
					student.setTempResult(score.getResult());
				}
			}
			request.setAttribute("exam", exam);
			request.setAttribute("studentList", studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toCheckScore";
	}
	
	public String returnScore(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			String examid=request.getParameter("examid");
			Exam exam=(Exam) this.combiz.get(Exam.class, Integer.parseInt(examid));
			Teacher teacher=mgr.getTeacherByTid(exam.getTeacherid());
			User user = (User) request.getSession().getAttribute("tuser");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			exam.setDisplaystatus(1);
			this.combiz.update(exam);
    		DifferentPhase phase=new DifferentPhase();
			String examTypeName="";
			String scoreTypeName="";
			 	if(exam.getScoretype()==1){//百分制   				
 				examTypeName=phase.getExamType(exam.getExamtype());
 				scoreTypeName="百分制";              				
 				}
            if(exam.getScoretype()==2){//非百分制   				
        	   	examTypeName=phase.getExamType(exam.getExamtype());
				scoreTypeName="非百分制";;              				
  				}
            if(exam.getScoretype()==3){//记分单元 				
        	   	examTypeName=phase.getExamType(exam.getExamtype());
				scoreTypeName="记分单元";              				
 				}
	    
            Subject subject=(Subject) this.combiz.get(Subject.class, exam.getSubjectid());
			TClass tclass = (TClass) this.combiz.get(TClass.class, exam.getClasskey());
			List<Student> studentList = null;


			/*****
			 * 而实际要参加考试的学生只能在score_new 表中通过考试科目subjectid， 考试阶段phaseid， 班级classkey, examtype=1
			 * 得到原来已经参加这次考试的学生， 
			 * 这里需要判断下， 如果这个班级 这个科目 这个阶段考试以前没有过考试， 就从学生表中拉取需要参加此次考试的学生， 
			 * 如果这个班级 这个科目 这个阶段以前有过考试， 这个班级 科目 阶段的正考考试的学生就要参加考试
			 *********确定要参加考试学生代码段BEGIN*********/
			JDBCConnection jdbccon = new JDBCConnection();
			Connection con = jdbccon.openConnection();
			Statement sm = con.createStatement();
			String sql = "select * from score_new where subjectid="+exam.getSubjectid()+
			" and classkey = "+exam.getClasskey()+ " and phaseid = "+exam.getPhaseid()+" and examtype = 1";
			ResultSet rs = sm.executeQuery(sql);
			if(rs.next()){
				rs.previous(); 
				studentList = new ArrayList();
				while(rs.next()){
					String sid = rs.getString("sid");
					Student student = mgr.getStudentBySid(sid);
					studentList.add(student);
				}
			}else{
				//需要参加考试的学生是通过学生表student中的班级名称得来的
				studentList = mgr.getStudentListByClassname(tclass.getName());  
			}
			con.close();
			/**********确定要参加考试学生代码段END*********/
			
			
			for (Student student : studentList) {				
				List<ScoreNew> currentScoreList=mgr.getScore(student.getSid(), exam.getSubjectid(), exam.getPhaseid(),exam.getExamtype()); 
				if(null!=currentScoreList&&currentScoreList.size()>0){
					ScoreNew score=currentScoreList.get(0);
					score.setButtonstatus(null);
					this.combiz.update(score);
				}
				
			}
			 Notice notice_ = new Notice();
	    	 notice_.setType(5);
	    	 notice_.setTitle("成绩退回通知");
	    	 notice_.setContent("用户："+user.getUser()+"退回了"+subject.getName()+scoreTypeName+examTypeName+"的录入成绩");
	    	 notice_.setPublishdate(sdf.format(new Date()));
	    	 notice_.setUsername(teacher.getName());
	    	 notice_.setStatus(3);
	    	 this.combiz.save(notice_);
	    	 Logging log=new Logging();
	    	 log.setUsername(teacher.getName());
	    	 log.setUsertype(user.getUserType());
	    	 log.setContent("用户："+user.getUser()+"退回了"+subject.getName()+scoreTypeName+examTypeName+"的录入成绩");
	    	 log.setOpertime(new Date());
	    	 this.combiz.save(log);
			
		} catch (Exception e) {
			
		}
		return "returnScore";
	}
	
	
	public String submitScore(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String examid=request.getParameter("examid");
		Exam exam=(Exam) this.combiz.get(Exam.class, Integer.parseInt(examid));
		exam.setDisplaystatus(3);
		this.combiz.update(exam);
		return "submitScore";
	}
	
	public String getLever(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			PrintWriter out=response.getWriter();
			String examid=request.getParameter("examid");
			String result=request.getParameter("result");
			Exam exam=(Exam) this.combiz.get(Exam.class, Integer.parseInt(examid));
			if(exam.getScoretype()==3&&(exam.getExamtype()==1||exam.getExamtype()==3)){
				  double a=Double.parseDouble(result);
				   if(a>=70){
					   result="A";
				   }
				   else if(a>=60&&a<=69){
					   result="B";
				   }
				   else if(a>=50&&a<=59){
					   result="C";
				   }
				   else{
					   result="F";
				   }				
			}
			else if(exam.getScoretype()==3&&(exam.getExamtype()==7||exam.getExamtype()==9)){
				  double a=Double.parseDouble(result);
				  if(a>=50){
					   result="C";
				   }									  
				   else{
					   result="F";
				   }				
			}
			
			out.print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

















