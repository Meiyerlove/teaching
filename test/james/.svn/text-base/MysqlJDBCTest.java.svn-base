package james;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.yeeku.test.BaseConfig;

public class MysqlJDBCTest {
	
	private String driverClass = "net.sourceforge.jtds.jdbc.Driver";

    private Connection connection;

    public MysqlJDBCTest() {
    }

    public Connection openConnection() throws SQLException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	//Class.forName("com.mysql.jdbc.Driver").newInstance();
        	BaseConfig bc = new BaseConfig();
        	//String username = bc.getProperty("username");
        	//String password = bc.getProperty("password");
        	
        	String username = "root";
        	String password = "chunrong2015";
            String url="jdbc:mysql://120.24.175.81:3306/teaching?useUnicode=true&characterEncoding=gbk&user="+username+"&password="+password;
            // String url="jdbc:mysql://localhost:3306/teaching?user="+username+"&password="+password;
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
    
    public static void main(String args[]){
    	try{
    		MysqlJDBCTest dbCon = new MysqlJDBCTest();
        	Connection con = dbCon.openConnection();
        	if(con != null)System.out.println("成功");
        	String sql ="{call dabiao();}";
			String sid = "";
			//PreparedStatement  sm = con.prepareStatement(sql);
			CallableStatement  cstmt = con.prepareCall("{call dabiao();}");  
		     //   call.setString(1, "test");  
			cstmt.execute();
			ResultSet rs = cstmt.getResultSet();
			//Boolean haveMore = cstmt.getMoreResults();
			//System.out.println(haveMore);
			while (rs.next()) {
				System.out.println("sid1:" + rs.getString(1));
			}
			if (cstmt.getMoreResults() == true) {

				rs = cstmt.getResultSet();
				while (rs.next()) {
					System.out.println("sid2:" + rs.getString(1));
				}
			}
        	dbCon.closeConnection();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public int count(){
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 	    String nowResult=dateFormat.format(new Date());
 	    String str=nowResult.substring(0, 4);
 	    String str1=nowResult.substring(5, 7);
 	    String str2=nowResult.substring(8, 10);
 	    String tk=str+str1+str2;
 	    System.out.println("tk----"+tk);
    	 int count=0;
    	 String sid = "";
    		MysqlJDBCTest dbcon = new MysqlJDBCTest();
			Connection con;
			try {
				con = dbcon.openConnection();
				Statement sm = con.createStatement();
				
				//String sql ="SELECT COUNT(1) count FROM adjust WHERE tknumber LIKE 'TK"+tk+"%'";
				String sql ="SET @EE='';SELECT @EE:=CONCAT(@EE,'MAX(IF(examtype=\'',examtype,'\'',',result,NULL)) AS ',subjectid,split,phaseid,split,examtype,',')  FROM (SELECT subjectid,phaseid,examtype,'ZZZ' AS split FROM score_new GROUP BY subjectid,phaseid,examtype ) A; SET @QQ=CONCAT('SELECT ifnull(score_new.sid,\'total\') AS sid, examdate,classkey,examid,major,scoretype,',LEFT(@EE,LENGTH(@EE)-1),' FROM score_new GROUP BY sid');PREPARE stmt  FROM @QQ; EXECUTE stmt ;";
				
				
				ResultSet rs = sm.executeQuery(sql);
				while(rs.next()){
					 //count=rs.getInt("count");
					 sid=rs.getString("sid");
					 //System.out.println("num----"+num);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbcon.closeConnection();
    	 return count;
    	 
     }

}
