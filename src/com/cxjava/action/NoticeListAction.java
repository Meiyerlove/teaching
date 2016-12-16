package com.cxjava.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.User;

public class NoticeListAction extends BaseAction{
	public List rows;
	public int total;
	public int page;
	
  public String noticeall(){
	    NoticeDao noticealldao=new NoticeDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
	    String username=request.getParameter("username");
	    String roleid=request.getParameter("roleid");
		 if(username!=null){
			 try {
				 username=new String(username.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		System.out.println("username----"+username);
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值 数据库字段内容
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		if(!query.equals("")){
			//query=query.replaceAll("\\s*", "");
			query=query.trim();
			int count=noticealldao.findjiaoteacherassistantcount(username,query,qtype);
			rows=noticealldao.findjiaoteacherassistantnotice(query,qtype,sortname, sortorder, (pages-1)*rp, rp);
			this.total=count;
			this.page=pages; 
			return SUCCESS;
		}else{
		   	try {
		  	int count=noticealldao.findJiaoTeacherAssistantCount();
			rows=noticealldao.findJiaoTeacherAssistantNotice(sortname, sortorder,(pages-1)*rp,rp);
			this.total=count;
			this.page=pages; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		   	return SUCCESS;
		}	   
	}  
  public String jiaowu_notice(){
	    NoticeDao noticedao=new NoticeDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
	    String username=request.getParameter("username");
		 String roleid=request.getParameter("roleid");
		 if(username!=null){
			 try {
				 username=new String(username.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		System.out.println("username----"+username);
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值 数据库字段内容
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		if(!query.equals("")){
			//query=query.replaceAll("\\s*", "");
			query=query.trim();
			int count=noticedao.findjiaowunoticecount(username,query,qtype);
			rows=noticedao.findjiaowunotice(query,qtype,sortname, sortorder, (pages-1)*rp, rp);
			this.total=count;
			this.page=pages; 
			return SUCCESS;
		
		}else{
		   	try {
		  	int count=noticedao.findJiaoWuNoticeCount(username);
			rows=noticedao.findJiaoWuNotice(username,sortname, sortorder,(pages-1)*rp,rp);
			this.total=count;
			this.page=pages; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		   	return SUCCESS;
			
		}	   
	}
	
  public String assistantnotice(){
	  System.out.println("11");
	  NoticeDao assistantdao=new NoticeDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");
	    String username=request.getParameter("username");
	    String roleid=request.getParameter("roleid");
	    HttpSession session=request.getSession();
		User curruser=(User) session.getAttribute("tuser");
		User user=(User) this.combiz.get(User.class, curruser.getId());
		 if(username!=null){
			 try {
				 username=new String(username.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值 数据库字段内容
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		if(!query.equals("")){
			//query=query.replaceAll("\\s*", "");
			query=query.trim();
			int count=assistantdao.findassistantnoticeCount(username,query,qtype);
			rows=assistantdao.findAssistantnotice(username,query,qtype,sortname, sortorder, (pages-1)*rp, rp);
			this.total=count;
			this.page=pages; 
			return SUCCESS;
		}else{
		   	try {
		  	int count=assistantdao.findAssistantCount(username);
			rows=assistantdao.findAssistantNotice(username,sortname, sortorder,(pages-1)*rp,rp);
			this.total=count;
			this.page=pages; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		   	return SUCCESS;
			
		}	  
  }
  
  public String teachernotice(){
	  NoticeDao assistantdao=new NoticeDao();
	  HttpServletRequest request=ServletActionContext.getRequest();
	  int pages=Integer.valueOf(request.getParameter("page"));
	  int rp=Integer.valueOf(request.getParameter("rp"));
	  String sortname=request.getParameter("sortname");
	  String username=request.getParameter("username");
	  String roleid=request.getParameter("roleid");
	  if(username!=null){
		  try {
			  username=new String(username.getBytes("iso-8859-1"),"utf-8");
		  } catch (UnsupportedEncodingException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
	  }
	  String sortorder=request.getParameter("sortorder");
	  String query = request.getParameter("query");//查询条件的值 数据库字段内容
	  String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
	  if(!query.equals("")){
		  //query=query.replaceAll("\\s*", "");
		  query=query.trim();
		  int count=assistantdao.findTeachernoticeCount(username,query,qtype);
		  rows=assistantdao.findTeachernotice(username,query,qtype,sortname, sortorder, (pages-1)*rp, rp);
		  this.total=count;
		  this.page=pages; 
		  return SUCCESS;	  
	  }else{
		  try {
			  int count=assistantdao.findTeacherNoticeCount(username);
			  rows=assistantdao.findTeacherNotice(username,sortname, sortorder,(pages-1)*rp,rp);
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