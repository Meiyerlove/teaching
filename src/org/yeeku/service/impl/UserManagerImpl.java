package org.yeeku.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.yeeku.dao.UserDao;
import org.yeeku.model.Absence;
import org.yeeku.model.Adjust;
import org.yeeku.model.Advice;
import org.yeeku.model.Assistant;
import org.yeeku.model.Classroom;
import org.yeeku.model.ClassroomApply;
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
import org.yeeku.model.RoleRight;
import org.yeeku.model.Score;
import org.yeeku.model.ScoreNew;
import org.yeeku.model.Student;
import org.yeeku.model.Subject;
import org.yeeku.model.TClass;
import org.yeeku.model.Teacher;
import org.yeeku.model.User;
import org.yeeku.service.UserManager;
import org.yeeku.dao.UserDao;
import org.yeeku.service.UserManager;

/**
 * @author yeeku.H.lee zengjiuzhou@163.com
 * @version 1.0 <br>
 *          Copyright (C), 2005-2008, yeeku.H.Lee <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: <br>
 *          Date:
 */
public class UserManagerImpl implements UserManager {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int addUser(String user, String pass, String email) throws Exception {
		try {
			User u = new User();
			u.setUser(user);
			u.setPass(pass);
			u.setEmail(email);
			userDao.save(u);
			return u.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public void updateUser(User user) throws Exception {
		try {
			userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public void deleteUser(User user) throws Exception {
		try {
			userDao.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public void saveUser(User user) throws Exception {
		try {
			userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public User getUserByID(int userID) throws Exception {
		try {
			User u = new User();
			u = userDao.get(userID);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAllUser() throws Exception {
		try {
			List userList = new ArrayList();
			userList = userDao.getAllUser();
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getRoleList() throws Exception {
		try {
			List roleList = new ArrayList();
			roleList = userDao.getRoleList();
			return roleList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getNoticeListByClassid(Integer classid) throws Exception {
		try {
			List noticeList = new ArrayList();
			noticeList = userDao.getNoticeListByClassid(classid);
			return noticeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getNoticeList() throws Exception {
		try {
			List noticeList = new ArrayList();
			noticeList = userDao.getNoticeList();
			return noticeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Notice getNoticeById(Integer id) throws Exception {
		try {
			// List noticeList = new ArrayList();
			Notice notice = userDao.getNoticeById(id);
			return notice;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Major getMajorBymajorId(String majorid) throws Exception {
		try {
			Major major = userDao.getMajorBymajorId(majorid);
			return major;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getNoticeListByPublisherid(Integer publisherid)
			throws Exception {
		try {
			List noticeList = new ArrayList();
			noticeList = userDao.getNoticeListByPublisherid(publisherid);
			return noticeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getNoticeListByPublisheridStatus(String noticetype,
			String username) throws Exception {
		try {
			List noticeList = new ArrayList();
			noticeList = userDao.getNoticeListByPublisheridStatus(noticetype,
					username);
			return noticeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getStudentList() throws Exception {
		try {
			List studentList = new ArrayList();
			studentList = userDao.getStudentList();
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengList(Integer v_id) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengList(v_id);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAllkechenglist(String name) throws Exception {
		try {
			List allKechengList = new ArrayList();
			allKechengList = userDao.getAllkechenglist(name);
			return allKechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAllkechenglist1() throws Exception {
		try {
			List allKechengList = new ArrayList();
			allKechengList = userDao.getAllkechenglist1();
			return allKechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getSec_KechengList() throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getSec_KechengList();
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengby_subject_class_room(String username,
			String className, String classSubject, String classRoom,
			Integer v_id) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengby_subject_class_room(username,
					className, classSubject, classRoom, v_id);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengList(String name, Integer v_id) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengList(name, v_id);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getSec_KechengListByVid(String name) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getSec_KechengListByVid(name);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListByVid(Integer vid) throws Exception {
		try {
			List kechenglist = new ArrayList();
			kechenglist = userDao.getKechengListByVid(vid);
			return kechenglist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getSec_KechengListByVid(Integer vid) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getSec_KechengListByVid(vid);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListById(Integer classroomsid) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengListById(classroomsid);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Kecheng> getKechengListByTclassnameAndTeachername(
			String teachername, Integer versionId) throws Exception {
		try {
			List<Kecheng> kechengList = new ArrayList<Kecheng>();
			kechengList = userDao.getKechengListByTclassnameAndTeachername(
					teachername, versionId);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getSec_KechengListById(Integer classroomsid) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getSec_KechengListById(classroomsid);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListByTeacher(String teachername) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengListByTeacher(teachername);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getDistinctKechengListByTeacher(String teachername)
			throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getDistinctKechengListByTeacher(teachername);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getDistinctSubjectListByTeacher(String teachername)
			throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getDistinctSubjectListByTeacher(teachername);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getSec_KechengListByTeacher(String teachername)
			throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getSec_KechengListByTeacher(teachername);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListClassByTeacher(String teachername)
			throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengListClassByTeacher(teachername);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListClassByTeacher1(String teachername)
			throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengListClassByTeacher1(teachername);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListClassByTeacher1_(String teachername)
			throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengListClassByTeacher1_(teachername);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKengchenglistClassRoom(String teachername) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKengchenglistClassRoom(teachername);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListClassByTeacher2(String id) throws Exception {
		try {
			List kechengList = new ArrayList();
			kechengList = userDao.getKechengListClassByTeacher1(id);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getStudentListByClassname(String classname) throws Exception {
		try {
			List studentList = new ArrayList();
			studentList = userDao.getStudentListByClassname(classname);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getStudentListByClassname_(String classname) throws Exception {
		try {
			List studentList = new ArrayList();
			studentList = userDao.getStudentListByClassname_(classname);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getDistinctTeacherListByclassname(String classname)
			throws Exception {
		try {
			List<Kecheng> kechengList = new ArrayList<Kecheng>();
			kechengList = userDao.getDistinctTeacherListByclassname(classname);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getHistoryStudentListByClassname(String classname)
			throws Exception {
		try {
			List studentList = new ArrayList();
			studentList = userDao.getHistoryStudentListByClassname(classname);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public EnterApply getExamApply(String examid) throws Exception {
		try {
			EnterApply ea = new EnterApply();
			ea = userDao.getExamApply(examid);
			return ea;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getStudentListByAssistantname(String assistant)
			throws Exception {
		try {
			List studentList = new ArrayList();
			studentList = userDao.getStudentListByAssistantname(assistant);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Teacher getTeacherByTid(String tid) throws Exception {
		try {
			// List teacherList = new ArrayList();
			Teacher teacher = userDao.getTeacherByTid(tid);
			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Teacher getTeacherByName(String name) throws Exception {
		try {
			// List teacherList = new ArrayList();
			Teacher teacher = userDao.getTeacherByName(name);
			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Kecheng getKechengjieke(String classname, String fromtime,
			String weekday) throws Exception {
		try {
			// List teacherList = new ArrayList();
			Kecheng kecheng = userDao.getKechengjieke(classname, fromtime,
					weekday);
			return kecheng;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Kecheng getKechengjiekeNew(String classname, String fromtime,
			String weekday, Integer version) throws Exception {
		try {
			// List teacherList = new ArrayList();
			Kecheng kecheng = userDao.getKechengjiekeNew(classname, fromtime,
					weekday, version);
			return kecheng;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Kecheng getKecheng(String classname, String subjectname,
			String weekday, String starttime, String teachername,
			Integer version) throws Exception {
		try {
			// List teacherList = new ArrayList();
			Kecheng kecheng = userDao.getKecheng(classname, subjectname,
					weekday, starttime, teachername, version);
			return kecheng;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Kecheng getKechengjieke(String teacherName, String fromtime,
			String weekday, Integer version) throws Exception {
		try {
			// List teacherList = new ArrayList();
			Kecheng kecheng = userDao.getKechengjieke(teacherName, fromtime,
					weekday, version);
			return kecheng;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Score getScoreForInput(String sid, Integer subjectid,
			Integer phaseid, Integer examtype) throws Exception {
		try {
			// List teacherList = new ArrayList();
			Score score = userDao.getScoreForInput(sid, subjectid, phaseid,
					examtype);
			return score;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Score getScoreForInput(String sid, Integer subjectid, Integer phaseid)
			throws Exception {
		try {
			// List teacherList = new ArrayList();
			Score score = userDao.getScoreForInput(sid, subjectid, phaseid);
			return score;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public ScoreNew getScoreForInputNew(String sid, Integer subjectid,
			Integer phaseid) throws Exception {
		try {
			// List teacherList = new ArrayList();
			ScoreNew score = userDao.getScoreForInputNew(sid, subjectid,
					phaseid);
			return score;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public ScoreNew getButtonStatus(Integer examId) throws Exception {
		try {
			// List teacherList = new ArrayList();
			ScoreNew score = userDao.getButtonStatus(examId);
			return score;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<ScoreNew> getScore(String sid, Integer subjectid,
			Integer phaseid, Integer examType) throws Exception {
		try {
			List<ScoreNew> scoreList = new ArrayList();
			scoreList = userDao.getScore(sid, subjectid, phaseid, examType);
			return scoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<ScoreNew> getScore(String sid, Integer subjectid,
			Integer phaseid, Integer examType, Integer examid) throws Exception {
		try {
			List<ScoreNew> scoreList = new ArrayList();
			scoreList = userDao.getScore(sid, subjectid, phaseid, examType,
					examid);
			return scoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getScore_(String sid, Integer subjectid, Integer phaseid,
			Integer examType) throws Exception {
		try {
			List scoreList = new ArrayList();
			scoreList = userDao.getScore_(sid, subjectid, phaseid, examType);
			return scoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getscore(String sid, Integer subjectid, Integer phaseid,
			Integer examType) throws Exception {
		try {
			List scoreList = new ArrayList();
			scoreList = userDao.getscore(sid, subjectid, phaseid, examType);
			return scoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getscore_(String sid, Integer subjectid, Integer phaseid,
			Integer examType) throws Exception {
		try {
			List scoreList = new ArrayList();
			scoreList = userDao.getscore_(sid, subjectid, phaseid, examType);
			return scoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public TClass getClassByCid(String cid) throws Exception {
		try {
			// List teacherList = new ArrayList();
			TClass tclass = userDao.getClassByCid(cid);
			return tclass;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public TClass getClassByAssistantId(Integer assistantid) throws Exception {
		try {
			// List teacherList = new ArrayList();
			TClass tclass = userDao.getClassByAssistantId(assistantid);
			return tclass;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<TClass> getClassByAssistantid(Integer assistantid)
			throws Exception {
		try {
			List<TClass> tclassList = new ArrayList<TClass>();
			tclassList = userDao.getClassByAssistantid(assistantid);
			return tclassList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public TClass getClassByName(String classname) throws Exception {
		try {
			// List teacherList = new ArrayList();
			TClass tclass = userDao.getClassByName(classname);
			return tclass;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Student> getStudentList(String sid) throws Exception {
		try {
			List<Student> studentList = new ArrayList<Student>();
			studentList = (ArrayList) userDao.getStudentList(sid);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Student> getStudentList(String sid, String assiatantname)
			throws Exception {
		try {
			List<Student> studentList = new ArrayList<Student>();
			studentList = (ArrayList) userDao
					.getStudentList(sid, assiatantname);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getStudentListBysidclassName(String sid, String classname)
			throws Exception {
		try {
			List studentList = new ArrayList();
			studentList = userDao.getStudentListBysidclassName(sid, classname);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getStudentListBysidclassName(String sid) throws Exception {
		try {
			List studentList = new ArrayList();
			studentList = userDao.getStudentListBysidclassName(sid);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Exam> getExamByPhaseid_Subjectid_Scoretype_Examtype(
			Integer phaseid, Integer subjectid, Integer examtype)
			throws Exception {
		try {
			List<Exam> examList = new ArrayList<Exam>();
			examList = (ArrayList) userDao
					.getExamByPhaseid_Subjectid_Scoretype_Examtype(phaseid,
							subjectid, examtype);
			return examList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Exam> getExamByPhaseid_Subjectid_Classkey(Integer phaseid,
			Integer subjectid, Integer classkey) throws Exception {
		try {
			List<Exam> examList = new ArrayList<Exam>();
			examList = (ArrayList) userDao.getExamByPhaseid_Subjectid_Classkey(
					phaseid, subjectid, classkey);
			return examList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<TClass> getExamByPhaseid_Subjectid(Integer phaseid,
			Integer subjectid) throws Exception {
		try {
			List<TClass> tclassList = new ArrayList<TClass>();
			tclassList = (ArrayList) userDao.getExamByPhaseid_Subjectid(
					phaseid, subjectid);
			return tclassList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Student> getStudentListByStatus() throws Exception {
		try {
			List<Student> studentList = new ArrayList<Student>();
			studentList = (ArrayList) userDao.getStudentListByStatus();
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Student> getStudentListByClassnameStatus(String classname)
			throws Exception {
		try {
			List<Student> studentList = new ArrayList<Student>();
			studentList = (ArrayList) userDao
					.getStudentListByClassnameStatus(classname);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Advice> getAdviceByUser(String name) throws Exception {
		try {
			List<Advice> adviceList = new ArrayList<Advice>();
			adviceList = (ArrayList) userDao.getAdviceByUser(name);
			return adviceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Advice> getAllAdviceList() throws Exception {
		try {
			List<Advice> adviceList = new ArrayList<Advice>();
			adviceList = (ArrayList) userDao.getAllAdviceList();
			return adviceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Student> getStudentListByassistant(String assistant)
			throws Exception {
		try {
			List<Student> studentList = new ArrayList<Student>();
			studentList = (ArrayList) userDao
					.getStudentListByassistant(assistant);
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Score> getStudentScoreList(String sid) throws Exception {
		try {
			List<Score> scoreList = new ArrayList<Score>();
			scoreList = (ArrayList) userDao.getStudentScoreList(sid);
			return scoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Absence> getStudentAbsenceList(String sid) throws Exception {
		try {
			List<Absence> absenceList = new ArrayList<Absence>();
			absenceList = (ArrayList) userDao.getStudentAbsenceList(sid);
			return absenceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Absence> getAbsenceList() throws Exception {
		try {
			// List<Absence> absenceList = new ArrayList<Absence>();
			List<Absence> absenceList = (ArrayList) userDao.getAbsenceList();
			return absenceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Absence> getAbsenceListByClassid(Integer classid)
			throws Exception {
		try {
			List<Absence> absenceList = new ArrayList<Absence>();
			absenceList = (ArrayList) userDao.getAbsenceListByClassid(classid);
			return absenceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAbsenceByCondition(String teachername, String classid,
			String sid, String name, String subjectid, String status,
			String date) throws Exception {
		try {
			List absenceList = new ArrayList();
			absenceList = (ArrayList) userDao.getAbsenceByCondition(
					teachername, classid, sid, name, subjectid, status, date);
			return absenceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Absence> getAbsenceListBySid(String sid) throws Exception {
		try {
			List<Absence> absenceList = new ArrayList<Absence>();
			absenceList = (ArrayList) userDao.getAbsenceListBySid(sid);
			return absenceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Absence> getAbsenceListBySid(String sid, Integer classid)
			throws Exception {
		try {
			List<Absence> absenceList = new ArrayList<Absence>();
			absenceList = (ArrayList) userDao.getAbsenceListBySid(sid, classid);
			return absenceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Absence> getAbsenceListBySid(String teachername, String sid,
			String classid, String subjectid, String status, String date)
			throws Exception {
		try {
			List<Absence> absenceList = new ArrayList<Absence>();
			absenceList = (ArrayList) userDao.getAbsenceListBySid(teachername,
					sid, classid, subjectid, status, date);
			return absenceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Absence> getAbsenceListByTeachername(String teachername)
			throws Exception {
		try {
			List<Absence> absenceList = new ArrayList<Absence>();
			absenceList = (ArrayList) userDao
					.getAbsenceListByTeachername(teachername);
			return absenceList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Reward> getStudentRewardList(String sid) throws Exception {
		try {
			List<Reward> rewardList = new ArrayList<Reward>();
			rewardList = (ArrayList) userDao.getStudentRewardList(sid);
			return rewardList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Reward> getRewardList() throws Exception {
		try {
			List<Reward> rewardList = new ArrayList<Reward>();
			rewardList = (ArrayList) userDao.getRewardList();
			return rewardList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Ielts> getStudentIeltsList(String sid) throws Exception {
		try {
			List<Ielts> ieltsList = new ArrayList<Ielts>();
			ieltsList = (ArrayList) userDao.getStudentIeltsList(sid);
			return ieltsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Ielts> getIeltsListInClassid(String classid) throws Exception {
		try {
			List<Ielts> ieltsList = new ArrayList<Ielts>();
			ieltsList = (ArrayList) userDao.getIeltsListInClassid(classid);
			return ieltsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Ielts> getIeltsListInClassid(Integer classid) throws Exception {
		try {
			List<Ielts> ieltsList = new ArrayList<Ielts>();
			ieltsList = (ArrayList) userDao.getIeltsListInClassid(classid);
			return ieltsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Ielts> getIeltsListBySid(String sid) throws Exception {
		try {
			List<Ielts> ieltsList = new ArrayList<Ielts>();
			ieltsList = (ArrayList) userDao.getIeltsListBySid(sid);
			return ieltsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Ielts> getAllIeltsList() throws Exception {
		try {
			List<Ielts> ieltsList = new ArrayList<Ielts>();
			ieltsList = (ArrayList) userDao.getAllIeltsList();
			return ieltsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Punish> getStudentPunishList(String sid) throws Exception {
		try {
			List<Punish> punishList = new ArrayList<Punish>();
			punishList = (ArrayList) userDao.getStudentPunishList(sid);
			return punishList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Exam> getExamByClasskey(Integer classkey) throws Exception {
		try {
			List<Exam> examList = new ArrayList<Exam>();
			examList = (ArrayList) userDao.getExamByClasskey(classkey);
			return examList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<ScoreNew> getScoreNewByClasskeyByScoretype(Integer classkey,
			Integer scoretype) throws Exception {
		try {
			List<ScoreNew> scorenewList = new ArrayList<ScoreNew>();
			scorenewList = (ArrayList) userDao
					.getScoreNewByClasskeyByScoretype(classkey, scoretype);
			return scorenewList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<ScoreNew> getScoreNewByClasskeyByScoretype(Integer classkey)
			throws Exception {
		try {
			List<ScoreNew> scorenewList = new ArrayList<ScoreNew>();
			scorenewList = (ArrayList) userDao
					.getScoreNewByClasskeyByScoretype(classkey);
			return scorenewList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	/*
	 * public List<ScoreNew> getScoreNewList(Integer classkey)throws Exception {
	 * try { List<ScoreNew> scorenewList = new ArrayList<ScoreNew>();
	 * scorenewList = (ArrayList) userDao.getScoreNewList(classkey); return
	 * scorenewList; } catch (Exception e) { e.printStackTrace(); throw new
	 * Exception("查询出现异常"); } }
	 */
	public List<ScoreNew> getScoreNewList(String sid) throws Exception {
		try {
			List<ScoreNew> scorenewList = new ArrayList<ScoreNew>();
			scorenewList = (ArrayList) userDao.getScoreNewList(sid);
			return scorenewList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<LetterTemplate> getLetterTemplateList() throws Exception {
		try {
			List<LetterTemplate> lettertemplateList = new ArrayList<LetterTemplate>();
			lettertemplateList = (ArrayList) userDao.getLetterTemplateList();
			return lettertemplateList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Jzletter> getJzletterlist() throws Exception {
		try {
			List<Jzletter> jzletterlist = new ArrayList<Jzletter>();
			jzletterlist = (ArrayList) userDao.getJzletterlist();
			return jzletterlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public LetterTemplate getLetterTemplateListById(Integer id)
			throws Exception {
		try {
			LetterTemplate lettertemplate = userDao
					.getLetterTemplateListById(id);
			return lettertemplate;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Subject getSubjectBySubid(String subid) throws Exception {
		try {
			Subject subject = userDao.getSubjectBySubid(subid);
			return subject;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Classroom getClassroomByroomname(String roomname) throws Exception {
		try {
			Classroom classroom = userDao.getClassroomByroomname(roomname);
			return classroom;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Student getStudentBystatusDividestatus(String name) throws Exception {
		try {
			Student student = userDao.getStudentBystatusDividestatus(name);
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Punish> getPunishList() throws Exception {
		try {
			List<Punish> punishList = new ArrayList<Punish>();
			punishList = (ArrayList) userDao.getPunishList();
			return punishList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getClassList() throws Exception {
		try {
			List classList = new ArrayList();
			classList = userDao.getClassList();
			return classList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getClassListByAssistantid(Integer assistantid) throws Exception {
		try {
			List classList = new ArrayList();
			classList = userDao.getClassListByAssistantid(assistantid);
			return classList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getSubjectList() throws Exception {
		try {
			List subjectList = new ArrayList();
			subjectList = userDao.getSubjectList();
			return subjectList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Subject getSubjectByName(String name) throws Exception {
		try {
			Subject subject = null;
			subject = userDao.getSubjectByName(name);
			return subject;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Student getStudentBySid(String sid) throws Exception {
		try {
			Student student = null;
			student = userDao.getStudentBySid(sid);
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Student getStudentBySid_(String sid) throws Exception {
		try {
			Student student = null;
			student = userDao.getStudentBySid_(sid);
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getTeacherList() throws Exception {
		try {
			List teacherList = new ArrayList();
			teacherList = userDao.getTeacherList();
			return teacherList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getTeacherListNew() throws Exception {
		try {
			List teacherList = new ArrayList();
			teacherList = userDao.getTeacherListNew();
			return teacherList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getTeacherList(String username) throws Exception {
		try {
			List teacherList = new ArrayList();
			teacherList = userDao.getTeacherList(username);
			return teacherList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAssistantList() throws Exception {
		try {
			List assistantList = new ArrayList();
			assistantList = userDao.getAssistantList();
			return assistantList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAssistantList(Integer assistantid) throws Exception {
		try {
			List assistantList = new ArrayList();
			assistantList = userDao.getAssistantList(assistantid);
			return assistantList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustList() throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustList();
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjusBystatus() throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjusBystatus();
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> get_system_notice_list() throws Exception {
		try {
			List<Notice> system_notice_list = new ArrayList<Notice>();
			system_notice_list = userDao.get_system_notice_list();
			return system_notice_list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> getNoticeByusernametype(Integer type, String username)
			throws Exception {
		try {
			List<Notice> noticelist = new ArrayList<Notice>();
			noticelist = userDao.getNoticeByusernametype(type, username);
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> getNoticeByassistantclassestype(Integer type,
			String classid) throws Exception {
		try {
			List<Notice> noticelist = new ArrayList<Notice>();
			noticelist = userDao.getNoticeByassistantclassestype(type, classid);
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> getNoticeBystudentclassestype(Integer type,
			Integer classid) throws Exception {
		try {
			List<Notice> noticelist = new ArrayList<Notice>();
			noticelist = userDao.getNoticeBystudentclassestype(type, classid);
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> getNoticeByAll() throws Exception {
		try {
			List<Notice> noticelist = new ArrayList<Notice>();
			noticelist = userDao.getNoticeByAll();
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> getNoticeByassistant() throws Exception {
		try {
			List<Notice> noticelist = new ArrayList<Notice>();
			noticelist = userDao.getNoticeByassistant();
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> getNoticeByteacher() throws Exception {
		try {
			List<Notice> noticelist = new ArrayList<Notice>();
			noticelist = userDao.getNoticeByteacher();
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> getNoticeBystudent(String classid) throws Exception {
		try {
			List<Notice> noticelist = new ArrayList<Notice>();
			noticelist = userDao.getNoticeBystudent(classid);
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengversionList() throws Exception {
		try {
			List kechengversion = new ArrayList();
			kechengversion = userDao.getKechengversionList();
			return kechengversion;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengversionList(Integer isvalid) throws Exception {
		try {
			List kechengversion = new ArrayList();
			kechengversion = userDao.getKechengversionList(isvalid);
			return kechengversion;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengversionListById(Integer id) throws Exception {
		try {
			List noticeList = new ArrayList();
			noticeList = userDao.getKechengversionListById(id);
			return noticeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListByclassname(String classname) throws Exception {
		try {
			List kecheng_List = new ArrayList();
			kecheng_List = userDao.getKechengListByclassname(classname);
			return kecheng_List;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Notice> getNoticeListBytype(String noticetype, Integer type)
			throws Exception {
		try {
			List<Notice> noticeList = new ArrayList();
			noticeList = userDao.getNoticeListBytype(noticetype, type);
			return noticeList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	/*
	 * public List<Notice> getNoticeByusernametype(Integer type,String
	 * username)throws Exception{ try { List<Notice> noticeList= new
	 * ArrayList(); noticeList = userDao.getNoticeByusernametype(type,username);
	 * return noticeList; } catch (Exception e) { e.printStackTrace(); throw new
	 * Exception("查询出现异常"); } }
	 */
	public List<String> getScorenewByClasskey(Integer classid) throws Exception {
		try {
			List<String> scorenewList = new ArrayList();
			scorenewList = userDao.getScorenewByClasskey(classid);
			return scorenewList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<String> getKechengByclassnamesubjectname(String subjectname,
			String classname) throws Exception {
		try {
			List<String> teacherlist = new ArrayList();
			teacherlist = userDao.getKechengByclassnamesubjectname(subjectname,
					classname);
			return teacherlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<String> getkechengteacherByclassname(String classname)
			throws Exception {
		try {
			List<String> teacherlist = new ArrayList();
			teacherlist = userDao.getkechengteacherByclassname(classname);
			return teacherlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Integer> getScorenewBysid_(String sid) throws Exception {
		try {
			List<Integer> scorenewList = new ArrayList();
			scorenewList = userDao.getScorenewBysid_(sid);
			return scorenewList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Integer> getSubjectidlist(String sid) throws Exception {
		try {
			List<Integer> Subjectidlist = new ArrayList();
			Subjectidlist = userDao.getSubjectidlist(sid);
			return Subjectidlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Integer> getSubjectid_list(String classkey) throws Exception {
		try {
			List<Integer> classkeylist = new ArrayList();
			classkeylist = userDao.getSubjectid_list(classkey);
			return classkeylist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<String> getClassnameList() throws Exception {
		try {
			List<String> classnamelist = new ArrayList();
			classnamelist = userDao.getClassnameList();
			return classnamelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<String> getExamByEdatephaseidClasskeySubjectid(
			Integer examtype, Integer phaseid, Integer classkey,
			Integer subjectid) throws Exception {
		try {
			List<String> scorenewList = new ArrayList();
			scorenewList = userDao.getExamByEdatephaseidClasskeySubjectid(
					examtype, phaseid, classkey, subjectid);
			return scorenewList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public User getUserBytype(String username, Integer type) throws Exception {
		try {
			User user = null;
			user = userDao.getUserBytype(username, type);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Assistant getAssistantListByaid(String assistantaid)
			throws Exception {
		try {
			Assistant assistant = null;
			assistant = userDao.getAssistantListByaid(assistantaid);
			return assistant;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Classroom getClassroomListByCid(String cid) throws Exception {
		try {
			Classroom classroom = null;
			classroom = userDao.getClassroomListByCid(cid);
			return classroom;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Classroom getClassroomListByroomid(String roomid) throws Exception {
		try {
			Classroom classroom = null;
			classroom = userDao.getClassroomListByroomid(roomid);
			return classroom;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getGoodsList() throws Exception {
		try {
			List goodsList = new ArrayList();
			goodsList = userDao.getGoodsList();
			return goodsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getKechengListClassByclassname(String classname)
			throws Exception {
		try {
			List kechengClasslist = new ArrayList();
			kechengClasslist = userDao
					.getKechengListClassByclassname(classname);
			return kechengClasslist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustByteacher(String username) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustByteacher(username);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustList(String column_name, String desc, int from,
			int size) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustList(column_name, desc, from, size);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getGoodsList(String column_name, String desc, int from, int size)
			throws Exception {
		try {
			List goodsList = new ArrayList();
			goodsList = userDao.getGoodsList(column_name, desc, from, size);
			return goodsList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustList(Integer status, String classname)
			throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustList(status, classname);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustList(Integer status) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustList(status);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustList(String classname, String date, String starttime)
			throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustList(classname, date, starttime);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustListNew(String classname, String date,
			String starttime, Integer version) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustListNew(classname, date, starttime,
					version);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustList(String teacherName, String date,
			String starttime, Integer version) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustList(teacherName, date, starttime,
					version);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustListAfter(String teacherName, String date,
			String starttime, Integer version) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustList(teacherName, date, starttime,
					version);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustClassSubjectName(String classroom, String subjectname,
			String classname) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustClassSubjectName(classroom,
					subjectname, classname);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustListAfter(String classname, String date,
			String starttime) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustListAfter(classname, date, starttime);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getAdjustListAfterNew(String classname, String date,
			String starttime, Integer veresion) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustListAfterNew(classname, date,
					starttime, veresion);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getDelayList() throws Exception {
		try {
			List delayList = new ArrayList();
			delayList = userDao.getDelayList();
			return delayList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getExampjList() throws Exception {
		try {
			List exampjList = new ArrayList();
			exampjList = userDao.getExampjList();
			return exampjList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getMyExampjList(String classname) throws Exception {
		try {
			List exampjList = new ArrayList();
			exampjList = userDao.getMyExampjList(classname);
			return exampjList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getLoggingList() throws Exception {
		try {
			List loggingList = new ArrayList();
			loggingList = userDao.getLoggingList();
			return loggingList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Assistant getAssistantByName(String name) throws Exception {
		try {
			Assistant assistant = userDao.getAssistantByName(name);
			return assistant;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Assistant getAssistantByAid(String aid) throws Exception {
		try {
			Assistant Assistant = userDao.getAssistantByAid(aid);
			return Assistant;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public Assistant getAssistantById(Integer id) throws Exception {
		try {
			Assistant Assistant = userDao.getAssistantById(id);
			return Assistant;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getRightList() throws Exception {
		try {
			List rightList = new ArrayList();
			rightList = userDao.getRightList();
			return rightList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getRoleRight(Integer roleid) throws Exception {
		try {
			List<RoleRight> userList = new ArrayList<RoleRight>();
			userList = userDao.getRoleRight(roleid);
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getRoleRight(Integer roleid, String rightcode) throws Exception {
		try {
			List<RoleRight> userList = new ArrayList<RoleRight>();
			userList = userDao.getRoleRight(roleid, rightcode);
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public User getUserByName(String userName) throws Exception {
		try {
			User u = userDao.findUserByName(userName);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public int loginValid(String user, String pass) throws Exception {
		try {
			User u = userDao.findUserByNameAndPass(user, pass);
			if (u != null) {
				return u.getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
		return -1;
	}

	public boolean validateName(String user) throws Exception {
		try {
			if (userDao.findUserByName(user) == null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new Exception("查询出现异常");
		}

	}

	public List getAdjustBystudentstatus(String name) throws Exception {
		try {
			List adjustList = new ArrayList();
			adjustList = userDao.getAdjustBystudentstatus(name);
			return adjustList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getScoreNewCountScoretype2(String sid) throws Exception {
		try {
			List resultCount = new ArrayList();
			resultCount = userDao.getScoreNewCountScoretype2(sid);
			return resultCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getScoreNewCountScoretype1(String sid) throws Exception {
		try {
			List scorelist = new ArrayList();
			scorelist = userDao.getScoreNewCountScoretype1(sid);
			return scorelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getScoreNewCountScoretype_1(String sid) throws Exception {
		try {
			List resultCount = new ArrayList();
			resultCount = userDao.getScoreNewCountScoretype_1(sid);
			return resultCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getScoreNewCountScoretype3(String sid) throws Exception {
		try {
			List scorelist = new ArrayList();
			scorelist = userDao.getScoreNewCountScoretype3(sid);
			return scorelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getScoreNewCountScoretype_3(String sid) throws Exception {
		try {
			List scorelist = new ArrayList();
			scorelist = userDao.getScoreNewCountScoretype_3(sid);
			return scorelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Integer> getScoreNewListByClasskey() throws Exception {
		try {
			List<Integer> scorelist = new ArrayList();
			scorelist = userDao.getScoreNewListByClasskey();
			return scorelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Object[]> getScoreNewBySid(String sid) throws Exception {
		try {
			List<Object[]> scorelist = new ArrayList();
			scorelist = userDao.getScoreNewBySid(sid);
			return scorelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Object[]> getScoreNewByClassid(Integer classid)
			throws Exception {
		try {
			List<Object[]> scorelist = new ArrayList();
			scorelist = userDao.getScoreNewByClassid(classid);
			return scorelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getScoreNewByClassidTitle(Integer classid, String title)
			throws Exception {
		try {
			List scoreList = new ArrayList();
			scoreList = userDao.getScoreNewByClassidTitle(classid, title);
			return scoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getScoreNewByClasskeySid(String sid, Integer classkey,
			Integer examid) throws Exception {
		try {
			List scoreList = new ArrayList();
			scoreList = userDao.getScoreNewByClasskeySid(sid, classkey, examid);
			return scoreList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getMajorList() throws Exception {
		try {
			List majorlist = new ArrayList();
			majorlist = userDao.getMajorList();
			return majorlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List getSubjectnameListByTeachername(String teachername)
			throws Exception {
		try {
			List subjectnamelist = new ArrayList();
			subjectnamelist = userDao
					.getSubjectnameListByTeachername(teachername);
			return subjectnamelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}

	}

	public List getClassnamenameListByAssistantname(String assistantname)
			throws Exception {
		try {
			List roomnameList = new ArrayList();
			roomnameList = userDao
					.getClassnamenameListByAssistantname(assistantname);
			return roomnameList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}

	}

	public List getClassListexceptById(Integer classid) throws Exception {
		try {
			List classlist = new ArrayList();
			classlist = userDao.getClassListexceptById(classid);
			return classlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}

	}

	public List getXszgtNoticeBytype() throws Exception {
		try {
			List noticelist = new ArrayList();
			noticelist = userDao.getXszgtNoticeBytype();
			return noticelist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}

	}

	public Kecheng getKechengByStartime(String username, String className,
			String classSubject, String classRoom, String startTime,
			Integer v_id) throws Exception {
		try {
			Kecheng kecheng = new Kecheng();
			kecheng = userDao.getKechengByStartime(username, className,
					classSubject, classRoom, startTime, v_id);
			return kecheng;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	public List<Exam> getExamByNeishenyuanId(String tid) throws Exception {
		try {
			List<Exam> examlist = new ArrayList();
			examlist = userDao.getExamByNeishenyuanId(tid);
			return examlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}

	}

	// 下面的代码由Alan增加--Begin
	public List getClassroomList() throws Exception {
		try {
			List<Classroom> classroomList = new ArrayList<Classroom>();
			classroomList = userDao.getClassRoom();
			return classroomList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	@Override
	public List getKechengListByDate(Date date) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Kecheng> kechengList = new ArrayList<Kecheng>();
			kechengList = userDao.getKechengListByDate(date);
			return kechengList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}

	@Override
	public List getApplyClassroomList() throws Exception {
		try {
			List<ClassroomApply> applyclassroomlist = new ArrayList<ClassroomApply>();
			applyclassroomlist = userDao.getApplyClassroomList();
			return applyclassroomlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("教室申请查询出现异常");
		}

	}

	@Override
	public List getApplyClassroomListByDate(String date) throws Exception {
		try {
			List<ClassroomApply> applyclassroomlist = new ArrayList<ClassroomApply>();
			applyclassroomlist = userDao.getApplyClassroomListByDate(date);
			return applyclassroomlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("按日期查询教室申请表出现异常");
		}
	}

	@Override
	public List getApplyClassroomListByUser(String user) throws Exception {
		try {
			List<ClassroomApply> applyclassroomlist = new ArrayList<ClassroomApply>();
			applyclassroomlist = userDao.getApplyClassroomListByUser(user);
			return applyclassroomlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("按申请人查询教室申请表出现异常");
		}
	}

	public List getAdjustListByDateafter(String sapplydate) throws Exception {
		try {
			List<Adjust> adjustlist = new ArrayList<Adjust>();
			adjustlist = userDao.getAdjustListByDateafter(sapplydate);
			return adjustlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("按调课后时间查询调课单出现异常");
		}
	}

	@Override
	public List getAdjustListByDatebefore(String sapplydate) throws Exception {
		try {
			List<Adjust> adjustlist = new ArrayList<Adjust>();
			adjustlist = userDao.getAdjustListByDatebefore(sapplydate);
			return adjustlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("按调课前时间查询调课单出现异常");
		}
	}

	// 上面的代码由Alan增加--End

	@Override
	// 得到所有教室
	public List getAllClassRoom() throws Exception {
		return userDao.getAllClassRoom();
	}

	@Override
	public Assistant getAllAssistantByName(String name) throws Exception {
		return userDao.getAllAssistantByName(name);
	}
}
