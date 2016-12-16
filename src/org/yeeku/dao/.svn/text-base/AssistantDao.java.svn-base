package org.yeeku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yeeku.model.Assistant;
import org.yeeku.model.Teacher;

import com.bw30.zjvote.config.BaseDao;

public class AssistantDao {
	public List<Assistant> findAssistant(String column_name,String desc,int from, int size) {
		List<Assistant> list=new ArrayList<Assistant>();
		Connection baseConn=BaseDao.getConnection();
		if(null != column_name && column_name.equals("s_status")){
			column_name = "status";
		}
		String sql = "select * from assistant order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Assistant assistant;
			while (rs.next()) {
				assistant=new Assistant();
				assistant.setId(rs.getInt("id"));
				assistant.setAid(rs.getString("aid"));
				assistant.setName(rs.getString("name"));
				assistant.setCellphone(rs.getString("cellphone"));
				assistant.setOph(rs.getString("office_phone"));
				assistant.setEmail(rs.getString("email"));
				Integer status=rs.getInt("status");
				if(status.equals(1)){
					assistant.setS_status("在职");
				}
				if(status.equals(2)){
					assistant.setS_status("离职");
				}
				Integer sex=rs.getInt("sex");
				if(sex.equals(1)){
					assistant.setTempsex("男");
				}
				if(sex.equals(2)){
					assistant.setTempsex("女");
				}
				List classnameList=this.getClassnameNameList(rs.getString("name"));
				String totalclassname="";
				if(classnameList!=null && classnameList.size()>0){
					for(int j=0;j<classnameList.size();j++){
						Object object=(Object)classnameList.get(j);
						String classname=(String) object;
						totalclassname+=classname+"丶";
					}
					totalclassname=totalclassname.substring(0, totalclassname.length()-1);
				}
				assistant.setClassname(totalclassname);
				list.add(assistant);
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
	public List getClassnameNameList(String assistantname){
		List list=new ArrayList();
		Connection baseConn=BaseDao.getConnection();
		String sql="select distinct kc.classname from kecheng kc,kechengversion kcv  where  kc.v_id=kcv.id and kcv.isvalid=1 and kc.teacher =?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			pre.setString(1, assistantname);
			rs = pre.executeQuery();
			while (rs.next()) {
				String subjectname=rs.getString("classname");
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
	
	
	public int findAssistantCount() {
		List<Assistant> list=new ArrayList<Assistant>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from assistant ");
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			Assistant assistant=new Assistant();
			while (rs.next()) {
				assistant.setId(rs.getInt("id"));
				assistant.setAid(rs.getString("aid"));
				assistant.setName(rs.getString("name"));
				assistant.setCellphone(rs.getString("cellphone"));
				assistant.setEmail(rs.getString("email"));
				Integer sex=rs.getInt("sex");
				if(sex.equals(1)){
					assistant.setTempsex("男");
				}
				if(sex.equals(2)){
					assistant.setTempsex("女");
				}
				list.add(assistant);
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
	public int findAssistantQueryCount(String query, String qtype) {
		List<Assistant> list=new ArrayList<Assistant>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from  assistant where ");
		if(qtype.equals("aid")){
			sb.append(" aid like '%"+query+"%'");
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
			Assistant assistant;
			while (rs.next()) {
				assistant=new Assistant();
				assistant.setId(rs.getInt("id"));
				assistant.setAid(rs.getString("aid"));
				assistant.setName(rs.getString("name"));
				assistant.setSex(rs.getInt("sex"));
				assistant.setCellphone(rs.getString("cellphone"));
				assistant.setEmail(rs.getString("email"));
				list.add(assistant);
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
	public List<Assistant> findAssistantQueryCountList(String query,String qtype,String column_name,String desc,int from, int size) {
		List<Assistant> assistantlist=new ArrayList<Assistant>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=new StringBuffer("select * from assistant where");
		 if(qtype.equals("aid")){
			    sb.append(" aid like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
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
			if(qtype.equals("oph")){
				sb.append(" office_phone like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
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
				Assistant assistant;
				while (rs.next()) {
					assistant=new Assistant();
					assistant.setId(rs.getInt("id"));
					assistant.setAid(rs.getString("aid"));
					assistant.setName(rs.getString("name"));
					assistant.setCellphone(rs.getString("cellphone"));
					assistant.setOph(rs.getString("office_phone"));
					assistant.setEmail(rs.getString("email"));
					List classnameList=this.getClassnameNameList(rs.getString("name"));
					String totalclassname="";
					if(classnameList!=null && classnameList.size()>0){
						for(int j=0;j<classnameList.size();j++){
							Object object=(Object)classnameList.get(j);
							String classname=(String) object;
							totalclassname+=classname+"丶";
						}
						totalclassname=totalclassname.substring(0, totalclassname.length()-1);
					}
					assistant.setClassname(totalclassname);
					Integer status=rs.getInt("status");
					if(status.equals(1)){
						assistant.setS_status("在职");
					}
					if(status.equals(2)){
						assistant.setS_status("离职");
					}
					Integer sex=rs.getInt("sex");
					if(sex.equals(1)){
						assistant.setTempsex("男");
					}
					if(sex.equals(2)){
						assistant.setTempsex("女");
					}
					assistant.setClassname(totalclassname);
					assistantlist.add(assistant);
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
		 return assistantlist;
	}
	
	public static void main(String[] args) {
		AssistantDao teacher=new AssistantDao();
		teacher.getClassnameNameList("李文娟");
	}
	
}













