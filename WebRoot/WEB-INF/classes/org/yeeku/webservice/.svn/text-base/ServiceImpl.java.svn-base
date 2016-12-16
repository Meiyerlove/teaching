package org.yeeku.webservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.yeeku.JDBCConnection;
import org.yeeku.Teaching;



public class ServiceImpl implements Teaching{

	public String getStudentBySid(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
        JSONArray jsonarray=null;
        List list=new ArrayList();
		try {
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql = "select * from student where sid ='"+sid+"' and status='1' and dividestatus <> 1";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			int count = 0;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
				  rowData.put(md.getColumnName(i), rs.getObject(i));
			     }
				 count = count + 1;
				 list.add(rowData);  
				}
			 if(count == 0){
					list.add("no such a student in database");
				}
			  jsonarray = JSONArray.fromObject(list); 
			
			dbcon.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	
	public static void main(String[] args) {
		//String a=new ServiceImpl().getStudentBySid("2016665155");
		//String a= new ServiceImpl().getScoreBySid("2014665078");
		 String a=new ServiceImpl().absenseBySid("2015665027");
		System.out.println(a);
		//System.out.println(a);
	}
     /*public static void main(String[] args) {
    	    //new ServiceImpl().getRewardBySid("2016665145");
    	  // new ServiceImpl().getpunishBySid("2016665146");
    	 // new ServiceImpl().getCurSch("12秋HND会计2班");
    	  // new ServiceImpl().absenseBySid("2014665122");
    	   //new ServiceImpl().getExamByCid("14秋HND会计1班");
    	   new ServiceImpl().getScoreBySid("2016665146");
    	   //new ServiceImpl().getNoticeByCid("12秋HND会计2班");
    	   //new ServiceImpl().getNotice();
    	   new ServiceImpl().getParentsNoticeBySid("2016665146");
    	   //new ServiceImpl().getNoticeBySid("2016665146");
    	     //new ServiceImpl().exist("2016665146");
    	   new ServiceImpl().getNotice();
    	//  new ServiceImpl().getAdvice("20166651461");
    	 // new ServiceImpl().getJZLetter("2016665145");
    	 // new ServiceImpl().makeAdvice("垃圾垃","李文娟");
    	 // new ServiceImpl().getAdjust("12秋HND会计2班");   
    	 
	}*/
        
     
	public String getCurSch(String classname){
		if(classname.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
	     List list=new ArrayList();
		try {
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql = "select * from kecheng where classname ='"+classname+"'";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
				  rowData.put(md.getColumnName(i), rs.getObject(i));
			     }
				   list.add(rowData);  
				}
			  jsonarray = JSONArray.fromObject(list); 
			dbcon.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	public String absenseBySid(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.MONTH,-3); 
			Date threeMonthAgoDate = cal.getTime(); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql="SELECT s.id as subjectid, s.name as subjectname, a.* ,st.* FROM absence a ,SUBJECT s ,student st WHERE st.sid=a.sid  AND st.sid = '"+sid+"' AND " +
					    "st.status=1 AND st.dividestatus=0 AND a.subjectid = s.id AND a.absencedate>='"+df.format(threeMonthAgoDate)+"'";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
				  rowData.put(md.getColumnName(i), rs.getObject(i));
			     }
				   list.add(rowData);  
				}
			  jsonarray = JSONArray.fromObject(list); 
			 dbcon.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	
	public String getExamByCid(String classname){
		if(classname.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.MONTH,-1); 
			Date oneMonthAgoDate = cal.getTime(); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			System.out.println(df.format(oneMonthAgoDate));
			String sql = "SELECT e.*,s.*,tc.* FROM exam e, subject s,tclass tc"+
             " where s.id = e.subjectid and edate >= '"+df.format(oneMonthAgoDate)+"' and tc.id = e.classkey and tc.tname = '"+classname+"'";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
					 if(null==rs.getObject(i)){						 
						 rowData.put(md.getColumnName(i),"");
					 }
					 else{
						 rowData.put(md.getColumnName(i), rs.getObject(i).toString());
					 }
			     }
				   list.add(rowData);  
				}
			  jsonarray = JSONArray.fromObject(list); 
			dbcon.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString() ;
	}
	
	public String getScoreBySid(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.MONTH,-1); 
			Date oneMonthAgoDate = cal.getTime(); 

			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
	
			String sql = "SELECT s1.*,s2.name as subjectname,e.*,st.* FROM score_new s1, subject s2 ,exam e ,student st where s1.subjectid = s2.id "+
                       " and s1.examid = e.id and e.displaystatus = 4 and st.sid = '"+sid+"' and s1.sid=st.sid and st.status=1 and st.dividestatus=0 order by subjectname asc,examdate asc ";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
					 Object obj = rs.getObject(i);
					 if(obj == null )obj = "";
				  rowData.put(md.getColumnName(i), obj.toString());
			     }
				   list.add(rowData);  
				}
			  jsonarray = JSONArray.fromObject(list); 
			dbcon.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	public String getNoticeByCid(String classname){
		if(classname.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.MONTH,-1); 
			Date oneMonthAgoDate = cal.getTime(); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql = "SELECT n.*,t.* FROM notice n , tclass t "+
                        " where n.classid = t.id and t.tname = '"+classname+"' and n.publishdate >='"+df.format(oneMonthAgoDate)+"' and ( status=3 or status = 2 )";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
				  rowData.put(md.getColumnName(i), rs.getObject(i));
			     }
				   list.add(rowData);  
				}
			  jsonarray = JSONArray.fromObject(list); 
			  dbcon.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	public String getParentsNoticeBySid(String sid){
		String str="";
		String str1="";
		String str2="";
		
		if(sid.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {			
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql = "select n.*,t.*,s.* FROM notice n ," +
					     "tclass t,student s where n.classid = t.id and t.tname =s.classname and s.sid='"+sid+"'and s.dividestatus=0 and s.status=1 and n.status=2";	
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
					 System.out.println(md.getColumnName(i));
					 System.out.println(rs.getObject(i));
				  rowData.put(md.getColumnName(i), rs.getObject(i));
			     }
				   list.add(rowData);  
				}
			  rs.last();
			dbcon.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JDBCConnection dbcon1 = new JDBCConnection();
			Connection con1 = dbcon1.openConnection();
			Statement sm1 = con1.createStatement();
			//通知所有人的通知
			String sql1="select n.* FROM notice n "+
					" where n.classid =0 and n.userid='0' and status=2";
			ResultSet rs1 = sm1.executeQuery(sql1);
			ResultSetMetaData md = rs1.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs1.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
				  rowData.put(md.getColumnName(i), rs1.getObject(i));
			     }
				   list.add(rowData);  
				}
			  jsonarray = JSONArray.fromObject(list);
			 rs1.last();
			dbcon1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
/*	public String getParentsNoticeBySid(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
		String stuStr = "[";
		try {			
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql = "select n.type,n.publishdate, n.title, n.content,n.username,n.readstatus,n.userid,n.noticetype,n.classid FROM notice n ,tclass t,student s "+
                          " where n.classid = t.id and t.tname =s.classname and s.sid='"+sid+"' and n.status=2";	
			String sql = "select t.tname,s.classname, n.type,n.publishdate, n.title, n.content,n.username,n.readstatus,n.userid,n.noticetype,n.classid FROM notice n ," +
					"tclass t,student s where n.classid = t.id and t.tname =s.classname and s.sid='"+sid+"'and s.dividestatus=0 and s.status=1 and n.status=2";	
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()){
				Integer type=rs.getInt("type");
				String phaseidStr = "";
				if(null==type.toString()){
					phaseidStr="";
				}else{
					phaseidStr = type.toString();
				}
				stuStr = stuStr + "type="+phaseidStr+",";
				
				String publishdate = rs.getString("publishdate");
				if(null == publishdate){
					publishdate = "";
				}
				stuStr = stuStr + "publishdate="+publishdate+",";
				
				String title = rs.getString("title");
				if(null == title){
					title = "";
				}
				stuStr = stuStr + "title="+title+",";
				
				String content = rs.getString("content");
				if(null == content){
					content = "";
				}
				stuStr = stuStr + "content="+content+",";
				
				String username=rs.getString("username");
				if(null==username){
					username="";
				}
				stuStr = stuStr + "username="+username+",";
				
				String readstatus=rs.getString("readstatus");
				if(null==readstatus){
					readstatus="";
				}
				stuStr = stuStr + "readstatus="+readstatus+",";
				
				String noticetype=rs.getString("noticetype");
				if(null==noticetype){
					noticetype="";
				}
				stuStr = stuStr + "noticetype="+noticetype+",";
				
				stuStr += ";";
			}
			rs.last();
			dbcon.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JDBCConnection dbcon1 = new JDBCConnection();
			Connection con1 = dbcon1.openConnection();
			Statement sm1 = con1.createStatement();
			//通知所有人的通知
			String sql1="select n.type,n.publishdate, n.title, n.content,n.username,n.readstatus,n.userid,n.noticetype,n.classid FROM notice n "+
					" where n.classid =0 and n.userid='0' and status=2";
			ResultSet rs1 = sm1.executeQuery(sql1);
			while(rs1.next()){
				Integer type=rs1.getInt("type");
				String phaseidStr = "";
				if(null==type.toString()){
					phaseidStr="";
				}else{
					phaseidStr = type.toString();
				}
				stuStr = stuStr + "type="+phaseidStr+",";
				
				String publishdate = rs1.getString("publishdate");
				if(null == publishdate){
					publishdate = "";
				}
				stuStr = stuStr + "publishdate="+publishdate+",";
				
				String title = rs1.getString("title");
				if(null == title){
					title = "";
				}
				stuStr = stuStr + "title="+title+",";
				
				String content = rs1.getString("content");
				if(null == content){
					content = "";
				}
				stuStr = stuStr + "content="+content+",";
				
				String username=rs1.getString("username");
				if(null==username){
					username="";
				}
				stuStr = stuStr + "username="+username+",";
				
				String readstatus=rs1.getString("readstatus");
				if(null==readstatus){
					readstatus="";
				}
				stuStr = stuStr + "readstatus="+readstatus+",";
				
				String noticetype=rs1.getString("noticetype");
				if(null==noticetype){
					noticetype="";
				}
				stuStr = stuStr + "noticetype="+noticetype+",";
				
				stuStr += ";";
			}
			rs1.last();
			dbcon1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated catch block
		stuStr = stuStr + "]";
		System.out.println(stuStr);
		return stuStr;
	}
*/	public String getNoticeBySid(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
		JSONArray jsonarray=null;
		List list=new ArrayList();
		try {			
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();	
			//String sql = "select n.*,t.*,s.* FROM notice n ,tclass t,student s " +
			//		    " where n.classid = t.id and t.tname =s.classname and s.sid='"+sid+"' and s.status=1 and s.dividestatus=0 and n.status=2";	
			String sql = "select n.*,t.tname,s.name FROM notice n ,tclass t,student s " +
		    " where n.classid = t.id and t.tname =s.classname and s.sid='"+sid+"' and s.status=1 and s.dividestatus=0 and n.status=2";	
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			while(rs.next()){
					Integer id=rs.getInt("id");
					
					Map rowData = new HashMap();
					 for (int i = 1; i <= columnCount; i++) {
					  rowData.put(md.getColumnName(i), rs.getObject(i));
					}
					list.add(rowData); 
					new ServiceImpl().insertNoticeSid(id,sid);	
	             }
				 jsonarray = JSONArray.fromObject(list); 
			     rs.last();
			     dbcon.closeConnection();
		  } catch (Exception e) {
			e.printStackTrace();
		}
		/* try {
					JDBCConnection dbcon1 = new JDBCConnection();
					Connection con1 = dbcon1.openConnection();
					Statement sm1 = con1.createStatement();
					String sql1="select n.id,n.type,n.publishdate, n.title, n.content,n.username,n.readstatus,n.userid,n.noticetype,n.classid FROM notice n "+
							" where n.classid =0 and n.userid='0' and status=2";
					ResultSet rs1 = sm1.executeQuery(sql1);
					ResultSetMetaData md = rs1.getMetaData();
					int columnCount = md.getColumnCount(); //Map rowData;
					 while(rs1.next()){
						 Integer id=rs1.getInt("id");
					     new ServiceImpl().insertNoticeSid(id,sid);	
						 Map rowData = new HashMap();
						 for (int i = 1; i <= columnCount; i++) {
						  rowData.put(md.getColumnName(i), rs1.getObject(i));
					     }
						   list.add(rowData);  
						}
					 jsonarray = JSONArray.fromObject(list); 
					rs1.close();
					dbcon1.closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}*/

		return jsonarray.toString();
	}
	 public int insertNoticeSid(Integer id,String sid){
		 int rows=0;
		 PreparedStatement pstm=null;
		 String readstatus="";
		 String totalreadstatus="";
		try {
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql="select * from notice where id='"+id+"'";
			ResultSet rs=sm.executeQuery(sql);
			while(rs.next()){
			   readstatus=rs.getString("readstatus");
			}
			if(null == readstatus)readstatus="";
			con.close();
			String[] readstatuses=readstatus.split(",");
		    List list= Arrays.asList(readstatuses);
			JDBCConnection dbcon1 = new JDBCConnection();
			Connection con1 = dbcon1.openConnection();
			if(!list.contains(sid)){
				if(readstatus.equals("0")){
					readstatus=sid;
					totalreadstatus=readstatus;
				} else{
					totalreadstatus=readstatus+","+sid;
				}
				String sql1="update notice set readstatus=? where id=?";
				pstm=con1.prepareStatement(sql1);  
				pstm.setString(1, totalreadstatus);
				pstm.setInt(2, id);
				rows=pstm.executeUpdate();
				con1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;  
		 
	 }	 
	public String getNotice(){
		JSONArray jsonarray = null;
		List list = new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.MONTH,-1); 
			Date oneMonthAgoDate = cal.getTime(); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql = "select * from notice where publishdate >='"+df.format(oneMonthAgoDate)+"' and status=2";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
				  rowData.put(md.getColumnName(i), rs.getObject(i));
			     }
				   list.add(rowData);  
				}
			  jsonarray = JSONArray.fromObject(list); 
			  dbcon.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	
	public String getAdvice(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.YEAR,-1);
			//cal.add(Calendar.MONTH,-1); 
			Date oneYearAgoDate = cal.getTime(); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			if( new ServiceImpl().existstudent(sid)){
				String sql = "SELECT * FROM advice where username = '"+sid+"' and createdate >='"+df.format(oneYearAgoDate)+"'";
				ResultSet rs = sm.executeQuery(sql);
				ResultSetMetaData md = rs.getMetaData();
				int columnCount = md.getColumnCount(); //Map rowData;
				 while(rs.next()){
					 Map rowData = new HashMap();
					 for (int i = 1; i <= columnCount; i++) {
					  rowData.put(md.getColumnName(i), rs.getObject(i));
				     }
					   list.add(rowData);  
					}
				  jsonarray = JSONArray.fromObject(list); 
				dbcon.closeConnection();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	/**
	 * 查看学生是否离职
	 * @param sid
	 * @return
	 */
	public boolean existstudent(String sid){
		  boolean flag=false;
		try {
			JDBCConnection dbcon = new JDBCConnection();
			Connection con= dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql="select  * from  student where sid='"+sid+"' and status=1 and dividestatus=0 ";
			ResultSet rs = sm.executeQuery(sql);
			if(rs.next()){
				flag=true;
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public String getJZLetter(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.YEAR,-1);
			//cal.add(Calendar.MONTH,-1); 
			Date oneYearAgoDate = cal.getTime(); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			 if(new ServiceImpl().existstudent(sid)){
				String sql= "SELECT * FROM jzletter where FIND_IN_SET('"+sid+"',sid)";
				 ResultSet rs = sm.executeQuery(sql);
				 ResultSetMetaData md = rs.getMetaData();
				 int columnCount = md.getColumnCount(); //Map rowData;
			     while(rs.next()){
						 Map rowData = new HashMap();
						 for (int i = 1; i <= columnCount; i++) {
						  rowData.put(md.getColumnName(i), rs.getObject(i));
					     }
						   list.add(rowData);  
						}
					  jsonarray = JSONArray.fromObject(list);
				 dbcon.closeConnection();
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	
	public String makeAdvice(String username, String content){
		try {
			Date nowDate = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowStr = df.format(nowDate);

			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql = "insert into advice (content, username, createdate) values('"+content+"', '"+username+"', '"+nowStr+"')";
			sm.executeUpdate(sql);
			dbcon.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
		return "SUCCESS";
	}
	
	public String getAdjust(String classname){
		if(classname.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.YEAR,-1);
			Date oneYearAgoDate = cal.getTime(); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql = "SELECT * FROM adjust where classname = '"+classname+"' ";
/*			String sql = "SELECT id, classname, subjectname, teachername, " +
					" datebefore, starttimebefore, endtimebefore, dateafter, starttimeafter, " +
					" endtimeafter,tknumber, reason,edureason,deanreason,s_status,v_id,publishdate,status FROM adjust ad where ad.classname = '"+classname+"' ";
*/			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
				  rowData.put(md.getColumnName(i), rs.getObject(i));
			     }
				   list.add(rowData);  
				}
			  jsonarray = JSONArray.fromObject(list); 
			  dbcon.closeConnection();
		   } catch (Exception e) {
						// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return jsonarray.toString();
	}
	
	public String getRewardBySid(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
		 JSONArray jsonarray=null;
		 List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.MONTH,-1); 
			Date oneMonthAgoDate = cal.getTime(); 
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
		   //if(new ServiceImpl().existstudent(sid)){
			String sql = "SELECT * from reward where sid='"+sid+"' order by rdate DESC";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			int count = 0;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
					 Object obj = rs.getObject(i);
					 if(null == obj){
						 rowData.put(md.getColumnName(i), "");
					 }else{
						 rowData.put(md.getColumnName(i),obj.toString());
					 }
			     }
				 count = count + 1;
				   list.add(rowData);  
				}
			 if(count == 0){
					list.add("no such a student in database");
				}
			  jsonarray = JSONArray.fromObject(list); 
			dbcon.closeConnection();
	     // }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
	public String getpunishBySid(String sid){
		if(sid.contains("or")){
			return "参数不合法";
		}
		JSONArray jsonarray=null;
		List list=new ArrayList();
		try {
			Date nowDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowDate);
			cal.add(Calendar.MONTH,-1); 
			Date oneMonthAgoDate = cal.getTime(); 
			JDBCConnection dbcon = new JDBCConnection();
			Connection con = dbcon.openConnection();
			Statement sm = con.createStatement();
			 //if(new ServiceImpl().existstudent(sid)){
			String sql = "SELECT * from punish where sid='"+sid+"' order by pdate DESC";
			ResultSet rs = sm.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount(); //Map rowData;
			int count = 0;
			 while(rs.next()){
				 Map rowData = new HashMap();
				 for (int i = 1; i <= columnCount; i++) {
					 Object obj = rs.getObject(i);
					 if(null == obj){
						 rowData.put(md.getColumnName(i), "");
					 }else{
						 rowData.put(md.getColumnName(i), obj.toString());
					 }
				  
			     }
				 count = count + 1;
				 list.add(rowData);  
				}
			 if(count == 0){
					list.add("no such a student in database");
				}
			 jsonarray = JSONArray.fromObject(list); 
			 
			 
			  
			 dbcon.closeConnection();
	      //}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray.toString();
	}
}
