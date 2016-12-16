package org.yeeku.dao.hibernate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.yeeku.dao.UserDao;
import org.yeeku.model.Absence;
import org.yeeku.model.Adjust;
import org.yeeku.model.Advice;
import org.yeeku.model.Assistant;
import org.yeeku.model.Classroom;
import org.yeeku.model.ClassroomApply;
import org.yeeku.model.Contract;
import org.yeeku.model.Cursch;
import org.yeeku.model.EnterApply;
import org.yeeku.model.EquCard;
import org.yeeku.model.ExClassRecord;
import org.yeeku.model.Exam;
import org.yeeku.model.HeInformation;
import org.yeeku.model.HrEmployee;
import org.yeeku.model.Ielts;
import org.yeeku.model.Jzletter;
import org.yeeku.model.Kecheng;
import org.yeeku.model.LetterTemplate;
import org.yeeku.model.Major;
import org.yeeku.model.ManualRecord;
import org.yeeku.model.Notice;
import org.yeeku.model.Punish;
import org.yeeku.model.Reward;
import org.yeeku.model.Score;
import org.yeeku.model.ScoreNew;
import org.yeeku.model.Student;
import org.yeeku.model.Subject;
import org.yeeku.model.TClass;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;

/**
 * @author yeeku.H.lee zengjiuzhou@163.com
 * @version 1.0 <br>
 *          Copyright (C), 2005-2008, yeeku.H.Lee <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: <br>
 *          Date:
 */
public class UserDaoHibernate extends HibernateDaoSupport implements UserDao {
	
	public User get(int id) {
		return (User) getHibernateTemplate().get(User.class, id);
		
	}
	
	@SuppressWarnings("rawtypes")
	public List getAllUser() {
		List ul = getHibernateTemplate().find(
				" from User au where au.userType != 1");
		return ul;
	}
	
	public Classroom findRoomByID(int id) {
		return (Classroom) getHibernateTemplate().get(Classroom.class, id);
	}

	
	public void save(User user) {
		getHibernateTemplate().save(user);
	}

	
	public void update(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	public void delete(int id) {
		getHibernateTemplate().delete(
				getHibernateTemplate().get(User.class, id));
	}

	
	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	public List<User> findAll() {
		return (List<User>) getHibernateTemplate().find("from User");
	}
	@SuppressWarnings("rawtypes")
	public User findUserByNameAndPass(String user, String pass) {
		List ul = getHibernateTemplate().find(
				"from User au where au.user = ? and au.pass = ?",
				new String[] { user, pass });
		if (ul != null && ul.size() >= 1) {
			return (User) ul.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public List findAllRecord(String startDate, String endDate) {
		List rl = getHibernateTemplate().
		   find("from Record r where r.consumeDate >=? and r.consumeDate <= ? " +
		   		"order by  r.consumeDate, r.equNO, r.consumeTime", new String[]{startDate,endDate});
		return rl;
	}
	
	@SuppressWarnings("rawtypes")
	public List getRoleRight(Integer roleid) {
		List rl = getHibernateTemplate().
		   find("from Right r, RoleRight rr where rr.roleid = ? and rr.rightcode = r.rightcode ", new Object[]{roleid});
		return rl;
	}
	
	@SuppressWarnings("rawtypes")
	public List getRoleRight(Integer roleid, String rightcode) {
		List rl = getHibernateTemplate().
		   find("from Right r, RoleRight rr where rr.roleid = ? and rr.rightcode = r.rightcode and r.rightcode = ?", new Object[]{roleid, rightcode});
		return rl;
	}
	
	@SuppressWarnings("rawtypes")
	public List getRoleList() {
		List rl = getHibernateTemplate().
		   find("from Role role ");
		return rl;
	}
	
	@SuppressWarnings("rawtypes")
	public List getNoticeListByClassid(Integer classid) {
		List rl = getHibernateTemplate().
		   find("from Notice notice where notice.classid = "+classid+" order by id desc");
		return rl;
	}
	
	@SuppressWarnings("rawtypes")
	public List getNoticeList() {
		List rl = getHibernateTemplate().
		   find("from Notice notice order by id desc");
		return rl;
	}
	@SuppressWarnings("rawtypes")
	public Notice getNoticeById(Integer id) {
		List rl = getHibernateTemplate().
				find("from Notice notice where notice.id=?",new Object[]{id});
		Notice notice=null;
		if(null != rl && rl.size() > 0){
			notice = (Notice) rl.get(0);
		}
		return notice;
		
	}
	@SuppressWarnings("rawtypes")
	public Major getMajorBymajorId(String majorid) {
		List rl = getHibernateTemplate().
				find("from Major m where m.majorid=?",new Object[]{majorid});
		Major major=null;
		if(null != rl && rl.size() > 0){
			major = (Major) rl.get(0);
		}
		return major;
		
	}
	
	@SuppressWarnings("rawtypes")
	public List getNoticeListByPublisherid(Integer publisherid) {
		List rl = getHibernateTemplate().
		   find("from Notice notice where notice.publisherid = "+publisherid+" order by id desc");
		return rl;
	}
	@SuppressWarnings("rawtypes")
	public List getNoticeListByPublisheridStatus(String noticetype,String username) {
		List rl = getHibernateTemplate().
				find("from Notice notice where notice.noticetype =? and notice.username=? and notice.status=1 order by notice.id desc",new Object[]{noticetype,username});
		return rl;
	}
	
	@SuppressWarnings("rawtypes")
	public List getStudentList() {
		List rl = getHibernateTemplate().
		   find("from Student student ");
		return rl;
	}
	@SuppressWarnings("rawtypes")
	public List getKechengList(Integer v_id) {
		List rl = getHibernateTemplate().
		   find("from Kecheng kc where kc.v_id="+v_id+"");
			
		return rl;
	}
	@SuppressWarnings("rawtypes")
	public List getAllkechenglist(String name){ 
		List rl = getHibernateTemplate().
			//find("from Kecheng kc,Kechengversion kv where kc.teacher='"+name+"' and  kc.v_id=kv.id and kv.isvalid=1 order by kc.v_id asc ");
		 find("select distinct kc.v_id from  Kecheng kc,Kechengversion kv where kc.teacher='"+name+"' and  kc.v_id=kv.id and kv.isvalid=1 order by kc.v_id asc ");
	
		return rl;
	}
	public List getAllkechenglist1(){ 
		List rl = getHibernateTemplate().
				find("from Kecheng kc,Kechengversion kv where kc.v_id=kv.id and kv.isvalid=1 order by kc.v_id asc ");
		
		return rl;
	}
	public List getSec_KechengList() {
		List rl = getHibernateTemplate().
				find("from Sec_Kecheng kc ");
		return rl;
	}
	public List getKechengby_subject_class_room(String username,String className,String classSubject,String classRoom,Integer v_id){
		List rl = getHibernateTemplate().
				find("select distinct kc.starttime,kc.endtime from Kecheng kc where kc.teacher=? and kc.classname=? and kc.subjectname=? and kc.classroom=? and kc.v_id=?",new Object[]{username,className,classSubject,classRoom,v_id});
		//Kecheng kecheng=null;
		/*if(rl!=null && rl.size()>0){
			kecheng=(Kecheng) rl.get(0);
		}*/
		return rl;
	}
	public Kecheng getKechengByStartime(String username, String className,
    		String classSubject, String classRoom, String startTime, Integer v_id){
		List rl = getHibernateTemplate().
				find("from Kecheng kc where kc.teacher=? and kc.classname=? and kc.subjectname=? and kc.classroom=? and kc.starttime=? and kc.v_id=?",new Object[]{username,className,classSubject,classRoom,startTime,v_id});
		 Kecheng kecheng=null;
		if(rl!=null && rl.size()>0){
			kecheng=(Kecheng) rl.get(0);
		}
		return kecheng;
	}
	public List getKechengList(String name,Integer v_id){ 
		List rl = getHibernateTemplate().
				//find("from Kecheng kc where kc.teacher=? and v_id=? ",new Object[]{name,v_id});
		        // find("select distinct kc.classname,kc.subjectname,kc.classroom ,kc.starttime,kc.endtime from Kecheng kc where kc.teacher=? and v_id=? ",new Object[]{name,v_id});
		        //find("select distinct kc.classname,kc.subjectname,kc.classroom from Kecheng kc where kc.teacher=? and v_id=? ",new Object[]{name,v_id});
		find("select kc.classname,kc.subjectname,kc.classroom, kc.id from Kecheng kc where kc.teacher=? and v_id=? ",new Object[]{name,v_id});
		return rl;
	}
	public List getSec_KechengListByVid(String name) {
		List rl = getHibernateTemplate().
				find("from Sec_Kecheng sc where sc.teacher=?",new Object[]{name});
		return rl;
	}
	public List getKechengListByVid(Integer vid){ 
		List rl = getHibernateTemplate().
				find("from Kecheng kc,Kechengversion kv where kc.v_id= "+vid+" and kv.id= "+vid+" and kv.isvalid=1");
		return rl;
	}
	public List getSec_KechengListByVid(Integer vid) {
		List rl = getHibernateTemplate().
				find("from Sec_Kecheng sc where sc.v_id=?",new Object[]{vid});
		return rl;
	}
	public List getKechengListById(Integer classroomsid) {
		List rl = getHibernateTemplate().
				find("from Kecheng kc where kc.id=?",new Object[]{classroomsid});
		return rl;
	}
	public List<Kecheng> getKechengListByTclassnameAndTeachername(String teachername,Integer versionId) {
		List<Kecheng> rl = getHibernateTemplate().
				find(" from Kecheng kc,Kechengversion kcv where kc.teacher= ? and kc.v_id=? and kc.v_id=kcv.id and kcv.isvalid=1",new Object[]{teachername,versionId});
		return rl;
	}
	public List getSec_KechengListById(Integer classroomsid) {
		List rl = getHibernateTemplate().
				find("from Sec_Kecheng sc where sc.id=?",new Object[]{classroomsid});
		return rl;
	}
	
	/*public List getKechengListByTeacher(String teachername) {
		String[] weekDays = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"};
		String weekdayStr = null;
		Date today = new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(today);
        int weekday=c.get(Calendar.DAY_OF_WEEK);
        if (weekday < 0)
        	weekday = 0;
        weekdayStr = weekDays[weekday-1];
        
		List rl = getHibernateTemplate().
		   find("from Kecheng kc where kc.teacher = ? and weekday = ? ", new Object[]{teachername, weekdayStr});
		return rl;
	}*/
	public List getKechengListByTeacher(String teachername) {
		String[] weekDays = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"};
		String weekdayStr = null;
		Date today = new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(today);
		int weekday=c.get(Calendar.DAY_OF_WEEK);
		if (weekday < 0)
			weekday = 0;
		weekdayStr = weekDays[weekday-1];
		List rl = getHibernateTemplate().
				find("from Kecheng kc, Kechengversion kcv where kc.v_id=kcv.id and kcv.isvalid=1 and kc.teacher = ? and kc.weekday = ? ", new Object[]{teachername, weekdayStr});
		return rl;
	}
	
	public List getDistinctKechengListByTeacher(String teachername) {
		List rl = getHibernateTemplate().
				find("select distinct kc.classname from Kecheng kc,Teacher t where kc.teacher=t.name and kc.teacher=? and t._status=1 ", new Object[]{teachername});
		return rl;
	}	
	
	public List getDistinctSubjectListByTeacher(String teachername) {
		List rl = getHibernateTemplate().
				find(" select s.id,s.name from (select  distinct k.subjectname from Kecheng k WHERE k.teacher=?) as oneselect,Subject s where oneselect.subjectname=s.name ", new Object[]{teachername});
		return rl;
	}
	
	public List getSec_KechengListByTeacher(String teachername) {
		String[] weekDays = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"};
		String weekdayStr = null;
		Date today = new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(today);
		int weekday=c.get(Calendar.DAY_OF_WEEK);
		if (weekday < 0)
			weekday = 0;
		weekdayStr = weekDays[weekday-1];
		
		List rl = getHibernateTemplate().
				find("from Sec_Kecheng sc where sc.teacher = ? and weekday = ?", new Object[]{teachername, weekdayStr});
		return rl;
	}
	
	public List getKechengListClassByTeacher(String teachername) {
		List rl = getHibernateTemplate().
		  //find("select distinct classname from Kecheng kc where kc.teacher = ?", new Object[]{teachername});
				find("select distinct kc.classname from Kecheng kc where kc.teacher = ?",new Object[]{teachername});
		return rl;
	}
	public List getKechengListClassByclassname(String classname) {
		List rl = getHibernateTemplate().
	//select distinct kc.teacher,kc.classname,kc.v_id,tc.id from Kecheng kc,Kechengversion kcv ,tclass tc 
				//where kc.classname=tc.tname and tc.tname='12秋HND会计2班' and kc.v_id=kcv.id and kcv.isvalid=1
				find("select distinct kc.teacher,kc.classname,kc.v_id,tc.id from Kecheng kc,Kechengversion kcv,TClass tc where kc.classname=tc.name and tc.name=? and kc.v_id=kcv.id and kcv.isvalid=1",new Object[]{classname});
		return rl;
	}
	public List getAdjustByteacher(String username) {
		List rl = getHibernateTemplate().
				find("from Adjust ad where ad.teachername='"+username+"' and status in (3,4,5) order by ad.publishdate");
		return rl;
	}
	public List getKechengListClassByTeacher1(String teachername){ 
		List rl = getHibernateTemplate().
				//find("select distinct kc from Kecheng kc,Kechengversion kcv  where kc.teacher = ? and  kcv.isvalid=1", new Object[]{teachername});
				//select distinct kc.* from Kecheng kc,Kechengversion kcv  where kc.teacher = '肖素文' and kcv.isvalid=1
				find("select distinct kc.classname,kc.v_id,kc.grade,kc.teacher from Kecheng kc,Kechengversion kcv  where kc.teacher = ? and kc.v_id=kcv.id and kcv.isvalid=1" ,new Object[]{teachername});
		    // find("select distinct kc  from Kecheng kc,Kechengversion kcv  where kc.teacher = ? and kc.v_id=kcv.id and kcv.isvalid=1" ,new Object[]{teachername});
		return rl;
	}
	public List getKechengListClassByTeacher1_(String teachername){ 
		List rl = getHibernateTemplate().
				find("select distinct kc.classname from Kecheng kc,Kechengversion kcv  where kc.teacher = ? and kc.v_id=kcv.id and kcv.isvalid=1" ,new Object[]{teachername});
		return rl;
	}
	//获取kencheng集合
	public List getKengchenglistClassRoom(String teachername) {
		List rl = getHibernateTemplate().
				find("from Kecheng kc where kc.teacher = ?",new Object[]{teachername});
		return rl;
	}
	
//	public List getKechengListClassByTeacher2(String id) {
//		List rl = getHibernateTemplate().
//		//select * from kecheng k,teacher t where k.teacher=t.name;
//				//find("select distinct classname from Kecheng kc where kc.teacher = ?", new Object[]{id});
//	  find("from Kecheng kc,Teacher tc where kc.teacher=tc.tid and tc.tid=?",new Object[]{id});
//		return rl;
//	}
	
	public List getDistinctTeacherListByclassname(String classname) {
		List rl = getHibernateTemplate().
		   find("SELECT DISTINCT k.teacher FROM Kecheng k WHERE k.classname=?", new Object[]{classname});
		return rl;
	}
	
	public List getStudentListByClassname(String classname) {
		List rl = getHibernateTemplate().
		   find("from Student student where student.classname = ? and student.status=1  and student.dividestatus <> 1 order by sid", new Object[]{classname});
		return rl;
	}
	public List getStudentListByClassname_(String classname) {
		List rl = getHibernateTemplate().
				find("from Student student where student.classname = ? and student.status=1  and student.dividestatus <> 1 order by sid", new Object[]{classname});
		return rl;
	}
	
	public List getHistoryStudentListByClassname(String classname) {
		List rl = getHibernateTemplate().
		   find("from Student student where student.classname = ?", new Object[]{classname});
		return rl;
	}
	
	public EnterApply getExamApply(String examid) {
		List<EnterApply> list =getHibernateTemplate().
		   find("from EnterApply ea where ea.examid = ? and ea.status=0", new Object[]{Integer.parseInt(examid)});
		
		return null!=list&&list.size()>0?list.get(0):null;
	}
	
	public List getStudentListByAssistantname(String assistantname) {
		List rl = getHibernateTemplate().
		   find("from Student student where student.assistant = ? order by sid ", new Object[]{assistantname});
		return rl;
	}
	
	public List<Student> getStudentList(String sid) {
		List rl = getHibernateTemplate().
		   find("from Student student where student.sid=? and student.status='1' and dividestatus <> 1 order by sid ", new Object[]{sid});
		return rl;
	}
	public List<Student> getStudentList(String sid,String assistantname){ 
		List rl = getHibernateTemplate().
				find("from Student student where student.sid=? and student.assistant=? and student.status='1' and dividestatus <> 1 order by sid ", new Object[]{sid,assistantname});
		return rl;
	}
	public List  getStudentListBysidclassName(String sid,String classname){ 
		List rl = getHibernateTemplate().
				find("from Student student where student.sid=? and student.classname=? and student.status='1' and dividestatus <> 1 order by sid ", new Object[]{sid,classname});
		return rl;
	}
	public List  getStudentListBysidclassName(String sid){ 
		List rl = getHibernateTemplate().
				find("from Student student where student.sid=? and student.status='1' and dividestatus <> 1 order by sid ", new Object[]{sid});
		return rl;
	}
	
	public List<Student> getStudentListByassistant(String assistant) {
		List rl = getHibernateTemplate().
				   find("from Student student where assistant=?", new Object[]{assistant});
	
				return rl;
	}
	
	
	public List<Exam> getExamByPhaseid_Subjectid_Scoretype_Examtype(Integer phaseid,Integer subjectid,Integer examtype) {
		List rl = getHibernateTemplate().
		   find("from Exam e where e.phaseid=? and e.subjectid=? and e.examtype=? group by e.classkey", new Object[]{phaseid,subjectid,examtype});
		return rl;
	}
	
	public List<Exam> getExamByPhaseid_Subjectid_Classkey(Integer phaseid,Integer subjectid,Integer classkey) {
		List rl = getHibernateTemplate().
		   find("from Exam e where e.phaseid=? and e.subjectid=? and e.classkey=? order by e.examtype desc", new Object[]{phaseid,subjectid,classkey});
		return rl;
	}
	
	public List<TClass> getExamByPhaseid_Subjectid(Integer phaseid,Integer subjectid) {
		List rl = getHibernateTemplate().
		   find("from TClass c where c.id not in (select e.classkey from Exam e where e.subjectid = ? and e.phaseid = ?)", new Object[]{subjectid,phaseid});
		return rl;
	}
	
	public List<Exam> getExamByClasskey(Integer classkey) {
		List rl = getHibernateTemplate().
				find("from Exam e where e.classkey=?", new Object[]{classkey});
		return rl;
	}
	
	public  List<ScoreNew> getScoreNewByClasskeyByScoretype(Integer classkey, Integer scoretype) {
		List rl = getHibernateTemplate().
				//SELECT * FROM  score_new WHERE classkey=1 and scoretype=2;
				find("from ScoreNew sn where sn.classkey=? and sn.scoretype=?", new Object[]{classkey,scoretype});
		return rl;
	}
	public  List<ScoreNew> getScoreNewByClasskeyByScoretype(Integer classkey) {
		List rl = getHibernateTemplate().
				find("from ScoreNew sn where sn.classkey=? and sn.scoretype in (1,3)", new Object[]{classkey});
		return rl;
	}
	public  List<ScoreNew> getScoreNewList(String sid) {
		List rl = getHibernateTemplate().
				find("from ScoreNew sn where sn.sid=? and sn.scoretype in (1,2,3)", new Object[]{sid});
		return rl;
	}
	public List<LetterTemplate> getLetterTemplateList(){
		List rl = getHibernateTemplate().
				find("from LetterTemplate l order by l.id");
		return rl;
	}
	public List<Jzletter> getJzletterlist(){
		List rl = getHibernateTemplate().
				find("from Jzletter j order by j.id");
		return rl;
	}
	public LetterTemplate getLetterTemplateListById(Integer id){
	List rl = getHibernateTemplate().
	   find("from LetterTemplate l where l.id = ?", new Object[]{id});
	  LetterTemplate lettertemplate = null;
	  if(null != rl && rl.size() > 0){
		lettertemplate = (LetterTemplate) rl.get(0);
	}
	return lettertemplate;
    }
   public Subject getSubjectBySubid(String subid){
	  List rl=getHibernateTemplate().find("from Subject s where s.subid=?",new Object[]{subid});
	  Subject subject=null;
	  if(null != rl && rl.size() > 0){
		  subject = (Subject) rl.get(0);
		}
	   return subject;
   }
   
   
   public Classroom getClassroomByroomname(String roomname){
	   List rl=getHibernateTemplate().find("from Classroom f where f.roomname=?",new Object[]{roomname});
	   Classroom classroom=null;
	   if(null != rl && rl.size() > 0){
		   classroom = (Classroom) rl.get(0);
			}
		   return classroom;
   }
   public Student getStudentBystatusDividestatus(String name){
	   List rl=getHibernateTemplate().find("from Student s where s.sid=? and s.status=1 and s.dividestatus <>1",new Object[]{name});
	   Student student=null;
	   if(null != rl && rl.size() > 0){
		   student = (Student) rl.get(0);
	   }
	   return student;
   }
	public List<Student> getStudentListByStatus() {
		List rl = getHibernateTemplate().
				find("from Student student where student.status='1' and dividestatus <> 1 ");
		return rl;
	}
	public List<Student> getStudentListByClassnameStatus(String classname) {
		List rl = getHibernateTemplate().
				find("from Student student where student.classname='"+classname+"' and student.status='1'and dividestatus <> 1 ");
		return rl;
	}

	public List<Advice> getAdviceByUser(String name) {
		List rl = getHibernateTemplate().
		   find("from Advice advice where advice.username=? order by createdate desc", new Object[]{name});
		return rl;
	}
	
	public List<Advice> getAllAdviceList() {
		List rl = getHibernateTemplate().
		   find("from Advice advice where advice.status=2 order by createdate desc");
		return rl;
	}
	
	

	public List<Score> getStudentScoreList(String sid) {
		List rl = getHibernateTemplate().
		   find("select s from ScoreNew s, Exam e where sid=? and s.examid = e.id and e.displaystatus = 4 ", new Object[]{sid});
		return rl;
	}
	
	public List<Absence> getStudentAbsenceList(String sid) {
		List rl = getHibernateTemplate().
		   find("from Absence absence where sid=?", new Object[]{sid});
		return rl;
	}
	
	public List<Absence> getAbsenceList() {
		List rl = getHibernateTemplate().
		   find("from Absence");
		return rl;
	}
	
	public List<Absence> getAbsenceListByClassid(Integer classid) {
		List rl = getHibernateTemplate().
		   find("from Absence absence where classid=?", new Object[]{classid});
		return rl;
	}
	
	public List getAbsenceByCondition(String teachername,String classid,String sid,String name,String subjectid,String status,String date) {
		StringBuffer buffer=new StringBuffer("select absence.sid,absence.subjectid,absence.classid from Absence as absence,Student as student where absence.sid=student.sid");
		if(null!=classid&&!classid.equals("")){
			buffer.append("	and absence.classid='"+classid+"'");
		}
		if(null!=teachername&&!teachername.equals("")){
			buffer.append("	and absence.teachername='"+teachername+"'");
		}
		if(null!=sid&&!sid.equals("")){
			buffer.append("	and absence.sid='"+sid+"'");
		}
		if(null!=name&&!name.equals("")){
			buffer.append("	and student.name='"+name+"'");
		}
		if(null!=subjectid&&!subjectid.equals("")){
			buffer.append("	and absence.subjectid='"+subjectid+"'");
		}
		if(null!=status&&!status.equals("")){
			buffer.append("	and absence.type='"+status+"'");
		}
		if(null!=date&&!date.equals("")){
			buffer.append("	and absence.absencedate like '"+date+"%'");
		}
		buffer.append(" group by absence.sid ");
		List rl = getHibernateTemplate().
		   find(buffer.toString());
		return rl;
	}
	
	public List<Absence> getAbsenceListBySid(String sid) {
		List rl = getHibernateTemplate().
		   find("from Absence absence where sid=? order by absence.subjectid", new Object[]{sid});
		return rl;
	}
	public List<Absence> getAbsenceListBySid(String sid,Integer classid) {
		List rl = getHibernateTemplate().
				find("from Absence absence where sid=? and classid=? order by absence.subjectid", new Object[]{sid,classid});
		return rl;
	}
	public List<Absence> getAbsenceListBySid(String teachername,String sid,String classid,String subjectid,String status,String date) {
		StringBuffer buffer=new StringBuffer("from Absence absence where sid='"+sid+"' ");
		if(null!=classid&&!classid.equals("")){
			buffer.append("	and absence.classid='"+classid+"'");
		}
		if(null!=teachername&&!teachername.equals("")){
			buffer.append("	and absence.teachername='"+teachername+"'");
		}
		if(null!=subjectid&&!subjectid.equals("")){
			buffer.append("	and absence.subjectid='"+subjectid+"'");
		}
		if(null!=status&&!status.equals("")){
			buffer.append("	and absence.type='"+status+"'");
		}
		if(null!=date&&!date.equals("")){
			buffer.append("	and absence.absencedate like '"+date+"%'");
		}
		buffer.append(" order by absence.subjectid");
		List rl = getHibernateTemplate().
		   find(buffer.toString());
		return rl;
	}
	
	public List<Absence> getAbsenceListByTeachername(String teachername ) {
		List rl = getHibernateTemplate().
		   find("from Absence absence where teachername = ?", new Object[]{teachername});
		return rl;
	}
	
	public List<Reward> getStudentRewardList(String sid) {
		List rl = getHibernateTemplate().
		   find("from Reward reward where sid=?", new Object[]{sid});
		return rl;
	}
	
	public List<Reward> getRewardList() {
		List rl = getHibernateTemplate().
		   find("from Reward reward ");
		return rl;
	}
	
	public List<Ielts> getStudentIeltsList(String sid) {
		List rl = getHibernateTemplate().
		   find("from Ielts ielts where sid=?", new Object[]{sid});
		return rl;
	}
	
	public List<Ielts> getIeltsListInClassid(String classid) {
		List rl = getHibernateTemplate().
		   find("from Ielts ielts where classid in ( "+classid+" )");
		return rl;
	}
	
	public List<Ielts> getIeltsListInClassid(Integer classid) {
		List rl = getHibernateTemplate().
		   find("from Ielts ielts where status=1 and classid in ( "+classid+" )");
		return rl;
	}
	
	public List<Ielts> getIeltsListBySid(String sid) {
		List rl = getHibernateTemplate().
		   find("from Ielts ielts where sid = ? and status=2 order by id desc", new Object[]{sid});
		return rl;
	}
	
	public List<Ielts> getAllIeltsList() {
		List rl = getHibernateTemplate().
		   find("from Ielts ielts where ielts.status=1");
		return rl;
	}
	
	public List<Punish> getStudentPunishList(String sid) {
		List rl = getHibernateTemplate().
		   find("from Punish punish where sid=?", new Object[]{sid});
		return rl;
	}
	
	public List<Punish> getPunishList() {
		List rl = getHibernateTemplate().
		   find("from Punish punish ");
		return rl;
	}
	
	public List getClassList() {
		List rl = getHibernateTemplate().
		   find("from TClass c order by id desc ");
		return rl;
	}
	
	public List getClassListByAssistantid(Integer assistantid) {
		List rl = getHibernateTemplate().
		   find("from TClass c where assistantid="+assistantid);
		return rl;
	}
	
	public List getSubjectList() {
		List rl = getHibernateTemplate().
		   find("from Subject s ");
		return rl;
	}
	
	public Subject getSubjectByName(String name) {
		List rl = getHibernateTemplate().
		   find("from Subject s where s.name ='"+name+"'");
		Subject subject = null;
		if(null != rl && rl.size() > 0){
			subject = (Subject) rl.get(0);
		}
		return subject;
	}
	
	public List getAssistantList() {
		List rl = getHibernateTemplate().
		   find("from Assistant assistant ");
		return rl;
	}
	public List getAssistantList(Integer assistantid) {
		List rl = getHibernateTemplate().
				find("from Assistant assistant where assistant.id=?",new Object[]{assistantid});
		return rl;
	}
	public Assistant getAssistantById(Integer id){
		List rl = getHibernateTemplate().
				   find("from Assistant a where a.id = ?", new Object[]{id});
				Assistant assistant = null;
				if(null != rl && rl.size() > 0){
					assistant = (Assistant) rl.get(0);
				}
				return assistant;
	}
	public List getAdjustList() {
		List rl = getHibernateTemplate().
		   find("from Adjust adjust ");
		return rl;
	}
	public List getAdjusBystatus() {
		List rl = getHibernateTemplate().
				find("from Adjust adjust where adjust.status in (3,4,5)");
		return rl;
	}
	public List<Notice> get_system_notice_list() {
		List rl = getHibernateTemplate().
				find("from Notice notice where notice.noticetype =4");
		return rl;
	}
	public List<Notice> getNoticeByusernametype(Integer type,String username){
		List rl=null;
		if(username==""){
	   rl = getHibernateTemplate().find("from Notice notice where notice.type=5 and notice.status <> 1 order by notice.publishdate desc ");
		}else{
	   rl = getHibernateTemplate().find("from Notice notice where notice.type=5 and notice.status <> 1 and FIND_IN_SET('"+username+"',notice.username)>0 order by notice.publishdate desc");	
		}	
		return rl;
	}
	
	
	
	
	public List<Notice> getNoticeByassistantclassestype(Integer type,String classid){
		//List rl= getHibernateTemplate().find("from Notice notice where notice.type=5 and notice.classid in("+classid+") and notice.status in (1,3)");	
		List rl= getHibernateTemplate().find("from Notice notice where notice.type=5 and notice.classid in("+classid+") and notice.status=3 order by notice.publishdate desc ");	
		return rl;
	}
	public List<Notice> getNoticeBystudentclassestype(Integer type,Integer classid){
		//List rl= getHibernateTemplate().find("from Notice notice where notice.type=5 and notice.classid=? and notice.status in (1,3)",new Object[]{classid});	
		List rl= getHibernateTemplate().find("from Notice notice where notice.type=5 and notice.classid=? and notice.status=3 order by notice.publishdate desc ",new Object[]{classid});	
		return rl;
	}
	
	
	
	public List<Notice> getNoticeByAll(){
		List rl= getHibernateTemplate().find("from Notice notice where notice.type=1 and notice.status=2 order by notice.id asc ");	
		return rl;
	}
	public List<Notice> getNoticeByassistant(){
		List rl= getHibernateTemplate().find("from Notice notice where notice.type=3 and notice.status=2 order by notice.id asc ");	
		return rl;
	}
	public List<Notice> getNoticeByteacher(){
		List rl= getHibernateTemplate().find("from Notice notice where notice.type=2 and notice.status=2 order by notice.id asc ");	
		return rl;
	}
	
	public List<Notice> getNoticeBystudent(String classid){
		List rl= getHibernateTemplate().find("from Notice notice where notice.type=4 and  notice.classid in ("+classid+") and notice.status=2 order by notice.id asc");	
		return rl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public List getAdjustBystudentstatus(String name){ 
		List rl = getHibernateTemplate().
				find("from Adjust adjust where adjust.classname='"+name+"' and adjust.status=4");
		return rl;
	}
	public List getKechengversionList() {
		List rl = getHibernateTemplate().
				find("from Kechengversion kechengversion ");
		return rl;
	}
	public List getKechengversionList(Integer isvalid) {
		List rl = getHibernateTemplate().
				find("from Kechengversion kechengversion where kechengversion.isvalid=1 ");
		return rl;
	}
	public List getKechengversionListById(Integer id) {
		List rl = getHibernateTemplate().
				find("from Kechengversion kechengversion where kechengversion.id=?",new Object[]{id});
		return rl;
	}
	public List getScoreNewCountScoretype1(String sid){
		List rl = getHibernateTemplate().
				find("select sc.result from ScoreNew sc,Exam e where sc.sid=? and sc.scoretype=1 AND sc.examtype=1 and sc.examid=e.id and e.displaystatus=4",new Object[]{sid});
		return rl;
	}
	public List getScoreNewCountScoretype_1(String sid){
		List rl = getHibernateTemplate().
				find("select count(*) from ScoreNew sc where sc.sid=? and sc.result in('A','B','C') and sc.scoretype=1 and sc.examtype in (3,7,9)",new Object[]{sid});
		return rl;
	}
	public List getScoreNewCountScoretype2(String sid) {
		List rl = getHibernateTemplate().
				//select count(*) from score_new sc,Exam e where sc.sid='2016665153' and sc.result='P' AND sc.scoretype=2 and  sc.examid=e.id and e.displaystatus=4
				find("select count(*) from ScoreNew sc,Exam e  where sc.sid=? and sc.result='P' AND sc.scoretype=2 and sc.examid=e.id and e.displaystatus=4 ",new Object[]{sid});
		return rl;
	}
	public List  getScoreNewCountScoretype3(String sid){
		List rl = getHibernateTemplate().
				find("select sc.result from ScoreNew sc,Exam e where sc.sid=? and sc.scoretype=3 and sc.examtype=1 and sc.examid=e.id and e.displaystatus=4",new Object[]{sid});
		return rl;
	}
	public List  getScoreNewCountScoretype_3(String sid){
		List rl = getHibernateTemplate().
				find("select sc.result from ScoreNew sc,Exam e where sc.sid=? and sc.scoretype=3 and sc.examtype in (3,7,9) and sc.examid=e.id and e.displaystatus=4",new Object[]{sid});
		return rl;
	}
	public List<Integer> getScoreNewListByClasskey(){
		List rl = getHibernateTemplate().
				find("select distinct sc.classkey from ScoreNew sc,Exam e where sc.scoretype in (1,2,3) and e.displaystatus=4");
		return rl;
	}
	
	public List<Object[]> getScoreNewBySid(String sid){
		List rl = getHibernateTemplate().
				//find("select distinct sc.subjectid,sc.phaseid,sc.scoretype,sc.classkey from ScoreNew sc where sc.sid=? order by sc.id desc",new Object[]{sid});
		   find("select distinct sc.subjectid,sc.phaseid,sc.scoretype,sc.classkey from ScoreNew sc," +
		   		"Exam e where sc.sid=? and sc.examid=e.id and e.displaystatus=4 order by sc.id desc",new Object[]{sid});
		return rl;
	}
	
	public List<Object[]> getScoreNewByClassid(Integer classid){
		List rl = getHibernateTemplate().
				find("select distinct sc.subjectid from ScoreNew sc where sc.classkey=?",new Object[]{classid});
		return rl;
	}
	public List getKechengListByclassname(String classname){ 
		List rl = getHibernateTemplate().
		find("select distinct kc.teacher,kc.classname,kc.v_id from Kecheng kc,Kechengversion kcv where kc.classname=? and kc.v_id=kcv.id and kcv.isvalid=1",new Object[]{classname});
		return rl;
	}
	public List<Notice> getNoticeListBytype(String noticetype,Integer type){
		 List<Notice> rl=null;
		 if(type.equals(0)){
			 rl = getHibernateTemplate().
					 find("from Notice notice where  notice.noticetype =? and  notice.type=1 and notice.status=2 order by notice.publishdate desc",new Object[]{noticetype}); 
		 }
		 if(type.equals(2) || type.equals(3)){
			 rl = getHibernateTemplate().
					 find("from Notice notice where  notice.noticetype =? and  notice.type in(1,?,4) and notice.status=2 order by notice.publishdate desc",new Object[]{noticetype,type}); 
		 }
		 if(type.equals(4)){
			 rl = getHibernateTemplate().
					 find("from Notice notice where  notice.noticetype =? and  notice.type in(1,?) and notice.status=2 order by notice.publishdate desc",new Object[]{noticetype,type});  	 
		 }
		return rl;
	}
	public User getUserBytype(String username,Integer type){
		List rl=getHibernateTemplate().
				find("from User u where u.user=? and u.userType=? ",new Object[]{username,type});
		User user=null;
		if(null != rl && rl.size() > 0){
			user = (User) rl.get(0);
		}
		return user;
	}
	public  Assistant getAssistantListByaid(String assistantaid){
		List rl=getHibernateTemplate().
				find("from Assistant a where a.aid=? ",new Object[]{assistantaid});
		Assistant assistant=null;
		if(null != rl && rl.size() > 0){
			assistant = (Assistant) rl.get(0);
		}
		return assistant;
	}
   public Classroom getClassroomListByCid(String cid){
	   List rl=getHibernateTemplate().find("from Classroom c where c.cid=? ",new Object[]{cid});
	   Classroom classroom=null;
	   if(null != rl && rl.size() > 0){
		   classroom = (Classroom) rl.get(0);
		}
		return classroom;
   }
   public Classroom getClassroomListByroomid(String roomid){
	   List rl=getHibernateTemplate().find("from Classroom c where c.roomid=? ",new Object[]{roomid});
	   Classroom classroom=null;
	   if(null != rl && rl.size() > 0){
		   classroom = (Classroom) rl.get(0);
	   }
	   return classroom;
   }

	/*public List<Notice> getNoticeListAcceptTeacherByXs(Integer publisherid,Integer type){
		List<Notice> rl = getHibernateTemplate().
				find("from Notice notice where  notice.publisherid =? and  notice.type in(1,?) order by notice.id asc",new Object[]{publisherid,type});
		return rl;
	}*/
	public List getGoodsList() {
		List rl = getHibernateTemplate().
				find("from Goods goods ");
		return rl;
	}
	public List getAdjustList(String column_name,String desc,int from, int size) {
		List rl = getHibernateTemplate().
				//find("from Adjust adjust ");
	//String sql = "select * from  goods  order by  "+column_name+" "+desc+ "  LIMIT " + from+ " , " + size + " ";
				find("from Adjust order by  "+column_name+" "+desc+" limit " + from + ","+ size + "",new Object[]{column_name,desc,from,size});
		return rl;
	}
	public List getGoodsList(String column_name,String desc,int from, int size) {
		List rl = getHibernateTemplate().
				//find("from Adjust adjust ");
				//String sql = "select * from  goods  order by  "+column_name+" "+desc+ "  LIMIT " + from+ " , " + size + " ";
				find("from Goods order by "+column_name+" "+desc+" limit " + from + ","+ size + "");
		return rl;
	}
	public List getAdjustList(Integer status) {
		List rl = getHibernateTemplate().
				find("from Adjust adjust where adjust.status=?",new Object[]{status});
		return rl;
	}
	public List getAdjustList(Integer status,String classname) {
		List rl = getHibernateTemplate().
				find("from Adjust adjust where adjust.status=? and adjust.classname=? ",new Object[]{status,classname});
		return rl;
	}
	
	public List getAdjustList(String classname, String date, String starttime) {
		List rl = getHibernateTemplate().
		   find("from Adjust adjust where adjust.classname=? and datebefore='"+date+"' and starttimebefore=? and status = 2 ", new Object[]{classname, starttime});
		return rl;
	}
	
	public List getAdjustListNew(String classname, String date, String starttime,Integer version) {
		List rl = getHibernateTemplate().
		   find("from Adjust adjust where adjust.classname=? and datebefore=? and starttimebefore=? and v_id=? and status = 4 ", new Object[]{classname, date,starttime,version});
		return rl;
	}
	
	public List getAdjustList(String teacherName, String date, String starttime,Integer version) {
		List rl = getHibernateTemplate().
		   find("from Adjust adjust where adjust.teachername=? and datebefore=? and starttimebefore=? and v_id=? and status = 4 ", new Object[]{teacherName,date,starttime,version});
		return rl;
	}
	
	public List getAdjustListAfter(String teacherName, String date, String starttime,Integer version) {
		List rl = getHibernateTemplate().
		   find("from Adjust adjust where adjust.teachername=? and dateafter=? and starttimeafter=? and v_id=? and status = 4 ", new Object[]{teacherName,date,starttime,version});
		return rl;
	}
	
	public List getAdjustClassSubjectName(String classroom, String subjectname, String classname) {
		List rl = getHibernateTemplate().
				find("from Adjust adjust where adjust.classroom=? and adjust.subjectname=? and adjust.classname=? ", new Object[]{classroom, subjectname,classname});
		return rl;
	}
	
	public List getAdjustListAfter(String classname, String date, String starttime) {
		List rl = getHibernateTemplate().
		   find("from Adjust adjust where adjust.classname=? and dateafter='"+date+"' and starttimeafter=? and status = 2 ", new Object[]{classname, starttime});
		return rl;
	}
	
	public List getAdjustListAfterNew(String classname, String date, String starttime,Integer version) {
		List rl = getHibernateTemplate().
		   find("from Adjust adjust where adjust.classname=? and dateafter=? and starttimeafter=? and v_id=? and status = 4 ", new Object[]{classname,date,starttime,version});
		return rl;
	}
	
	public List getDelayList() {
		List rl = getHibernateTemplate().
		   find("from EnterApply ea ");
		return rl;
	}
	
	public List getExampjList() {
		List rl = getHibernateTemplate().
		   find("from Exampj exampj ");
		return rl;
	}
	
	public List getMyExampjList(String classname) {
		List rl = getHibernateTemplate().
		   find("from Exampj exampj where exampj.classname = ?", new Object[]{classname});
		return rl;
	}
	
	public List getLoggingList() {
		List rl = getHibernateTemplate().
		   find("from Logging logging order by logging.id desc");
		return rl;
	}
	
	public Assistant getAssistantByName(String name){
		List rl = getHibernateTemplate().
		   find("from Assistant a where a.name = ? and a._status=1 ", new Object[]{name});
		Assistant assistant = null;
		if(null != rl && rl.size() > 0){
			assistant = (Assistant) rl.get(0);
		}
		return assistant;
	}
	public Assistant getAssistantByAid(String aid) {
		List rl = getHibernateTemplate().
				find("from Assistant a where a.aid = ?", new Object[]{aid});
		Assistant assistant = null;
		if(null != rl && rl.size() > 0){
			assistant = (Assistant) rl.get(0);
		}
		return assistant;
	}
	
	public List getTeacherList() {
		List rl = getHibernateTemplate().find("from Teacher t ");
		return rl;
	}
	public List getTeacherListNew() {
		List rl = getHibernateTemplate().find("from Teacher t where t._status=1 ");
		return rl;
	}
	public List getTeacherList(String username) {
		List rl = getHibernateTemplate().
				find("from Teacher t where t.name=?",new Object[]{username});
		return rl;
	}
	
	public Teacher getTeacherByTid(String tid) {
		List rl = getHibernateTemplate().
		   find("from Teacher t where t.tid = ?", new Object[]{tid});
		Teacher teacher = null;
		if(null != rl && rl.size() > 0){
			teacher = (Teacher) rl.get(0);
		}
		return teacher;
	}
	
	public Teacher getTeacherByName(String name){
		List rl = getHibernateTemplate().
		   find("from Teacher t where t.name = ? and t._status=1", new Object[]{name});
		Teacher teacher = null;
		if(null != rl && rl.size() > 0){
			teacher = (Teacher) rl.get(0);
		}
		return teacher;
	}

	
	public Kecheng getKechengjieke(String classname, String fromtime, String weekday) {
		List rl = getHibernateTemplate().
		   find("from Kecheng t where t.classname = ? and t.starttime = ? and t.weekday = ?", new Object[]{classname, fromtime, weekday});
		Kecheng kecheng = null;
		if(null != rl && rl.size() > 0){
			kecheng = (Kecheng) rl.get(0);
		}
		return kecheng;
	}
	
	public Kecheng getKechengjiekeNew(String classname, String fromtime, String weekday,Integer version) {
		List rl = getHibernateTemplate().
		   find("from Kecheng t where t.classname = ? and t.starttime = ? and t.weekday = ? and t.v_id=?", new Object[]{classname, fromtime, weekday,version});
		Kecheng kecheng = null;
		if(null != rl && rl.size() > 0){
			kecheng = (Kecheng) rl.get(0);
		}
		return kecheng;
	}
	
	public Kecheng getKecheng(String classname,String subjectname,String weekday, String starttime,String teachername,Integer version){
		List rl = getHibernateTemplate().
				   find("from Kecheng t where t.classname = ? and t.subjectname=? and t.weekday=? and t.starttime=? and t.teacher=? and t.v_id=?", new Object[]{classname,subjectname,weekday, starttime, teachername,version});
				Kecheng kecheng = null;
				if(null != rl && rl.size() > 0){
					kecheng = (Kecheng) rl.get(0);
				}
				return kecheng;
	}
	
	public Kecheng getKechengjieke(String teacherName, String fromtime, String weekday,Integer version) {
		List rl = getHibernateTemplate().
		   find("from Kecheng t where t.teacher = ? and t.starttime = ? and t.weekday = ? and t.v_id=?", new Object[]{teacherName, fromtime, weekday,version});
		Kecheng kecheng = null;
		if(null != rl && rl.size() > 0){
			kecheng = (Kecheng) rl.get(0);
		}
		return kecheng;
	}
	
	public Score getScoreForInput(String sid, Integer subjectid, Integer phaseid, Integer examtype) {
		List rl = null;
		if(examtype == 1){
			rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? and ( exam1 is not null and exam1 <> '' ) ", new Object[]{sid, subjectid, phaseid});
		}
		if(examtype == 2){
			rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? and ( exam2 is not null and exam2 <> '' ) ", new Object[]{sid, subjectid, phaseid});
		}
		if(examtype == 3){
			rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? and ( exam3 is not null and exam3 <> '' ) ", new Object[]{sid, subjectid, phaseid});
		}
		if(examtype == 4){
			rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? and ( exam4 is not null and exam4 <> '' ) ", new Object[]{sid, subjectid, phaseid});
		}
		if(examtype == 5){
			rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? and ( exam5 is not null and exam5 <> '' ) ", new Object[]{sid, subjectid, phaseid});
		}
		if(examtype == 6){
			rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? and ( exam6 is not null and exam6 <> '' ) ", new Object[]{sid, subjectid, phaseid});
		}
		if(examtype == 7){
			rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? and ( exam7 is not null and exam7 <> '' ) ", new Object[]{sid, subjectid, phaseid});
		}
		if(examtype == 8){
			rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? and ( exam8 is not null and exam8 <> '' ) ", new Object[]{sid, subjectid, phaseid});
		}
		Score score = null;
		if(null != rl && rl.size() > 0){
			score = (Score) rl.get(0);
		}
		return score;
	}
	
	public Score getScoreForInput(String sid, Integer subjectid, Integer examid) {
		List rl = getHibernateTemplate().
			   find("from Score s where s.sid = ? and subjectid = ? and phaseid = ? ", new Object[]{sid, subjectid, examid});
		Score score = null;
		if(null != rl && rl.size() > 0){
			score = (Score) rl.get(0);
		}
		return score;
	}
	
	public ScoreNew getButtonStatus(Integer examId) {
		List rl = getHibernateTemplate().
			   find("from ScoreNew s where s.examid = ?", new Object[]{examId});
		ScoreNew score = null;
		if(null != rl && rl.size() > 0){
			score = (ScoreNew) rl.get(0);
		}
		return score;
	}
	
	
	//获得该学生该科目考试的上一次的成绩结果,同一阶段同一科目只会有一种得分值考试
	public ScoreNew getScoreForInputNew(String sid, Integer subjectid, Integer phaseid) {
		List rl =null;
		
		rl = getHibernateTemplate().
		find("select s.result from ScoreNew s,Exam e where s.examid=e.id and s.sid = ? and s.subjectid = ? and s.phaseid = ? and s.result is not null and e.displaystatus=4", new Object[]{sid, subjectid, phaseid});
		ScoreNew score = new ScoreNew();
		String result="";
		if(null != rl && rl.size() > 0){
			result = (String) rl.get(rl.size()-1);
		}
		score.setResult(result);
		return score;
	}
	
	public List<ScoreNew> getScore(String sid, Integer subjectid, Integer phaseid,Integer examType) {
		List<ScoreNew> rl = getHibernateTemplate().
			find("from ScoreNew s where s.sid = ? and s.subjectid = ? and s.phaseid = ? and s.examtype=?", new Object[]{sid, subjectid, phaseid,examType});
		return rl;
	}	
	
	public List<ScoreNew> getScore(String sid, Integer subjectid, Integer phaseid,Integer examType,Integer examid) {
		List<ScoreNew> rl = getHibernateTemplate().
			find("from ScoreNew s where s.sid = ? and s.subjectid = ? and s.phaseid = ? and s.examtype=? and s.examid=?", new Object[]{sid, subjectid, phaseid,examType,examid});
		return rl;
	}
	
	public List getScore_(String sid, Integer subjectid, Integer phaseid,Integer examType) {
		List rl = getHibernateTemplate().
				//select s.result,s.examid,e.id from score_new s,exam e where s.examid=e.id and s.sid='2014665121' and s.subjectid=1 and s.phaseid=0 and s.examtype=1
				find("select s.result from  ScoreNew s,Exam e where s.sid = ?" +
					 " and s.subjectid = ? and s.phaseid = ? and s.examtype=? and s.examid=e.id and e.displaystatus=4",
					 new Object[]{sid, subjectid, phaseid,examType});
		return rl;
	}
	public List getscore(String sid, Integer subjectid, Integer phaseid,Integer examType) {
		List rl = getHibernateTemplate().
				//select s.result,s.examid,e.id from score_new s,exam e where s.examid=e.id and s.sid='2014665121' and s.subjectid=1 and s.phaseid=0 and s.examtype=1
				find("select s.result,e.title from  ScoreNew s,Exam e where s.sid = ? " +
					 "and s.subjectid = ? and s.phaseid = ? and s.examtype=? and s.examid=e.id and e.displaystatus=4",
					 new Object[]{sid, subjectid, phaseid,examType});
		return rl;
	}
	public List getscore_(String sid, Integer subjectid, Integer phaseid,Integer examType) {
		List rl = getHibernateTemplate().
				//select s.result,s.examid,e.id from score_new s,exam e where s.examid=e.id and s.sid='2014665121' and s.subjectid=1 and s.phaseid=0 and s.examtype=1
				find("select s.result,e.title from  ScoreNew s,Exam e where s.sid = ? and s.subjectid = ? and s.phaseid = ? and s.examtype=? and s.examid=e.id and e.displaystatus=4", new Object[]{sid, subjectid, phaseid,examType});
		return rl;
	}
	
	public TClass getClassByCid(String cid) {
		List rl = getHibernateTemplate().
		   find("from TClass c where c.cid = ?", new Object[]{cid});
		TClass tclass = null;
		if(null != rl && rl.size() > 0){
			tclass = (TClass) rl.get(0);
		}
		return tclass;
	}
	public Student getStudentBySid(String sid) {
		List rl = getHibernateTemplate().
				find("from Student student where student.sid = ? and student.status=1  and student.dividestatus <> 1 order by sid", new Object[]{sid});
		Student student = null;
		if(null != rl && rl.size() > 0){
			student = (Student) rl.get(0);
		}
		return student;
	}
	public Student getStudentBySid_(String sid) {
		List rl = getHibernateTemplate().
				find("from Student student where student.sid = ? order by sid", new Object[]{sid});
		Student student = null;
		if(null != rl && rl.size() > 0){
			student = (Student) rl.get(0);
		}
		return student;
	}
	
	
	
	
	public List<TClass> getClassByAssistantid(Integer assistantid){
		List rl = getHibernateTemplate().
				find("from TClass c where c.assistantid = ?", new Object[]{assistantid});
	
		return rl;
	}
	public List<String> getScorenewByClasskey(Integer classid){
		List rl = getHibernateTemplate().
				find("select distinct sn.sid from ScoreNew sn,Exam e where sn.classkey = ? " +
					"and sn.scoretype in(1,2,3) and sn.examid=e.id and  e.displaystatus=4 order by sn.sid asc", new Object[]{classid});
		
		return rl;
	}
	public List<String> getkechengteacherByclassname(String classname){
		List rl = getHibernateTemplate().
				find("select distinct k.teacher from Kecheng k,Kechengversion kc where k.classname=? and k.v_id=kc.id and kc.isvalid=1", new Object[]{classname});
		return rl;
	}
	public List<Integer> getScorenewBysid_(String sid){
		List rl = getHibernateTemplate().
				find("select distinct sn.classkey from ScoreNew sn where sn.sid = ?", new Object[]{sid});
		
		return rl;
	}
	public List<Integer> getSubjectidlist(String sid){
		List rl=getHibernateTemplate().find("select distinct sn.subjectid from ScoreNew sn,Exam e where sn.sid in ("+sid+") and sn.examid=e.id and e.displaystatus=4");
		return rl;
	}
	
	public List<Integer> getSubjectid_list(String classkey){
		List rl=getHibernateTemplate().find("select distinct sn.subjectid from ScoreNew sn,Exam e where sn.classkey in("+classkey+") and sn.classkey=e.classkey and sn.examid=e.id and e.displaystatus=4");
		return rl;
	}
	public List<String> getClassnameList(){
		List rl = getHibernateTemplate().
				find("select distinct s.classname  from Student s");
		
		return rl;
	}
	public List<String> getExamByEdatephaseidClasskeySubjectid(Integer examtype,
			Integer phaseid, Integer classkey, Integer subjectid){
		List rl = getHibernateTemplate().
				find("select e.title from Exam e where e.examtype=? and e.phaseid=? and e.classkey=? and e.subjectid=?", new Object[]{examtype,phaseid,classkey,subjectid});
		return rl;
	}
	public List<String> getKechengByclassnamesubjectname(String subjectname,String classname){
		List rl = getHibernateTemplate().
				find("SELECT distinct k.teacher from Kecheng k,Kechengversion kc where k.subjectname=? and k.classname=? and k.v_id=kc.id and kc.isvalid=1 ", new Object[]{subjectname,classname});
		return rl;
	}
	
	
	
	public TClass getClassByAssistantId(Integer assistantid) {
		List rl = getHibernateTemplate().
				find("from TClass c where c.assistantid = ?", new Object[]{assistantid});
		TClass tclass = null;
		if(null != rl && rl.size() > 0){
			tclass = (TClass) rl.get(0);
		}
		return tclass;
	}
	
	public TClass getClassByName(String classname) {
		List rl = getHibernateTemplate().
		   find("from TClass c where c.name = ?", new Object[]{classname});
		TClass tclass = null;
		if(null != rl && rl.size() > 0){
			tclass = (TClass) rl.get(0);
		}
		return tclass;
	}
	
	public List getRightList() {
		List rl = getHibernateTemplate().
		   find("from Right rr ");
		return rl;
	}

	public List findAllRecord(String startDate, String endDate,String cardNO) {
		List rl = getHibernateTemplate().
		   find("from Record r where r.consumeDate >=? and r.consumeDate <= ? and  r.cardNO = ?" +
		   		"order by  r.consumeDate, r.equNO, r.consumeTime", new String[]{startDate,endDate,cardNO});
		return rl;
	}
	
	public List findCurrentRecordList() {
		Date nowDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String nowDateStr = df.format(nowDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MINUTE, -10);    //????10????
		long date = cal.getTimeInMillis();
		String nowTimeStr = sdf.format(new Date(date));
		
		List rl = getHibernateTemplate().
		   find("from Record r where r.consumeDate =? and r.consumeTime >= ?" +
		   		"order by  r.cardNO", new String[]{nowDateStr, nowTimeStr});
		return rl;
	}
	
	public List findAllTeacher(){
		List tl = getHibernateTemplate().find("from Teacher");
		return tl;
	}
	
	public List findStudentByIDOrName(String emplID, String emplName){
		List tl = getHibernateTemplate().find("from HrEmployee he where he.emplID = ? or he.emplName like '%"+emplName+"%'", 
				new String[]{emplID});
		return tl;
	}
	
	public List findStuRank(Date startDate, Date endDate){
		List tl = getHibernateTemplate().find("select count(*), jm.emplID, jm.emplName,jm.cellPhone from ManualRecord " +
				"as jm where jm.reasonType = '忘带卡' and jm.recordTime >= ? and jm.recordTime <= ? group by jm.emplID, jm.emplName,jm.cellPhone order by count(*) desc"
				, new Date[] { startDate, endDate });
		return tl;
	}
	
	public List findAllStudent(){
		List tl = getHibernateTemplate().find("from HrEmployee hr  where hr.status = '已审核' ");
		return tl;
	}
	
	public List getUncheckedStudentList(){
		List tl = getHibernateTemplate().find("from HrEmployee he where he.status = '未审核' ");
		return tl;
	}
	
	public List searchEmployee(String emplName ){
		List tl = getHibernateTemplate().find("from HrEmployee h where h.emplName like '%"+emplName+"%'");
		return tl;
	}
	
	public List findAllContract(){
		List tl = getHibernateTemplate().find("from Contract c where c.status = '已审核' ");
		return tl;
	}
	
	public List getListUncheckedContract(){
		List tl = getHibernateTemplate().find("from Contract c where c.status = '未审核' ");
		return tl;
	}
	
	public List findContractByNO(String contractNO){
		List tl = getHibernateTemplate().find("from Contract c where c.contractNO = ? ", new String[]{contractNO});
		return tl;
	}
	
	public List findContractByName(String name){
		List tl = getHibernateTemplate().find("from Contract c where c.emplName like '%"+name+"%' ");
		return tl;
	}
	
	public String findMaxContractNo(){
		List tl = getHibernateTemplate().find("select Max(c.contractNO) from  Contract c ");
		Object obj = new Object();
		if(null != tl && tl.size() >= 1){
			obj = tl.get(0);
		}
		if(null == obj) obj = "-1";
		return String.valueOf(obj);
	}
	
	public List findAllEmplName(){
		List tl = getHibernateTemplate().find("select h.emplName from  HrEmployee h ");
		return tl;
	}
	
	public String findMaxEmployeeNo(){
		List tl = getHibernateTemplate().find("select Max(h.emplID) from  HrEmployee h ");
		Object obj = new Object();
		if(null != tl && tl.size() >= 1){
			obj = tl.get(0);
		}
		if(null == obj) obj = "-1";
		return String.valueOf(obj);
	}
	
	public Contract findContractByEmplID(String emplID){
		List cl = getHibernateTemplate().find("from Contract c where c.emplID = ?", new String[]{emplID});
		if (cl != null && cl.size() >= 1) {
			return (Contract) cl.get(0);
		}
		return null;
	}
	
	public List findManualRecord(){
		List tl = getHibernateTemplate().find("from ManualRecord mr where mr.status = '未刷卡");
		return tl;
	}
	
	public List findManualRecordByTime(Date startDate, Date endDate){
		List tl = getHibernateTemplate().find("from ManualRecord mr where " +
				" mr.recordTime >= ? and mr.recordTime < ?", new Date[]{startDate, endDate});
		return tl;
	}
	
	public List findManualRecordByDate(String date){
		List tl = getHibernateTemplate().find("from ManualRecord mr where " +
				" mr.lessonDate = ? and mr.reasonType ='活动课' ", new String[]{date});
		return tl;
	}
	
	public List findExClassRecordByDate(String date){
		List tl = getHibernateTemplate().find("from ExClassRecord ecr where " +
				" ecr.classDate = ? order by ecr.classDate, ecr.startTime", new String[]{date});
		return tl;
	}
	
	public List findManualRecordByDate(String startDate, String endDate){
		List tl = getHibernateTemplate().find("from ManualRecord mr where " +
				" mr.lessonDate >= ? and mr.lessonDate <= ? order by mr.lessonDate, mr.emplID asc", new String[]{startDate, endDate});
		return tl;
	}
	
	public List findManualRecordByDate(String startDate, String endDate, String emplID){
		List tl = getHibernateTemplate().find("from ManualRecord mr where " +
				" mr.lessonDate >= ? and mr.lessonDate <= ? and mr.emplID = ? order by mr.lessonDate, mr.emplID asc", new String[]{startDate, endDate, emplID});
		return tl;
	}
	
	public List findManualRecordByDateIDName(String startDate, String endDate, String emplID, String emplName){
		List tl = getHibernateTemplate().find("from ManualRecord mr where " +
				" mr.lessonDate >= ? and mr.lessonDate <= ? and ( mr.emplID = ? or mr.emplName like '%"+emplName+"%') " +
				" order by mr.lessonDate, mr.emplID asc", new String[]{startDate, endDate, emplID});
		return tl;
	}
	
	public List findManualRecord(String emplID, String emplName){
		List tl = getHibernateTemplate().find("from ManualRecord mr where mr.status = '未刷卡' " +
				" and mr.emplID = ? or mr.emplName = ? ",
				new String[]{emplID, emplName});
		return tl;
	}
	
	public List findManualRecordByDateName(String startDate, String endDate, String emplName){
		List tl = getHibernateTemplate().find("from ManualRecord mr where " +
				" mr.lessonDate >= ? and mr.lessonDate <= ? and mr.emplName like '%"+emplName+"%'" +
				" order by mr.lessonDate, mr.emplID asc", new String[]{startDate, endDate});
		return tl;
	}

	public ManualRecord findManualRecord(int id){
			return (ManualRecord) getHibernateTemplate().get(ManualRecord.class, id);
	}
	
	public int getFinishedLessonNumber(String emplID){
		List tl = getHibernateTemplate().find("select count(*) from ManualRecord " +
				"as jm where jm.emplID = ? "
				, new String[] { emplID });
		if (tl != null && tl.size() >= 1) {
			long finishedLessonNumberLong = (Long) tl.get(0);
			/*if(tmp != null && tmp.size() >= 1){
				Integer finishedLessonNumber = (Integer) tmp.get(0);
				return finishedLessonNumber;
			}*/
			int finishedLessonNumber =  (int) finishedLessonNumberLong;
			return finishedLessonNumber;
		}
		return 0;
	}
	
	public ManualRecord findManualRecordByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber){
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String fullDateFormat = sdf.format(startDate);
		
		List lmr = getHibernateTemplate().find("from ManualRecord mr where mr.lessonDate = ? " +
				" and mr.roomID = ? and mr.lessonNumber = ?", 
				new Object[]{date, roomID, lessonNumber});
		if (lmr != null && lmr.size() >= 1) {
			return (ManualRecord) lmr.get(0);
		}
		return null;
		//return (ManualRecord) getHibernateTemplate().get(ManualRecord.class, id);
    }
	
	public List findManualRecordNumberByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber){
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String fullDateFormat = sdf.format(startDate);
		
		List lmr = getHibernateTemplate().find("from ManualRecord mr where mr.lessonDate = ? " +
				" and mr.roomID = ? and mr.lessonNumber = ?", 
				new Object[]{date, roomID, lessonNumber});
		//if (lmr != null && lmr.size() >= 1) {
			return lmr;
		//}
		//return null;
		//return (ManualRecord) getHibernateTemplate().get(ManualRecord.class, id);
    }
	
public List findManualRecordListByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber){
	   //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   //String fullDateFormat = sdf.format(startDate);
	   List lmr = getHibernateTemplate().find("from ManualRecord mr where mr.lessonDate = ? " +
				" and mr.roomID = ? and mr.lessonNumber = ?", 
				new Object[]{date, roomID, lessonNumber});
	   if (lmr != null && lmr.size() >= 1) {
			return lmr;
	   }
	   return null;
		//return (ManualRecord) getHibernateTemplate().get(ManualRecord.class, id);
    }
	
public List findStudentByEmplIDorName(String emplID, String emplName){
		
		List tl = getHibernateTemplate().find("from HrEmployee he where he.emplID = ? or he.emplName like '%"+emplName+"%'", 
				new String[]{emplID});
		return tl;
	}
	
	public HrEmployee findStudentByEmplID(String emplID){
		
		List tl = getHibernateTemplate().find("from HrEmployee he where he.emplID = ?", 
				new String[]{emplID});
		if (tl != null && tl.size() >= 1) {
			return (HrEmployee) tl.get(0);
		}
		return null;
	}
	
public HeInformation findHiByEmplID(String emplID){
		
		List tl = getHibernateTemplate().find("from HeInformation he where he.emplID = ?", 
				new String[]{emplID});
		if (tl != null && tl.size() >= 1) {
			return (HeInformation) tl.get(0);
		}
		return null;
	}
	
public HrEmployee findStudentByEmplName(String emplName){
		
		List tl = getHibernateTemplate().find("from HrEmployee he where he.emplName = ?", 
				new String[]{emplName});
		if (tl != null && tl.size() >= 1) {
			return (HrEmployee) tl.get(0);
		}
		return null;
	}
	
	public List findAllRoom(){
		List tl = getHibernateTemplate().find("from Classroom order by id asc");
		return tl;
	}
	
	public List findAllSubject(){
		List sl = getHibernateTemplate().find("select distinct subject from Cursch");
		return sl;
	}

	public EquCard findStuNameByCardNO(String cardNO) {
		List ecl = getHibernateTemplate().find(
				"from EquCard ec where ec.cardNO = ?", new String[] { cardNO });
		if (ecl != null && ecl.size() >= 1) {
			return (EquCard) ecl.get(0);
		}
		return null;
	}
	
	public EquCard findEquCardByEmplID(String emplID) {
		List ecl = getHibernateTemplate().find(
				"from EquCard ec where ec.emplID = ?", new String[] { emplID });
		if (ecl != null && ecl.size() >= 1) {
			return (EquCard) ecl.get(0);
		}
		return null;
	}

	public Classroom findRoomNOByEquNO(String equno) {
		List crl = getHibernateTemplate().find(
				"from Classroom cr where cr.equno = ?", new String[] { equno });
		if (crl != null && crl.size() >= 1) {
			return (Classroom) crl.get(0);
		}
		return null;
	}
	
	public Teacher findTeaByTeaID(String teaID){
		List tcl = getHibernateTemplate().find(
				"from Teacher tc where tc.teaid = ?", new String[] { teaID });
		if (tcl != null && tcl.size() >= 1) {
			return (Teacher) tcl.get(0);
		}
		return null;
	}

	public void saveTeacher(Teacher tc){
		getHibernateTemplate().saveOrUpdate(tc);
	}
	
	public void saveEmployee(HrEmployee he){
		getHibernateTemplate().saveOrUpdate(he);
	}
	
	public void saveEmployeeDetail(HeInformation hi){
		getHibernateTemplate().save(hi);
	}
	
	public void saveContract(Contract con){
		getHibernateTemplate().saveOrUpdate(con);
	}
	
	public void updateEmployeeDetail(HeInformation hi){
		getHibernateTemplate().update(hi);
	}
	
	public void saveMR(ManualRecord mr){
		getHibernateTemplate().saveOrUpdate(mr);
	}
	
	public void saveECR(ExClassRecord ecr){
		getHibernateTemplate().saveOrUpdate(ecr);
	}
	
	public void saveCursch(Cursch cs){
		getHibernateTemplate().saveOrUpdate(cs);
	}
	
	public void saveRoom(Classroom cr){
		getHibernateTemplate().saveOrUpdate(cr);
	}
	
	public void deleteTeacher(Teacher tc){
		getHibernateTemplate().delete(tc);
	}
	
	public void deleteContract(Contract con){
		getHibernateTemplate().delete(con);
	}
	
	public void deleteEmployee(HrEmployee he){
		getHibernateTemplate().delete(he);
	}
	
	public void deleteMR(ManualRecord mr){
		getHibernateTemplate().delete(mr);
	}
	
	public void deleteContractByNO(String contractNO){
		getHibernateTemplate().find("delete from Contract c where c.contractNO = ?", new String []{contractNO});
	}
	
	public void deleteCursch(Cursch cs){
		getHibernateTemplate().delete(cs);
	}
	
	public Cursch findCursch(String weekday, String roomNO, String time) {
		List csl = getHibernateTemplate()
				.find("from Cursch cs where cs.weekday = ? and cs.roomNO = ? and cs.fromtime <= ? and cs.totime >= ?",
						new String[] { weekday, roomNO, time, time});
		if (csl != null && csl.size() >= 1) {
			return (Cursch) csl.get(0);
		}
		return null;
	}
	
	public List findCurschListByTeaID(String teacherID) {
		List csl = getHibernateTemplate()
				.find("from Cursch cs where cs.teaid = ? order by cs.weekday",
						new String[] { teacherID});
		return csl;
	}
	
	public Cursch findCursch(String weekday,String roomNO, int sequenceNumber) {
		List csl = getHibernateTemplate()
				.find("from Cursch cs where cs.weekday = ? and cs.roomNO = ? and cs.sequenceNumber = ?",
						new Object[] { weekday, roomNO, sequenceNumber});
		if (csl != null && csl.size() >= 1) {
			return (Cursch) csl.get(0);
		}
		return null;
	}
	
	public Cursch findCursch(int id) {
		return (Cursch) getHibernateTemplate().get(Cursch.class, id);
	}

	public User findUserByName(String user) {
		List ul = getHibernateTemplate().find("from User au where au.user = ?",
				user);
		if (ul != null && ul.size() >= 1) {
			return (User) ul.get(0);
		}
		return null;
	}

	public List getScoreNewByClassidTitle(Integer classid,String title) {
		List rl = getHibernateTemplate().
//				SELECT e.id ,e.title, e.phaseid,e.classkey,e.examtype,e.subjectid,sn.id,sn.sid,sn.classkey,sn.subjectid,SN.phaseid,sn.examtype,sn.result FROM 
//				exam e,score_new sn
//				WHERE e.classkey=sn.classkey AND e.classkey=1 AND sn.examtype=e.examtype AND e.title='哲学考试' AND 
//				e.subjectid=sn.subjectid AND sn.result IN ('ABS-RA','Resit-RA','DISQ-RA');
				find("select e.title,sn.id,sn.sid,sn.classkey,sn.subjectid,sn.phaseid,sn.examtype,sn.result from Exam e,ScoreNew sn where " +
					 " e.classkey=sn.classkey and e.classkey=? and sn.examtype=e.examtype and e.displaystatus=4 and e.title=? and e.id=sn.examid and e.subjectid=sn.subjectid "+
					 " and sn.result in ('ABS-RA','Resit-RA','DISQ-RA')",new Object[]{classid,title});
		return rl;
	}

	 public List getScoreNewByClasskeySid(String sid,Integer classkey,Integer examid) {
			List rl = getHibernateTemplate().
					find("select e.title from Exam e,ScoreNew sn where " +
							" e.classkey=sn.classkey and sn.sid=? and sn.examtype=e.examtype and  e.subjectid=sn.subjectid and e.displaystatus=4 and sn.examid=e.id and e.classkey=? and sn.examid=?",new Object[]{sid,classkey,examid});
			return rl;
		}
	 public List getMajorList() {
		 List rl = getHibernateTemplate().
				 find("from Major m");
		 return rl;
	 }
  public List getSubjectnameListByTeachername(String teachername){
	  List rl=getHibernateTemplate().
			find("select distinct kc.subjectname from Kecheng kc,Kechengversion kcv  where kc.teacher = ? and kc.v_id=kcv.id and kcv.isvalid=1" ,new Object[]{teachername});
	  return rl;
  }  
  public List getClassnamenameListByAssistantname(String assistantname){
	  List rl=getHibernateTemplate().
			  find("select distinct kc.classname from Kecheng kc,Kechengversion kcv  where kc.teacher = ? and kc.v_id=kcv.id and kcv.isvalid=1" ,new Object[]{assistantname});
	  return rl;
  }  
  public List getClassListexceptById(Integer classid){
	  List rl=getHibernateTemplate().
			  find("from TClass t where t.id not in("+classid+")");
	  return rl;
  }
  public List getXszgtNoticeBytype(){
	  List rl=getHibernateTemplate().
			  find("from Notice n where n.type=4 and n.status=2");
	  return rl;
  }
  
  public List<Exam> getExamByNeishenyuanId(String tid){
	  List<Exam> rl=getHibernateTemplate().
			  find("from Exam e where e.displaystatus=5 and e.neishenyuanid='"+tid+"'");
	  return rl;
  }


//  下面代码由Alan增加 --Begin
  	public List getKechengListByDate(Date date) {
		String[] weekDays = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"};
		String weekdayStr = null;
      Calendar c=Calendar.getInstance();
      c.setTime(date);
      
     
      
      int weekday=c.get(Calendar.DAY_OF_WEEK);
      if (weekday < 0)
      	weekday = 0;
      weekdayStr = weekDays[weekday-1];
      
		List rl = getHibernateTemplate().
		   find("from Kecheng kc ,Kechengversion kcv where kc.weekday = ? and kc.v_id=kcv.id and kcv.isvalid=1", new Object[]{weekdayStr});
		return rl;
	}
  	public List getClassRoom() {
		List classroom = getHibernateTemplate().find("from Classroom ");
		
		return classroom;
	}

  	public List<ClassroomApply> getApplyClassroomList(){
	List applyclassroomlist=getHibernateTemplate().find("from ClassroomApply order by id desc");
	return applyclassroomlist;
}
  	public List<ClassroomApply> getApplyClassroomListByUser(String user){
	List applyclassroomlist=getHibernateTemplate().find("from ClassroomApply ca where ca.user= ?",user);
	return applyclassroomlist;
}
  	public List<ClassroomApply> getApplyClassroomListByDate(String date){
	List applyclassroomlist=getHibernateTemplate().find("from ClassroomApply ca where ca.sapplydate= ?",date);
	return applyclassroomlist;
}


  	public List<Adjust> getAdjustListByDateafter(String date) {	
	List adjustlist=getHibernateTemplate().find("from Adjust aj where aj.dateafter=? and status=4",date);
	return adjustlist;
}


  	public List<Adjust> getAdjustListByDatebefore(String date) {
	List adjustlist=getHibernateTemplate().find("from Adjust aj where aj.datebefore=? and status=4",date);
	return adjustlist;
}

	@Override
	//得到所有教室
	public List getAllClassRoom() throws Exception {
		List list = getHibernateTemplate().find("from Classroom");
		return list;
	}

	@Override
	//根据辅导员姓名得到全部信息
	public Assistant getAllAssistantByName(String name) throws Exception {
		if(!name.equals("")&&name!=null){
			Assistant ass = (Assistant) getHibernateTemplate().find("from Assistant where name=?").get(0);
			return ass;
		}else{
			return null;
		}
	}

//上段代码由Alan增加--End
}
  









