package org.yeeku.dao;

import java.util.Date;
import java.util.List;

import org.yeeku.model.*;

/**
 * @author yeeku.H.lee zengjiuzhou@163.com
 * @version 1.0 <br>
 *          Copyright (C), 2005-2008, yeeku.H.Lee <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: <br>
 *          Date:
 */

@SuppressWarnings("rawtypes")
public interface UserDao {
	/**
	 * ???id???????
	 * 
	 * @param id
	 *            ????????????id
	 */
	User get(int id);

	List getAllUser();

	/**
	 * ????????
	 * 
	 * @param user
	 *            ????????????
	 */
	void save(User user);

	/**
	 * ??????
	 * 
	 * @param user
	 *            ??????????
	 */
	void update(User user);

	/**
	 * ??????
	 * 
	 * @param id
	 *            ??????????id
	 */
	void delete(int id);

	/**
	 * ??????
	 * 
	 * @param user
	 *            ??????????
	 */
	void delete(User user);

	/**
	 * ?????????
	 * 
	 * @return ?????????
	 */
	List<User> findAll();

	/**
	 * ??????????????????
	 * 
	 * @param user
	 *            ?????????????
	 * @param pass
	 *            ????????????
	 * @return ????????
	 */
	User findUserByNameAndPass(String user, String pass);

	/**
	 * ??????????????????
	 * 
	 * @param user
	 *            ?????????????
	 * @param pass
	 *            ????????????
	 * @return ????????
	 */
	// 教务管理系统方法 开始
	List getRoleRight(Integer roleid);

	List getRoleRight(Integer roleid, String rightcode);

	List getRoleList();

	List getNoticeListByClassid(Integer classid);

	List getNoticeList();

	Notice getNoticeById(Integer id);

	Major getMajorBymajorId(String Majorid);

	List getNoticeListByPublisherid(Integer publisherid);

	List getNoticeListByPublisheridStatus(String noticetype, String username);

	List getStudentList();

	List getKechengList(Integer v_id);

	List getAllkechenglist(String name);

	List getAllkechenglist1();

	List getSec_KechengList();

	List getKechengby_subject_class_room(String username, String className,
			String classSubject, String classRoom, Integer v_id);

	List getKechengList(String name, Integer v_id);

	List getSec_KechengListByVid(String name);

	List getKechengListByVid(Integer vid);

	List getKechengversionList();

	List getKechengversionListById(Integer id);

	List<Notice> getNoticeListBytype(String noticetype, Integer type);

	List getScoreNewCountScoretype2(String sid);

	List getScoreNewCountScoretype1(String sid);

	List getScoreNewCountScoretype_1(String sid);

	List getScoreNewCountScoretype3(String sid);

	List getScoreNewCountScoretype_3(String sid);

	List<Integer> getScoreNewListByClasskey();

	List<Object[]> getScoreNewBySid(String sid);

	List<Object[]> getScoreNewByClassid(Integer classid);

	// List<Notice> getNoticeListAcceptTeacherByXs(Integer publisherid,Integer
	// type);

	List getKechengversionList(Integer isvalid);

	List getSec_KechengListByVid(Integer vid);

	List getKechengListById(Integer classroomsid);

	List<Kecheng> getKechengListByTclassnameAndTeachername(String teachername,
			Integer versionId);

	List getSec_KechengListById(Integer classroomsid);

	List getKechengListByTeacher(String teachername);

	List getDistinctKechengListByTeacher(String teachername);

	List getDistinctSubjectListByTeacher(String teachername);

	List getSec_KechengListByTeacher(String teachername);

	List getKechengListClassByTeacher(String teachername);

	List getKechengListClassByTeacher1(String teachername);

	List getKechengListClassByTeacher1_(String teachername);

	List getStudentListByClassname(String classname);

	List getStudentListByClassname_(String classname);

	List<Kecheng> getDistinctTeacherListByclassname(String classname);

	List getHistoryStudentListByClassname(String classname);

	EnterApply getExamApply(String examid);

	List getStudentListByAssistantname(String assistantname);

	List<Student> getStudentList(String sid);

	List<Student> getStudentList(String sid, String assiatantname);

	List getStudentListBysidclassName(String sid, String classname);

	List getStudentListBysidclassName(String sid);

	List<Exam> getExamByPhaseid_Subjectid_Scoretype_Examtype(Integer phaseid,
			Integer subjectid, Integer examtype);

	List<Exam> getExamByPhaseid_Subjectid_Classkey(Integer phaseid,
			Integer subjectid, Integer classkey);

	List<TClass> getExamByPhaseid_Subjectid(Integer phaseid, Integer subjectid);

	Student getStudentBySid(String sid);

	Student getStudentBySid_(String sid);

	List<Student> getStudentListByStatus();

	List<Student> getStudentListByClassnameStatus(String classname);

	List<Advice> getAdviceByUser(String name);

	List<Advice> getAllAdviceList();

	List<Score> getStudentScoreList(String sid);

	List<Absence> getStudentAbsenceList(String sid);

	List<Absence> getAbsenceList();

	List<Absence> getAbsenceListByClassid(Integer classid);

	List getAbsenceByCondition(String teachername, String classid, String sid,
			String name, String subjectid, String status, String date);

	List<Absence> getAbsenceListBySid(String sid);

	List<Absence> getAbsenceListBySid(String sid, Integer classid);

	List<Absence> getAbsenceListBySid(String teachername, String sid,
			String classid, String subjectid, String status, String date);

	List<Absence> getAbsenceListByTeachername(String teachername);

	Kecheng getKechengByStartime(String username, String className,
			String classSubject, String classRoom, String startTime,
			Integer v_id);

	List<Reward> getStudentRewardList(String sid);

	List<Reward> getRewardList();

	List<Ielts> getStudentIeltsList(String sid);

	List<Ielts> getIeltsListInClassid(String classid);

	List<Ielts> getIeltsListInClassid(Integer classid);

	List<Ielts> getIeltsListBySid(String sid);

	List<Ielts> getAllIeltsList();

	List<Punish> getStudentPunishList(String sid);

	List<Exam> getExamByClasskey(Integer classkey);

	List<ScoreNew> getScoreNewByClasskeyByScoretype(Integer classkey,
			Integer scoretype);

	List<ScoreNew> getScoreNewByClasskeyByScoretype(Integer classkey);

	// List<ScoreNew> getScoreNewList(Integer classkey);

	List<ScoreNew> getScoreNewList(String sid);

	List<LetterTemplate> getLetterTemplateList();

	List<Jzletter> getJzletterlist();

	LetterTemplate getLetterTemplateListById(Integer id);

	Subject getSubjectBySubid(String subid);

	Classroom getClassroomByroomname(String roomname);

	Student getStudentBystatusDividestatus(String name);

	List<Punish> getPunishList();

	List getClassList();

	List getClassListByAssistantid(Integer assistantid);

	List getSubjectList();

	Subject getSubjectByName(String name);

	List getTeacherList(String username);

	List getTeacherList();

	List getTeacherListNew();

	Teacher getTeacherByTid(String tid);

	Teacher getTeacherByName(String name);

	Kecheng getKechengjieke(String classname, String fromtime, String weekday);

	Kecheng getKechengjiekeNew(String classname, String fromtime,
			String weekday, Integer version);

	Kecheng getKechengjieke(String teacherName, String fromtime,
			String weekday, Integer version);

	Score getScoreForInput(String sid, Integer subjectid, Integer phaseid,
			Integer examtype);

	Score getScoreForInput(String sid, Integer subjectid, Integer phaseid);

	ScoreNew getScoreForInputNew(String sid, Integer subjectid, Integer phaseid);

	ScoreNew getButtonStatus(Integer examId);

	List<ScoreNew> getScore(String sid, Integer subjectid, Integer phaseid,
			Integer examType);

	List<ScoreNew> getScore(String sid, Integer subjectid, Integer phaseid,
			Integer examType, Integer examid);

	List getScore_(String sid, Integer subjectid, Integer phaseid,
			Integer examType);

	List getscore(String sid, Integer subjectid, Integer phaseid,
			Integer examType);

	List getscore_(String sid, Integer subjectid, Integer phaseid,
			Integer examType);

	TClass getClassByCid(String cid);

	TClass getClassByAssistantId(Integer assistantid);

	List<TClass> getClassByAssistantid(Integer assistantid);

	Assistant getAssistantById(Integer id);

	TClass getClassByName(String classname);

	List getAssistantList();

	List getAssistantList(Integer assistantid);

	List getAdjustList();

	List getAdjusBystatus();

	List<Notice> get_system_notice_list();

	List<Notice> getNoticeByusernametype(Integer type, String username);

	List<Notice> getNoticeByassistantclassestype(Integer type, String classid);

	List<Notice> getNoticeBystudentclassestype(Integer type, Integer classid);

	List<Notice> getNoticeByAll();

	List<Notice> getNoticeByassistant();

	List<Notice> getNoticeByteacher();

	List<Notice> getNoticeBystudent(String classid);

	List getAdjustBystudentstatus(String name);

	List<String> getScorenewByClasskey(Integer classid);

	List<Integer> getScorenewBysid_(String sid);

	List<Integer> getSubjectidlist(String sid);

	List<String> getClassnameList();

	List<Integer> getSubjectid_list(String sid);

	List<String> getkechengteacherByclassname(String classname);

	List<String> getExamByEdatephaseidClasskeySubjectid(Integer examtype,
			Integer phaseid, Integer classkey, Integer subjectid);

	List<String> getKechengByclassnamesubjectname(String subjectname,
			String classname);

	List getGoodsList();

	List getKechengListClassByclassname(String classname);

	List getAdjustByteacher(String username);

	List getAdjustList(String column_name, String desc, int from, int size);

	List getGoodsList(String column_name, String desc, int from, int size);

	List getAdjustList(Integer status, String classname);

	List getAdjustList(Integer status);

	List<Student> getStudentListByassistant(String assistant);

	List getAdjustList(String classname, String date, String starttime);

	List getAdjustListNew(String classname, String date, String starttime,
			Integer version);

	List getAdjustList(String teacherName, String date, String starttime,
			Integer version);

	List getAdjustListAfter(String teacherName, String date, String starttime,
			Integer version);

	List getAdjustListAfter(String classname, String date, String starttime);

	List getAdjustListAfterNew(String classname, String date, String starttime,
			Integer version);

	List getDelayList();

	List getExampjList();

	List getMyExampjList(String classname);

	List getLoggingList();

	Assistant getAssistantByName(String name);

	Assistant getAssistantByAid(String aid);

	List getRightList();

	// 教务管理系统方法 结束

	List findAllRecord(String startDate, String endDate);

	List findAllRecord(String startDate, String endDate, String cardNO);

	List findCurrentRecordList();

	List findAllTeacher();

	List findStudentByIDOrName(String emplID, String emplName);

	List findStuRank(Date startDate, Date endDate);

	List findAllStudent();

	List getUncheckedStudentList();

	List searchEmployee(String emplName);

	List findAllContract();

	List getListUncheckedContract();

	List findContractByNO(String contractNO);

	List findContractByName(String name);

	String findMaxContractNo();

	List findAllEmplName();

	String findMaxEmployeeNo();

	Contract findContractByEmplID(String emplID);

	List findManualRecord();

	List findManualRecordByTime(Date startDate, Date endDate);

	List findManualRecordByDate(String date);

	List findExClassRecordByDate(String date);

	List findManualRecordByDate(String startDate, String endDate);

	List findManualRecordByDate(String startDate, String endDate, String emplID);

	List findManualRecordByDateIDName(String startDate, String endDate,
			String emplID, String emplName);

	List findManualRecordByDateName(String startDate, String endDate,
			String emplName);

	List findManualRecord(String emplID, String emplName);

	Kecheng getKecheng(String classname, String subjectname, String weekday,
			String starttime, String teachername, Integer version)
			throws Exception;

	ManualRecord findManualRecord(int id);

	ManualRecord findManualRecordByDate(String date, Date startDate,
			Date endDate, int roomID, int lessonNumber);

	List findManualRecordNumberByDate(String date, Date startDate,
			Date endDate, int roomID, int lessonNumber);

	int getFinishedLessonNumber(String emplID);

	List findManualRecordListByDate(String date, Date startDate, Date endDate,
			int roomID, int lessonNumber);

	List findStudentByEmplIDorName(String emplID, String emplName);

	HrEmployee findStudentByEmplID(String emplID);

	HeInformation findHiByEmplID(String emplID);

	HrEmployee findStudentByEmplName(String emplName);

	List findAllRoom();

	List findAllSubject();

	EquCard findStuNameByCardNO(String cardNO);

	EquCard findEquCardByEmplID(String emplID);

	Classroom findRoomNOByEquNO(String equNO);

	Classroom findRoomByID(int id);

	Teacher findTeaByTeaID(String teaID);

	void deleteTeacher(Teacher tc);

	void deleteContract(Contract con);

	void deleteEmployee(HrEmployee he);

	void deleteMR(ManualRecord mr);

	void deleteContractByNO(String contractNO);

	void deleteCursch(Cursch cs);

	void saveTeacher(Teacher tc);

	void saveEmployee(HrEmployee he);

	void saveEmployeeDetail(HeInformation hi);

	void saveContract(Contract con);

	void updateEmployeeDetail(HeInformation hi);

	void saveRoom(Classroom cr);

	void saveMR(ManualRecord mr);

	void saveECR(ExClassRecord ecr);

	void saveCursch(Cursch cs);

	Cursch findCursch(String weekday, String roomNO, String time);

	Cursch findCursch(int id);

	List findCurschListByTeaID(String teacherID);

	List getKechengListByclassname(String classname);

	Cursch findCursch(String weekday, String roomNO, int sequenceNumber);

	/**
	 * ??????????????
	 * 
	 * @param user
	 *            ?????????????
	 * @return ????????
	 */
	User findUserByName(String user);

	List getKengchenglistClassRoom(String teachername);

	List getAdjustClassSubjectName(String classroom, String subjectname,
			String classname);

	User getUserBytype(String username, Integer type);

	Assistant getAssistantListByaid(String assistantaid);

	Classroom getClassroomListByCid(String cid);

	Classroom getClassroomListByroomid(String roomid);

	List getScoreNewByClassidTitle(Integer classid, String title);

	List getScoreNewByClasskeySid(String sid, Integer classkey, Integer examid);

	List getMajorList();

	List getSubjectnameListByTeachername(String teachername);

	List getClassnamenameListByAssistantname(String assistantname);

	List getClassListexceptById(Integer classid);

	List getXszgtNoticeBytype();

	List<Exam> getExamByNeishenyuanId(String tid);

	// 下面的代码由Alan增加--Begin
	List<Classroom> getClassRoom();

	List getKechengListByDate(Date date);

	List<ClassroomApply> getApplyClassroomList();

	List<ClassroomApply> getApplyClassroomListByUser(String user);

	List<ClassroomApply> getApplyClassroomListByDate(String date);

	List<Adjust> getAdjustListByDatebefore(String date);

	List<Adjust> getAdjustListByDateafter(String date);

	// 上面的代码由Alan增加--End
	// 得到所有教室
	public List getAllClassRoom() throws Exception;
	// 根据姓名  得到辅导员信息
	public Assistant getAllAssistantByName(String name) throws Exception;
}