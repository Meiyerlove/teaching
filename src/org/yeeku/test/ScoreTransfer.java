package org.yeeku.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.yeeku.JDBCConnection;

public class ScoreTransfer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCConnection dbCon = new JDBCConnection();
		try {
			Connection con = dbCon.openConnection();
			Statement sm = con.createStatement();
			Statement sm2 = con.createStatement();
			Statement sm3 = con.createStatement();
			String sql = "select * from score ;";
			ResultSet rs = sm.executeQuery(sql);
            int count = 0;
				while(rs.next()){
					//if(count > 0)break;
					String sid = rs.getString("sid");
					Integer subjectid = rs.getInt("subjectid");
					Date examdate = rs.getDate("examdate");
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String examdateStr = df.format(examdate);
					System.out.println(examdate);
					//Integer examid = rs.getInt("examid");
					Integer classkey = rs.getInt("classkey");
					Integer phaseid = rs.getInt("phaseid");
					String exam1 = rs.getString("exam1");
					
					if(null != exam1 && !exam1.equals("")){
						String examsql = "select * from exam where subjectid = "+subjectid+" and examtype = 1 and phaseid = "+phaseid+" and classkey = "+classkey;
						ResultSet examrs = sm3.executeQuery(examsql);
						Integer scoretype = null;
						Integer examid = null;
						String major = null;
						while(examrs.next()){
							scoretype = examrs.getInt("scoretype");
							examid = examrs.getInt("id");
							major = examrs.getString("title");
						}
						
						String insertsql = "insert into score_new( sid, subjectid, examdate, classkey, examid, result, " +
								                      "examtype, major, phaseid, scoretype, buttonstatus, baifenresult) values " +
								                              " ('"+sid+"',"+subjectid+",'"+examdateStr+"',"+classkey+","+examid+",'"+exam1+"', " +
								                              		" '1', '"+major+"', "+phaseid+", "+scoretype+", '2', null );";
						sm2.executeUpdate(insertsql);
					}
					String exam2 = rs.getString("exam2");
					if(null != exam2 && !exam2.equals("")){
						String examsql = "select * from exam where subjectid = "+subjectid+" and examtype = 2 and phaseid = "+phaseid+" and classkey = "+classkey;
						ResultSet examrs = sm3.executeQuery(examsql);
						Integer scoretype = null;
						Integer examid = null;
						String major = null;
						while(examrs.next()){
							scoretype = examrs.getInt("scoretype");
							examid = examrs.getInt("id");
							major = examrs.getString("title");
						}
						
						String insertsql = "insert into score_new( sid, subjectid, examdate, classkey, examid, result, " +
								                      "examtype, major, phaseid, scoretype, buttonstatus, baifenresult) values " +
								                              " ('"+sid+"',"+subjectid+",'"+examdateStr+"',"+classkey+","+examid+",'"+exam2+"', " +
								                              		" '2', '"+major+"', "+phaseid+", "+scoretype+", '2', null );";
						sm2.executeUpdate(insertsql);
					}
					String exam3 = rs.getString("exam3");
					if(null != exam3 && !exam3.equals("")){
						String examsql = "select * from exam where subjectid = "+subjectid+" and examtype = 3 and phaseid = "+phaseid+" and classkey = "+classkey;
						ResultSet examrs = sm3.executeQuery(examsql);
						Integer scoretype = null;
						Integer examid = null;
						String major = null;
						while(examrs.next()){
							scoretype = examrs.getInt("scoretype");
							examid = examrs.getInt("id");
							major = examrs.getString("title");
						}
						
						String insertsql = "insert into score_new( sid, subjectid, examdate, classkey, examid, result, " +
								                      "examtype, major, phaseid, scoretype, buttonstatus, baifenresult) values " +
								                              " ('"+sid+"',"+subjectid+",'"+examdateStr+"',"+classkey+","+examid+",'"+exam3+"', " +
								                              		" '3', '"+major+"', "+phaseid+", "+scoretype+", '2', null );";
						sm2.executeUpdate(insertsql);
					}
					String exam4 = rs.getString("exam4");
					if(null != exam4 && !exam4.equals("")){
						String examsql = "select * from exam where subjectid = "+subjectid+" and examtype = 4 and phaseid = "+phaseid+" and classkey = "+classkey;
						ResultSet examrs = sm3.executeQuery(examsql);
						Integer scoretype = null;
						Integer examid = null;
						String major = null;
						while(examrs.next()){
							scoretype = examrs.getInt("scoretype");
							examid = examrs.getInt("id");
							major = examrs.getString("title");
						}
						
						String insertsql = "insert into score_new( sid, subjectid, examdate, classkey, examid, result, " +
								                      "examtype, major, phaseid, scoretype, buttonstatus, baifenresult) values " +
								                              " ('"+sid+"',"+subjectid+",'"+examdateStr+"',"+classkey+","+examid+",'"+exam4+"', " +
								                              		" '4', '"+major+"', "+phaseid+", "+scoretype+", '2', null );";
						sm2.executeUpdate(insertsql);
					}
					String exam5 = rs.getString("exam5");
					if(null != exam5 && !exam5.equals("")){
						String examsql = "select * from exam where subjectid = "+subjectid+" and examtype = 5 and phaseid = "+phaseid+" and classkey = "+classkey;
						ResultSet examrs = sm3.executeQuery(examsql);
						Integer scoretype = null;
						Integer examid = null;
						String major = null;
						while(examrs.next()){
							scoretype = examrs.getInt("scoretype");
							examid = examrs.getInt("id");
							major = examrs.getString("title");
						}
						
						String insertsql = "insert into score_new( sid, subjectid, examdate, classkey, examid, result, " +
								                      "examtype, major, phaseid, scoretype, buttonstatus, baifenresult) values " +
								                              " ('"+sid+"',"+subjectid+","+examdateStr+","+classkey+","+examid+",'"+exam5+"', " +
								                              		" '5', '"+major+"', "+phaseid+", "+scoretype+", '2', null );";
						sm2.executeUpdate(insertsql);
					}
					String exam6 = rs.getString("exam6");
					if(null != exam6 && !exam6.equals("")){
						String examsql = "select * from exam where subjectid = "+subjectid+" and examtype = 6 and phaseid = "+phaseid+" and classkey = "+classkey;
						ResultSet examrs = sm3.executeQuery(examsql);
						Integer scoretype = null;
						Integer examid = null;
						String major = null;
						while(examrs.next()){
							scoretype = examrs.getInt("scoretype");
							examid = examrs.getInt("id");
							major = examrs.getString("title");
						}
						
						String insertsql = "insert into score_new( sid, subjectid, examdate, classkey, examid, result, " +
								                      "examtype, major, phaseid, scoretype, buttonstatus, baifenresult) values " +
								                              " ('"+sid+"',"+subjectid+","+examdateStr+","+classkey+","+examid+",'"+exam6+"', " +
								                              		" '6', '"+major+"', "+phaseid+", "+scoretype+", '2', null );";
						sm2.executeUpdate(insertsql);
					}
					String exam7 = rs.getString("exam7");
					if(null != exam7 && !exam7.equals("")){
						String examsql = "select * from exam where subjectid = "+subjectid+" and examtype = 7 and phaseid = "+phaseid+" and classkey = "+classkey;
						ResultSet examrs = sm3.executeQuery(examsql);
						Integer scoretype = null;
						Integer examid = null;
						String major = null;
						while(examrs.next()){
							scoretype = examrs.getInt("scoretype");
							examid = examrs.getInt("id");
							major = examrs.getString("title");
						}
						
						String insertsql = "insert into score_new( sid, subjectid, examdate, classkey, examid, result, " +
								                      "examtype, major, phaseid, scoretype, buttonstatus, baifenresult) values " +
								                              " ('"+sid+"',"+subjectid+","+examdateStr+","+classkey+","+examid+",'"+exam7+"', " +
								                              		" '7', '"+major+"', "+phaseid+", "+scoretype+", '2', null );";
						sm2.executeUpdate(insertsql);
					}
					String exam8 = rs.getString("exam8");
					if(null != exam8 && !exam8.equals("")){
						String examsql = "select * from exam where subjectid = "+subjectid+" and examtype = 8 and phaseid = "+phaseid+" and classkey = "+classkey;
						ResultSet examrs = sm3.executeQuery(examsql);
						Integer scoretype = null;
						Integer examid = null;
						String major = null;
						while(examrs.next()){
							scoretype = examrs.getInt("scoretype");
							examid = examrs.getInt("id");
							major = examrs.getString("title");
						}
						
						String insertsql = "insert into score_new( sid, subjectid, examdate, classkey, examid, result, " +
								                      "examtype, major, phaseid, scoretype, buttonstatus, baifenresult) values " +
								                              " ('"+sid+"',"+subjectid+","+examdate+","+classkey+","+examid+",'"+exam8+"', " +
								                              		" '8', '"+major+"', "+examdateStr+", "+scoretype+", '2', null );";
						sm2.executeUpdate(insertsql);
					}
					++count;
				}
				System.out.println("score 数据转移转化成功");
			    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dbCon.closeConnection();
		}

	}

}
