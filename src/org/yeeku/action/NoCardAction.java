package org.yeeku.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.yeeku.model.Classroom;
import org.yeeku.model.EquCard;
import org.yeeku.model.ExClassRecord;
import org.yeeku.model.HrEmployee;
import org.yeeku.model.ManualRecord;
import org.yeeku.model.Record;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;
import org.yeeku.service.StudentListManager;
import org.yeeku.service.UserManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NoCardAction extends ActionSupport {
	
	public List<HrEmployee> heList;
	
	public List stuRankList;
	
	private Date todayStartDate;

	private Date todayEndDate;
	
	private HrEmployee hrEmpl;
	
	protected StudentListManager smgr;
	
	private ManualRecord mr;
	
	private ExClassRecord ecr;
	
	private List<ManualRecord> mrl;
	
	public List<ManualRecord> getMrl() {
		return mrl;
	}

	public void setMrl(List<ManualRecord> mrl) {
		this.mrl = mrl;
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

	public List getStuRankList() {
		return stuRankList;
	}

	public void setStuRankList(List stuRankList) {
		this.stuRankList = stuRankList;
	}

	

	public ManualRecord getMr() {
		return mr;
	}

	public void setMr(ManualRecord mr) {
		this.mr = mr;
	}

	public ExClassRecord getEcr() {
		return ecr;
	}

	public void setEcr(ExClassRecord ecr) {
		this.ecr = ecr;
	}

	public List<HrEmployee> getHeList() {
		return heList;
	}
	   
	public void setHeList(List<HrEmployee> heList) {
		this.heList = heList;
	}

	public HrEmployee getHrEmpl() {
		return hrEmpl;
	}

	public void setHrEmpl(HrEmployee hrEmpl) {
		this.hrEmpl = hrEmpl;
	}


	public void setSmgr(StudentListManager smgr) {
		this.smgr = smgr;
	}
	
	protected UserManager mgr;

    public void setMgr(UserManager mgr)
    {
        this.mgr = mgr;
    }
	
	public String search() throws Exception
	{
		heList = smgr.getAllStudent();
        return "search";
	}
	
	/*public String searchUser() throws Exception
	{
		heList = smgr.getAllStudent();
        return "searchUser";
	}*/
	
	public String searchStudent() throws Exception
	{
		if("".equals(hrEmpl.getEmplID()) && "".equals(hrEmpl.getEmplName())){
			heList = smgr.getAllStudent();
		}else{
			heList = smgr.getStuList(hrEmpl.getEmplID(), hrEmpl.getEmplName());
		}	
        return "searchStudent";
	}
	
	public String forgetRank() throws Exception
	{  
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		//cal.add(Calendar.DATE, -1);    //�õ�ǰһ�� 
		cal.add(Calendar.MONTH, -1);    //�õ�ǰһ����
		long date = cal.getTimeInMillis();
		Date kk=df.parse(df.format(new Date(date)));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
		if(null == todayEndDate)todayEndDate = new Date(System.currentTimeMillis());
		
		
		
		//String startDate = sdf.format(todayStartDate);
		//String endDate = sdf.format(todayEndDate);
		
		stuRankList = new ArrayList();
		stuRankList = smgr.getStuRank(todayStartDate, todayEndDate);
        return "forgetRank";
	}
	
	public String searchActivityStudent() throws Exception
	{
		heList = smgr.getAllStudent();
        return "activityHandle";
	}
	
	public String searchActivityStudentByIDorName() throws Exception
	{
		heList = smgr.getHrEmployeeByEmplIDorName(hrEmpl.getEmplID(), hrEmpl.getEmplName());
        return "searchActivityStudentByIDorName";
	}
	
	public String recoverCardRecord() throws Exception
	{
		mrl = new ArrayList();
		
		List<ManualRecord> lmrl = new ArrayList();
		List<Record> currentCardRecordList =  new ArrayList();
		currentCardRecordList = smgr.getCurrentRecordList();
		List<String> emplIDStr = new ArrayList();
		if(null != currentCardRecordList && currentCardRecordList.size() > 0){
			for(int x = 0; x < currentCardRecordList.size(); x++){
				Record r = new Record();
				r = currentCardRecordList.get(x);
				EquCard equCard = smgr.getStudentNameByCardNO(r.getCardNO());
				String emplID = equCard.getEmplID();
				emplIDStr.add(emplID);
			}
			
		}
		if(null != hrEmpl){
			String emplID = hrEmpl.getEmplID();
			String emplName = hrEmpl.getEmplName();
			lmrl = smgr.getManualRecord(emplID, emplName);
		}else{
			lmrl = smgr.getManualRecord();
		}
		if(null != lmrl && lmrl.size() > 0){
			for(int i = 0; i < lmrl.size();i++){
				ManualRecord lmr = new ManualRecord();
				lmr = lmrl.get(i);
				if(emplIDStr.contains(lmr.getEmplID())){
					lmr.setContained(true);	
				}else{
					lmr.setContained(false);	
				}
				mrl.add(lmr);
			}
		}
        return "recoverCardRecord";
	}
	
	public String saveRecoverRecord() throws Exception
	{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String id = request.getParameter("id");
		int idInteger = -1;
		if(null != id)idInteger = Integer.parseInt(id);
		ManualRecord mmr = new ManualRecord();
		mmr = smgr.getManualRecord(idInteger);
		Date payTime = new Date(System.currentTimeMillis());
		mmr.setPayTime(payTime);
		mmr.setStatus("已刷卡");
		smgr.saveMR(mmr);
		
        return "saveRecoverRecord";
	}
	
	public String fillMoreInformation() throws Exception
	{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		
		if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
		
		String idlist[] = request.getParameterValues("permisskey");
		heList = new ArrayList<HrEmployee>();
		if(idlist != null){
			for(int i = 0;i < idlist.length; i++){
				String emplID = idlist[i];
				HrEmployee ahe = new HrEmployee();
				ahe = smgr.getHrEmployeeByEmplID(emplID);
				heList.add(ahe);
			}
		}
		
		List<Teacher> teacherList = new ArrayList();
		teacherList = smgr.getTeaList();
		List teaStringList = new ArrayList();
		for(int i = 0; i < teacherList.size(); i++){
			Teacher tc = new Teacher();
			tc = teacherList.get(i);

		}
		request.setAttribute("teaStringList",teaStringList);
		
        return "fillMoreInformation";
	}
	
	public String fillMoreLessonInformation() throws Exception{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String idlist[] = request.getParameterValues("permisskey");
		
		Map session = ActionContext.getContext().getSession();
		session.put("idlist", idlist);
		if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
		
		heList = new ArrayList<HrEmployee>();
		if(idlist != null){
			for(int i = 0;i < idlist.length; i++){
				String emplID = idlist[i];
				HrEmployee ahe = new HrEmployee();
				ahe = smgr.getHrEmployeeByEmplID(emplID);
				heList.add(ahe);
			}
		}
		
		/*ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String emplID = request.getParameter("emplID");*/
		mr = new ManualRecord();
		List subjectList = new ArrayList();
		subjectList = smgr.getSubjectList();
		//String activity = "活动课";
		//subjectList.add(activity);
		
		request.setAttribute("subjectList",subjectList);
		
		List<Teacher> teacherList = new ArrayList();
		teacherList = smgr.getTeaList();
		List teaStringList = new ArrayList();
		for(int i = 0; i < teacherList.size(); i++){
			Teacher tc = new Teacher();
			tc = teacherList.get(i);
	
		}
		request.setAttribute("teaStringList",teaStringList);
		
		List<Classroom> roomList = new ArrayList();
		roomList = smgr.getRoomList();
		
		List roomIDAndNOList = new ArrayList();
		for(int m=0; m <roomList.size();m++){
			Classroom cr = new Classroom();
			cr = roomList.get(m);
			String roomID = String.valueOf(cr.getId());
			String roomNO = cr.getRoomno();
			roomIDAndNOList.add(roomID+" "+roomNO);
		}
		request.setAttribute("roomIDAndNOList",roomIDAndNOList);
		
		
		//hrEmpl = smgr.getHrEmployeeByEmplID(emplID);
		
		mr.setEmplID(hrEmpl.getEmplID());
		mr.setEmplName(hrEmpl.getEmplName());
		
		User luser = (User) session.get("luser");
		return "chooseStudent";
		/*if(luser.getUserType() == 1){
			return "chooseStudent";
		}else{
			return "chooseStudentUser";
		}*/
		
	}
	
	public String handleExClass() throws Exception{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		
		if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
		
		List subjectList = new ArrayList();
		subjectList = smgr.getSubjectList();
		//String activity = "活动课";
		//subjectList.add(activity);
		
		request.setAttribute("subjectList",subjectList);
		
		List<Teacher> teacherList = new ArrayList();
		teacherList = smgr.getTeaList();
		List teaStringList = new ArrayList();
		for(int i = 0; i < teacherList.size(); i++){
			Teacher tc = new Teacher();
			tc = teacherList.get(i);
	
		}
		request.setAttribute("teaStringList",teaStringList);
		
		List<Classroom> roomList = new ArrayList();
		roomList = smgr.getRoomList();
		
		List roomIDAndNOList = new ArrayList();
		for(int m=0; m <roomList.size();m++){
			Classroom cr = new Classroom();
			cr = roomList.get(m);
			String roomID = String.valueOf(cr.getId());
			String roomNO = cr.getRoomno();
			roomIDAndNOList.add(roomID+" "+roomNO);
		}
		request.setAttribute("roomIDAndNOList",roomIDAndNOList);
		
		return "handleExClass";
	}
	
	public String saveManualRecord() throws Exception
	{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		Map session = ActionContext.getContext().getSession();
		int userID = (Integer) session.get("userId");
		User  user = mgr.getUserByID(userID);
		String chineseName = user.getChineseName();
		String teacherIDAndName = request.getParameter("teacherIDAndName");
		String teaID[] = teacherIDAndName.split(" ");
		
		String roomIDAndNOList = request.getParameter("roomIDAndNO");
		String roomIDAndNo[] = roomIDAndNOList.split(" ");
		int roomID = Integer.valueOf(roomIDAndNo[0]);
		
		String lessonDate = request.getParameter("todayStartDate");

		
		String emplIDs[] = request.getParameterValues("emplID");
		for(int i = 0;i < emplIDs.length;i++){
			String emplID = emplIDs[i];
			HrEmployee lhe = new HrEmployee();
			lhe = smgr.getHrEmployeeByEmplID(emplID);
			
			ManualRecord lmr = new ManualRecord();
			lmr.setEmplID(lhe.getEmplID());
			lmr.setEmplName(lhe.getEmplName());
			

			Date nowTime = new Date(System.currentTimeMillis());
			lmr.setRecordTime(nowTime);
			lmr.setStatus("未刷卡");
			lmr.setCellPhone(lhe.getRemark());
			lmr.setReasonType("手动输入");
			lmr.setLessonNumber(mr.getLessonNumber());
			lmr.setRoomID(roomID);
			lmr.setRoomNO(roomIDAndNo[1]);
			lmr.setSubject(mr.getSubject());
			lmr.setLessonDate(lessonDate);
			lmr.setOperBy(chineseName);
			
			smgr.saveMR(lmr);	
		}
		
		
		/*if(null != teaID){
			Teacher tc = new Teacher();
			String teacherID = teaID[0];
			tc = smgr.getTeaNameByTeaID(teacherID);
			mr.setTeacherID(teacherID);
			mr.setTeacherName(tc.getTeaname());
		}else{
			mr.setTeacherID("未知");
			mr.setTeacherName("未知");
		}
		
		
		Date nowTime = new Date(System.currentTimeMillis());
		mr.setRecordTime(nowTime);
		mr.setStatus("未刷卡");
		
		HrEmployee hrEmpl = new HrEmployee();
		hrEmpl = smgr.getHrEmployeeByEmplID(mr.getEmplID());
		mr.setCellPhone(hrEmpl.getRemark());
		mr.setReasonType("手动输入");
		
		smgr.saveMR(mr);*/
		
        return "saveManualRecord";
	}
	
	
	public String saveManualRecordUser() throws Exception
	{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String emplID = mr.getEmplID();
			HrEmployee lhe = new HrEmployee();
			lhe = smgr.getHrEmployeeByEmplID(emplID);
			
			Map session = ActionContext.getContext().getSession();
			int userID = (Integer) session.get("userId");
			User  user = mgr.getUserByID(userID);
			String chineseName = user.getChineseName();
			
			Date todayDate = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String todayStr = sdf.format(todayDate);
			int passLogCount = 0;
			String passLogDate = lhe.getPassLogDate();
			if(null != lhe.getPassLogCount()){
				passLogCount = lhe.getPassLogCount();
			}
			 
			
			
			String priIiniPass = lhe.getIniPass();
			String iniPass = "-1";
			if(null != priIiniPass){
				iniPass = priIiniPass.trim();
			}
			String inputIniPass = hrEmpl.getIniPass();
			
				if(iniPass.equals(inputIniPass)){
					if(passLogCount < 10){
						ManualRecord lmr = new ManualRecord();
						lmr = mr;
						lmr.setEmplID(lhe.getEmplID());
						lmr.setEmplName(lhe.getEmplName());

						Date nowTime = new Date(System.currentTimeMillis());
						lmr.setRecordTime(nowTime);
						lmr.setStatus("未刷卡");
						lmr.setCellPhone(lhe.getRemark());
						lmr.setReasonType("手动输入");
						lmr.setLessonNumber(mr.getLessonNumber());
						lmr.setRoomID(mr.getRoomID());
						lmr.setRoomNO(mr.getRoomNO());
						lmr.setSubject(mr.getSubject());
						//lmr.setLessonDate(lessonDate);
						lmr.setOperBy(chineseName);
						smgr.saveMR(lmr);
						
						lhe.setPassLogDate(todayStr);
						lhe.setPassLogCount(0);
						smgr.saveEmployee(lhe);
						
						addActionMessage("添加成功");
					    return "saveManualRecordUser";
					}else{
						addActionError("你已经输入错误超过10次，该学生当日已经锁定");
						return "failure";	
					}
					
					
				}else{
					
						if(null == passLogDate){
							lhe.setPassLogDate(todayStr);
							lhe.setPassLogCount(passLogCount+1);
							smgr.saveEmployee(lhe);
						}else{
							if(passLogDate.equals(todayStr)){
								if(passLogCount < 10){
									lhe.setPassLogCount(passLogCount+1);
									smgr.saveEmployee(lhe);
								}else{
									addActionError("你已经输入错误超过10次，该学生当日已经锁定");
									return "failure";	
								}	
							}else{		
									lhe.setPassLogDate(todayStr);
									lhe.setPassLogCount(1);
									smgr.saveEmployee(lhe);
							}
						}
						addActionError("密码错误，请重新弄输入,你已经输入错误"+lhe.getPassLogCount()+"次，超过10次该学生当日将会锁定");
						return "failure";	
					}	
	}
	
	public String confirmPass() throws Exception
	{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String teacherIDAndName = request.getParameter("teacherIDAndName");
		String teaID[] = teacherIDAndName.split(" ");
		
		String roomIDAndNOList = request.getParameter("roomIDAndNO");
		String roomIDAndNo[] = roomIDAndNOList.split(" ");
		int roomID = Integer.valueOf(roomIDAndNo[0]);
		mr.setRoomID(roomID);
		mr.setRoomNO(roomIDAndNo[1]);
		
		Date todayDate = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todayStr = sdf.format(todayDate);
		
		Map session = ActionContext.getContext().getSession();
		String idlist[] = (String [])session.get("idlist");
		heList = new ArrayList<HrEmployee>();
		if(idlist != null){
			for(int i = 0;i < idlist.length; i++){
				String emplID = idlist[i];
				HrEmployee ahe = new HrEmployee();
				ahe = smgr.getHrEmployeeByEmplID(emplID);
				mr.setEmplID(ahe.getEmplID());
				mr.setEmplName(ahe.getEmplName());
				heList.add(ahe);
			}
		}
		
		
		String todayStartDate = request.getParameter("todayStartDate");
		mr.setLessonDate(todayStartDate);
		//request.setAttribute("todayStartDate", todayStartDate);
		//request.setAttribute("teacherIDAndName", teacherIDAndName);
		
		

		
		String emplIDs[] = request.getParameterValues("emplID");
		for(int i = 0;i < emplIDs.length;i++){
			String emplID = emplIDs[i];
			HrEmployee lhe = new HrEmployee();
			lhe = smgr.getHrEmployeeByEmplID(emplID);
			
			ManualRecord lmr = new ManualRecord();
			lmr.setEmplID(lhe.getEmplID());
			lmr.setEmplName(lhe.getEmplName());
			if(null != teaID){
				Teacher tc = new Teacher();
				String teacherID = teaID[0];
				tc = smgr.getTeaNameByTeaID(teacherID);
				mr.setTeacherID(teacherID);
				lmr.setTeacherID(teacherID);
			}else{
				lmr.setTeacherID("未知");
				lmr.setTeacherName("未知");
			}

			Date nowTime = new Date(System.currentTimeMillis());
			lmr.setRecordTime(nowTime);
			lmr.setStatus("未刷卡");
			lmr.setCellPhone(lhe.getRemark());
			lmr.setReasonType("手动输入");
			lmr.setLessonNumber(mr.getLessonNumber());
			lmr.setRoomNO(mr.getRoomNO());
			lmr.setSubject(mr.getSubject());
			//lmr.setLessonDate(todayStartDate);
			
			//smgr.saveMR(lmr);	
		}
		
        return "confirmPass";
	}
	
	public String saveExClassRecord() throws Exception
	{
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		
		
		//---------------------segment start--------------------------------
		//此段代码是为了带入页面初始化list
        if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
		
		List subjectList = new ArrayList();
		subjectList = smgr.getSubjectList();
		//String activity = "活动课";
		//subjectList.add(activity);
		
		request.setAttribute("subjectList",subjectList);
		
		List<Teacher> teacherList = new ArrayList();
		teacherList = smgr.getTeaList();
		List teaStringList = new ArrayList();
		for(int i = 0; i < teacherList.size(); i++){
			Teacher tc = new Teacher();
			tc = teacherList.get(i);
		}
		request.setAttribute("teaStringList",teaStringList);
		
		List<Classroom> roomList = new ArrayList();
		roomList = smgr.getRoomList();
		
		List roomNOList = new ArrayList();
		for(int m=0; m <roomList.size();m++){
			Classroom cr = new Classroom();
			cr = roomList.get(m);
			String roomNO = cr.getRoomno();
			roomNOList.add(roomNO);
		}
		request.setAttribute("roomNOList",roomNOList);
		//------------------------segment end-----------------------------
		
		String teacherIDAndName = request.getParameter("teacherIDAndName");
		String teaID[] = teacherIDAndName.split(" ");
		
		String roomIDAndNOList = request.getParameter("roomIDAndNO");
		String roomIDAndNo[] = roomIDAndNOList.split(" ");
		int roomID = Integer.valueOf(roomIDAndNo[0]);
		
		ExClassRecord lecr = new ExClassRecord();
		String classDate = request.getParameter("todayStartDate");
        try{
        	 lecr = ecr;
             lecr.setTeacherID(teaID[0]);
             lecr.setTeacherName(teaID[1]);
             lecr.setRoomID(roomID);
             lecr.setRoomNo(roomIDAndNo[1]);
             
             Date nowTime = new Date(System.currentTimeMillis());
             lecr.setRecordTime(nowTime);
             lecr.setClassDate(classDate);
             smgr.saveECR(lecr);
             addActionMessage("添加成功");
             return "saveExClassRecord";
		  }catch(Exception e){
			 e.printStackTrace();
			 addActionError("添加失败，请重新输入");
			 return "failure";
		  }
	}
	
	public String saveActivityManualRecord() throws Exception
	{   
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String teacherIDAndName = request.getParameter("teacherIDAndName");
		String note = request.getParameter("note");
		String teaID[] = teacherIDAndName.split(" ");
		String emplIDs[] = request.getParameterValues("emplID");
		
		String lessonDate = request.getParameter("todayStartDate");
		
		for(int i = 0;i < emplIDs.length;i++){
			String emplID = emplIDs[i];
			HrEmployee lhe = new HrEmployee();
			lhe = smgr.getHrEmployeeByEmplID(emplID);
			
			ManualRecord lmr = new ManualRecord();
			lmr.setEmplID(lhe.getEmplID());
			lmr.setEmplName(lhe.getEmplName());
			if(null != teaID){
				Teacher tc = new Teacher();
				String teacherID = teaID[0];
				tc = smgr.getTeaNameByTeaID(teacherID);
				lmr.setTeacherID(teacherID);
			}else{
				lmr.setTeacherID("未知");
				lmr.setTeacherName("未知");
			}

			Date nowTime = new Date(System.currentTimeMillis());
			lmr.setRecordTime(nowTime);
			lmr.setStatus("未刷卡");
			lmr.setCellPhone(lhe.getRemark());
			lmr.setReasonType("活动课");
			lmr.setNote(note);
			lmr.setLessonDate(lessonDate);
			
			smgr.saveMR(lmr);	
		}
        return "saveActivityManualRecord";
	}

}
