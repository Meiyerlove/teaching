package org.yeeku.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Adjust;
import org.yeeku.model.Assistant;
import org.yeeku.model.Jieke;
import org.yeeku.model.Kecheng;
import org.yeeku.model.Kechengversion;
import org.yeeku.model.Sec_Kecheng;
import org.yeeku.model.Student;
import org.yeeku.model.Subject;
import org.yeeku.model.TClass;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;
import org.yeeku.util.DateHandle;

import com.opensymphony.xwork2.ActionContext;

public class KechengAction extends BaseAction {
	
	private List teacherList;
	private List classList;
	private List subjectList;
	private List kechengList;
	private List assistantList;
    private String versions;

	public List getTeacherList() {
		return teacherList;
	}
	
	public void setTeacherList(List teacherList) {
		this.teacherList = teacherList;
	}
	public List getClassList() {
		return classList;
	}
	public void setClassList(List classList) {
		this.classList = classList;
	}
	public List getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List subjectList) {
		this.subjectList = subjectList;
	}
	public List getKechengList() {
		return kechengList;
	}
	public void setKechengList(List kechengList) {
		this.kechengList = kechengList;
	}
	
	public String getVersions() {
		return versions;
	}

	public void setVersions(String versions) {
		this.versions = versions;
	}

	public String toKechengAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String versions=request.getParameter("versions");
     		classList = mgr.getClassList();
    		teacherList = mgr.getTeacherList();
    		subjectList = mgr.getSubjectList();
    		assistantList=mgr.getAssistantList();
    		request.setAttribute("classList", classList);
    		request.setAttribute("teacherList", teacherList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("assistantList", assistantList);
    		request.setAttribute("versions", versions);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toKechengAdd";
    }
	
	public String doKechengAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String grade = request.getParameter("grade");
    		String classid = request.getParameter("classid");
    		String subjectid = request.getParameter("subjectid");
    		String weekday = request.getParameter("weekday");
    		String starttime = request.getParameter("starttime");
    		String endtime = request.getParameter("endtime");
    		String teacherid = request.getParameter("teacherid");
    		String assistantid = request.getParameter("assistantid");
    		String campus = request.getParameter("campus");
    		String classroom = request.getParameter("classroom");
    		String week=request.getParameter("week");
    		String semester = request.getParameter("semester");
    		String versions=request.getParameter("versions");
            try {
            	campus = (campus != null)?new String(campus.getBytes("iso-8859-1"),"utf-8"):campus;
            	classroom = (classroom != null)?new String(classroom.getBytes("iso-8859-1"),"utf-8"):classroom;
            	semester = (semester != null)?new String(semester.getBytes("iso-8859-1"),"utf-8"):semester;
    		} catch (UnsupportedEncodingException e) {
    			e.printStackTrace();
    		}
    		
    		TClass cla = (TClass) this.combiz.get(TClass.class, Integer.valueOf(classid));
    		Subject subject = (Subject) this.combiz.get(Subject.class, Integer.valueOf(subjectid));
    		Kecheng kecheng = new Kecheng();
    		if(null!=teacherid&&!teacherid.equals("")){    			
    			Teacher teacher = (Teacher) this.combiz.get(Teacher.class, Integer.valueOf(teacherid));
    			kecheng.setTeacherid(teacher.getTid());
    			kecheng.setTeacher(teacher.getName());
    		}else{
    			Assistant assistant=(Assistant) this.combiz.get(Assistant.class, Integer.valueOf(assistantid));
    			kecheng.setTeacherid(assistant.getAid());
    			kecheng.setTeacher(assistant.getName());
    		}
    			kecheng.setGrade(Integer.valueOf(grade));
    			kecheng.setClassid(cla.getId());
    			kecheng.setClassname(cla.getName());
    			kecheng.setSubjectid(subject.getId());
    			kecheng.setSubjectname(subject.getName());
    			kecheng.setWeekday(weekday);
    			kecheng.setStarttime(starttime);
    			kecheng.setEndtime(endtime);
    			kecheng.setCampus(campus);
    			kecheng.setClassroom(classroom);
    			kecheng.setSemester(semester);
    			kecheng.setWeek(Integer.parseInt(week));
    			kecheng.setV_id(Integer.parseInt(versions));
    			this.combiz.save(kecheng);	
    	
    		addActionMessage("课程保存成功");
    		classList = mgr.getClassList();
    		teacherList = mgr.getTeacherList();
    		subjectList = mgr.getSubjectList();
    		assistantList=mgr.getAssistantList();
    		request.setAttribute("classList", classList);
    		request.setAttribute("teacherList", teacherList);
    		request.setAttribute("subjectList", subjectList);
    		request.setAttribute("assistantList", assistantList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doKechengAdd";
    }
	
	public String deleteKecheng(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		// HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
    		String kechengid = request.getParameter("kechengid");
    		versions = request.getParameter("versions");
    		Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));	
    		this.combiz.delete(kecheng);
    		request.setAttribute("versions", versions);
     		//request.getSession().setAttribute("versions", versions);
//    		 ActionContext actionContext = ActionContext.getContext();
//			 Map session = actionContext.getSession();
//    		if(versions.equals("1")){
//    			Kecheng kecheng = (Kecheng) this.combiz.get(Kecheng.class, Integer.valueOf(kechengid));	
//    			 this.combiz.delete(kecheng);
//    			 request.getSession().setAttribute("versions", versions);
//    		}else{
//    			Sec_Kecheng sec_Kecheng = (Sec_Kecheng) this.combiz.get(Sec_Kecheng.class, Integer.valueOf(kechengid));	
//    			this.combiz.delete(sec_Kecheng);
//    			request.getSession().setAttribute("versions", versions);
//    		}
    		
    		//roleList = mgr.getRoleList();
    		//Role role = (Role) this.combiz.get(Role.class, useredit.getUserType());
    		//roleList = mgr.getRoleList();
    		//request.setAttribute("useredit", useredit);
    		//request.setAttribute("role", role);
    		//request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "deleteKecheng";
    }

	public String toMyKechengList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User user = (User) request.getSession().getAttribute("tuser");
    		//kechengList = mgr.getKechengListByTeacher(user.getUser());
    		List kelist=new ArrayList();
    		kechengList = mgr.getKechengListByTeacher(user.getUser());
    		for(int i=0;i<kechengList.size();i++){
    			 Object object[] = (Object[]) kechengList.get(i);
				 Kecheng kecheng=(Kecheng) object[0];
				 kelist.add(kecheng);
    		}
    		request.setAttribute("kechengList", kelist);
//    		kechengList = mgr.getSec_KechengListByTeacher(user.getUser());
//    		request.setAttribute("kechengList2", kechengList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toMyKechengList";
    }


	 /*
	  * 根据课程版本查看老师课程
	  * */
		public String findTeacherKebiaoListByVersion(){
			try {
				HttpServletRequest request = ServletActionContext.getRequest();
				User user = (User) request.getSession().getAttribute("tuser");
				String versionId=request.getParameter("version");
				Teacher teacher=mgr.getTeacherByName(user.getUser());
				List<Kechengversion> kechengVersionList=mgr.getKechengversionList(1);
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
	    	    				List adjustList = mgr.getAdjustList(teacher.getName(), date, fromtime,Integer.parseInt(versionId));   	    				    	    				
	    	    				Kecheng kecheng = mgr.getKechengjieke(teacher.getName(),fromtime,weekday,Integer.parseInt(versionId));
	    	    				if(null != adjustList && adjustList.size() > 0){
	    	    					kecheng = null;
	    	    				}   	    				
	    	    				List adjustListAfter = mgr.getAdjustListAfter(teacher.getName(), date, fromtime,Integer.parseInt(versionId));
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
	    			request.setAttribute("versionId", versionId);
					request.setAttribute("kebiaoList", kebiaoList);
					request.setAttribute("kechengVersionList", kechengVersionList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "findTeacherKebiaoListByVersion";
		}
		
		
		 /*
		  * 根据课程版本查看辅导员课程
		  * */
			public String findFudaoyuanKebiaoListByVersion(){
				try {
					HttpServletRequest request = ServletActionContext.getRequest();
					User user = (User) request.getSession().getAttribute("tuser");
					String versionId=request.getParameter("version");
					String kebiao=request.getParameter("kebiao");
					Assistant assistant=mgr.getAssistantByName(user.getUser());
					List<Kechengversion> kechengVersionList=mgr.getKechengversionList(1);
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
		    	    				List adjustList = mgr.getAdjustList(assistant.getName(), date, fromtime,Integer.parseInt(versionId));   	    				    	    				
		    	    				Kecheng kecheng = mgr.getKechengjieke(assistant.getName(),fromtime,weekday,Integer.parseInt(versionId));
		    	    				if(null != adjustList && adjustList.size() > 0){
		    	    					kecheng = null;
		    	    				}   	    				
		    	    				List adjustListAfter = mgr.getAdjustListAfter(assistant.getName(), date, fromtime,Integer.parseInt(versionId));
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
		    			request.setAttribute("kebiao", kebiao);
		    			request.setAttribute("versionId", versionId);
						request.setAttribute("kebiaoList", kebiaoList);
						request.setAttribute("kechengVersionList", kechengVersionList);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "findFudaoyuanKebiaoListByVersion";
			}
		
		/*
		  * 根据课程版本查看学生课程
		  * */
			public String findStudentKebiaoListByVersion(){
				try {
					HttpServletRequest request = ServletActionContext.getRequest();
					User user = (User) request.getSession().getAttribute("tuser");
					String versionId=request.getParameter("version");
					List<Kechengversion> kechengVersionList=mgr.getKechengversionList(1);					
					Student student = (Student) mgr.getStudentList(user.getUser()).get(0);
	        		String classname = student.getClassname();
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
		    	    				List adjustList = mgr.getAdjustListNew(classname, date, fromtime,Integer.parseInt(versionId));   	    				    	    				
		    	    				Kecheng kecheng = mgr.getKechengjiekeNew(classname,fromtime,weekday,Integer.parseInt(versionId));
		    	    				if(null != adjustList && adjustList.size() > 0){
		    	    					kecheng = null;
		    	    				}   	    				
		    	    				List adjustListAfter = mgr.getAdjustListAfterNew(classname, date, fromtime,Integer.parseInt(versionId));
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
		    			request.setAttribute("versionId", versionId);
						request.setAttribute("kebiaoList", kebiaoList);
						request.setAttribute("kechengVersionList", kechengVersionList);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "findStudentKebiaoListByVersion";
			}
			
			
			/*
			  * 根据课程版本查看辅导员课程
			  * */
				public String findFudaoyuanKebiaoListByVersionAndClass(){
					try {
						HttpServletRequest request = ServletActionContext.getRequest();
						User user = (User) request.getSession().getAttribute("tuser");
						String versionId=request.getParameter("version");
						String kebiao=request.getParameter("kebiao");
						String classId=request.getParameter("class");
						List<Kechengversion> kechengVersionList=mgr.getKechengversionList(1);					
						Assistant assistant=mgr.getAssistantByName(user.getUser());
		    			List<TClass> tclassList=mgr.getClassListByAssistantid(assistant.getId());
		    			String classname="";
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
			    	    				if(kebiao.equals("1")){//通过版本查询辅导员课程
			    	    					
			    		    				List adjustList = mgr.getAdjustList(assistant.getName(), date, fromtime,Integer.parseInt(versionId));   	    				    	    				
				    	    				Kecheng kecheng = mgr.getKechengjieke(assistant.getName(),fromtime,weekday,Integer.parseInt(versionId));
				    	    				if(null != adjustList && adjustList.size() > 0){
				    	    					kecheng = null;
				    	    				}   	    				
				    	    				List adjustListAfter = mgr.getAdjustListAfter(assistant.getName(), date, fromtime,Integer.parseInt(versionId));
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
				    	    				
			    		    			}else{//通过版本查询班级课程
			    		    				if(null==classId){
			    		    					classId=tclassList.get(0).getId().toString();
			    		    				}
			    		    				
			    		    				TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(classId));
			    		    				classname = tclass.getName();
			    		    				List adjustList = mgr.getAdjustListNew(classname, date, fromtime,Integer.parseInt(versionId));   	    				    	    				
			    		    				Kecheng kecheng = mgr.getKechengjiekeNew(classname,fromtime,weekday,Integer.parseInt(versionId));
			    		    				if(null != adjustList && adjustList.size() > 0){
			    		    					kecheng = null;
			    		    				}   	    				
			    		    				List adjustListAfter = mgr.getAdjustListAfterNew(classname, date, fromtime,Integer.parseInt(versionId));
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
			    	    			}
			    	    			kebiaoList.add(cellList);
			    	    		}	
			    			request.setAttribute("kebiao", kebiao);
			    			request.setAttribute("classId", classId);
			    			request.setAttribute("versionId", versionId);
			    			request.setAttribute("tclassList", tclassList);
							request.setAttribute("kebiaoList", kebiaoList);
							request.setAttribute("kechengVersionList", kechengVersionList);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return "findFudaoyuanKebiaoListByVersionAndClass";
				}

	
	
}
