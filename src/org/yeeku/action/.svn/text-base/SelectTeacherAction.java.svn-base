package org.yeeku.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.yeeku.model.Classroom;
import org.yeeku.model.Contract;
import org.yeeku.model.Cursch;
import org.yeeku.model.HeInformation;
import org.yeeku.model.HrEmployee;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;
import org.yeeku.service.StudentListManager;
import org.yeeku.service.UserManager;
import org.yeeku.util.ContractComparatorByDateDown;
import org.yeeku.util.ContractComparatorByDateUp;
import org.yeeku.util.ContractComparatorByTotalDown;
import org.yeeku.util.ContractComparatorByTotalUp;
import org.yeeku.util.EmployeeComparator;
import org.yeeku.util.EmployeeComparatorByAgeDown;
import org.yeeku.util.EmployeeComparatorByRemainDown;
import org.yeeku.util.EmployeeComparatorByRemainUp;
import org.yeeku.util.EmployeeComparatorByTotalDown;
import org.yeeku.util.EmployeeComparatorByTotalUp;
import org.yeeku.util.ImageInfo;
import org.yeeku.util.JpegInfoReader;
import org.yeeku.util.TestEncoder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SelectTeacherAction extends ActionSupport {

	protected StudentListManager smgr;

	public void setSmgr(StudentListManager smgr) {
		this.smgr = smgr;
	}
	
	private List <User> userList;
	
	protected UserManager mgr;

    public void setMgr(UserManager mgr)
    {
        this.mgr = mgr;
    }
    
	private List<Teacher> teaList;
	
	private List<Classroom> roomList;
	
	private Teacher tea;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private HrEmployee he;
	
	private HeInformation hi;
	
	private Contract con;
	
	public List<HrEmployee> heList;
	
	public List<Contract> conList;
	
	private Date todayStartDate;
	
	private File image;
	
	private File imageEdit;
	
	private Date todayEndDate;

	private Classroom room;
	
	private Cursch cs;

	private Date contractDate;
	
	private Date expireDate;
	
	public Cursch getCs() {
		return cs;
	}

	public void setCs(Cursch cs) {
		this.cs = cs;
	}

	public Classroom getRoom() {
		return room;
	}

	public void setRoom(Classroom room) {
		this.room = room;
	}
	
	public List<HrEmployee> getHeList() {
		return heList;
	}

	public void setHeList(List<HrEmployee> heList) {
		this.heList = heList;
	}

	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	public Date getTodayStartDate() {
		return todayStartDate;
	}

	public void setTodayStartDate(Date todayStartDate) {
		this.todayStartDate = todayStartDate;
	}

	public Date getTodayEndDate() {
		return todayEndDate;
	}

	public void setTodayEndDate(Date todayEndDate) {
		this.todayEndDate = todayEndDate;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	
	public List<User> getUserList() {
		return userList;
	}



	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String input() throws Exception {
		System.out.println("default method");
		return INPUT;
	}
	
	public String search() throws Exception {
		try {
			teaList = new ArrayList<Teacher>();
			teaList = smgr.getTeaList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "search";
	}
	
	public String findAllRoom() throws Exception {
		try {
			roomList = new ArrayList<Classroom>();
			roomList = smgr.getRoomList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "roomList";
	}
	
	public String findAllEmployee() throws Exception {
		try {
			heList = smgr.getAllStudent();
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = (HrEmployee) heList.get(i);
				byte[] b = he.getImage();
				if(null != b)he.setIsExistImage(1);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					Integer finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
					he.setConsumeLessonAmount(finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
					he.setConsumeLessonAmount(0);
				}
				
				String contextPath = ServletActionContext.getServletContext().getRealPath("/Student/");
				File file = new File(contextPath+"/"+he.getEmplID()+".jpg");
				if(file.exists()){
					he.setIsExistImage(1);
				}else{
					he.setIsExistImage(0);
				}
				lhl.add(he);
			}
			heList = lhl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "employeeList";
	}
	
	public String listUncheckedEmployee() throws Exception {
		try {
			heList = smgr.getUncheckedStudentList();
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = (HrEmployee) heList.get(i);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					Integer finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
					he.setConsumeLessonAmount(finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
					he.setConsumeLessonAmount(0);
				}	
				String contextPath = ServletActionContext.getServletContext().getRealPath("/Student/");
				File file = new File(contextPath+"/"+he.getEmplID()+".jpg");
				if(file.exists()){
					he.setIsExistImage(1);
				}else{
					he.setIsExistImage(0);
				}
				lhl.add(he);
			}
			heList = lhl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUncheckedEmployee";
	}
	
	  public String listUser(){
	    	
	    	try{
	    		userList = mgr.getAllUser();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    	return "listUser";
	    }
	  
	  public String addUser(){
	    	return "addUser";
	    }
	  
	  public String saveUser(){
		  try{
			  if(null != user){
				  //user.setUserType(2);
				  mgr.saveUser(user);
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	    	return "saveUser";
	    }
	  
	  public String editUser(){
		  try{
			  ActionContext context=ActionContext.getContext(); 
			  HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			  String userid = request.getParameter("userid");
			  Integer id = Integer.parseInt(userid);
			  user = mgr.getUserByID(id);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	    	return "editUser";
	    }
	  
	  public String deleteUser(){
		  try{
			  ActionContext context=ActionContext.getContext(); 
			  HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			  String userid = request.getParameter("userid");
			  Integer id = Integer.parseInt(userid);
			  User luser = mgr.getUserByID(id);
			  mgr.deleteUser(luser);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	    	return "deleteUser";
	    }
	  
	  public String updateUser(){
		  try{
			  if(null != user){
				  //user.setUserType(2);
				  mgr.updateUser(user);
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	    	return "updateUser";
	    }
	
	public String searchEmployee() throws Exception {
		try {
			String emplName = he.getEmplName();
			if(null != emplName){
				heList = smgr.searchEmployee(emplName);
			}else{
				heList = smgr.getAllStudent();
			}
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = heList.get(i);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					int finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
				}	
				String contextPath = ServletActionContext.getServletContext().getRealPath("/Student/");
				File file = new File(contextPath+"/"+he.getEmplID()+".jpg");
				if(file.exists()){
					he.setIsExistImage(1);
				}else{
					he.setIsExistImage(0);
				}
				lhl.add(he);
			}
			heList = lhl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "searchEmployee";
	}
	
	public String searchContract() throws Exception {
		try {
			String emplName = he.getEmplName();
			if(null != emplName){
				conList = smgr.getContractByName(emplName);
			}else{
				conList = smgr.getAllContract();
			}
			
				//conList = smgr.getAllContract();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				List lcl = new ArrayList();
				for(int i = 0; i < conList.size(); i++){
					Contract con = new Contract();
					con = conList.get(i);
					HrEmployee he = new HrEmployee();
					he = smgr.getHrEmployeeByEmplID(con.getEmplID());
					con.setEmplName(he.getEmplName());
					con.setContractDateFormat(sdf.format(con.getContractDate()));
					con.setExpireDateFormat(sdf.format(con.getExpireDate()));
					String contextPath = ServletActionContext.getServletContext().getRealPath("/Contract/");
					File file = new File(contextPath+"/"+con.getContractNO()+".jpg");
					if(file.exists()){
						con.setIsExistImage(1);
					}else{
						con.setIsExistImage(0);
					}
					lcl.add(con);
				}
				
				conList = lcl;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "searchContract";
	}
	
	public String sortEmployeeByAgeUp() throws Exception {
		try {
			heList = smgr.getAllStudent();
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = heList.get(i);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					int finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
				}			
				lhl.add(he);
			}
			heList = lhl;
			EmployeeComparator comparator=new EmployeeComparator();
			Collections.sort(heList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sortEmployeeByAge";
	}
	
	public String sortEmployeeByAgeDown() throws Exception {
		try {
			heList = smgr.getAllStudent();
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = heList.get(i);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					int finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
				}			
				lhl.add(he);
			}
			heList = lhl;
			EmployeeComparatorByAgeDown comparator=new EmployeeComparatorByAgeDown();
			Collections.sort(heList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sortEmployeeByAge";
	}
	
	public String sortEmployeeByTotalUp() throws Exception {
		try {
			heList = smgr.getAllStudent();
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = heList.get(i);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					int finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
				}			
				lhl.add(he);
			}
			heList = lhl;
			EmployeeComparatorByTotalUp comparator=new EmployeeComparatorByTotalUp();
			Collections.sort(heList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sortEmployeeByAge";
	}
	
	public String sortEmployeeByTotalDown() throws Exception {
		try {
			heList = smgr.getAllStudent();
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = heList.get(i);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					int finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
				}			
				lhl.add(he);
			}
			heList = lhl;
			EmployeeComparatorByTotalDown comparator=new EmployeeComparatorByTotalDown();
			Collections.sort(heList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sortEmployeeByAge";
	}
	
	public String sortEmployeeByRemainUp() throws Exception {
		try {
			heList = smgr.getAllStudent();
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = heList.get(i);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					int finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
				}			
				lhl.add(he);
			}
			heList = lhl;
			EmployeeComparatorByRemainUp comparator=new EmployeeComparatorByRemainUp();
			Collections.sort(heList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sortEmployeeByAge";
	}
	
	public String sortEmployeeByRemainDown() throws Exception {
		try {
			heList = smgr.getAllStudent();
			List lhl = new ArrayList();
			for(int i = 0; i < heList.size(); i++){
				HrEmployee he = new HrEmployee();
				he = heList.get(i);
				Contract con = new Contract();
				con = smgr.getContractByEmplID(he.getEmplID());
				if(null != con){
					he.setTotalLessonAmount(con.getTotalLessonAmount());
					int finishedLessonNumber = smgr.getFinishedLessonNumber(he.getEmplID());
					he.setRemainLessonAmount(con.getTotalLessonAmount()-finishedLessonNumber);
				}else{
					he.setTotalLessonAmount(0);
					he.setRemainLessonAmount(0);
				}			
				lhl.add(he);
			}
			heList = lhl;
			EmployeeComparatorByRemainDown comparator=new EmployeeComparatorByRemainDown();
			Collections.sort(heList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sortEmployeeByAge";
	}
	
	
	
	public String findAllContract() throws Exception {
		try {
			conList = smgr.getAllContract();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List lcl = new ArrayList();
			for(int i = 0; i < conList.size(); i++){
				Contract con = new Contract();
				con = conList.get(i);
				HrEmployee he = new HrEmployee();
				he = smgr.getHrEmployeeByEmplID(con.getEmplID());
				con.setEmplName(he.getEmplName());
				con.setContractDateFormat(sdf.format(con.getContractDate()));
				con.setExpireDateFormat(sdf.format(con.getExpireDate()));
				String contextPath = ServletActionContext.getServletContext().getRealPath("/Contract/");
				File file = new File(contextPath+"/"+con.getContractNO()+".jpg");
				if(file.exists()){
					con.setIsExistImage(1);
				}else{
					con.setIsExistImage(0);
				}
				lcl.add(con);
			}
			conList = lcl;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
	public String listUncheckedContract() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			conList = smgr.getListUncheckedContract();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List lcl = new ArrayList();
			for(int i = 0; i < conList.size(); i++){
				Contract con = new Contract();
				con = conList.get(i);
				HrEmployee he = new HrEmployee();
				he = smgr.getHrEmployeeByEmplID(con.getEmplID());
				if(null == he){
					con.setEmplName("已删除的学生");
					
				}else{
					con.setEmplName(he.getEmplName());
				}
				con.setContractDateFormat(sdf.format(con.getContractDate()));
				con.setExpireDateFormat(sdf.format(con.getExpireDate()));
				String contextPath = ServletActionContext.getServletContext().getRealPath("/Contract/");
				File file = new File(contextPath+"/"+con.getContractNO()+".jpg");
				if(file.exists()){
					con.setIsExistImage(1);
				}else{
					con.setIsExistImage(0);
				}
				lcl.add(con);
			}
			conList = lcl;
			Map session = context.getSession();
			User luser = (User) session.get("luser");
			if(luser.getUserType() == 3){
				request.setAttribute("displayCheck", 1);
			}else{
				request.setAttribute("displayCheck", 0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUncheckedContract";
	}
	
	public String sortContractByTotalUp() throws Exception {
		try {
			conList = smgr.getAllContract();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List lcl = new ArrayList();
			for(int i = 0; i < conList.size(); i++){
				Contract con = new Contract();
				con = conList.get(i);
				HrEmployee he = new HrEmployee();
				he = smgr.getHrEmployeeByEmplID(con.getEmplID());
				if(null != he){
					con.setEmplName(he.getEmplName());
				}else{
					con.setEmplName("已删除的学生");
				}
				
				con.setContractDateFormat(sdf.format(con.getContractDate()));
				con.setExpireDateFormat(sdf.format(con.getExpireDate()));
				lcl.add(con);
			}
			conList = lcl;
			ContractComparatorByTotalUp comparator=new ContractComparatorByTotalUp();
			Collections.sort(conList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
	public String sortContractByTotalDown() throws Exception {
		try {
			conList = smgr.getAllContract();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List lcl = new ArrayList();
			for(int i = 0; i < conList.size(); i++){
				Contract con = new Contract();
				con = conList.get(i);
				HrEmployee he = new HrEmployee();
				he = smgr.getHrEmployeeByEmplID(con.getEmplID());
				con.setEmplName(he.getEmplName());
				con.setContractDateFormat(sdf.format(con.getContractDate()));
				con.setExpireDateFormat(sdf.format(con.getExpireDate()));
				lcl.add(con);
			}
			conList = lcl;
			ContractComparatorByTotalDown comparator=new ContractComparatorByTotalDown();
			Collections.sort(conList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
	public String sortContractByDateUp() throws Exception {
		try {
			conList = smgr.getAllContract();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List lcl = new ArrayList();
			for(int i = 0; i < conList.size(); i++){
				Contract con = new Contract();
				con = conList.get(i);
				HrEmployee he = new HrEmployee();
				he = smgr.getHrEmployeeByEmplID(con.getEmplID());
				con.setEmplName(he.getEmplName());
				con.setContractDateFormat(sdf.format(con.getContractDate()));
				con.setExpireDateFormat(sdf.format(con.getExpireDate()));
				lcl.add(con);
			}
			conList = lcl;
			ContractComparatorByDateUp comparator=new ContractComparatorByDateUp();
			Collections.sort(conList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
	public String sortContractByDateDown() throws Exception {
		try {
			conList = smgr.getAllContract();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List lcl = new ArrayList();
			for(int i = 0; i < conList.size(); i++){
				Contract con = new Contract();
				con = conList.get(i);
				HrEmployee he = new HrEmployee();
				he = smgr.getHrEmployeeByEmplID(con.getEmplID());
				con.setEmplName(he.getEmplName());
				con.setContractDateFormat(sdf.format(con.getContractDate()));
				con.setExpireDateFormat(sdf.format(con.getExpireDate()));
				lcl.add(con);
			}
			conList = lcl;
			ContractComparatorByDateDown comparator=new ContractComparatorByDateDown();
			Collections.sort(conList, comparator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "contractList";
	}
	
	public List<Classroom> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Classroom> roomList) {
		this.roomList = roomList;
	}
	
	public String editTeacher() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String teaid = request.getParameter("teaid");
			tea = smgr.getTeaNameByTeaID(teaid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "edit";
	}
	
	public String editLesson() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String id = request.getParameter("id");
			cs = new Cursch();
			if(null != id){
				Integer idCS = Integer.parseInt(id);
				cs = smgr.getCursch(idCS);
			}
			
			//request.setAttribute("cs", cs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "editLesson";
	}
	
	public String saveLesson() throws Exception {
		try {
			smgr.saveCursch(cs);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "saveLesson";
	}
	
	public String saveNewLesson() throws Exception {
		try {
			cs.setId(null);
			//cs.setTeaid(tea.getTeaid());
			smgr.saveCursch(cs);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "saveNewLesson";
	}
	
	public String setTeacherCurSch() throws Exception{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String teacherID = request.getParameter("teaid");
		tea = smgr.getTeaNameByTeaID(teacherID);
		List csl = smgr.getCurschListByTeaID(teacherID);
		request.setAttribute("csl", csl);
//		Cursch csMonday1 = new Cursch();
//		csMonday1 = smgr.getCursch(teacherID, "ÐÇÆÚÒ»", 1);
//		String subjectM1 = "";
//		if(null != csMonday1)subjectM1 = csMonday1.getSubject();
//		request.setAttribute("subjectM1", subjectM1);
//		
//		Cursch csMonday2 = new Cursch();
//		csMonday2 = smgr.getCursch(teacherID, "ÐÇÆÚÒ»", 2);
//		String subject12 = "";
//		if(null != csMonday1)subject12 = csMonday2.getSubject();
//		request.setAttribute("subject12", subject12);
//		
//		Cursch csTuesday1 = new Cursch();
//		csTuesday1 = smgr.getCursch(teacherID, "ÐÇÆÚ¶þ", 1);
//		String subject21 = "";
//		if(null != csTuesday1)subject21 = csTuesday1.getSubject();
//		request.setAttribute("subject21", subject21);
//		
//		Cursch csTuesday2 = new Cursch();
//		csTuesday2 = smgr.getCursch(teacherID, "ÐÇÆÚ¶þ", 2);
//		String subject22 = "";
//		if(null != csTuesday2)subject22 = csTuesday2.getSubject();
//		request.setAttribute("subject22", subject22);
//		
//		Cursch csWednesday1 = new Cursch();
//		csWednesday1 = smgr.getCursch(teacherID, "ÐÇÆÚÈý", 1);
//		String subject31 = "";
//		if(null != csWednesday1)subject31 = csWednesday1.getSubject();
//		request.setAttribute("subject31", subject31);
//		
//		Cursch csWednesday2 = new Cursch();
//		csWednesday2 = smgr.getCursch(teacherID, "ÐÇÆÚÈý", 2);
//		String subject32 = "";
//		if(null != csWednesday2)subject32 = csWednesday2.getSubject();
//		request.setAttribute("subject32", subject32);
//		
//		Cursch csThursday1 = new Cursch();
//		csThursday1 = smgr.getCursch(teacherID, "ÐÇÆÚËÄ", 1);
//		String subject41 = "";
//		if(null != csThursday1)subject41 = csThursday1.getSubject();
//		request.setAttribute("subject41", subject41);
//		
//		Cursch csThursday2 = new Cursch();
//		csThursday2 = smgr.getCursch(teacherID, "ÐÇÆÚËÄ", 2);
//		String subject42 = "";
//		if(null != csThursday2)subject42 = csThursday2.getSubject();
//		request.setAttribute("subject42", subject42);
//		
//		Cursch csFriday1 = new Cursch();
//		csFriday1 = smgr.getCursch(teacherID, "ÐÇÆÚÎå", 1);
//		String subject51 = "";
//		if(null != csFriday1)subject51 = csFriday1.getSubject();
//		request.setAttribute("subject51", subject51);
//		
//		Cursch csFriday2 = new Cursch();
//		csFriday2 = smgr.getCursch(teacherID, "ÐÇÆÚÎå", 2);
//		String subject52 = "";
//		if(null != csFriday2)subject52 = csFriday2.getSubject();
//		request.setAttribute("subject52", subject52);
//		
//		Cursch csSaturday1 = new Cursch();
//		csSaturday1 = smgr.getCursch(teacherID, "ÐÇÆÚÁù", 1);
//		String subject61 = "";
//		if(null != csFriday2)subject52 = csFriday2.getSubject();
//		request.setAttribute("subject52", subject52);
//		
//		Cursch csSaturday2 = new Cursch();
//		csSaturday2 = smgr.getCursch(teacherID, "ÐÇÆÚÁù", 2);
//		
//		Cursch csSunday1 = new Cursch();
//		csSunday1 = smgr.getCursch(teacherID, "ÐÇÆÚÈÕ", 1);
//		
//		Cursch csSunday2 = new Cursch();
//		csSunday2 = smgr.getCursch(teacherID, "ÐÇÆÚÈÕ", 2);
		
		return "setTeacherCurSch";
	}
	
	public String editRoom() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			int id = Integer.parseInt(request.getParameter("id"));
			room = smgr.getRoomByID(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "editRoom";
	}
	
	public String deleteTeacher() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String teaid = request.getParameter("teaid");
			Teacher tc = smgr.getTeaNameByTeaID(teaid);
			smgr.deleteTeacher(tc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleteTeacher";
	}
	
	public String deleteLesson() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String teacherID = request.getParameter("teaid");
			request.setAttribute("teaid",teacherID);
			String id = request.getParameter("id");
			Integer idInt = Integer.parseInt(id);
			Cursch lcs = smgr.getCursch(idInt);
			//smgr.deleteCursch(lcs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleteLesson";
	}
	
	public String addTeacher() throws Exception {
		return "addTeacher";
	}
	
	public String detailEmployee() throws Exception {
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String emplID = request.getParameter("emplID");
		//HrEmployee he = new HrEmployee();
		he = smgr.getHrEmployeeByEmplID(emplID);
		byte [] b=new byte[1024*1024*4];
		b  = he.getImage();
		String contextPath = ServletActionContext.getServletContext().getRealPath("/image/");
		String path = contextPath+"\\"+emplID+".JPG";
		
		image = new File(path);
		//File newFile = new File(contextPath+"/image");
		if(null != b){
			if(image.exists()){
				image.delete();
				File newFile = new File(contextPath);
				newFile.mkdir();
				FileOutputStream fos = new FileOutputStream(image,true); 
				fos.write(b, 0, b.length);
				fos.close();
			}else{
				File newFile = new File(contextPath);
				newFile.mkdir();
				FileOutputStream out=new FileOutputStream(path);
				out.write(b, 0, b.length);
		        out.close();
			}
		}
		hi = smgr.getHeInformationByEmplID(emplID);
		return "detailEmployee";
	}
	
	public String detailUncheckedEmployee() throws Exception {
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String emplID = request.getParameter("emplID");
		//HrEmployee he = new HrEmployee();
		he = smgr.getHrEmployeeByEmplID(emplID);
		byte [] b=new byte[1024*1024*4];
		b  = he.getImage();
		String contextPath = ServletActionContext.getServletContext().getRealPath("/image/");
		String path = contextPath+"\\"+emplID+".JPG";
		image = new File(path);
		//File newFile = new File(contextPath+"/image");
		if(null != b){
			if(image.exists()){
				image.delete();
				File newFile = new File(contextPath);
				newFile.mkdir();
				FileOutputStream fos = new FileOutputStream(image,true); 
				fos.write(b, 0, b.length);
				fos.close();
			}else{
				File newFile = new File(contextPath);
				newFile.mkdir();
				FileOutputStream out=new FileOutputStream(path);
				out.write(b, 0, b.length);
		        out.close();
			}
		}
		Map session = context.getSession();
		User luser = (User) session.get("luser");
		if(luser.getUserType() == 3){
			request.setAttribute("displayCheck", 1);
		}else{
			request.setAttribute("displayCheck", 0);
		}
		hi = smgr.getHeInformationByEmplID(emplID);
		return "detailUncheckedEmployee";
	}
	
	public String editEmployee() throws Exception {
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String emplID = request.getParameter("emplID");
		//HrEmployee he = new HrEmployee();
		he = smgr.getHrEmployeeByEmplID(emplID);
		byte [] b=new byte[1024*1024*4];
		b  = he.getImage();
		String contextPath = ServletActionContext.getServletContext().getRealPath("/image/");
		String path = contextPath+"\\"+emplID+".JPG";
		
		image = new File(path);
		//File newFile = new File(contextPath+"/image");
		if(null != b){
			if(image.exists()){
				image.delete();
				File newFile = new File(contextPath);
				newFile.mkdir();
				FileOutputStream fos = new FileOutputStream(image,true); 
				fos.write(b, 0, b.length);
				fos.close();
			}else{
				File newFile = new File(contextPath);
				newFile.mkdir();
				FileOutputStream out=new FileOutputStream(path);
				out.write(b, 0, b.length);
		        out.close();
			}
		}
		he = smgr.getHrEmployeeByEmplID(emplID);
		
		hi = smgr.getHeInformationByEmplID(emplID);
		return "editEmployee";
	}
	
	public String addEmployee() throws Exception {
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST); 
		String maxEmplID = smgr.findMaxEmployeeNo();
		if(maxEmplID.equals("-1"))maxEmplID = "0";
		Long maxNo = Long.parseLong(maxEmplID);
		maxNo = maxNo + 1 ;
		maxEmplID = maxNo.toString();
	/*	if(maxEmplID.length() == 1)maxEmplID = "0000000" + maxEmplID;
		if(maxEmplID.length() == 2)maxEmplID = "000000" + maxEmplID;
		if(maxEmplID.length() == 3)maxEmplID = "00000" + maxEmplID;
		if(maxEmplID.length() == 4)maxEmplID = "0000" + maxEmplID;
		if(maxEmplID.length() == 5)maxEmplID = "000" + maxEmplID;
		if(maxEmplID.length() == 6)maxEmplID = "00" + maxEmplID;
		if(maxEmplID.length() == 6)maxEmplID = "0" + maxEmplID;*/
		char maxEmplIDChar []  = new char[8];
		for(int i = 0; i < maxEmplIDChar.length ; i ++){
			maxEmplIDChar[i] = '0';
		}
		for(int j = maxEmplID.length() - 1 ; j >= 0; j --){
			int index = j+ maxEmplIDChar.length - maxEmplID.length();
			maxEmplIDChar[index] =  maxEmplID.charAt(j);
		}
		maxEmplID = String.valueOf(maxEmplIDChar);
		
		//request.setAttribute("maxEmplID", maxEmplID);
		he = new HrEmployee();
		he.setEmplID(maxEmplID);
		Map session = context.getSession();
		User luser = (User) session.get("luser");
		if(luser.getUserType() == 3){
			return "addUncheckedEmployee";
		}else{
			return "addEmployee";
		}
		
	}
	
	public String addContract() throws Exception {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String maxContractNo = smgr.findMaxContractNo();
		List nameList = smgr.findAllEmplName();
		String nameStr = "";
		for(int i = 0 ; i < nameList.size(); i++){
			
			String name = (String)nameList.get(i);
			nameStr = nameStr+name+",";
		}
		if(maxContractNo.equals("-1"))maxContractNo = "0";
		//Integer maxNo = Integer.parseInt(maxContractNo);
		//maxNo = maxNo + 1 ;
		//maxContractNo = maxNo.toString();
		if(maxContractNo.length() == 1)maxContractNo = "000"+maxContractNo;
		if(maxContractNo.length() == 2)maxContractNo = "00"+maxContractNo;
		if(maxContractNo.length() == 3)maxContractNo = "0"+maxContractNo;
		//con = new Contract();
		//con.setContractNO(maxContractNo);
		//con.setTotalLessonAmount(null);
		
		Long maxNo = Long.parseLong(maxContractNo);
		maxNo = maxNo + 1 ;
		maxContractNo = maxNo.toString();
	/*	if(maxEmplID.length() == 1)maxEmplID = "0000000" + maxEmplID;
		if(maxEmplID.length() == 2)maxEmplID = "000000" + maxEmplID;
		if(maxEmplID.length() == 3)maxEmplID = "00000" + maxEmplID;
		if(maxEmplID.length() == 4)maxEmplID = "0000" + maxEmplID;
		if(maxEmplID.length() == 5)maxEmplID = "000" + maxEmplID;
		if(maxEmplID.length() == 6)maxEmplID = "00" + maxEmplID;
		if(maxEmplID.length() == 6)maxEmplID = "0" + maxEmplID;*/
		char maxContractNOChar []  = new char[16];
		for(int i = 0; i < maxContractNOChar.length ; i ++){
			maxContractNOChar[i] = '0';
		}
		for(int j = maxContractNo.length() - 1 ; j >= 0; j --){
			int index = j+ maxContractNOChar.length - maxContractNo.length();
			maxContractNOChar[index] =  maxContractNo.charAt(j);
		}
		maxContractNo = String.valueOf(maxContractNOChar);
		
		
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		//request.setAttribute("maxContractNo", maxContractNo);
		con = new Contract();
		con.setContractNO(maxContractNo);
		request.setAttribute("nameStr", nameStr);
		if(null == contractDate)contractDate = new Date(System.currentTimeMillis());
		if(null == expireDate)expireDate = new Date(System.currentTimeMillis());
		return "addContract";
	}
	
	public String addUncheckedContract() throws Exception {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String maxContractNo = smgr.findMaxContractNo();
		List nameList = smgr.findAllEmplName();
		String nameStr = "";
		for(int i = 0 ; i < nameList.size(); i++){
			
			String name = (String)nameList.get(i);
			nameStr = nameStr+name+",";
		}
		if(maxContractNo.equals("-1"))maxContractNo = "0";
		//Integer maxNo = Integer.parseInt(maxContractNo);
		//maxNo = maxNo + 1 ;
		//maxContractNo = maxNo.toString();
		if(maxContractNo.length() == 1)maxContractNo = "000"+maxContractNo;
		if(maxContractNo.length() == 2)maxContractNo = "00"+maxContractNo;
		if(maxContractNo.length() == 3)maxContractNo = "0"+maxContractNo;
		//con = new Contract();
		//con.setContractNO(maxContractNo);
		//con.setTotalLessonAmount(null);
		
		Long maxNo = Long.parseLong(maxContractNo);
		maxNo = maxNo + 1 ;
		maxContractNo = maxNo.toString();
	/*	if(maxEmplID.length() == 1)maxEmplID = "0000000" + maxEmplID;
		if(maxEmplID.length() == 2)maxEmplID = "000000" + maxEmplID;
		if(maxEmplID.length() == 3)maxEmplID = "00000" + maxEmplID;
		if(maxEmplID.length() == 4)maxEmplID = "0000" + maxEmplID;
		if(maxEmplID.length() == 5)maxEmplID = "000" + maxEmplID;
		if(maxEmplID.length() == 6)maxEmplID = "00" + maxEmplID;
		if(maxEmplID.length() == 6)maxEmplID = "0" + maxEmplID;*/
		char maxContractNOChar []  = new char[16];
		for(int i = 0; i < maxContractNOChar.length ; i ++){
			maxContractNOChar[i] = '0';
		}
		for(int j = maxContractNo.length() - 1 ; j >= 0; j --){
			int index = j+ maxContractNOChar.length - maxContractNo.length();
			maxContractNOChar[index] =  maxContractNo.charAt(j);
		}
		maxContractNo = String.valueOf(maxContractNOChar);
		
		
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		//request.setAttribute("maxContractNo", maxContractNo);
		con = new Contract();
		con.setContractNO(maxContractNo);
		request.setAttribute("nameStr", nameStr);
		if(null == contractDate)contractDate = new Date(System.currentTimeMillis());
		if(null == expireDate)expireDate = new Date(System.currentTimeMillis());
		return "addUncheckedContract";
	}
	
	public String deleteEmployee() throws Exception {
		try{
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String emplID = request.getParameter("emplID");
			HrEmployee he = new HrEmployee();
			he = smgr.getHrEmployeeByEmplID(emplID);
			smgr.deleteEmployee(he);
			return "deleteEmployee";
		}catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
	}
	
	public String deleteContract() throws Exception {
		try{
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String contractNO = request.getParameter("contractNO");
			Contract con = new Contract();
			List conList = smgr.getContractByNO(contractNO);
			if(null != conList && conList.size() > 0){
				con = (Contract) conList.get(0);
				smgr.deleteContract(con);
			}
			return "deleteContract";
		}catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
	}
	
	public String checkContract() throws Exception {
		try{
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String contractNO = request.getParameter("contractNO");
			Contract con = new Contract();
			List conList = smgr.getContractByNO(contractNO);
			if(null != conList && conList.size() > 0){
				con = (Contract) conList.get(0);
				con.setStatus("已审核");
				smgr.saveContract(con);
			}
			return "checkContract";
		}catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
	}
	
	public String saveContract() throws Exception {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(null == contractDate)contractDate = new Date(System.currentTimeMillis());
		if(null == expireDate)expireDate = new Date(System.currentTimeMillis());
		try {
			ActionContext context=ActionContext.getContext(); 
			Map session = context.getSession();
			int userId = (Integer) session.get("userId");
			User user = mgr.getUserByID(userId);
			String chineseName = user.getChineseName();
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			//String contractDateStr = request.getParameter("contractDate");
			//String expireDateStr = request.getParameter("expireDate");
			Contract lcon= new Contract();
			//lcon.setContractDate(contractDate);
			//lcon.setExpireDate(expireDate);
			byte [] b = new byte[1024*1024*4];
			try{
				InputStream in = new FileInputStream(image);
				
				int n = in.read(b);
				//byte [] b1 = new byte[n];
				//b1 = b;
 
			}catch(FileNotFoundException e){
				System.out.println("没有上传照片");
			}
			
			String contextPath = ServletActionContext.getServletContext().getRealPath("/Contract/");
			File file = new File(contextPath+"/"+con.getContractNO()+".jpg");
			//File file = new File("c:\\Contract\\" +con.getContractNO()+ ".jpg");
			
			if(file.exists()){
				FileOutputStream out = new FileOutputStream(file,false); 
				//FileOutputStream fos = new FileOutputStream(image,true); 
				out.write(b, 0, b.length);
				out.close();
			}else{
				File newFile = new File(contextPath);
				newFile.mkdir();
				FileOutputStream out=new FileOutputStream(contextPath+"/" +con.getContractNO()+ ".jpg");
				out.write(b, 0, b.length);
		        out.close();
			}
			
			lcon = con;
			String contractno = lcon.getContractNO();
			List tmp = new ArrayList();
			tmp = smgr.getContractByNO(contractno);
			String emplName = lcon.getEmplName();
			HrEmployee lhe = smgr.getHrEmployeeByEmplName(emplName);
			if(tmp.size() == 0 && lhe != null){
				lcon.setExpireDate(expireDate);
				lcon.setContractDate(contractDate);
				lcon.setEmplID(lhe.getEmplID());
				lcon.setUserId(userId);
				lcon.setUserName(chineseName);
				lcon.setStatus("未审核");
				smgr.saveContract(lcon);
			}else{
				 addActionError("合同号存在或学生不存在，请重新输入");
				 return "failure";
			}
			User luser = (User) session.get("luser");
			if(luser.getUserType() == 3){
				return "agent";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "saveContract";
	}
	
	
	public String addRoom() throws Exception {
		return "addRoom";
	}
	
	public String addLesson() throws Exception {
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String teacherID = request.getParameter("teaid");
		List subjectList = new ArrayList();
		subjectList = smgr.getSubjectList();
		request.setAttribute("subjectList",subjectList);
		
		List roomNOList = new ArrayList();
		List<Classroom> roomList = new ArrayList();
		roomList = smgr.getRoomList();
		for(int m=0; m <roomList.size();m++){
			Classroom cr = new Classroom();
			cr = roomList.get(m);
			String roomNO = cr.getRoomno();
			roomNOList.add(roomNO);
		}
		request.setAttribute("roomNOList",roomNOList);
		
		tea = smgr.getTeaNameByTeaID(teacherID);
		
		return "addLesson";
	}
	
	public String saveTeacher() throws Exception {
		try {
			Teacher tc = new Teacher();
			tc = tea;
			smgr.saveTeacher(tc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "saveTeacher";
	}
	
	public String saveEmployee() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			Map session = ActionContext.getContext().getSession();
			String emplName = he.getEmplName();
			HrEmployee checkHrEmployee = smgr.getHrEmployeeByEmplName(emplName);
			if(null == checkHrEmployee ){
				HrEmployee lhe = new HrEmployee();
				String gender = request.getParameter("gender");
				
				
				lhe = he;
				if(null != gender && gender.equals("男")){
					lhe.setSex(1);
				}else{
					lhe.setSex(2);
				}
				
				Date nowDate = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String entryDate = sdf.format(nowDate);
				lhe.setEntryDate(entryDate);
				byte [] b = new byte[1024*1024*4];
				try{
					InputStream in = new FileInputStream(image);
					String contextPath = ServletActionContext.getServletContext().getRealPath("/Student/");
					File file = new File(contextPath+"/"+he.getEmplID()+".jpg");
					//File file = new File("c:\\Contract\\" +con.getContractNO()+ ".jpg");
					int i = in.read(b);
					if(file.exists()){
						FileOutputStream out = new FileOutputStream(file,false); 
						//FileOutputStream fos = new FileOutputStream(image,true); 
						out.write(b, 0, b.length);
						out.close();
					}else{
						File newFile = new File(contextPath);
						newFile.mkdir();
						FileOutputStream out=new FileOutputStream(contextPath+"/" +he.getEmplID()+ ".jpg");
						out.write(b, 0, b.length);
				        out.close();
					}
					//InputStream in2 = new FileInputStream(image);
					//ImageInfo info = JpegInfoReader.getImageInfo(in2);
					/*int height = info.getHeight();
					int width = info.getWidth();
					if(height >=250 || width >= 250){
						addActionError("图片长或宽不能大于250像素");
						return "toobig";
					}
		            System.out.println(info);*/
		            
					//byte [] b=new byte[10240*12];
					//int n = in.read(b);
					//byte [] b1 = new byte[n];
					//b1 = b;
					//lhe.setImage(b);
				}catch(FileNotFoundException e){
					System.out.println("没有上传照片");
				}
				lhe.setStatus("未审核");
				smgr.saveEmployee(lhe);
				
				HeInformation lhi = new HeInformation();
				lhi = hi;
				lhi.setEmplID(he.getEmplID());
				lhi.setEmplName(he.getEmplName());
				
				smgr.saveEmployeeDetail(lhi);	
			}else{
				String maxEmplID = smgr.findMaxEmployeeNo();
				Integer maxNo = Integer.parseInt(maxEmplID);
				maxNo = maxNo + 1 ;
				maxEmplID = maxNo.toString();
				char maxEmplIDChar []  = new char[8];
				for(int i = 0; i < maxEmplIDChar.length ; i ++){
					maxEmplIDChar[i] = '0';
				}
				for(int j = maxEmplID.length() - 1 ; j >= 0; j --){
					int index = j+ maxEmplIDChar.length - maxEmplID.length();
					maxEmplIDChar[index] =  maxEmplID.charAt(j);
				}
				maxEmplID = String.valueOf(maxEmplIDChar); 
				request.setAttribute("maxEmplID", maxEmplID);
				addActionError("此学生已经存在 ，请重新输入");
				return "failure";
			}
			User luser = (User) session.get("luser");
			if(luser.getUserType() == 3){
				return "agent";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "saveEmployee";
	}
	
	public String updateEmployee() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			HrEmployee lhe = new HrEmployee();
			String gender = request.getParameter("gender");
			
			try{
				InputStream in = new FileInputStream(imageEdit);
//				InputStream in2 = new FileInputStream(imageEdit);
//				ImageInfo info = JpegInfoReader.getImageInfo(in2);
//				int height = info.getHeight();
//				int width = info.getWidth();
//				if(height >=250 || width >= 250){
//					addActionError("图片长或宽不能大于250像素");
//					return "toobig";
//				}
//	            System.out.println(info);
	            
				byte [] b = new byte[1024*1024*4];
				
				String contextPath = ServletActionContext.getServletContext().getRealPath("/Student/");
				File file = new File(contextPath+"/"+he.getEmplID()+".jpg");
				//File file = new File("c:\\Contract\\" +con.getContractNO()+ ".jpg");
				int i = in.read(b);
				if(file.exists()){
					FileOutputStream out = new FileOutputStream(file,false); 
					//FileOutputStream fos = new FileOutputStream(image,true); 
					out.write(b, 0, b.length);
					out.close();
				}else{
					File newFile = new File(contextPath);
					newFile.mkdir();
					FileOutputStream out=new FileOutputStream(contextPath+"/" +he.getEmplID()+ ".jpg");
					out.write(b, 0, b.length);
			        out.close();
				}
				
				//he.setImage(b);
			}catch(FileNotFoundException e){
				System.out.println("没有上传照片");
			}
			
			lhe = he;
			if(null != gender && gender.equals("男")){
				lhe.setSex(1);
			}else{
				lhe.setSex(2);
			}
			smgr.saveEmployee(lhe);
			
			HeInformation lhi = new HeInformation();
			
			lhi = smgr.getHeInformationByEmplID(he.getEmplID());
			
			if(null != lhi){
				int id = lhi.getId();
				String emplID = lhi.getEmplID();
				String emplName = lhi.getEmplName();
				lhi = hi;
				lhi.setId(id);
				lhi.setEmplID(emplID);
				lhi.setEmplName(emplName);
				smgr.updateEmployeeDetail(lhi);
			}else{
				lhi = hi;
				lhi.setEmplID(he.getEmplID());
				lhi.setEmplName(he.getEmplName());
				smgr.saveEmployeeDetail(lhi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "updateEmployee";
	}
	
	public String checkEmployee() throws Exception {
		try {
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			HrEmployee lhe = new HrEmployee();
			String gender = request.getParameter("gender");
			
			lhe = smgr.getHrEmployeeByEmplID(he.getEmplID());
			/*lhe = he;
			if(null != gender && gender.equals("男")){
				lhe.setSex(1);
			}else{
				lhe.setSex(0);
			}*/
			lhe.setStatus("已审核");
			smgr.saveEmployee(lhe);
			
			/*HeInformation lhi = new HeInformation();
			
			lhi = smgr.getHeInformationByEmplID(he.getEmplID());
			
			if(null != lhi){
				int id = lhi.getId();
				String emplID = lhi.getEmplID();
				String emplName = lhi.getEmplName();
				lhi = hi;
				lhi.setId(id);
				lhi.setEmplID(emplID);
				lhi.setEmplName(emplName);
				smgr.updateEmployeeDetail(lhi);
			}else{
				lhi = hi;
				lhi.setEmplID(he.getEmplID());
				lhi.setEmplName(he.getEmplName());
				smgr.saveEmployeeDetail(lhi);
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "checkEmployee";
	}
	
	public String saveRoom() throws Exception {
		try {
			Classroom cr = new Classroom();
			cr = room;
			smgr.saveRoom(cr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "saveRoom";
	}
	
	 public void ajaxContractNOCheck() throws Exception {
			HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����  
			HttpServletRequest request = ServletActionContext.getRequest();//ȡrequest����      
			//��������Ӧ		
			response.setContentType("text/xml;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			String contractNO = request.getParameter("contractNO"); 
			String msgStr="";
			
			Map session = ActionContext.getContext().getSession(); //��ȡsession
			
			List cl = new ArrayList();
			cl = smgr.getContractByNO(contractNO);
			//String password = (String) session
			//		.get("password"); //��ȡUser����
			if (null != cl && cl.size() >= 1) {
				msgStr="1";	
			}
			try {//responseд��Ϣ    
				response.getWriter().print(msgStr);
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	 
	    public void ajaxEmplNameCheck() throws Exception {
			HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����  
			HttpServletRequest request = ServletActionContext.getRequest();//ȡrequest����      
			//��������Ӧ		
			response.setContentType("text/xml;charset=utf-8");
			//response.setHeader("Charset","GB2312");
			//response.setContentType("text/xml;charset=gbk");
			response.setHeader("Cache-Control", "no-cache");
			//request.setCharacterEncoding("UTF-8" ); 
			String emplName = request.getParameter("emplName");
			
			//emplName = URLDecoder.decode(emplName,"utf8");
			TestEncoder te = new TestEncoder();
			emplName = te.unescape(emplName);
			//emplName = te.getUTF8StringFromGBKString(emplName);
			//emplName = Util.filter(request.getParameter("q_bureau_name"));
			//String emplName =  new String(request.getParameter("emplName").getBytes("GBK"),"iso-8859-1");//getBytes("","gb2312"));
			//emplName = new String( emplName.getBytes("gbk"), "utf-8"); 
			
			//emplName = new String(emplName.getBytes("utf-8"),"iso-8859-1");  
			
			String msgStr="";
			
			Map session = ActionContext.getContext().getSession(); //��ȡsession
			
			//HrEmployee lhe = new HrEmployee();
			//HrEmployee lhe = smgr.getHrEmployeeByEmplID(emplID);
			HrEmployee lhe = smgr.getHrEmployeeByEmplName(emplName);
			if (null == lhe) {
				msgStr="1";	
			}
			try {//responseд��Ϣ    
				response.getWriter().print(msgStr);
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	
	/* employee method section  */
	
	

	public List<Teacher> getTeaList() {
		return teaList;
	}

	public void setTeaList(List<Teacher> teaList) {
		this.teaList = teaList;
	}

	public HrEmployee getHe() {
		return he;
	}

	public void setHe(HrEmployee he) {
		this.he = he;
	}

	public HeInformation getHi() {
		return hi;
	}

	public void setHi(HeInformation hi) {
		this.hi = hi;
	}

	public List<Contract> getConList() {
		return conList;
	}

	public void setConList(List<Contract> conList) {
		this.conList = conList;
	}

	public Contract getCon() {
		return con;
	}

	public void setCon(Contract con) {
		this.con = con;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getImageEdit() {
		return imageEdit;
	}

	public void setImageEdit(File imageEdit) {
		this.imageEdit = imageEdit;
	}
}
