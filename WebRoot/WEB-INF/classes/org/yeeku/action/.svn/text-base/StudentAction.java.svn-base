package org.yeeku.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.yeeku.JDBCConnection;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Absence;
import org.yeeku.model.Advice;
import org.yeeku.model.Assistant;
import org.yeeku.model.DifferentPhase;
import org.yeeku.model.EnterApply;
import org.yeeku.model.Exam;
import org.yeeku.model.Ielts;
import org.yeeku.model.Kecheng;
import org.yeeku.model.Logging;
import org.yeeku.model.Notice;
import org.yeeku.model.Score;
import org.yeeku.model.ScoreNew;
import org.yeeku.model.Student;
import org.yeeku.model.Subject;
import org.yeeku.model.TClass;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;
import org.yeeku.test.TestGetPost;

import com.alibaba.fastjson.JSONArray;

public class StudentAction extends BaseAction{
	
	private List noticeList;
	private List classList;
	private List assistantList;
	private List teacherList;
	private List kechengList;
	private List subjectList;
	private List<TClass> tclassList;
	private List<Student> studentList;
	private List<Absence> absenceList;
	private String absenceid;
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAbsenceid() {
		return absenceid;
	}

	public void setAbsenceid(String absenceid) {
		this.absenceid = absenceid;
	}

	public List getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List noticeList) {
		this.noticeList = noticeList;
	}

	public List getClassList() {
		return classList;
	}

	public void setClassList(List classList) {
		this.classList = classList;
	}

	public List getAssistantList() {
		return assistantList;
	}

	public void setAssistantList(List assistantList) {
		this.assistantList = assistantList;
	}

	public List getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List teacherList) {
		this.teacherList = teacherList;
	}

	public List<TClass> getTclassList() {
		return tclassList;
	}

	public void setTclassList(List<TClass> tclassList) {
		this.tclassList = tclassList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List getKechengList() {
		return kechengList;
	}

	public void setKechengList(List kechengList) {
		this.kechengList = kechengList;
	}

	public List<Absence> getAbsenceList() {
		return absenceList;
	}

	public void setAbsenceList(List<Absence> absenceList) {
		this.absenceList = absenceList;
	}	
	public List getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List subjectList) {
		this.subjectList = subjectList;
	}

	public String toNoticeList(){
    	/*try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		if(user.getUserType() == 3 || user.getUserType() == 4 || user.getUserType() == 5){
    			noticeList = mgr.getNoticeList();
    		}
    		
    		if(user.getUserType() == 8){
    			String username = user.getUser();
    			List stuList = mgr.getStudentList(username);
    			if(null != stuList && stuList.size() > 0){
    				Student stu = (Student) stuList.get(0);
    				String classid = stu.getClassid();
    				if(null == classid){
    					String classname = stu.getClassname();
    					TClass cla = mgr.getClassByName(classname);
        				noticeList = mgr.getNoticeListByClassid(cla.getId());
    					
    				}else{
    					Integer classidI = Integer.valueOf(stu.getClassid());
        				noticeList = mgr.getNoticeListByClassid(classidI);
    				}
    				
    			}
    		}
    		
    		if(user.getUserType() == 6){
			Integer userid = user.getId();
    		//Integer usertype=user.getUserType();
			noticeList = mgr.getNoticeListByPublisherid(userid);
			
			Assistant assistant = mgr.getAssistantByName(user.getUser());
			classList = mgr.getClassListByAssistantid(assistant.getId());
			if (null != classList && classList.size() > 0) {
					for (int i = 0; i < classList.size(); i++) {
						TClass cal = (TClass) classList.get(i);
						List tmp = mgr.getNoticeListByClassid(cal.getId());
						noticeList.addAll(tmp);
					}
				}
			}
			
    		request.setAttribute("noticeList", noticeList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}*/
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		Integer roleid=user.getId();
		String username=user.getUser();
		request.setAttribute("roleid", roleid);
		request.setAttribute("username", username);
    	return "toNoticeList";
    }
	
	public String toStudentInfo(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
    		User user = (User) request.getSession().getAttribute("tuser");
    		//String studentid = request.getParameter("studentid");
    		Student student = new Student();
    		
    		if(user.getUserType() == 8){
    			String studentid = user.getUser();
    			if(null != studentid && !studentid.equals("")){	
    				List stuList = mgr.getStudentList(studentid);
    				if(null != stuList && stuList.size() > 0){
    					student = (Student) stuList.get(0);
    				}
        		}
    		}
    		request.setAttribute("student", student);
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentInfo";
    }
	
	public String toStudentScore(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
    		User user = (User) request.getSession().getAttribute("tuser");
    		//String studentid = request.getParameter("studentid");
    		Student student = new Student();
    		List scoreList = new ArrayList();
    		List scoreListNew = new ArrayList();
    		if(user.getUserType() == 8){
    			String studentid = user.getUser();
    			if(null != studentid && !studentid.equals("")){	
    				scoreList = mgr.getStudentScoreList(studentid);
        		}
    		}
    		for(int i = 0; i < scoreList.size(); i++){
    			ScoreNew score = (ScoreNew) scoreList.get(i);
    			String result=score.getResult();
    			Integer scoretype=score.getScoretype();
    			String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";
    			if(null!=result && !result.equals("") && result.matches(regex)){
    				if(!scoretype.equals(1)){
    					double num = Double.valueOf(result);
    					if(num>=70){
    						score.setResult_("A");
    					}else if(num>=60){
    						score.setResult_("B");
    					}else if(num>=50){
    						score.setResult_("C");
    					}else{
    						score.setResult_("F");
    					}	
    				}else{
    					score.setResult_(result);	
    				}
    			}else if(null!=result && !result.equals("") && !result.matches(regex)){
    				result=result.split("-")[0];
    				score.setResult_(result);	
    			}else{
    				continue;
    			}

    			Subject subject = (Subject) this.combiz.get(Subject.class, score.getSubjectid());
    			score.setSubjectname(subject.getName());
    			scoreListNew.add(score);
		
    		}
    		request.setAttribute("scoreList", scoreListNew);
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentScore";
    }
	
	public String toStudentAbsence(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
    		User user = (User) request.getSession().getAttribute("tuser");
    		//String studentid = request.getParameter("studentid");
    		Student student = new Student();
    		List absenceList = new ArrayList();
    		List absenceListNew = new ArrayList();
    		if(user.getUserType() == 8){
    			String studentid = user.getUser();
    			if(null != studentid && !studentid.equals("")){	
    				absenceList = mgr.getStudentAbsenceList(studentid);
        		}
    		}
    		for(int i = 0; i < absenceList.size(); i++){
    			Absence absence = (Absence) absenceList.get(i);
    			Subject subject = (Subject) this.combiz.get(Subject.class, absence.getSubjectid());
    			List temp = mgr.getStudentList(absence.getSid());
				if(null != temp && temp.size() > 0){
					Student student1 = (Student) temp.get(0);
					absence.setStudentname(student1.getName());
				}
    			absence.setSubjectname(subject.getName());
    			absenceListNew.add(absence);
    			
    		}
    		request.setAttribute("absenceList", absenceListNew);
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentAbsence";
    }
	
	public String toStudentjc(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
    		User user = (User) request.getSession().getAttribute("tuser");
    		//String studentid = request.getParameter("studentid");
    		Student student = new Student();
    		List rewardList = new ArrayList();
    		

    		if(user.getUserType() == 8){
    			String studentid = user.getUser();
    			if(null != studentid && !studentid.equals("")){	
    				rewardList = mgr.getStudentRewardList(studentid);
        		}
    		}
    		
    		List punishList = new ArrayList();
    		
    		if(user.getUserType() == 8){
    			String studentid = user.getUser();
    			if(null != studentid && !studentid.equals("")){	
    				punishList = mgr.getStudentPunishList(studentid);
        		}
    		}
    		
    		request.setAttribute("rewardList", rewardList);
    		request.setAttribute("punishList", punishList);
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentjc";
    }
	
	public String toStudentIeltsList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//classList = mgr.getClassList();
    		//assistantList = mgr.getAssistantList();
    		User user = (User) request.getSession().getAttribute("tuser");
    		//String studentid = request.getParameter("studentid");
    		Student student = new Student();
    		List ieltsList = new ArrayList();
    		if(user.getUserType() == 8){
    			String studentid = user.getUser();
    			if(null != studentid && !studentid.equals("")){	
    				ieltsList = mgr.getStudentIeltsList(studentid);
        		}
    		}
    		request.setAttribute("ieltsList", ieltsList);
    		//request.setAttribute("classList", classList);
    		//request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentIeltsList";
    }
	
	public String toStudentIeltsAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toStudentIeltsAdd";
    }
	
	public String doStudentIeltsAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		
    		String listening = request.getParameter("listening");
    		String speaking = request.getParameter("speaking");
    		String reading = request.getParameter("reading");
    		String writing = request.getParameter("writing");
    		String total = request.getParameter("total");
    		String account = request.getParameter("account");
    		String password = request.getParameter("password");
    		
    		Ielts ielts = new Ielts();
    		ielts.setListening(listening);
    		ielts.setSpeaking(speaking);
    		ielts.setReading(reading);
    		ielts.setWriting(writing);
    		ielts.setTotal(total);
    		ielts.setStatus(1);
    		ielts.setAccount(account);
    		ielts.setPassword(password);
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Date now = new Date();
    		//String createdate = df.format(now);
    		ielts.setCreatedate(now);
    		
    		User user = (User) request.getSession().getAttribute("tuser");
    		if(user.getUserType() == 8){
    			//Student student =mgr.getStudentList(user.getUser()).get(0);
        		List<Student> studentlist=mgr.getStudentList(user.getUser());
    			Student student=studentlist.get(0);
    			String classname = student.getClassname();
    			TClass cal = mgr.getClassByName(classname);
    			ielts.setSid(user.getUser());
    			ielts.setClassid(cal.getId());
    		}
    		this.combiz.save(ielts);
    		
    		addActionMessage("上传雅思成绩成功");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doStudentIeltsAdd";
    }
	
	public String checkAdviceInfo(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse  response = ServletActionContext.getResponse();
    		//response.setContentType("application/json;charset=utf-8");
    		response.setContentType("text/html;charset=utf-8");
    		PrintWriter out=response.getWriter();
    		String adviceId=request.getParameter("id");
    		String from=request.getParameter("from");
    		Advice curradvice=(Advice) this.combiz.get(Advice.class, Integer.parseInt(adviceId));
    		if(curradvice.getStatus()==2){
    			out.print("false:意见已发送,无法操作");
    		}else{
    			if(from.equals("alter")){
    				curradvice.setStatus(3);
    				this.combiz.update(curradvice);
    			}
    			out.print(curradvice.getContent());
    		}
    		out.flush();
    		out.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public String revokeAdviceInfo(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String adviceId=request.getParameter("id");
    		Advice curradvice=(Advice) this.combiz.get(Advice.class, Integer.parseInt(adviceId));
    		curradvice.setStatus(3);
    		this.combiz.update(curradvice);
    		User user = (User) request.getSession().getAttribute("tuser");
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		List<Advice> adviceList=mgr.getAdviceByUser(user.getUser());
    		if(null!=adviceList&&adviceList.size()>0){   			
    			for (Advice advice : adviceList) {
    				String content=advice.getContent();
    				if(content.length()>54){
    					advice.setContent(content.substring(0, 54)+"...");
    				}
    			}
    		}
    		request.setAttribute("adviceList", adviceList);
    		addActionMessage("撤回成功");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "revokeAdviceInfo";
    }
	
	public String toAdviceAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		List<Advice> adviceList=new ArrayList<Advice>();
    		if(user.getUserType()==9){
    			return "toAdviceBangongshi";
    		}else{ 			
    			adviceList=mgr.getAdviceByUser(user.getUser());
    			if(null!=adviceList&&adviceList.size()>0){   			
    				for (Advice advice : adviceList) {
    					String content=advice.getContent();
    					if(content.length()>54){
    						advice.setContent(content.substring(0,54)+"...");
    					}
    				}
    			}
    			request.setAttribute("adviceList", adviceList);
    			return "toAdviceAdd";
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public String doAdviceAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		String content = request.getParameter("content");
    		String hiddenId=request.getParameter("hiddenid");
            try {
            	content = (content != null)?new String(content.getBytes("iso-8859-1"),"utf-8"):content;
    		} catch (UnsupportedEncodingException e) {
    			e.printStackTrace();
    		}
    		if(null!=hiddenId&&!hiddenId.equals("")){
    			Advice advice=(Advice) this.combiz.get(Advice.class, Integer.parseInt(hiddenId));
    			advice.setContent(content);
    			advice.setStatus(1);
    			this.combiz.update(advice);
    		}else{    			
    			Advice advice = new Advice();
    			advice.setContent(content);
    			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			Date now = new Date();
    			advice.setCreatedate(df.format(now));   			
    			user = (User) request.getSession().getAttribute("tuser");
    			advice.setUsername(user.getUser());
    			advice.setStatus(1);
    			this.combiz.save(advice);
    		}   		
    		addActionMessage("提交意见建议成功");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doAdviceAdd";
    }
	
	public String toMyNoticeList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    			//Integer userid = user.getId();
    			String username=user.getUser();
    			 Integer roleid=user.getUserType();
    			Integer usertype=user.getUserType();
    			if(usertype==3 || usertype==4){
    			 noticeList = mgr.getNoticeListByPublisheridStatus("1",username);
    			}
    		    if(usertype==5||usertype==6){
    		     noticeList = mgr.getNoticeListByPublisheridStatus("2",username);	
    		    }
    		    if(usertype==7){
    		     noticeList = mgr.getNoticeListByPublisheridStatus("3",username);	
    		    }
    		    if(noticeList!=null && noticeList.size()>0){
   				 for(int i=0;i<noticeList.size();i++){
   					 Notice notice=(Notice) noticeList.get(i);
   					 Integer classid=notice.getClassid();
   					 if(!classid.equals(0)){
   						 TClass tclass=(TClass) this.combiz.get(TClass.class, classid);
   						 notice.setClassname(tclass.getName());
   						 
   					 }
   				 }
   			 }
    		request.setAttribute("noticeList", noticeList);
    		request.setAttribute("username", username);
    		request.setAttribute("roleid", roleid);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toMyNoticeList";
    }

	public String toNoticeAdd(){
//    	try{
//    		HttpServletRequest request = ServletActionContext.getRequest();
//    		User user = (User) request.getSession().getAttribute("tuser");
//    		Assistant assistant = mgr.getAssistantByName(user.getUser());
//    		if(null != assistant){
//    			Integer assistantid = assistant.getId();
//        		classList = mgr.getClassListByAssistantid(assistantid);
//    		}
//    		request.setAttribute("classList", classList);
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
//    	return "toNoticeAdd";
		//try {
   try {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		String username=user.getUser();
		if(user.getUserType()==3 ||user.getUserType()==4||user.getUserType()==5){
			classList=mgr.getClassList();
			teacherList=mgr.getTeacherList();
			assistantList=mgr.getAssistantList();
		}
		List list =new ArrayList();
		if(user.getUserType()==6){
			/*studentList=mgr.getStudentListByassistant(username);
			String classname1=null;
			for(Student student:studentList){
				 String classname=student.getClassname();
				if(classname.equals(classname1)){
					continue;
				}
				if(classname!=null){
					classname1=classname;
				}
				TClass tclass=mgr.getClassByName(classname);
				Integer id=tclass.getId();
				String name=tclass.getName();
				TClass tclass1=new TClass();
				tclass1.setId(id);
				tclass1.setName(name);
				list.add(tclass1);
				
			}*/
			String name =user.getUser();
		   Assistant assistant= mgr.getAssistantByName(name);
		   Integer assistantid=assistant.getId();
		   tclassList=mgr.getClassByAssistantid(assistantid);
		}
		if(user.getUserType()==7){
			kechengList=mgr.getKechengListClassByTeacher1(username); 
			if(kechengList!=null && kechengList.size()>0){
				for(int i=0;i<kechengList.size();i++){
				Object object[]=(Object[])kechengList.get(i);
				TClass tclass=mgr.getClassByName((String) object[0]);
				if(null!=tclass){
					Integer id=tclass.getId();
					String name=tclass.getName();
					TClass tclass1=new TClass();
					tclass1.setId(id);
					tclass1.setName(name);
					list.add(tclass1);	
				}
			
			}	
		 }
		}
			request.setAttribute("assistantList", assistantList);
			request.setAttribute("tclassList", tclassList);
			request.setAttribute("classList", classList);
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("list", list);
		/*for(Object tclass:classList){
			assistantid=((TClass)tclass).getAssistantid();
			assistantList=mgr.getAssistantList(assistantid);
			for(int i=0;i< assistantList.size();i++){
				Assistant assistant=(Assistant) assistantList.get(i);	
				System.out.println(assistant.getName());
				List<TClass> tclassList=mgr.getClassByAssistantid(assistant.getId());
				for (TClass tClass2 : tclassList) {
					assistant.getTclasses().add(tClass2);
				}
				list.add(assistantList);
				
			}
		}*/
		
		/*HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		Integer assistantid=null;
		List<Assistant> list=new ArrayList<Assistant>();
		List list1=new ArrayList();
		List list2=new ArrayList();
		classList=mgr.getClassList();
		for(Object tclass:classList){
			assistantid=((TClass)tclass).getAssistantid();
			if(!list1.contains(assistantid)){
				list1.add(assistantid);	
			}else{
				continue;	
			}
			Assistant assistant=mgr.getAssistantById(assistantid);
			String name=assistant.getName();
			Integer id=assistant.getId();
			Assistant assistant1=new Assistant();	
			assistant1.setName(name);
			assistant1.setId(id);
			list.add(assistant1);
		}
			System.out.println(list.size());
			for (Assistant assis : list) {
				List<TClass> tclassList=mgr.getClassByAssistantid(assis.getId());
				if(null!=tclassList&&tclassList.size()>0){
					for (TClass tClass2 : tclassList) {
						assis.getTclasses().add(tClass2);
					}
				}
			}*/
			/*for (Assistant assis : list) {
				System.out.println(assis.getName());
				for (TClass tcl : assis.getTclasses()) {
					System.out.println(tcl.getName());
				}
				System.out.println("-----------------");
			}*/
			/*List<TClass> tclassList=mgr.getClassByAssistantid(id);
			for (TClass tClass2 : tclassList) {
				TClass tclass1=new TClass();
				String classname=tClass2.getName();
				Integer classid=tClass2.getId();
				tclass1.setName(classname);
				tclass1.setId(classid);
				list2.add(tclass1);
				assistant.getTclasses().add(tClass2);
				list2.add(assistant);
			}*/
				
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	return "toNoticeAdd";
    
	}
	@SuppressWarnings("unused")
	public String doNoticeAdd(){
//    	try{
//    		HttpServletRequest request = ServletActionContext.getRequest();
//    		User user = (User) request.getSession().getAttribute("tuser");
//    		String classid = request.getParameter("classid");
//    		String title = request.getParameter("title");
//    		String content = request.getParameter("content");
//    		String classids[] = classid.split(",");
//    		
//    		try {
//    			title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
//            	content = (content != null)?new String(content.getBytes("iso-8859-1"),"utf-8"):content;
//    		} catch (UnsupportedEncodingException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    		}
//    		if(user.getUserType() == 6){
//    			for(int i = 0; i < classids.length; i++){
//        			Notice notice = new Notice();
//        			notice.setClassid(Integer.valueOf(classids[i]));
//        			notice.setContent(content);
//        			notice.setTitle(title);
//        			notice.setType(2);
//        			notice.setPublisherid(user.getId());
//        			Date now = new Date();
//        			notice.setPublishdate(now);
//        			this.combiz.save(notice);
//        		}
//    		}else{
//    			Notice notice = new Notice();
//    			//notice.setClassid(Integer.valueOf(classids[i]));
//    			notice.setContent(content);
//    			notice.setTitle(title);
//    			notice.setType(1);
//    			notice.setPublisherid(user.getId());
//    			Date now = new Date();
//    			notice.setPublishdate(now);
//    			this.combiz.save(notice);
//    		}
//    		
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("tuser");
		String username=user.getUser();
		String checkboxall=request.getParameter("checkboxall");
		String classid = request.getParameter("classid");
		String assistantid=request.getParameter("assistantid");
		//System.out.println("assistantid---"+assistantid);
		String teacherid=request.getParameter("teacherid");
		//System.out.println("teacherid---"+teacherid);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String classids[] = classid.split(",");	
		String assistantids[]=assistantid.split(",");
		String teacherids[]=teacherid.split(",");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 try {
			title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
			content = (content != null)?new String(content.getBytes("iso-8859-1"),"utf-8"):content;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   String s1 = TestGetPost.sendPost("http://test.wesufe.cn/weixin/notify",
				"title='"+title+"'&content='"+content+"'");
        System.out.println(s1);
	    if(checkboxall!=null && checkboxall.equals("1")){
	    	assistantid="";
	    	teacherid="";
	    	classid="";
	    }
		if(checkboxall!="" && checkboxall.equals("1") && assistantid=="" && classid=="" && teacherid==""){//当等于1通知所有人
			Notice notice = new Notice();
			notice.setContent(content);
			notice.setTitle(title);
			notice.setType(1);//通知所有人
			//notice.setPublisherid(user.getId());
			notice.setPublisherid(user.getUserType());
			Date now = new Date();
			notice.setPublishdate(df1.format(now));
			notice.setUsername(username);
			notice.setReadstatus("0");
			notice.setUserid("0");
			notice.setClassid(0);
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice.setNoticetype("2");//辅导员通知
			}
			notice.setStatus(1);
			this.combiz.save(notice);
		}
		if( assistantid!="" && classid!="" && teacherid!="" && checkboxall=="" ){
			Notice notice2 = new Notice();
			notice2.setContent(content);
			notice2.setTitle(title);
			notice2.setType(2);//通知老师的
			//notice2.setPublisherid(user.getId());
			notice2.setPublisherid(user.getUserType());
			Date now2 = new Date();
			notice2.setPublishdate(df1.format(now2));
			notice2.setUserid(teacherid);
			notice2.setUsername(username);
			notice2.setReadstatus("0");
			notice2.setClassid(0);
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice2.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice2.setNoticetype("2");//辅导员通知
			}
			notice2.setStatus(1);
		    this.combiz.save(notice2);
			Notice notice = new Notice();
			notice.setContent(content);
			notice.setTitle(title);
			notice.setType(3);//通知辅导员的
			//notice.setPublisherid(user.getId());
			notice.setPublisherid(user.getUserType());
			Date now = new Date();
			notice.setPublishdate(df1.format(now));
			notice.setUsername(username);
			notice.setUserid(assistantid);
			notice.setClassid(0);
			notice.setReadstatus("0");
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice.setNoticetype("2");//辅导员通知
			}
			notice.setStatus(1);
		    this.combiz.save(notice);
		 for(int i = 0; i < classids.length; i++){
			    Notice notice1 = new Notice();
				notice1.setContent(content);
				notice1.setTitle(title);
				notice1.setType(4);//通知班级的
				//notice1.setPublisherid(user.getId());
				notice1.setPublisherid(user.getUserType());
				Date now1 = new Date();
				notice1.setPublishdate(df1.format(now1));
				notice1.setReadstatus("0");
				notice1.setUsername(username);
				notice1.setUserid("0");
				notice1.setClassid(Integer.valueOf(classids[i]));
				if(user.getUserType()==3 || user.getUserType()==4){
					notice1.setNoticetype("1");//教务通知
				}
				if(user.getUserType()==5){
					notice1.setNoticetype("2");//辅导员通知
				}
				notice1.setStatus(1);
			    this.combiz.save(notice1);
			  }
		  	
		}
		if(assistantid!="" && classid!="" && teacherid=="" && checkboxall=="" ){
			Notice notice = new Notice();
			notice.setContent(content);
			notice.setTitle(title);
			notice.setType(3);//通知辅导员的
			//notice.setPublisherid(user.getId());
			notice.setPublisherid(user.getUserType());
			Date now = new Date();
			notice.setPublishdate(df1.format(now));
			notice.setUsername(username);
			notice.setUserid(assistantid);
			notice.setReadstatus("0");
			notice.setClassid(0);
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice.setNoticetype("2");//辅导员通知
			}
			notice.setStatus(1);
		    this.combiz.save(notice);
		    for(int i = 0; i < classids.length; i++){
		    Notice notice1 = new Notice();
			notice1.setContent(content);
			notice1.setTitle(title);
			notice1.setType(4);//通知班级的
			//notice1.setPublisherid(user.getId());
			notice1.setPublisherid(user.getUserType());
			Date now1 = new Date();
			notice1.setPublishdate(df1.format(now1));
			notice1.setUsername(username);
			notice1.setReadstatus("0");
			notice1.setUserid("0");
			notice1.setClassid(Integer.valueOf(classids[i]));
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice1.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice1.setNoticetype("2");//辅导员通知
			}
			notice1.setStatus(1);
		    this.combiz.save(notice1);
		  }
		}
		if(assistantid!="" && classid=="" && teacherid!="" && checkboxall==""){//通知辅导员
			Notice notice = new Notice();
			notice.setContent(content);
			notice.setTitle(title);
			notice.setType(3);//通知辅导员的
			//notice.setPublisherid(user.getId());
			notice.setPublisherid(user.getUserType());
			Date now = new Date();
			notice.setPublishdate(df1.format(now));
			notice.setUsername(username);
			notice.setUserid(assistantid);
			notice.setClassid(0);
			notice.setReadstatus("0");
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice.setNoticetype("2");//辅导员通知
			}
			notice.setStatus(1);
		    this.combiz.save(notice);
		    Notice notice1 = new Notice();
			notice1.setContent(content);
			notice1.setTitle(title);
			notice1.setType(2);//通知老师的
			//notice1.setPublisherid(user.getId());
			notice1.setPublisherid(user.getUserType());
			Date now1 = new Date();
			notice.setPublishdate(df1.format(now1));
			notice1.setUsername(username);
			notice1.setClassid(0);
			notice1.setReadstatus("0");
			notice1.setUserid(teacherid);
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice1.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice1.setNoticetype("2");//辅导员通知
			}
			notice1.setStatus(1);
		    this.combiz.save(notice1);
		}
        if(assistantid!="" && classid=="" && teacherid=="" && checkboxall==""){//通知辅导员
        	Notice notice = new Notice();
			notice.setContent(content);
			notice.setTitle(title);
			notice.setType(3);//通知辅导员的
			//notice.setPublisherid(user.getId());
			notice.setPublisherid(user.getUserType());
			Date now = new Date();
			notice.setPublishdate(df1.format(now));
			notice.setUsername(username);
			notice.setUserid(assistantid);
			notice.setReadstatus("0");
			notice.setClassid(0);
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5 || user.getUserType()==6){
				notice.setNoticetype("2");//辅导员通知
			}
			notice.setStatus(1);
		    this.combiz.save(notice);	
        } 
		if(classid!="" && assistantid=="" && teacherid!="" && checkboxall==""){
			Notice notice = new Notice();
			notice.setContent(content);
			notice.setTitle(title);
			notice.setType(4);//通知班级的
			//notice.setPublisherid(user.getId());
			notice.setPublisherid(user.getUserType());
			Date now = new Date();
			notice.setPublishdate(df1.format(now));
			notice.setUsername(username);
			//notice.setUserid(teacherid);
			notice.setUserid("0");
			notice.setReadstatus("0");
			notice.setClassid(0);
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice.setNoticetype("2");//辅导员通知
			}
			notice.setStatus(1);
		    this.combiz.save(notice);
		    for(int i = 0; i < classids.length; i++){
			    Notice notice1 = new Notice();
				notice1.setContent(content);
				notice1.setTitle(title);
				notice1.setType(4);//通知班级的
				//notice1.setPublisherid(user.getId());
				notice1.setPublisherid(user.getUserType());
				Date now1 = new Date();
				notice1.setPublishdate(df1.format(now1));
				notice1.setUsername(username);
				notice1.setReadstatus("0");
				notice1.setUserid("0");
				notice1.setClassid(Integer.valueOf(classids[i]));
				if(user.getUserType()==3 ||user.getUserType()==4){
					notice1.setNoticetype("1");//教务通知
				}
				if(user.getUserType()==5 ){
					notice1.setNoticetype("2");//辅导员通知
				}
				notice1.setStatus(1);
			    this.combiz.save(notice1);
			  }
		}
		if(classid!="" && assistantid=="" && teacherid=="" && checkboxall==""){//通知班级及所在的学生
			for(int i = 0; i < classids.length; i++){
			    Notice notice = new Notice();
				notice.setContent(content);
				notice.setTitle(title);
				notice.setType(4);//通知班级的
				//notice.setPublisherid(user.getId());
				notice.setPublisherid(user.getUserType());
				Date now = new Date();
				notice.setPublishdate(df1.format(now));
				notice.setUsername(username);
				notice.setReadstatus("0");
				notice.setUserid("0");
				notice.setClassid(Integer.valueOf(classids[i]));
				if(user.getUserType()==3 ||user.getUserType()==4){
					notice.setNoticetype("1");//教务通知
				}
				if(user.getUserType()==5 ||user.getUserType()==6){
					notice.setNoticetype("2");//辅导员通知
				}
				if(user.getUserType()==7){
					notice.setNoticetype("3");
				}
				notice.setStatus(1);
			    this.combiz.save(notice);
			  }
		}
        if(teacherid!="" && assistantid=="" && classid=="" && checkboxall==""){//通知班级
        	Notice notice = new Notice();
			notice.setContent(content);
			notice.setTitle(title);
			notice.setType(2);//通知老师的
			//notice.setPublisherid(user.getId());
			notice.setPublisherid(user.getUserType());
			Date now = new Date();
			notice.setPublishdate(df1.format(now));
			notice.setUsername(username);
			notice.setUserid(teacherid);
			notice.setReadstatus("0");
			notice.setClassid(0);
			if(user.getUserType()==3 ||user.getUserType()==4){
				notice.setNoticetype("1");//教务通知
			}
			if(user.getUserType()==5){
				notice.setNoticetype("2");//辅导员通知
			}
			notice.setStatus(1);
		    this.combiz.save(notice);	
		}
    	return "doNoticeAdd";
    }

	
	public String findStudentHistoryInformation(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		List<Student> studentList=new ArrayList<Student>();
    		//教务和教务主管可以查看所有学生的历史信息	
			if(user.getUserType()==3||user.getUserType()==4){
				studentList=mgr.getStudentList();
			}
			//辅导员角色只能查看自己所带班级的学生历史信息		
			else if(user.getUserType()==6){			
				 Assistant assistant=mgr.getAssistantByName(user.getUser());
				 studentList=mgr.getStudentListByAssistantname(assistant.getName());
			}
			//老师角色只能查看自己所代课班级的学生历史信息	
			else if(user.getUserType()==7){
				List<String> tclassnameList = mgr.getDistinctKechengListByTeacher(user.getUser());
				if(null!=tclassnameList&&tclassnameList.size()>0){   					
					for (String tclassname : tclassnameList) {
						TClass tclass=mgr.getClassByName(tclassname);
						if(null!=tclass){ 
							Assistant assistant=(Assistant) this.combiz.get(Assistant.class, tclass.getAssistantid());
							List<Student> currstudentList=mgr.getStudentListByAssistantname(assistant.getName());
							for (Student student : currstudentList) {
								studentList.add(student);
							}
						}
					}
				}
			}
			//学生角色只能查看自己的历史信息	
			else if(user.getUserType()==8){
				 Student student = mgr.getStudentBySid(user.getUser());
				 studentList.add(student);
			}
    		request.setAttribute("studentList", studentList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "findStudentHistoryInformation";
    }
	
	
	
	public String lookStudentSubjectHistoryInformation(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String studnetid=request.getParameter("studentid");
    		Student student=(Student) this.combiz.get(Student.class, Integer.parseInt(studnetid));
    		JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			List<ScoreNew> scoreListBaifenzhi=new ArrayList<ScoreNew>();
			List<ScoreNew> scoreListFeibaifenzhi=new ArrayList<ScoreNew>();
			List<ScoreNew> scoreListJifendanyuan=new ArrayList<ScoreNew>();
			DifferentPhase df=new DifferentPhase();
			ResultSet rs=null;
			Statement sm =null;
			/*当前学生的所有百分制成绩*/
			String sql="SELECT * FROM score_new WHERE  scoretype=1 AND sid='" +student.getSid()+ "'";
			sm = con.createStatement();
			rs = sm.executeQuery(sql);
			while(rs.next()){
				ScoreNew score = new ScoreNew();
				int score_newid=rs.getInt("id");
				int subjectid=rs.getInt("subjectid");
				int phaseid=rs.getInt("phaseid");
				int scoretype=rs.getInt("scoretype");
				int examtype=rs.getInt("examtype");
				score.setExamtypename(df.getExamType(examtype));
				String result = rs.getString("result");
				Subject subject=(Subject) this.combiz.get(Subject.class, subjectid);
				score.setSid(student.getSid());
				score.setStudentname(student.getName());
				score.setStudentname(student.getName());
				score.setSubjectname(subject.getName());
				score.setPhaseid(phaseid);
				score.setScoretype(scoretype);
				score.setResult(result);
				score.setSubjectid(subjectid);
				score.setId(score_newid);
				scoreListBaifenzhi.add(score);
			}
			List<Integer> subjectidList=new ArrayList<Integer>();
			/*当前学生的非百分制考试科目id*/
			sql="SELECT DISTINCT subjectid FROM score_new where scoretype=2 AND sid='" +student.getSid()+ "'";
			sm = con.createStatement();
			rs = sm.executeQuery(sql);
			while(rs.next()){
				int subjectid=rs.getInt("subjectid");				
				subjectidList.add(subjectid);
			}
			/*当前学生非百分制考试每一个考试科目所对应的最终成绩*/
			for (Integer integer : subjectidList) {
				sql="select * from score_new where scoretype=2 and sid='" +student.getSid()+ "' and subjectid='"+integer+"' order by examtype desc";
				sm = con.createStatement();
				rs = sm.executeQuery(sql);
				while(rs.next()){
					if(null!=rs.getString("result")){						
						ScoreNew score = new ScoreNew();
						int score_newid=rs.getInt("id");
						int subjectid=rs.getInt("subjectid");
						int phaseid=rs.getInt("phaseid");
						int scoretype=rs.getInt("scoretype");
						int examtype=rs.getInt("examtype");
						score.setExamtypename(df.getExamType(examtype));
						String result = rs.getString("result");
						Subject subject=(Subject) this.combiz.get(Subject.class, subjectid);
						score.setSid(student.getSid());
						score.setStudentname(student.getName());
						score.setStudentname(student.getName());
						score.setSubjectname(subject.getName());
						score.setPhaseid(phaseid);
						score.setScoretype(scoretype);
						score.setResult(result);
						score.setSubjectid(subjectid);
						score.setId(score_newid);
						scoreListBaifenzhi.add(score);
						break;
					}
				}
			}
			/*当前学生的记分单元考试科目id*/
			sql="SELECT DISTINCT subjectid FROM score_new where scoretype=3 AND sid='" +student.getSid()+ "'";
			sm = con.createStatement();
			rs = sm.executeQuery(sql);
			subjectidList.clear();
			while(rs.next()){
				int subjectid=rs.getInt("subjectid");				
				subjectidList.add(subjectid);
			}

			/*当前学生记分单元考试每一个考试科目所对应的最终成绩*/
			for (Integer integer : subjectidList) {
				sql="select * from score_new where scoretype=3 and sid='" +student.getSid()+ "' and subjectid='"+integer+"' order by examtype desc";
				sm = con.createStatement();
				rs = sm.executeQuery(sql);
				while(rs.next()){
					if(null!=rs.getString("result")){						
						ScoreNew score = new ScoreNew();
						int score_newid=rs.getInt("id");
						int subjectid=rs.getInt("subjectid");
						int phaseid=rs.getInt("phaseid");
						int scoretype=rs.getInt("scoretype");
						int examtype=rs.getInt("examtype");
						score.setExamtypename(df.getExamType(examtype));
						String result = rs.getString("result");
						Subject subject=(Subject) this.combiz.get(Subject.class, subjectid);
						score.setSid(student.getSid());
						score.setStudentname(student.getName());
						score.setStudentname(student.getName());
						score.setSubjectname(subject.getName());
						score.setPhaseid(phaseid);
						score.setScoretype(scoretype);
						score.setResult(result);
						score.setSubjectid(subjectid);
						score.setId(score_newid);
						scoreListBaifenzhi.add(score);
						break;
					}
				}
			}
    		request.setAttribute("scoreListBaifenzhi", scoreListBaifenzhi);
    		request.setAttribute("scoreListFeibaifenzhi", scoreListFeibaifenzhi);
    		request.setAttribute("scoreListJifendanyuan", scoreListJifendanyuan);
    		request.setAttribute("student", student);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "lookStudentSubjectHistoryInformation";
    }
	
	public String lookStudentSubjectDetailHistoryInformation(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String scoreid=request.getParameter("scoreid");
    		JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			List<ScoreNew> scoreList=new ArrayList<ScoreNew>();
			DifferentPhase df=new DifferentPhase();
			ResultSet rs=null;
			Statement sm =null;
			String sql="";
    		ScoreNew score=(ScoreNew) this.combiz.get(ScoreNew.class, Integer.parseInt(scoreid));
    		Exam exam=(Exam) this.combiz.get(Exam.class, score.getExamid());
    		Subject subject=(Subject) this.combiz.get(Subject.class, score.getSubjectid());
    		score.setExam(exam.getTitle());
    		score.setSubjectname(subject.getName());
    		if(score.getScoretype()==1){    			
    		}
    		else if(score.getScoretype()==2){
    			if(!score.getResult().equals("P")){
    				score.setResult("未考完");
    			}
    			sql="select * from score_new where scoretype=2 and sid='" +score.getSid()+ "' and subjectid='"+score.getSubjectid()+"' and phaseid='"+score.getPhaseid()+"' order by examtype asc";
				sm = con.createStatement();
				rs = sm.executeQuery(sql);
				while(rs.next()){
					if(null!=rs.getString("result")){						
						ScoreNew scoreNew = new ScoreNew();
						int subjectid=rs.getInt("subjectid");
						int phaseid=rs.getInt("phaseid");
						int examtype=rs.getInt("examtype");
						String examdate=rs.getString("examdate");
						scoreNew.setExamtypename(df.getExamType(examtype));
						String result = rs.getString("result");
						scoreNew.setSubjectname(subject.getName());
						scoreNew.setPhaseid(phaseid);
						scoreNew.setResult(result);
						scoreNew.setSubjectid(subjectid);
						scoreNew.setExamdate(examdate);
						scoreList.add(scoreNew);
					}
				}
    		}
    		else{
    			if(!score.getResult().equals("F")){
    				score.setResult("未考完");
    			}
    			sql="select * from score_new where scoretype=3 and sid='" +score.getSid()+ "' and subjectid='"+score.getSubjectid()+"' and phaseid='"+score.getPhaseid()+"' order by examtype asc";
				sm = con.createStatement();
				rs = sm.executeQuery(sql);
				while(rs.next()){
					if(null!=rs.getString("result")){						
						ScoreNew scoreNew = new ScoreNew();
						int examid=rs.getInt("examid");
						int phaseid=rs.getInt("phaseid");
						int examtype=rs.getInt("examtype");
						String examdate=rs.getString("examdate");
						scoreNew.setExamtypename(df.getExamType(examtype));
						String result = rs.getString("result");
						scoreNew.setSubjectname(subject.getName());
						scoreNew.setPhaseid(phaseid);
						scoreNew.setResult(result);
						Exam examNew=(Exam) this.combiz.get(Exam.class, examid);
						scoreNew.setExam(examNew.getTitle()+"-"+df.getExamType(examtype));
						scoreNew.setExamdate(examdate);
						scoreList.add(scoreNew);
					}
				}
    		}
    		request.setAttribute("score", score);
    		request.setAttribute("scoreList", scoreList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "lookStudentSubjectDetailHistoryInformation";
    }
	
	
	
	public String findStudentHistoryAbsenceInformation(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		List<Student> studentList=new ArrayList<Student>();
    		String classid=request.getParameter("classid");
    		Integer late=0;
    		Integer early=0;
    		Integer truant=0;
    		//教务和教务主管可以查看所有学生的历史考勤信息	
			/*if(user.getUserType()==3||user.getUserType()==4){
				absenceList=mgr.getAbsenceList();
			}*/
			//辅导员角色只能查看自己所带班级的学生历史考勤信息		
			if(user.getUserType()==6){			
				 Assistant assistant=mgr.getAssistantByName(user.getUser());
				 tclassList=mgr.getClassByAssistantid(assistant.getId());
				 if(null==classid||classid.equals("")){					 
					 if(null!=tclassList&&tclassList.size()>0){					 
						 TClass tclass=tclassList.get(0);
						 studentList=mgr.getHistoryStudentListByClassname(tclass.getName());
					 }
				 }else{
					 TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(classid));
					 tclassList=mgr.getClassByAssistantid(assistant.getId());
					 studentList=mgr.getHistoryStudentListByClassname(tclass.getName());
				 }
				request.setAttribute("classList", tclassList);
	    		request.setAttribute("studentList", studentList);
	    		request.setAttribute("classid", classid); 
	    		return "findStudentHistoryAbsenceInformation";
			}
			//老师角色只能查看自己所代课班级的学生历史考勤信息	
			/*else if(user.getUserType()==7){
				List<String> tclassnameList = mgr.getDistinctKechengListByTeacher(user.getUser());
				if(null!=tclassnameList&&tclassnameList.size()>0){   					
					for (String tclassname : tclassnameList) {
						TClass tclass=mgr.getClassByName(tclassname);
						if(null!=tclass){ 
							Assistant assistant=(Assistant) this.combiz.get(Assistant.class, tclass.getAssistantid());
							List<Student> currstudentList=mgr.getStudentListByAssistantname(assistant.getName());
							for (Student student : currstudentList) {
								studentList.add(student);
							}
						}
					}
				}
			}*/
			//学生角色只能查看自己的历史考勤信息	
			else if(user.getUserType()==8){
				 Student student = mgr.getStudentBySid(user.getUser());
				 absenceList=mgr.getAbsenceListBySid(student.getSid());
		    		if(null!=absenceList&&absenceList.size()>0){   			
		    			for (Absence absence : absenceList) {
		    				Subject subject=(Subject) this.combiz.get(Subject.class, absence.getSubjectid());
		    				absence.setSubjectname(subject.getName());
		    				if(absence.getType()==1){
		    					late+=1;
		    				}
		    				else if(absence.getType()==2){
		    					truant+=1;
		    				}
		    				else if(absence.getType()==4){
		    					early+=1;
		    				}
		    				else if(absence.getType()==5){
		    					late+=1;
		    					early+=1;
		    				}
		    			}
		    		}
		    		request.setAttribute("late",late);
		    		request.setAttribute("truant",truant);
		    		request.setAttribute("early",early);
		    		request.setAttribute("absenceList", absenceList);
		    		return "findStudentHistoryAbsenceDetailInformation";
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
	
	public String findStudentHistoryAbsenceDetailInformation(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String sid=request.getParameter("sid");
    		Integer late=0;
    		Integer early=0;
    		Integer truant=0;
    		absenceList=mgr.getAbsenceListBySid(sid);
    		if(null!=absenceList&&absenceList.size()>0){   			
    			for (Absence absence : absenceList) {
    				Subject subject=(Subject) this.combiz.get(Subject.class, absence.getSubjectid());
    				absence.setSubjectname(subject.getName());
    				if(absence.getType()==1){
    					late+=1;
    				}
    				else if(absence.getType()==2){
    					truant+=1;
    				}
    				else if(absence.getType()==4){
    					early+=1;
    				}
    				else if(absence.getType()==5){
    					early+=1;
    					late+=1;
    				}
    			}
    		}
    		request.setAttribute("late",late);
    		request.setAttribute("truant",truant);
    		request.setAttribute("early",early);
    		request.setAttribute("absenceList", absenceList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "findStudentHistoryAbsenceDetailInformation";
    }
	
	public String checkCondition(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse response = ServletActionContext.getResponse();
    		response.setContentType("text/html;charset=utf-8");
    		PrintWriter out=response.getWriter();
    		HttpSession session=request.getSession();
    		User user=(User) session.getAttribute("tuser");
    		String sid=request.getParameter("sid");
    		List<String> classnameList=new ArrayList<String>();
    		if(user.getUserType()==5){
    			/*学生主管查看所有班级*/
				classList=mgr.getClassList();
    		}
    		else if(user.getUserType()==6){
    			/*当前辅导员所带的班级*/
    			Assistant assistant = mgr.getAssistantByName(user.getUser());
    			classList = mgr.getClassListByAssistantid(assistant.getId());
    		}
    		else if(user.getUserType()==7){
    			/*当前老师所代课的班级*/
    			classList=new ArrayList<String>();
    			List<String> tclassnameList = mgr.getDistinctKechengListByTeacher(user.getUser());
    			if(null!=tclassnameList&&tclassnameList.size()>0){   					
    				for (String tclassname : tclassnameList) {
    					TClass tclass=mgr.getClassByName(tclassname);
    					if(null!=tclass){   						
    						classList.add(tclass);
    					}
    				}
    			}
    		}
    		/*获取当前角色所能查看的班级名字*/
			if(null != classList && classList.size() > 0){
				for(int i = 0 ; i < classList.size(); i++){
					TClass cla = (TClass) classList.get(i);
					classnameList.add(cla.getName());
				}   								
			}

			Student student=mgr.getStudentBySid(sid);
			if(null!=student){				
				if(classnameList.contains(student.getClassname()))
				{
					out.print("{bol:true}");
				}else{
					out.print("{bol:false,message:'"+URLEncoder.encode("此学生不属于你所带的班级，请填写正确的学号","UTF-8")+"'}");
				}
			}
			else{
				out.print("{bol:false,message:'"+URLEncoder.encode("没有查到该学生，请填写正确的学号","UTF-8")+"'}");
			}
			
			out.flush();
			out.close();
			
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "success";
    }
	
	public String addAbsence(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			classList=mgr.getClassList();
			teacherList=mgr.getTeacherList();
			request.setAttribute("classList", classList);
			request.setAttribute("teacherList", teacherList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addAbsence";
	}
	
	public String getStudent(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse response = ServletActionContext.getResponse();
    		response.setContentType("application/json;charset=utf-8");
    		PrintWriter out=response.getWriter();
    		String classid=request.getParameter("classid");
    		if(classid!=null){
    			TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(classid));
    			studentList=mgr.getStudentListByClassname(tclass.getName());
    			out.write(JSONArray.toJSONString(studentList));
    			
    		}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addAbsence";
	}
	
	public String getSubject(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse response = ServletActionContext.getResponse();
    		response.setContentType("application/json;charset=utf-8");
    		PrintWriter out=response.getWriter();
    		String teachername=request.getParameter("teacher");
    		JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			List<Subject> subjectList=new ArrayList<Subject>();
			ResultSet rs=null;
			Statement sm =null;
			String sql="select s.id,s.name from (select  distinct k.subjectname from kecheng k WHERE k.teacher='"+teachername+"') as oneselect,subject s where oneselect.subjectname=s.name";
			sm = con.createStatement();
			rs = sm.executeQuery(sql);
			while(rs.next()){					
					Subject subject = new Subject();
					int id=rs.getInt("id");
					String name=rs.getString("name");
					subject.setId(id);
					subject.setName(name);
					subjectList.add(subject);				
			}
    		out.write(JSONArray.toJSONString(subjectList));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addAbsence";
	}
	
	public String doAddAbsence(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse response = ServletActionContext.getResponse(); 
    		User user = (User) request.getSession().getAttribute("tuser");
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    		String classid=request.getParameter("classid");
    		String studentid=request.getParameter("studentid");
    		String teachername=request.getParameter("teacher");
    		teachername=new String(teachername.getBytes("iso-8859-1"),"utf-8");
    		String subjectid=request.getParameter("subjectid");
    		String absenceType=request.getParameter("absenceType");
    		String absencedate=request.getParameter("absenceDate");
    		Absence absence=new Absence();
    		absence.setSubjectid(Integer.parseInt(subjectid));
    		absence.setSid(studentid);
    		absence.setTeachername(teachername);
    		absence.setType(Integer.parseInt(absenceType));
    		absence.setAbsencedate(df.parse(absencedate));
    		absence.setClassid(Integer.parseInt(classid));
    		this.combiz.save(absence);
    		addActionMessage("添加成功");
    		Logging logg=new Logging();
			logg.setUsername(user.getUser());
			logg.setUsertype(user.getUserType());
			logg.setContent("用户："+user.getUser()+"添加了学号为："+studentid+"的考勤");
			logg.setOpertime(new Date());
			this.combiz.save(logg);
    		classList=mgr.getClassList();
			teacherList=mgr.getTeacherList();
			request.setAttribute("classList", classList);
			request.setAttribute("teacherList", teacherList);
    		return "doAddAbsence";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addAbsence";
	}
	
	public String doUpdateAbsence(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    		//String absenceid=request.getParameter("absenceid");
    		 absenceid=request.getParameter("absenceid");
    		 content="update";
    		/*
    		String classid=request.getParameter("classid");
    		String studentid=request.getParameter("studentid");
    		String teachername=request.getParameter("teacher");
    		teachername=new String(teachername.getBytes("iso-8859-1"),"utf-8");
    		String subjectid=request.getParameter("subjectid");*/
    		String absenceType=request.getParameter("absenceType");
    		String absencedate=request.getParameter("absenceDate");
    		Absence absence=(Absence) this.combiz.get(Absence.class, Integer.parseInt(absenceid));
    		/*
    		absence.setSubjectid(Integer.parseInt(subjectid));
    		absence.setSid(studentid);
    		absence.setTeachername(teachername);
    		absence.setClassid(Integer.parseInt(classid));*/
    		absence.setType(Integer.parseInt(absenceType));
    		absence.setAbsencedate(df.parse(absencedate));
    		this.combiz.update(absence);
    		Logging logg=new Logging();
			logg.setUsername(user.getUser());
			logg.setUsertype(user.getUserType());
			logg.setContent("用户："+user.getUser()+"修改了学号为："+absence.getSid()+"的考勤");
			logg.setOpertime(new Date());
			this.combiz.save(logg);
			request.setAttribute("absenceid", absenceid);
			request.setAttribute("content", content);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "doUpdateAbsence";
	}
	
	public String toEditAbsence(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
    		String absenceid=request.getParameter("absenceid");
    		
    		String content=request.getParameter("content");
    		System.out.println(content);
    		Absence absence=(Absence) this.combiz.get(Absence.class, Integer.parseInt(absenceid));
    		Subject subject=(Subject) this.combiz.get(Subject.class,absence.getSubjectid());
    		Student student=mgr.getStudentBySid(absence.getSid());
    		TClass tclass=(TClass) this.combiz.get(TClass.class,absence.getClassid());
    		absence.setSubjectname(subject.getName());
    		absence.setClassname(tclass.getName());
    		absence.setStudentname(student.getName());
			request.setAttribute("absence", absence);
			if(content!=null && content.equals("update")){
				addActionMessage("更新成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toEditAbsence";
	}
	
	public String doDeleteAbsence(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
    		String absenceid=request.getParameter("absenceid");
    		content="delete";
    		String[] absenceidArray=absenceid.split(",");
    		List<String> absenceidList=Arrays.asList(absenceidArray);
    		for (String string : absenceidList) {				
    			Absence absence=(Absence) this.combiz.get(Absence.class, Integer.parseInt(string));
    			this.combiz.delete(absence);
    			Logging logg=new Logging();
    			logg.setUsername(user.getUser());
    			logg.setUsertype(user.getUserType());
    			logg.setContent("用户："+user.getUser()+"删除了学号为："+absence.getSid()+"的考勤");
    			logg.setOpertime(new Date());
    			this.combiz.save(logg);
			}
			request.setAttribute("content", content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "doDeleteAbsence";
	}
	
	public String getUpdateTime(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse response = ServletActionContext.getResponse();
    		response.setContentType("text/html;charset=utf-8");
    		PrintWriter out=response.getWriter();
    		String delayid=request.getParameter("delayid");
    		if(delayid!=null){
    			EnterApply enterApply=(EnterApply) this.combiz.get(EnterApply.class, Integer.parseInt(delayid));
    			out.write(enterApply.getUpdatedate());
    		}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addAbsence";
	}
	
}














