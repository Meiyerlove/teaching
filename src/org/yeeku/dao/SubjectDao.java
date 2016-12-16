package org.yeeku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.yeeku.model.Subject;

import com.bw30.zjvote.config.BaseDao;

public class SubjectDao {
		public List<Subject> findSubject(String column_name,String desc,int from, int size) {
			List<Subject> list=new ArrayList<Subject>();
			Connection baseConn=BaseDao.getConnection();
			String sql = "select * from subject order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
			PreparedStatement pre = null;
			ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sql);
				rs = pre.executeQuery();
				Subject subject;
				while (rs.next()) {
					subject=new Subject();
					subject.setId(rs.getInt("id"));
					subject.setName(rs.getString("name"));
					subject.setSubid(rs.getString("subid"));
					list.add(subject);
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
		
		public int findSubjectCount() {
			List<Subject> list=new ArrayList<Subject>();
			Connection baseConn=BaseDao.getConnection();
			StringBuffer sb=new StringBuffer("select * from subject ");
			PreparedStatement pre = null;
			ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sb.toString());
				rs = pre.executeQuery();
				Subject subject=new Subject();
				while (rs.next()) {
					subject=new Subject();
					subject.setId(rs.getInt("id"));
					subject.setName(rs.getString("name"));
					subject.setSubid(rs.getString("subid"));
					list.add(subject);
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
		public int findSubjectQueryCount(String query, String qtype) {
			List<Subject> list=new ArrayList<Subject>();
			Connection baseConn=BaseDao.getConnection();
			StringBuffer sb=new StringBuffer("select * from  subject where ");
			if(qtype.equals("name")){
				sb.append(" name like '%"+query+"%'");
			}
			if(qtype.equals("subid")){
				sb.append(" subid like '%"+query+"%'");
			}
			PreparedStatement pre = null;
			ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sb.toString());
				rs = pre.executeQuery();
				Subject subject;
				while (rs.next()) {
					subject=new Subject();
					subject.setId(rs.getInt("id"));
					subject.setName(rs.getString("name"));
					subject.setSubid(rs.getString("subid"));
					list.add(subject);
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
		public List<Subject> findSubjectQueryCountList(String query,String qtype,String column_name,String desc,int from, int size) {
			 List<Subject> list=new ArrayList<Subject>();
			 Connection baseConn=BaseDao.getConnection();
			 StringBuffer sb=new StringBuffer("select * from subject where");
			 if(qtype.equals("name")){
				    sb.append(" name like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			 }
			 if(qtype.equals("subid")){
					sb.append(" subid like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
				}
			 PreparedStatement pre = null;
			 ResultSet rs = null;
				try {
					pre = baseConn.prepareStatement(sb.toString());
					rs = pre.executeQuery();
					Subject subject;
					while (rs.next()) {
						subject=new Subject();
						subject.setId(rs.getInt("id"));
						subject.setName(rs.getString("name"));
						subject.setSubid(rs.getString("subid"));
						list.add(subject);
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
		
		public static void main(String[] args) {
			AssistantDao teacher=new AssistantDao();
			teacher.getClassnameNameList("李文娟");
		}
		
}
