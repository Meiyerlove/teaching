package org.yeeku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yeeku.model.Adjust;
import org.yeeku.model.Notice;
import org.yeeku.model.Teacher;

import com.bw30.zjvote.config.BaseDao;

public class TeacherDao {
	public List<Teacher> findTeacher(String column_name,String desc,int from, int size) {
		List<Teacher> list=new ArrayList<Teacher>();
		Connection baseConn=BaseDao.getConnection();
		String sql = "select * from teacher order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Teacher teacher;
			while (rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setTid(rs.getString("tid"));
				teacher.setName(rs.getString("name"));
				teacher.setCellphone(rs.getString("cellphone"));
				teacher.setEmail(rs.getString("email"));
				
				Integer status=rs.getInt("status");
				if(status.equals(1)){
				  teacher.setS_status("在职");
				}
				if(status.equals(2)){
				  teacher.setS_status("离职");
				}
				Integer sex=rs.getInt("sex");
				if(sex.equals(1)){
					teacher.setTempsex("男");
				}
				if(sex.equals(2)){
					teacher.setTempsex("女");
				}
				List subjectnamelist=this.getSubjectNameList(rs.getString("name"));
				String totalSubjectname="";
				if(subjectnamelist!=null && subjectnamelist.size()>0){
					for(int i=0;i<subjectnamelist.size();i++){
						 Object object = (Object) subjectnamelist.get(i);
						 String subname=(String) object;
						 totalSubjectname+=subname+"、";
					}
					totalSubjectname=totalSubjectname.substring(0, totalSubjectname.length()-1);
				}
				//System.out.println(totalSubjectname);
				teacher.setSubjectname(totalSubjectname);
				list.add(teacher);
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
	public List getSubjectNameList(String teachername){
		List list=new ArrayList();
		Connection baseConn=BaseDao.getConnection();
		String sql="select distinct kc.subjectname from kecheng kc,kechengversion kcv  where  kc.v_id=kcv.id and kcv.isvalid=1 and kc.teacher =?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			pre.setString(1, teachername);
			rs = pre.executeQuery();
			while (rs.next()) {
				String subjectname=rs.getString("subjectname");
				list.add(subjectname);
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
	
	
	public int findTeacherCount() {
		List<Teacher> list=new ArrayList<Teacher>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from teacher ");
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			Teacher teacher=new Teacher();
			while (rs.next()) {
				teacher.setId(rs.getInt("id"));
				teacher.setTid(rs.getString("tid"));
				teacher.setName(rs.getString("name"));
				teacher.setCellphone(rs.getString("cellphone"));
				teacher.setEmail(rs.getString("email"));
				Integer status=rs.getInt("status");
				if(status.equals(1)){
				  teacher.setS_status("在职");
				}
				if(status.equals(2)){
				  teacher.setS_status("离职");
				}
				Integer sex=rs.getInt("sex");
				if(sex.equals(1)){
					teacher.setTempsex("男");
				}
				if(sex.equals(2)){
					teacher.setTempsex("女");
				}
				list.add(teacher);
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
		return list.size();
	}
	public int findTeacherQueryCount(String query, String qtype) {
		List<Teacher> list=new ArrayList<Teacher>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from  teacher where ");
		if(qtype.equals("tid")){
			sb.append(" tid like '%"+query+"%'");
		}
		if(qtype.equals("name")){
			sb.append(" name like '%"+query+"%'");
		}
		if(qtype.equals("sex")){
			sb.append(" sex like '%"+query+"%'"); 
		}
		if(qtype.equals("cellphone")){
			sb.append(" cellphone like '%"+query+"%'");
		}
		if(qtype.equals("email")){
			sb.append(" email like '%"+query+"%'");
		}
		if(qtype.equals("s_status")){
			sb.append(" status like '%"+query+"%'");
		}
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			Teacher teacher;
			while (rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setTid(rs.getString("tid"));
				teacher.setName(rs.getString("name"));
				teacher.setSex(rs.getInt("sex"));
				teacher.setCellphone(rs.getString("cellphone"));
				teacher.setEmail(rs.getString("email"));
				list.add(teacher);
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
		//System.out.println("size----"+list.size());
		return list.size();
	}
	public List<Teacher> findTeacherQueryCountList(String query,String qtype,String column_name,String desc,int from, int size) {
		 List<Teacher> teacherlist=new ArrayList<Teacher>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=new StringBuffer("select * from teacher where");
		 if(qtype.equals("tid")){
			    sb.append(" tid like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
		 }
		 if(qtype.equals("name")){
				sb.append(" name like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("sex")){
				sb.append(" sex like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("cellphone")){
				sb.append(" cellphone like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("email")){
				sb.append(" email like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("s_status")){
				sb.append(" status like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sb.toString());
				rs = pre.executeQuery();
				Teacher teacher;
				while (rs.next()) {
					teacher=new Teacher();
					teacher=new Teacher();
					teacher.setId(rs.getInt("id"));
					teacher.setTid(rs.getString("tid"));
					teacher.setName(rs.getString("name"));
					teacher.setCellphone(rs.getString("cellphone"));
					teacher.setEmail(rs.getString("email"));
					List subjectnamelist=this.getSubjectNameList(rs.getString("name"));
					String totalSubjectname="";
					if(subjectnamelist!=null && subjectnamelist.size()>0){
						for(int i=0;i<subjectnamelist.size();i++){
							 Object object = (Object) subjectnamelist.get(i);
							 String subname=(String) object;
							 totalSubjectname+=subname+"、";
						}
						totalSubjectname=totalSubjectname.substring(0, totalSubjectname.length()-1);
					}
					Integer status=rs.getInt("status");
					if(status.equals(1)){
					  teacher.setS_status("在职");
					}
					if(status.equals(2)){
					  teacher.setS_status("离职");
					}
					Integer sex=rs.getInt("sex");
					if(sex.equals(1)){
						teacher.setTempsex("男");
					}
					if(sex.equals(2)){
						teacher.setTempsex("女");
					}
					teacher.setSubjectname(totalSubjectname);
					teacherlist.add(teacher);
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
		 return teacherlist;
	}
	
	public static void main(String[] args) {
		TeacherDao teacher=new TeacherDao();
		teacher.getSubjectNameList("肖素文");
	}
	
}
