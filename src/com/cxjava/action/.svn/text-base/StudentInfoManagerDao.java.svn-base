package com.cxjava.action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yeeku.model.Assistant;
import org.yeeku.model.Student;
import org.yeeku.model.StudentAssistantVo;

import com.bw30.zjvote.config.BaseDao;

public class StudentInfoManagerDao {
	public List<StudentAssistantVo> findStudentInfoByUsertype(String roleid,String userName,String sortname,String sortorder,int from, int size) {
		List<StudentAssistantVo> list=new ArrayList<StudentAssistantVo>();
		 Connection baseConn=BaseDao.getConnection();
		 PreparedStatement pre = null;
		 ResultSet rs = null;
		 String sql="";
		 if(roleid.equals("6")){
			 sql = "select s.*,a.office_phone,a.cellphone as telephone from student s,assistant a where s.assistant=a.name and s.assistant = '"+userName+"' and  s.dividestatus <>1 and s.status=1 order by  "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " ";
		 }else{
			// sql = "select * from student where  dividestatus <>1 and status=1 order by  "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "; 
			 sql = "select s.*,a.office_phone,a.cellphone as telephone from student s,assistant a where s.assistant=a.name and s.dividestatus <>1 order by  "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "; 
		 }
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				StudentAssistantVo student=new StudentAssistantVo();
				student.setId(rs.getInt("id"));
				student.setSid(rs.getString("sid"));
				student.setName(rs.getString("name"));
				if(rs.getInt("sex")==1){
					student.setTempsex("男");
				}else{
					student.setTempsex("女");
				}
				student.setClassname(rs.getString("classname"));
				student.setMajorname(rs.getString("majorname"));
				student.setProgram(rs.getString("program"));
				student.setCellphone(rs.getString("cellphone"));
				student.setAssistant(rs.getString("assistant"));
				student.setOffice_phone(rs.getString("office_phone"));
				student.setA_cellphone(rs.getString("telephone"));
				if(rs.getString("status").equals("1")){
					student.setStatus("在校");
				}else{
					student.setStatus("离校");
				}
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pre){
					pre.close();	
				  }
				if (null != rs){
					rs.close();	
				 }
				if (null != baseConn){
					baseConn.close();	
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;
	 }
	
	@SuppressWarnings("unused")
	public int findStudentInfoByUsertypeCount(String roleid,String userName) {
		List<Student> list=new ArrayList<Student>();
		 Connection baseConn=BaseDao.getConnection();
		 PreparedStatement pre = null;
		 int count = 0;
		 ResultSet rs=null; 
		 String sql="";
		 if(roleid.equals("6")){
			 sql = "select s.*,a.office_phone  from student s,assistant a where s.assistant=a.name and s.assistant='"+userName+"' and s.dividestatus <>1 and s.status=1";
		 }else{
			// sql = "select * from student where  dividestatus <>1 and status=1 "; 
			 sql = "select s.*,a.office_phone  from student s,assistant a where s.assistant=a.name and  s.dividestatus <>1"; 
		 }
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			rs.last();
			count=rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pre){
					pre.close();	
				  }
				if (null != rs){
					rs.close();	
				 }
				if (null != baseConn){
					baseConn.close();	
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return count;
	 }

	public List<StudentAssistantVo> findStudentInfoByCondition(String roleid,String userName,String qtype, String query,String sortname,String sortorder,int from, int size) {
		List<StudentAssistantVo> list=new ArrayList<StudentAssistantVo>();
		 Connection baseConn=BaseDao.getConnection();
		 PreparedStatement pre = null;
		 ResultSet rs = null;
		 StringBuffer sb=new StringBuffer("select s.*,a.office_phone,a.cellphone as telephone  from student s,assistant a where s.assistant=a.name ");
		try {
			if(roleid.equals("6")){
				sb.append(" s.assistant='"+userName+"' ");
				if(qtype.equals("sid")){
					sb.append(" and s.sid like '%"+query+"%' and s.dividestatus <>1 and s.status=1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " " );
				}else if(qtype.equals("name")){
					sb.append(" and s.name like '%"+query+"%' and s.dividestatus <>1  and s.status=1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 		 
				}else if(qtype.equals("tempsex")){
					sb.append(" and s.sex like '%"+query+"%' and s.dividestatus <>1  and s.status=1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 	 
				}else if(qtype.equals("classname")){
					sb.append(" and s.classname like '%"+query+"%' and s.dividestatus <>1 and s.status=1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 		
				}else if(qtype.equals("majorname")) {
					sb.append(" and s.majorname like '%"+query+"%' and s.dividestatus <>1 and s.status=1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 
				}else if(qtype.equals("program")) {
					sb.append(" and s.program like '%"+query+"%' and s.dividestatus <>1 and s.status=1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 
				}else if(qtype.equals("cellphone")) {
					sb.append(" and s.cellphone like '%"+query+"%' and s.dividestatus <>1 and s.status=1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 
				}else if(qtype.equals("status")) {
					sb.append(" and s.status like '%"+query+"%' and s.dividestatus <>1 and s.status=1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 
				}else{
					sb.append("");
				}
			}else{
				if(qtype.equals("sid")){
					sb.append(" and s.sid like '%"+query+"%' and s.dividestatus <>1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " " );
				}else if(qtype.equals("name")){
					sb.append(" and s.name like '%"+query+"%' and s.dividestatus <>1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 		 
				}else if(qtype.equals("tempsex")){
					sb.append(" and s.sex like '%"+query+"%' and s.dividestatus <>1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 	 
				}else if(qtype.equals("classname")){
					sb.append(" and s.classname like '%"+query+"%' and s.dividestatus <>1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 		
				}else if(qtype.equals("majorname")) {
					sb.append(" and s.majorname like '%"+query+"%' and s.dividestatus <>1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 
				}else if(qtype.equals("program")) {
					sb.append(" and s.program like '%"+query+"%' and s.dividestatus <>1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 
				}else if(qtype.equals("cellphone")) {
					sb.append(" and s.cellphone like '%"+query+"%' and s.dividestatus <>1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 
				}else if(qtype.equals("status")) {
					sb.append(" and s.status like '%"+query+"%' and s.dividestatus <>1 order by "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " "); 
				}else{
					sb.append("");
				}
				
			}
			System.out.println("SQL:"+sb.toString());
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			while (rs.next()) {
				StudentAssistantVo student=new StudentAssistantVo();
				student.setId(rs.getInt("id"));
				student.setSid(rs.getString("sid"));
				student.setName(rs.getString("name"));
				if(rs.getInt("sex")==1){
					student.setTempsex("男");
				}else{
					student.setTempsex("女");
				}
			    student.setClassname(rs.getString("classname"));
				student.setMajorname(rs.getString("majorname"));
				student.setProgram(rs.getString("program"));
				student.setCellphone(rs.getString("cellphone"));
				student.setAssistant(rs.getString("assistant"));
				student.setOffice_phone(rs.getString("office_phone"));
				student.setA_cellphone(rs.getString("telephone"));
				if(rs.getString("status").equals("1")){
					student.setStatus("在校");
				}else{
					student.setStatus("离校");
				}
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pre){
					pre.close();	
				  }
				if (null != rs){
					rs.close();	
				 }
				if (null != baseConn){
					baseConn.close();	
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return list;
	 }
	
	public int findStudentInfoByConditionCount(String roleid,String userName,String qtype, String query) {
		@SuppressWarnings("unused")
		List<Student> list=new ArrayList<Student>();
		 Connection baseConn=BaseDao.getConnection();
		 PreparedStatement pre = null;
		 int count = 0;
		 ResultSet rs=null; 
		 StringBuffer sb=new StringBuffer("select s.*  from student s,assistant a where s.assistant=a.name ");
		try {
			if(roleid.equals("6")){
				sb.append("  and s.assistant='"+userName+"' and s.dividestatus <>1 and s.status=1 ");
				if(qtype.equals("s.sid")){
					sb.append("  and  s.sid like '%"+query+"%'" );
				}else if(qtype.equals("s.name")){
					sb.append("  and  s.name like '%"+query+"%'"); 		 
				}else if(qtype.equals("s.tempsex")){
					sb.append("  and  s.sex like '%"+query+"%'"); 	 
				}else if(qtype.equals("s.classname")){
					sb.append("  and  s.classname like '%"+query+"%'"); 		
				}else if(qtype.equals("s.majorname")) {
					sb.append("  and  s.majorname like '%"+query+"%'"); 
				}else if(qtype.equals("s.program")) {
					sb.append("  and  s.program like '%"+query+"%'"); 
				}else if(qtype.equals("s.cellphone")) {
					sb.append("  and  s.cellphone like'%"+query+"%'"); 
				}else if(qtype.equals("s.status")) {
					sb.append("  and  s.status like'%"+query+"%'"); 
				}
			}else{
				if(qtype.equals("s.sid")){
					sb.append("  and  s.sid like '%"+query+"%' and s.dividestatus <>1" );
				}else if(qtype.equals("s.name")){
					sb.append("  and  s.name like '%"+query+"%'and s.dividestatus <>1"); 		 
				}else if(qtype.equals("s.tempsex")){
					sb.append("  and  s.sex like '%"+query+"%'and s.dividestatus <>1"); 	 
				}else if(qtype.equals("s.classname")){
					sb.append("  and  s.classname like '%"+query+"%'and s.dividestatus <>1"); 		
				}else if(qtype.equals("s.majorname")) {
					sb.append("  and  s.majorname like '%"+query+"%'and s.dividestatus <>1"); 
				}else if(qtype.equals("s.program")) {
					sb.append("  and  s.program like '%"+query+"%'and s.dividestatus <>1"); 
				}else if(qtype.equals("s.cellphone")) {
					sb.append("  and  s.cellphone like '%"+query+"%'and s.dividestatus <>1"); 
				}else if(qtype.equals("s.status")) {
					sb.append("  and s.status like '%"+query+"%'and s.dividestatus <>1"); 
				}
			}
			System.out.println(sb.toString());
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			rs.last();
			count=rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != pre){
					pre.close();	
				  }
				if (null != rs){
					rs.close();	
				 }
				if (null != baseConn){
					baseConn.close();	
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return count;
	 }
	}

