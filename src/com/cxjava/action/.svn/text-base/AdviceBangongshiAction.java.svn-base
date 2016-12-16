package com.cxjava.action;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Adjust;
import org.yeeku.model.Advice;
import org.yeeku.model.Goods;
import org.yeeku.model.Student;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
public class AdviceBangongshiAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(AdviceBangongshiAction.class);

	public List<Advice> rows;
	public int total;
	public int page;
	public String findAllAdvice(){

		AdviceBangongshiDao adviceDao=new AdviceBangongshiDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
		User user = (User) request.getSession().getAttribute("tuser");
		Integer roleid=user.getUserType();
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值
		if(null!=query&&!query.equals("")){
			query=query.replaceAll("\\s*", "");
		}
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		if(roleid==9){	
			int count=adviceDao.findAllAdviceCount(qtype, query);
			rows=adviceDao.findAllAdvice(qtype,query,sortname, sortorder,(pages-1)*rp, rp);
			this.total=count;
			this.page=pages; 
			return SUCCESS;
		}
		return null;
	}
	
	public String findAdviceById(){
		try {			
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			String adviceId=request.getParameter("id");
			Advice advice=(Advice) this.combiz.get(Advice.class, Integer.parseInt(adviceId));
			out.print(advice.getContent());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
