package org.yeeku.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Role;
import org.yeeku.model.User;

public class UserAction extends BaseAction{
	
	private List userList =new ArrayList();
	private List roleList;

	public List getUserList() {
		return userList;
	}
	public void setUserList(List userList) {
		this.userList = userList;
	}
	public List getRoleList() {
		return roleList;
	}
	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}
	
	
	public String toUserList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpSession session=request.getSession();
    		User user = (User) request.getSession().getAttribute("tuser");
    		if(user.getUserType()==1){    			
    			userList = mgr.getAllUser();
    			request.setAttribute("userList", userList);
    			return "userList";
    		}else{
    			System.out.println(user.getUser());
    			User currUser=mgr.getUserByName(user.getUser());
    			userList.add(currUser);
    			request.setAttribute("userList", userList);
    			return "user";
    		}
    	}catch(Exception e){
    		e.printStackTrace();  
    	}
    	return null;
    }
	
	public String checkPassword(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpServletResponse response = ServletActionContext.getResponse();
    		response.setContentType("text/html;charset=utf-8");
    		PrintWriter out = response.getWriter();
    		String userid=request.getParameter("userid");
    		String password=request.getParameter("password");
    		User user=(User) this.combiz.get(User.class,Integer.parseInt(userid));
    		if(password.equals(user.getPass())){
    			out.print("true");
    		}else{
    			out.print("false");
    		}
    		out.flush();
    		out.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toUserEdit";
    }
	
	public String toUserAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		roleList = mgr.getRoleList();
    		request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toUserAdd";
    }
	
	public String doUserAdd(){
		String returnvalue = "doUserAdd";
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		User curruser = (User) request.getSession().getAttribute("tuser");
    		String username = request.getParameter("username");
    		String password = request.getParameter("password");
    		String passwordNew = request.getParameter("passwordNew");
    		String usertype = request.getParameter("usertype");
    		
    		roleList = mgr.getRoleList();
    		request.setAttribute("roleList", roleList);
    		
    		User user = null;
    		
    		String userid = request.getParameter("userid");
    		if(null != userid && !userid.equals("")){
    			user = (User) this.combiz.get(User.class, Integer.valueOf(userid)); 				
    				returnvalue = "doUserEdit";
    		}else{
    			user = new User();
    			user.set_status(1);
    		}
    		
    		
    		try {
    			username = new String(username.getBytes("iso-8859-1"),"utf-8");
    			password = new String(password.getBytes("iso-8859-1"),"utf-8");
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		user.setUser(username);
    		if(curruser.getUserType()==1){
    			user.setPass(password);
    		}else{
    			user.setPass(passwordNew);
    		} 			
    			user.setUserType(Integer.valueOf(usertype));   		
    			this.combiz.saveOrupate(user);  
    			request.setAttribute("userType", curruser.getUserType());
    			addActionMessage("用户保存成功");
    		//roleList = mgr.getRoleList();
    		//request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return returnvalue;
    }
	
	public String toUserEdit(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String userid = request.getParameter("userid");
    		User useredit = (User) this.combiz.get(User.class, Integer.valueOf(userid));
    		User user = (User) request.getSession().getAttribute("tuser");
    		//roleList = mgr.getRoleList();
    		Role role = (Role) this.combiz.get(Role.class, useredit.getUserType());
    		roleList = mgr.getRoleList();
    		request.setAttribute("userType", user.getUserType());
    		request.setAttribute("useredit", useredit);
    		request.setAttribute("role", role);
    		request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toUserEdit";
    }
	
	public String deleteUser(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String userid = request.getParameter("userid");
    		User useredit = (User) this.combiz.get(User.class, Integer.valueOf(userid));
    		this.combiz.delete(useredit);
    		//roleList = mgr.getRoleList();
    		//Role role = (Role) this.combiz.get(Role.class, useredit.getUserType());
    		//roleList = mgr.getRoleList();
    		//request.setAttribute("useredit", useredit);
    		//request.setAttribute("role", role);
    		//request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "deleteUser";
    }

}
