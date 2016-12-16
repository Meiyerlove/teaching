package com.bw30.zjvote.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager configManager=new ConfigManager();
    private static Properties properties;
 
  private ConfigManager(){
	 String config="database.properties";
	 properties=new Properties();
	 InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream(config);
	 try {
		properties.load(is);
		is.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }
   public static ConfigManager getInstance(){
	   return configManager;
   }
   public String getString(String key){
	   return properties.getProperty(key);
   }
   
}
