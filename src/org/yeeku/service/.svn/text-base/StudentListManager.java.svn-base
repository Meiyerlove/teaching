package org.yeeku.service;

import java.util.Date;
import java.util.List;

import org.yeeku.model.Classroom;
import org.yeeku.model.Contract;
import org.yeeku.model.Cursch;
import org.yeeku.model.EquCard;
import org.yeeku.model.ExClassRecord;
import org.yeeku.model.HeInformation;
import org.yeeku.model.HrEmployee;
import org.yeeku.model.ManualRecord;
import org.yeeku.model.Teacher;


/**
 * @author  zengjiuzhou@163.com
 * @version  1.0
 * <br>Copyright (C), 2013-2018, James.Zeng
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */
public interface StudentListManager
{
	/**
     * ��ѯ�����Ͽ��˵ļ�¼
     * @param user ��Ҫ��½���û���
     * @param pass ��Ҫ��½������
	 * @return �Ͽμ�¼list
     */
	List getRecordList(String startDate, String endDate) throws Exception;
	
    List getRecordList(String startDate, String endDate,String cardNO) throws Exception;
    
    List getTeaList() throws Exception;
    
    List getStuList(String emplID, String emplName) throws Exception;
    
    List getCurrentRecordList() throws Exception;
    
    ManualRecord getManualRecord(int id) throws Exception;
    
    ManualRecord getManualRecordByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber) throws Exception;
    
    List getManualRecordNumberByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber) throws Exception;
    
    List getManualRecordListByDate(String date, Date startDate, Date endDate, int roomID, int lessonNumber) throws Exception;
    
    List getStuRank(Date startDate, Date endDate) throws Exception;
    
    List getAllStudent() throws Exception;
    
    List getUncheckedStudentList() throws Exception;
    
    List searchEmployee(String emplName) throws Exception;
    
    List getAllContract() throws Exception;
    
    List getListUncheckedContract() throws Exception;
    
    List getContractByNO(String contractNO) throws Exception;
    
    List getContractByName(String name) throws Exception;
    
    String findMaxContractNo() throws Exception;
    
    List findAllEmplName() throws Exception;
    
    String findMaxEmployeeNo() throws Exception;
    
    Contract getContractByEmplID(String emplID) throws Exception;
    
    List getManualRecord() throws Exception;
    
    List getManualRecordByTime(Date startDate, Date endDate) throws Exception;
    
    List getManualRecordByDate(String startDate, String endDate) throws Exception;
    
    List getManualRecordByDate(String startDate, String endDate, String emplID) throws Exception;
    
    List getManualRecordByDateName(String startDate, String endDate, String emplName) throws Exception;
    
    List getManualRecordByDateIDName(String startDate, String endDate, String emplID, String emplName) throws Exception;
    
    List getManualRecordByDate(String date) throws Exception;
    
    List getExClassRecordByDate(String date) throws Exception;
    
    List getManualRecord(String emplID, String emplName) throws Exception;
    
    int getFinishedLessonNumber(String emplID) throws Exception;
    
    List getHrEmployeeByEmplIDorName(String emplID, String emplName) throws Exception;
    
    HrEmployee getHrEmployeeByEmplID(String emplID) throws Exception;
    
    HeInformation getHeInformationByEmplID(String emplID) throws Exception;
    
    HrEmployee getHrEmployeeByEmplName(String emplName) throws Exception;
    
    List getRoomList() throws Exception;
    
    List getSubjectList() throws Exception;
    
    EquCard getStudentNameByCardNO(String cardNO) throws Exception;
    
    EquCard getEquCardByEmplID(String emplID) throws Exception;
    
    Classroom getRoomNOByEquNO(String equNO) throws Exception;
    
    Classroom getRoomByID(int id) throws Exception;
    
    Teacher getTeaNameByTeaID(String teaID) throws Exception;
    
    void deleteTeacher(Teacher tc) throws Exception;
    
    void deleteContract(Contract con) throws Exception;
    
    void deleteEmployee(HrEmployee he) throws Exception;
    
    void deleteMR(ManualRecord mr) throws Exception;
    
    void deleteContractByNO(String contractNO) throws Exception;
    
    void deleteCursch(Cursch cs) throws Exception;
    
    void saveTeacher(Teacher tc) throws Exception;
    
    void saveEmployee(HrEmployee he) throws Exception;
    
    void saveEmployeeDetail(HeInformation hi) throws Exception;
    
    void saveContract(Contract con) throws Exception;
    
    void updateEmployeeDetail(HeInformation hi) throws Exception;
    
    void saveRoom(Classroom cr) throws Exception;
    
    void saveMR(ManualRecord mr) throws Exception;
    
    void saveECR(ExClassRecord ecr) throws Exception;
    
    void saveCursch(Cursch cs) throws Exception;
    
    Cursch getCursch(String weekday, String roomNO, String time) throws Exception;
    
    Cursch getCursch(String weekday, String roomNO, int lessonNumber) throws Exception;
    
    List getCurschListByTeaID(String teacherID) throws Exception;
    
    //Cursch getCursch(String teacherID,String weekday, int sequenceNumber) throws Exception;
    
    Cursch getCursch(int id) throws Exception;

}

