package org.yeeku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yeeku.model.Assistant;
import org.yeeku.model.User;

import com.bw30.zjvote.config.BaseDao;

public class AlluserDao {
	public List<User> findUser(String column_name,String desc,int from, int size) {
		List<User> list=new ArrayList<User>();
		Connection baseConn=BaseDao.getConnection();
		String sql = "select * from user where type <> 1 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			User user;
			while (rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUser(rs.getString("username"));
				user.setPass(rs.getString("password"));
                Integer usertype=rs.getInt("type");
                if(usertype.equals(2)){
                	user.setUser_type("院长");
                }
                if(usertype.equals(3)){
                	user.setUser_type("教务主管");
                }
                if(usertype.equals(4)){
                	user.setUser_type("教务员");
                }
                if(usertype.equals(5)){
                	user.setUser_type("学生主管");
                }
                if(usertype.equals(6)){
                	user.setUser_type("辅导员");
                }
                if(usertype.equals(7)){
                	user.setUser_type("任课老师");
                }
                if(usertype.equals(8)){
                	user.setUser_type("学生");
                }
                if(usertype.equals(9)){
                	user.setUser_type("办公室");
                }
                if(usertype.equals(10)){
                	user.setUser_type("离校学生");
                }
				Integer status=rs.getInt("status");
				if(status.equals(1)){
					user.setS_status("在职");
				}
				if(status.equals(2)){
					user.setS_status("离职");
				}
				list.add(user);
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
	
	
	
	public int findUserCount() {
		List<User> list=new ArrayList<User>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from user ");
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			User user=new User();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUser(rs.getString("username"));
              /*  Integer usertype=rs.getInt("type");
                if(usertype.equals(2)){
                	user.setUser_type("院长");
                }
                if(usertype.equals(3)){
                	user.setUser_type("教务主管");
                }
                if(usertype.equals(4)){
                	user.setUser_type("教务员");
                }
                if(usertype.equals(5)){
                	user.setUser_type("学生主管");
                }
                if(usertype.equals(6)){
                	user.setUser_type("辅导员");
                }
                if(usertype.equals(7)){
                	user.setUser_type("任课老师");
                }
                if(usertype.equals(8)){
                	user.setUser_type("学生");
                }
                if(usertype.equals(9)){
                	user.setUser_type("办公室");
                }
                if(usertype.equals(10)){
                	user.setUser_type("离校学生");
                }*/
				Integer status=rs.getInt("status");
				if(status.equals(1)){
					user.setS_status("在职");
				}
				if(status.equals(2)){
					user.setS_status("离职");
				}
				list.add(user);
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
		return list.size();
	}
	public int findUserQueryCount(String query, String qtype) {
		List<User> list=new ArrayList<User>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from  user where ");
		if(qtype.equals("user")){
			sb.append(" username like '%"+query+"%'");
		}
		if(qtype.equals("user_type")){
			sb.append(" type like '%"+query+"%'");
		}
		if(qtype.equals("s_status")){
			sb.append(" status like '%"+query+"%'");
		}
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sb.toString());
			rs = pre.executeQuery();
			User user;
			while (rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUser(rs.getString("username"));
				Integer status=rs.getInt("status");
				if(status.equals(1)){
					user.setS_status("在职");
				}
				if(status.equals(2)){
					user.setS_status("离职");
				}
				list.add(user);
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
		return list.size();
	}
	public List<User> findUserQueryCountList(String query,String qtype,String column_name,String desc,int from, int size) {
		List<User> userlist=new ArrayList<User>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=new StringBuffer("select * from user where");
	
		 if(qtype.equals("user")){
				sb.append(" username like '%"+query+"%' and type<> 1 order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
		 if(qtype.equals("user_type")){
				sb.append(" type like '%"+query+"%' and type<> 1 order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
		 if(qtype.equals("s_status")){
				sb.append(" status like '%"+query+"%' and type<> 1 order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sb.toString());
				rs = pre.executeQuery();
				User user;
				while (rs.next()) {
					user=new User();
					user.setId(rs.getInt("id"));
					user.setUser(rs.getString("username"));
					user.setPass(rs.getString("password"));
	                Integer usertype=rs.getInt("type");
	                if(usertype.equals(2)){
	                	user.setUser_type("院长");
	                }
	                if(usertype.equals(3)){
	                	user.setUser_type("教务主管");
	                }
	                if(usertype.equals(4)){
	                	user.setUser_type("教务员");
	                }
	                if(usertype.equals(5)){
	                	user.setUser_type("学生主管");
	                }
	                if(usertype.equals(6)){
	                	user.setUser_type("辅导员");
	                }
	                if(usertype.equals(7)){
	                	user.setUser_type("任课老师");
	                }
	                if(usertype.equals(8)){
	                	user.setUser_type("学生");
	                }
	                if(usertype.equals(9)){
	                	user.setUser_type("办公室");
	                }
	                if(usertype.equals(10)){
	                	user.setUser_type("离校学生");
	                }
					Integer status=rs.getInt("status");
					if(status.equals(1)){
						user.setS_status("在职");
					}
					if(status.equals(2)){
						user.setS_status("离职");
					}
					userlist.add(user);
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
		 return userlist;
	}
	
	public static void main(String[] args) {
		AssistantDao teacher=new AssistantDao();
		teacher.getClassnameNameList("李文娟");
	}
}
