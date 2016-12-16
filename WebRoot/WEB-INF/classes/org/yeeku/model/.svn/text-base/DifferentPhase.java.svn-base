package org.yeeku.model;

import java.util.ArrayList;
import java.util.List;

public class DifferentPhase {
	
	public String getExamType(int examType){
		String type="";
		if(examType==1){//正考
			type="正考";
		}
		if(examType==2){//正考-补做
			type="正考-补做";
		}
		if(examType==3){//正考-补考
			type="正考-补考";
		}
		if(examType==4){//正考-补考-补做
			type="正考-补考-补做";
		}
		if(examType==5){//重修
			type="重修";
		}
		if(examType==6){//重修-补做
			type="重修-补做";
		}
		if(examType==7){//毕前考
			type="毕前考";
		}
		if(examType==8){//毕前考-补做
			type="毕前考-补做";
		}
		if(examType==9){//其它考
			type="其它考";
		}
		if(examType==10){//其它考-补做
			type="其它考-补做";
		}
		if(examType==10){//其它考-补做
			type="其它考-补做";
		}
		
		//非百分之1.4的考试类型
		if(examType==20){//其它考-补做
			type="第二次补考";
		}
		if(examType==21){//其他-正考
			type="其他-正考";
		}
		if(examType==22){//其他-补做
			type="其他-补做";
		}
		return type;
	}
	
	
	
	public Integer get_exam_type_id(String examTypename){
		Integer exam_type_id=0;
		if(examTypename.equals("正考")){//正考
			exam_type_id=1;
		}
		else if(examTypename.equals("正考-补做")){//正考-补做
			exam_type_id=2;
		}
		else if(examTypename.equals("正考-补考")){//正考-补考
			exam_type_id=3;
		}
		else if(examTypename.equals("正考-补考-补做")){//正考-补考-补做
			exam_type_id=4;
		}
		else if(examTypename.equals("重修")){//重修
			exam_type_id=5;
		}
		else if(examTypename.equals("重修-补做")){//重修-补做
			exam_type_id=6;
		}
		else if(examTypename.equals("毕前考")){//毕前考
			exam_type_id=7;
		}
		else if(examTypename.equals("毕前考-补做")){//毕前考-补做
			exam_type_id=8;
		}
		else if(examTypename.equals("其它考")){//其它考
			exam_type_id=9;
		}
		else if(examTypename.equals("其它考-补做")){//其它考-补做
			exam_type_id=10;
		}
		
		return exam_type_id;
	}
	
	public List<String> getShowCurrExamTitleByOther(int examType){
		List<String> resultList=new ArrayList<String>();
		if(examType==1){//正考
			resultList.add("正考");
		}
		if(examType==3){//正考-补考
			resultList.add("正考");
			resultList.add("正考-补考");
		}
		if(examType==7){//毕前考
			resultList.add("正考");
			resultList.add("正考-补考");
			resultList.add("毕前考");
		}
		if(examType==9){//其它考
			resultList.add("正考");
			resultList.add("正考-补考");
			resultList.add("毕前考");
			resultList.add("其它考");
		}
		return resultList;
	}
	
	public List<String> get_jifendanyuan_exam_title(int examType){
		List<String> resultList=new ArrayList<String>();
		if(examType==0){
			resultList.add("正考");
			resultList.add("正考-补考");
			resultList.add("毕前考");
			resultList.add("其它考");
		}
		else if(examType==1){//正考
			resultList.add("正考-补考");
			resultList.add("毕前考");
			resultList.add("其它考");
		}
		else if(examType==3){//正考-补考
			resultList.add("毕前考");
			resultList.add("其它考");
		}
		else if(examType==7){//毕前考
			resultList.add("其它考");
		}
		else{//其它考
			resultList.add("已结束");
		}
		return resultList;
	}
	
	public List<String> get_feibaifenzhi_exam_title(int examType){
		List<String> resultList=new ArrayList<String>();
		if(examType==0){
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		else if(examType==1){//正考
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==2){//正考-补做
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==3){//正考-补考
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==4){//正考-补考-补做
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==5){//重修;
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==6){//重修-补做
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==7){//毕前考
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==8){//毕前考-补做
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==9){//其它考
			resultList.add("其它考-补做");
		}
		if(examType==10){//其它考-补做
			resultList.add("已结束");
		}
		return resultList;
	}
	
	
	public List<String> getShowCurrExamTitle(int examType){
		List<String> resultList=new ArrayList<String>();
		if(examType==1){//正考
			resultList.add("正考");
		}
		if(examType==2){//正考-补做
			resultList.add("正考");
			resultList.add("正考-补做");
		}
		if(examType==3){//正考-补考
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
		}
		if(examType==4){//正考-补考-补做
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
		}
		if(examType==5){//重修
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
		}
		if(examType==6){//重修-补做
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
		}
		if(examType==7){//毕前考
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
		}
		if(examType==8){//毕前考-补做
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
		}
		if(examType==9){//其它考
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
		}
		if(examType==10){//其它考-补做
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("正考-补考-补做");
			resultList.add("重修");
			resultList.add("重修-补做");
			resultList.add("毕前考");
			resultList.add("毕前考-补做");
			resultList.add("其它考");
			resultList.add("其它考-补做");
		}
		if(examType==20){//第二次补考
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("第二次补考");
		}
		if(examType==21){//其他
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("第二次补考");
			resultList.add("其他");
		}
		if(examType==22){//其他补考
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("第二次补考");
			resultList.add("其他");
			resultList.add("其他-补做");
		}
		return resultList;
	}
	
	public List<String> getCurrSubjectResultExcelTileFeibaizhi(int examType){
		List<String> resultList=new ArrayList<String>();
		resultList.add("学号");
		resultList.add("姓名");
		resultList.add("班级");
		resultList.add("科目");
		resultList.add("阶段");
		resultList.add("得分制");
		if(examType==1){//正考
			resultList.add("正考");
			
		}
		if(examType==2){//正考-补做
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
		}
		if(examType==3){//正考-补考
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
		}
		if(examType==4){//正考-补考-补做
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
			resultList.add("正考-补考-补做");
			
		}
		if(examType==5){//重修
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
			resultList.add("正考-补考-补做");
			
			resultList.add("重修");
			
		}
		if(examType==6){//重修-补做
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
			resultList.add("正考-补考-补做");
			
			resultList.add("重修");
			
			resultList.add("重修-补做");
			
		}
		if(examType==7){//毕前考
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
			resultList.add("正考-补考-补做");
			
			resultList.add("重修");
			
			resultList.add("重修-补做");
			
			resultList.add("毕前考");
			
		}
		if(examType==8){//毕前考-补做
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
			resultList.add("正考-补考-补做");
			
			resultList.add("重修");
			
			resultList.add("重修-补做");
			
			resultList.add("毕前考");
			
			resultList.add("毕前考-补做");
			
		}
		if(examType==9){//其它考
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
			resultList.add("正考-补考-补做");
			
			resultList.add("重修");
			
			resultList.add("重修-补做");
			
			resultList.add("毕前考");
			
			resultList.add("毕前考-补做");
			
			resultList.add("其它考");
			
		}
		if(examType==10){//其它考-补做
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
			resultList.add("正考-补考-补做");
			
			resultList.add("重修");
			
			resultList.add("重修-补做");
			
			resultList.add("毕前考");
			
			resultList.add("毕前考-补做");
			
			resultList.add("其它考");
			
			resultList.add("其它考-补做");
			
		}
		if(examType==20){//第二次补考
			resultList.add("正考");
			
			resultList.add("正考-补做");
			
			resultList.add("正考-补考");
			
			resultList.add("第二次补考");
			
		}
		if(examType==21){//其他
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("第二次补考");
			resultList.add("其他");
			
		}
		if(examType==22){//其他
			resultList.add("正考");
			resultList.add("正考-补做");
			resultList.add("正考-补考");
			resultList.add("第二次补考");
			resultList.add("其他");
			resultList.add("其他-补做");
			
		}
		return resultList;
	}
	
	public List<String> getCurrResultExcelTileFeibaizhi(int examType){
		List<String> resultList=new ArrayList<String>();
		resultList.add("学号");
		resultList.add("姓名");
		resultList.add("班级");
		resultList.add("科目");
		resultList.add("阶段");
		resultList.add("得分制");
		if(examType==1){//正考
			resultList.add("正考");
			resultList.add("百分成绩");
		}
		if(examType==2){//正考-补做
			resultList.add("正考-补做");
			resultList.add("百分成绩");
		}
		if(examType==3){//正考-补考
			resultList.add("正考-补考");
			resultList.add("百分成绩");
		}
		if(examType==4){//正考-补考-补做
			resultList.add("正考-补考-补做");
			resultList.add("百分成绩");
		}
		if(examType==5){//重修
			resultList.add("重修");
			resultList.add("百分成绩");
		}
		if(examType==6){//重修-补做
			resultList.add("重修-补做");
			resultList.add("百分成绩");
		}
		if(examType==7){//毕前考
			resultList.add("毕前考");
			resultList.add("百分成绩");
		}
		if(examType==8){//毕前考-补做
			resultList.add("毕前考-补做");
			resultList.add("百分成绩");
		}
		if(examType==9){//其它考
			resultList.add("其它考");
			resultList.add("百分成绩");
		}
		if(examType==10){//其它考-补做
			resultList.add("其它考-补做");
			resultList.add("百分成绩");
		}
		return resultList;
	}
	
	public List<String> getCurrResultExcelTileOther(int examType){
		List<String> resultList=new ArrayList<String>();
		resultList.add("学号");
		resultList.add("姓名");
		resultList.add("班级");
		resultList.add("科目");
		resultList.add("阶段");
		resultList.add("得分制");
		if(examType==1){//正考
			resultList.add("正考");
		}
		if(examType==3){//正考-补考
			resultList.add("正考-补考");
		}
		if(examType==7){//毕前考
			resultList.add("毕前考");
		}
		if(examType==9){//其它考
			resultList.add("其它考");
		}
		return resultList;
	}
	
	
	public List<String> getCurrSubjectResultExcelTileOther(int examType){
		List<String> resultList=new ArrayList<String>();
		resultList.add("学号");
		resultList.add("姓名");
		resultList.add("班级");
		resultList.add("科目");
		resultList.add("阶段");
		resultList.add("得分制");
		if(examType==1){//正考
			resultList.add("正考");
		}
		if(examType==3){//正考-补考
			resultList.add("正考");
			resultList.add("正考-补考");
		}
		if(examType==7){//毕前考
			resultList.add("正考");
			resultList.add("正考-补考");
			resultList.add("毕前考");
		}
		if(examType==9){//其它考
			resultList.add("正考");
			resultList.add("正考-补考");
			resultList.add("毕前考");
			resultList.add("其它考");
		}
		return resultList;
	}
	
	/*非百分制-教务*/
	public List<String> getFeiBaiFenZhiResult(int examType){
		List<String> resultList=new ArrayList<String>();
		if(examType==1){//正考
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("Resit");
			resultList.add("ABS");
			resultList.add("DISQ");
			resultList.add("CHT");
			resultList.add("Resit-RA");
			resultList.add("ABS-RA");
			resultList.add("DISQ-RA");
			resultList.add("CHT-RA");
		}
		if(examType==2){//正考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("ABS-RA");
			resultList.add("CHT-RA");
		}
		if(examType==3){//正考-补考
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("Resit");
			resultList.add("ABS");
			resultList.add("CHT");
		}
		if(examType==4){//正考-补考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
		}
		if(examType==5){//重修
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("Resit");
			resultList.add("ABS");
			resultList.add("DISQ");
			resultList.add("CHT");
		}
		if(examType==6){//重修-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
		}
		if(examType==7){//毕前考
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
		}
		if(examType==8){//毕前考-补做
			resultList.add("P");
			resultList.add("RA");
		}
		if(examType==9){//其它考
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
		}
		if(examType==10){//其它考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
		}
		return resultList;
	}
	
	/*非百分制1.4-教务*/
	public List<String> getFeiBaiFenZhiOneFourResult(int examType){
		List<String> resultList=new ArrayList<String>();
		if(examType==1){//正考
			resultList.add("P");
			resultList.add("RW");
			resultList.add("RA");
			resultList.add("Resit");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
			resultList.add("Resit-RA");
			resultList.add("ABS-RA");
			resultList.add("DISQ-RA");
			resultList.add("CHT-RA");
		}
		if(examType==2){//正考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			//resultList.add("DISQ");
		}
		if(examType==3){//正考-补考
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			//resultList.add("DISQ");
		}
		if(examType==20){//正考-第二次补考
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			//resultList.add("DISQ");
		}
		if(examType==21){//其他-正考
			resultList.add("P");
			resultList.add("RW");
			resultList.add("F");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			//resultList.add("DISQ");
		}
		if(examType==22){//其他-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("F");
			resultList.add("ABS");
			resultList.add("CHT");
			
		}
		return resultList;
	}
	
	
	/*非百分制-老师*/
	public List<String> getFeiBaiFenZhiResultTeacher(int examType){
		List<String> resultList=new ArrayList<String>();
		if(examType==1){//正考
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("Resit");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==2){//正考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==3){//正考-补考
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("Resit");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==4){//正考-补考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==5){//重修
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("Resit");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==6){//重修-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==7){//毕前考
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==8){//毕前考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("DISQ");
		}
		if(examType==9){//其它考
			resultList.add("RW");
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==10){//其它考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		return resultList;
	}
	
	/*非百分制1.4-老师*/
	public List<String> getFeiBaiFenZhiOneFourResultTeacher(int examType){
		List<String> resultList=new ArrayList<String>();
		if(examType==1){//正考
			resultList.add("P");
			resultList.add("RW");
			resultList.add("RA");
			resultList.add("Resit");
			resultList.add("ABS");
			resultList.add("CHT");
			resultList.add("DISQ");
		}
		if(examType==2){//正考-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			//resultList.add("DISQ");
		}
		if(examType==3){//正考-补考
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			//resultList.add("DISQ");
		}
		if(examType==20){//正考-第二次补考
			resultList.add("P");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			//resultList.add("DISQ");
		}
		if(examType==21){//其他-正考
			resultList.add("P");
			resultList.add("RW");
			resultList.add("F");
			resultList.add("RA");
			resultList.add("ABS");
			resultList.add("CHT");
			//resultList.add("DISQ");
		}
		if(examType==22){//其他-补做
			resultList.add("P");
			resultList.add("RA");
			resultList.add("F");
			resultList.add("ABS");
			resultList.add("CHT");
			
		}
		return resultList;
	}
}
