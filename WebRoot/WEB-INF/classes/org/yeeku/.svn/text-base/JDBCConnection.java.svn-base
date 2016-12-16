package org.yeeku;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.yeeku.model.ScoreNew;
import org.yeeku.test.BaseConfig;

public class JDBCConnection {
	
	private String driverClass = "net.sourceforge.jtds.jdbc.Driver";

    private Connection connection;

    public JDBCConnection() {
    }

    public Connection openConnection() throws SQLException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	//Class.forName("com.mysql.jdbc.Driver").newInstance();
        	BaseConfig bc = new BaseConfig();
        	String dbip = bc.getProperty("url");
        	String username = bc.getProperty("username");
        	String password = bc.getProperty("password");
            // String url="jdbc:mysql://120.24.175.81:3306/teaching?useUnicode=true&characterEncoding=gbk&user="+username+"&password="+password;
        	String url = dbip+"&user="+username+"&password="+password;
            connection = DriverManager.getConnection(url);        
            return connection;
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void closeConnection() {
        try {        
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  /*  public static void main(String args[]){
    	try{
    		JDBCConnection dbCon = new JDBCConnection();
        	Connection con = dbCon.openConnection();
        	if(con != null)System.out.println("成功");
        	dbCon.closeConnection();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }*/
    public int count(){
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 	    String nowResult=dateFormat.format(new Date());
 	    String str=nowResult.substring(0, 4);
 	    String str1=nowResult.substring(5, 7);
 	    String str2=nowResult.substring(8, 10);
 	    String tk=str+str1+str2;
 	    System.out.println("tk----"+tk);
    	 int count=0;
    		JDBCConnection dbcon = new JDBCConnection();
			Connection con;
			try {
				con = dbcon.openConnection();
				Statement sm = con.createStatement();
				String sql ="SELECT COUNT(1) count FROM adjust WHERE tknumber LIKE 'TK"+tk+"%'";
				ResultSet rs = sm.executeQuery(sql);
				while(rs.next()){
					 count=rs.getInt("count");
					//System.out.println("num----"+num);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbcon.closeConnection();
    	 return count;
    	 
     }
    public int Resultcount(String sid){
    	 int count=0;
    	 JDBCConnection dbcon = new JDBCConnection();
    	 Connection con = null;
    	try {
		    con=dbcon.openConnection();
			Statement sm = con.createStatement();
			String sql="select count(*) count from score_new where sid='"+sid+"' and result='P'";
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()){
				// String examdate=rs.getString("examdate");
				// System.out.println(examdate);
				 count=rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    	 try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
    	
    	
    }
    
    public List<ScoreNew> subjectidNonhundredlist(Integer classkey){
    	List<ScoreNew> scorenewlist=new ArrayList<ScoreNew>();
    	ScoreNew score=null;
   	 JDBCConnection dbcon = new JDBCConnection();
   	 Connection con = null;
   	try {
		    con=dbcon.openConnection();
			Statement sm = con.createStatement();
			//String sql="SELECT  COUNT(DISTINCT subjectid) count FROM score_new WHERE classkey="+classkey;
			String sql="SELECT DISTINCT subjectid FROM  score_new WHERE scoretype=2 AND classkey="+classkey;
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()){
				score=new ScoreNew();
			    Integer subjectid=rs.getInt("subjectid");
			    score.setSubjectid(subjectid);
			    scorenewlist.add(score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
   	 try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scorenewlist;
   }
    public List<ScoreNew> subjectidHundredlist(Integer classkey){
    	List<ScoreNew> scorenewlist=new ArrayList<ScoreNew>();
    	ScoreNew score=null;
    	JDBCConnection dbcon = new JDBCConnection();
    	Connection con = null;
    	try {
    		con=dbcon.openConnection();
    		Statement sm = con.createStatement();
    		String sql="SELECT DISTINCT subjectid FROM  score_new WHERE scoretype in (1,3) and classkey="+classkey;
    		ResultSet rs = sm.executeQuery(sql);
    		while(rs.next()){
    			score=new ScoreNew();
    			Integer subjectid=rs.getInt("subjectid");
    			score.setSubjectid(subjectid);
    			scorenewlist.add(score);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}  
    	try {
    		con.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return scorenewlist;
    }
   /* public List<ScoreNew> getResultList(){
    	CallableStatement cstmt = null;
    	boolean moreResultSets = cstmt.execute(); 
    	while (moreResultSets) { 
    		ResultSet rs = cstmt.getResultSet(); 
    		ResultSetMetaData rsmd = rs.getMetaData();
    		StringBuffer buffer = new StringBuffer(); 
    		for (int i = 1; i <= rsmd.getColumnCount(); i++){ 
    			buffer.append(rsmd.getColumnName(i)).append("\t");
    			System.out.println(buffer.toString());
    			while (rs.next()) {
    				buffer.setLength(0); 
    				for (int i = 1; i <= rsmd.getColumnCount(); i++) 
    				buffer.append(rs.getString(i)).append("\t"); System.out.println(buffer.toString()); } }
    		   rs.close(); moreResultSets = cstmt.getMoreResults(); }
    	List<ScoreNew> scorenewlist=new ArrayList<ScoreNew>();
    	StringBuffer sb=new StringBuffer();
    	ScoreNew score=null;
    	JDBCConnection dbcon = new JDBCConnection();
    	Connection con = null;
        String sql="seelct * from ";
    	try {
    		con=dbcon.openConnection();
    		Statement sm = con.createStatement();
    		ResultSet rs = sm.executeQuery(sb.toString());
    		while(rs.next()){
    		
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}  
    	try {
    		con.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return scorenewlist;
    }*/
    
      public void getResult(){
    	  JDBCConnection dbcon = new JDBCConnection();
    	  CallableStatement cstmt = null;  
    	  ResultSet rs = null;  
    	  Connection conn = null;
    	  try{
          	Connection con = dbcon.openConnection();
          	if(con != null)System.out.println("成功");
          	String sql ="{call dabiao();}";
  			String sid = "";
  		    cstmt = con.prepareCall("{call dabiao();}");    
  			cstmt.execute();
  			 rs = cstmt.getResultSet();
  			 ResultSetMetaData rsmd = rs.getMetaData();
  		    int cols=rsmd.getColumnCount();
  		    String ResultRow="";
  		    for(int i=0;i<cols;i++){
  		    	ResultRow+=rsmd.getColumnName(i);
  		    }
  		    System.out.println("------"+ResultRow);
  				/*System.out.print("----"+ rsmd.getColumnLabel(1) + "\t" );
  				System.out.print( rsmd.getColumnName(1) + "\t" );*/
  				//System.out.println( rsmd.getColumnTypeName(1) );
  			while (rs.next()) {
  				System.out.println("sid1:" + rs.getString(1));
  			}
  			if (cstmt.getMoreResults() == true) {
  				rs = cstmt.getResultSet();
  				
  				while (rs.next()) {
  					String ResultRow1="";
  				   for(int i=0;i<cols;i++){
  					 ResultRow1+=rs.getString(i);
  					 System.out.println(ResultRow1);
  					//System.out.println("sid2:" + rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(7));
  				}
  				}
  			}
  			dbcon.closeConnection();
      	}catch(Exception e){
      		e.printStackTrace();
      	 }
      	}
      
      
      public void getJDBCtext(){
    	  JDBCConnection dbcon = new JDBCConnection();
    	  CallableStatement cstmt = null;  
    	  Connection conn = null;
    	  try{
          	Connection con = dbcon.openConnection();
          	if(con != null)System.out.println("成功");
  			String sql = "select * FROM SCORE_NEW";
  			Statement stam=con.createStatement();
  			ResultSet rs = stam.executeQuery(sql); 
  		    ResultSetMetaData rsmd = rs.getMetaData();
  		    int cols=rsmd.getColumnCount();
  		    String ResultRow="";
  		    for(int i=0;i<cols;i++){
  		    	ResultRow+=rsmd.getColumnName(i);
  		    }
  		    System.out.println("------"+ResultRow);
  				while (rs.next()) {
  					String ResultRow1="";
  				   for(int i=0;i<cols;i++){
  					 ResultRow1+=rs.getString(i);
  					 System.out.println(ResultRow1);
  				 }
  			}
  			dbcon.closeConnection();
      	}catch(Exception e){
      		e.printStackTrace();
      	 }
      	} 
      
    public static void main(String[] args) {
    	JDBCConnection dbCon = new JDBCConnection();
    	//List<ScoreNew> getResultList=dbCon.getResultList();
    	//System.out.println(row);
    	// dbCon.getResult();
    	 dbCon.getJDBCtext();
	}
    

}







