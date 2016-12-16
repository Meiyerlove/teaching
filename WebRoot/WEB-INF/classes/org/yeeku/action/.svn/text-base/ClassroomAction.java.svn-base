package org.yeeku.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.mapping.Map;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Classroom;
import org.yeeku.model.ClassroomApply;
import org.yeeku.model.User;

import com.opensymphony.xwork2.ActionContext;

public class ClassroomAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roomname;
	private String campus;
	private Date applydate;
	private String sapplydate;
	private String dt;
	private String user;
	private int clrid;


	
	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		byte[] temp;
		try {
			temp=campus.getBytes("iso-8859-1");
			this.campus = new String(temp,"utf-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
	}

	public Date getApplydate() {
		return applydate;
	}

	

	public void setApplydate(Date applydate) {
		
		this.applydate = applydate;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String toClassroomList(){
		HttpServletRequest request=ServletActionContext.getRequest();
    	try{
    		
    		String applydateStr = request.getParameter("applydate");
    		
    		if(applydateStr==null || applydateStr==""){
				applydate=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				sapplydate=sdf.format(applydate);
			}else{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    		applydate = sdf.parse(applydateStr);
	    		sapplydate=sdf.format(applydate);
	    		applydate=sdf.parse(sapplydate);
	    		
			}
    		
		
    		List kebiaoList = mgr.getKechengListByDate(applydate);
    		List classroomList = mgr.getClassroomList();
    		List applyclassroomList =mgr.getApplyClassroomListByDate(sapplydate);
    		List adjustlistbefore=mgr.getAdjustListByDatebefore(sapplydate);
    		List adjustlistafter=mgr.getAdjustListByDateafter(sapplydate);
  
    		request.setAttribute("classroomList", classroomList);
    		request.setAttribute("kebiaoList", kebiaoList);
    		request.setAttribute("applyclassroomList", applyclassroomList);
    		request.setAttribute("adjustlistbefore", adjustlistbefore);
    		request.setAttribute("adjustlistafter", adjustlistafter);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "toClassroomList";
    }
	
	public String toClassroomApplyList(){
		HttpServletRequest request =ServletActionContext.getRequest();
		try {
			List applyclassroomList=mgr.getApplyClassroomList();
			request.setAttribute("applyclassroomList", applyclassroomList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "toClassroomApplyList";
	}
	public String toClassroomApplyListForUser(){
		//Map mapsession =(Map) ActionContext.getContext().getSession();
		HttpServletRequest request =ServletActionContext.getRequest();
		User user=(User) request.getSession().getAttribute("tuser");
		
		try {
			List applyclassroomList=mgr.getApplyClassroomListByUser(user.getUser());
			request.setAttribute("applyclassroomList", applyclassroomList);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "toClassroomApplyListForUser";
	}

	public String doClassroomAdd(){
    	try{
    		HttpServletRequest request = ServletActionContext.getRequest();
    		String roomname=request.getParameter("roomname");
    		String campus=request.getParameter("campus");
    		Classroom clr=new Classroom();
    		clr.setRoomid("20150009");
    		clr.setRoomname(roomname);
    		clr.setCampus(campus);
    		this.combiz.save(clr);
    
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return "doClassroomAdd";
    }
	public String toClassroomApply(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sapplydate=sdf.format(applydate);
		return "toClassroomApply";
	}
	public String  doClassroomApplyAdd(){
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			
			int  clrid=Integer.parseInt(request.getParameter("clrid"));
			String user=request.getParameter("user");
			Date createtime=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
			Date applydate=sdf.parse(request.getParameter("applydate"));
			sapplydate=sdf.format(applydate);
			String applystarttime=request.getParameter("applystarttime");
			String applyendtime=request.getParameter("applyendtime");
			String applyreason=request.getParameter("applyreason");
			String campus=request.getParameter("campus");
			roomname=request.getParameter("roomname");
			//int approverid=Integer.parseInt(request.getParameter("approverid"));
			int  userid=Integer.parseInt(request.getParameter("userid"));
			int approvestatus=1;
			
			byte[] temp;
			try {
			
				
				temp=campus.getBytes("iso-8859-1");
				campus=new String(temp,"utf-8");
				temp=applyreason.getBytes("iso-8859-1");
				applyreason=new String(temp,"utf-8");

			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
			ClassroomApply clra=new ClassroomApply();
			clra.setClrid(clrid);
			clra.setRoomname(roomname);
			clra.setCreatetime(createtime);
			clra.setSapplydate(sapplydate);
			clra.setApplyendtime(applyendtime);
			
			clra.setApplystarttime(applystarttime);
			//clra.setApproverid(approverid);
			clra.setApprovestatus(approvestatus);
			clra.setUser(user);
			clra.setUserid(userid);
			clra.setCampus(campus);
			clra.setApplyreason(applyreason);
			this.combiz.save(clra);
			
			System.out.println("success");

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "doClassroomApplyAdd";
	}

	public String doClassroomApplyPass(){
		HttpServletRequest request=ServletActionContext.getRequest();
		ClassroomApply clra=(ClassroomApply)combiz.get(ClassroomApply.class,Integer.parseInt(request.getParameter("id")) );
		clra.setApprovestatus(2);
		clra.setApproverid(Integer.parseInt(request.getParameter("approverid")));
		clra.setApprover(request.getParameter("approver"));
		this.combiz.update(clra);
		return "Pass";
	
	}
	/**
	 * @param dt the dt to set
	 */
	public String  doClassroomApplyRefuse(){
		HttpServletRequest request=ServletActionContext.getRequest();
		ClassroomApply clra=(ClassroomApply)combiz.get(ClassroomApply.class,Integer.parseInt(request.getParameter("id")) );
		clra.setApprovestatus(3);
		clra.setApproverid(Integer.parseInt(request.getParameter("approverid")));
		clra.setApprover(request.getParameter("approver"));
		this.combiz.update(clra);
		return "Refuse";
	}
	public void setDt(String dt) {
		this.dt = dt;
	}

	/**
	 * @return the dt
	 */
	public String getDt() {
		return dt;
	}

	/**
	 * @param sapplydate the sapplydate to set
	 */
	public void setSapplydate(String sapplydate) {
		this.sapplydate = sapplydate;
	}

	/**
	 * @return the sapplydate
	 */
	public String getSapplydate() {
		return sapplydate;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param clrid the clrid to set
	 */
	public void setClrid(int clrid) {
		this.clrid = clrid;
	}

	/**
	 * @return the clrid
	 */
	public int getClrid() {
		return clrid;
	}


}
