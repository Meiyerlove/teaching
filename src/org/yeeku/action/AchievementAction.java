package org.yeeku.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hdf.extractor.TC;
import org.apache.struts2.ServletActionContext;
import org.hibernate.mapping.Array;
import org.yeeku.JDBCConnection;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Assistant;
import org.yeeku.model.Classroom;
import org.yeeku.model.Exam;
import org.yeeku.model.Jzletter;
import org.yeeku.model.LetterTemplate;
import org.yeeku.model.Major;
import org.yeeku.model.ScoreNew;
import org.yeeku.model.Student;
import org.yeeku.model.Subject;
import org.yeeku.model.TClass;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;
import org.yeeku.util.ExcelUtil2007;

//import com.sun.xml.internal.ws.resources.HttpserverMessages;

public class AchievementAction extends BaseAction {
     private List<String> scorenewList;
     private List<Integer> scorenew_list;
    // private List<String> examList;
     private List examList;
     private List<String> scoresidList;
     private List<TClass> tclassList;
     private String id;
     private String title;
     private List kechengList;
     private String classId;
     private String subjectName;
     private List tclasslist;
     private List assistantlist;
     private List majorlist;
     private List studentList ;
     private List teacherList;
     private List assistantList;
     private List classList;
     private List subjectlist;
     private String classname;
     private List<String> classnamelist;
     private List<Jzletter> jzlettermgrlist;
     private List<LetterTemplate> lettertemplatelist;
	public void setScorenewList(List<String> scorenewList) {
		this.scorenewList = scorenewList;
	}

	public List<String> getExamList() {
		return examList;
	}

	public List<String> getScorenewList() {
		return scorenewList;
	}

	public List<TClass> getTclassList() {
		return tclassList;
	}

	public void setTclassList(List<TClass> tclassList) {
		this.tclassList = tclassList;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getScoresidList() {
		return scoresidList;
	}

	public void setScoresidList(List<String> scoresidList) {
		this.scoresidList = scoresidList;
	}

	

	public void setExamList(List examList) {
		this.examList = examList;
	}
   
	public List getKechengList() {
		return kechengList;
	}

	public void setKechengList(List kechengList) {
		this.kechengList = kechengList;
	}
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
    
	
	public List getTclasslist() {
		return tclasslist;
	}

	public void setTclasslist(List tclasslist) {
		this.tclasslist = tclasslist;
	}
    
	public List getAssistantlist() {
		return assistantlist;
	}

	public void setAssistantlist(List assistantlist) {
		this.assistantlist = assistantlist;
	}

	public List getMajorlist() {
		return majorlist;
	}

	public void setMajorlist(List majorlist) {
		this.majorlist = majorlist;
	}

	public List getStudentList() {
		return studentList;
	}

	public void setStudentList(List studentList) {
		this.studentList = studentList;
	}

	public List getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List teacherList) {
		this.teacherList = teacherList;
	}

	public List getAssistantList() {
		return assistantList;
	}

	public void setAssistantList(List assistantList) {
		this.assistantList = assistantList;
	}
    
	

	public List<LetterTemplate> getLettertemplatelist() {
		return lettertemplatelist;
	}

	public void setLettertemplatelist(List<LetterTemplate> lettertemplatelist) {
		this.lettertemplatelist = lettertemplatelist;
	}

	public List getClassList() {
		return classList;
	}

	public void setClassList(List classList) {
		this.classList = classList;
	}

	public List<String> getClassnamelist() {
		return classnamelist;
	}

	public void setClassnamelist(List<String> classnamelist) {
		this.classnamelist = classnamelist;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public List<Jzletter> getJzlettermgrlist() {
		return jzlettermgrlist;
	}

	public void setJzlettermgrlist(List<Jzletter> jzlettermgrlist) {
		this.jzlettermgrlist = jzlettermgrlist;
	}

	public List getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(List subjectlist) {
		this.subjectlist = subjectlist;
	}

	public List<Integer> getScorenew_list() {
		return scorenew_list;
	}

	public void setScorenew_list(List<Integer> scorenew_list) {
		this.scorenew_list = scorenew_list;
	}

	public String toMyExamList(){
		try {
		 HttpServletRequest request=ServletActionContext.getRequest();
		 User user=(User) request.getSession().getAttribute("tuser");
		 String tc=request.getParameter("id");
		 String sc=request.getParameter("title");
		 sc = (sc != null)?new String(sc.getBytes("iso-8859-1"),"utf-8"):sc;
		 List list=null;
		 List list_=null;
		 ScoreNew sn=null;
		 List scorenewlist=new ArrayList();
		 List tclassList_=new ArrayList();
		 String name=user.getUser();
		 if(user.getUserType()!=null && user.getUserType()==6){
				 Assistant assistant = mgr.getAssistantByName(name);
				 Integer assistanid=assistant.getId();
				 list=new ArrayList();
				 list_=new ArrayList();
				 List<TClass> tclassList=mgr.getClassByAssistantid(assistanid);
				 List<Integer> classkeylist=mgr.getScoreNewListByClasskey();//查出score_new表中有效的班级id
				 for(int i=0;i<classkeylist.size();i++){
					 Integer c=classkeylist.get(i);
					 list_.add(c);
				 }
				 for (TClass tClass : tclassList) {
					 Integer classkey=tClass.getId();
					 if(list_.contains(classkey)){
						 TClass tclass=(TClass) this.combiz.get(TClass.class, classkey);
						 tclassList_.add(tclass);
						 List<Exam> examlist= mgr.getExamByClasskey(classkey);
						 for (Exam exam : examlist) {
							 String title=exam.getTitle();
							 if(!list.contains(title)){
								 sn=new ScoreNew();
								 list.add(title);
								 sn.setTitle(title);
								 scorenewlist.add(sn);
							 }
						 } 
					 }			 
				}
				 List studentList=new ArrayList();
				 for (TClass tClass2 : tclassList) {
					Integer classid=tClass2.getId();
					Student stu=null;
					 scorenewList=mgr.getScorenewByClasskey(classid);//查询发布有效的sid集合
					 for (String str : scorenewList) {
						List<Student> student_list=mgr.getStudentList(str,name);//查询学生
						for (Student student2 : student_list) {
							String classname=student2.getClassname();
							TClass tcl=mgr.getClassByName(classname);
							if(tcl!=null){
								Integer tclid=tcl.getId();
								stu=new Student();
								scorenew_list= mgr.getScorenewBysid_(str); //查询班级的id集合
								for(Integer sr:scorenew_list){
									if(tclid.equals(sr)){
										String stusid=student2.getSid();
										Integer stuid=student2.getId();
										String studentname=student2.getName();
										Integer sex=student2.getSex();
										List CountBF1 =mgr.getScoreNewCountScoretype1(str);//百分制只有正考且大于等于60分算通过
										int baifen=0;
										String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数字
										if(CountBF1!=null && CountBF1.size()>0){
											for(int i=0;i<CountBF1.size();i++){
												Object _object = (Object) CountBF1.get(i);
												String result=(String)_object+"";
												if(!result.equals("null") && result.matches(regex)){
													double a = Double.valueOf(result);
													if(a>=60){
														baifen++; 
													}
												}
												
											}
										}
										List CountNoBF =mgr.getScoreNewCountScoretype2(str);//非百分制通过门数
										//记分单元正考
										List scoreNewlist=mgr.getScoreNewCountScoretype3(str); 
										int count=0;
										int count_=0;
										if(scoreNewlist!=null && scoreNewlist.size()>0){
											Object _object = (Object) scoreNewlist.get(0);
											String result=(String)_object+"";
											if(!result.equals("null")){
											if(((String)_object).matches(regex)){
												double a = Double.valueOf((String)_object);
												if(a>=70){
													count++; 
												}
											}else{
												if(((String)_object).equals("A")){
													count++; 
												}
											 }
											}
										}
										//记分单元补做 毕前考 其他考试成绩
										List scoreNewlist_=mgr.getScoreNewCountScoretype_3(str);
										if(scoreNewlist_!=null && scoreNewlist_.size()>0){
											Object _object = (Object) scoreNewlist_.get(0);
											String result=(String)_object+"";
											if(!result.equals("null")){
												if((result).matches(regex)){
													double b = Double.valueOf(result);
													if(b>=50){
														count_++; 
													}
												}else{
													if((result).equals("A")|| (result).equals("B") || (result).equals("C")){
														count_++; 
													}					
												}											
											}
										}
										Number num2=(Number) CountNoBF.get(0);
										int count1=baifen+num2.intValue()+count+count_;
										stu.setCount(count1);
										stu.setSid(stusid);
										stu.setId(stuid);
										stu.setName(studentname);
										stu.setSex(sex);
										stu.setClassname(classname);
										stu.setClassId(classid);
										studentList.add(stu);					
									}
							   }
							}
						 }
					 }	
			      } 
				 request.setAttribute("studentList", studentList);
				 request.setAttribute("scorenewlist", scorenewlist);
				 request.setAttribute("tclassList_", tclassList_);
				 request.setAttribute("tc", tc);
		   		 request.setAttribute("sc", sc);
		    } 
		 if(user.getUserType()!=null && user.getUserType()==7){
			 List tclasslist=new ArrayList();
			 List subjectlist=new ArrayList();
	    	 List _list=new ArrayList();
	    	 String cid="";
	    	 Teacher teacher=mgr.getTeacherByName(name);
	    	 List classname_list=mgr.getKechengListClassByTeacher1_(name) ;//老师对应的班级
	    	 if(classname_list!=null && classname_list.size()>0){
	    		for(int i=0;i<classname_list.size();i++){
	    			 Object object=classname_list.get(i);
	    			 TClass tclass=new TClass();
	    			 TClass t=mgr.getClassByName((String)object);
	    			 cid+=t.getId()+",";	    			
	    			// tclass.setName((String)object);
	    			 tclasslist.add(t);
	    			 
	    		}
	    		 cid=cid.substring(0, cid.length()-1);
	    	 }
	    	   request.setAttribute("tclasslist", tclasslist);
			   List<Integer> subject_list=mgr.getSubjectid_list(cid);
			   for(Integer str:subject_list){
				   Subject subject=(Subject) this.combiz.get(Subject.class, str);
				   subjectlist.add(subject.getName());
			   }
				if(classname_list!=null && classname_list.size()>0){
			   for(int i=0;i<classname_list.size();i++){
				   Object object = (Object) classname_list.get(i);
				   List classnamelist=new ArrayList();
				   String classname1=null;
				   List<Student> student_List= mgr.getStudentListByClassnameStatus((String) object); 
				   if(student_List!=null && student_List.size()>0){
				   for(Student stu:student_List){
					   String sid=stu.getSid(); 
		  			    ScoreNew _scoreNew=null;	 
		  				 List<Object[]> list1=mgr.getScoreNewBySid(sid);
		  				 for(Object[] object_ : list1){
		  					 List totalresult=new ArrayList();
		  					 _scoreNew=new ScoreNew();
		  					 Integer subjectid= (Integer) object_[0];	
		  					 Integer phaseid=(Integer) object_[1];
		  					 Integer scoretype=(Integer) object_[2];
		  					 Integer classkey=(Integer) object_[3];
		  					 //百分制
		  					 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//
		  					 if(scoretype.equals(1)){
		  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
		  						 if(zkScoreList.size()>0){
		  							 Object _object = (Object) zkScoreList.get(0);
		  							 _scoreNew.setZkresult((String) _object); 
		  							_scoreNew.setTotalresult((String) _object);
		  						 }	 
		  					 }
		  					 // 非百分制
		  					 if(scoretype.equals(2)){
		  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
		  						 if(zkScoreList.size()>0){
		  							 Object _object = (Object) zkScoreList.get(0);
		  							 String str=(String) _object+"";	 
		  							 if(!str.equals("null") && !(str).matches(regex)){
		  								 str=((String) _object).split("-")[0];
		  								 _scoreNew.setZkresult(str);
		  								 totalresult.add(str);
		  								 
		  							 }
		  						  }
		  						 List zkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,2);
		  						   if(zkbzScoreList.size()>0){
		  							   Object _object = (Object) zkbzScoreList.get(0);
		  							   String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							    _scoreNew.setZkbzresult(str); 
		  							   totalresult.add(str);
		  						     }	
		  						   }
		  						  
		  						 List zkbkScoreList=mgr.getScore_(sid, subjectid, phaseid,3);
		  						 if(zkbkScoreList.size()>0){
		  							 Object _object = (Object) zkbkScoreList.get(0);
		  							String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							  _scoreNew.setZkbkresult(str);
		  							  totalresult.add(str);
		  						   }
		  						 }
		
		  						 List zkbkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,4);
		  						 if(zkbkbzScoreList.size()>0){
		  							 Object _object = (Object) zkbkbzScoreList.get(0);
		  							 String str=(String) _object+"";
		  							  if(!str.equals("null") && !(str).matches(regex)){
		  							  str=str.split("-")[0];
		  							  _scoreNew.setZkbkbzresult(str);
		  							  totalresult.add(str);
		  						   }
		  						 }
		  						 List cxScoreList=mgr.getScore_(sid, subjectid, phaseid,5);
		  						 if(cxScoreList.size()>0){
		  							 Object _object = (Object) cxScoreList.get(0);
		  							 String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setCxresult(str);
		  							 totalresult.add(str);
		  						   }
		  						 }
		  						 List  cxbzScoreList=mgr.getScore_(sid, subjectid, phaseid,6);
		  						 if(cxbzScoreList.size()>0){
		  							 Object _object = (Object) cxbzScoreList.get(0);
		  							 String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setCxbzresult(str);
		  							totalresult.add(str);
		  						   }
		  						 }
		  						 List  bqkScoreList=mgr.getScore_(sid, subjectid, phaseid,7);
		  						 if(bqkScoreList.size()>0){
		  							 Object _object = (Object) bqkScoreList.get(0);
		  							 String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0]; 
		  							 _scoreNew.setBqkresult(str);
		  							totalresult.add(str);
		  						  }
		  						 }
		  						 List bqkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,8);
		  						 if(bqkbzScoreList.size()>0){
		  							 Object _object = (Object) bqkbzScoreList.get(0);
		  							String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setBqkbzresult(str);
		  							totalresult.add(str);
		  						   }
		  						 }
		  						 List qtScoreList=mgr.getScore_(sid, subjectid, phaseid,9);
		  						 if(qtScoreList.size()>0){
		  							 Object _object = (Object) qtScoreList.get(0);
		  							String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setQtresult(str);
		  							 totalresult.add(str);
		  						  }
		  						 }
		  						 List qtbzScoreList=mgr.getScore_(sid, subjectid, phaseid,10);
		  						 if(qtbzScoreList.size()>0){
		  							Object _object = (Object) qtbzScoreList.get(0);
		  							String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setQtbzresult(str);
		  							totalresult.add(str);
		  						   }
		  						 }
		  						 if(totalresult.contains("P")){
		  							 _scoreNew.setTotalresult("P");
		  						 }else{
		  							 _scoreNew.setTotalresult("未通过"); 
		  						 }
		  					 
		  				  }
		  					 //记分单元
		  					if(scoretype.equals(3)){
		  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
		  						 if(zkScoreList.size()>0){
		  							 Object _object = (Object) zkScoreList.get(0);
		  							 String str=(String)_object+"";
		  							 String result="";
		  							 if(!str.equals("null") && str.matches(regex)){
		  								double num = Double.valueOf(str);
		  								if(num>=70){
		  									result="A -- "+num;
		  			    				}else if(num>=60){
		  			    					result="B -- "+num;;
		  			    				}else if(num>=50){
		  			    					result="C -- "+num;;
		  			    				}else{
		  			    					result="F -- "+num;;
		  			    				}	
		  								_scoreNew.setTotalresult(result);
		  							 }else if(!str.equals("null") && !str.matches(regex)){
		  								result=str.split("-")[0];
		  								_scoreNew.setTotalresult(result);
		  							 }else{
		  								result=null;
		  							 }
		  							 _scoreNew.setZkresult(result);
		  						  }	 
		  						 List zkbkScoreList=mgr.getScore_(sid, subjectid, phaseid,3);
		  						 if(zkbkScoreList.size()>0){
		  							 Object _object = (Object) zkbkScoreList.get(0);
		  							 String str=(String)_object+"";
		  							 String result="";
		  							 if(!str.equals("null") && str.matches(regex)){
		  								double num = Double.valueOf(str);
		  								if(num>=70){
		  									result="A -- "+num;
		  			    				}else if(num>=60){
		  			    					result="B -- "+num;;
		  			    				}else if(num>=50){
		  			    					result="C -- "+num;;
		  			    				}else{
		  			    					result="F -- "+num;;
		  			    				}
		  								_scoreNew.setTotalresult(result);
		  							 }else if(!str.equals("null") && !str.matches(regex)){
		  								result=str.split("-")[0];
		  								_scoreNew.setTotalresult(result);
		  							 }else{
		  								result=null;
		  							 }
		  							_scoreNew.setZkbkresult(result);
		  						 }
		  						 List bqkScoreList=mgr.getScore_(sid, subjectid, phaseid,7);
		  						 if(bqkScoreList.size()>0){
		  							 Object _object = (Object) bqkScoreList.get(0);
		  							 String str=(String)_object+"";
		  							 String result="";
		  							 if(!str.equals("null") && str.matches(regex)){
		  								double num = Double.valueOf(str);
		  								if(num>=70){
		  									result="A -- "+num;
		  			    				}else if(num>=60){
		  			    					result="B -- "+num;;
		  			    				}else if(num>=50){
		  			    					result="C -- "+num;;
		  			    				}else{
		  			    					result="F -- "+num;;
		  			    				}
		  								_scoreNew.setTotalresult(result);
		  							 }else if(!str.equals("null") && !str.matches(regex)){
		  								result=str.split("-")[0];
		  								_scoreNew.setTotalresult(result);
		  							 }else{
		  								 result=null;
		  							 }
		  							_scoreNew.setBqkresult(result);	
		  						 }
		  						 List qtScoreList=mgr.getScore_(sid, subjectid, phaseid,9);
		  						 if(qtScoreList.size()>0){
		  								Object _object = (Object) qtScoreList.get(0);
		  								 String str=(String)_object+"";
			  							 String result="";
			  							if(!str.equals("null") && str.matches(regex)){
			  								double num = Double.valueOf(str);
			  								if(num>=70){
			  									result="A -- "+num;
			  			    				}else if(num>=60){
			  			    					result="B -- "+num;;
			  			    				}else if(num>=50){
			  			    					result="C -- "+num;;
			  			    				}else{
			  			    					result="F -- "+num;;
			  			    				}
			  								_scoreNew.setTotalresult(result);
			  							 }else if(!str.equals("null") && !str.matches(regex)){
			  								result=str.split("-")[0];
			  								_scoreNew.setTotalresult(result);
			  							 }else{
			  								 result=null;
			  							 }
			  							_scoreNew.setQtresult(result);
		  							}
		  					 }
		  					
		  					 Subject sub=(Subject) this.combiz.get(Subject.class, subjectid);
		  					 String subjectname=sub.getName(); 		  					
		  					 TClass _tclass=(TClass) this.combiz.get(TClass.class, classkey);
		  					 String _classname=_tclass.getName();
		  					 Student student= mgr.getStudentBySid(sid);
		  					 String studentname=student.getName();  
		  					 _scoreNew.setStudentname(studentname);
		  					 String studentid=student.getSid(); 
		  					 _scoreNew.setClassname(_classname);
		  					 _scoreNew.setStudentid(Integer.parseInt(studentid));
		  					 _scoreNew.setSubjectname(subjectname);
		  					 if(phaseid.equals(0)){//Assessment1
		  						 _scoreNew.setPhase("无");
		  					 }
		  					 if(phaseid.equals(1)){//Assessment1
		  						 _scoreNew.setPhase("Assessment1");
		  					 }
		  					 if(phaseid.equals(2)){//Assessment1
		  						 _scoreNew.setPhase("Assessment2");
		  					 }
		  					 if(phaseid.equals(3)){//Assessment1
		  						 _scoreNew.setPhase("Assessment3");
		  					 }
		  					 if(phaseid.equals(4)){//Assessment1
		  						 _scoreNew.setPhase("Assessment4");
		  					 }
		  					 if(phaseid.equals(5)){//Assessment1
		  						 _scoreNew.setPhase("Assessment5");
		  					 }
		  					 
		  					 _list.add(_scoreNew);
		  				
		  					 

		  		      }
				     request.setAttribute("_list", _list);
				     request.setAttribute("subjectlist", subjectlist);
				   }
			        }
	             }
	           }
		   }
			 if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4 || user.getUserType()==5){
					List tclasslist=mgr.getClassList();
					List subjectlist=mgr.getSubjectList();
		     		request.setAttribute("tclasslist", tclasslist);
		     		request.setAttribute("subjectlist", subjectlist);
				 
		      }
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 return "toMyExamList";
	}
	
	
	//备份的 toMyExamList的方法
	public String toQueryScore(){
		try {
		 HttpServletRequest request=ServletActionContext.getRequest();
		 User user=(User) request.getSession().getAttribute("tuser");
		 String tc=request.getParameter("id");
		 String sc=request.getParameter("title");
		 sc = (sc != null)?new String(sc.getBytes("iso-8859-1"),"utf-8"):sc;
		 List list=null;
		 List list_=null;
		 ScoreNew sn=null;
		 List scorenewlist=new ArrayList();
		 List tclassList_=new ArrayList();
		 String name=user.getUser();

		 if(user.getUserType()!=null && user.getUserType()==7){
			 List tclasslist=new ArrayList();
			 List subjectlist=new ArrayList();
	    	 List _list=new ArrayList();
	    	 String cid="";
	    	 Teacher teacher=mgr.getTeacherByName(name);
	    	 List classname_list=mgr.getKechengListClassByTeacher1_(name) ;//老师对应的班级
	    	 if(classname_list!=null && classname_list.size()>0){
	    		for(int i=0;i<classname_list.size();i++){
	    			 Object object=classname_list.get(i);
	    			 TClass tclass=new TClass();
	    			 TClass t=mgr.getClassByName((String)object);
	    			 cid+=t.getId()+",";	    			
	    			// tclass.setName((String)object);
	    			 tclasslist.add(t);
	    			 
	    		}
	    		 cid=cid.substring(0, cid.length()-1);
	    	 }
	    	   request.setAttribute("tclasslist", tclasslist);
			   List<Integer> subject_list=mgr.getSubjectid_list(cid);
			   for(Integer str:subject_list){
				   Subject subject=(Subject) this.combiz.get(Subject.class, str);
				   subjectlist.add(subject.getName());
			   }
				if(classname_list!=null && classname_list.size()>0){
			   for(int i=0;i<classname_list.size();i++){
				   Object object = (Object) classname_list.get(i);
				   List classnamelist=new ArrayList();
				   String classname1=null;
				   List<Student> student_List= mgr.getStudentListByClassnameStatus((String) object); 
				   if(student_List!=null && student_List.size()>0){
				   for(Student stu:student_List){
					   String sid=stu.getSid(); 
		  			    ScoreNew _scoreNew=null;	 
		  				 List<Object[]> list1=mgr.getScoreNewBySid(sid);
		  				 for(Object[] object_ : list1){
		  					 List totalresult=new ArrayList();
		  					 _scoreNew=new ScoreNew();
		  					 Integer subjectid= (Integer) object_[0];	
		  					 Integer phaseid=(Integer) object_[1];
		  					 Integer scoretype=(Integer) object_[2];
		  					 Integer classkey=(Integer) object_[3];
		  					 //百分制
		  					 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//
		  					 if(scoretype.equals(1)){
		  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
		  						 if(zkScoreList.size()>0){
		  							 Object _object = (Object) zkScoreList.get(0);
		  							 _scoreNew.setZkresult((String) _object); 
		  							_scoreNew.setTotalresult((String) _object);
		  						 }	 
		  					 }
		  					 // 非百分制
		  					 if(scoretype.equals(2)){
		  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
		  						 if(zkScoreList.size()>0){
		  							 Object _object = (Object) zkScoreList.get(0);
		  							 String str=(String) _object+"";	 
		  							 if(!str.equals("null") && !(str).matches(regex)){
		  								 str=((String) _object).split("-")[0];
		  								 _scoreNew.setZkresult(str);
		  								 totalresult.add(str);
		  								 
		  							 }
		  						  }
		  						 List zkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,2);
		  						   if(zkbzScoreList.size()>0){
		  							   Object _object = (Object) zkbzScoreList.get(0);
		  							   String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							    _scoreNew.setZkbzresult(str); 
		  							   totalresult.add(str);
		  						     }	
		  						   }
		  						  
		  						 List zkbkScoreList=mgr.getScore_(sid, subjectid, phaseid,3);
		  						 if(zkbkScoreList.size()>0){
		  							 Object _object = (Object) zkbkScoreList.get(0);
		  							String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							  _scoreNew.setZkbkresult(str);
		  							  totalresult.add(str);
		  						   }
		  						 }
		
		  						 List zkbkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,4);
		  						 if(zkbkbzScoreList.size()>0){
		  							 Object _object = (Object) zkbkbzScoreList.get(0);
		  							 String str=(String) _object+"";
		  							  if(!str.equals("null") && !(str).matches(regex)){
		  							  str=str.split("-")[0];
		  							  _scoreNew.setZkbkbzresult(str);
		  							  totalresult.add(str);
		  						   }
		  						 }
		  						 List cxScoreList=mgr.getScore_(sid, subjectid, phaseid,5);
		  						 if(cxScoreList.size()>0){
		  							 Object _object = (Object) cxScoreList.get(0);
		  							 String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setCxresult(str);
		  							 totalresult.add(str);
		  						   }
		  						 }
		  						 List  cxbzScoreList=mgr.getScore_(sid, subjectid, phaseid,6);
		  						 if(cxbzScoreList.size()>0){
		  							 Object _object = (Object) cxbzScoreList.get(0);
		  							 String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setCxbzresult(str);
		  							totalresult.add(str);
		  						   }
		  						 }
		  						 List  bqkScoreList=mgr.getScore_(sid, subjectid, phaseid,7);
		  						 if(bqkScoreList.size()>0){
		  							 Object _object = (Object) bqkScoreList.get(0);
		  							 String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0]; 
		  							 _scoreNew.setBqkresult(str);
		  							totalresult.add(str);
		  						  }
		  						 }
		  						 List bqkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,8);
		  						 if(bqkbzScoreList.size()>0){
		  							 Object _object = (Object) bqkbzScoreList.get(0);
		  							String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setBqkbzresult(str);
		  							totalresult.add(str);
		  						   }
		  						 }
		  						 List qtScoreList=mgr.getScore_(sid, subjectid, phaseid,9);
		  						 if(qtScoreList.size()>0){
		  							 Object _object = (Object) qtScoreList.get(0);
		  							String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setQtresult(str);
		  							 totalresult.add(str);
		  						  }
		  						 }
		  						 List qtbzScoreList=mgr.getScore_(sid, subjectid, phaseid,10);
		  						 if(qtbzScoreList.size()>0){
		  							Object _object = (Object) qtbzScoreList.get(0);
		  							String str=(String) _object+"";
		  							   if(!str.equals("null") && !(str).matches(regex)){
		  							   str=str.split("-")[0];
		  							 _scoreNew.setQtbzresult(str);
		  							totalresult.add(str);
		  						   }
		  						 }
		  						 if(totalresult.contains("P")){
		  							 _scoreNew.setTotalresult("P");
		  						 }else{
		  							 _scoreNew.setTotalresult("未通过"); 
		  						 }
		  					 
		  				  }
		  					 //记分单元
		  					if(scoretype.equals(3)){
		  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
		  						 if(zkScoreList.size()>0){
		  							 Object _object = (Object) zkScoreList.get(0);
		  							 String str=(String)_object+"";
		  							 String result="";
		  							 if(!str.equals("null") && str.matches(regex)){
		  								double num = Double.valueOf(str);
		  								if(num>=70){
		  									result="A -- "+num;
		  			    				}else if(num>=60){
		  			    					result="B -- "+num;;
		  			    				}else if(num>=50){
		  			    					result="C -- "+num;;
		  			    				}else{
		  			    					result="F -- "+num;;
		  			    				}	
		  								_scoreNew.setTotalresult(result);
		  							 }else if(!str.equals("null") && !str.matches(regex)){
		  								result=str.split("-")[0];
		  								_scoreNew.setTotalresult(result);
		  							 }else{
		  								result=null;
		  							 }
		  							 _scoreNew.setZkresult(result);
		  						  }	 
		  						 List zkbkScoreList=mgr.getScore_(sid, subjectid, phaseid,3);
		  						 if(zkbkScoreList.size()>0){
		  							 Object _object = (Object) zkbkScoreList.get(0);
		  							 String str=(String)_object+"";
		  							 String result="";
		  							 if(!str.equals("null") && str.matches(regex)){
		  								double num = Double.valueOf(str);
		  								if(num>=70){
		  									result="A -- "+num;
		  			    				}else if(num>=60){
		  			    					result="B -- "+num;;
		  			    				}else if(num>=50){
		  			    					result="C -- "+num;;
		  			    				}else{
		  			    					result="F -- "+num;;
		  			    				}
		  								_scoreNew.setTotalresult(result);
		  							 }else if(!str.equals("null") && !str.matches(regex)){
		  								result=str.split("-")[0];
		  								_scoreNew.setTotalresult(result);
		  							 }else{
		  								result=null;
		  							 }
		  							_scoreNew.setZkbkresult(result);
		  						 }
		  						 List bqkScoreList=mgr.getScore_(sid, subjectid, phaseid,7);
		  						 if(bqkScoreList.size()>0){
		  							 Object _object = (Object) bqkScoreList.get(0);
		  							 String str=(String)_object+"";
		  							 String result="";
		  							 if(!str.equals("null") && str.matches(regex)){
		  								double num = Double.valueOf(str);
		  								if(num>=70){
		  									result="A -- "+num;
		  			    				}else if(num>=60){
		  			    					result="B -- "+num;;
		  			    				}else if(num>=50){
		  			    					result="C -- "+num;;
		  			    				}else{
		  			    					result="F -- "+num;;
		  			    				}
		  								_scoreNew.setTotalresult(result);
		  							 }else if(!str.equals("null") && !str.matches(regex)){
		  								result=str.split("-")[0];
		  								_scoreNew.setTotalresult(result);
		  							 }else{
		  								 result=null;
		  							 }
		  							_scoreNew.setBqkresult(result);	
		  						 }
		  						 List qtScoreList=mgr.getScore_(sid, subjectid, phaseid,9);
		  						 if(qtScoreList.size()>0){
		  								Object _object = (Object) qtScoreList.get(0);
		  								 String str=(String)_object+"";
			  							 String result="";
			  							if(!str.equals("null") && str.matches(regex)){
			  								double num = Double.valueOf(str);
			  								if(num>=70){
			  									result="A -- "+num;
			  			    				}else if(num>=60){
			  			    					result="B -- "+num;;
			  			    				}else if(num>=50){
			  			    					result="C -- "+num;;
			  			    				}else{
			  			    					result="F -- "+num;;
			  			    				}
			  								_scoreNew.setTotalresult(result);
			  							 }else if(!str.equals("null") && !str.matches(regex)){
			  								result=str.split("-")[0];
			  								_scoreNew.setTotalresult(result);
			  							 }else{
			  								 result=null;
			  							 }
			  							_scoreNew.setQtresult(result);
		  							}
		  					 }
		  					
		  					 Subject sub=(Subject) this.combiz.get(Subject.class, subjectid);
		  					 String subjectname=sub.getName(); 		  					
		  					 TClass _tclass=(TClass) this.combiz.get(TClass.class, classkey);
		  					 String _classname=_tclass.getName();
		  					 Student student= mgr.getStudentBySid(sid);
		  					 String studentname=student.getName();  
		  					 _scoreNew.setStudentname(studentname);
		  					 String studentid=student.getSid(); 
		  					 _scoreNew.setClassname(_classname);
		  					 _scoreNew.setStudentid(Integer.parseInt(studentid));
		  					 _scoreNew.setSubjectname(subjectname);
		  					 if(phaseid.equals(0)){//Assessment1
		  						 _scoreNew.setPhase("无");
		  					 }
		  					 if(phaseid.equals(1)){//Assessment1
		  						 _scoreNew.setPhase("Assessment1");
		  					 }
		  					 if(phaseid.equals(2)){//Assessment1
		  						 _scoreNew.setPhase("Assessment2");
		  					 }
		  					 if(phaseid.equals(3)){//Assessment1
		  						 _scoreNew.setPhase("Assessment3");
		  					 }
		  					 if(phaseid.equals(4)){//Assessment1
		  						 _scoreNew.setPhase("Assessment4");
		  					 }
		  					 if(phaseid.equals(5)){//Assessment1
		  						 _scoreNew.setPhase("Assessment5");
		  					 }
		  					 
		  					 _list.add(_scoreNew);
		  				
		  					 

		  		      }
				     request.setAttribute("_list", _list);
				     request.setAttribute("subjectlist", subjectlist);
				   }
			        }
	             }
	           }
		   }
			 if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4 || user.getUserType()==5){
					List tclasslist=mgr.getClassList();
					List subjectlist=mgr.getSubjectList();
					JDBCConnection dbcon = new JDBCConnection();
					Connection con=dbcon.openConnection();
		     		CallableStatement sm = con.prepareCall("{CALL dabiao()}"); 
		     		List alllist=new ArrayList();
		     		List rowlist=new ArrayList();
		     	    StringBuffer navCode=new StringBuffer();
		     	    StringBuffer conter=new StringBuffer();
		     		if(sm.execute() && sm.getMoreResults()){
		     			ResultSet rs = sm.getResultSet();
		     			ResultSetMetaData rsmd = rs.getMetaData();
		     			String str1=null;
		     			int totalcount=rsmd.getColumnCount();
		     			List scorelist=new ArrayList();
		     			List list1=null;
		     				while(rs.next()){ 
		     					String _str=null;
		     				    String _subjectid=null;
		     			        String _phaseid=null;
		     					list1=new ArrayList();
		     					for(int i =1; i <= totalcount; i++){ 
		     						String st=rsmd.getColumnTypeName(i);
		     					    str1=rsmd.getColumnName(i);
		     						Object a=rs.getObject(i);
		     						if(str1.equals("subjectid") ||str1.equals("phaseid") || str1.equals("examtype") ||str1.equals("major") || str1.equals("examid") || str1.equals("examdate")|| str1.equals("scoretype")){
		     							continue;
		     						}
		     						if(!rowlist.contains(str1)){
		     							rowlist.add(str1);
		     						}
		     						if(rsmd.getColumnTypeName(i).equals("VARCHAR")){
		     							String st_="^[0-9A-Z]+$";
		     						    String str=rs.getString(str1);
		     			           if(str!=null){
		     						  if(str1.matches(st_)){
		     								String subjectid=((String) str1).split("ZZZ")[0];
		     		 	      				String phaseid=((String) str1).split("ZZZ")[1];
		     		 	      				String c=((String) str1).split("ZZZ")[2];
		     		 	      		 if(subjectid.equals(_subjectid) && phaseid.equals(_phaseid)){
		     		 	      		   list1.add(str);
		   	 	      				continue;
		     		 	      		  }	
		     		 	      	     if(subjectid!=null && phaseid!=null){
		     		 	      			   _subjectid=subjectid;
		     		 	      			   _phaseid=phaseid;
		     		 	      		   }
		 		 	      			  Subject subject=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		 		 	      			  String subjectname=subject.getName();
		     		 	      		     if(c.equals("1")){
		     		 	      		       list1.add(str);
			   	 	      				}
		     							}else{
		     								if(str1.equals("sid")){
		     									Student student=mgr.getStudentBySid_(str);
		     									if(null != student){
		     										String studentname=student.getName();
			     									list1.add(studentname);
			     									list1.add(str);
		     									}
		     									
		     								}
		     								if(str1.equals("classkey")){
		     								 TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(str));
		     								 list1.add(tclass.getName());
		     								}
		     							}
		     					    }else{	 
		     					    	String subjectid=((String) str1).split("ZZZ")[0];
		     					    	String phaseid=((String) str1).split("ZZZ")[1];
		 		 	      				String c=((String) str1).split("ZZZ")[2];
		 		 	      				if(subjectid!=null && c.equals("1")){
		 		 	      					Subject sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		 		 	      					String subname=sub.getName();
		     		 	      		        list1.add("");
		 		 	      				}else{
		 		 	      				    list1.add("");	
		 		 	      				}
		     					     } 
		     					  }		
		     						if(rsmd.getColumnTypeName(i).equals("INTEGER")){
		     							if(str1.equals("classkey")){
		     								int classkey=rs.getInt(str1);
		     								TClass tclass=(TClass) this.combiz.get(TClass.class, classkey);
		     								String classname=tclass.getName();
		     								list1.add(classname);
		     							}
		     						 }
		     					 }
		     					scorelist.add(list1);
		     				  }		
		     			  List _list=new ArrayList();
		     			  String subid=null;
		     			  String phid=null;
		     			 for(int i=0;i<rowlist.size();i++){
		     				 Object str=rowlist.get(i);
		     				// System.out.println("------>"+rowlist.get(i));
		     				 if(str.equals("sid")){
		     					_list.add("姓名");
		     					_list.add("编号");
		     				 }
		     				 if(str.equals("classkey")){
		     					_list.add("班级名称"); 
		     				 }
		     				 String st_="^[0-9A-Z]+$";
		     			    if(((String) str).matches(st_)){
			      				String subjectid=((String) str).split("ZZZ")[0];//
			      				Subject sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
			      				String subname=sub.getName();
			      				String phaseid=((String) str).split("ZZZ")[1];
			      				String c=((String) str).split("ZZZ")[2];
			      				if(subjectid.equals(subid) && phaseid.equals(phid)){
			      					if(c.equals("2")){
			      					 _list.add(subname+"正考-补做");	
			 	      				}
			 	      				if(c.equals("3")){
			 	      				_list.add(subname+"正考-补考");
			 	      				}
			 	      				if(c.equals("4")){
			 	      				_list.add(subname+"正考-补考-补做");
			 	      				}
			 	      				if(c.equals("5")){
			 	      				_list.add(subname+"正考-重修");
			 	      				}
			 	      				if(c.equals("6")){
			 	      				_list.add(subname+"正考-重修-补做");
			 	      				}
			 	      				if(c.equals("7")){
			 	      				_list.add(subname+"毕前考");
			 	      				}
			 	      				if(c.equals("8")){
			 	      				_list.add(subname+"毕前考-补做");
			 	      				}
			 	      				if(c.equals("9")){
			 	      				_list.add(subname+"其他");
			 	      				}
			 	      				if(c.equals("10")){
			 	      				_list.add(subname+"其他-补做");
			 	      				}
			      					continue;
			      				}
			      				if(subjectid!=null && phaseid!=null){
			      					subid=subjectid;
			      					phid=phaseid;
			      					Subject _sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
				      				String _subname=_sub.getName();
			      					//_list.add("科目");
			      					//_list.add("阶段类型");
			      				}
			      				if(c.equals("1")){
			      					_list.add(subname+"正考");
			      				}
			      				if(c.equals("2")){
			      					_list.add(subname+"正考-补做");	
			      				}
			      				if(c.equals("3")){
			      					_list.add(subname+"正考-补考");
			      				}
			      				if(c.equals("4")){
			      					_list.add(subname+"正考-补考-补做");
			      				}
			      				if(c.equals("5")){
			      					_list.add(subname+"正考-重修");
			      				}
			      				if(c.equals("6")){
			      					_list.add(subname+"正考-重修-补做");
			      				}
			      				if(c.equals("7")){
			      					_list.add(subname+"毕前考");
			      				}
			      				if(c.equals("8")){
			      					_list.add(subname+"毕前考-补做");
			      				}
			      				if(c.equals("9")){
			      					_list.add(subname+"其他");
			      				}
			      				if(c.equals("10")){
			      					_list.add(subname+"其他-补做");
			      				}
		     			     }
		     			    }		     			 
		     			 navCode.append("<tr style='font-family:宋体 ;color:black;font-size:15px'>");
		     			 for(int i=0;i<_list.size();i++){  
			     		  if(i<3){
			     			navCode.append("<th class='tab'><strong style='padding:0px 30px; height:40px;padding-top:10px;'>"+_list.get(i)+"</strong></th>");	
			     			}else{
			     			  navCode.append("<th class='tab1'><strong style='width:140px;cursor:pointer;'title='"+_list.get(i)+"'>"+_list.get(i)+"</strong></th>"); 
			     			  }
			     			  }
			     			  navCode.append("</tr>");
			     			  navCode.append("</thead>");
			     		  for(int j=0;j<scorelist.size();j++){
			     				  conter.append("<tr>");
			     				  List list2=(List) scorelist.get(j);
			     				 for(int k=0;k<list2.size();k++){
			     				 conter.append("<td class='conter'>"+list2.get(k)+"</td>");
			     				}
			     				 conter.append("</tr>");
			     			  }   
			     		  }
		     		request.setAttribute("navCode", navCode.toString());
		     		request.setAttribute("conter", conter.toString());
		     		request.setAttribute("tclasslist", tclasslist);
		     		request.setAttribute("subjectlist", subjectlist);
				 
		      }
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 return "toMyExamList";
	}
	/**
	 * 老师查询成绩
	 * @return
	 */
	public String queryclasssubject() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) request.getSession().getAttribute("tuser");
			List scorenewclasskeylist = new ArrayList();
			List tclasslist = new ArrayList();
			List subjectlist = new ArrayList();
			List _list = new ArrayList();
			String name = user.getUser();
			String classId = request.getParameter("classId");
			TClass tclass_ = (TClass) this.combiz.get(TClass.class, Integer
					.parseInt(classId));
			String _subjectname = request.getParameter("subjectName");
			// 如果用户角色是老师
			if (user.getUserType() != null && user.getUserType() == 7) {
				Subject subject = mgr.getSubjectByName(_subjectname);
				Integer _subjectid = null;
				if (null != subject) {
					_subjectid = subject.getId();
				}
				Teacher teacher = mgr.getTeacherByName(name);
				request.setAttribute("subjectlist", subjectlist);
				String cid = "";
				List classname_list = mgr.getKechengListClassByTeacher1_(name);// 老师对应的班级
				if (classname_list != null && classname_list.size() > 0) {
					for (int i = 0; i < classname_list.size(); i++) {
						Object object = classname_list.get(i);
						TClass tclass = new TClass();
						TClass t = mgr.getClassByName((String) object);
						cid += t.getId() + ",";
						tclass.setName((String) object);
						tclasslist.add(t);
					}
					cid = cid.substring(0, cid.length() - 1);
				}
				request.setAttribute("tclasslist", tclasslist);
				//
				List<Integer> subject_list = mgr.getSubjectid_list(cid);
				for (Integer str : subject_list) {
					Subject subject_ = (Subject) this.combiz.get(Subject.class,
							str);
					subjectlist.add(subject_.getName());
				}
				List<Student> student_list = mgr
						.getStudentListByClassnameStatus(tclass_.getName());
				for (Student stu : student_list) {
					String sid = stu.getSid();
					ScoreNew _scoreNew = null;
					List<Object[]> list1 = mgr.getScoreNewBySid(sid);
					for (Object[] object_ : list1) {
						List totalresult = new ArrayList();
						_scoreNew = new ScoreNew();
						Integer subjectid = (Integer) object_[0];
						if (!subjectid.equals(_subjectid)) {
							continue;
						}
						Integer phaseid = (Integer) object_[1];
						Integer scoretype = (Integer) object_[2];
						Integer classkey = (Integer) object_[3];

						String regex = "^[0-9]+([.]{1}[0-9]+){0,1}$";//
						if (scoretype.equals(1)) {
							List zkScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 1);
							if (zkScoreList.size() > 0) {
								Object _object = (Object) zkScoreList.get(0);
								_scoreNew.setZkresult((String) _object);
								_scoreNew.setTotalresult((String) _object);
							}
						}
						// 非百分制
						if (scoretype.equals(2)) {
							List zkScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 1);
							if (zkScoreList.size() > 0) {
								Object _object = (Object) zkScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setZkresult(str);
									totalresult.add(str);

								}
							}
							List zkbzScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 2);
							if (zkbzScoreList.size() > 0) {
								Object _object = (Object) zkbzScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setZkbzresult(str);
									totalresult.add(str);
								}
							}

							List zkbkScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 3);
							if (zkbkScoreList.size() > 0) {
								Object _object = (Object) zkbkScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setZkbkresult(str);
									totalresult.add(str);
								}
							}

							List zkbkbzScoreList = mgr.getScore_(sid,
									subjectid, phaseid, 4);
							if (zkbkbzScoreList.size() > 0) {
								Object _object = (Object) zkbkbzScoreList
										.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setZkbkbzresult(str);
									totalresult.add(str);
								}
							}
							List cxScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 5);
							if (cxScoreList.size() > 0) {
								Object _object = (Object) cxScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setCxresult(str);
									totalresult.add(str);
								}
							}
							List cxbzScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 6);
							if (cxbzScoreList.size() > 0) {
								Object _object = (Object) cxbzScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setCxbzresult(str);
									totalresult.add(str);
								}
							}
							List bqkScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 7);
							if (bqkScoreList.size() > 0) {
								Object _object = (Object) bqkScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setBqkresult(str);
									totalresult.add(str);
								}
							}
							List bqkbzScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 8);
							if (bqkbzScoreList.size() > 0) {
								Object _object = (Object) bqkbzScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setBqkbzresult(str);
									totalresult.add(str);
								}
							}
							List qtScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 9);
							if (qtScoreList.size() > 0) {
								Object _object = (Object) qtScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setQtresult(str);
									totalresult.add(str);
								}
							}
							List qtbzScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 10);
							if (qtbzScoreList.size() > 0) {
								Object _object = (Object) qtbzScoreList.get(0);
								String str = (String) _object + "";
								if (!str.equals("null")
										&& !(str).matches(regex)) {
									str = str.split("-")[0];
									_scoreNew.setQtbzresult(str);
									totalresult.add(str);
								}
							}
							if (totalresult.contains("P")) {
								_scoreNew.setTotalresult("P");
							} else {
								_scoreNew.setTotalresult("未通过");
							}

						}
						// 记分单元
						if (scoretype.equals(3)) {
							List zkScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 1);
							if (zkScoreList.size() > 0) {
								Object _object = (Object) zkScoreList.get(0);
								String str = (String) _object + "";
								String result = "";
								if (!str.equals("null") && str.matches(regex)) {
									double num = Double.valueOf(str);
									if (num >= 70) {
										result = "A -- " + num;
									} else if (num >= 60) {
										result = "B -- " + num;
										;
									} else if (num >= 50) {
										result = "C -- " + num;
										;
									} else {
										result = "F -- " + num;
										;
									}
									_scoreNew.setTotalresult(result);
								} else if (!str.equals("null")
										&& !str.matches(regex)) {
									result = str.split("-")[0];
									_scoreNew.setTotalresult(result);
								} else {
									result = null;
								}
								_scoreNew.setZkresult(result);
							}
							List zkbkScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 3);
							if (zkbkScoreList.size() > 0) {
								Object _object = (Object) zkbkScoreList.get(0);
								String str = (String) _object + "";
								String result = "";
								if (!str.equals("null") && str.matches(regex)) {
									double num = Double.valueOf(str);
									if (num >= 70) {
										result = "A -- " + num;
									} else if (num >= 60) {
										result = "B -- " + num;
										;
									} else if (num >= 50) {
										result = "C -- " + num;
										;
									} else {
										result = "F -- " + num;
										;
									}
									_scoreNew.setTotalresult(result);
								} else if (!str.equals("null")
										&& !str.matches(regex)) {
									result = str.split("-")[0];
									_scoreNew.setTotalresult(result);
								} else {
									result = null;
								}
								_scoreNew.setZkbkresult(result);
							}
							List bqkScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 7);
							if (bqkScoreList.size() > 0) {
								Object _object = (Object) bqkScoreList.get(0);
								String str = (String) _object + "";
								String result = "";
								if (!str.equals("null") && str.matches(regex)) {
									double num = Double.valueOf(str);
									if (num >= 70) {
										result = "A -- " + num;
									} else if (num >= 60) {
										result = "B -- " + num;
										;
									} else if (num >= 50) {
										result = "C -- " + num;
										;
									} else {
										result = "F -- " + num;
										;
									}
									_scoreNew.setTotalresult(result);
								} else if (!str.equals("null")
										&& !str.matches(regex)) {
									result = str.split("-")[0];
									_scoreNew.setTotalresult(result);
								} else {
									result = null;
								}
								_scoreNew.setBqkresult(result);
							}
							List qtScoreList = mgr.getScore_(sid, subjectid,
									phaseid, 9);
							if (qtScoreList.size() > 0) {
								Object _object = (Object) qtScoreList.get(0);
								String str = (String) _object + "";
								String result = "";
								if (!str.equals("null") && str.matches(regex)) {
									double num = Double.valueOf(str);
									if (num >= 70) {
										result = "A -- " + num;
									} else if (num >= 60) {
										result = "B -- " + num;
										;
									} else if (num >= 50) {
										result = "C -- " + num;
										;
									} else {
										result = "F -- " + num;
										;
									}
									_scoreNew.setTotalresult(result);
								} else if (!str.equals("null")
										&& !str.matches(regex)) {
									result = str.split("-")[0];
									_scoreNew.setTotalresult(result);
								} else {
									result = null;
								}
								_scoreNew.setQtresult(result);
							}
						}

						Subject sub = (Subject) this.combiz.get(Subject.class,
								subjectid);
						String subjectname = sub.getName();

						TClass _tclass = (TClass) this.combiz.get(TClass.class,
								classkey);
						String classname = _tclass.getName();
						Student student = mgr.getStudentBySid(sid);
						String studentname = student.getName();
						_scoreNew.setStudentname(studentname);
						// Integer studentid=student.getId();
						String studentsid = student.getSid();
						_scoreNew.setClassname(classname);
						_scoreNew.setStudentid(Integer.parseInt(studentsid));
						_scoreNew.setSubjectname(subjectname);
						if (phaseid.equals(0)) {
							_scoreNew.setPhase("无");
						}
						if (phaseid.equals(1)) {
							_scoreNew.setPhase("Assessment1");
						}
						if (phaseid.equals(2)) {
							_scoreNew.setPhase("Assessment2");
						}
						if (phaseid.equals(3)) {
							_scoreNew.setPhase("Assessment3");
						}
						if (phaseid.equals(4)) {
							_scoreNew.setPhase("Assessment4");
						}
						if (phaseid.equals(5)) {
							_scoreNew.setPhase("Assessment5");
						}
						_list.add(_scoreNew);
					}
					request.setAttribute("_list", _list);
					request.setAttribute("tcl", tclass_.getId());
					request.setAttribute("sb", _subjectname);
				}
			} 
			//如果操作用户角色不是老师
			
			else {
				String subject_id = request.getParameter("subjectName");
				Subject su = mgr.getSubjectByName(subject_id);
				List tclasslist_ = mgr.getClassList();
				List subjectlist_ = mgr.getSubjectList();
				JDBCConnection dbcon = new JDBCConnection();
				Connection con = dbcon.openConnection();
				// CallableStatement sm = con.prepareCall("{CALL dabiao()}");
				CallableStatement sm = con
						.prepareCall("{CALL dabiaoclassid_subjectid("
								+ tclass_.getId() + "," + su.getId() + ")}");
				List alllist = new ArrayList();
				List rowlist = new ArrayList();
				StringBuffer navCode = new StringBuffer();
				StringBuffer conter = new StringBuffer();
				if (sm.execute() && sm.getMoreResults()) {
					ResultSet rs = sm.getResultSet();
					ResultSetMetaData rsmd = rs.getMetaData();
					String str1 = null;
					int totalcount = rsmd.getColumnCount();
					List scorelist = new ArrayList();
					List list1 = null;
					while (rs.next()) {
						String _str = null;
						String _subjectid = null;
						String _phaseid = null;
						list1 = new ArrayList();
						for (int i = 1; i <= totalcount; i++) {
							String st = rsmd.getColumnTypeName(i);
							str1 = rsmd.getColumnName(i);
							Object a = rs.getObject(i);
							if (str1.equals("subjectid")
									|| str1.equals("phaseid")
									|| str1.equals("examtype")
									|| str1.equals("major")
									|| str1.equals("examid")
									|| str1.equals("examdate")
									|| str1.equals("scoretype")) {
								continue;
							}
							if (!rowlist.contains(str1)) {
								rowlist.add(str1);
							}
							if (rsmd.getColumnTypeName(i).equals("VARCHAR")) {
								String st_ = "^[0-9A-Z]+$";
								String str = rs.getString(str1);
								if (str != null) {
									if (str1.matches(st_)) {
										String subjectid = ((String) str1)
												.split("ZZZ")[0];
										String phaseid = ((String) str1)
												.split("ZZZ")[1];
										String c = ((String) str1).split("ZZZ")[2];
										if (subjectid.equals(_subjectid)
												&& phaseid.equals(_phaseid)) {
											list1.add(str);
											continue;
										}
										if (subjectid != null
												&& phaseid != null) {
											_subjectid = subjectid;
											_phaseid = phaseid;
										}
										Subject subject = (Subject) this.combiz
												.get(Subject.class, Integer
														.parseInt(subjectid));
										String subjectname = subject.getName();
										if (c.equals("1")) {
											list1.add(str);
										}
									} else {
										if (str1.equals("sid")) {
											Student student = mgr
													.getStudentBySid_(str);
											if (null != student) {
												String studentname = student
														.getName();
												list1.add(studentname);
												list1.add(str);
											}

										}
										if (str1.equals("classkey")) {
											TClass tclass = (TClass) this.combiz
													.get(TClass.class, Integer
															.parseInt(str));
											list1.add(tclass.getName());
										}
									}
								} else {
									String subjectid = ((String) str1)
											.split("ZZZ")[0];
									String phaseid = ((String) str1)
											.split("ZZZ")[1];
									String c = ((String) str1).split("ZZZ")[2];
									if (subjectid != null && c.equals("1")) {
										Subject sub = (Subject) this.combiz
												.get(Subject.class, Integer
														.parseInt(subjectid));
										String subname = sub.getName();
										list1.add("");
									} else {
										list1.add("");
									}
								}
							}
							if (rsmd.getColumnTypeName(i).equals("INTEGER")) {
								if (str1.equals("classkey")) {
									int classkey = rs.getInt(str1);
									TClass tclass = (TClass) this.combiz.get(
											TClass.class, classkey);
									String classname = tclass.getName();
									list1.add(classname);
								}
							}
						}
						scorelist.add(list1);
					}
					List list_ = new ArrayList();
					String subid = null;
					String phid = null;
					for (int i = 0; i < rowlist.size(); i++) {
						Object str = rowlist.get(i);
						// System.out.println("------>"+rowlist.get(i));
						if (str.equals("sid")) {
							list_.add("姓名");
							list_.add("编号");
						}
						if (str.equals("classkey")) {
							list_.add("班级名称");
						}
						String st_ = "^[0-9A-Z]+$";
						if (((String) str).matches(st_)) {
							String subjectid = ((String) str).split("ZZZ")[0];//
							Subject sub = (Subject) this.combiz.get(
									Subject.class, Integer.parseInt(subjectid));
							String subname = sub.getName();
							String phaseid = ((String) str).split("ZZZ")[1];
							String c = ((String) str).split("ZZZ")[2];
							if (subjectid.equals(subid) && phaseid.equals(phid)) {
								//考试名称中加上阶段
								if (phaseid.equals("0")) {
									subname = subname + "无阶段";
								}
								if (phaseid.equals("1")) {
									subname = subname + "阶段1";
								}
								if (phaseid.equals("2")) {
									subname = subname + "阶段2";
								}
								if (phaseid.equals("3")) {
									subname = subname + "阶段3";
								}
								if (phaseid.equals("4")) {
									subname = subname + "阶段4";
								}
								if (phaseid.equals("5")) {
									subname = subname + "阶段5";
								}
								
								//考试名称中加上考试类型
								if (c.equals("2")) {
									list_.add(subname + "正考-补做");
								}
								if (c.equals("3")) {
									list_.add(subname + "正考-补考");
								}
								if (c.equals("4")) {
									list_.add(subname + "正考-补考-补做");
								}
								if (c.equals("5")) {
									list_.add(subname + "正考-重修");
								}
								if (c.equals("6")) {
									list_.add(subname + "正考-重修-补做");
								}
								if (c.equals("7")) {
									list_.add(subname + "毕前考");
								}
								if (c.equals("8")) {
									list_.add(subname + "毕前考-补做");
								}
								if (c.equals("9")) {
									list_.add(subname + "其他");
								}
								if (c.equals("10")) {
									list_.add(subname + "其他-补做");
								}
								continue;
							}
							if (subjectid != null && phaseid != null) {
								subid = subjectid;
								phid = phaseid;
								Subject _sub = (Subject) this.combiz.get(
										Subject.class, Integer
												.parseInt(subjectid));
								String _subname = _sub.getName();
								// _list.add("科目");
								// _list.add("阶段类型");
							}
							
							//考试名称中加上阶段
							if (phaseid.equals("0")) {
								subname = subname + "无阶段";
							}
							if (phaseid.equals("1")) {
								subname = subname + "阶段1";
							}
							if (phaseid.equals("2")) {
								subname = subname + "阶段2";
							}
							if (phaseid.equals("3")) {
								subname = subname + "阶段3";
							}
							if (phaseid.equals("4")) {
								subname = subname + "阶段4";
							}
							if (phaseid.equals("5")) {
								subname = subname + "阶段5";
							}
							
							if (c.equals("1")) {
								list_.add(subname + "正考");
							}
							if (c.equals("2")) {
								list_.add(subname + "正考-补做");
							}
							if (c.equals("3")) {
								list_.add(subname + "正考-补考");
							}
							if (c.equals("4")) {
								list_.add(subname + "正考-补考-补做");
							}
							if (c.equals("5")) {
								list_.add(subname + "正考-重修");
							}
							if (c.equals("6")) {
								list_.add(subname + "正考-重修-补做");
							}
							if (c.equals("7")) {
								list_.add(subname + "毕前考");
							}
							if (c.equals("8")) {
								list_.add(subname + "毕前考-补做");
							}
							if (c.equals("9")) {
								list_.add(subname + "其他");
							}
							if (c.equals("10")) {
								list_.add(subname + "其他-补做");
							}
						}
					}
					navCode
							.append("<tr style='font-family:宋体 ;color:black;font-size:15px'>");
					for (int i = 0; i < list_.size(); i++) {
						if (i < 3) {
							navCode
									.append("<th class='tab'><strong style='padding:0px 30px; height:40px;padding-top:10px;'>"
											+ list_.get(i) + "</strong></th>");
						} else {
							navCode
									.append("<th class='tab1'><strong style='width:140px;cursor:pointer;'title='"
											+ list_.get(i)
											+ "'>"
											+ list_.get(i) + "</strong></th>");
						}
					}
					navCode.append("</tr>");
					navCode.append("</thead>");
					for (int j = 0; j < scorelist.size(); j++) {
						conter.append("<tr>");
						List list2 = (List) scorelist.get(j);
						for (int k = 0; k < list2.size(); k++) {
							conter.append("<td class='conter'>" + list2.get(k)
									+ "</td>");
						}
						conter.append("</tr>");
					}
				}
				request.setAttribute("navCode", navCode.toString());
				request.setAttribute("conter", conter.toString());
				request.setAttribute("tclasslist", tclasslist_);
				request.setAttribute("subjectlist", subjectlist_);
				request.setAttribute("sb", subject_id);
				request.setAttribute("tcl", tclass_.getId());

			}

			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "queryclasssubject";
	}
	///
   public String checkstudentscore(){
	  try {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   User user=(User) request.getSession().getAttribute("tuser");
		   List _list=new ArrayList();
		   String studentsid=null;
			if(user.getUserType()!=null && user.getUserType()==6){
			    studentsid=request.getParameter("studentid");	
				ScoreNew scorenew=new ScoreNew();
			    List<Object[]> list1=mgr.getScoreNewBySid(studentsid);
				 for(Object[] object_ : list1){
					 scorenew=new ScoreNew();
					 Integer subjectid= (Integer) object_[0];
					 Integer phaseid=(Integer) object_[1];
					 Integer scoretype=(Integer) object_[2];
					 Integer classkey=(Integer) object_[3];					
					 if(scoretype.equals(1)){
	  						List zkScoreList=mgr.getscore(studentsid, subjectid, phaseid,1);
	  						 if(zkScoreList.size()>0){
	  							 Object object[] = (Object[]) zkScoreList.get(0);
								 scorenew.setZkresult((String)object[0]);
								 scorenew.setTitle((String)object[1]);
	  							 }	  
	  					 }
	  					 if(scoretype.equals(2)){
	  						 List zkScoreList=mgr.getscore(studentsid, subjectid, phaseid,1);
	  						 if(zkScoreList.size()>0){
	  							Object object[] = (Object[]) zkScoreList.get(0);
	  							Object object1=zkScoreList.get(0);
	  							String str=(String)object[0]+"";
	  							String result="";
	  							String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setZkresult(result);
	  								scorenew.setTitle((String)object[1]);
	  							}
	  						  }
	  						 List zkbzScoreList=mgr.getscore(studentsid, subjectid, phaseid,2);
	  						   if(zkbzScoreList.size()>0){
	  							 Object object[] = (Object[]) zkbzScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setZkbzresult(result); 
	  							  }
	  						     }		  							   
	  						  
	  						 List zkbkScoreList=mgr.getscore(studentsid, subjectid, phaseid,3);
	  						 if(zkbkScoreList.size()>0){
	  							 Object object[] = (Object[]) zkbkScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setZkbkresult(result);
	  							  }
	  						   }
	
	  						 List zkbkbzScoreList=mgr.getscore(studentsid, subjectid, phaseid,4);
	  						 if(zkbkbzScoreList.size()>0){
	  							 Object object[] = (Object[]) zkbkbzScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setZkbkbzresult(result);
	  							  }
	  						  }
	  						 List cxScoreList=mgr.getscore(studentsid, subjectid, phaseid,5);
	  						 if(cxScoreList.size()>0){
	  							 Object object[] = (Object[]) cxScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setCxresult(result);
	  							  }
	  						 }
	  						 List  cxbzScoreList=mgr.getscore(studentsid, subjectid, phaseid,6);
	  						 if(cxbzScoreList.size()>0){
	  							 Object object[] = (Object[]) cxbzScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setCxbzresult(result);
	  							  }
	  						 }
	  						 List  bqkScoreList=mgr.getscore(studentsid, subjectid, phaseid,7);
	  						 if(bqkScoreList.size()>0){
	  							 Object object[] = (Object[]) bqkScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setBqkresult(result);
	  							  }
	  						 }
	  						 List bqkbzScoreList=mgr.getscore(studentsid, subjectid, phaseid,8);
	  						 if(bqkbzScoreList.size()>0){
	  							 Object object[] = (Object[]) bqkbzScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setBqkbzresult(result);
	  							  }
	  						 }
	  						 List qtScoreList=mgr.getscore(studentsid, subjectid, phaseid,9);
	  						 if(qtScoreList.size()>0){
	  							 Object object[] = (Object[]) qtScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setQtresult(result);
	  							  }
	  						  }
	  						 List qtbzScoreList=mgr.getscore(studentsid, subjectid, phaseid,10);
	  						 if(qtbzScoreList.size()>0){
	  							 Object object[] = (Object[]) qtbzScoreList.get(0);
	  							 String str=(String)object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  								scorenew.setQtbzresult(result);
	  							  }
	  						 }  
		  				  } 
	  					 if(scoretype.equals(3)){
	  						List zkScoreList=mgr.getscore(studentsid, subjectid, phaseid,1);
	  						 if(zkScoreList.size()>0){
	  							 Object object[] = (Object[]) zkScoreList.get(0);
	  							 String str=(String) object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							 if(!str.equals("null") && str.matches(regex)){
	  								double num = Double.valueOf(str);
	  								if(num>=70){
	  									result="A";
	  			    				}else if(num>=60){
	  			    					result="B";
	  			    				}else if(num>=50){
	  			    					result="C";
	  			    				}else{
	  			    					result="F";
	  			    				}	
	  							 }else if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  							 }
								 scorenew.setZkresult(result);
								 scorenew.setTitle((String)object[1]);
	  							 }	 
	  						 List zkbkScoreList=mgr.getscore(studentsid, subjectid, phaseid,3);
	  						 if(zkbkScoreList.size()>0){
	  							Object object[] = (Object[]) zkbkScoreList.get(0);
	  							 String str=(String) object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							 if(!str.equals("null") && str.matches(regex)){
	  								double num = Double.valueOf(str);
	  								if(num>=70){
	  									result="A";
	  			    				}else if(num>=60){
	  			    					result="B";
	  			    				}else if(num>=50){
	  			    					result="C";
	  			    				}else{
	  			    					result="F";
	  			    				}	
	  							 }else if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  							 }
	  							scorenew.setZkbkresult(result);
	  						 }
	  						 List bqkScoreList=mgr.getscore(studentsid, subjectid, phaseid,7);
	  						 if(bqkScoreList.size()>0){
	  							Object object[] = (Object[]) bqkScoreList.get(0);
	  							 String str=(String) object[0]+"";
	  							 String result="";
	  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
	  							 if(!str.equals("null") && str.matches(regex)){
	  								double num = Double.valueOf(str);
	  								if(num>=70){
	  									result="A";
	  			    				}else if(num>=60){
	  			    					result="B";
	  			    				}else if(num>=50){
	  			    					result="C";
	  			    				}else{
	  			    					result="F";
	  			    				}	
	  							 }else if(!str.equals("null") && !str.matches(regex)){
	  								result=str.split("-")[0];
	  							 }
	  							scorenew.setBqkresult(result);
	  						 }
	  						 List qtScoreList=mgr.getscore(studentsid, subjectid, phaseid,9);
	  						 if(qtScoreList.size()>0){
	  								Object object[] = (Object[]) qtScoreList.get(0);
	  								 String str=(String) object[0]+"";
		  							 String result="";
		  							 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//匹配数
		  							 if(!str.equals("null") && str.matches(regex)){
		  								double num = Double.valueOf(str);
		  								if(num>=70){
		  									result="A";
		  			    				}else if(num>=60){
		  			    					result="B";
		  			    				}else if(num>=50){
		  			    					result="C";
		  			    				}else{
		  			    					result="F";
		  			    				}	
		  							 }else if(!str.equals("null") && !str.matches(regex)){
		  								result=str.split("-")[0];
		  							 }
	  								scorenew.setQtresult(result);
	  							}
	  					 }
					 Subject sub=(Subject) this.combiz.get(Subject.class, subjectid);
					 String subjectname=sub.getName();
					 TClass _tclass=(TClass) this.combiz.get(TClass.class, classkey);
					 String classname=_tclass.getName();
					 Student student= mgr.getStudentBySid(studentsid);
					 String studentname=student.getName();  
					 scorenew.setStudentname(studentname);
					 Integer studentid=student.getId(); 
					 scorenew.setClassname(classname);
					 scorenew.setStudentid(studentid);
					 scorenew.setSubjectname(subjectname);
					 if(phaseid.equals(0)){
						 scorenew.setPhase("无");
					 }
					 if(phaseid.equals(1)){
						 scorenew.setPhase("Assessment1");
					 }
					 if(phaseid.equals(2)){
						 scorenew.setPhase("Assessment2");
					 }
					 if(phaseid.equals(3)){
						 scorenew.setPhase("Assessment3");
					 }
					 if(phaseid.equals(4)){
						 scorenew.setPhase("Assessment4");
					 }
					 if(phaseid.equals(5)){
						 scorenew.setPhase("Assessment5");
					 }
					  _list.add(scorenew);
					 
				   }
				    request.setAttribute("_list", _list);
			    }
	           }catch (Exception e) {
				e.printStackTrace();
			}
	  
		  return "checkstudentscore";
	    }
   /**辅导员查看本班的成绩表
    * 
    * @return
    */
   public String checkclassscore(){ 
  	 HttpServletRequest request=ServletActionContext.getRequest();
  	 User user=(User) request.getSession().getAttribute("tuser");
  	 String tclassid=request.getParameter("classId");
  	 JDBCConnection dbcon = new JDBCConnection();
  	 try {
     		Connection con=dbcon.openConnection();
     		CallableStatement sm = con.prepareCall("{CALL dabiaoclass("+tclassid+")}");
     		List alllist=new ArrayList();
     		List rowlist=new ArrayList();
     	    StringBuffer navCode=new StringBuffer();
     	    StringBuffer conter=new StringBuffer();
     	    StringBuffer colgroup=new StringBuffer();
     		if(sm.execute() && sm.getMoreResults()){
     			ResultSet rs = sm.getResultSet();
     			ResultSetMetaData rsmd = rs.getMetaData();
     			String str1=null;
     			int totalcount=rsmd.getColumnCount();
     			List scorelist=new ArrayList();
     			List list=null;
     				while(rs.next()){ 
     					String _str=null;
     				    String _subjectid=null;
     			        String _phaseid=null;
     					list=new ArrayList();
     					for(int i =1; i <= totalcount; i++){ 
     						String st=rsmd.getColumnTypeName(i);
     					    str1=rsmd.getColumnName(i);
     						Object a=rs.getObject(i);
     						if(str1.equals("subjectid") ||str1.equals("phaseid") || str1.equals("examtype") ||str1.equals("major") || str1.equals("examid") || str1.equals("examdate")|| str1.equals("scoretype")){
     							continue;
     						}
     						if(!rowlist.contains(str1)){
     							rowlist.add(str1);
     						}
     						if(rsmd.getColumnTypeName(i).equals("VARCHAR")){
     							String st_="^[0-9A-Z]+$";
     						    String str=rs.getString(str1);
     			           if(str!=null){
     						  if(str1.matches(st_)){
     								String subjectid=((String) str1).split("ZZZ")[0];
     		 	      				String phaseid=((String) str1).split("ZZZ")[1];
     		 	      				String c=((String) str1).split("ZZZ")[2];
		     		 	      		 if(subjectid.equals(_subjectid) && phaseid.equals(_phaseid)){
		     		 	      		   list.add(str);
		   	 	      				continue;
		     		 	      		  }	
		     		 	      	     if(subjectid!=null && phaseid!=null){
		     		 	      			   _subjectid=subjectid;
		     		 	      			   _phaseid=phaseid;
		     		 	      		   }
		 		 	      			  Subject subject=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		 		 	      			  String subjectname=subject.getName();
		     		 	      		     if(c.equals("1")){
		     		 	      		       list.add(str);
			   	 	      				}
     		 	      			   
     							}else{
     								if(str1.equals("sid")){
     									Student student=mgr.getStudentBySid(str);
     									String studentname = "";
     									if(null == student){
     										studentname = "";
     									}else{
     										studentname = student.getName();
     									}
     									
     									list.add(studentname);
     									list.add(str);
     								}
     								if(str1.equals("classkey")){
     								 TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(str));
     								 list.add(tclass.getName());
     								}
     							}
     					    }else{	 
     					    	String subjectid=((String) str1).split("ZZZ")[0];
     					    	String phaseid=((String) str1).split("ZZZ")[1];
 		 	      				String c=((String) str1).split("ZZZ")[2];
 		 	      				if(subjectid!=null && c.equals("1")){
 		 	      					Subject sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
 		 	      					String subname=sub.getName();
     		 	      		        list.add("");
 		 	      				}else{
 		 	      				    list.add("");	
 		 	      				}
     					     } 
     					  }		
     						if(rsmd.getColumnTypeName(i).equals("INTEGER")){
     							if(str1.equals("classkey")){
     								int classkey=rs.getInt(str1);
     								TClass tclass=(TClass) this.combiz.get(TClass.class, classkey);
     								String classname=tclass.getName();
     								list.add(classname);
     							}
     						 }
     					 }
     					scorelist.add(list);
     				  }		
     			  List _list=new ArrayList();
     			  String subid=null;
     			  String phid=null;
     			 for(int i=0;i<rowlist.size();i++){
     				 Object str=rowlist.get(i);
     				 if(str.equals("sid")){
     					_list.add("姓名");
     					_list.add("编号");
     				 }
     				 if(str.equals("classkey")){
     					_list.add("班级名称"); 
     				 }
     				 String st_="^[0-9A-Z]+$";
     			    if(((String) str).matches(st_)){
	      				String subjectid=((String) str).split("ZZZ")[0];//
	      				Subject sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
	      				String subname=sub.getName();
	      				String phaseid=((String) str).split("ZZZ")[1];
	      				String c=((String) str).split("ZZZ")[2];
	      				if(subjectid.equals(subid) && phaseid.equals(phid)){
	      					if(c.equals("2")){
	      					 _list.add(subname+"正考-补做");	
	 	      				}
	 	      				if(c.equals("3")){
	 	      				_list.add(subname+"正考-补考");
	 	      				}
	 	      				if(c.equals("4")){
	 	      				_list.add(subname+"正考-补考-补做");
	 	      				}
	 	      				if(c.equals("5")){
	 	      				_list.add(subname+"正考-重修");
	 	      				}
	 	      				if(c.equals("6")){
	 	      				_list.add(subname+"正考-重修-补做");
	 	      				}
	 	      				if(c.equals("7")){
	 	      				_list.add(subname+"毕前考");
	 	      				}
	 	      				if(c.equals("8")){
	 	      				_list.add(subname+"毕前考-补做");
	 	      				}
	 	      				if(c.equals("9")){
	 	      				_list.add(subname+"其他");
	 	      				}
	 	      				if(c.equals("10")){
	 	      				_list.add(subname+"其他-补做");
	 	      				}
	      					continue;
	      				}
	      				if(subjectid!=null && phaseid!=null){
	      					subid=subjectid;
	      					phid=phaseid;
	      					Subject _sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		      				String _subname=_sub.getName();
	      					//_list.add("科目");
	      					//_list.add("阶段类型");
	      				}
	      				if(c.equals("1")){
	      					_list.add(subname+"正考");
	      				}
	      				if(c.equals("2")){
	      					_list.add(subname+"正考-补做");	
	      				}
	      				if(c.equals("3")){
	      					_list.add(subname+"正考-补考");
	      				}
	      				if(c.equals("4")){
	      					_list.add(subname+"正考-补考-补做");
	      				}
	      				if(c.equals("5")){
	      					_list.add(subname+"正考-重修");
	      				}
	      				if(c.equals("6")){
	      					_list.add(subname+"正考-重修-补做");
	      				}
	      				if(c.equals("7")){
	      					_list.add(subname+"毕前考");
	      				}
	      				if(c.equals("8")){
	      					_list.add(subname+"毕前考-补做");
	      				}
	      				if(c.equals("9")){
	      					_list.add(subname+"其他");
	      				}
	      				if(c.equals("10")){
	      					_list.add(subname+"其他-补做");
	      				}
     			     }
     			    }
     			    navCode.append("<thead>");
     			    navCode.append("<tr style='font-family:宋体 ;color:black;font-size:15px'>");
     			    for(int i=0;i<_list.size();i++){  
     				if(i<3){
     					navCode.append("<th class='tab'><strong style='padding:0px 30px; height:40px;padding-top:10px;'>"+_list.get(i)+"</strong></th>");	
     				 }else{
     					navCode.append("<th class='tab1'><strong style='width:140px;cursor:pointer;'title='"+_list.get(i)+"'>"+_list.get(i)+"</strong></th>"); 
     				 }
     			   }
     			    navCode.append("</tr>");
     			    navCode.append("</thead>");
     			  for(int j=0;j<scorelist.size();j++){
     				//  System.out.println(scorelist.get(j));
     				  conter.append("<tr>");
     				  List list1=(List) scorelist.get(j);
     				 for(int k=0;k<list1.size();k++){
     				 conter.append("<td class='conter'>"+list1.get(k)+"</td>");
     				}
     				 conter.append("</tr>");
     			  }   
     		  }
     		request.setAttribute("navCode", navCode.toString());
     		request.setAttribute("conter", conter.toString());
     		request.setAttribute("tclassid", tclassid);
     		//request.setAttribute("colgroup", colgroup.toString());
     	} catch (Exception e) {
     		e.printStackTrace();
     	}
     	 dbcon.closeConnection();
     	 return "checkclassscore";
     }
   /**
    * 辅导员导出班级
    * @return
    * @throws IOException
    */
  public String exportexcelscore() throws IOException{
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpSession session=request.getSession();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  PrintWriter out=response.getWriter();
	  response.setContentType("text/html;charset=utf-8");
	  User user=(User)request.getSession().getAttribute("tuser");
	  try {			
	  List<ScoreNew> scorenewList=null;
	  ScoreNew scorenew=null;
	  if(user.getUserType()!=null && user.getUserType()==6){
		  id=request.getParameter("classid");
		  title=request.getParameter("title");
			List scoreList= mgr.getScoreNewByClassidTitle(Integer.parseInt(id),title);
			if(scoreList!=null && scoreList.size()>0){	
				scorenewList=new ArrayList<ScoreNew>();
				for(int i=0;i<scoreList.size();i++){
					scorenew=new ScoreNew();
					 Object object[] = (Object[]) scoreList.get(i);
					 List<Student> student=mgr.getStudentList((String) object[2]);
						for (Student stu : student) {
							String studentname=stu.getName();
							Integer studentId=stu.getId();
							scorenew.setStudentid(studentId);
							scorenew.setStudentname(studentname);
						}
					 scorenew.setTitle((String) object[0]);
					 TClass tClass=(TClass) this.combiz.get(TClass.class,(Integer) object[3]);
					 String classname=tClass.getName();
					 Subject subject=(Subject) this.combiz.get(Subject.class, (Integer) object[4]);
					 String subjectname=subject.getName();
					 scorenew.setClassname(classname);
					 scorenew.setSubjectname(subjectname);
					 if((Integer) object[5]==0){
						scorenew.setPhase("无"); 
					 }
					 if((Integer) object[5]==1){
						 scorenew.setPhase("Assessment1"); 
					 }
					 if((Integer) object[5]==2){
						 scorenew.setPhase("Assessment2"); 
					 }
					 if((Integer) object[5]==3){
						 scorenew.setPhase("Assessment3"); 
					 }
					 if((Integer) object[5]==4){
						 scorenew.setPhase("Assessment4"); 
					 }
					 if((Integer) object[5]==5){
						 scorenew.setPhase("Assessment5"); 
					 }
					 //考试类型 1正考 2正考—补做 3正考-补考 4正考-补考-补做 5正考-重修 6正考-重修-补做 7毕业前考 8毕前考-补做 9其它 10其它-补做
					 if((Integer) object[6]==1){
						 scorenew.setExam("正考"); 
					 }
					 if((Integer) object[6]==2){
						 scorenew.setExam("正考—补做"); 
					 }
					 if((Integer) object[6]==3){
						 scorenew.setExam("正考-补考"); 
					 }
					 if((Integer) object[6]==4){
						 scorenew.setExam("正考-补考-补做"); 
					 }
					 if((Integer) object[6]==5){
						 scorenew.setExam("正考-重修"); 
					 }
					 if((Integer) object[6]==6){
						 scorenew.setExam("正考-重修-补做"); 
					 }
					 if((Integer) object[6]==7){
						 scorenew.setExam("毕业前考"); 
					 }
					 if((Integer) object[6]==8){
						 scorenew.setExam("毕前考-补做"); 
					 }
					 if((Integer) object[6]==9){
						 scorenew.setExam("其它"); 
					 }
					 if((Integer) object[6]==10){
						 scorenew.setExam("其它-补做"); 
					 }
					 String str=((String) object[7]).split("-")[0];
					 scorenew.setResult(str);
					 scorenewList.add(scorenew);
				   }
			  }else{
			   out.print("{bol:false,message:'"+URLEncoder.encode("没有数据要导出","UTF-8")+"'}");		
			   return null;
			  }	
			request.setAttribute("id", id);
			request.setAttribute("title", title);
			String message=new ExcelUtil2007().buildXSLXExcel1(scorenewList);
			if(message.equals("false")){				
				out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
			}else{
				out.print("{bol:true,message:'"+URLEncoder.encode(message,"UTF-8")+"'}");
			 }
			out.flush();
			out.close();
	      }
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
		}
	  return null;
  }
  /**
   * 辅导员导出本班的成绩表
   * @return
   * @throws IOException
   */
  public String exportexcelclassresult()throws IOException{
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/html;charset=utf-8");
	  HttpSession session=request.getSession();
	  User user=(User) request.getSession().getAttribute("tuser");
	  JDBCConnection dbcon = new JDBCConnection();
	  PrintWriter out=response.getWriter();
	  response.setContentType("text/html;charset=utf-8");
	  String tclassid=request.getParameter("tclassid");
	  System.out.println("tclassid------>"+tclassid);
	  List _list=new ArrayList();
	  List list=null;
	  List scorelist=null;
	  	 try {
	     		Connection con=dbcon.openConnection();
	     		CallableStatement sm = con.prepareCall("{CALL dabiaoclass("+tclassid+")}");
	     		List alllist=new ArrayList();
	     		List rowlist=new ArrayList();
	     	    StringBuffer navCode=new StringBuffer();
	     	    StringBuffer conter=new StringBuffer();
	     	    StringBuffer colgroup=new StringBuffer();
	     		if(sm.execute() && sm.getMoreResults()){
	     			ResultSet rs = sm.getResultSet();
	     			ResultSetMetaData rsmd = rs.getMetaData();
	     			String str1=null;
	     			int totalcount=rsmd.getColumnCount();
	     		    scorelist=new ArrayList();
	     				while(rs.next()){ 
	     					String _str=null;
	     				    String _subjectid=null;
	     			        String _phaseid=null;
	     					list=new ArrayList();
	     					for(int i =1; i <= totalcount; i++){ 
	     						String st=rsmd.getColumnTypeName(i);
	     					    str1=rsmd.getColumnName(i);
	     						Object a=rs.getObject(i);
	     						if(str1.equals("subjectid") ||str1.equals("phaseid") || str1.equals("examtype") ||str1.equals("major") || str1.equals("examid") || str1.equals("examdate")|| str1.equals("scoretype")){
	     							continue;
	     						}
	     						if(!rowlist.contains(str1)){
	     							rowlist.add(str1);
	     						}
	     						if(rsmd.getColumnTypeName(i).equals("VARCHAR")){
	     							String st_="^[0-9A-Z]+$";
	     						    String str=rs.getString(str1);
	     			           if(str!=null){
	     						  if(str1.matches(st_)){
	     								String subjectid=((String) str1).split("ZZZ")[0];
	     		 	      				String phaseid=((String) str1).split("ZZZ")[1];
	     		 	      				String c=((String) str1).split("ZZZ")[2];
	     		 	      		 if(subjectid.equals(_subjectid) && phaseid.equals(_phaseid)){
	     		 	      		   list.add(str);
	   	 	      				continue;
	     		 	      		  }	
	     		 	      	     if(subjectid!=null && phaseid!=null){
	     		 	      			   _subjectid=subjectid;
	     		 	      			   _phaseid=phaseid;
	     		 	      		   }
	 		 	      			  Subject subject=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
	 		 	      			  String subjectname=subject.getName();
	     		 	      		     if(c.equals("1")){
	     		 	      		       list.add(str);
		   	 	      				}
	     		 	      			   
	     							}else{
	     								if(str1.equals("sid")){
	     									String studentname = "";
	     									Student student=mgr.getStudentBySid(str);
	     									if(null == student){
	     										studentname = "";
	     									}else{
	     										studentname=student.getName();
	     									}
	     									list.add(studentname);
	     									list.add(str);
	     								}
	     								if(str1.equals("classkey")){
	     								 TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(str));
	     								 list.add(tclass.getName());
	     								}
	     							}
	     					    }else{	 
	     					    	String subjectid=((String) str1).split("ZZZ")[0];
	     					    	String phaseid=((String) str1).split("ZZZ")[1];
	 		 	      				String c=((String) str1).split("ZZZ")[2];
	 		 	      				if(subjectid!=null && c.equals("1")){
	 		 	      					Subject sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
	 		 	      					String subname=sub.getName();
	     		 	      		        list.add("");
	 		 	      				}else{
	 		 	      				    list.add("");	
	 		 	      				}
	     					     } 
	     					  }		
	     						if(rsmd.getColumnTypeName(i).equals("INTEGER")){
	     							if(str1.equals("classkey")){
	     								int classkey=rs.getInt(str1);
	     								TClass tclass=(TClass) this.combiz.get(TClass.class, classkey);
	     								String classname=tclass.getName();
	     								list.add(classname);
	     							}
	     						 }
	     					 }
	     					scorelist.add(list);
	     				  }		
	     			 
	     			  String subid=null;
	     			  String phid=null;
	     			 for(int i=0;i<rowlist.size();i++){
	     				 Object str=rowlist.get(i);
	     				 if(str.equals("sid")){
	     					_list.add("姓名");
	     					_list.add("编号");
	     				 }
	     				 if(str.equals("classkey")){
	     					_list.add("班级名称"); 
	     				 }
	     				 String st_="^[0-9A-Z]+$";
	     			    if(((String) str).matches(st_)){
		      				String subjectid=((String) str).split("ZZZ")[0];//
		      				Subject sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		      				String subname=sub.getName();
		      				String phaseid=((String) str).split("ZZZ")[1];
		      				String c=((String) str).split("ZZZ")[2];
		      				if(subjectid.equals(subid) && phaseid.equals(phid)){
		      					if(c.equals("2")){
		      					 _list.add(subname+"正考-补做");	
		 	      				}
		 	      				if(c.equals("3")){
		 	      				_list.add(subname+"正考-补考");
		 	      				}
		 	      				if(c.equals("4")){
		 	      				_list.add(subname+"正考-补考-补做");
		 	      				}
		 	      				if(c.equals("5")){
		 	      				_list.add(subname+"正考-重修");
		 	      				}
		 	      				if(c.equals("6")){
		 	      				_list.add(subname+"正考-重修-补做");
		 	      				}
		 	      				if(c.equals("7")){
		 	      				_list.add(subname+"毕前考");
		 	      				}
		 	      				if(c.equals("8")){
		 	      				_list.add(subname+"毕前考-补做");
		 	      				}
		 	      				if(c.equals("9")){
		 	      				_list.add(subname+"其他");
		 	      				}
		 	      				if(c.equals("10")){
		 	      				_list.add(subname+"其他-补做");
		 	      				}
		      					continue;
		      				}
		      				if(subjectid!=null && phaseid!=null){
		      					subid=subjectid;
		      					phid=phaseid;
		      					Subject _sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
			      				String _subname=_sub.getName();
		      					//_list.add("科目");
		      					//_list.add("阶段类型");
		      				}
		      				if(c.equals("1")){
		      					_list.add(subname+"正考");
		      				}
		      				if(c.equals("2")){
		      					_list.add(subname+"正考-补做");	
		      				}
		      				if(c.equals("3")){
		      					_list.add(subname+"正考-补考");
		      				}
		      				if(c.equals("4")){
		      					_list.add(subname+"正考-补考-补做");
		      				}
		      				if(c.equals("5")){
		      					_list.add(subname+"正考-重修");
		      				}
		      				if(c.equals("6")){
		      					_list.add(subname+"正考-重修-补做");
		      				}
		      				if(c.equals("7")){
		      					_list.add(subname+"毕前考");
		      				}
		      				if(c.equals("8")){
		      					_list.add(subname+"毕前考-补做");
		      				}
		      				if(c.equals("9")){
		      					_list.add(subname+"其他");
		      				}
		      				if(c.equals("10")){
		      					_list.add(subname+"其他-补做");
		      			  }
	     			    }
	     			  }   
	     		   }	     	 
	     	   String message=new ExcelUtil2007().buildXSLXExcelclassResult_(_list,scorelist);
			   if(message.equals("false")){				
				out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
			   }else{
				out.print("{bol:true,message:'"+URLEncoder.encode(message,"UTF-8")+"'}");
			   }
			   out.flush();
			   out.close();
		    } catch (Exception e) {
			  e.printStackTrace();
			out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
		     }
	  	    return null;
	   }
  
  /**
   *  教务默认
   * @return
   * @throws IOException
   */
  public String exportexcelallclassresult()throws IOException{
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/html;charset=utf-8");
	  HttpSession session=request.getSession();
	  User user=(User) request.getSession().getAttribute("tuser");
	  JDBCConnection dbcon = new JDBCConnection();
	  PrintWriter out=response.getWriter();
	  response.setContentType("text/html;charset=utf-8");
	  String tclassid=request.getParameter("tclassid");
	  String sub_jectid=request.getParameter("subject");
	  Subject su=null;
	  if(!sub_jectid.equals("")){
		  try {
			su=mgr.getSubjectByName(sub_jectid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  System.out.println("tclassid------>"+tclassid);
	 // List _list=new ArrayList();
	  List list=null;
	//  List scorelist=null;
	  try {
		   // JDBCConnection dbcon = new JDBCConnection();
		  CallableStatement sm =null;
		 Connection con=dbcon.openConnection();
		 if(!tclassid.equals("") && !sub_jectid.equals("")){
			  sm = con.prepareCall("{CALL dabiaoclassid_subjectid("+tclassid+","+su.getId()+")}");
		 }else{
			  sm = con.prepareCall("{CALL dabiao()}");
			 
		 }
		 List alllist=new ArrayList();
  		List rowlist=new ArrayList();
  	    StringBuffer navCode=new StringBuffer();
  	    StringBuffer conter=new StringBuffer();
  		if(sm.execute() && sm.getMoreResults()){
  			ResultSet rs = sm.getResultSet();
  			ResultSetMetaData rsmd = rs.getMetaData();
  			String str1=null;
  			int totalcount=rsmd.getColumnCount();
  			List scorelist=new ArrayList();
  			List list1=null;
  				while(rs.next()){ 
  					String _str=null;
  				    String _subjectid=null;
  			        String _phaseid=null;
  					list1=new ArrayList();
  					for(int i =1; i <= totalcount; i++){ 
  						String st=rsmd.getColumnTypeName(i);
  					    str1=rsmd.getColumnName(i);
  						Object a=rs.getObject(i);
  						if(str1.equals("subjectid") ||str1.equals("phaseid") || str1.equals("examtype") ||str1.equals("major") || str1.equals("examid") || str1.equals("examdate")|| str1.equals("scoretype")){
  							continue;
  						}
  						if(!rowlist.contains(str1)){
  							rowlist.add(str1);
  						}
  						if(rsmd.getColumnTypeName(i).equals("VARCHAR")){
  							String st_="^[0-9A-Z]+$";
  						    String str=rs.getString(str1);
  			           if(str!=null){
  						  if(str1.matches(st_)){
  								String subjectid=((String) str1).split("ZZZ")[0];
  		 	      				String phaseid=((String) str1).split("ZZZ")[1];
  		 	      				String c=((String) str1).split("ZZZ")[2];
  		 	      		 if(subjectid.equals(_subjectid) && phaseid.equals(_phaseid)){
  		 	      		   list1.add(str);
	 	      				continue;
  		 	      		  }	
  		 	      	     if(subjectid!=null && phaseid!=null){
  		 	      			   _subjectid=subjectid;
  		 	      			   _phaseid=phaseid;
  		 	      		   }
		 	      			  Subject subject=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		 	      			  String subjectname=subject.getName();
  		 	      		     if(c.equals("1")){
  		 	      		       list1.add(str);
	   	 	      				}
  							}else{
  								if(str1.equals("sid")){
  									Student student=mgr.getStudentBySid_(str);
  									if(null != student){
  										String studentname=student.getName();
	     									list1.add(studentname);
	     									list1.add(str);
  									}
  									
  								}
  								if(str1.equals("classkey")){
  								 TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(str));
  								 list1.add(tclass.getName());
  								}
  							}
  					    }else{	 
  					    	String subjectid=((String) str1).split("ZZZ")[0];
  					    	String phaseid=((String) str1).split("ZZZ")[1];
		 	      				String c=((String) str1).split("ZZZ")[2];
		 	      				if(subjectid!=null && c.equals("1")){
		 	      					Subject sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		 	      					String subname=sub.getName();
  		 	      		        list1.add("");
		 	      				}else{
		 	      				    list1.add("");	
		 	      				}
  					     } 
  					  }		
  						if(rsmd.getColumnTypeName(i).equals("INTEGER")){
  							if(str1.equals("classkey")){
  								int classkey=rs.getInt(str1);
  								TClass tclass=(TClass) this.combiz.get(TClass.class, classkey);
  								String classname=tclass.getName();
  								list1.add(classname);
  							}
  						 }
  					 }
  					scorelist.add(list1);
  				  }
  			  List list_=new ArrayList();
  			  String subid=null;
  			  String phid=null;
  			 for(int i=0;i<rowlist.size();i++){
  				 Object str=rowlist.get(i);
  				// System.out.println("------>"+rowlist.get(i));
  				 if(str.equals("sid")){
  					list_.add("姓名");
  					list_.add("编号");
  				 }
  				 if(str.equals("classkey")){
  					list_.add("班级名称"); 
  				 }
  				 String st_="^[0-9A-Z]+$";
  			    if(((String) str).matches(st_)){
	      				String subjectid=((String) str).split("ZZZ")[0];//
	      				Subject sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
	      				String subname=sub.getName();
	      				String phaseid=((String) str).split("ZZZ")[1];
	      				String c=((String) str).split("ZZZ")[2];
	      				if(subjectid.equals(subid) && phaseid.equals(phid)){
	      					
	      					
	      				    //考试名称中加上阶段
							if (phaseid.equals("0")) {
								subname = subname + "无阶段";
							}
							if (phaseid.equals("1")) {
								subname = subname + "阶段1";
							}
							if (phaseid.equals("2")) {
								subname = subname + "阶段2";
							}
							if (phaseid.equals("3")) {
								subname = subname + "阶段3";
							}
							if (phaseid.equals("4")) {
								subname = subname + "阶段4";
							}
							if (phaseid.equals("5")) {
								subname = subname + "阶段5";
							}
	      					
	      					if(c.equals("2")){
	      						list_.add(subname+"正考-补做");	
	 	      				}
	 	      				if(c.equals("3")){
	 	      					list_.add(subname+"正考-补考");
	 	      				}
	 	      				if(c.equals("4")){
	 	      					list_.add(subname+"正考-补考-补做");
	 	      				}
	 	      				if(c.equals("5")){
	 	      					list_.add(subname+"正考-重修");
	 	      				}
	 	      				if(c.equals("6")){
	 	      					list_.add(subname+"正考-重修-补做");
	 	      				}
	 	      				if(c.equals("7")){
	 	      					list_.add(subname+"毕前考");
	 	      				}
	 	      				if(c.equals("8")){
	 	      					list_.add(subname+"毕前考-补做");
	 	      				}
	 	      				if(c.equals("9")){
	 	      					list_.add(subname+"其他");
	 	      				}
	 	      				if(c.equals("10")){
	 	      					list_.add(subname+"其他-补做");
	 	      				}
	      					continue;
	      				}
	      				if(subjectid!=null && phaseid!=null){
	      					subid=subjectid;
	      					phid=phaseid;
	      					Subject _sub=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		      				String _subname=_sub.getName();
	      					//_list.add("科目");
	      					//_list.add("阶段类型");
	      				}
	      				
	      			    //考试名称中加上阶段
						if (phaseid.equals("0")) {
							subname = subname + "无阶段";
						}
						if (phaseid.equals("1")) {
							subname = subname + "阶段1";
						}
						if (phaseid.equals("2")) {
							subname = subname + "阶段2";
						}
						if (phaseid.equals("3")) {
							subname = subname + "阶段3";
						}
						if (phaseid.equals("4")) {
							subname = subname + "阶段4";
						}
						if (phaseid.equals("5")) {
							subname = subname + "阶段5";
						}
						
	      				if(c.equals("1")){
	      					list_.add(subname+"正考");
	      				}
	      				if(c.equals("2")){
	      					list_.add(subname+"正考-补做");	
	      				}
	      				if(c.equals("3")){
	      					list_.add(subname+"正考-补考");
	      				}
	      				if(c.equals("4")){
	      					list_.add(subname+"正考-补考-补做");
	      				}
	      				if(c.equals("5")){
	      					list_.add(subname+"正考-重修");
	      				}
	      				if(c.equals("6")){
	      					list_.add(subname+"正考-重修-补做");
	      				}
	      				if(c.equals("7")){
	      					list_.add(subname+"毕前考");
	      				}
	      				if(c.equals("8")){
	      					list_.add(subname+"毕前考-补做");
	      				}
	      				if(c.equals("9")){
	      					list_.add(subname+"其他");
	      				}
	      				if(c.equals("10")){
	      					list_.add(subname+"其他-补做");
	      				}
  			     }
  			    }
		 	     	 
		  String message=new ExcelUtil2007().buildXSLXExcelclassResult_(list_,scorelist);
		  if(message.equals("false")){				
			  out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
		  }else{
			  out.print("{bol:true,message:'"+URLEncoder.encode(message,"UTF-8")+"'}");
		  }
		  out.flush();
		  out.close();
  	    }
	  } catch (Exception e) {
		  e.printStackTrace();
		  out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
	  }
	  return null;
  }
	  
 /**
  * 老师查询成绩导出
  * @return
  * @throws IOException
  */
  public String exportexcelresult()throws IOException{
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  PrintWriter out=response.getWriter();
	  response.setContentType("text/html;charset=utf-8");
	  HttpSession session=request.getSession();
	  User user=(User) request.getSession().getAttribute("tuser");
	  List tclasslist=new ArrayList();
	  List subjectlist=new ArrayList();
 	  List<ScoreNew> _list=new ArrayList<ScoreNew>();
 	  try {
	   if(user.getUserType()!=null && user.getUserType()==7){
		   classId=request.getParameter("classId_");
		   subjectName=request.getParameter("subjectname");
		   Subject subject=mgr.getSubjectByName(subjectName);
		   Integer _subjectid=subject.getId();
			 TClass t_class=(TClass) this.combiz.get(TClass.class, Integer.parseInt(classId));
			 String class_name=t_class.getName();
				 List<Student> student_list=mgr.getStudentListByClassnameStatus(class_name);
				 for(Student stu:student_list){
					 String sid=stu.getSid();			 
		  			 ScoreNew _scoreNew=null; 
		  				 List<Object[]> list1=mgr.getScoreNewBySid(sid);
		  				 if(list1 !=null && list1.size()>0){
		  				 for(Object[] object_ : list1){
		  				 	List totalresult=new ArrayList();
		  					 _scoreNew=new ScoreNew();
		  					 Integer subjectid= (Integer) object_[0];
		  					if(!subjectid.equals(_subjectid)){
		  						 continue;
		  					 }
		  					 Integer phaseid=(Integer) object_[1];
		  					 Integer scoretype=(Integer) object_[2];
		  					 Integer classkey=(Integer) object_[3];
			  				 String regex="^[0-9]+([.]{1}[0-9]+){0,1}$";//
			  					if(scoretype.equals(1)){
			  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
			  						 if(zkScoreList.size()>0){
			  							 Object _object = (Object) zkScoreList.get(0);
			  							 _scoreNew.setZkresult((String) _object); 
			  							_scoreNew.setTotalresult((String) _object);
			  						 }	 
			  					 }
			  					 // 非百分制
			  					 if(scoretype.equals(2)){
			  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
			  						 if(zkScoreList.size()>0){
			  							 Object _object = (Object) zkScoreList.get(0);
			  							 String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  								 _scoreNew.setZkresult(str);
			  								 totalresult.add(str);
			  								 
			  							 }
			  						  }
			  						 List zkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,2);
			  						   if(zkbzScoreList.size()>0){
			  							   Object _object = (Object) zkbzScoreList.get(0);
			  							   String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							    _scoreNew.setZkbzresult(str); 
			  							   totalresult.add(str);
			  						     }	
			  						   }
			  						  
			  						 List zkbkScoreList=mgr.getScore_(sid, subjectid, phaseid,3);
			  						 if(zkbkScoreList.size()>0){
			  							 Object _object = (Object) zkbkScoreList.get(0);
			  							 String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							 _scoreNew.setZkbkresult(str);
			  							 totalresult.add(str);
			  						   }
			  						 }
			
			  						 List zkbkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,4);
			  						 if(zkbkbzScoreList.size()>0){
			  							 Object _object = (Object) zkbkbzScoreList.get(0);
			  							 String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							 _scoreNew.setZkbkbzresult(str);
			  							totalresult.add(str);
			  						   }
			  						 }
			  						 List cxScoreList=mgr.getScore_(sid, subjectid, phaseid,5);
			  						 if(cxScoreList.size()>0){
			  							 Object _object = (Object) cxScoreList.get(0);
			  							String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							 _scoreNew.setCxresult(str);
			  							totalresult.add(str);
			  						   }
			  						 }
			  						 List  cxbzScoreList=mgr.getScore_(sid, subjectid, phaseid,6);
			  						 if(cxbzScoreList.size()>0){
			  							 Object _object = (Object) cxbzScoreList.get(0);
			  							String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							 _scoreNew.setCxbzresult(str);
			  							totalresult.add(str);
			  						   }
			  						 }
			  						 List  bqkScoreList=mgr.getScore_(sid, subjectid, phaseid,7);
			  						 if(bqkScoreList.size()>0){
			  							 Object _object = (Object) bqkScoreList.get(0);
			  							String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							 _scoreNew.setBqkresult(str);
			  							totalresult.add(str);
			  						  }
			  						 }
			  						 List bqkbzScoreList=mgr.getScore_(sid, subjectid, phaseid,8);
			  						 if(bqkbzScoreList.size()>0){
			  							 Object _object = (Object) bqkbzScoreList.get(0);
			  							String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							 _scoreNew.setBqkbzresult(str);
			  							totalresult.add(str);
			  						   }
			  						 }
			  						 List qtScoreList=mgr.getScore_(sid, subjectid, phaseid,9);
			  						 if(qtScoreList.size()>0){
			  							 Object _object = (Object) qtScoreList.get(0);
			  							String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							 _scoreNew.setQtresult(str);
			  							 totalresult.add(str);
			  						  }
			  						 }
			  						 List qtbzScoreList=mgr.getScore_(sid, subjectid, phaseid,10);
			  						 if(qtbzScoreList.size()>0){
			  							Object _object = (Object) qtbzScoreList.get(0);
			  							String str=(String) _object+"";
			  							   if(!str.equals("null") && !(str).matches(regex)){
			  							   str=str.split("-")[0];
			  							 _scoreNew.setQtbzresult(str);
			  							totalresult.add(str);
			  						   }
			  						 }
			  						 if(totalresult.contains("P")){
			  							 _scoreNew.setTotalresult("P");
			  						 }else{
			  							 _scoreNew.setTotalresult("未通过"); 
			  						 }
			  					 
			  				  }
			  					 //记分单元
			  					if(scoretype.equals(3)){
			  						 List zkScoreList=mgr.getScore_(sid, subjectid, phaseid,1);
			  						 if(zkScoreList.size()>0){
			  							 Object _object = (Object) zkScoreList.get(0);
			  							 String str=(String)_object+"";
			  							 String result="";
			  							 if(!str.equals("null") && str.matches(regex)){
			  								double num = Double.valueOf(str);
			  								if(num>=70){
			  									result="A -- "+num;
			  			    				}else if(num>=60){
			  			    					result="B -- "+num;
			  			    				}else if(num>=50){
			  			    					result="C -- "+num;
			  			    				}else{
			  			    					result="F -- "+num;
			  			    				}
			  								_scoreNew.setTotalresult(result);
			  							 }else if(!str.equals("null") && !str.matches(regex)){
			  								result=str.split("-")[0];
			  								_scoreNew.setTotalresult(result);
			  							 }else{
			  								result=null;
			  							 }
			  							 _scoreNew.setZkresult(result);
			  						  }	 
			  						 List zkbkScoreList=mgr.getScore_(sid, subjectid, phaseid,3);
			  						 if(zkbkScoreList.size()>0){
			  							 Object _object = (Object) zkbkScoreList.get(0);
			  							 String str=(String)_object+"";
			  							 String result="";
			  							 if(!str.equals("null") && str.matches(regex)){
			  								double num = Double.valueOf(str);
			  								if(num>=70){
			  									result="A -- "+num;
			  			    				}else if(num>=60){
			  			    					result="B -- "+num;
			  			    				}else if(num>=50){
			  			    					result="C -- "+num;
			  			    				}else{
			  			    					result="F -- "+num;
			  			    				}
			  								_scoreNew.setTotalresult(result);
			  							 }else if(!str.equals("null") && !str.matches(regex)){
			  								result=str.split("-")[0];
			  								_scoreNew.setTotalresult(result);
			  							 }else{
			  								result=null;
			  							 }
			  							_scoreNew.setZkbkresult(result);
			  						 }
			  						 List bqkScoreList=mgr.getScore_(sid, subjectid, phaseid,7);
			  						 if(bqkScoreList.size()>0){
			  							 Object _object = (Object) bqkScoreList.get(0);
			  							 String str=(String)_object+"";
			  							 String result="";
			  							 if(!str.equals("null") && str.matches(regex)){
			  								double num = Double.valueOf(str);
			  								if(num>=70){
			  									result="A -- "+num;
			  			    				}else if(num>=60){
			  			    					result="B -- "+num;
			  			    				}else if(num>=50){
			  			    					result="C -- "+num;
			  			    				}else{
			  			    					result="F -- "+num;
			  			    				}
			  								_scoreNew.setTotalresult(result);
			  							 }else if(!str.equals("null") && !str.matches(regex)){
			  								result=str.split("-")[0];
			  								_scoreNew.setTotalresult(result);
			  							 }else{
			  								 result=null;
			  							 }
			  							_scoreNew.setBqkresult(result);	
			  						 }
			  						 List qtScoreList=mgr.getScore_(sid, subjectid, phaseid,9);
			  						 if(qtScoreList.size()>0){
			  								Object _object = (Object) qtScoreList.get(0);
			  								 String str=(String)_object+"";
				  							 String result="";
				  							if(!str.equals("null") && str.matches(regex)){
				  								double num = Double.valueOf(str);
				  								if(num>=70){
				  									result="A -- "+num;
				  			    				}else if(num>=60){
				  			    					result="B -- "+num;
				  			    				}else if(num>=50){
				  			    					result="C -- "+num;
				  			    				}else{
				  			    					result="F -- "+num;
				  			    				}
				  								_scoreNew.setTotalresult(result);
				  							 }else if(!str.equals("null") && !str.matches(regex)){
				  								result=str.split("-")[0];
				  								_scoreNew.setTotalresult(result);
				  							 }else{
				  								 result=null;
				  							 }
				  							_scoreNew.setQtresult(result);
			  							}
			  					 }
		  					 Subject sub=(Subject) this.combiz.get(Subject.class, subjectid);
		  					 String subjectname=sub.getName();
		  					 TClass _tclass=(TClass) this.combiz.get(TClass.class, classkey);
		  					 String classname=_tclass.getName();
		  					 Student student= mgr.getStudentBySid(sid);
		  					 String studentname=student.getName();  
		  					 _scoreNew.setStudentname(studentname);
		  					 Integer studentid=student.getId(); 
		  					 _scoreNew.setClassname(classname);
		  					 _scoreNew.setStudentid(studentid);
		  					 _scoreNew.setSubjectname(subjectname);
		  					 if(phaseid.equals(0)){
		  						 _scoreNew.setPhase("无");
		  					 }
		  					 if(phaseid.equals(1)){
		  						 _scoreNew.setPhase("Assessment1");
		  					 }
		  					 if(phaseid.equals(2)){
		  						 _scoreNew.setPhase("Assessment2");
		  					 }
		  					 if(phaseid.equals(3)){
		  						 _scoreNew.setPhase("Assessment3");
		  					 }
		  					 if(phaseid.equals(4)){
		  						 _scoreNew.setPhase("Assessment4");
		  					 }
		  					 if(phaseid.equals(5)){
		  						 _scoreNew.setPhase("Assessment5");
		  					 }
		  					 _list.add(_scoreNew);
		  				    }
		  				  }
				         }
	  				 request.setAttribute("_list", _list);
	  				 request.setAttribute("tclasslist", tclasslist);
	  				 request.setAttribute("subjectlist", subjectlist);
	  				 request.setAttribute("classId",classId );
	  				 request.setAttribute("subjectName",subjectName );
	  				 request.setAttribute("id", id);
	  				 request.setAttribute("title", title);
	  				 if(_list.size()==0 || _list==null){
	  				   out.print("{bol:false,message:'"+URLEncoder.encode("没有数据要导出","UTF-8")+"'}");
	  				   return null;
	  				 }
	  			 // }	
	  	 	     
				String message=new ExcelUtil2007().buildXSLXExcel1_(_list);
				if(message.equals("false")){				
					out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
				}else{
					out.print("{bol:true,message:'"+URLEncoder.encode(message,"UTF-8")+"'}");
				 }
				out.flush();
				out.close();
	           } 
			} catch (Exception e) {
				e.printStackTrace();
				out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
			}
 	        
		  return null;
    }

  public String manageclasslist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  List listnewclasslist=new ArrayList();
	  try {
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
			tclasslist=mgr.getClassList();
			for(int i=0;i<tclasslist.size();i++){
				TClass tclass=(TClass) tclasslist.get(i);
				Integer id=tclass.getId();
				String name=tclass.getName();
				Integer assistantid=tclass.getAssistantid();
				if(assistantid==null){
				    tclass.setAssistant(null);
				    listnewclasslist.add(tclass);
				}else{
					Assistant assistant=(Assistant) this.combiz.get(Assistant.class, assistantid);
					if(assistant!=null){
						String assistantname=assistant.getName();
						tclass.setAssistant(assistant);
						listnewclasslist.add(tclass);	
					}
				}
			}
			
	      }
	       request.setAttribute("listnewclasslist", listnewclasslist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return "manageclasslist";
  }
   public String addtclass(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  try {
			assistantlist=mgr.getAssistantList();
			majorlist=mgr.getMajorList();
			request.setAttribute("assistantlist", assistantlist);
			request.setAttribute("majorlist", majorlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  return "addtclass";
  }
  public String dotclasstadd(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  TClass tclass=new TClass();
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  String classname=request.getParameter("classname").trim();
		  String gradename=request.getParameter("gradename").trim();
		  String classvid=request.getParameter("classvid");
		  String assistantid=request.getParameter("assistantid");
		  String majorid=request.getParameter("majorid");
		  String project=request.getParameter("project");
		  try {
			classname = (classname != null)?new String(classname.getBytes("iso-8859-1"),"utf-8"):classname;
			gradename = (gradename != null)?new String(gradename.getBytes("iso-8859-1"),"utf-8"):gradename;
			project = (project != null)?new String(project.getBytes("iso-8859-1"),"utf-8"):project;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		  tclass.setName(classname);
		  tclass.setCid(classvid);
		  if(assistantid!=""){
			  tclass.setAssistantid(Integer.parseInt(assistantid));	 
		  }
		  tclass.setGrade(gradename);
		  tclass.setMajorid(majorid);
		  tclass.setProject(project);
		  this.combiz.save(tclass);
	  }
	  return "dotclasstadd";
  } 
  public String toclassenter(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  try {
		  String classid=request.getParameter("tclassid");
		  String _tclassid=request.getParameter("_tclassid");
		  if(_tclassid.equals("0")){
			  TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(classid));
			  this.combiz.delete(tclass);
			  return "toclassdelete";
		    }else{
			  TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(classid));
			  String classname=tclass.getName();
			  studentList=mgr.getStudentListByClassname(classname);
			  request.setAttribute("studentList", studentList);  
			  return "toclassenter";
		     }
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			  return null;
		  }
		 }else{
		     return null;	 
		 }   
     }  
  public String detailstudent(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  List list=new ArrayList();
	  try {
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  String studentid=request.getParameter("studentid");
          Student student=(Student) this.combiz.get(Student.class, Integer.parseInt(studentid));
          request.setAttribute("student", student);
	      }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return "detailstudent";
  }
   public String toclassupdate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  List list=new ArrayList();
	  try {
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		   String tclassid=request.getParameter("tclassid");
		   TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(tclassid));
		   Integer id=tclass.getId();
		   String tclassname=tclass.getName();
		   String grade=tclass.getGrade();
		   String tclid=tclass.getCid();
		   String project=tclass.getProject();
		   Integer assistid=tclass.getAssistantid();
		   Assistant assistant=(Assistant) this.combiz.get(Assistant.class, assistid);
		   String assistantname=assistant.getName();
		   String magorid=tclass.getMajorid();
		   if(magorid!=null){
			Major major=mgr.getMajorBymajorId(magorid);
			Integer majorid=major.getId();
			request.setAttribute("ma", majorid);
		   }
		   majorlist= mgr.getMajorList();
		   TClass tcl=new TClass();
		   tcl.setName(tclassname);
		   tcl.setGrade(grade);
		   tcl.setCid(tclid);
		   tcl.setAssistantname(assistantname);
		   tcl.setProject(project);
 		   request.setAttribute("tcl", tcl);
 		   request.setAttribute("tclassid", tclassid);
 		   request.setAttribute("majorlist", majorlist);
	    }
      } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return "toclassupdate";
  }
   
   public String doupdatetclass(){
	      HttpServletRequest request=ServletActionContext.getRequest();
		  User user=(User) request.getSession().getAttribute("tuser");
		  List list=new ArrayList();
		  try {
		  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
			  String tclassid=request.getParameter("classid");
			  String classname=request.getParameter("classname");
			  String gradename=request.getParameter("gradename");
			  String classvid=request.getParameter("classvid");
			  String assistantname=request.getParameter("assistantname");
			  assistantname = (assistantname != null)?new String(assistantname.getBytes("iso-8859-1"),"utf-8"):assistantname;
			  Assistant assistant= mgr.getAssistantByName(assistantname);
			  Integer assistantid=assistant.getId();
			  String majorid=request.getParameter("majorid");
			  String project=request.getParameter("project");
			  classname = (classname != null)?new String(classname.getBytes("iso-8859-1"),"utf-8"):classname;
			  gradename = (gradename != null)?new String(gradename.getBytes("iso-8859-1"),"utf-8"):gradename;
			  project = (project != null)?new String(project.getBytes("iso-8859-1"),"utf-8"):project;
			  TClass tclass=new TClass();
			  tclass.setId(Integer.parseInt(tclassid));
			  tclass.setName(classname);
			  tclass.setGrade(gradename);
			  tclass.setCid(classvid);
			  tclass.setAssistantid(assistantid);
			  tclass.setMajorid(majorid);
			  tclass.setProject(project);
			  this.combiz.update(tclass);
		   }
		  } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
	   return "doupdatetclass";
   
    }
   
   public String checkclassname(){
	 try {
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response = ServletActionContext.getResponse();
	  User user=(User) request.getSession().getAttribute("tuser");
	  response.setContentType("text/json;charset=utf-8");
      PrintWriter out=response.getWriter();
      String classname=request.getParameter("classname");
      TClass tclass=mgr.getClassByName(classname);
      if(tclass==null){
    	  out.print(false);//不存在
      }else{
    	  out.print(true);//存在
      }
      out.flush();
      out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return SUCCESS;
  }
   
   public String checkclasscid(){
	   try {
	   HttpServletRequest request=ServletActionContext.getRequest();
	   HttpServletResponse response=ServletActionContext.getResponse();
	   response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		String classcid=request.getParameter("classcid");
		TClass tclass=mgr.getClassByCid(classcid);
		if(tclass==null){
		  out.print(false);
		}else{
			out.print(true);
		}
		 out.flush();
	     out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return SUCCESS;
   }
   public String checkenglishname(){
	   try {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   HttpServletResponse response=ServletActionContext.getResponse();
		   response.setContentType("text/json;charset=utf-8");
			PrintWriter out=response.getWriter();
			String englishname=request.getParameter("englishname");
			User user=mgr.getUserByName(englishname);
			if(user==null){
			  out.print(false);
			}else{
				out.print(true);
			}
			 out.flush();
		     out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return SUCCESS;
	   }
  /*public String tomanagerteacherlist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response = ServletActionContext.getResponse();
	  User user=(User) request.getSession().getAttribute("tuser");
	  try {
	  List list=new ArrayList();
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
			teacherList=mgr.getTeacherList();
			if(teacherList!=null && teacherList.size()>0){
				for(int i=0;i<teacherList.size();i++){
					String totalSubjectname="";
					Teacher tea=new Teacher();
					Teacher teacher=(Teacher) teacherList.get(i);
					String teachername=teacher.getName();
					String sid=teacher.getTid();
					Integer sex=teacher.getSex();
					String cellphone=teacher.getCellphone();
					String email=teacher.getEmail();
					List subjectnamelist=mgr.getSubjectnameListByTeachername(teachername);
					for(int j=0;j<subjectnamelist.size();j++){
						Object object = (Object) subjectnamelist.get(j);
						String subname=(String) object;
						totalSubjectname+=subname+"、";
					}
					tea.setTid(sid);
					tea.setName(teachername);
					tea.setSex(sex);
					tea.setCellphone(cellphone);
					tea.setEmail(email);
					tea.setSubjectname(totalSubjectname);
					list.add(tea);
				}
			}
			request.setAttribute("list", list);
			request.setAttribute("teacherList", teacherList);
	     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  return "tomanagerteacherlist";
  }*/
  public String tomanagerteacherlist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response = ServletActionContext.getResponse();
	  User user=(User) request.getSession().getAttribute("tuser");
	  List list=new ArrayList();
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){	 
	      return "tomanagerteacherlist";
      }else{
    	  return null;
      }
  }
  public String checkteachername(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String teachername=request.getParameter("teachername");
		Teacher teacher=mgr.getTeacherByName(teachername);
		if(teacher==null){
			out.print(false);
		}else{
			out.print(true);
		}
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return SUCCESS;
  }
  public String checkteachertid(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String teachertid=request.getParameter("teachertid");
		Teacher teacher=mgr.getTeacherByTid(teachertid);
		if(teacher==null){
			out.print(false);
		}else{
			out.print(true);
		}
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return SUCCESS;
  }
  public String doteacheradd(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  String teachername=request.getParameter("teachername").trim();
		  try {
			teachername = (teachername != null)?new String(teachername.getBytes("iso-8859-1"),"utf-8"):teachername;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String teachertid=request.getParameter("teachertid");
		  String sex=request.getParameter("teachersex");
		  String cellphone=request.getParameter("cellphone");
		  String email=request.getParameter("email");
		 // String englishname=request.getParameter("englishname");
		  User use=new User();
		  use.setUser(teachername);
		  //use.setEnglishname(englishname);
		  use.setPass("123");
		  use.setUserType(7);
		  use.set_status(1);//在职
		  Teacher teacher=new Teacher();
		  teacher.setName(teachername);
		  teacher.setTid(teachertid);
		  teacher.setSex(Integer.parseInt(sex));
		  teacher.setEmail(email);
		  teacher.setCellphone(cellphone);
		  teacher.set_status(1);//在职
		  this.combiz.save(teacher);
		  this.combiz.save(use);
	  }
	  return "doteacheradd";
  }
  public String toteacherupdate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  String teachertid=request.getParameter("teachertid");
		  try {
			Teacher teacher=mgr.getTeacherByTid(teachertid);
			request.setAttribute("teacher", teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  return"toteacherupdate";
  }
  public String doteacherupdate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  try {
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		 String teachername=request.getParameter("teachername");
		 String teacherid=request.getParameter("teacherid");
		 String teachertid=request.getParameter("teachertid");
		 String email=request.getParameter("email");
		 String cellphone=request.getParameter("cellphone");
		 String sex=request.getParameter("sex");
		 String status=request.getParameter("status");
		 teachername = (teachername != null)?new String(teachername.getBytes("iso-8859-1"),"utf-8"):teachername;
		 Teacher teacher=new Teacher();
		 User use=new User();
		 User _user= mgr.getUserByName(teachername);
		 Integer userid=_user.getId();
		 String username=_user.getUser();
		 String pass=_user.getPass();
		 Integer usertype=_user.getUserType();
		 teacher.setId(Integer.parseInt(teacherid));
		 teacher.setTid(teachertid);
		 teacher.setName(teachername);
		 teacher.setCellphone(cellphone);
		 teacher.setEmail(email);
		 teacher.setSex(Integer.parseInt(sex));
		 teacher.set_status(Integer.parseInt(status));
		 use.setId(userid);
		 use.setUser(username);
		 use.setPass(pass);
		 use.setUserType(usertype);
		 use.set_status(Integer.parseInt(status));
		 this.combiz.update(teacher);
		 this.combiz.update(use);
	    }
   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return "doteacherupdate";
  }
 /* public String tomanagerassistantlist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  List list=new ArrayList();
	  if(user.getUserType()!=null && user.getUserType()==5){
		  try {
			assistantList=mgr.getAssistantList();
			if(assistantList!=null && assistantList.size()>0){
				for(int i=0;i<assistantList.size();i++){
					String totalclassroom="";
					Assistant assistant=(Assistant) assistantList.get(i);
					String assistantname=assistant.getName();
					String assistantaid=assistant.getAid();
					Integer sex=assistant.getSex();
					String cellphone=assistant.getCellphone();
					List classnameList=mgr.getClassnamenameListByAssistantname(assistantname);
					if(classnameList!=null && classnameList.size()>0){
						for(int j=0;j<classnameList.size();j++){
							Object object=(Object)classnameList.get(j);
							String classroom=(String) object;
							totalclassroom+=classroom+"丶";
						}
					}
					Assistant _assistant=new Assistant();
					_assistant.setAid(assistantaid);
					_assistant.setName(assistantname);
					_assistant.setSex(sex);
					_assistant.setCellphone(cellphone);
					_assistant.setClassname(totalclassroom);
					list.add(_assistant);
				}
			}
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  return "tomanagerassistantlist";
  }*/
  public String tomanagerassistantlist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  List list=new ArrayList();
	  if(user.getUserType()!=null && user.getUserType()==5){
		  return "tomanagerassistantlist";	 
	   }else{
		  return null;
	   }
  }
  public String checkassistantname(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String assistantname=request.getParameter("assistantname");
		Assistant assistant=mgr.getAssistantByName(assistantname);
		if(assistant==null){
			out.print(false);
		}else{
			out.print(true);
		}
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return SUCCESS;
  }
  public String checkassistantaid(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String assistantaid=request.getParameter("assistantaid");
		Assistant assistant=mgr.getAssistantListByaid(assistantaid);
		if(assistant==null){
			out.print(false);
		}else{
			out.print(true);
		}
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return SUCCESS;
  }
  public String doassistantadd(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  try {
	  if(user.getUserType()!=null && user.getUserType()==5){
		  String assistantname=request.getParameter("assistantname").trim();
		  String assistantaid=request.getParameter("assistantaid");
		  String assistantsex=request.getParameter("assistantsex");
		  String cellphone=request.getParameter("cellphone");
		  String oph=request.getParameter("oph");
		  String email=request.getParameter("email");
		  assistantname = (assistantname != null)?new String(assistantname.getBytes("iso-8859-1"),"utf-8"):assistantname;
          Assistant assistant=new Assistant();
          User use=new User();
          assistant.setAid(assistantaid);
          assistant.setName(assistantname);
          assistant.setCellphone(cellphone);
          assistant.setOph(oph);
          assistant.setSex(Integer.parseInt(assistantsex));
          assistant.setEmail(email);
          assistant.set_status(1);
          use.setUser(assistantname);
          use.setPass("123");
          use.setUserType(6);
          use.set_status(1);
          this.combiz.save(use);
          this.combiz.save(assistant);
	      }
	    } catch (Exception e) {
		  e.printStackTrace();
	  }
	  return "doassistantadd";
  }
  public String toassistantupdate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==5){
		  String assistantid=request.getParameter("assistantid");
		 try {
			Assistant assistant= mgr.getAssistantByAid(assistantid);
			request.setAttribute("assistant", assistant);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  return "toassistantupdate";
  }
  public String doassistantupdate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  try {
	  if(user.getUserType()!=null && user.getUserType()==5){
		  String assistantid=request.getParameter("assistantid");
		  String assistantname=request.getParameter("assistantname");
		  String assistantaid=request.getParameter("assistantaid");
		  String email=request.getParameter("email");
		  String cellphone=request.getParameter("cellphone");
		  String oph=request.getParameter("oph");
		  String sex=request.getParameter("sex");
		  String status=request.getParameter("status");
		  assistantname = (assistantname != null)?new String(assistantname.getBytes("iso-8859-1"),"utf-8"):assistantname;
		  Assistant assistant=(Assistant) this.combiz.get(Assistant.class, Integer.parseInt(assistantid));
		  assistant.setAid(assistantaid);
		  assistant.setName(assistantname);
		  assistant.setCellphone(cellphone);
		  assistant.setOph(oph);
		  assistant.setEmail(email);
		  assistant.setSex(Integer.parseInt(sex));
		  assistant.set_status(Integer.parseInt(status));  
		  User use=new User();
		  User _user= mgr.getUserByName(assistantname);
		  Integer userid=_user.getId();
		  String username=_user.getUser();
		  String pass=_user.getPass();
		  Integer usertype=_user.getUserType();
		  use.setId(userid);
		  use.setUser(username);
		  use.setPass(pass);
		  use.setUserType(usertype);
		  use.set_status(Integer.parseInt(status));
		  this.combiz.update(assistant);
		  this.combiz.update(use);
		  
	     }
	   } catch (Exception e) {
		  e.printStackTrace();
	   }
	  return "doassistantupdate";
  }
  public String tomanagerclassroomlist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4 ){
		  return "tomanagerclassroomlist";  
	  }else{
		  return null;
	  }
  }
  
  public String checkcid(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String cid=request.getParameter("cid");
		Classroom classroom=mgr.getClassroomListByCid(cid);
		  if(classroom==null){
			out.print(false);
		  }else{
			out.print(true);
		  }
		  out.flush();
		  out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return SUCCESS;
  }
  public String checkclassroomid(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		  PrintWriter out=response.getWriter();
		  String roomid=request.getParameter("roomid");
		  Classroom classroom=mgr.getClassroomListByroomid(roomid);
		  if(classroom==null){
			  out.print(false);
		  }else{
			  out.print(true);
		  }
		  out.flush();
		  out.close();
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	  return SUCCESS;
  }
  public String doclassroomadd(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  try {
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  String cid=request.getParameter("cid");
		  String campus=request.getParameter("campus");
		  String roomid=request.getParameter("roomid");
		  String type=request.getParameter("type");
		 String roomname=request.getParameter("roomname").trim();
		  cid = (cid != null)?new String(cid.getBytes("iso-8859-1"),"utf-8"):cid;
		  campus = (campus != null)?new String(campus.getBytes("iso-8859-1"),"utf-8"):campus;
		roomname = (roomname != null)?new String(roomname.getBytes("iso-8859-1"),"utf-8"):roomname;
		  Classroom classroom=new Classroom();
		  classroom.setCid(cid);
		  classroom.setRoomid(roomid);
		  classroom.setCampus(campus);
		  classroom.setType(Integer.parseInt(type));
		classroom.setRoomname(roomname);
		  this.combiz.save(classroom);
	   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  return "doclassroomadd";
  }
  public String toclassroomupdate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  try {
		  String classroomcid=request.getParameter("classroomcid");
			Classroom classroom=mgr.getClassroomListByCid(classroomcid);
			request.setAttribute("classroom", classroom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  return "toclassroomupdate";
  }
  public String doclassroomupdate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  try {
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  String id=request.getParameter("id");
		  String cid=request.getParameter("cid");
		String roomname=request.getParameter("roomname").trim();
		  String campus=request.getParameter("campus");
		  String roomid=request.getParameter("roomid");
		  String type=request.getParameter("type");
		  Classroom classroom=(Classroom) this.combiz.get(Classroom.class, Integer.parseInt(id));
		  campus = (campus != null)?new String(campus.getBytes("iso-8859-1"),"utf-8"):campus;
		 roomname = (roomname != null)?new String(roomname.getBytes("iso-8859-1"),"utf-8"):roomname;
		  roomid = (roomid != null)?new String(roomid.getBytes("iso-8859-1"),"utf-8"):roomid;
		  cid = (cid != null)?new String(cid.getBytes("iso-8859-1"),"utf-8"):cid;
		  classroom.setId(Integer.parseInt(id));
		  classroom.setCid(cid);
		 classroom.setRoomname(roomname);
		  classroom.setCampus(campus);
		  classroom.setRoomid(roomid);
		  classroom.setType(Integer.parseInt(type));
		  this.combiz.update(classroom);
	      }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return "doclassroomupdate";
  }
  public String checkclasscidroomid(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/josn;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String currentcid=request.getParameter("cid");//当前的房间编号
		String currentroomid=request.getParameter("roomid");//获取当前房间号
		Classroom classroom=mgr.getClassroomListByroomid(currentroomid);
		if(classroom==null){
			out.print(false);
		}
		if(classroom!=null){
		  String cid=classroom.getCid();//获取的房间编号
		  if(currentcid.equals(cid)){
		    out.print(false);
		  }else{
			out.print(true); 
		  }
		}
		out.flush();	
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	return SUCCESS;  
	  
  }
  
  public String checkclassroom(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String cid=request.getParameter("cid");
		String roomname=request.getParameter("roomname");
		Classroom classroom=mgr.getClassroomByroomname(roomname);
		if(classroom==null){
			out.print(false);
		}else{
			String currnetcid=classroom.getCid();
			if(currnetcid.equals(cid)){
			out.print(false);
		   }else{
			 out.print(true);	
		   }
		}
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return SUCCESS;
  }
  public String tomanagerparentlettertemplatelist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==5){
		  try {
			List<LetterTemplate> lettertemplatelist=mgr.getLetterTemplateList();
			
			request.setAttribute("lettertemplatelist", lettertemplatelist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return "tomanagerparentlettertemplatelist";
	  }else{
		 return null;  
	  }
  }
  public String tosavetemplate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==5){
		  String name=user.getUser();
		  String title=request.getParameter("title");
		  String content=request.getParameter("editor1");
		  SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  try {
			name = (name != null)?new String(name.getBytes("iso-8859-1"),"utf-8"):name;
			//title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
			//content = (content != null)?new String(content.getBytes("iso-8859-1"),"utf-8"):content;
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  Date now = new Date();
		  LetterTemplate lettertemplate=new LetterTemplate();
		  lettertemplate.setName(name);
		  lettertemplate.setTitle(title);
		  lettertemplate.setContent(content);
		  lettertemplate.setCreatedate(df1.format(now));
		  this.combiz.save(lettertemplate);
		  return "tosavetemplate";	  
	  }else{
		  return null;
	  }
  }
  
  public String toLettertemplatelook(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==5){
		  String lettertemplateid=request.getParameter("lettertemplateid");
		  String deleteid=request.getParameter("deleteid");
		  LetterTemplate lettertemplate=(LetterTemplate) this.combiz.get(LetterTemplate.class, Integer.parseInt(lettertemplateid));
		  if(deleteid!=null && deleteid.equals("1") ){
			  this.combiz.delete(lettertemplate);
			  return "totettertemplatedelete";
		  }else{
			  request.setAttribute("lettertemplate", lettertemplate);
			  return "toLettertemplatelook"; 
		  }
	  }else{
		  return null;
	  }
  }
  public String toupdatetemplate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==5){
		  String lettertemplateid=request.getParameter("lettertemplateid");
		  LetterTemplate lettertemplate=(LetterTemplate) this.combiz.get(LetterTemplate.class, Integer.parseInt(lettertemplateid));
		  SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String title=request.getParameter("title");
		  String content=request.getParameter("editor1");
		  Date now=new Date();
		 /* try {
		   title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
		   content = (content != null)?new String(content.getBytes("iso-8859-1"),"utf-8"):content;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			  lettertemplate.setId(Integer.parseInt(lettertemplateid));
			  lettertemplate.setTitle(title);
			  lettertemplate.setContent(content);
			  lettertemplate.setUpdatedate(df1.format(now));
			  this.combiz.update(lettertemplate);  
			  return "toupdatetemplate";
		  
	  }else{
		  return null;
	  }
  }
  
  public String tomanagerparentletterlist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==5){
		  try {
			//classList=mgr.getClassList();
			List<String> classnamelist=mgr.getClassnameList();
			request.setAttribute("classnamelist", classnamelist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return "tomanagerparentletterlist";
	  }else{
		  return null;
	  }
  }
  public String doallselecttemplate(){
	 HttpServletRequest request=ServletActionContext.getRequest();
	 User user=(User) request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==5){
		try {
		    String studentsid=request.getParameter("studentsid");
			List<LetterTemplate> lettertemplatelist = mgr.getLetterTemplateList();
			request.setAttribute("lettertemplatelist", lettertemplatelist);
			request.setAttribute("studentsid", studentsid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 return "doallselecttemplate" ;
		}else{
		 return null;
	   }
   }
 /* public String doallsendtemplate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	   if(user.getUserType()!=null && user.getUserType()==5){
		  String classname=request.getParameter("classname");
		  try {
			classname = (classname != null)?new String(classname.getBytes("iso-8859-1"),"utf-8"):classname;
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		  String classnames[]=classname.split(",");
		  String lettertemplateid=request.getParameter("lettertemplateid");
		  String lettertemplateids[]=lettertemplateid.split(",");
		  try {
		  for(int i=0;i<classnames.length;i++){
				List<Student> studentlist= mgr.getStudentListByClassnameStatus(String.valueOf(classnames[i]));
				for(Student stu :studentlist){
					String sid=stu.getSid();
				   for(int j=0;j<lettertemplateids.length;j++){
				    LetterTemplate lettertemplate= mgr.getLetterTemplateListById(Integer.parseInt(lettertemplateids[j]));
				    SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    Date now=new Date();
				    String title=lettertemplate.getTitle();
				    String content=lettertemplate.getContent();
				    Jzletter jzletter=new Jzletter();
				    jzletter.setTitle(title);
				    jzletter.setContent(content);
				    jzletter.setSid(sid);
				    jzletter.setSendtime(now);
				    this.combiz.save(jzletter);
				  }
				 }
		      } 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "doallsendtemplate";
		  }else{
			 return null;
		  }
  }*/
  public String doallsendtemplate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	   if(user.getUserType()!=null && user.getUserType()==5){
		  String studentsid=request.getParameter("studentsid");
		  String totalsid=studentsid.substring(0,  studentsid.length() - 1);
		  String lettertemplateid=request.getParameter("lettertemplateid");
		  String lettertemplateids[]=lettertemplateid.split(",");
		  try {
				   for(int j=0;j<lettertemplateids.length;j++){
				    LetterTemplate lettertemplate= mgr.getLetterTemplateListById(Integer.parseInt(lettertemplateids[j]));
				    SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    Date now=new Date();
				    String title=lettertemplate.getTitle();
				    String content=lettertemplate.getContent();
				    Jzletter jzletter=new Jzletter();
				    jzletter.setTitle(title);
				    jzletter.setContent(content);
				    jzletter.setSid(totalsid);
				    jzletter.setSendtime(now);
				    this.combiz.save(jzletter);
				  }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "doallsendtemplate";
		  }else{
			 return null;
		  }
  }
   public String doalljzletterlist(){
	   HttpServletRequest request=ServletActionContext.getRequest();
	   User user=(User) request.getSession().getAttribute("tuser");
	   if(user.getUserType()!=null && user.getUserType()==5){
		   try {
			List<Jzletter> jzlettermgrlist=mgr.getJzletterlist();
			request.setAttribute("jzlettermgrlist", jzlettermgrlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return "doalljzletterlist";
	   }else{
		   return null;
	   }
   }
   public String updatejzletter(){
	   HttpServletRequest request=ServletActionContext.getRequest();
	   User user=(User) request.getSession().getAttribute("tuser");
	   if(user.getUserType()!=null && user.getUserType()==5){
		   try {
          String jzletterid=request.getParameter("jzletterid");
          Jzletter jzletter=(Jzletter) this.combiz.get(Jzletter.class, Integer.parseInt(jzletterid));
          String sid=jzletter.getSid();
          String[] sids=sid.split(",");
          List<Student> list=new ArrayList();
          int num=0;
          System.out.println(sids.length);
          for(int i=0;i<sids.length;i++){
				Student student=mgr.getStudentBySid(sids[i]);
				list.add(student);
				request.setAttribute("jzletter", jzletter);
				request.setAttribute("list", list);
             }
           
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
		   return  "updatejzletter";
		   
	   }else{
		   return null;
	   }
   }
/*   public String updatejzletter(){
	   HttpServletRequest request=ServletActionContext.getRequest();
	   User user=(User) request.getSession().getAttribute("tuser");
	   if(user.getUserType()!=null && user.getUserType()==5){
		   try {
			   String jzletterid=request.getParameter("jzletterid");
			   Jzletter jzletter=(Jzletter) this.combiz.get(Jzletter.class, Integer.parseInt(jzletterid));
			   String sid=jzletter.getSid();
			   String[] sids=sid.split(",");
		getClassroomByroomname	   List<Student> list=new ArrayList();
			   for(int i=0;i<sids.length;i++){
				   Student student=mgr.getStudentBySid(sids[i]);
				   list.add(student);
				   request.setAttribute("jzletter", jzletter);
				   request.setAttribute("list", list);
			   }
			   
			   
		   } catch (Exception e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		   
		   return  "updatejzletter";
		   
	   }else{
		   return null;
	   }
   }
*/   public String  toupdatejzletter(){
	   HttpServletRequest request=ServletActionContext.getRequest();
	   User user=(User) request.getSession().getAttribute("tuser");
	   if(user.getUserType()!=null && user.getUserType()==5){
		   String studentid=request.getParameter("studentid");
		   String jzletterid=request.getParameter("jzletterid");
		   String dejzletterid=request.getParameter("dejzletterid");
		   String title=request.getParameter("title");
		   String content=request.getParameter("editor1");
		   System.out.println(jzletterid!="");
		   if(jzletterid!=""){
			   Jzletter jzletter=(Jzletter) this.combiz.get(Jzletter.class, Integer.parseInt(jzletterid));
			   jzletter.setId(Integer.parseInt(jzletterid));
			   jzletter.setTitle(title);
			   jzletter.setContent(content);
			   jzletter.setSid(studentid);
			   this.combiz.update(jzletter);
			   return "tolookjzletter";  
		   }else{
			   Jzletter jzletter=(Jzletter) this.combiz.get(Jzletter.class, Integer.parseInt(dejzletterid));
			   this.combiz.delete(jzletter);
			   return "tolookjzletter";
		   }
		 
	   }else{
		   return null;  
     }
  }
  public String tomanagersubjectlist(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	   User user=(User) request.getSession().getAttribute("tuser");
	   if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		   try {
			List subjectlist= mgr.getSubjectList();
			request.setAttribute("subjectlist", subjectlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return "tomanagersubjectlist";
	   }else{
		   return null;
	   }
  }
  public String checksubjectname(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String subjectname=request.getParameter("subjectname");
		Subject subject=mgr.getSubjectByName(subjectname);
		if(subject==null){
			 out.print(false);//不存在
		}else{
			 out.print(true);//存在
		}
		 out.flush();
	     out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return SUCCESS;
  }
  public String checksubjectid(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String subid=request.getParameter("subid");
		Subject subject=mgr.getSubjectBySubid(subid);
		if(subject==null){
			 out.print(false);//不存在
		}else{
			out.print(true);//存在
		}
		out.flush();
	    out.close();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
	  return SUCCESS;
  }
  
  public String checkexistsubjectname(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  HttpServletResponse response=ServletActionContext.getResponse();
	  response.setContentType("text/json;charset=utf-8");
	  try {
		PrintWriter out=response.getWriter();
		String subjectname=request.getParameter("subjectname");
		String subjectid=request.getParameter("subjectid");
		Subject subject=mgr.getSubjectByName(subjectname);
		if(subject==null){
			out.print(false);
		}
		if(subject!=null){
			Integer id=subject.getId();
			Integer sub=Integer.parseInt(subjectid);
			if(sub.equals(id)){
				out.print(false);
			}else{
				out.print(true);
			}
		}
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	  return SUCCESS;
  }
   public String checkexistsubid(){
	   HttpServletRequest request=ServletActionContext.getRequest();
	   HttpServletResponse response=ServletActionContext.getResponse();
	   response.setContentType("text/json;charset=utf-8");
	   try {
		PrintWriter out=response.getWriter();
		String subjectid=request.getParameter("subjectid");
		String subid=request.getParameter("subid");
		Subject subject=mgr.getSubjectBySubid(subid);
		if(subject==null){
			out.print(false);
		}else{
			if(subject!=null){
				Integer id=subject.getId();
				Integer _subjectid=Integer.valueOf(subjectid);
				if(_subjectid.equals(id)){
					out.print(false);
				}else{
					out.print(true);
				}
			}	
		}
	    out.flush();
	    out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return SUCCESS;
   }
  public String dosubjectadd(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User)request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){
		  String subjectname=request.getParameter("subjectname").trim();
		  String subid=request.getParameter("subid").trim();
		  try {
			subjectname = (subjectname != null)?new String(subjectname.getBytes("iso-8859-1"),"utf-8"):subjectname;
			subid=(subid!=null)?new String(subid.getBytes("iso-8859-1"),"utf-8"):subid;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  Subject subject=new Subject();
			  subject.setName(subjectname);
			  subject.setSubid(subid);
			  this.combiz.save(subject);
			  return "dosubjectadd";
	    }else{
		 return null;  
	  }
  }
  public String dosubjectupdate(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  User user=(User)request.getSession().getAttribute("tuser");
	  if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4){ 
		  String subjectid=request.getParameter("subjectid");
		  String subjectid_=request.getParameter("subjectid_");
		  Subject subject=(Subject) this.combiz.get(Subject.class, Integer.parseInt(subjectid));
		  if(subjectid!="" && subjectid_==null){
			  request.setAttribute("subject", subject);
			  return "dosubjectupdate";  
		  }else{
			  String subjectname=request.getParameter("subjectname").trim();
			  String subid=request.getParameter("subid").trim();;
			  try {
				  subjectname=(subjectname!=null)?new String(subjectname.getBytes("iso-8859-1"),"utf-8"):subjectname;
				  subid=(subid!=null)?new String(subid.getBytes("iso-8859-1"),"utf-8"):subid;
			  } catch (UnsupportedEncodingException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
			  subject.setName(subjectname);
			  subject.setSubid(subid);
			  this.combiz.update(subject);
			  return "subjectupdate";
		  }
	  }else{
		  return null;
	  }
  }
  
  public String doenterClass(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  String classname=request.getParameter("classname");
	  try {
		  classname=(classname!=null)?new String(classname.getBytes("iso-8859-1"),"utf-8"):classname;
		List studentlist= mgr.getStudentListByClassname(classname);
		request.setAttribute("studentlist", studentlist);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return "doenterClass";
  }
}












  












