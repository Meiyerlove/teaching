package org.yeeku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yeeku.model.Assistant;
import org.yeeku.model.Classroom;

import com.bw30.zjvote.config.BaseDao;

public class ClassroomDao {
	public List<Classroom> findClassroom(String column_name,String desc,int from, int size) {
		List<Classroom> list=new ArrayList<Classroom>();
		Connection baseConn=BaseDao.getConnection();
		String sql = "select * from classroom order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Classroom classroom ;
			while (rs.next()) {
				classroom=new Classroom();
				classroom.setId(rs.getInt("id"));
				classroom.setCid(rs.getString("cid"));
				//classroom.setRoomname(rs.getString("roomname"));
				classroom.setRoomid(rs.getString("roomid"));
				classroom.setCampus(rs.getString("campus"));
				Integer type=rs.getInt("type");
				if(type.equals(1)){
					classroom.setClassroomtype("机房");
				}
				if(type.equals(2)){
					classroom.setClassroomtype("教室");
				}
				if(type.equals(3)){
					classroom.setClassroomtype("口语室");
				}
				list.add(classroom);
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
	public int findClassroomCount() {
		List<Classroom> list=new ArrayList<Classroom>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from classroom ");
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			Classroom classroom=new Classroom();
			while (rs.next()) {
				classroom=new Classroom();
				classroom.setId(rs.getInt("id"));
				classroom.setCid(rs.getString("cid"));
			//	classroom.setRoomname(rs.getString("roomname"));
				classroom.setRoomid(rs.getString("roomid"));
				classroom.setCampus(rs.getString("campus"));
				Integer type=rs.getInt("type");
				if(type.equals(1)){
					classroom.setClassroomtype("机房");
				}
				if(type.equals(2)){
					classroom.setClassroomtype("教室");
				}
				if(type.equals(3)){
					classroom.setClassroomtype("口语室");
				}
				list.add(classroom);
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
	public int findClassroomQueryCount(String query, String qtype) {
		List<Classroom> list=new ArrayList<Classroom>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from  classroom where ");
		if(qtype.equals("cid")){
			sb.append(" cid like '%"+query+"%'");
		}
		if(qtype.equals("campus")){
			sb.append(" campus like '%"+query+"%'");
		}
		if(qtype.equals("roomid")){
			sb.append(" roomid like '%"+query+"%'"); 
		}
		if(qtype.equals("type")){
			sb.append(" type like '%"+query+"%'");
		}
		if(qtype.equals("email")){
			sb.append(" email like '%"+query+"%'");
		}
		/*if(qtype.equals("roomname")){
			sb.append(" roomname like '%"+query+"%'");
		}*/
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			Classroom classroom;
			while (rs.next()) {
				classroom=new Classroom();
				classroom.setId(rs.getInt("id"));
				classroom.setCid(rs.getString("cid"));
			//	classroom.setRoomname(rs.getString("roomname"));
				classroom.setRoomid(rs.getString("roomid"));
				classroom.setCampus(rs.getString("campus"));
				Integer type=rs.getInt("type");
				if(type.equals(1)){
					classroom.setClassroomtype("机房");
				}
				if(type.equals(2)){
					classroom.setClassroomtype("教室");
				}
				if(type.equals(3)){
					classroom.setClassroomtype("口语室");
				}
				list.add(classroom);
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
	public List<Classroom> findClassroomQueryCountList(String query,String qtype,String column_name,String desc,int from, int size) {
		List<Classroom> classroomlist=new ArrayList<Classroom>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=new StringBuffer("select * from classroom where");
		 if(qtype.equals("cid")){
			    sb.append(" cid like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
		 }
		 if(qtype.equals("campus")){
				sb.append(" campus like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("roomid")){
				sb.append(" roomid like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("type")){
				sb.append(" type like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("email")){
				sb.append(" email like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			/*if(qtype.equals("roomname")){
				sb.append(" roomname like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}*/
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sb.toString());
				rs = pre.executeQuery();
				Classroom classroom;
				while (rs.next()) {
					classroom=new Classroom();
					classroom.setId(rs.getInt("id"));
					classroom.setCid(rs.getString("cid"));
					//classroom.setRoomname(rs.getString("roomname"));
					classroom.setRoomid(rs.getString("roomid"));
					classroom.setCampus(rs.getString("campus"));
					Integer type=rs.getInt("type");
					if(type.equals(1)){
						classroom.setClassroomtype("机房");
					}
					if(type.equals(2)){
						classroom.setClassroomtype("教室");
					}
					if(type.equals(3)){
						classroom.setClassroomtype("口语室");
					}
					classroomlist.add(classroom);
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
		 return classroomlist;
	}
	
}
