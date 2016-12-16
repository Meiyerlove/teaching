package com.cxjava.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yeeku.model.Notice;

import com.bw30.zjvote.config.BaseDao;

public class AssistantNoticeDao {
	public List<Notice> findAllNotice(String username,String column_name,String desc,int from, int size) {
		List<Notice> list=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 String sql = "select * from notice where username='"+username+"' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sql);
				rs = pre.executeQuery();
				Notice notice;
				while (rs.next()) {
					notice=new Notice();
					notice.setId(rs.getInt("id"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("1")){
						notice.setNoticetype("教务通知");
					}
					notice.setUsername(rs.getString("username"));
    				list.add(notice);
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
	public int findNoticeCount(String username) {
		List<Notice> list=new ArrayList<Notice>();
		Connection baseConn=BaseDao.getConnection();
		String sql="select * from  notice where username='"+username+"'";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Notice notice;
			while (rs.next()) {
				notice=new Notice();
				notice.setId(rs.getInt("id"));
				notice.setPublishdate(rs.getString("publishdate"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setNoticetype(rs.getString("noticetype"));
				notice.setUsername(rs.getString("username"));
				list.add(notice);
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
		System.out.println("size----"+list.size());
		return list.size();
	}
	public List<Notice> findNotice(String username,String query,String qtype,String column_name,String desc,int from, int size) {
		List<Notice> noticelist=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=new StringBuffer("select * from notice where username='"+username+"'");
		// String sql = "select * from notice where username='"+username+"' and publishdate='"+publishdate+"' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		 if(qtype.equals("publishdate")){
				sb.append(" and publishdate='"+query+"' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("title")){
				sb.append(" and title like '"+query+"%' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("content")){
				sb.append(" and content like '"+query+"%' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sb.toString());
				rs = pre.executeQuery();
				Notice notice;
				while (rs.next()) {
					notice=new Notice();
					notice.setId(rs.getInt("id"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("1")){
						notice.setNoticetype("教务通知");
					}
					notice.setUsername(rs.getString("username"));
					noticelist.add(notice);
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
		 return noticelist;
	}
	
	public int findnoticeCount(String username,String query,String qtype) {
		List<Notice> list=new ArrayList<Notice>();
		Connection baseConn=BaseDao.getConnection();
		//String sql="select * from  notice where username='"+username+"' and publishdate='"+publishdate+"'";
		StringBuffer sb=new StringBuffer("select * from  notice where username='"+username+"'");
		if(qtype.equals("publishdate")){
			sb.append(" and publishdate='"+query+"'");
		}
		if(qtype.equals("title")){
			sb.append(" and title like '"+query+"%'");
		}
		if(qtype.equals("content")){
			sb.append(" and content like '"+query+"%'");
		}
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			Notice notice;
			while (rs.next()) {
				notice=new Notice();
				notice.setId(rs.getInt("id"));
				notice.setPublishdate(rs.getString("publishdate"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setNoticetype(rs.getString("noticetype"));
				notice.setUsername(rs.getString("username"));
				list.add(notice);
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
		System.out.println("size----"+list.size());
		return list.size();
	} 
}
