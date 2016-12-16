package com.cxjava.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.dao.AlluserDao;
import org.yeeku.dao.AssistantDao;

public class AlluserAction extends BaseAction{
	
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
	
	public String alluser(){
		AlluserDao userDao=new AlluserDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		if(!query.equals("")){
			 query=query.trim();
			 if(query.equals("院长")){
				 query="2";
			 }
			 if(query.equals("教务主管")){
				 query="3";
			 }
			 if(query.equals("教务员")){
				 query="4";
			 }
			 if(query.equals("学生主管")){
				 query="5";
			 }
			 if(query.equals("辅导员")){
				 query="6";
			 }
			 if(query.equals("任课老师")){
				 query="7";
			 }
			 if(query.equals("学生")){
				 query="8";
			 }
			 if(query.equals("办公室")){
				 query="9";
			 }
			 if(query.equals("离校学生")){
				 query="10";
			 }
			 if(query.equals("在职")){
				 query="1";
			 }
			 if(query.equals("离职")){
				 query="2";
			 }
				int count=userDao.findUserQueryCount(query,qtype);
				rows=userDao.findUserQueryCountList(query,qtype,sortname, sortorder, (pages-1)*rp, rp);
				this.total=count;
				this.page=pages; 
				return SUCCESS; 
		 }else{
			 try {
				 int count=userDao.findUserCount();
				 rows=userDao.findUser(sortname, sortorder,(pages-1)*rp,rp);
				 this.total=count;
				 this.page=pages; 
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			 return SUCCESS;	 
		 }	
		}
}
