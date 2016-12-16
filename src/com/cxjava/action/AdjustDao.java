package com.cxjava.action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.yeeku.model.Adjust;
import org.yeeku.model.Goods;

import com.bw30.zjvote.config.BaseDao;

public class AdjustDao {
	public List<Adjust> findByIpDate(String column_name,String desc,int from, int size) {
		List<Adjust> list=new ArrayList<Adjust>();
		 Connection baseConn=BaseDao.getConnection();
		 String sql = "select * from adjust order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		 //System.out.println("sql--"+sql);
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Adjust adjust;
			while (rs.next()) {
				adjust=new Adjust();
				adjust.setId(rs.getInt("id"));
				adjust.setClassname(rs.getString("classname"));
				adjust.setSubjectname(rs.getString("subjectname"));
				adjust.setTeachername(rs.getString("teachername"));
				adjust.setClassroom(rs.getString("classroom"));
				//adjust.setDatebefore(rs.getTimestamp("datebefore"));
				adjust.setDatebefore(rs.getString("datebefore"));
				adjust.setStarttimebefore(rs.getString("starttimebefore"));
				adjust.setEndtimebefore(rs.getString("endtimebefore"));
				adjust.setTknumber(rs.getString("tknumber"));
				//adjust.setDateafter(rs.getTimestamp("dateafter"));
				adjust.setDateafter(rs.getString("dateafter"));
				adjust.setEndtimeafter(rs.getString("endtimeafter"));
				adjust.setStarttimeafter(rs.getString("starttimeafter"));
				adjust.setReason(rs.getString("reason"));
				adjust.setEdureason(rs.getString("edureason"));
				adjust.setDeanreason(rs.getString("deanreason"));
				adjust.setStatus(rs.getInt("status"));
				adjust.setS_status(rs.getString("s_status"));
				list.add(adjust);
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
	/**
	 * 
	 * 任课老师/教務主管/教務員查看调课记录数
	 * @param teachername
	 * @param column_name
	 * @param desc
	 * @param from
	 * @param size
	 * @return
	 */
	public List<Adjust> findNoagreet(String teachername,String roleid,String column_name,String desc,int from, int size) {
		List<Adjust> list=new ArrayList<Adjust>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from adjust ");
		if(teachername!=null ){
			sb.append(" where teachername='"+teachername+"' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
		}
		if(roleid.equals("3") || roleid.equals("4")){		
			sb.append(" order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " " );	
		  }
	    if(roleid.equals("6")||roleid.equals("8")){
		    sb.append(" where status=4 order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " " );
		 }
	   /* if(roleid.equals("4")){
	    	sb.append("  where status in (4,5) order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
	    }*/
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			//System.out.println("sb.toString()----"+sb.toString());
			rs = pre.executeQuery();
			Adjust adjust;
			while (rs.next()) {
				adjust=new Adjust();
				adjust.setId(rs.getInt("id"));
				adjust.setClassname(rs.getString("classname"));
				adjust.setSubjectname(rs.getString("subjectname"));
				adjust.setTeachername(rs.getString("teachername"));
				adjust.setClassroom(rs.getString("classroom"));
				//adjust.setDatebefore(rs.getTimestamp("datebefore"));
				adjust.setDatebefore(rs.getString("datebefore"));
				adjust.setStarttimebefore(rs.getString("starttimebefore"));
				adjust.setEndtimebefore(rs.getString("endtimebefore"));
				adjust.setTknumber(rs.getString("tknumber"));
				//adjust.setDateafter(rs.getTimestamp("dateafter"));
				adjust.setDateafter(rs.getString("dateafter"));
				adjust.setEndtimeafter(rs.getString("endtimeafter"));
				adjust.setStarttimeafter(rs.getString("starttimeafter"));
				adjust.setNewlcassroom(rs.getString("newlcassroom"));
				adjust.setReason(rs.getString("reason"));
				adjust.setEdureason(rs.getString("edureason"));
				adjust.setDeanreason(rs.getString("deanreason"));
				adjust.setS_status(rs.getString("s_status"));			    
				list.add(adjust);
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
	
	/**
	 * 任课老师/教務主管/教務員调课记录数
	 * @param teachername
	 * @return
	 */
	public int findNoagreetCount(String teachername,String roleid ) {
		List<Adjust> list=new ArrayList<Adjust>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from adjust ");
		System.out.println(teachername!=null);
		if(teachername!=null){
			sb.append(" where teachername='"+teachername+"'");
		}
		if(roleid.equals("6")||roleid.equals("8")){
			sb.append(" where status=4 ");
		}
		if(roleid.equals("4")){
			sb.append(" where status in(4,5)");
		}
		PreparedStatement pre = null;
		ResultSet rs = null;
	//	System.out.println("sb.toString()-----"+sb.toString());
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			Adjust adjust=new Adjust();
			while (rs.next()) {
				adjust.setId(rs.getInt("id"));
				adjust.setClassname(rs.getString("classname"));
				adjust.setSubjectname(rs.getString("subjectname"));
				adjust.setTeachername(rs.getString("teachername"));
				adjust.setClassroom(rs.getString("classroom"));
				//adjust.setDatebefore(rs.getTimestamp("datebefore"));
				adjust.setDatebefore(rs.getString("datebefore"));
				adjust.setStarttimebefore(rs.getString("starttimebefore"));
				adjust.setEndtimebefore(rs.getString("endtimebefore"));
				adjust.setTknumber(rs.getString("tknumber"));
				//adjust.setDateafter(rs.getTimestamp("dateafter"));
				adjust.setDateafter(rs.getString("dateafter"));
				adjust.setEndtimeafter(rs.getString("endtimeafter"));
				adjust.setStarttimeafter(rs.getString("starttimeafter"));
				adjust.setReason(rs.getString("reason"));
				adjust.setEdureason(rs.getString("edureason"));
				adjust.setDeanreason(rs.getString("deanreason"));
				adjust.setS_status(rs.getString("s_status"));
				list.add(adjust);
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
	/**
	 *  任课老师搜索查看课程记录数
	 * @param teachername
	 * @param qtype
	 * @param args
	 * @return
	 */
	public int findAdjustCount1 (String teachername,String qtype,String args)  {
		List<Adjust> list=new ArrayList<Adjust>();
		Connection con=BaseDao.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer("select * from adjust where ");
		try {
			if(qtype.equals("tknumber")){
				sb.append(" tknumber= '"+args+"'");
			}else if(qtype.equals("subjectname")){
				sb.append(" subjectname= '"+args+"'"); 		 
			}else if(qtype.equals("classname")){
				sb.append(" classname= '"+args+"'"); 	 
			}else if(qtype.equals("datebefore")){
				sb.append(" datebefore= '"+args+"'"); 		
			}else if(qtype.equals("dateafter")) {
				sb.append(" dateafter= '"+args+"'"); 
			}else {
				sb.append("");
			}
			  if(teachername!=null){
				sb.append(" and teachername='"+teachername+"'");
			  }
			//System.out.println("---"+sb.toString());
			 pstm=con.prepareStatement(sb.toString());
			 rs=pstm.executeQuery();
			Adjust adjust=null;
			while(rs.next()){
				adjust=new Adjust();
				adjust.setId(rs.getInt("id"));
				adjust.setClassname(rs.getString("classname"));
				adjust.setSubjectname(rs.getString("subjectname"));
				adjust.setTeachername(rs.getString("teachername"));
				adjust.setClassroom(rs.getString("classroom"));
				//adjust.setDatebefore(rs.getTimestamp("datebefore"));
				adjust.setDatebefore(rs.getString("datebefore"));
				adjust.setStarttimebefore(rs.getString("starttimebefore"));
				adjust.setEndtimebefore(rs.getString("endtimebefore"));
				adjust.setTknumber(rs.getString("tknumber"));
				//adjust.setDateafter(rs.getTimestamp("dateafter"));
				adjust.setDateafter(rs.getString("dateafter"));
				adjust.setEndtimeafter(rs.getString("endtimeafter"));
				adjust.setStarttimeafter(rs.getString("starttimeafter"));
				adjust.setReason(rs.getString("reason"));
				adjust.setEdureason(rs.getString("edureason"));
				adjust.setDeanreason(rs.getString("deanreason"));
				adjust.setS_status(rs.getString("s_status"));
				list.add(adjust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (null != pstm){
					pstm.close();	
				  }
				if (null != rs){
					rs.close();	
				 }
				if (null != con){
					con.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("size()----"+list.size());
		return list.size();
	}
	public List<Adjust> findByIpDate1(String teachername, String qtype,String agrs,String column_name,String desc,int from, int size) {
		List<Adjust> list=new ArrayList<Adjust>();
		Connection baseConn=BaseDao.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		StringBuffer sb=new StringBuffer("select * from adjust where ");
		try {
	    if(teachername!=null){
	    	sb.append(" teachername='"+teachername+"' and");	 
			 }
		if(qtype.equals("tknumber")){
			sb.append(" tknumber= '"+agrs+"' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " " );
		}else if(qtype.equals("subjectname")){
			sb.append(" subjectname= '"+agrs+"'order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " "); 		 
		}else if(qtype.equals("classname")){
			sb.append(" classname= '"+agrs+"'order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " "); 	 
		}else if(qtype.equals("datebefore")){
			sb.append(" datebefore= '"+agrs+"'order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " "); 		
		}else if(qtype.equals("dateafter")) {
			sb.append(" dateafter= '"+agrs+"'order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " "); 
		}else{
			sb.append("");
		}
		//  System.out.println("sb.toString()----"+sb.toString());
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			Adjust adjust=null;
			while (rs.next()) {
				adjust=new Adjust();
				adjust.setId(rs.getInt("id"));
				adjust.setClassname(rs.getString("classname"));
				adjust.setSubjectname(rs.getString("subjectname"));
				adjust.setTeachername(rs.getString("teachername"));
				adjust.setClassroom(rs.getString("classroom"));
				//adjust.setDatebefore(rs.getTimestamp("datebefore"));
				adjust.setDatebefore(rs.getString("datebefore"));
				adjust.setStarttimebefore(rs.getString("starttimebefore"));
				adjust.setEndtimebefore(rs.getString("endtimebefore"));
				adjust.setTknumber(rs.getString("tknumber"));
				//adjust.setDateafter(rs.getTimestamp("dateafter"));
				adjust.setDateafter(rs.getString("dateafter"));
				adjust.setEndtimeafter(rs.getString("endtimeafter"));
				adjust.setStarttimeafter(rs.getString("starttimeafter"));
				adjust.setNewlcassroom(rs.getString("newlcassroom"));
				adjust.setReason(rs.getString("reason"));
				adjust.setEdureason(rs.getString("edureason"));
				adjust.setDeanreason(rs.getString("deanreason"));
				adjust.setS_status(rs.getString("s_status"));
				list.add(adjust);
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
	
	
    
	public int findCount() {
		List<Adjust> list=new ArrayList<Adjust>();
		 Connection baseConn=BaseDao.getConnection();
		String sql = "select * from adjust";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Adjust adjust=new Adjust();
			while (rs.next()) {
				adjust.setId(rs.getInt("id"));
				adjust.setClassname(rs.getString("classname"));
				adjust.setSubjectname(rs.getString("subjectname"));
				adjust.setTeachername(rs.getString("teachername"));
				adjust.setClassroom(rs.getString("classroom"));
			//	adjust.setDatebefore(rs.getTimestamp("datebefore"));
				adjust.setDatebefore(rs.getString("datebefore"));
				adjust.setStarttimebefore(rs.getString("starttimebefore"));
				adjust.setEndtimebefore(rs.getString("endtimebefore"));
				adjust.setTknumber(rs.getString("tknumber"));
				//adjust.setDateafter(rs.getTimestamp("dateafter"));
				adjust.setDateafter(rs.getString("dateafter"));
				adjust.setEndtimeafter(rs.getString("endtimeafter"));
				adjust.setStarttimeafter(rs.getString("starttimeafter"));
				adjust.setReason(rs.getString("reason"));
				adjust.setEdureason(rs.getString("edureason"));
				adjust.setDeanreason(rs.getString("deanreason"));
				list.add(adjust);
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
		//System.out.println("list.size()----"+list.size());
		return list.size();
	}
	 
	public int findAdjustCount (String qtype,String args)  {
		 List<Adjust> list=new ArrayList<Adjust>();
		 Connection con=BaseDao.getConnection();
         PreparedStatement pstm=null;
		 ResultSet rs=null;
		 StringBuffer sb=new StringBuffer("select * from adjust where ");
		 try {
			 if(qtype.equals("tknumber")){
				sb.append(" tknumber= '"+args+"'");
				System.out.println("sb.toString()---"+sb.toString());
		     }else if(qtype.equals("subjectname")){
		       sb.append(" subjectname= '"+args+"'"); 		 
			 }else if(qtype.equals("classname")){
			   sb.append(" classname= '"+args+"'"); 	 
			 }else if(qtype.equals("datebefore")){
			   sb.append(" datebefore= '"+args+"'"); 		
			 }else {
			   sb.append(" dateafter= '"+args+"'"); 
		     }
			pstm=con.prepareStatement(sb.toString());
			rs=pstm.executeQuery();
			Adjust adjust=null;
			while(rs.next()){
				adjust=new Adjust();
			    adjust.setId(rs.getInt("id"));
				adjust.setClassname(rs.getString("classname"));
				adjust.setSubjectname(rs.getString("subjectname"));
				adjust.setTeachername(rs.getString("teachername"));
				adjust.setClassroom(rs.getString("classroom"));
				//adjust.setDatebefore(rs.getTimestamp("datebefore"));
				adjust.setDatebefore(rs.getString("datebefore"));
				adjust.setStarttimebefore(rs.getString("starttimebefore"));
				adjust.setEndtimebefore(rs.getString("endtimebefore"));
				adjust.setTknumber(rs.getString("tknumber"));
				//adjust.setDateafter(rs.getTimestamp("dateafter"));
				adjust.setDateafter(rs.getString("dateafter"));
				adjust.setEndtimeafter(rs.getString("endtimeafter"));
				adjust.setStarttimeafter(rs.getString("starttimeafter"));
				adjust.setReason(rs.getString("reason"));
				adjust.setEdureason(rs.getString("edureason"));
				adjust.setDeanreason(rs.getString("deanreason"));
				list.add(adjust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (null != pstm){
					pstm.close();	
				  }
				if (null != rs){
					rs.close();	
				 }
				if (null != con){
					con.close();	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		// System.out.println("size()----"+list.size());
		 return list.size();
	} 
	public void findexamid_update(){
		 Connection con=BaseDao.getConnection();
         PreparedStatement pstm=null;
		 ResultSet rs=null;
		 String sql="select * from exam";
		 try {
			pstm=con.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				int teachingid=rs.getInt("teacherid");
				int row=new AdjustDao().update(teachingid,con);
				if(row>0){
					System.out.println("---ok");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
	public int update(int teachingid,Connection con){
		 int rows=0;
		 con=BaseDao.getConnection();
         PreparedStatement pstm=null;
		 String sql="update exam set neishenyuanid=? where teacherid=?";
		 try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, teachingid);
			pstm.setInt(2, teachingid);
			rows=pstm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return rows;
	}
	
	public static void main(String[] args) {
		new AdjustDao().findexamid_update();
	}
	
	}














