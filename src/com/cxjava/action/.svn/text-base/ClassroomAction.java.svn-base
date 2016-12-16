package com.cxjava.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.dao.AssistantDao;
import org.yeeku.dao.ClassroomDao;

public class ClassroomAction extends BaseAction{

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
	public String classroomall(){
		ClassroomDao classroomDao=new ClassroomDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		query=query.replaceAll("\\s*", "");
		if(!query.equals("")){
			// query=query.trim();
			 if( qtype.equals("type")&& query.equals("机房")){
				 query="1";
			 }
			 if(qtype.equals("type") && query.equals("教室")){
				 query="2";
			 }
			 if(qtype.equals("type") && query.equals("口语室")){
				 query="3";
			 }
				int count=classroomDao.findClassroomQueryCount(query,qtype);
				rows=classroomDao.findClassroomQueryCountList(query,qtype,sortname, sortorder, (pages-1)*rp, rp);
				this.total=count;
				this.page=pages; 
				return SUCCESS; 
		 }else{
			 try {
				 int count=classroomDao.findClassroomCount();
				 rows=classroomDao.findClassroom(sortname, sortorder,(pages-1)*rp,rp);
				 this.total=count;
				 this.page=pages; 
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			 return SUCCESS;	 
		 }	
		}

}
