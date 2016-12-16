package com.cxjava.action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Adjust;
import org.yeeku.model.Assistant;
import org.yeeku.model.DifferentPhase;
import org.yeeku.model.Exam;
import org.yeeku.model.Goods;
import org.yeeku.model.Student;
import org.yeeku.model.TClass;
import org.yeeku.model.User;

import com.bw30.zjvote.config.BaseDao;

public class ExamManagerDao extends BaseAction{
	
	public List<Exam> find_exam_list(String tclassid,String sortname,String sortorder,int from, int size) {
		List<Exam> examList=new ArrayList<Exam>();
		DifferentPhase phase=new DifferentPhase();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Connection baseConn=BaseDao.getConnection();
		 PreparedStatement pre = null;
		 ResultSet rs = null;
		 String sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
			" where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and e.classkey  in (" +tclassid+ ") order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + "";
		 try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("id");
                String title = rs.getString("title");
                Date edate=rs.getDate("edate");
                String classname = rs.getString("classname");
                String classroom = rs.getString("classroom");
                Integer phaseid = rs.getInt("phaseid");
                String subjectname = rs.getString("subjectname");
                String fromtime = rs.getString("fromtime");
                Integer examtype = rs.getInt("examtype");
                Integer scoretype = rs.getInt("scoretype");
                Integer displaystatus = rs.getInt("displaystatus");
                Exam exam = new Exam();                                                      
                exam.setId(id);                           
                exam.setTitle(title);
                exam.setTime(sdf.format(edate));
                exam.setPhaseid(phaseid);
                exam.setClassname(classname);
                exam.setClassroom(classroom);
                exam.setSubjectname(subjectname);
                exam.setFromtime(fromtime);
                if(phaseid==0){
             	   exam.setPhasename("无");
                }else if(phaseid==1){
             	   exam.setPhasename("Assessment1");
                }else if(phaseid==2){
                	exam.setPhasename("Assessment2");
                }else if(phaseid==3){
                	exam.setPhasename("Assessment3");
                }else if(phaseid==4){
                	exam.setPhasename("Assessment4");
                }else{
                	exam.setPhasename("Assessment5");
                }
                if(scoretype==1){//百分制   				
      				String examTypeName=phase.getExamType(examtype);
      				exam.setScoreTypeName("百分制");
      				exam.setExamTypeName(examTypeName);              				
      				}
                if(scoretype==2){//非百分制   				
       				String examTypeName=phase.getExamType(examtype);
       				exam.setScoreTypeName("非百分制");
       				exam.setExamTypeName(examTypeName);              				
       				}
                if(scoretype==3){//记分单元 				
      				String examTypeName=phase.getExamType(examtype);
      				exam.setScoreTypeName("记分单元 ");
      				exam.setExamTypeName(examTypeName);              				
      				}
                	exam.setDisplaystatus(displaystatus);
                	/*Calendar calendar = Calendar.getInstance();
        			calendar.setTime(edate);
        			calendar.add(Calendar.DAY_OF_YEAR, 183);
        			Date historydate = calendar.getTime();
        			int result=historydate.compareTo(new Date());
        			if(result>0){                   				
        				examList.add(exam);
        			}*/
        			examList.add(exam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pre)
					pre.close();
				if (null != rs)
					rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return examList;
	 }
	
	public int find_exam_count(String tclassid) {
			 List<Exam> list=new ArrayList<Exam>();
			 Connection baseConn=BaseDao.getConnection();
			 PreparedStatement pre = null;
			 int count = 0;
			 ResultSet rs; 
			 String sql = "SELECT e.*, t.name as teachername, s.name as subjectname, tt.tname as classname  FROM exam e, teacher t, subject s , tclass tt " +
				" where e.subjectid = s.id and e.classkey = tt.id and e.teacherid = t.tid and e.classkey  in (" +tclassid+ ")";

			 try {
				 pre = baseConn.prepareStatement(sql);
				 rs = pre.executeQuery();
				 rs.last();
				 count=rs.getRow();
			 
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			} finally {
				
				try {
					if (null != pre)
						pre.close();
				} catch (SQLException e) {
	
					e.printStackTrace();
				}
			}
			return count;
	 }
	}

