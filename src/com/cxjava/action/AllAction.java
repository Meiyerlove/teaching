package com.cxjava.action;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Adjust;
import org.yeeku.model.Goods;

import com.opensymphony.xwork2.ActionSupport;
public class AllAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(AllAction.class);

	public List rows;
	public int total;
	public int page;
	public String T_All(){
		AdjustDao adjustDao=new AdjustDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
	    String teachername=request.getParameter("teachername");
	    if(teachername.equals("undefined")){
	    	teachername=null;
	    }
		 String roleid=request.getParameter("roleid");
		 if(teachername!=null){
			 try {
				 teachername=new String(teachername.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		System.out.println("teachername----"+teachername);
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		if(!query.equals("")){
			int count=adjustDao.findAdjustCount1(teachername,qtype, query);
			rows=adjustDao.findByIpDate1(teachername,qtype,query,sortname, sortorder, (pages-1)*rp, rp);
			this.total=count;
			this.page=pages; 
			return SUCCESS;
		}else{
			try {
				int count=adjustDao.findNoagreetCount(teachername,roleid);
				rows=adjustDao.findNoagreet(teachername,roleid,sortname, sortorder,(pages-1)*rp,rp);
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
