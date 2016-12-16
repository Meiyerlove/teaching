package org.yeeku.service.impl;

import java.util.Date;
import java.util.List;

import org.yeeku.dao.UserDao;
import org.yeeku.model.Classroom;
import org.yeeku.model.Contract;
import org.yeeku.model.Cursch;
import org.yeeku.model.EquCard;
import org.yeeku.model.ExClassRecord;
import org.yeeku.model.HeInformation;
import org.yeeku.model.HrEmployee;
import org.yeeku.model.ManualRecord;
import org.yeeku.model.Teacher;
import org.yeeku.service.StudentListManager;

public class StudentListManagerImpl implements StudentListManager{
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	public List getRecordList(String startDate, String endDate) throws Exception {
		try
		{
			List rl = userDao.findAllRecord(startDate, endDate);
		    return rl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getRecordList(String startDate, String endDate,String cardNO) throws Exception {
		try
		{
			List rl = userDao.findAllRecord(startDate, endDate, cardNO);
		    return rl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getTeaList() throws Exception{
		try
		{
			List tl = userDao.findAllTeacher();
		    return tl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getStuList(String emplID, String emplName) throws Exception{
		try
		{
			List tl = userDao.findStudentByIDOrName(emplID, emplName);
		    return tl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getCurrentRecordList() throws Exception{
		try
		{
			List tl = userDao.findCurrentRecordList();
		    return tl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getStuRank(Date startDate, Date endDate) throws Exception{
		try
		{
			List tl = userDao.findStuRank(startDate, endDate);
		    return tl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getAllStudent() throws Exception{
		try
		{
			List sl = userDao.findAllStudent();
		    return sl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getUncheckedStudentList() throws Exception{
		try
		{
			List sl = userDao.getUncheckedStudentList();
		    return sl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List searchEmployee(String emplName) throws Exception{
		try
		{
			List sl = userDao.searchEmployee(emplName);
		    return sl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getAllContract() throws Exception{
		try
		{
			List sl = userDao.findAllContract();
		    return sl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getListUncheckedContract() throws Exception{
		try
		{
			List sl = userDao.getListUncheckedContract();
		    return sl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getContractByNO(String contractNO) throws Exception{
		try
		{
			List cl = userDao.findContractByNO(contractNO);
		    return cl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getContractByName(String name) throws Exception{
		try
		{
			List cl = userDao.findContractByName(name);
		    return cl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public String findMaxContractNo() throws Exception{
		try
		{
			String contractNo = userDao.findMaxContractNo();
		    return contractNo;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List findAllEmplName() throws Exception{
		try
		{
			List nameList = userDao.findAllEmplName();
		    return nameList;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public String findMaxEmployeeNo() throws Exception{
		try
		{
			String employeeNo = userDao.findMaxEmployeeNo();
		    return employeeNo;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public Contract getContractByEmplID(String emplID) throws Exception{
		try
		{
			Contract con = userDao.findContractByEmplID(emplID);
		    return con;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecord() throws Exception{
		try
		{
			List mrl = userDao.findManualRecord();
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecordByTime(Date startDate, Date endDate) throws Exception{
		try
		{
			List mrl = userDao.findManualRecordByTime(startDate, endDate);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecordByDate(String date) throws Exception{
		try
		{
			List mrl = userDao.findManualRecordByDate(date);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getExClassRecordByDate(String date) throws Exception{
		try
		{
			List mrl = userDao.findExClassRecordByDate(date);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	
	public List getManualRecordByDate(String startDate, String endDate) throws Exception{
		try
		{
			List mrl = userDao.findManualRecordByDate(startDate, endDate);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecordByDate(String startDate, String endDate, String emplID) throws Exception{
		try
		{
			List mrl = userDao.findManualRecordByDate(startDate, endDate, emplID);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecordByDateIDName(String startDate, String endDate, String emplID, String emplName) throws Exception{
		try
		{
			List mrl = userDao.findManualRecordByDateIDName(startDate, endDate, emplID, emplName);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecordByDateName(String startDate, String endDate, String emplName) throws Exception{
		try
		{
			List mrl = userDao.findManualRecordByDateName(startDate, endDate, emplName);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecord(String emplID, String emplName) throws Exception{
		try
		{
			List mrl = userDao.findManualRecord(emplID, emplName);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public int getFinishedLessonNumber(String emplID) throws Exception{
		int finishedLessonNumber = userDao.getFinishedLessonNumber(emplID);
		return finishedLessonNumber;
	}
	
	public ManualRecord getManualRecord(int id) throws Exception{
		try
		{
			ManualRecord mr = userDao.findManualRecord(id);
		    return mr;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public ManualRecord getManualRecordByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber) throws Exception{
		try
		{
			ManualRecord mr = userDao.findManualRecordByDate(date,startDate, endDate, roomID, lessonNumber);
		    return mr;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecordNumberByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber) throws Exception{
		try
		{
			List mrl = userDao.findManualRecordNumberByDate(date,startDate, endDate, roomID, lessonNumber);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getManualRecordListByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber) throws Exception{
		try
		{
			List mrl = userDao.findManualRecordListByDate(date, startDate, endDate, roomID, lessonNumber);
		    return mrl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getHrEmployeeByEmplIDorName(String emplID, String emplName) throws Exception{
		try
		{
			List lhel = userDao.findStudentByEmplIDorName(emplID, emplName);
		    return lhel;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public HrEmployee getHrEmployeeByEmplID(String emplID) throws Exception{
		try
		{
			HrEmployee he = userDao.findStudentByEmplID(emplID);
		    return he;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public HeInformation getHeInformationByEmplID(String emplID) throws Exception{
		try
		{
			HeInformation he = userDao.findHiByEmplID(emplID);
		    return he;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public HrEmployee getHrEmployeeByEmplName(String emplName) throws Exception{
		try
		{
			HrEmployee he = userDao.findStudentByEmplName(emplName);
		    return he;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getRoomList() throws Exception{
		try
		{
			List rl = userDao.findAllRoom();
		    return rl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public List getSubjectList() throws Exception{
		try
		{
			List rl = userDao.findAllSubject();
		    return rl;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public EquCard getStudentNameByCardNO(String cardNO) throws Exception{
		try
		{
			return userDao.findStuNameByCardNO(cardNO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public EquCard getEquCardByEmplID(String emplID) throws Exception{
		try
		{
			return userDao.findEquCardByEmplID(emplID);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
    public Cursch getCursch(String weekday, String roomNO, String time) throws Exception{
    	try
		{
			return userDao.findCursch(weekday, roomNO, time);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
    }
    
    public List getCurschListByTeaID(String teacherID) throws Exception{
    	try
		{
			return userDao.findCurschListByTeaID(teacherID);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
    }
    
    public Cursch getCursch(String weekday,String roomNO, int sequenceNumber) throws Exception{
    	try
		{
			return userDao.findCursch(weekday, roomNO, sequenceNumber);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
    }
    
    public Cursch getCursch(int id) throws Exception{
    	try
		{
			return userDao.findCursch(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
    }
	
	public Classroom getRoomNOByEquNO(String equNO) throws Exception{
		try
		{
			return userDao.findRoomNOByEquNO(equNO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public Classroom getRoomByID(int id) throws Exception{
		try
		{
			return userDao.findRoomByID(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public Teacher getTeaNameByTeaID(String teaID) throws Exception{
		try
		{
			return userDao.findTeaByTeaID(teaID);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void deleteTeacher(Teacher tc) throws Exception{
		try
		{
			userDao.deleteTeacher(tc);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void deleteContract(Contract con) throws Exception{
		try
		{
			userDao.deleteContract(con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void deleteEmployee(HrEmployee he) throws Exception{
		try
		{
			userDao.deleteEmployee(he);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void deleteMR(ManualRecord mr) throws Exception{
		try
		{
			userDao.deleteMR(mr);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void deleteContractByNO(String contractNO) throws Exception{
		try
		{
			userDao.deleteContractByNO(contractNO);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void deleteCursch(Cursch cs) throws Exception{
		try
		{
			userDao.deleteCursch(cs);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void saveTeacher(Teacher tc) throws Exception{
		try
		{
			userDao.saveTeacher(tc);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void saveEmployee(HrEmployee he) throws Exception{
		try
		{
			userDao.saveEmployee(he);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void saveEmployeeDetail(HeInformation hi) throws Exception{
		try
		{
			userDao.saveEmployeeDetail(hi);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void saveContract(Contract con) throws Exception{
		try
		{
			userDao.saveContract(con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void updateEmployeeDetail(HeInformation hi) throws Exception{
		try
		{
			userDao.updateEmployeeDetail(hi);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void saveRoom(Classroom cr) throws Exception{
		try
		{
			userDao.saveRoom(cr);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void saveMR(ManualRecord mr) throws Exception{
		try
		{
			userDao.saveMR(mr);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void saveECR(ExClassRecord ecr) throws Exception{
		try
		{
			userDao.saveECR(ecr);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	public void saveCursch(Cursch cs) throws Exception{
		try
		{
			userDao.saveCursch(cs);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("查询出现异常");
		}
	}
	
	
}
