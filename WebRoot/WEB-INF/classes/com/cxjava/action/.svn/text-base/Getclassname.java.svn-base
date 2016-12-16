package com.cxjava.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.yeeku.model.TClass;

import com.bw30.zjvote.config.BaseDao;

public class Getclassname {
   
	public static TClass getclassname(Integer classid){
		 TClass tclass=null;
		 Connection baseConn=BaseDao.getConnection();
		 String sql = "select * from Tclass where id="+classid;
		 PreparedStatement pre = null;
		 try {
			pre=baseConn.prepareStatement(sql);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				tclass=new TClass();
				tclass.setId(rs.getInt("id"));
				tclass.setName(rs.getString("tname"));	 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		 } finally{
				try {
					baseConn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		   return tclass;
     }
	
  public static void main(String[] args) {
	try {
		TClass tcla=Getclassname.getclassname(7);
		System.out.println(tcla.getName());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}