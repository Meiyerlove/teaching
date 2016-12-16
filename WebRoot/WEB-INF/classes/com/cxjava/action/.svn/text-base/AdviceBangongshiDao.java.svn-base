package com.cxjava.action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.yeeku.model.Adjust;
import org.yeeku.model.Advice;
import org.yeeku.model.Goods;
import org.yeeku.model.Student;

import com.bw30.zjvote.config.BaseDao;

public class AdviceBangongshiDao {
	public List<Advice> findAllAdvice(String qtype,String query,String sortname,String sortorder,int from, int size) {
		List<Advice> list=new ArrayList<Advice>();
		 Connection baseConn=BaseDao.getConnection();
		 PreparedStatement pre = null;
		 ResultSet rs = null;
		 try {
		 String sql="";
		 StringBuffer sb=new StringBuffer("select * from advice where advice.status=2");
		 if(!query.equals("")&&qtype.equals("username")){
			 sb.append("  and username='"+query+"' order by  "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " ");
			 pre = baseConn.prepareStatement(sb.toString());
		 }else if(!query.equals("")&&qtype.equals("createdate")){
			 sb.append("  and createdate like '%"+query+"%' order by  "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " ");
			 pre = baseConn.prepareStatement(sb.toString());
		 }else{
			 sql = "select * from advice where advice.status=2 order by  "+sortname+" "+sortorder+ " LIMIT " +from+ " , " + size + " ";
			 pre = baseConn.prepareStatement(sql);
		 }
			rs = pre.executeQuery();
			while (rs.next()) {
				Advice advice=new Advice();
				advice.setId(rs.getInt("id"));
				String content=rs.getString("content");
				if(content.length()>55){
					advice.setContent(content.substring(0,55)+"...");
				}else{
					advice.setContent(rs.getString("content"));
				}
				advice.setUsername(rs.getString("username"));
				advice.setCreatedate(rs.getString("createdate"));
				advice.setStatus(rs.getInt("status"));
				list.add(advice);
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
		return list;
	 }
	
	public int findAllAdviceCount(String qtype,String query) {
		List<Advice> list=new ArrayList<Advice>();
		 Connection baseConn=BaseDao.getConnection();
		 PreparedStatement pre = null;
		 int count = 0;
		 ResultSet rs; 
		 try {
		 String sql="";
		 StringBuffer sb=new StringBuffer("select * from advice where advice.status=2");
		 if(!query.equals("")&&qtype.equals("username")){
			 sb.append("  and username='"+query+"' ");
			 pre = baseConn.prepareStatement(sb.toString());
		 }else if(!query.equals("")&&qtype.equals("createdate")){
			 sb.append("  and createdate like '%"+query+"%' ");
			 pre = baseConn.prepareStatement(sb.toString());
		 }else{
			 sql = "select * from advice where advice.status=2";
			 pre = baseConn.prepareStatement(sql);
		 }
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

