package com.cxjava.action;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Adjust;
import org.yeeku.model.Assistant;
import org.yeeku.model.Exam;
import org.yeeku.model.Goods;
import org.yeeku.model.Student;
import org.yeeku.model.TClass;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;

import com.opensymphony.xwork2.ActionSupport;
public class ExamManagerAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(ExamManagerAction.class);

	public List<Exam> rows;
	public int total;
	public int page;
	public String findExamInfo(){
		ExamManagerDao examManagerDao=new ExamManagerDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("tuser");
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		String tclassid="";
		if(sortname.equals("scoreTypeName")){
			sortname="scoreType";
		}
		else if(sortname.equals("examTypeName")){
			sortname="examtype";
		}
		else if(sortname.equals("time")){
			sortname="edate";
		}
		else if(sortname.equals("subjectname")){
			sortname="subjectid";
		}
		else if(sortname.equals("phasename")){
			sortname="phaseid";
		}
		if(!query.equals("")){
			query=query.replaceAll("\\s*", "");
			try {				
				TClass tclass=mgr.getClassByName(query);
				if(null!=tclass){				
					Assistant assistant=mgr.getAssistantByName(user.getUser());
					List<TClass> tclassList=mgr.getClassByAssistantid(assistant.getId());
					if(null!=tclassList&&tclassList.size()>0){
						for (TClass currtclass : tclassList) {
							tclassid=tclassid+currtclass.getId()+",";
						}
					}
					String[] string=tclassid.split(",");
					if(Arrays.asList(string).contains(tclass.getId()+"")){					
						int count=examManagerDao.find_exam_count(tclass.getId()+"");
						rows=examManagerDao.find_exam_list(tclass.getId()+"",sortname,sortorder,(pages-1)*rp,rp);
						this.total=count;
						this.page=pages; 
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
		else{
			
			try {
				//教务和教务主管可以查看所有班级的当前学期的考试安排	
				if(user.getUserType()==3||user.getUserType()==4){
					List<TClass> tclassList=mgr.getClassList();
					if(null!=tclassList&&tclassList.size()>0){
						 for (TClass tclass : tclassList) {
							 tclassid=tclassid+tclass.getId()+",";
						 }
					 }
					tclassid = tclassid.substring(0,tclassid.length()-1);
				}
				//辅导员角色只能查看自己所带班级的当前学期的考试安排	
				else if(user.getUserType()==6){			
					 Assistant assistant=mgr.getAssistantByName(user.getUser());
					 List<TClass> tclassList=mgr.getClassByAssistantid(assistant.getId());
					 if(null!=tclassList&&tclassList.size()>0){
						 for (TClass tclass : tclassList) {
							 tclassid=tclassid+tclass.getId()+",";
						 }
					 }
					 tclassid = tclassid.substring(0,tclassid.length()-1);
				}
				//老师角色只能查看自己所代课班级的当前学期的考试安排
				else if(user.getUserType()==7){
					List<String> tclassnameList = mgr.getDistinctKechengListByTeacher(user.getUser());
					if(null!=tclassnameList&&tclassnameList.size()>0){   					
						for (String tclassname : tclassnameList) {
							TClass tclass=mgr.getClassByName(tclassname);
							if(null!=tclass){   							
								tclassid=tclassid+tclass.getId()+",";
							}
						}
					}
					 tclassid = tclassid.substring(0,tclassid.length()-1);
				}
				//学生角色只能查看自己所在班级的当前学期的考试安排
				else if(user.getUserType()==8){
					 Student student = mgr.getStudentBySid(user.getUser());
					 TClass tclass=mgr.getClassByName(student.getClassname());
					 tclassid = tclass.getId()+"";
				}
				int count=examManagerDao.find_exam_count(tclassid);
				rows=examManagerDao.find_exam_list(tclassid,sortname,sortorder,(pages-1)*rp,rp);
				this.total=count;
				this.page=pages; 
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
			
		}
	}
	
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
