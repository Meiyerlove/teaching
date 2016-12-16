package com.cxjava.action;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Adjust;
import org.yeeku.model.Goods;
import org.yeeku.model.Student;
import org.yeeku.model.StudentAssistantVo;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;

import com.opensymphony.xwork2.ActionSupport;
public class StudentInfoManagerAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(StudentInfoManagerAction.class);

	public List<StudentAssistantVo> rows;
	public int total;
	public int page;
	public String findStudentInfo(){
		StudentInfoManagerDao studentInfoManagerDao=new StudentInfoManagerDao();
		HttpServletRequest request=ServletActionContext.getRequest();
		int pages=Integer.valueOf(request.getParameter("page"));
		int rp=Integer.valueOf(request.getParameter("rp"));
		String sortname=request.getParameter("sortname");

		String roleid=request.getParameter("roleid");
		HttpSession session=request.getSession();
		User curruser=(User) session.getAttribute("tuser");
		User user=(User) this.combiz.get(User.class, curruser.getId());
		String userName=user.getUser();
		String sortorder=request.getParameter("sortorder");
		String query = request.getParameter("query");//查询条件的值
		String qtype =request.getParameter("qtype");//查询条件的类型:id与库存
		if(!query.equals("")){
			query=query.replaceAll("\\s*", "");
			if(query.equals("男")){
				query="1";
			}
			if(query.equals("女")){
				query="2";
			}
			if(query.equals("在校")|| query.equals("在")){
				query="1";
			}
			if(query.equals("离校") || query.equals("离")){
				query="2";
			}
			int count=studentInfoManagerDao.findStudentInfoByConditionCount(roleid,userName,qtype, query);
			
			rows=studentInfoManagerDao.findStudentInfoByCondition(roleid,userName,qtype,query,sortname, sortorder, (pages-1)*rp, rp);
			
			this.total=count;
			this.page=pages; 
			return SUCCESS;
		}else{
			try {
				int count=studentInfoManagerDao.findStudentInfoByUsertypeCount(roleid,userName);
				rows=studentInfoManagerDao.findStudentInfoByUsertype(roleid,userName,sortname, sortorder,(pages-1)*rp,rp);
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
