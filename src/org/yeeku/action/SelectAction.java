package org.yeeku.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.yeeku.model.Cell;
import org.yeeku.model.CellRecordSet;
import org.yeeku.model.Classroom;
import org.yeeku.model.Contract;
import org.yeeku.model.Cursch;
import org.yeeku.model.EquCard;
import org.yeeku.model.ExClassRecord;
import org.yeeku.model.HrEmployee;
import org.yeeku.model.ManualRecord;
import org.yeeku.model.Record;
import org.yeeku.model.StudentRecord;
import org.yeeku.model.Teacher;
import org.yeeku.model.TeacherCounter;
import org.yeeku.model.TeacherSubCounter;
import org.yeeku.model.User;
import org.yeeku.service.StudentListManager;
import org.yeeku.service.UserManager;
import org.yeeku.util.ComparatorStudent;
import org.yeeku.util.DateTimeUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SelectAction extends ActionSupport {

	protected StudentListManager smgr;

	private  static final SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	
	public void setSmgr(StudentListManager smgr) {
		this.smgr = smgr;
	}
	
	 protected UserManager mgr;

	    public void setMgr(UserManager mgr)
	    {
	        this.mgr = mgr;
	    }

	private List<StudentRecord> stuList;
	
	private List<ManualRecord> manualRecordList;
	
	private List<ExClassRecord> exClassRecordList;

	public List<ExClassRecord> getExClassRecordList() {
		return exClassRecordList;
	}

	public void setExClassRecordList(List<ExClassRecord> exClassRecordList) {
		this.exClassRecordList = exClassRecordList;
	}

	private HrEmployee hrEmpl;
	
	public HrEmployee getHrEmpl() {
		return hrEmpl;
	}

	public List<ManualRecord> getManualRecordList() {
		return manualRecordList;
	}

	public void setManualRecordList(List<ManualRecord> manualRecordList) {
		this.manualRecordList = manualRecordList;
	}

	public void setHrEmpl(HrEmployee hrEmpl) {
		this.hrEmpl = hrEmpl;
	}

	private List<TeacherCounter> tcList;
	
	private List<TeacherSubCounter> tcSubList;
	
	public List<TeacherSubCounter> getTcSubList() {
		return tcSubList;
	}

	public void setTcSubList(List<TeacherSubCounter> tcSubList) {
		this.tcSubList = tcSubList;
	}

	private Date todayStartDate;
	
	public List<TeacherCounter> getTcList() {
		return tcList;
	}

	public void setTcList(List<TeacherCounter> tcList) {
		this.tcList = tcList;
	}

	private Date todayEndDate;

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
	
	public String password() throws Exception {
		return "password";
		
	}
	
	 /** ������*/
	private String oldPassword; 
	 /** ������*/
	private String password; 
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String selectRecord() throws Exception {
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		
		if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullDateFormat = sdf.format(todayStartDate);
		//todayStartDate = sdf.parse(fullDateFormat);
		
		List lrl = new ArrayList<Classroom>();
		lrl = smgr.getRoomList();
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		//Date nowDate = new Date(System.currentTimeMillis());
		//System.out.println(nowDate);
		//DateFormat f3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		//System.out.println("现在的时间是："+f3.format(new Date()));
		String weekday = sdw.format(todayStartDate);
		
		
		
		DateTimeUtil dtu = new DateTimeUtil();
		Date startDate = dtu.getStartDate(todayStartDate);
		Date endDate = dtu.getEndDate(todayStartDate);
		
		List recordSet = new ArrayList<CellRecordSet>();
		
		List lessonTimeList = new ArrayList();
		String lesson1 = "09:00-09:45";
		String lesson2 = "10:00-10:45";
		String lesson3 = "11:00-11:45";
		String lesson4 = "12:00-12:45";
		String lesson5 = "13:00-13:45";
		String lesson6 = "14:00-14:45";
		String lesson7 = "15:00-15:45";
		String lesson8 = "16:00-16:45";
		String lesson9 = "17:00-17:45";
		String lesson10 = "18:00-18:45";
		String lesson11 = "18:30-19:15";
		String lesson12 = "19:00-19:45";
		lessonTimeList.add(lesson1);
		lessonTimeList.add(lesson2);
		lessonTimeList.add(lesson3);
		lessonTimeList.add(lesson4);
		lessonTimeList.add(lesson5);
		lessonTimeList.add(lesson6);
		lessonTimeList.add(lesson7);
		lessonTimeList.add(lesson8);
		lessonTimeList.add(lesson9);
		lessonTimeList.add(lesson10);
		lessonTimeList.add(lesson11);
		lessonTimeList.add(lesson12);
		
		
		
		
		
		for(int n = 1; n <= 12; n++){
			CellRecordSet row = new CellRecordSet();
			List cellList = new ArrayList();
			int roomID;
			Classroom cr = new Classroom();
			for(int i = 0; i < lrl.size(); i++){
				cr = (Classroom) lrl.get(i);
				roomID = cr.getId();
				//Cursch cs = new Cursch();
				//cs = smgr.getCursch(weekday, roomNO, n);
				ManualRecord mr = new ManualRecord();
				//通过上课的当天日期，房间号，第几节课
				mr = smgr.getManualRecordByDate(fullDateFormat,startDate, endDate,roomID,n);
				
				List mrl = smgr.getManualRecordNumberByDate(fullDateFormat,startDate, endDate,roomID,n);
				Integer recordNumber = 0;
				if(null != mrl) recordNumber = mrl.size();
				Cell cell = new Cell();
				if(null != mr){
					cell.setLessonno(n);
					cell.setRoomID(cr.getId());
					cell.setRoomno(cr.getRoomno());
					cell.setTeaID(mr.getTeacherID());
					cell.setTeaName(mr.getTeacherName());
					cell.setSubject(mr.getSubject());
					cell.setRecordNumber(recordNumber);
				}
				cellList.add(cell);	
			}
			String lessonTime =  (String) lessonTimeList.get(n-1);
			row.setLessonTime(lessonTime);
			row.setCellList(cellList);
			recordSet.add(row);
		}
		
		request.setAttribute("recordSet",recordSet);
		request.setAttribute("roomList",lrl);
		request.setAttribute("fullDateFormat",fullDateFormat);
		request.setAttribute("lessonTimeList",lessonTimeList);
		
		manualRecordList = new ArrayList();
		manualRecordList = smgr.getManualRecordByDate(fullDateFormat);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ManualRecord mr = new ManualRecord();
		for(int i = 0; i < manualRecordList.size(); i++){
			mr = manualRecordList.get(i);
			mr.setRecordTimeFormat(sdf1.format(mr.getRecordTime()));
			/*Classroom cr = new Classroom();
			cr = smgr.getRoomByID(mr.getRoomID());
			mr.setRoomNO(cr.getRoomno());*/
		}
		
		exClassRecordList = new ArrayList();
		List<ExClassRecord> lexClassRecordList = smgr.getExClassRecordByDate(fullDateFormat);
		ExClassRecord ecr = new ExClassRecord();
		for(int i = 0; i < lexClassRecordList.size(); i++){
			ecr = lexClassRecordList.get(i);
			ecr.setRecordTimeFormat(sdf1.format(ecr.getRecordTime()));
			exClassRecordList.add(ecr);
		}
		
		return "selectRecord";
	}
	
	public String lessonRecordDetail() throws Exception {
		ActionContext context=ActionContext.getContext(); 
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
		String specifiedDateStr = request.getParameter("specifiedDate");
		//String roomno = request.getParameter("roomno");
		String roomIDStr = request.getParameter("roomid");
		int roomID = Integer.valueOf(roomIDStr);
		Classroom cr = new Classroom();
		cr = smgr.getRoomByID(roomID);
		String roomno = cr.getRoomno();
		String lessonno = request.getParameter("lessonno");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date specifiedDate = sdf.parse(specifiedDateStr);
		DateTimeUtil dtu = new DateTimeUtil();
		Date startDate = dtu.getStartDate(specifiedDate);
		Date endDate = dtu.getEndDate(specifiedDate);
		List lmrl = new ArrayList<ManualRecord>();
		int lessonNumber = Integer.parseInt(lessonno);
		lmrl = smgr.getManualRecordListByDate(specifiedDateStr, startDate, endDate, roomID, lessonNumber);
		
		manualRecordList = new ArrayList();
		manualRecordList = lmrl;
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ManualRecord mr = new ManualRecord();
		for(int i = 0; i < manualRecordList.size(); i++){
			mr = manualRecordList.get(i);
			mr.setRecordTimeFormat(sdf1.format(mr.getRecordTime()));
			cr = smgr.getRoomByID(mr.getRoomID());
			mr.setRoomNO(cr.getRoomno());
		}
		
		request.setAttribute("specifiedDateStr",specifiedDateStr);
		request.setAttribute("roomno",roomno);
		request.setAttribute("lessonno",lessonno);
		return "lessonRecordDetail";
	}

	public String search() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			 /** 
		     * ȡ�������������� 
		     */  
			   Date todayStart = null;
			   Date todayEnd = null;
		       DateTimeUtil dtu = new DateTimeUtil(); 
		       if(null == todayStartDate) {
		    	   todayStart = dtu.getTodayStartDate();
		       }else{
		    	   todayStart = todayStartDate;
		       }
		       if(null == todayEndDate){
		    	   todayEnd = dtu.getTodayEndDate();
		       }else{
		    	   todayEnd = todayEndDate;
		       }
		       
			if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
			if(null == todayEndDate)todayEndDate = new Date(System.currentTimeMillis());
			
			String startDate = sdf.format(todayStartDate);
			String endDate = sdf.format(todayEndDate);
			
			stuList = new ArrayList<StudentRecord>();
			List<Record> rList = new ArrayList();
			rList = smgr.getRecordList(startDate, endDate);
			
			for (int i = 0; i < rList.size(); i++) {
				StudentRecord s = new StudentRecord();
				Record r = new Record();
				r = rList.get(i);
				
				// ͨ��cardNO�õ�ѧ�����ֺ�ID
				String cardNO = r.getCardNO();
				EquCard equCard = smgr.getStudentNameByCardNO(cardNO);
				s.setStuName(equCard.getEmplName());
				s.setStuID(equCard.getEmplID());
				s.setSdate(r.getConsumeDate());
				s.setStime(r.getConsumeTime());

				// ͨ���豸��NO�õ�����NO
				String equNO = r.getEquNO();
				Classroom cr = smgr.getRoomNOByEquNO(equNO);
				String roomNO = cr.getRoomno();

				// ͨ��ˢ��ʱ�䣬���ڣ����ڼ��������ҵõ��Ͽ���ʦ�Ϳγ����
				
				Date date = sdf.parse(r.getConsumeDate());
				SimpleDateFormat sdw = new SimpleDateFormat("E");
				String weekDay = sdw.format(date);
				String time = r.getConsumeTime().substring(0, 5);
				
                s.setWeekDay(weekDay);
            	Cursch cursch = new Cursch();
   				cursch = smgr.getCursch(weekDay,roomNO, time);
   				
   				Teacher tc = new Teacher();
   				
   				if(null != cursch){
   					tc = smgr.getTeaNameByTeaID(cursch.getTeaid());

   	   				//s.setTeaName(tc.getTeaname());
   	   				s.setSubject(cursch.getSubject());
   				}else{
   					s.setTeaName("");
   	   				s.setSubject("δ֪");
   				}
   				
   				
               
				stuList.add(s);

			}
			
			
			//��ʦ��������ͳ���߼�
			tcList = new ArrayList<TeacherCounter>();
	        ComparatorStudent comparator=new ComparatorStudent();
			Collections.sort(stuList, comparator);
			String teaNameBefore = "0000"; 
			int teacherNumber = 0; // teacherNumber��¼����ÿ����ʦ�������Ͽ�ѧ����
			for(int i = 0; i < stuList.size(); i++){
				  StudentRecord sr = new StudentRecord();
				  sr = stuList.get(i);
				  String teaNameAfter = sr.getTeaName();
				  
				  //��ǰ����ʦ���ֲ�ͬ���Ҳ��ǵ�һ����ʦʱ,���������һ����ʦʱ���ʹ���һ��������ʦ�ܼ�ͳ��
				  if((teaNameBefore != "0000" && ! teaNameBefore.equals(teaNameAfter))){
					  TeacherCounter tc = new TeacherCounter();
					  tc.setTeaName(teaNameBefore);
					  tc.setNumber(teacherNumber);
					  teacherNumber = 0;
					  tcList.add(tc);
					}
				  teacherNumber = teacherNumber + 1;
				  
				  if(i == stuList.size()-1){
					  TeacherCounter tc = new TeacherCounter();
					  tc.setTeaName(teaNameBefore);
					  tc.setNumber(teacherNumber);
					  teacherNumber = 0;
					  tcList.add(tc);
				  }
				  
				  teaNameBefore = teaNameAfter;
				  
			}
			
			//ͳ�Ƶ���ÿ����ʦÿ�ڿε��Ͽ�ѧ������
			tcSubList = new ArrayList<TeacherSubCounter>();
			String teaNameBefore2 = "0000"; 
			String subjectBefore2 = "0000";
			int teacherNumber2 = 0;
			for(int i = 0; i < stuList.size(); i++){
				  StudentRecord sr = new StudentRecord();
				  sr = stuList.get(i);
				  String teaNameAfter2 = sr.getTeaName();
				  String subjectAfter2 = sr.getSubject();
				  
				  if(teaNameBefore2.equals(teaNameAfter2) && (!subjectBefore2.equals(subjectAfter2)) && !subjectBefore2.equals("0000") ){
					  TeacherSubCounter tsc = new TeacherSubCounter();
					  tsc.setTeaName(teaNameBefore2);
					  tsc.setNumber(teacherNumber2);
					  tsc.setSubject(subjectBefore2);
					  teacherNumber2 = 0;
					  tcSubList.add(tsc);
				  }
				  
				  if((teaNameBefore2 != "0000" && ! teaNameBefore2.equals(teaNameAfter2))){
					  TeacherSubCounter tsc = new TeacherSubCounter();
					  tsc.setTeaName(teaNameBefore2);
					  tsc.setNumber(teacherNumber2);
					  tsc.setSubject(subjectBefore2);
					  teacherNumber2 = 0;
					  tcSubList.add(tsc);
					}
				  
				  teacherNumber2 = teacherNumber2 + 1;
				  if(i == stuList.size()-1){
					  TeacherSubCounter tsc = new TeacherSubCounter();
					  tsc.setTeaName(teaNameBefore2);
					  tsc.setNumber(teacherNumber2);
					  tsc.setSubject(subjectBefore2);
					  teacherNumber2 = 0;
					  tcSubList.add(tsc);
				  }
				  subjectBefore2 = subjectAfter2;
				  teaNameBefore2 = teaNameAfter2;
	        }
			
			
   
		    
//			  Calendar   calendar   =   new   GregorianCalendar(); 
//			  calendar.setTime(todayEndDate); 
//			  calendar.add(calendar.DATE,1);//�������������һ��.���������,������ǰ�ƶ� 
//			  Date endDateAdapter=calendar.getTime();   //���ʱ��������������һ��Ľ�� 
			  manualRecordList = new ArrayList();
			  manualRecordList = smgr.getManualRecordByTime(todayStart, todayEnd);
			  
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "search";
	}
	
	
	public String selectManualRecord() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
			if(null == todayEndDate)todayEndDate = new Date(System.currentTimeMillis());
			
			String startDate = sdf.format(todayStartDate);
			String endDate = sdf.format(todayEndDate);
			
			manualRecordList = new ArrayList();
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			if(null == hrEmpl){
				manualRecordList = smgr.getManualRecordByDate(startDate, endDate);
			}else{
				if("".equals(hrEmpl.getEmplID()) && "".equals(hrEmpl.getEmplName())){
					manualRecordList = smgr.getManualRecordByDate(startDate, endDate);
				}else if((!"".equals(hrEmpl.getEmplID())) && "".equals(hrEmpl.getEmplName())){
					manualRecordList = smgr.getManualRecordByDate(startDate, endDate, hrEmpl.getEmplID());
				}else if("".equals(hrEmpl.getEmplID()) && (!"".equals(hrEmpl.getEmplName()))){
					manualRecordList = smgr.getManualRecordByDateName(startDate, endDate, hrEmpl.getEmplName());
				}else{
					manualRecordList = smgr.getManualRecordByDateIDName(startDate, endDate, hrEmpl.getEmplID(), hrEmpl.getEmplName());
				}
			}
			SimpleDateFormat sdw = new SimpleDateFormat("E");
			
			ManualRecord mr = new ManualRecord();
			for(int i = 0; i < manualRecordList.size(); i++){
				mr = manualRecordList.get(i);
				String lessonDateStr = mr.getLessonDate();
				Date lessonDate = sdf2.parse(lessonDateStr);
				String week = sdw.format(lessonDate);
				mr.setLessonDate(lessonDateStr+" "+week);
				mr.setRecordTimeFormat(sdf1.format(mr.getRecordTime()));
				Classroom cr = new Classroom();
				if(0 != mr.getRoomID()){
					cr = smgr.getRoomByID(mr.getRoomID());
					mr.setRoomNO(cr.getRoomno());
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "selectManualRecord";
	}
	
	public String dropCourseList() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(null == todayStartDate)todayStartDate = new Date(System.currentTimeMillis());
			if(null == todayEndDate)todayEndDate = new Date(System.currentTimeMillis());
			
			String startDate = sdf.format(todayStartDate);
			String endDate = sdf.format(todayEndDate);
			
			manualRecordList = new ArrayList();
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			if(null == hrEmpl){
				manualRecordList = smgr.getManualRecordByDate(startDate, endDate);
			}else{
				if("".equals(hrEmpl.getEmplID()) && "".equals(hrEmpl.getEmplName())){
					manualRecordList = smgr.getManualRecordByDate(startDate, endDate);
				}else if((!"".equals(hrEmpl.getEmplID())) && "".equals(hrEmpl.getEmplName())){
					manualRecordList = smgr.getManualRecordByDate(startDate, endDate, hrEmpl.getEmplID());
				}else if("".equals(hrEmpl.getEmplID()) && (!"".equals(hrEmpl.getEmplName()))){
					manualRecordList = smgr.getManualRecordByDateName(startDate, endDate, hrEmpl.getEmplName());
				}else{
					manualRecordList = smgr.getManualRecordByDateIDName(startDate, endDate, hrEmpl.getEmplID(), hrEmpl.getEmplName());
				}
			}
			SimpleDateFormat sdw = new SimpleDateFormat("E");
			
			ManualRecord mr = new ManualRecord();
			for(int i = 0; i < manualRecordList.size(); i++){
				mr = manualRecordList.get(i);
				String lessonDateStr = mr.getLessonDate();
				Date lessonDate = sdf2.parse(lessonDateStr);
				String week = sdw.format(lessonDate);
				mr.setLessonDate(lessonDateStr+" "+week);
				mr.setRecordTimeFormat(sdf1.format(mr.getRecordTime()));
				Classroom cr = new Classroom();
				if(0 != mr.getRoomID()){
					cr = smgr.getRoomByID(mr.getRoomID());
					mr.setRoomNO(cr.getRoomno());
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "dropCourseList";
	}
	
	public String dropCourse() throws Exception {
		try{
			ActionContext context=ActionContext.getContext(); 
			HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
			String mrID = request.getParameter("id");
			Integer id = Integer.valueOf(mrID);
			ManualRecord mr = new ManualRecord();
			mr = smgr.getManualRecord(id);
			String emplID = mr.getEmplID();
			HrEmployee he = new HrEmployee();
			he = smgr.getHrEmployeeByEmplID(emplID);
			if(he == null){
				addActionError("该学生资料已经被删除，数据不一致,请整理数据");
				this.dropCourseList();
				return "data_inconsistent";
			}
			he.setRemainLessonAmount(he.getRemainLessonAmount() + 1);
			smgr.saveEmployee(he);
			smgr.deleteMR(mr);
			this.dropCourseList();
			return "dropCourse";
		}catch(Exception e){
			e.printStackTrace();
			return "exception";
		}
	}
	 
	 public void ajaxCheck() {
		HttpServletResponse response = ServletActionContext.getResponse(); //ȡresponse����  
		HttpServletRequest request = ServletActionContext.getRequest();//ȡrequest����      
		//��������Ӧ		
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		String oldPassword = request.getParameter("oldPassword"); 
		String msgStr="";
		
		Map session = ActionContext.getContext().getSession(); //��ȡsession
		String password = (String) session
				.get("password"); //��ȡUser����
		if (!password.equals(oldPassword)) {
			msgStr="1";			
		}
		try {//responseд��Ϣ    
			response.getWriter().print(msgStr);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	 
	 /**
		 * �޸����붯��ִ����<br>
		 */
		public String modify() throws Exception {
			Map session = ActionContext.getContext().getSession(); //��ȡsession
			int userID = (Integer) session.get("userId");
			User user = mgr.getUserByID(userID); //��ȡUser����
			if (user.getPass().equals(oldPassword)) {
				user.setPass(password);
				mgr.updateUser(user);
				addActionMessage(getText("password.update.success"));
			} else {
				addActionError(getText("errors.password.invalid"));
			}
			return "modify";

		}

	public List<StudentRecord> getStuList() {
		return stuList;
	}

	public void setStuList(List<StudentRecord> stuList) {
		this.stuList = stuList;
	}

}
