package org.yeeku.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Adjust;
import org.yeeku.model.Advice;
import org.yeeku.model.Assistant;
import org.yeeku.model.Kecheng;
import org.yeeku.model.Kechengversion;
import org.yeeku.model.Notice;
import org.yeeku.model.Student;
import org.yeeku.model.TClass;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;

import com.alibaba.fastjson.JSONArray;

public class SysNoticeAction extends BaseAction{
	/**
	 * 
	 */
	private List adjustList;
	private List adjustList1;
	private List kechengList;
	private List kecheng_List;
	private List<Student> studentList;
	private List KechengversionList;
	private List <Notice>noticeAllList;
    private List <TClass> tclass;
	private List <Notice> noticeListjw;
	private List <Notice> noticeListfd;
	private List<User> userList;
	private List <Notice> noticeListls;
	private List noticeList;
	public List getKechengList() {
		return kechengList;
	}

	public void setKechengList(List kechengList) {
		this.kechengList = kechengList;
	}

	public List getAdjustList() {
		return adjustList;
	}

	public void setAdjustList(List adjustList) {
		this.adjustList = adjustList;
	}
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List getKechengversionList() {
		return KechengversionList;
	}

	public void setKechengversionList(List kechengversionList) {
		KechengversionList = kechengversionList;
	}
	public List<Notice> getNoticeListjw() {
		return noticeListjw;
	}

	public void setNoticeListjw(List<Notice> noticeListjw) {
		this.noticeListjw = noticeListjw;
	}
	public List<Notice> getNoticeListfd() {
		return noticeListfd;
	}

	public void setNoticeListfd(List<Notice> noticeListfd) {
		this.noticeListfd = noticeListfd;
	}

	public List getNoticeAllList() {
		return noticeAllList;
	}

	public void setNoticeAllList(List noticeAllList) {
		this.noticeAllList = noticeAllList;
	}

	public List<TClass> getTclass() {
		return tclass;
	}

	public void setTclass(List<TClass> tclass) {
		this.tclass = tclass;
	}

	public List<Notice> getNoticeListls() {
		return noticeListls;
	}

	public void setNoticeListls(List<Notice> noticeListls) {
		this.noticeListls = noticeListls;
	}

	public List getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List noticeList) {
		this.noticeList = noticeList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List getKecheng_List() {
		return kecheng_List;
	}

	public void setKecheng_List(List kecheng_List) {
		this.kecheng_List = kecheng_List;
	}

public List getAdjustList1() {
		return adjustList1;
	}

	public void setAdjustList1(List adjustList1) {
		this.adjustList1 = adjustList1;
	}

	/*	public String getAdjustNoticeList(){
	  HttpServletRequest request = ServletActionContext.getRequest();
	  User user=(User) request.getSession().getAttribute("tuser");
	  try {
		  
	  if(user.getUserType()==3||user.getUserType()==4){
			adjustList= mgr.getAdjustList();
	  }
	   if(user.getUserType()==6){
		   String assistant =user.getUser();
		    studentList= mgr.getStudentListByassistant(assistant);
		    for (Student student : studentList) {
		    	String classname=student.getClassname();
		    	adjustList= mgr.getAdjustList(4,classname);
			}
	   }
	   if(user.getUserType()==7){
		  String username=user.getUser();
		  adjustList= mgr.getAdjustByteacher(username);
		  
	   }
	   if(user.getUserType()==8){
		    String sid=user.getUser();
		    studentList= mgr.getStudentList(sid);
		    for (Student student : studentList) {
		    	String classname=student.getClassname();
		    	adjustList= mgr.getAdjustList(4,classname);
			}
	     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  request.setAttribute("adjustList", adjustList);
		return "adjustNoticeList";
	}*/
	public String kechengmanage(){
		HttpServletRequest request=ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("tuser");
		try {
			KechengversionList=mgr.getKechengversionList();
			request.setAttribute("KechengversionList", KechengversionList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "kechengmanage";
	}
	
	public String addKechengversion(){
		
		return "addKechengversion";
	}
	public String dokechengversionAdd(){
		HttpServletRequest request=ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("tuser");
		String name=user.getUser();
		String id=request.getParameter("id");
		String vname=request.getParameter("vname");
		String vid=request.getParameter("vid");
		String createid=request.getParameter("createid");
		String isvalid=request.getParameter("isvalid");
		String createdate=request.getParameter("createdate");
		String description=request.getParameter("description");
		try {
			name = (name != null)?new String(name.getBytes("iso-8859-1"),"utf-8"):name;
			vname = (vname != null)?new String(vname.getBytes("iso-8859-1"),"utf-8"):vname;
			vid = (vid != null)?new String(vid.getBytes("iso-8859-1"),"utf-8"):vid;
			createid = (createid != null)?new String(createid.getBytes("iso-8859-1"),"utf-8"):createid;
			description = (description != null)?new String(description.getBytes("iso-8859-1"),"utf-8"):description;
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Kechengversion kechengversion=new Kechengversion();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(id==null ||id==""){
			kechengversion.setVname(vname);
			kechengversion.setVid(vid);
			kechengversion.setCreateid(name);
			String nowtime=df.format(new Date());
			kechengversion.setCreatedate(nowtime);
			kechengversion.setIsvalid(1);//有效
			kechengversion.setDescription(description);
			this.combiz.save(kechengversion);
		}else{
			kechengversion.setId(Integer.parseInt(id));
			kechengversion.setVname(vname);
			kechengversion.setVid(vid);
			kechengversion.setCreateid(createid);
			kechengversion.setCreatedate(createdate);
			kechengversion.setIsvalid(Integer.parseInt(isvalid));
			kechengversion.setDescription(description);
			this.combiz.update(kechengversion);
		}
	
		return "dokechengversionAdd";
	}
  public String updateKechengversion(){
	  HttpServletRequest request=ServletActionContext.getRequest();
	  String params=request.getParameter("params");
	   Kechengversion kechengversion = (Kechengversion) this.combiz.get(Kechengversion.class, Integer.valueOf(params));
	   request.setAttribute("kechengversion", kechengversion);
	  return "updateKechengversion";
  }
  
  public String dokechengversionUpdate(){
	   
	  return "dokechengversionUpdate";
  }
 public String deleteKechengversion(){
	 HttpServletRequest request=ServletActionContext.getRequest();
	 String params=request.getParameter("params");
	 Kechengversion kechengversion = (Kechengversion) this.combiz.get(Kechengversion.class, Integer.valueOf(params));
	 this.combiz.delete(kechengversion);
	 return "deleteKechengversion";
 }
 public String checkNotice(){
	 try{
	 		HttpServletRequest request = ServletActionContext.getRequest();
	 		User user = (User) request.getSession().getAttribute("tuser");
	 		String username=user.getUser();
	 		List noticelists=new ArrayList();//
	 		List noticelists1=new ArrayList();
	 		List useridlist=null;
	 		List readstatuslist=null;
	 		List noticelistsfd=new ArrayList();//
	 		List noticelistsfd1=new ArrayList();
	 		List noticeliststea=new ArrayList();
	 		List noticelists_tea=new ArrayList();
	 		List useridlistxs=null;
	 		List readstatuslistxs=null;
	 		int count=0;//
	 		int count1=0;//未读取的数量
	 		int count2=0;//读取的数量
	 		int count3=0;
	 		int count4=0;
	 		int count5=0;
	 		int count6=0;
	 		int count7=0;
	 		int count8=0;
	 		int count9=0;
	 		int count10=0;
	 		int count11=0;
	 		int size=0;
	 		int totalCount=0;
	 		int totalCount1=0;
	 		int totalfdCount=0;
	 		int totaljwCount=0;
	 		int totallsCount=0;
	 		if(user.getUserType()!=null && user.getUserType()==3 || user.getUserType()==4 ){
		 			 Integer type=user.getUserType();
		 			 User _user=mgr.getUserBytype(username,type);
			 		 noticeListjw = mgr.getNoticeListBytype("1",0); 
			 		 Integer userid=_user.getId();
			 		for(Notice notice:noticeListjw){
			 			String readstatus=notice.getReadstatus();
			 			String [] readstatuses=readstatus.split(",");
			 			readstatuslist= Arrays.asList(readstatuses);
				 			    ++count;
				 			if(!readstatuslist.contains(String.valueOf(userid))){
				 				++count1;
				 				noticelists.add(notice);//未读取的数量
				 			}
				 			if(readstatuslist.contains(String.valueOf(userid))){
				 				++count3;
				 				noticelists1.add(notice);//读取过的数量
				 			}   
			 		  }
		 			noticeListfd = mgr.getNoticeListBytype("2",0);
			 		for(Notice notice:noticeListfd){
			 			String readstatus=notice.getReadstatus();
			 			String [] readstatuses=readstatus.split(",");
			 			readstatuslist= Arrays.asList(readstatuses);
			 				   ++count4;
					 			if(!readstatuslist.contains(String.valueOf(userid))){
					 				++count5;//未读取的数量
					 				noticelistsfd.add(notice);
					 			}
					 		   if(readstatuslist.contains(String.valueOf(userid))){
					 				++count7;//读取过的数量
					 				noticelistsfd1.add(notice);
					 			}  
			 		   }
			 		List<Notice> notice_list=mgr.getNoticeByusernametype(5,"");
			 		 if(notice_list!=null && notice_list.size()>0){
			 			 size+=notice_list.size(); 
			 		 }else{
			 			 size=0;
			 		 }
			 		 request.setAttribute("size", size);
			 		 request.setAttribute("count_number", notice_list.size());
			 		 request.setAttribute("notice_list", notice_list);
	 	     	}
	 		
	 		if(user.getUserType()!=null && user.getUserType()==5){
	 			 Integer type=user.getUserType();
	 			 User _user=mgr.getUserBytype(username,type); 
		 		 noticeListjw = mgr.getNoticeListBytype("1",4);
		 		 Integer userid=_user.getId();
		 		for(Notice notice:noticeListjw){
		 			String readstatus=notice.getReadstatus();
		 			String [] readstatuses=readstatus.split(",");
		 			readstatuslist= Arrays.asList(readstatuses);
			 			    ++count;
			 			if(!readstatuslist.contains(String.valueOf(userid))){
			 				++count1;
			 				noticelists.add(notice);//未读取的数量
			 			}
			 			if(readstatuslist.contains(String.valueOf(userid))){
			 				++count3;
			 				noticelists1.add(notice);//读取过的数量
			 			}   
		 		  }
	 			noticeListfd = mgr.getNoticeListBytype("2",4);
		 		for(Notice notice:noticeListfd){
		 			String readstatus=notice.getReadstatus();
		 			String [] readstatuses=readstatus.split(",");
		 			readstatuslist= Arrays.asList(readstatuses);
		 				   ++count4;
				 			if(!readstatuslist.contains(String.valueOf(userid))){
				 				++count5;//未读取的数量
				 				noticelistsfd.add(notice);
				 			}
				 		   if(readstatuslist.contains(String.valueOf(userid))){
				 				++count7;//读取过的数量
				 				noticelistsfd1.add(notice);
				 			}  
		 		   }
			 	        noticeListls = mgr.getNoticeListBytype("3",4);
			 	       for (Notice notice : noticeListls) {
							String userNotice=notice.getUserid(); 
							String readstatus=notice.getReadstatus();	
							String[] readstatuses=readstatus.split(",");
							readstatuslistxs= Arrays.asList(readstatuses);
							Integer classid=notice.getClassid();
				 			        	++count8;//总数量
				 						if(!readstatuslistxs.contains(String.valueOf(userid))){
				 							++count9;//未读取的数量
				 							noticeliststea.add(notice);
				 						}
				 						if(readstatuslistxs.contains(String.valueOf(userid))){
				 							++count11;//读取过的数量
				 							noticelists_tea.add(notice);
				 						}		
				 			       }
	 	     	          }
	 		if(user.getUserType()!=null && user.getUserType()==6){
	 			String name=user.getUser();
	 			Assistant assistant=mgr.getAssistantByName(name);
	 		    Integer assistanid=assistant.getId();
	 			String currentsid=assistant.getAid();
	 			   noticeListjw = mgr.getNoticeListBytype("1",3);//
	 				for (Notice notice : noticeListjw) {
	 					String userNotice=notice.getUserid();
	 					String readstatus=notice.getReadstatus();
	 					Integer classid=notice.getClassid();
	 					String[] userNoticeId=userNotice.split(",");
	 					String[] readstatuses=readstatus.split(",");
	 					useridlist= Arrays.asList(userNoticeId);
	 					readstatuslist= Arrays.asList(readstatuses);	
	 					if(useridlist.contains(String.valueOf(assistanid)) || useridlist.contains("0") && classid.equals(0) ){
	 						++count;//总数量
	 						if(readstatuslist.contains("0")){
	 							++count1;
	 							noticelists.add(notice);//未读取的数量
	 						}
	 						if(!readstatuslist.contains("0") && !readstatuslist.contains(currentsid)){
	 							++count2;
	 							noticelists.add(notice);//未读取的数量
	 						}
	 						if(!readstatuslist.contains("0") && readstatuslist.contains(currentsid)){
	 							++count3;
	 							noticelists1.add(notice);//读取过的数量
	 						}	  
	 					}  
	 					  if(!classid.equals(0)){
	 						TClass tClass=(TClass) this.combiz.get(TClass.class, classid);
	 	 					Integer _assistanid=tClass.getAssistantid();
	 	 					Assistant astant=(Assistant) this.combiz.get(Assistant.class, _assistanid);
	 	 					if(astant!=null){
	 	 						String sid=astant.getAid();
	 	 						if(currentsid.equals(sid)){
	 	 							++count;
	 	 							if(!readstatuslist.contains(currentsid)){
	 	 								++count1;
	 	 								noticelists.add(notice);//未读取的数量
	 	 							}
	 	 							if(readstatuslist.contains(currentsid)){
	 	 								++count3;
	 	 								noticelists1.add(notice);//读取过的数量
	 	 							}
	 	 						}	
	 	 					  }
	 		 				}  
	 					  } 
	 		 		noticeListfd = mgr.getNoticeListBytype("2",3);
	 				for (Notice notice : noticeListfd) {
	 					String userNotice=notice.getUserid();
	 					String readstatus=notice.getReadstatus();
	 					Integer classid=notice.getClassid();
	 					String[] userNoticeId=userNotice.split(",");
	 					String[] readstatuses=readstatus.split(",");
	 					useridlistxs= Arrays.asList(userNoticeId);
	 					readstatuslistxs= Arrays.asList(readstatuses);
	 					if(useridlistxs.contains(String.valueOf(assistanid)) || useridlistxs.contains("0") && classid.equals(0)){
	 						++count4;//总数量
	 						if(readstatuslistxs.contains("0")){
	 							++count5;
	 							noticelistsfd.add(notice);//未读取的数量
	 						}
	 						if(!readstatuslistxs.contains("0") && !readstatuslistxs.contains(currentsid)){
	 							++count6;
	 							noticelistsfd.add(notice);//未读取的数量
	 						}
	 						if(!readstatuslistxs.contains("0") && readstatuslistxs.contains(currentsid)){
	 							++count7;//读取过的数量
	 							noticelistsfd1.add(notice);
	 						}	  
	 					}
	 					 if(!classid.equals(0)){
	 						TClass tClass=(TClass) this.combiz.get(TClass.class, classid);
		 					Integer _assistanid=tClass.getAssistantid();
		 					Assistant astant=(Assistant) this.combiz.get(Assistant.class, _assistanid);
		 					String sid=astant.getAid();
	 		 					if(currentsid.equals(sid)){
	 		 						++count4;//总数量
	 		 						if(!readstatuslistxs.contains(currentsid)){
	 		 							++count5;//未读取的数量
	 		 							noticelistsfd.add(notice);//未读取的数量
	 		 						}
	 		 						if(readstatuslistxs.contains(currentsid)){
	 		 							++count7;//读取过的数量
	 		 							noticelistsfd1.add(notice);//读取过的数量
	 		 						}
	 		 					}
	 		 				}  
	 			    	}	
	 			    noticeListls = mgr.getNoticeListBytype("3",3);//老师通知
	 				for (Notice notice : noticeListls) {
	 					String readstatus=notice.getReadstatus();
	 					String[] readstatuses=readstatus.split(",");
	 					List readstatuslist_assist= Arrays.asList(readstatuses);
	 					Integer classid=notice.getClassid();
	 					TClass tClass=(TClass) this.combiz.get(TClass.class, classid);
	 					Integer _assistanid=tClass.getAssistantid();
	 					Assistant astant=(Assistant) this.combiz.get(Assistant.class, _assistanid);
	 					if(astant!=null){
	 						String sid=astant.getAid();
	 						if(currentsid.equals(sid)){
	 							++count8;
	 							if(!readstatuslist_assist.contains(currentsid)){
	 								++count9;
	 								noticeliststea.add(notice);//未读取的数量
	 							}
	 							if(readstatuslist_assist.contains(currentsid)){
	 								++count11;
	 								noticelists_tea.add(notice);//读取过的数量
	 							}
	 						}
	 						
	 					}
	 				}
	 		  List tclasslist= mgr.getClassListByAssistantid(assistanid);
	 		  String _classid = "";
	 		  if(tclasslist!=null && tclasslist.size()>0){
	 			  for (int i=0;i<tclasslist.size();i++ ) {
	 				  TClass cal = (TClass) tclasslist.get(i);
	 				 _classid = _classid + cal.getId() + ",";
	 				 
	 			  }
	 			 _classid = _classid.substring(0, _classid.length() - 1);
	 		  }
	 		   List<Notice> notice_list=mgr.getNoticeByassistantclassestype(5,_classid);
	 		   if(notice_list!=null && notice_list.size()>0){
	 				 size+=notice_list.size(); 
		 		 }else{
		 			 size=0; 
	 		   }
	 		   request.setAttribute("size",size );
	 		   request.setAttribute("notice_list", notice_list);
          }
	 		if(user.getUserType()!=null && user.getUserType()==7){	
	 			String name=user.getUser();
	 			Teacher teacher=mgr.getTeacherByName(name);
	 			Integer teacherid=teacher.getId();
	 			String teacherttid=teacher.getTid();
	 			noticeListjw = mgr.getNoticeListBytype("1",2);//教务通知
	 				for (Notice notice : noticeListjw) {
	 					String userNotice=notice.getUserid();
	 					Integer classid=notice.getClassid();
	 					String readstatus=notice.getReadstatus();	
	 					String[] userNoticeId=userNotice.split(",");
	 					String[] readstatuses=readstatus.split(",");
	 					useridlist= Arrays.asList(userNoticeId);
	 					readstatuslist= Arrays.asList(readstatuses);
	 					if(useridlist.contains(String.valueOf(teacherid)) || useridlist.contains("0") && classid.equals(0)){
	 						++count;//总数量
	 						if(readstatuslist.contains("0")){
	 							++count1;//未读取的数量
	 							noticelists.add(notice);
	 						}
	 						if(!readstatuslist.contains("0") && !readstatuslist.contains(teacherttid)){
	 							++count2;//未读取的数量
	 							noticelists.add(notice);
	 						}
	 						if(!readstatuslist.contains("0") && readstatuslist.contains(teacherttid)){
	 							++count3;//读取过的数量
	 							noticelists1.add(notice);
	 						}	  
	 					}
	 					if(!classid.equals(0)){
	 					kechengList=mgr.getKechengListClassByTeacher1(name) ;
	 					if(kechengList!=null && kechengList.size()>0){
	 					for(int i=0;i<kechengList.size();i++){
	 					 Object object[] = (Object[]) kechengList.get(i);
	 					 TClass tclass=mgr.getClassByName((String) object[0]);
	 					 Integer classid1=tclass.getId();
	 				     if(useridlist.contains("0") && classid.equals(classid1)){
	 							++count;
	 							if(readstatuslist.contains("0")){
	 								++count1;//未读取的数量
	 								noticelists.add(notice);
	 							}
	 							if(!readstatuslist.contains("0") && !readstatuslist.contains(teacherttid)){
	 								++count2;//未读取的数量
	 								noticelists.add(notice);
	 							}
	 							if(!readstatuslist.contains("0") && readstatuslist.contains(teacherttid)){
	 								++count3;//读取过的数量
	 								noticelists1.add(notice);
	 							}
	 					   }
	 				      }
	 				    }
	 				  }
	 				}
	 		 		noticeListfd = mgr.getNoticeListBytype("2",2);//辅导员通知
	 				for (Notice notice : noticeListfd) {
	 					String userNotice=notice.getUserid();
	 					String readstatus=notice.getReadstatus();
	 					Integer classid=notice.getClassid();
	 					String[] userNoticeId=userNotice.split(",");
	 					String[] readstatuses=readstatus.split(",");
	 					useridlistxs= Arrays.asList(userNoticeId);
	 					readstatuslistxs= Arrays.asList(readstatuses);
	 					if(useridlistxs.contains(String.valueOf(teacherid)) || useridlistxs.contains("0") && classid.equals(0)){
 	 						++count4;//总数量
	 						if(readstatuslistxs.contains("0")){
	 							++count5;//未读取的数量
	 							noticelistsfd.add(notice);
	 						}
	 						if(!readstatuslistxs.contains("0") && !readstatuslistxs.contains(teacherttid)){
	 							++count6;//未读取的数量
	 							noticelistsfd.add(notice);
	 						}
	 						if(!readstatuslistxs.contains("0") && readstatuslistxs.contains(teacherttid)){
	 							++count7;//读取过的数量
	 							noticelistsfd1.add(notice);
	 						}	  
	 					}
	 					if(!classid.equals(0)){
	 						kechengList=mgr.getKechengListClassByTeacher1(name); 
	 						if(kechengList!=null && kechengList.size()>0){
	 							for(int i=0;i<kechengList.size();i++){
	 								Object object[] = (Object[]) kechengList.get(i); 
	 								TClass tclass=mgr.getClassByName((String) object[0]);
	 								Integer classid1=tclass.getId();
	 								if(useridlistxs.contains("0") && classid.equals(classid1)){
	 									if(classid.equals(classid1)){
	 										++count4;
	 										if(readstatuslistxs.contains("0")){
	 											++count5;//未读取的数量
	 											noticelistsfd.add(notice);
	 										}
	 										if(!readstatuslistxs.contains("0") && !readstatuslistxs.contains(teacherttid)){
	 											++count6;//未读取的数量
	 											noticelistsfd.add(notice);
	 										}
	 										if(!readstatuslistxs.contains("0") && readstatuslistxs.contains(teacherttid)){
	 											++count7;//读取过的数量
	 											noticelistsfd1.add(notice);
	 										}
	 									}
	 								}
	 							}
	 						}
	 					}
	 			}
	 		  noticeListls = mgr.getNoticeListBytype("3",4);//老师通知
	 		 for (Notice notice : noticeListls) {
					String readstatus=notice.getReadstatus();
					String[] readstatuses=readstatus.split(",");
					List tea_readstatuslist= Arrays.asList(readstatuses);
					Integer classid=notice.getClassid();
					TClass tclass=(TClass) this.combiz.get(TClass.class, classid);
					String clssname=tclass.getName();
					List kechengClasslist=mgr.getKechengListClassByclassname(clssname);
				    List _teacherlist=new ArrayList();
				     if(kechengClasslist!=null && kechengClasslist.size()>0){
				    	 for(int i=0;i<kechengClasslist.size();i++){
				    		 Object[] object = (Object[]) kechengClasslist.get(i); 
				    		 _teacherlist=Arrays.asList(object);
				    		 if(_teacherlist.contains(name)){
				    			 ++count8;//总数量
				    		 if(!tea_readstatuslist.contains(teacherttid)){
									++count9;//未读数量
									noticeliststea.add(notice);
								}
							if(tea_readstatuslist.contains(teacherttid)){
									++count11;//已读数量
									noticelists_tea.add(notice);	
							  	}
						 	}
				    	 }
				    }
	 		   }
	 	   List<Notice> notice_list=mgr.getNoticeByusernametype(5,name);
	 		 if(notice_list!=null && notice_list.size()>0){
	 			 size+=notice_list.size(); 
	 		 }else{
	 			 size=0;
	 		 }
	 		 request.setAttribute("size", size);
	 		 request.setAttribute("count_number", notice_list.size());
	 		 request.setAttribute("notice_list", notice_list);
	 	  }
	 		if( user.getUserType()!=null && user.getUserType()==8 ){
	 			 String sid=user.getUser();
	 			 Integer classID=null;
	 			 String name=user.getUser();
	 			 studentList=mgr.getStudentList(sid);
		 		 noticeListjw = mgr.getNoticeListBytype("1",4); 
		 		for(Notice notice:noticeListjw){
		 			String readstatus=notice.getReadstatus();
		 			String userNotice=notice.getUserid();
		 			String [] readstatuses=readstatus.split(",");
		 			readstatuslist= Arrays.asList(readstatuses);
		 			Integer classid=notice.getClassid();
			 		 for(Student student:studentList){
			 			String classname=student.getClassname();
			 			TClass tclass=mgr.getClassByName(classname);
			 		    classID=tclass.getId();
			 		 }
		 			if(classid==0){
	 					++count;
	 					if(readstatuslist.contains("0")){
 							++count1;
 							noticelists.add(notice);//未读取的数量
 						}
 						if(!readstatuslist.contains("0") && !readstatuslist.contains(sid)){
 							++count2;
 							noticelists.add(notice);//未读取的数量
 						}
 						if(!readstatuslist.contains("0") && readstatuslist.contains(sid)){
 							++count3;
 							noticelists1.add(notice);//读取过的数量
 						}	  
	 				}
		 		   if(classid.equals(classID)){
		 			  ++count;
	 					if(readstatuslist.contains("0")){
							++count1;
							noticelists.add(notice);//未读取的数量
						}
						if(!readstatuslist.contains("0") && !readstatuslist.contains(sid)){
							++count2;
							noticelists.add(notice);//未读取的数量
						}
						if(!readstatuslist.contains("0") && readstatuslist.contains(sid)){
							++count3;
							noticelists1.add(notice);//读取过的数量
						}	
		 		     }
		 		  }
		 	    noticeListfd = mgr.getNoticeListBytype("2",4);
		 	   for (Notice notice : noticeListfd) {
					String userNotice=notice.getUserid();
					String readstatus=notice.getReadstatus();	
					String[] readstatuses=readstatus.split(",");
					readstatuslistxs= Arrays.asList(readstatuses);
					Integer classid=notice.getClassid();
			 		 for(Student student:studentList){
			 			String classname=student.getClassname();
			 			TClass tclass=mgr.getClassByName(classname);
			 		    classID=tclass.getId();
			 	     }
	 			       if(classid==0){
	 						++count4;//总数量
	 						if(readstatuslistxs.contains("0")){
	 							++count5;//未读取的数量
	 							noticelistsfd.add(notice);
	 						}
	 						if(!readstatuslistxs.contains("0") && !readstatuslistxs.contains(sid)){
	 							++count6;//未读取的数量
	 							noticelistsfd.add(notice);
	 						}
	 						if(!readstatuslistxs.contains("0") && readstatuslistxs.contains(sid)){
	 							++count7;//读取过的数量
	 							noticelistsfd1.add(notice);
	 						 }	  	 
	 					 }
		 			    if(classid.equals(classID)){
		 			        	++count4;//总数量
		 						if(readstatuslistxs.contains("0")){
		 							++count5;//未读取的数量
		 							noticelistsfd.add(notice);
		 						}
		 						if(!readstatuslistxs.contains("0") && !readstatuslistxs.contains(sid)){
		 							++count6;//未读取的数量
		 							noticelistsfd.add(notice);
		 						}
		 						if(!readstatuslistxs.contains("0") && readstatuslistxs.contains(sid)){
		 							++count7;//读取过的数量
		 							noticelistsfd1.add(notice);
		 						}		
		 			       }
		 			   }
		 	        noticeListls = mgr.getNoticeListBytype("3",4);
		 	       for (Notice notice : noticeListls) {
						String userNotice=notice.getUserid();
						String readstatus=notice.getReadstatus();	
						String[] readstatuses=readstatus.split(",");
						readstatuslistxs= Arrays.asList(readstatuses);
						Integer classid=notice.getClassid();
				 		 for(Student student:studentList){
				 			String classname=student.getClassname();
				 			TClass tclass=mgr.getClassByName(classname);
				 		    classID=tclass.getId();
				 	     }
			 			    if(classid.equals(classID)){
			 			        	++count8;//总数量
			 						if(readstatuslistxs.contains("0")){
			 							++count9;//未读取的数量
			 							noticeliststea.add(notice);
			 						}
			 						if(!readstatuslistxs.contains("0") && !readstatuslistxs.contains(sid)){
			 							++count10;//未读取的数量
			 							noticeliststea.add(notice);
			 						}
			 						if(!readstatuslistxs.contains("0") && readstatuslistxs.contains(sid)){
			 							++count11;//读取过的数量
			 							noticelists_tea.add(notice);
			 						}		
			 			       }
			 			   }
		 	      for(Student student:studentList){
		 	    	  String classname=student.getClassname();
		 	    	  TClass tClass=mgr.getClassByName(classname);
		 	    	  List<Notice> notice_list=mgr.getNoticeBystudentclassestype(5,tClass.getId());
		 	    	  if(notice_list!=null && notice_list.size()>0){
		 	    		  size=notice_list.size();
		 	    	  }else{
		 	    		  size=0;
		 	    	  }
		 	    	  request.setAttribute("size", size);
		 	    	  request.setAttribute("notice_list", notice_list);
		 	      }
		 		 }
		 		request.setAttribute("noticelists", noticelists);
		 		request.setAttribute("noticelists1", noticelists1);
		 		totaljwCount=count1+count2;//未读取总数量	
		 		totalfdCount=count5+count6;
		 	    totallsCount=count9+count10;
		 	    totalCount=count+count4+size;//总数量
		 	    totalCount1=count+count4+count8+size;//总数量
		 	    request.setAttribute("totaljwCount", totaljwCount);
		 	    request.setAttribute("count", count);
		 	    request.setAttribute("totalCount", totalCount);
		 	    request.setAttribute("totalCount1", totalCount1);
		 		request.setAttribute("totalfdCount", totalfdCount);
		 		request.setAttribute("totallsCount", totallsCount);
		 		request.setAttribute("count4", count4);
		 		request.setAttribute("noticelistsfd", noticelistsfd);
		 		request.setAttribute("noticelistsfd1", noticelistsfd1);
		 		request.setAttribute("noticeliststea", noticeliststea);
		 		request.setAttribute("noticelists_tea", noticelists_tea);
		 	}catch(Exception e){
		 		e.printStackTrace();
		 	}
		 return "checkNotice";
	  }
 public String noticeDetails(){
	    try {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   User user = (User) request.getSession().getAttribute("tuser");
		   if(user.getUserType()==3 || user.getUserType()==4 ||user.getUserType()==5){
			  String name=user.getUser();
			  Integer id=user.getId();
			  String roleid=request.getParameter("roleid");
			  Notice notice=(Notice) this.combiz.get(Notice.class, Integer.parseInt(roleid));
			  String readstatus=notice.getReadstatus();
			  if(readstatus.equals("0")){ 
				   notice.setReadstatus(String.valueOf(id));
				   this.combiz.update(notice);
			   }else{
				   String[] readstatuses=readstatus.split(",");
				   List list= Arrays.asList(readstatuses);
				   if(!list.contains(String.valueOf(id))){
					   readstatus+=","+String.valueOf(id);				
					   notice.setReadstatus(readstatus);
					   this.combiz.update(notice);
				   } 
			   }
			   request.setAttribute("notice", notice);  
		   }
		    
		   
		   if(user.getUserType()==6){
				 String name=user.getUser();
				  Assistant assistant=mgr.getAssistantByName(name);
				  String assistanttid=assistant.getAid();
				  String roleid=request.getParameter("roleid");
				  Notice notice=(Notice) this.combiz.get(Notice.class, Integer.parseInt(roleid));
				  String readstatus=notice.getReadstatus();
				  if(readstatus.equals("0")){ 
					   notice.setReadstatus(assistanttid);
					   this.combiz.update(notice);
				   }else{
					   String[] readstatuses=readstatus.split(",");
					   List list= Arrays.asList(readstatuses);
					   if(!list.contains(assistanttid)){
						   readstatus+=","+assistanttid;				
						   notice.setReadstatus(readstatus);
						   this.combiz.update(notice);
					   } 
				   }
				   request.setAttribute("notice", notice);  
			   }  
		   if(user.getUserType()==7){
			   String name=user.getUser();
			   Teacher teacher=mgr.getTeacherByName(name);
			   String teacherttid=teacher.getTid();
			   String roleid=request.getParameter("roleid");
			   System.out.println(roleid);
			   Notice notice=(Notice) this.combiz.get(Notice.class, Integer.parseInt(roleid));
			   String readstatus=notice.getReadstatus();
			   if(readstatus.equals("0")){ 
				   notice.setReadstatus(teacherttid);
				   this.combiz.update(notice);
			   }else{
				   // String readStatuses=notice.getReadstatus();
				   String[] readstatuses=readstatus.split(",");
				   List list= Arrays.asList(readstatuses);
				   if(!list.contains(teacherttid)){
					   readstatus+=","+teacherttid;				
					   notice.setReadstatus(readstatus);
					   this.combiz.update(notice);
				   }
				   
			   }
			   request.setAttribute("notice", notice);
			   
		   }
		 if(user.getUserType()==8){
			 String studentSid=user.getUser();
			 String roleid=request.getParameter("roleid");
			  Notice notice=(Notice) this.combiz.get(Notice.class, Integer.parseInt(roleid));
			  String readstatus=notice.getReadstatus();
			  if(readstatus.equals("0")){ 
				   notice.setReadstatus(studentSid);
				   this.combiz.update(notice);
			   }else{
				   // String readStatuses=notice.getReadstatus();
				   String[] readstatuses=readstatus.split(",");
				   List list= Arrays.asList(readstatuses);
				   if(!list.contains(studentSid)){
					   readstatus+=","+studentSid;				
					   notice.setReadstatus(readstatus);
					   this.combiz.update(notice);
				   }
				   
			   }
			   request.setAttribute("notice", notice);
		 }
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return "noticeDetails";
	   }
	   
	   public String deleteNotice(){
		   HttpServletRequest request=ServletActionContext.getRequest();
		   String noticeid=request.getParameter("noticeId"); 
		   Notice notice=(Notice) this.combiz.get(Notice.class, Integer.parseInt(noticeid));
		   this.combiz.delete(notice);
		   return "deleteNotice";
	   } 
	   public String returnNotice(){
		    HttpServletRequest request=ServletActionContext.getRequest();
		    String noticeid=request.getParameter("noticeId");
		    Notice notice=(Notice)this.combiz.get(Notice.class,Integer.parseInt(noticeid));
		    String userid=notice.getUserid();
		    Integer type=notice.getType();
		    Integer classid=notice.getClassid();
		    List<Teacher> teach=new ArrayList<Teacher>();
		    List<Assistant> assist=new ArrayList<Assistant>();
		    String[] userids=userid.split(",");
		    List<String> list= Arrays.asList(userids);
		    if(type!=null && type==2){
		    	if(userid!=null || userid!=""){
		    		for (String id : list) {
		    			Teacher teacher=(Teacher) this.combiz.get(Teacher.class, Integer.parseInt(id));
		    			teach.add(teacher);
		    		}
		    	}
		    }
		    if(type!=null && type==3){
		    	if(userid!=null || userid!=""){
		    		for(String id:list){
		    			Assistant assistant=(Assistant) this.combiz.get(Assistant.class, Integer.parseInt(id));
		    			assist.add(assistant);
		    		}
		    	}	
		    }
		    if(type!=null && type==4){
		    	TClass tclass=(TClass) this.combiz.get(TClass.class, classid);
		    	request.setAttribute("tclass", tclass);
		    }
		    request.setAttribute("notice", notice);
		    request.setAttribute("teach", teach);
		    request.setAttribute("assist", assist);
		    return "returnNotice";
	   }
	   
	   public String check_notice(){
		   try {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out=response.getWriter();
			String noticeid=request.getParameter("id");
			Notice notice=(Notice) this.combiz.get(Notice.class, Integer.parseInt(noticeid));
			if(notice.getStatus()==2){
				out.print(false);
			}
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		   return SUCCESS;
	   }
	   public String doNoticeUpdate(){
		   HttpServletRequest request=ServletActionContext.getRequest();
		   String id=request.getParameter("id");
		   String type=request.getParameter("type");
		   String title=request.getParameter("noticetitle");
		   String content=request.getParameter("noticecontent");
		   String classid=request.getParameter("classid");
		   String setpeopleallbox=request.getParameter("setpeopleallbox");
		   String publisherid=request.getParameter("publisherid");
		   String noticepublishdate=request.getParameter("noticepublishdate");
		   String noticeusername=request.getParameter("noticeusername");
		   String readstatus=request.getParameter("readstatus");
		   String assistantid=request.getParameter("assistantid");
		   String teacherid=request.getParameter("teacherid");
		   String noticeType=request.getParameter("noticeType");
		   String status=request.getParameter("status");
		   try {
			title = (title != null)?new String(title.getBytes("iso-8859-1"),"utf-8"):title;
			content=(content!=null)?new String(content.getBytes("iso-8859-1"),"utf-8"):content;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Notice notice=(Notice) this.combiz.get(Notice.class, Integer.parseInt(id));
		   notice.setId(Integer.parseInt(id));
		   notice.setType(Integer.parseInt(type));
		   notice.setTitle(title);
		   notice.setContent(content);
		   notice.setClassid(Integer.parseInt(classid));
		   notice.setPublisherid(Integer.parseInt(publisherid));
		   notice.setPublishdate(noticepublishdate);
		   notice.setUsername(noticeusername);
		   notice.setReadstatus(readstatus);
		   if(type!=null && type.equals("1")){
			   notice.setUserid(setpeopleallbox);
		   }
		   if(type!=null && type.equals("2")){
			   notice.setUserid(teacherid);   
		   }
		   if(type!=null && type.equals("3")){
			   notice.setUserid(assistantid);
		   }
		   if(noticeType.equals("1")){
			   notice.setNoticetype("1");
		   }
		   if(noticeType.equals("2")){
			   notice.setNoticetype("2");
		   }
		   if(noticeType.equals("3")){
			   notice.setNoticetype("3");
		   }
		   if(noticeType.equals("4")){
			   notice.setNoticetype("4");
		   }
		   notice.setStatus(Integer.parseInt(status));
		   this.combiz.update(notice);
		   return "doNoticeUpdate";
	   }
	   public String jiaowuself(){
		   HttpServletRequest request=ServletActionContext.getRequest();
		   User user = (User) request.getSession().getAttribute("tuser");
		   Integer roleid=user.getUserType();
		   String username=user.getUser();
			try {
				if(user.getUserType()==3 || user.getUserType()==4){
					noticeList = mgr.getNoticeListByPublisheridStatus("1",username);
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
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   request.setAttribute("username", username);
		   request.setAttribute("noticeList", noticeList);
		   request.setAttribute("roleid", roleid);
		   return "jiaowuself";
	   }
	   public String jiaowuAssistant(){
		   HttpServletRequest request=ServletActionContext.getRequest();
		   User user = (User) request.getSession().getAttribute("tuser");
		   String username=user.getUser();
		   Integer roleid=user.getUserType();
			try {
				if(user.getUserType()==3 || user.getUserType()==4){
					noticeList = mgr.getNoticeListByPublisheridStatus("1",username);
				}
				if(user.getUserType()==5 || user.getUserType()==6){
					noticeList = mgr.getNoticeListByPublisheridStatus("2",username);
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
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   request.setAttribute("roleid", roleid);
		   request.setAttribute("username", username);
		   request.setAttribute("noticeList", noticeList);
		   return "jiaowuAssistant";
	   }
	   public String jiaowuTeacher(){
		   HttpServletRequest request=ServletActionContext.getRequest();
		   User user = (User) request.getSession().getAttribute("tuser");
		   String username=user.getUser();
		   Integer roleid=user.getUserType();
		   try {
				if(user.getUserType()==3 || user.getUserType()==4){
					noticeList = mgr.getNoticeListByPublisheridStatus("1",username);
				}
				if(user.getUserType()==5 ||user.getUserType()==6){
					noticeList = mgr.getNoticeListByPublisheridStatus("2",username);
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   request.setAttribute("noticeList", noticeList);
		   request.setAttribute("username", username);
		   request.setAttribute("roleid", roleid);
		   return "jiaowuTeacher";
	   }
	   public String jiaowucheckroile(){
		   try {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   HttpServletResponse response=ServletActionContext.getResponse();
		   User user=(User) request.getSession().getAttribute("tuser");
		   String id=request.getParameter("id");
		   Integer roleid=user.getUserType();
		   String username=user.getUser();
		   List<Student> stuList=new ArrayList<Student>();
			 Notice notice=(Notice) this.combiz.get(Notice.class, Integer.parseInt(id));
			// System.out.println(notice.getContent()+" "+notice.getTitle()+notice.getClassid()+" "+notice.getUserid());
			 Integer type=notice.getType();
			 Integer classid=notice.getClassid();
			 String readstatus=notice.getReadstatus();
			 String[] readstatuses=readstatus.split(",");
			 List<String> readstatuslistxs= Arrays.asList(readstatuses);
			 if(type!=null && type==1){
			 List<Student> studentList =mgr.getStudentListByStatus();
			 if(studentList!=null && studentList.size()>0){
			 for (Student student : studentList) {
				if(!readstatuslistxs.contains(student.getSid())){
					//System.out.println("----"+student.getSid());
					Student stu=mgr.getStudentBySid(student.getSid());
					stuList.add(stu);	
				  }			
			   } 
		   }
	 }
			 if(type!=null && type==4 && classid!=null){
				 TClass tclass=(TClass) this.combiz.get(TClass.class, classid);
				 String classname=tclass.getName();
				 studentList=mgr.getStudentListByClassnameStatus(classname);
				  if(studentList!=null && studentList.size()>0){
				 for (Student student : studentList) {
					 if(!readstatuslistxs.contains(student.getSid())){
							//System.out.println("----"+student.getSid());
							Student stu=mgr.getStudentBySid(student.getSid());
							stuList.add(stu);	
						 }	
				   }
			    }
			 }
		    request.setAttribute("stuList",stuList);
		   } catch (Exception e) {
			   e.printStackTrace();
			}
		   return "jiaowucheckroile";
	   }
	}