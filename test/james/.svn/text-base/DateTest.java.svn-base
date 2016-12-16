package james;

import java.util.Date;

import org.yeeku.util.DateTimeUtil;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date nowDate = new Date(System.currentTimeMillis());
		DateTimeUtil dtu = new DateTimeUtil();
		Date startDate = dtu.getStartDate(nowDate);
		Date endDate = dtu.getEndDate(nowDate);
		System.out.println(startDate);
		System.out.println(endDate);
		//System.out.println(sdw.format(nowDate));

	}

	// 实现给定某日期，判断是星期几
	/*public static String getWeekday(String date) {// 必须yyyy-MM-dd
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date d = null;
		try {
			d = sd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdw.format(d);
	}*/

}
