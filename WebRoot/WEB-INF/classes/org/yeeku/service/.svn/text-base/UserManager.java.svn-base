package org.yeeku.service;

import java.util.Date;
import java.util.List;

import org.yeeku.model.Absence;
import org.yeeku.model.Advice;
import org.yeeku.model.Assistant;
import org.yeeku.model.Classroom;
import org.yeeku.model.EnterApply;
import org.yeeku.model.Exam;
import org.yeeku.model.Ielts;
import org.yeeku.model.Jzletter;
import org.yeeku.model.Kecheng;
import org.yeeku.model.LetterTemplate;
import org.yeeku.model.Major;
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
 * @author  yeeku.H.lee zengjiuzhou@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.z
 * <br>Program Name:
 * <br>Date: 
 */ 
@SuppressWarnings("rawtypes")
public interface UserManager
{
    int addUser(String user , String pass , String email) 
		throws Exception;
    
    void updateUser(User user) throws Exception;
    
    void deleteUser(User user) throws Exception;
    
    void saveUser(User user) throws Exception;
    
    User getUserByID(int userID) throws Exception;
    
    List getAllUser() throws Exception;
    
    List getRoleList() throws Exception;
    
    List getNoticeListByClassid(Integer classid) throws Exception;
    
    List getNoticeList() throws Exception;
    
    Notice getNoticeById(Integer id) throws Exception;
    
    Major getMajorBymajorId(String majorid) throws Exception;
    
    List getNoticeListByPublisherid(Integer publisherid) throws Exception;
    
    List getNoticeListByPublisheridStatus(String noticetype,String username) throws Exception;
    
    List getStudentList() throws Exception;
    
    List<Student> getStudentList(String sid,String assiatantname) throws Exception;
    
    List getStudentListBysidclassName(String sid,String classname)throws Exception;
    
    List getStudentListBysidclassName(String sid)throws Exception;
    
    List getKechengList(Integer v_id) throws Exception;
    
    List getAllkechenglist(String name)throws Exception;
    
    List getAllkechenglist1()throws Exception;
    
    List getSec_KechengList() throws Exception;
    
    List getKechengby_subject_class_room(String username,String className,String classSubject,String classRoom,Integer v_id)throws Exception;
    
    List getKechengList(String name,Integer v_id) throws Exception;
    
    List getKechengListByVid(Integer vid) throws Exception;
    
    List getSec_KechengListByVid(Integer vid) throws Exception;
    
    List getSec_KechengListByVid(String name) throws Exception;
    
    List getKechengListById(Integer classroomsid)throws Exception;
    
    List<Kecheng> getKechengListByTclassnameAndTeachername(String teachername,Integer versionId)throws Exception;
    
    List<Student> getStudentListByassistant(String sid)throws Exception;
    
    
    List getSec_KechengListById(Integer classroomsid)throws Exception;
    
    List getKechengListByTeacher(String teachername) throws Exception;
    
    List getDistinctKechengListByTeacher(String teachername) throws Exception;
    
    List getDistinctSubjectListByTeacher(String teachername) throws Exception;
    
    List getSec_KechengListByTeacher(String teachername) throws Exception;
    
    List getKechengListClassByTeacher(String teachername) throws Exception;
    
    List getKechengListClassByTeacher1(String teachername) throws Exception;
    
    List getKechengListClassByTeacher1_(String teachername) throws Exception;
    
    List getKengchenglistClassRoom(String teachername) throws Exception;
    
    //List getKechengListClassByTeacher2(String id) throws Exception;
    List<Kecheng> getDistinctTeacherListByclassname(String classname) throws Exception;
    
    List getStudentListByClassname(String classname) throws Exception;
    
    List getStudentListByClassname_(String classname) throws Exception;
    
    List getHistoryStudentListByClassname(String classname) throws Exception;
    
    EnterApply getExamApply(String examid) throws Exception;
    
    List getStudentListByAssistantname(String assistantname) throws Exception;
    
    
    Teacher getTeacherByTid(String tid) throws Exception;
    
    Teacher getTeacherByName(String name) throws Exception;

    Kecheng getKechengjieke(String classname, String fromtime, String weekday) throws Exception;
    
    Kecheng getKechengjiekeNew(String classname, String fromtime, String weekday,Integer version) throws Exception;
    
    List<String> getKechengByclassnamesubjectname(String subjectname,String classname)throws Exception;
    
    List<String> getkechengteacherByclassname(String classname)throws Exception;
    
    Kecheng getKecheng(String classname,String subjectname,String weekday, String starttime,String teachername,Integer version)throws Exception;
    
    Kecheng getKechengjieke(String teacherName, String fromtime, String weekday,Integer version) throws Exception;
    
    Score getScoreForInput(String sid, Integer subjectid, Integer phaseid, Integer examtype) throws Exception;
    
    Score getScoreForInput(String sid, Integer subjectid, Integer phaseid) throws Exception;
    
    ScoreNew getScoreForInputNew(String sid, Integer subjectid, Integer phaseid) throws Exception;
    
    ScoreNew getButtonStatus(Integer examId) throws Exception;
    
    List<ScoreNew> getScore(String sid, Integer subjectid, Integer phaseid,Integer examType) throws Exception;
    
    List<ScoreNew> getScore(String sid, Integer subjectid, Integer phaseid,Integer examType,Integer examid) throws Exception;
    
    List getScore_(String sid, Integer subjectid, Integer phaseid,Integer examType) throws Exception;
    
	List getscore(String sid, Integer subjectid, Integer phaseid,Integer examType) throws Exception;
    
    List getscore_(String sid, Integer subjectid, Integer phaseid,Integer examType) throws Exception;
    
    TClass getClassByCid(String cid) throws Exception;
    
    TClass getClassByAssistantId(Integer assistantid) throws Exception;
    
    List<TClass> getClassByAssistantid(Integer assistantid) throws Exception;
    
    TClass getClassByName(String classname) throws Exception;
    
    List<Student> getStudentList(String sid) throws Exception;
    
    List<Integer> getScorenewBysid_(String sid)throws Exception;
    
    List<Integer> getSubjectidlist(String sid)throws Exception;
    
    List<Integer> getSubjectid_list(String classkey) throws Exception;
    
    List<Exam> getExamByPhaseid_Subjectid_Scoretype_Examtype(Integer phaseid,Integer subjectid,Integer examtype) throws Exception;
    
    List<TClass> getExamByPhaseid_Subjectid(Integer phaseid,Integer subjectid) throws Exception;
    
    List<Exam> getExamByPhaseid_Subjectid_Classkey(Integer phaseid,Integer subjectid,Integer classkey) throws Exception;
    
    Student getStudentBySid(String sid)throws Exception;
    
    Student getStudentBySid_(String sid)throws Exception;
    
    List<Student> getStudentListByStatus()throws Exception;
    
    List<Student> getStudentListByClassnameStatus(String classname)throws Exception;
    
    List<Advice> getAdviceByUser(String name) throws Exception;
    
    List<Advice> getAllAdviceList() throws Exception;
    
    List<Score> getStudentScoreList(String sid) throws Exception;
    
    List<Absence> getStudentAbsenceList(String sid) throws Exception;
    
    List<Absence> getAbsenceList() throws Exception;
    
    List<Absence> getAbsenceListByClassid(Integer classid) throws Exception;
    
    List getAbsenceByCondition(String teachername,String classid,String sid,String name,String subjectid,String status,String date) throws Exception;
    
    List<Absence> getAbsenceListBySid(String sid) throws Exception;
    
    List<Absence> getAbsenceListBySid(String sid,Integer classid) throws Exception;
    
    List<Absence> getAbsenceListBySid(String teachername,String sid,String classid,String subjectid,String status,String date) throws Exception;
    
    List<Absence> getAbsenceListByTeachername(String teachername) throws Exception;
    
    List<Reward> getStudentRewardList(String sid) throws Exception;
    
    List<Reward> getRewardList() throws Exception;
    
    List<Ielts> getStudentIeltsList(String sid) throws Exception;
    
    List<Ielts> getIeltsListInClassid(String classid) throws Exception;
    
    List<Ielts> getIeltsListInClassid(Integer classid) throws Exception;
    
    List<Ielts> getIeltsListBySid(String sid) throws Exception;
    
    List<Ielts> getAllIeltsList() throws Exception;
    
    List<Punish> getStudentPunishList(String sid) throws Exception;
    
    List<Punish> getPunishList() throws Exception;
    
    List getClassList() throws Exception;
    
    List getClassListByAssistantid(Integer assistantid) throws Exception;
    
    List getSubjectList() throws Exception;
    
    Subject getSubjectByName(String name) throws Exception;
    
    List getTeacherList() throws Exception;
    List getTeacherListNew() throws Exception;
    
    List getTeacherList(String username)throws Exception;
    
    List getAssistantList() throws Exception;
    
    List getAssistantList(Integer assistantid) throws Exception;
    
    Assistant getAssistantById(Integer id)throws Exception;
    
    List getAdjustList() throws Exception;
    
    List getGoodsList() throws Exception;
    
    List getAdjustList(String column_name,String desc,int from, int size)throws Exception;
    
    List getGoodsList(String column_name,String desc,int from, int size)throws Exception;
    
    List getAdjustList(Integer status,String classname) throws Exception;
    List getAdjustList(Integer status) throws Exception;
    
    List getAdjustList(String classname, String date, String starttime) throws Exception;
    
    List getAdjustListNew(String classname, String date, String starttime,Integer version) throws Exception;
    
    List getAdjustList(String teacherName, String date, String starttime,Integer version) throws Exception;
    
    List getAdjustListAfter(String teacherName, String date, String starttime,Integer version) throws Exception;
    
    List getAdjustListAfter(String classname, String date, String starttime) throws Exception;
    
    List getAdjustListAfterNew(String classname, String date, String starttime,Integer version) throws Exception;
    
    List getDelayList() throws Exception;
    
    List getExampjList() throws Exception;
    
    List getMyExampjList(String classname) throws Exception;
    
    List getLoggingList() throws Exception;
    
    Assistant getAssistantByName(String name) throws Exception;
    
    Assistant getAssistantByAid(String aid)throws Exception;
    
    List getRightList() throws Exception;
    
    List getRoleRight(Integer roleid) throws Exception;
    
    List getRoleRight(Integer roleid, String rightcode) throws Exception;
    
    User getUserByName(String userName) throws Exception;

    int loginValid(String user , String pass) 
		throws Exception;

	boolean validateName(String user)
		throws Exception;

	List getAdjustClassSubjectName(String classroom, String subjectname,
			String classname) throws Exception;

	List getKechengversionList() throws Exception;

	List getKechengversionList(Integer isvalid)throws Exception;
	
	List getKechengversionListById(Integer id)throws Exception;

	List<Notice> getNoticeListBytype(String noticetype,Integer type)throws Exception;
	
	List<Notice> getNoticeByusernametype(Integer type,String username)throws Exception;

	User getUserBytype(String usernmae,Integer type)throws Exception;
	
	Assistant getAssistantListByaid(String assistantaid)throws Exception;

	List getKechengListByclassname(String classname)throws Exception;

	List getKechengListClassByclassname(String clssname)throws Exception;

	List getAdjustByteacher(String username)throws Exception;

	List getAdjusBystatus()throws Exception;
	
	List<Notice> get_system_notice_list()throws Exception;
	
	List<Notice> getNoticeByassistantclassestype(Integer type,String classid)throws Exception;
	
	List<Notice> getNoticeBystudentclassestype(Integer type,Integer classid)throws Exception;

	List<Notice> getNoticeByAll()throws Exception;
	
    List<Notice> getNoticeByassistant()throws Exception;

    List<Notice> getNoticeByteacher()throws Exception;
	    
	List<Notice> getNoticeBystudent(String classid)throws Exception;
	
	List getAdjustBystudentstatus(String name)throws Exception;

	List<String>  getScorenewByClasskey(Integer classid)throws Exception;
	
	 List<String> getClassnameList()throws Exception;
	
	List<String> getExamByEdatephaseidClasskeySubjectid( Integer examtype,
			Integer phaseid, Integer classkey, Integer subjectid)throws Exception;

	List getScoreNewCountScoretype2(String sid)throws Exception;
	    
    List getScoreNewCountScoretype1(String sid)throws Exception;
    
    List getScoreNewCountScoretype_1(String sid)throws Exception;
    
    List getScoreNewCountScoretype3(String sid)throws Exception;
    
    List getScoreNewCountScoretype_3(String sid)throws Exception;

	List<Exam> getExamByClasskey(Integer classkey)throws Exception;	
	
	List getScoreNewByClassidTitle(Integer parseInt, String title)throws Exception;

	List<ScoreNew> getScoreNewByClasskeyByScoretype(Integer parseInt, Integer scoretype)throws Exception;
	
	List<ScoreNew> getScoreNewByClasskeyByScoretype(Integer parseInt)throws Exception;

	List<ScoreNew> getScoreNewList(String sid)throws Exception;

    List getScoreNewByClasskeySid(String sid,Integer classkey,Integer examid) throws Exception;

    List<Integer> getScoreNewListByClasskey() throws Exception;

	List<Object[]> getScoreNewBySid(String sid)throws Exception;

	List<Object[]> getScoreNewByClassid(Integer classid)throws Exception;

	List getMajorList()throws Exception;

	List getSubjectnameListByTeachername(String teachername)throws Exception;

	List getClassnamenameListByAssistantname(String assistantname)throws Exception;

	Classroom getClassroomListByCid(String cid)throws Exception;
	
	Classroom getClassroomListByroomid(String roomid)throws Exception;

	List<LetterTemplate> getLetterTemplateList()throws Exception;

	LetterTemplate getLetterTemplateListById(Integer id)throws Exception;

	List<Jzletter> getJzletterlist()throws Exception;

	Subject getSubjectBySubid(String subid)throws Exception;

	Classroom getClassroomByroomname(String roomname)throws Exception;
	
	Student getStudentBystatusDividestatus(String name)throws Exception;
	
	List getClassListexceptById(Integer classid)throws Exception;

	Kecheng getKechengByStartime(String username, String className,	String classSubject, String classRoom, String startTime,
			Integer v_id)throws Exception;

	List<Notice> getXszgtNoticeBytype()throws Exception;
	
	List<Exam> getExamByNeishenyuanId(String tid)throws Exception;

//	下面的代码由Alan增加--Begin
	List  getClassroomList() throws Exception;

	List getKechengListByDate(Date date) throws Exception;
	
	List getApplyClassroomList() throws Exception;
	
	List getApplyClassroomListByUser(String user) throws Exception;
	
	List getApplyClassroomListByDate(String date) throws Exception;
	List getAdjustListByDatebefore(String sapplydate) throws Exception;
	List getAdjustListByDateafter(String sapplydate) throws Exception;
//	上面的代码由Alan增加--End	

	// 得到所有教室
	@SuppressWarnings("unchecked")
	public List getAllClassRoom() throws Exception;
	// 根据姓名  得到辅导员信息
	public Assistant getAllAssistantByName(String name) throws Exception;
}