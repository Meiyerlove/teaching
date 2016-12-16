package org.yeeku.model;

public class Jieke {
	
	private Integer weekdayid;
	private Kecheng kecheng;
	private Integer lessonid;
	public Kecheng getKecheng() {
		return kecheng;
	}
	public void setKecheng(Kecheng kecheng) {
		this.kecheng = kecheng;
	}
	public Integer getWeekdayid() {
		return weekdayid;
	}
	public void setWeekdayid(Integer weekdayid) {
		this.weekdayid = weekdayid;
	}
	public Integer getLessonid() {
		return lessonid;
	}
	public void setLessonid(Integer lessonid) {
		this.lessonid = lessonid;
	}
}
