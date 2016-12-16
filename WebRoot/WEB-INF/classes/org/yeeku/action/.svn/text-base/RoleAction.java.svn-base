package org.yeeku.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Right;
import org.yeeku.model.Role;
import org.yeeku.model.RoleRight;
import org.yeeku.model.User;

public class RoleAction extends BaseAction{
	
	private List roleList;
	private List rightList;
	private String roleid;
	
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public List getRoleList() {
		return roleList;
	}
	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}
	
	public List getRightList() {
		return rightList;
	}
	public void setRightList(List rightList) {
		this.rightList = rightList;
	}
	
	public String toRoleList(){
	    	try{
	    		HttpServletRequest request = ServletActionContext.getRequest();
	    		roleList = mgr.getRoleList();
	    		request.setAttribute("roleList", roleList);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return "roleList";
	    }
	
	public String toRoleRightList(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		roleList = mgr.getRoleList();
    		request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "roleRightList";
    }
	
	public String toRoleAssignRight(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpSession session = request.getSession();
    		
    		//User tuser = (User) session.getAttribute("tuser");
    		String roleid = request.getParameter("roleid");
    		Role role = (Role) this.combiz.get(Role.class, Integer.valueOf(roleid));
    		
    		rightList = mgr.getRightList();
    		List rightandrolelist = mgr.getRoleRight(Integer.valueOf(roleid));
    		
    		Vector vector = new Vector();
    		for(int i = 0; i < rightandrolelist.size(); i++){
    			Object object[] = (Object[]) rightandrolelist.get(i);
            	Right right = (Right) object[0];
    			vector.add(right.getRightcode());
    		}
    		
    	    List<Right> rightListNew = new ArrayList<Right>();
    	    for(int i = 0 ; i < rightList.size(); i++){
    	    	Right right = new Right();
    	    	right = (Right) rightList.get(i);
    	    	if(vector.contains(right.getRightcode())){
    	    		right.setIschecked(1);
    	    	}
    	    	rightListNew.add(right);
    	    }
            
    		request.setAttribute("rightList", rightListNew);
    		request.setAttribute("role", role);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "roleAssignRight";
    }
	
	public String doRoleRightAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		HttpSession session = request.getSession();
    		
    		String checkbox[]  = request.getParameterValues("mycheckbox");
    		String roleidget = request.getParameter("roleid");
    		
            List rightandrolelist = mgr.getRoleRight(Integer.valueOf(roleid));
    		
    		Vector vector = new Vector();
    		if(null != checkbox){
    			for(int i = 0; i < checkbox.length; i++){
        			vector.add(checkbox[i]);
        		}
    		}
    		
    		
    		for(int i = 0; i < rightandrolelist.size(); i++){
    			Object object[] = (Object[]) rightandrolelist.get(i);
            	Right right = (Right) object[0];
            	if(vector.contains(right.getRightcode())){
    	    		
    	    	}else{
    	    		List deleteList = mgr.getRoleRight(Integer.valueOf(roleidget), right.getRightcode());
    	    		for(int j = 0; j < deleteList.size(); j++){
    	    			Object object1[] = (Object[]) rightandrolelist.get(i);
    	            	RoleRight rr = (RoleRight) object1[1];
    	            	this.combiz.delete(rr);
    	    		}
    	    	}
    		}
    		if(null != checkbox){
    			for(int i = 0; i < checkbox.length; i++){
        			List list = mgr.getRoleRight(Integer.valueOf(roleidget), checkbox[i]);
        			if(null != list && list.size() > 0){
        				
        			}else{
        				Right right = (Right) this.combiz.get(Right.class, checkbox[i]);
        				
        				RoleRight roleright = new RoleRight();
        				roleright.setRoleid(Integer.valueOf(roleidget));
        				roleright.setRightcode(checkbox[i]);
        				
        				this.combiz.save(roleright);
        			}
        		}
    		}
    		
    		roleid = roleidget;
    		//String url = "ToRoleAssignRight.action?roleid="+roleid;
    		request.setAttribute("roleid", roleid);
    		
    		/*Role role = (Role) this.combiz.get(Role.class, Integer.valueOf(roleid));
    		rightList = mgr.getRightList();
    		List rightandrolelist = mgr.getRoleRight(Integer.valueOf(roleid));
    		
    		Vector vector = new Vector();
    		for(int i = 0; i < rightandrolelist.size(); i++){
    			Object object[] = (Object[]) rightandrolelist.get(i);
            	Right right = (Right) object[0];
    			vector.add(right.getRightcode());
    		}
    		
    	    List<Right> rightListNew = new ArrayList<Right>();
    	    for(int i = 0 ; i < rightList.size(); i++){
    	    	Right right = new Right();
    	    	right = (Right) rightList.get(i);
    	    	if(vector.contains(right.getRightcode())){
    	    		right.setIschecked(1);
    	    	}
    	    	rightListNew.add(right);
    	    }
            
    		request.setAttribute("rightList", rightListNew);
    		request.setAttribute("role", role);*/
    		//rightList = mgr.getRightList();
    		//List rightandrolelist = mgr.getRoleRight(tuser.getUserType());
    		
    		
            
    		//request.setAttribute("rightList", rightListNew);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "savedirect";
    }
	
	public String toRoleAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		//roleList = mgr.getRoleList();
    		//request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toRoleAdd";
    }
	
	public String doRoleAdd(){
		String returnvalue = "doRoleAdd";
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String rolename = request.getParameter("rolename");
    		String roledesc = request.getParameter("roledesc");
    		
    		
    		
    		Role role = null;
    		
    		String roleid = request.getParameter("roleid");
    		if(null != roleid && !roleid.equals("")){
    			role = (Role) this.combiz.get(Role.class, Integer.valueOf(roleid));
    			returnvalue = "doRoleEdit";
    		}else{
    			role = new Role();
    		}
    		
    		
    		try {
    			rolename = new String(rolename.getBytes("iso-8859-1"),"utf-8");
    			roledesc = new String(roledesc.getBytes("iso-8859-1"),"utf-8");
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		role.setName(rolename);
    		role.setDesc(roledesc);
    		this.combiz.saveOrupate(role);   	
    		addActionMessage("角色保存成功");
    		//roleList = mgr.getRoleList();
    		//request.setAttribute("roleList", roleList);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return returnvalue;
    }
	
	public String toRoleEdit(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String roleid = request.getParameter("roleid");
    		Role role = (Role) this.combiz.get(Role.class, Integer.valueOf(roleid));
    		//roleList = mgr.getRoleList();
    		request.setAttribute("role", role);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toRoleEdit";
    }
}
