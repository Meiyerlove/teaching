package org.yeeku.action;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Absence;
import org.yeeku.model.Assistant;
import org.yeeku.model.Ielts;
import org.yeeku.model.Student;
import org.yeeku.model.Subject;
import org.yeeku.model.TClass;
import org.yeeku.model.User;
import org.yeeku.util.ExcelUtil2007;
import org.yeeku.util.ExportExcel;

import com.alibaba.fastjson.JSONArray;

public class CommonAction extends BaseAction{
	
	public String findIeltsInfoById(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {			
			String ieltsid=request.getParameter("ieltsid");
			Ielts ielts=(Ielts) this.combiz.get(Ielts.class, Integer.parseInt(ieltsid));
			Student stu = (Student) mgr.getStudentList(ielts.getSid()).get(0);
			TClass tclass=(TClass) this.combiz.get(TClass.class, ielts.getClassid());
			ielts.setSname(stu.getName());
			ielts.setTclass(tclass.getName());
			PrintWriter out=response.getWriter();
			out.write(JSONArray.toJSONString(ielts));
			System.out.println(JSONArray.toJSONString(ielts));
			out.flush();
			out.close();
			  
		}  catch (Exception e) {
			e.printStackTrace();
		}
	return SUCCESS;
	}
	
	public String saveStudentItelsInfo(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user = (User) request.getSession().getAttribute("tuser");
		try {			
			Assistant assistant = mgr.getAssistantByName(user.getUser());
			List<TClass> classList = mgr.getClassListByAssistantid(assistant.getId());
			String ieltsid=request.getParameter("ielts");
			String slistening=request.getParameter("slistening");
			String ssay=request.getParameter("ssay");
			String sread=request.getParameter("sread");
			String swrite=request.getParameter("swrite");
			String sscore=request.getParameter("sscore");
			Ielts ielts=(Ielts) this.combiz.get(Ielts.class, Integer.parseInt(ieltsid));
			ielts.setListening(slistening);
			ielts.setSpeaking(ssay);
			ielts.setReading(sread);
			ielts.setWriting(swrite);
			ielts.setTotal(sscore);
			this.combiz.update(ielts);
			session.setAttribute("message", "修改成功");
		}  catch (Exception e) {
			session.setAttribute("message", "修改失败"); 
			e.printStackTrace();
		}
	return "saveStudentItelsInfo";
	}
	
	
	
	
	/*
	 * 导出未审核Ielts信息excel
	 */
	
	public String exportExcel() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
//		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		User user = (User) request.getSession().getAttribute("tuser");
		try {
			Assistant assistant = mgr.getAssistantByName(user.getUser());
			List<TClass> classList = mgr.getClassListByAssistantid(assistant.getId());//通过辅导员id找班级，一对多			
			List<Ielts> allStudentItlesInfoList=new ArrayList<Ielts>();
    		List<Ielts> ieltsList = new ArrayList<Ielts>();
			classList = mgr.getClassListByAssistantid(assistant.getId());
			if(null != classList && classList.size() > 0){
				String classid = "";
				for(int  i = 0 ; i < classList.size(); i++){
					TClass cal = (TClass) classList.get(i);
					classid = classid + cal.getId() + ",";
				}
				classid = classid.substring(0, classid.length() - 1);
				ieltsList = mgr.getIeltsListInClassid(classid);
			}

    		if(null != ieltsList && ieltsList.size() >0){
    			for(int i = 0; i < ieltsList.size(); i++){
    				Ielts ielts = (Ielts) ieltsList.get(i);
    				if(ielts.getStatus()==1){    					
    					List<Student> stu =mgr.getStudentList(ielts.getSid());
    					if(null!=stu&&stu.size()>0){
    						ielts.setStudent(stu.get(0));
    						TClass tclass=(TClass) this.combiz.get(TClass.class, ielts.getClassid());
    						ielts.setTclass(tclass.getName());
    						allStudentItlesInfoList.add(ielts);
    					}
    				}
    			}
    			
    		}
			
			if(allStudentItlesInfoList.size()==0){
				System.out.println("无未审核数据");
				out.print("{bol:false,message:'"+URLEncoder.encode("无未审核数据","UTF-8")+"'}");
			}else{				
				String message=new ExcelUtil2007().buildXSLXExcel(allStudentItlesInfoList);
				if(message.equals("false")){				
					out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
				}else{
					System.out.println(message);
					out.print("{bol:true,message:'"+URLEncoder.encode(message,"UTF-8")+"'}");
				}
			}	
			
			out.flush();
			out.close();
			
		} catch (Exception e) {
			out.print("{bol:false,message:'导出失败'}");
			e.printStackTrace();
		}
		//return "exportExcel";
		return null;
	}	
	
	
	/*
	 * 导出考勤信息
	 */
	
	public String exportAbsenceExcel() throws IOException{
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			User user=(User) request.getSession().getAttribute("tuser");
			PrintWriter out=response.getWriter();
	//		response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			try {
				String varparam=request.getParameter("varparam");	
				String sid=request.getParameter("sid");
				String classid=request.getParameter("classid");
				String[] cellTitle = { "学号" , "姓名" , "班级" , "课程" , "考勤类别", "考勤时间"};
				List<Absence> absenceList=null;
				List<Absence> absenceListNew=new ArrayList<Absence>();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String message="";
				String name="";
				/*导出班级考勤记录*/
				if(varparam.equals("class")){
					absenceList=mgr.getAbsenceListByClassid(Integer.parseInt(classid));						
					TClass tclass=(TClass) this.combiz.get(TClass.class, Integer.parseInt(classid));
					name=tclass.getName();
				}
				/*导出学生考勤记录*/
				else{
					absenceList=mgr.getAbsenceListBySid(sid);
					Student student=mgr.getStudentBySid(sid);
					name=student.getName();
				}
				
				if(null!=absenceList&&absenceList.size()>0){
					for (Absence absence : absenceList) {
						if(user.getUserType()==6){
						    TClass tclass=(TClass) this.combiz.get(TClass.class, absence.getClassid());
						    absence.setClassname(tclass.getName());
							absenceListNew.add(absence);		
						}else{
							  TClass tclass=(TClass) this.combiz.get(TClass.class, absence.getClassid());
							   absence.setClassname(tclass.getName());
							if(absence.getType()!=3){
							absenceListNew.add(absence);						
						  }
						}
					}
					if(null!=absenceListNew&&absenceListNew.size()>0){						
						for (Absence absence : absenceListNew) {						
							Subject subject = (Subject) this.combiz.get(Subject.class, absence.getSubjectid());
							Student student=mgr.getStudentBySid(absence.getSid());
							absence.setStudent(student);
							absence.setSubjectname(subject.getName());  
							absence.setTempdate(sdf.format(absence.getAbsencedate()));
						}
						message=new ExcelUtil2007().exportAbsenceExcel(cellTitle,absenceListNew,name);
						if(message.equals("false")){							
							out.print("{bol:false,message:'"+URLEncoder.encode("导出失败","UTF-8")+"'}");
						}
						else{
							out.print("{bol:true,message:'"+URLEncoder.encode(message,"UTF-8")+"'}");
						}
					}
					else{
						out.print("{bol:false,message:'"+URLEncoder.encode("无考勤记录","UTF-8")+"'}");
					}					
					
				}else{
					out.print("{bol:false,message:'"+URLEncoder.encode("无考勤记录","UTF-8")+"'}");
				}	
				out.flush();
				out.close();
			
		} catch (Exception e) {
			out.print("{bol:false,message:'导出失败'}");
			e.printStackTrace();
		}
		//return "exportExcel";
		return "success";
	}
	
}  























