package org.yeeku.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author zengjiuzhou@163.com
 * 
 */
public class BaseConfig {
	private static final Log log = LogFactory.getLog(BaseConfig.class);

	protected static String configFileName = "database.properties";

	protected static Properties props = null;

	public BaseConfig() {
	}

	public String getConfigFileName() {
		return configFileName;
	}

	public void setConfigFileName(String configFileName) {
		BaseConfig.configFileName = configFileName;
	}

	public static void init(String filename) {
		if (filename.indexOf('.') == -1) {
			filename += ".properties";
		}
		configFileName = filename;
		String basepath = BaseConfig.class.getResource("/").getPath();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(basepath + configFileName);
			props = new Properties();
			props.load(fis);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					log.error(e, e);
				}
			}
		}
	}

	public static void setProperty(String name, String value) {
		props.setProperty(name, value);
	}

	public static String getProperty(String name) {
		if (props == null) {
			init(configFileName);
		}
		return getProperty(name, "");
	}

	public static String getProperty(String name, String defalutValue) {
		if (props == null) {
			init(configFileName);
		}
		return props.getProperty(name, defalutValue);
	}

	public static int getProperty(String name, int defalutValue) {
		if (props == null) {
			init(configFileName);
		}
		return Integer.valueOf(props.getProperty(name), defalutValue);
	}

	public  void update() {
		FileOutputStream fos = null;
		try {
			String basepath = BaseConfig.class.getResource("/").getPath();
			fos = new FileOutputStream(basepath + configFileName);
			props.store(fos, "");
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					log.error(e, e);
				}
			}
		}
	}

	public static void putProperties(Map props) {
		BaseConfig.props.putAll(props);
	}

	public static Properties getProperties() {
		return props;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(BaseConfig.getProperty("username"));
		System.out.println(BaseConfig.getProperty("password"));
		// Config.update();
	}
}