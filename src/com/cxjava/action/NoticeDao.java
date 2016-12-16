package com.cxjava.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yeeku.model.Adjust;
import org.yeeku.model.Notice;
import org.yeeku.model.TClass;

import com.bw30.zjvote.config.BaseDao;


public class NoticeDao { 
 
	public List<Notice> findJiaoTeacherAssistantNotice(String column_name,String desc,int from, int size) {
		 List<Notice> list=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 String sql = "select * from notice where status=2 and type <>5 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sql);
				rs = pre.executeQuery();
				Notice notice;
				while (rs.next()) {
					notice=new Notice();
					notice.setId(rs.getInt("id"));
					notice.setType(rs.getInt("type"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(null != noticetype){
						if(noticetype.equals("1")){
							notice.setNoticetype("教务通知");
						}
						if(noticetype.equals("2")){
							notice.setNoticetype("辅导员通知");
						}
						if(noticetype.equals("3")){
							notice.setNoticetype("老师通知");
						}
						Integer type=rs.getInt("type");
						if(type.equals(1)){
							notice.setClassname("所有人");
						}else if(type.equals(2)){
							notice.setClassname("老师个人");
						}else if(type.equals(3)){
							notice.setClassname("辅导员个人");
						}else{
							Integer classid=rs.getInt("classid");
							TClass tclass=Getclassname.getclassname(classid);
							if(null!=tclass){
						              notice.setClassname(tclass.getName());	
						       }
						}
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
	
	
	public int findJiaoTeacherAssistantCount() {
		List<Notice> list=new ArrayList<Notice>();
		Connection baseConn=BaseDao.getConnection();
		String sql="select * from  notice where status=2 and type <> 5";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Notice notice;
			while (rs.next()) {
				notice=new Notice();
				notice.setId(rs.getInt("id"));
				notice.setType(rs.getInt("type"));
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
	
	public int findjiaoteacherassistantcount(String username,String query,String qtype) {
		List<Notice> list=new ArrayList<Notice>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from  notice where status=2 and type <> 5");
		if(qtype.equals("username")){
			sb.append(" and username like '%"+query+"%'");
		}
		if(qtype.equals("publishdate")){
			sb.append(" and publishdate like '%"+query+"%'");
		}
		if(qtype.equals("title")){
			sb.append(" and title like '%"+query+"%'");
		}
		if(qtype.equals("content")){
			sb.append(" and content like '%"+query+"%'");
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
				notice.setType(rs.getInt("type"));
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
	public List<Notice> findjiaoteacherassistantnotice(String query,String qtype,String column_name,String desc,int from, int size) {
		List<Notice> noticelist=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=new StringBuffer("select * from notice  where status=2 and type <> 5 ");
		 if(qtype.equals("username")){
			    sb.append(" and username like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
		 }
		 if(qtype.equals("publishdate")){
				sb.append(" and publishdate like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("title")){
				sb.append(" and title like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("content")){
				sb.append(" and content like '%"+query+"%' order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
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
					notice.setType(rs.getInt("type"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("1")){
						notice.setNoticetype("教务通知");
					}
					if(noticetype.equals("2")){
						notice.setNoticetype("辅导员通知");
					}
					if(noticetype.equals("3")){
						notice.setNoticetype("老师通知");
					}
					if(noticetype.equals("4")){
						notice.setNoticetype("系统通知");
					}
					Integer type=rs.getInt("type");
					if(type.equals(1)){
						notice.setClassname("所有人");
					}else if(type.equals(2)){
						notice.setClassname("老师个人");
					}else if(type.equals(3)){
						notice.setClassname("辅导员");
					}else{
						Integer classid=rs.getInt("classid");
						TClass tclass=Getclassname.getclassname(classid);
						if(null!=tclass){
					     notice.setClassname(tclass.getName());	
					  }
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
	public List<Notice> findJiaoWuNotice(String username,String column_name,String desc,int from, int size){ 
		List<Notice> list=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 String sql = "select * from notice where  publisherid in(3,4) and status=2 and type <> 5 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sql);
				rs = pre.executeQuery();
				Notice notice;
				while (rs.next()) {
					notice=new Notice();
					notice.setId(rs.getInt("id"));
					notice.setType(rs.getInt("type"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("1")){
						notice.setNoticetype("教务通知");
					}
					Integer type=rs.getInt("type");
					if(type.equals(1)){
						notice.setClassname("所有人");
					}else if(type.equals(2)){
						notice.setClassname("老师个人");
					}else if(type.equals(3)){
						notice.setClassname("辅导员");
					}else{
						Integer classid=rs.getInt("classid");
						TClass tclass=Getclassname.getclassname(classid);
						if(null!=tclass){
					     notice.setClassname(tclass.getName());	
					  }
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
	public int findJiaoWuNoticeCount(String username) {
		List<Notice> list=new ArrayList<Notice>();
		Connection baseConn=BaseDao.getConnection();
		String sql="select * from  notice where publisherid in(3,4) and status=2 and type <> 5";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Notice notice;
			while (rs.next()) {
				notice=new Notice();
				notice.setId(rs.getInt("id"));
				notice.setType(rs.getInt("type"));
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
	public List<Notice> findjiaowunotice(String query,String qtype,String column_name,String desc,int from, int size) {
		List<Notice> noticelist=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=new StringBuffer("select * from notice  where publisherid in (3,4) and  status=2 and type <> 5 and ");
		 if(qtype.equals("username")){
			    sb.append("  username like '%"+query+"%' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
		 }
		 if(qtype.equals("publishdate")){
				sb.append("  publishdate like '%"+query+"%' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("title")){
				sb.append("  title like '%"+query+"%' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}                
			if(qtype.equals("content")){
				sb.append(" content like '%"+query+"%' order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
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
					notice.setType(rs.getInt("type"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("1")){
						notice.setNoticetype("教务通知");
					}
					Integer type=rs.getInt("type");
					if(type.equals(1)){
						notice.setClassname("所有人");
					}else if(type.equals(2)){
						notice.setClassname("老师个人");
					}else if(type.equals(3)){
						notice.setClassname("辅导员");
					}else{
						Integer classid=rs.getInt("classid");
						TClass tclass=Getclassname.getclassname(classid);
						if(null!=tclass){
					     notice.setClassname(tclass.getName());	
					  }
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
	
	public int findjiaowunoticecount(String username,String query,String qtype){ 
		List<Notice> list=new ArrayList<Notice>();
		Connection baseConn=BaseDao.getConnection();
		StringBuffer sb=new StringBuffer("select * from  notice where publisherid in (3,4) and status=2 ");
		if(qtype.equals("username")){
			sb.append(" and username like '%"+query+"%'");
		}
		if(qtype.equals("publishdate")){
			sb.append(" and publishdate like '%"+query+"%'");
		}
		if(qtype.equals("title")){
			sb.append(" and title like '%"+query+"%'");
		}
		if(qtype.equals("content")){
			sb.append(" and content like '%"+query+"%'");
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
				notice.setType(rs.getInt("type"));
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
	
	public int findAssistantCount(String username){
		List<Notice> list=new ArrayList<Notice>();
		Connection baseConn=BaseDao.getConnection();
		String sql=null;
		if(username==null ||username==""){
			sql="select * from notice where publisherid in (5,6) and status=2 and type <> 5";		
		}else{
			sql="select * from notice where username='"+username+"' and publisherid=6 and status=2 and type <> 5";	
		}
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = baseConn.prepareStatement(sql);
			rs = pre.executeQuery();
			Notice notice;
			while (rs.next()) {
				notice=new Notice();
				notice.setId(rs.getInt("id"));
				notice.setType(rs.getInt("type"));
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
	
	 public List<Notice> findAssistantNotice(String username,String column_name,String desc,int from, int size) {
		 List<Notice> noticelist=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 String sql = null;
			if(username==null ||username==""){
		    sql = "select * from notice where publisherid in (5,6) and status=2 and type <> 5 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
			}else{
			 sql = "select * from notice where username='"+username+"' and publisherid=6 and status=2 and type <> 5  order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";
		   }
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sql);
				rs = pre.executeQuery();
				Notice notice;
				while (rs.next()) {
					notice=new Notice();
					notice.setId(rs.getInt("id"));
					notice.setType(rs.getInt("type"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("2")){
						notice.setNoticetype("辅导员通知");
					}
					Integer type=rs.getInt("type");
					if(type.equals(1)){
						notice.setClassname("所有人");
					}else if(type.equals(2)){
						notice.setClassname("老师个人");
					}else if(type.equals(3)){
						notice.setClassname("辅导员");
					}else{
						Integer classid=rs.getInt("classid");
						TClass tclass=Getclassname.getclassname(classid);
						if(null!=tclass){
					     notice.setClassname(tclass.getName());	
					  }
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
	 
	 public int findassistantnoticeCount(String username,String query,String qtype) {
		 List<Notice> list=new ArrayList<Notice>();
		   StringBuffer sb=null;
			Connection baseConn=BaseDao.getConnection();
			PreparedStatement pre = null;
			ResultSet rs = null;
			try {
		 if(username==null || username==""){
			 sb=new StringBuffer("select * from  notice where publisherid in (5,6) and status=2 and ");
			if(qtype.equals("username")){
				sb.append(" username like '%"+query+"%'");
			}
			if(qtype.equals("publishdate")){
				sb.append(" publishdate like '%"+query+"%'");
			}
			if(qtype.equals("title")){
				sb.append(" title like '%"+query+"%'");
			}
			if(qtype.equals("content")){
				sb.append(" content like '%"+query+"%'");
			}
		 }else{
			sb=new StringBuffer("select * from  notice where username='"+username+"' and publisherid=6 and status=2 and ");
			if(qtype.equals("username")){
				sb.append(" username like '%"+query+"%'");
			}
			if(qtype.equals("publishdate")){
				sb.append(" publishdate like '%"+query+"%'");
			}
			if(qtype.equals("title")){
				sb.append(" title like '%"+query+"%'");
			}
			if(qtype.equals("content")){
				sb.append(" content like '%"+query+"%'");
			 }	
			}
	        	pre = baseConn.prepareStatement(sb.toString());
				rs = pre.executeQuery();
				Notice notice;
				while (rs.next()) {
					notice=new Notice();
					notice.setId(rs.getInt("id"));
					notice.setType(rs.getInt("type"));
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
		
	 public List<Notice> findAssistantnotice(String username,String query,String qtype,String column_name,String desc,int from, int size) {
		 List<Notice> noticelist=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=null;
		 if(username==null ||username==""){
			  sb=new StringBuffer("select * from  notice where publisherid in (5,6) and ");  
		    } else{
		    	sb=new StringBuffer("select * from  notice where username='"+username+"' and ");  	  
		    }
			if(qtype.equals("username")){
				sb.append(" username like '%"+query+"%' and status=2 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("publishdate")){
				sb.append(" publishdate like '%"+query+"%' and status=2 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("title")){
				sb.append(" title like '%"+query+"%' and status=2 order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("content")){
				sb.append(" content like '%"+query+"%' and status=2 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
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
					notice.setType(rs.getInt("type"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("2")){
						notice.setNoticetype("辅导员通知");
					}
					Integer type=rs.getInt("type");
					if(type.equals(1)){
						notice.setClassname("所有人");
					}else if(type.equals(2)){
						notice.setClassname("老师个人");
					}else if(type.equals(3)){
						notice.setClassname("辅导员");
					}else{
						Integer classid=rs.getInt("classid");
						TClass tclass=Getclassname.getclassname(classid);
						if(null!=tclass){
					     notice.setClassname(tclass.getName());	
					  }
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
	 public List<Notice> findTeacherNotice(String username,String column_name,String desc,int from, int size) {
		 List<Notice> noticelist=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 String sql=null;
		 if(username==null || username==""){
			sql = "select * from notice where publisherid=7 and status=2 and type <> 5 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " "; 
		 }else{
			sql = "select * from notice where username='"+username+"' and publisherid=7 and status=2 and type <> 5 order by  "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ";  
		 }
		 PreparedStatement pre = null;
		 ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sql);
				rs = pre.executeQuery();
				Notice notice;
				while (rs.next()) {
					notice=new Notice();
					notice.setId(rs.getInt("id"));
					notice.setType(rs.getInt("type"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("3")){
						notice.setNoticetype("老师通知");
					}
					Integer type=rs.getInt("type");
					if(type.equals(1)){
						notice.setClassname("所有人");
					}else if(type.equals(2)){
						notice.setClassname("老师个人");
					}else if(type.equals(3)){
						notice.setClassname("辅导员");
					}else{
						Integer classid=rs.getInt("classid");
						TClass tclass=Getclassname.getclassname(classid);
						if(null!=tclass){
					     notice.setClassname(tclass.getName());	
					  }
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
	 public int findTeacherNoticeCount(String username){
			List<Notice> list=new ArrayList<Notice>();
			Connection baseConn=BaseDao.getConnection();
			String sql=null;
			if(username==null || username==""){
				sql="select * from notice where publisherid=7 and status=2 and type <> 5";	
			}else{
			    sql="select * from notice where username='"+username+"' and publisherid=7 and status=2 and type <> 5";
			}
			PreparedStatement pre = null;
			ResultSet rs = null;
			try {
				pre = baseConn.prepareStatement(sql);
				rs = pre.executeQuery();
				Notice notice;
				while (rs.next()) {
					notice=new Notice();
					notice.setId(rs.getInt("id"));
					notice.setType(rs.getInt("type"));
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
	 
	 public List<Notice> findTeachernotice(String username,String query,String qtype,String column_name,String desc,int from, int size) {
		 List<Notice> noticelist=new ArrayList<Notice>();
		 Connection baseConn=BaseDao.getConnection();
		 StringBuffer sb=null;
		 if(username==null || username==""){
		  sb=new StringBuffer("select * from  notice where publisherid=7 and type <> 5 and ");
		 }else{
		  sb=new StringBuffer("select * from  notice where username='"+username+"' and publisherid=7 and type <> 5 and "); 
		 }
		  if(qtype.equals("username")){
		 		sb.append(" username like '%"+query+"%' and status=2 order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("publishdate")){
				sb.append(" publishdate like '%"+query+"%' and status=2 order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("title")){
				sb.append(" title like '%"+query+"%' and status=2  order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
			}
			if(qtype.equals("content")){
				sb.append(" content like '%"+query+"%' and status=2 order by "+column_name+" "+desc+ " LIMIT " +from+ " , " + size + " ");
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
					notice.setType(rs.getInt("type"));
					notice.setPublishdate(rs.getString("publishdate"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					String noticetype=rs.getString("noticetype");
					if(noticetype.equals("3")){
						notice.setNoticetype("老师通知");
					}
					Integer type=rs.getInt("type");
					if(type.equals(1)){
						notice.setClassname("所有人");
					}else if(type.equals(2)){
						notice.setClassname("老师个人");
					}else if(type.equals(3)){
						notice.setClassname("辅导员");
					}else{
						Integer classid=rs.getInt("classid");
						TClass tclass=Getclassname.getclassname(classid);
						if(null!=tclass){
					     notice.setClassname(tclass.getName());	
					  }
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
	 
	 public int findTeachernoticeCount(String username,String query,String qtype) {
		 List<Notice> list=new ArrayList<Notice>();
		 StringBuffer sb=null;
			Connection baseConn=BaseDao.getConnection();
			if(username==null || username==""){
				sb=new StringBuffer("select * from  notice where publisherid=7 and status=2 and type <> 5 and  ");
			}else{
				sb=new StringBuffer("select * from  notice where username='"+username+"' and publisherid=7 and status=2 and type <> 5 and ");
			}
			if(qtype.equals("username")){
				sb.append(" username like '%"+query+"%' ");
			}
			if(qtype.equals("publishdate")){
				sb.append(" publishdate like '%"+query+"%'");
			}
			if(qtype.equals("title")){
				sb.append(" title like '%"+query+"%'");
			}
			if(qtype.equals("content")){
				sb.append(" content like '%"+query+"%'");
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
					notice.setType(rs.getInt("type"));
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
			//System.out.println("size----"+list.size());
			return list.size();
		}
	public static void main(String[] args) {
//		List<Notice> list= new NoticeDao().findAllNotice("jiaowu","id", "desc", 0, 10);
//		for (Notice notice : list) {
//			System.out.println(notice.getContent()+" "+notice.getTitle());
//		}
//		int roes= new NoticeDao().findNoticeCount("jiaowu");
//		System.out.println(roes);
//		List<Notice> list= new NoticeDao().findNotice("jiaowu", "2016-01-04 10:05:49", "id", "desc", 0, 10);
//		for (Notice notice : list) {
//			System.out.println(notice.getContent()+" "+notice.getId());
//		}
//		int roes= new NoticeDao().findnoticeCount("jiaowu","2016-01-04 10:05:49");
//		System.out.println(roes);
		
//		//List<Notice> list= new NoticeDao().findAssistantNotice("id","desc", 0, 10);
//		for (Notice notice : list) {
//			System.out.println(notice.getContent()+" "+notice.getId());
//		}
	}
  }