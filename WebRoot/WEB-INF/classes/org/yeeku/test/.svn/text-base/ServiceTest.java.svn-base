package org.yeeku.test;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.yeeku.Teaching;

public class ServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectServiceFactory objectFactory = new ObjectServiceFactory();
		Service srClass = objectFactory.create(Teaching.class);
		//String url = "http://localhost:8080/teaching/services/ServiceTest";
		String url = "http://120.24.175.81/exam/services/ServiceTest";
		//String url = "http://120.24.175.81/teaching/services/ServiceTest";
		XFireProxyFactory factory = new XFireProxyFactory(XFireFactory
				.newInstance().getXFire());

		try {
			Teaching name = (Teaching) factory.create(srClass, url);
			//测试该学生SID不存在的学生
			//System.out.println(name.getStudentBySid("c2015611002"));
			//测试该学生SID存在的学生
			//System.out.println(name.getStudentBySid("34123414"));
			
			
			/*System.out.println(name.getCurSch("12秋HND会计2班"));
			System.out.println(name.absenseBySid("2014665122"));
			System.out.println(name.getExamByCid("12秋HND会计2班"));
			System.out.println(name.getScoreBySid("2014665122"));
			
			System.out.println(name.getNotice());
			System.out.println(name.getNoticeByCid("12秋HND会计2班"));
			System.out.println(name.getAdvice("2014665122"));
			
			System.out.println(name.getJZLetter("2014665130"));*/
			//System.out.println(name.makeAdvice("c2015611002", "提建议接口"));
			//System.out.println(name.getExamByCid("2015级HND春季班"));
			
			//System.out.println("Adjust: "+name.getAdjust("2015级HND春季班"));
			//System.out.println(name.getScoreBySid("2015211071"));
			//System.out.println(name.absenseBySid("2015211071"));
			//System.out.println(name.getExamByCid("12秋HND会计2班"));
			//System.out.println(name.getNoticeBySid("2015211071"));
			//System.out.println(name.getpunishBySid("2015211071"));
			//System.out.println(name.getRewardBySid("2015211071"));
			System.out.println(name.getNoticeByCid("12秋HND会计2班"));
			
			System.out.println(" --- Service Test end --- ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


