package com.cxjava.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.dao.TeacherDao;

public class TeacherAction  extends BaseAction{
	public List rows;
	public int total;
	public int page;
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
	
	public String teacherall(){
		TeacherDao teacherDao=new TeacherDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		 if(!query.equals("")){
			 query=query.trim();
			 if(query.equals("男")){
				 query="1";
			 }
			 if(query.equals("女")){
				 query="2";
			 }
			 if(query.equals("在职")){
				 query="1";
			 }
			 if(query.equals("离职")){
				 query="2";
			 }
				int count=teacherDao.findTeacherQueryCount(query,qtype);
				rows=teacherDao.findTeacherQueryCountList(query,qtype,sortname, sortorder, (pages-1)*rp, rp);
				this.total=count;
				this.page=pages; 
				return SUCCESS; 
		 }else{
			 try {
				 int count=teacherDao.findTeacherCount();
				 rows=teacherDao.findTeacher(sortname, sortorder,(pages-1)*rp,rp);
				 this.total=count;
				 this.page=pages; 
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			 return SUCCESS;	 
		 }	
		}
	
	}
	

