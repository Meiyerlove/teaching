package james;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionSample {
    public static void main(String[] args) {
    	/*System.out.println(args.length);
		if(1!=args.length){
			System.err.println("Usage:java URLConnectionSample url");
			return ;
		}*/                                 
	try {
			//URL url=new URL(args[0]);
		    URL url=new URL("http://www.baidu.com");
			URLConnection con;
			//try {
				con = url.openConnection();
				con.connect();
				
				System.out.println("Content type:"+con.getContentType());
				System.out.println("Content Encoding:"+con.getContentEncoding());
				System.out.println("Content:"+con.getContent());
				System.out.println("Date:"+new Date(con.getDate()));
				System.out.println("Last Modified:"+new Date(con.getLastModified()));	
				System.out.println("Expiration:"+new Date(con.getExpiration()));
				if(con instanceof HttpURLConnection){
					HttpURLConnection h=(HttpURLConnection) con;
					System.out.println("Request Method:"+h.getRequestMethod());
					System.out.println("Response Message:"+h.getResponseMessage());
					System.out.println("Response Code:"+h.getResponseCode());
				}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

