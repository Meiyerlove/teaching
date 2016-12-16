package org.yeeku.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.yeeku.action.base.BaseAction;
import org.yeeku.model.Absence;
import org.yeeku.model.Exam;
import org.yeeku.model.Ielts;
import org.yeeku.model.ScoreNew;
import org.yeeku.model.Student;

public class ExcelUtil2007 extends BaseAction
{
  private static final long serialVersionUID = 1L;

  public static void main(String[] args)
  {
    ExcelUtil2007 e = new ExcelUtil2007();
  }

  public static void buildXSLXExcel()
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());

    String basePath = "C:/Users/Administrator/Desktop/";
    String exportFileName = "Ielts" + now + ".xlsx";

    String[] cellTitle = { "学号", "姓名", "班级", "听", "说", "读", "写", "总分", "账号", "密码" };
    try {
      XSSFWorkbook workBook = null;

      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "Ielts未审核学生成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 3000);
          break;
        case 1:
          sheet.setColumnWidth(1, 4000);
          break;
        case 2:
          sheet.setColumnWidth(2, 4000);
          break;
        case 3:
          sheet.setColumnWidth(3, 2000);
          break;
        case 4:
          sheet.setColumnWidth(4, 2000);
          break;
        case 5:
          sheet.setColumnWidth(5, 2000);
          break;
        case 6:
          sheet.setColumnWidth(6, 2000);
          break;
        case 7:
          sheet.setColumnWidth(7, 2000);
          break;
        case 8:
          sheet.setColumnWidth(8, 2000);
          break;
        case 9:
          sheet.setColumnWidth(9, 2000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue(cellTitle[i]);
      }

      XSSFCellStyle style = workBook.createCellStyle();

      XSSFRow row = sheet.createRow(1);
      int j = 0; for (int length = cellTitle.length; j < length; j++) {
        XSSFCell cell = row.createCell(j, 0);
        cell.setCellType(1);
        switch (j) {
        case 0:
          cell.setCellValue("1990");
          style.setAlignment((short)2);
          cell.setCellStyle(style);
          break;
        case 1:
          cell.setCellValue("小红");
          style.setAlignment((short)2);
          cell.setCellStyle(style);
          break;
        case 2:
          cell.setCellValue("11001");
          style.setAlignment((short)1);
          cell.setCellStyle(style);
          break;
        case 3:
          cell.setCellValue("80");
          cell.setCellType(0);
          style.setAlignment((short)1);
          cell.setCellStyle(style);
          break;
        case 4:
          cell.setCellValue("80");
          style.setAlignment((short)2);
          cell.setCellStyle(style);
          break;
        case 5:
          cell.setCellValue("80");
          style.setAlignment((short)2);
          cell.setCellStyle(style);
          break;
        case 6:
          cell.setCellValue("80");
          style.setAlignment((short)2);
          cell.setCellStyle(style);
          break;
        case 7:
          cell.setCellValue("320");
          style.setAlignment((short)2);
          cell.setCellStyle(style);
          break;
        case 8:
          cell.setCellValue("admin");
          style.setAlignment((short)2);
          cell.setCellStyle(style);
          break;
        case 9:
          cell.setCellValue("admin");
          style.setAlignment((short)2);
          cell.setCellStyle(style);
        }

      }

      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      System.out.println("Excel 2007文件导出完成！导出文件路径：" + file.getPath());
    } catch (IOException e) {
      System.out.println("生成Ielts未审核学生成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }
  }

  public String buildXSLXExcel(List<Ielts> list)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());

    String basePath = "D:/download/";
    String exportFileName = "Ielts" + now + ".xlsx";

    XSSFWorkbook workBook = null;
    String[] cellTitle = { "学号", "姓名", "班级", "听", "说", "读", "写", "总分", "账号", "密码" };
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "Ielts未审核学生成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 3000);
          break;
        case 1:
          sheet.setColumnWidth(1, 4000);
          break;
        case 2:
          sheet.setColumnWidth(2, 4000);
          break;
        case 3:
          sheet.setColumnWidth(3, 2000);
          break;
        case 4:
          sheet.setColumnWidth(4, 2000);
          break;
        case 5:
          sheet.setColumnWidth(5, 2000);
          break;
        case 6:
          sheet.setColumnWidth(6, 2000);
          break;
        case 7:
          sheet.setColumnWidth(7, 2000);
          break;
        case 8:
          sheet.setColumnWidth(8, 2000);
          break;
        case 9:
          sheet.setColumnWidth(9, 2000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue(cellTitle[i]);
      }

      if ((list != null) && (!list.isEmpty())) {
        XSSFCellStyle style = workBook.createCellStyle();
        int i1 = 0; for (int size = list.size(); i1 < size; i1++) {
          Ielts entity = (Ielts)list.get(i1);
          XSSFRow row = sheet.createRow((short)i1 + 1);
          int j = 0; for (int length = cellTitle.length; j < length; j++) {
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            switch (j) {
            case 0:
              cell.setCellValue(Double.parseDouble(entity.getSid()));
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 1:
              cell.setCellValue(entity.getStudent().getName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 2:
              cell.setCellValue(entity.getTclass());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 3:
              cell.setCellValue(Double.parseDouble(entity.getListening()));
              cell.setCellType(0);
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 4:
              cell.setCellValue(Double.parseDouble(entity.getSpeaking()));
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 5:
              cell.setCellValue(Double.parseDouble(entity.getReading()));
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 6:
              cell.setCellValue(Double.parseDouble(entity.getWriting()));
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 7:
              cell.setCellValue(Double.parseDouble(entity.getTotal()));
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 8:
              cell.setCellValue(entity.getAccount());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 9:
              cell.setCellValue(entity.getPassword());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
            }
          }

        }

      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }

  public String buildXSLXExcel1(List<ScoreNew> list)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());
    String basePath = "D:/download/";
    String exportFileName = "考试成绩" + now + ".xlsx";
    XSSFWorkbook workBook = null;
    String[] cellTitle = { "学生ID", "学生姓名", "班级", "考试名称", "考试科目", "阶段考试", "考试类型", "考试成绩" };
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "ABS、Resit、DISQ成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 2000);
          break;
        case 1:
          sheet.setColumnWidth(1, 4000);
          break;
        case 2:
          sheet.setColumnWidth(2, 4000);
          break;
        case 3:
          sheet.setColumnWidth(3, 4000);
          break;
        case 4:
          sheet.setColumnWidth(4, 10000);
          break;
        case 5:
          sheet.setColumnWidth(5, 4000);
          break;
        case 6:
          sheet.setColumnWidth(6, 4000);
          break;
        case 7:
          sheet.setColumnWidth(7, 4000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        System.out.println(cellTitle[i]);
        cell.setCellValue(cellTitle[i]);
      }

      if ((list != null) && (!list.isEmpty())) {
        String regex = "^[0-9]+([.]{1}[0-9]+){0,1}$";
        XSSFCellStyle style = workBook.createCellStyle();
        int i1 = 0; for (int size = list.size(); i1 < size; i1++) {
          ScoreNew entity = (ScoreNew)list.get(i1);

          XSSFRow row = sheet.createRow((short)i1 + 1);
          int j = 0; for (int length = cellTitle.length; j < length; j++) {
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            switch (j)
            {
            case 0:
              cell.setCellValue(entity.getStudentid().intValue());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 1:
              cell.setCellValue(entity.getStudentname());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 2:
              cell.setCellValue(entity.getClassname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 3:
              cell.setCellValue(entity.getTitle());

              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 4:
              cell.setCellValue(entity.getSubjectname());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 5:
              cell.setCellValue(entity.getPhase());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 6:
              cell.setCellValue(entity.getExam());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 7:
              if ((entity.getResult() != null) && (entity.getResult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getResult()));
              else {
                cell.setCellValue(entity.getResult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
            }
          }
        }

      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }

  public String buildXSLXExcel1_(List<ScoreNew> list)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());
    String basePath = "D:/download/";
    String exportFileName = "考试成绩" + now + ".xlsx";
    XSSFWorkbook workBook = null;
    String[] cellTitle = { "班级名称", "学生ID", "学生姓名", "科目", "阶段", "正考", "正考-补做", "正考-补考", "正考-补考-补做", "重修", "重修-补做", "毕前考", "毕前-补做", "其它", "其它补做" };
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "考试成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 4000);
          break;
        case 1:
          sheet.setColumnWidth(1, 2000);
          break;
        case 2:
          sheet.setColumnWidth(2, 3000);
          break;
        case 3:
          sheet.setColumnWidth(3, 10000);
          break;
        case 4:
          sheet.setColumnWidth(4, 3000);
          break;
        case 5:
          sheet.setColumnWidth(5, 3000);
          break;
        case 6:
          sheet.setColumnWidth(6, 3000);
          break;
        case 7:
          sheet.setColumnWidth(7, 3000);
          break;
        case 8:
          sheet.setColumnWidth(8, 4000);
          break;
        case 9:
          sheet.setColumnWidth(9, 3000);
          break;
        case 10:
          sheet.setColumnWidth(10, 4000);
          break;
        case 11:
          sheet.setColumnWidth(11, 3000);
          break;
        case 12:
          sheet.setColumnWidth(12, 4000);
          break;
        case 13:
          sheet.setColumnWidth(13, 3000);
          break;
        case 14:
          sheet.setColumnWidth(14, 3000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue(cellTitle[i]);
      }

      if ((list != null) && (!list.isEmpty())) {
        XSSFCellStyle style = workBook.createCellStyle();
        String regex = "^[0-9]+([.]{1}[0-9]+){0,1}$";
        int i1 = 0; for (int size1 = list.size(); i1 < size1; i1++) {
          ScoreNew entity = (ScoreNew)list.get(i1);
          XSSFRow row = sheet.createRow((short)i1 + 1);
          int j = 0; for (int length = cellTitle.length; j < length; j++) {
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            switch (j) {
            case 0:
              cell.setCellValue(entity.getClassname());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 1:
              cell.setCellValue(entity.getStudentid().intValue());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 2:
              cell.setCellValue(entity.getStudentname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 3:
              cell.setCellValue(entity.getSubjectname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 4:
              cell.setCellValue(entity.getPhase());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 5:
              if ((entity.getZkresult() != null) && (entity.getZkresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getZkresult()));
              else {
                cell.setCellValue(entity.getZkresult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 6:
              if ((entity.getZkbzresult() != null) && (entity.getZkbzresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getZkbzresult()));
              else {
                cell.setCellValue(entity.getZkbzresult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 7:
              if ((entity.getZkbkresult() != null) && (entity.getZkbkresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getZkbkresult()));
              else {
                cell.setCellValue(entity.getZkbkresult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 8:
              if ((entity.getZkbkbzresult() != null) && (entity.getZkbkbzresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getZkbkbzresult()));
              else {
                cell.setCellValue(entity.getZkbkbzresult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 9:
              if ((entity.getCxresult() != null) && (entity.getCxresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getCxresult()));
              else {
                cell.setCellValue(entity.getCxresult());
              }
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 10:
              if ((entity.getCxbzresult() != null) && (entity.getCxbzresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getCxbzresult()));
              else {
                cell.setCellValue(entity.getCxbzresult());
              }
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 11:
              if ((entity.getBqkresult() != null) && (entity.getBqkresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getBqkresult()));
              else {
                cell.setCellValue(entity.getBqkresult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 12:
              if ((entity.getBqkbzresult() != null) && (entity.getBqkbzresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getBqkbzresult()));
              else {
                cell.setCellValue(entity.getBqkbzresult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 13:
              if ((entity.getQtresult() != null) && (entity.getQtresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getQtresult()));
              else {
                cell.setCellValue(entity.getQtresult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 14:
              if ((entity.getQtbzresult() != null) && (entity.getQtbzresult().matches(regex)))
                cell.setCellValue(Double.parseDouble(entity.getQtbzresult()));
              else {
                cell.setCellValue(entity.getQtbzresult());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
            }
          }
        }

      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }

  public String buildXSLXExcelclassResult_(List title, List conter) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());
    String basePath = "D:/download/";
    String exportFileName = "考试成绩" + now + ".xlsx";
    XSSFWorkbook workBook = null;
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "考试成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = title.size(); i < size; i++) {
        if (i < 3)
          sheet.setColumnWidth(i, 4000);
        else {
          sheet.setColumnWidth(i, ((String)title.get(i)).getBytes().length * 2 * 130);
        }
        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue((String)title.get(i));
      }
      if ((conter != null) && (!conter.isEmpty())) {
        XSSFCellStyle style = workBook.createCellStyle();
        int i1 = 0; for (int size1 = conter.size(); i1 < size1; i1++)
        {
          XSSFRow row = sheet.createRow((short)i1 + 1);
          List list2 = (List)conter.get(i1);
          int j = 0; for (int length = list2.size(); j < length; j++) {
            String regex = "^[0-9]+([.]{1}[0-9]+){0,1}$";
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            if (((String)list2.get(j) != null) && (((String)list2.get(j)).matches(regex)))
            {
              cell.setCellValue(Double.parseDouble((String)list2.get(j)));
            }
            else cell.setCellValue((String)list2.get(j));

            style.setAlignment((short)2);
            cell.setCellStyle(style);
          }
        }
      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }

  public String exportCurrResultExcelFeibaifenzhi(String[] cellTitle, List<Student> list, Exam exam)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());
    String basePath = "D:/download/";
    String exportFileName = exam.getScoreTypeName() + "-" + exam.getExamTypeName() + "-" + "本次考试成绩" + now + ".xlsx";
    XSSFWorkbook workBook = null;
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "考试成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 4000);
          break;
        case 1:
          sheet.setColumnWidth(1, 4000);
          break;
        case 2:
          sheet.setColumnWidth(2, 8000);
          break;
        case 3:
          sheet.setColumnWidth(3, 10000);
          break;
        case 4:
          sheet.setColumnWidth(4, 4000);
          break;
        case 5:
          sheet.setColumnWidth(5, 4000);
          break;
        case 6:
          sheet.setColumnWidth(6, 6000);
          break;
        case 7:
          sheet.setColumnWidth(7, 6000);
          break;
        case 8:
          sheet.setColumnWidth(7, 6000);
          break;
        case 9:
          sheet.setColumnWidth(7, 6000);
          break;
        case 10:
          sheet.setColumnWidth(7, 6000);
          break;
        case 11:
          sheet.setColumnWidth(7, 6000);
          break;
        case 12:
          sheet.setColumnWidth(7, 6000);
          break;
        case 13:
          sheet.setColumnWidth(7, 6000);
          break;
        case 14:
          sheet.setColumnWidth(7, 6000);
          break;
        case 15:
          sheet.setColumnWidth(7, 6000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue(cellTitle[i]);
      }

      if ((list != null) && (!list.isEmpty())) {
        XSSFCellStyle style = workBook.createCellStyle();
        int i1 = 0; for (int size1 = list.size(); i1 < size1; i1++) {
          Student entity = (Student)list.get(i1);
          XSSFRow row = sheet.createRow((short)i1 + 1);
          int j = 0; for (int length = cellTitle.length; j < length; j++) {
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            switch (j)
            {
            case 0:
              cell.setCellValue(entity.getSid());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 1:
              cell.setCellValue(entity.getName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 2:
              cell.setCellValue(entity.getClassname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 3:
              cell.setCellValue(exam.getSubjectname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 4:
              String phaseName = "";
              if (exam.getPhaseid().intValue() == 0)
                phaseName = "无";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment1";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment2";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment3";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment4";
              else
                phaseName = "Assessment5";
              cell.setCellValue(phaseName);
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 5:
              cell.setCellValue(exam.getScoreTypeName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 6:
              if (exam.getExamtype().intValue() == 1)
                cell.setCellValue(entity.getZk());
              else if (exam.getExamtype().intValue() == 2)
                cell.setCellValue(entity.getZkbz());
              else if (exam.getExamtype().intValue() == 3)
                cell.setCellValue(entity.getZkbk());
              else if (exam.getExamtype().intValue() == 4)
                cell.setCellValue(entity.getZkbkbz());
              else if (exam.getExamtype().intValue() == 5)
                cell.setCellValue(entity.getCx());
              else if (exam.getExamtype().intValue() == 6)
                cell.setCellValue(entity.getCxbz());
              else if (exam.getExamtype().intValue() == 7)
                cell.setCellValue(entity.getBqk());
              else if (exam.getExamtype().intValue() == 8)
                cell.setCellValue(entity.getBqkbz());
              else if (exam.getExamtype().intValue() == 9)
                cell.setCellValue(entity.getQt());
              else if (exam.getExamtype().intValue() == 10)
                cell.setCellValue(entity.getQtbz());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 7:
              if ((entity.getBaifenscore() == null) || (entity.getBaifenscore().doubleValue() == 0.0D))
                cell.setCellValue("");
              else {
                cell.setCellValue(entity.getBaifenscore().doubleValue());
              }
              style.setAlignment((short)2);
              cell.setCellStyle(style);
            }
          }
        }

      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }

  public String exportCurrResultExcelJifendanyuanAndBaifenzhi(String[] cellTitle, List<Student> list, Exam exam)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());
    String basePath = "D:/download/";
    String exportFileName = exam.getScoreTypeName() + "-" + exam.getExamTypeName() + "-" + "本次考试成绩" + now + ".xlsx";
    XSSFWorkbook workBook = null;
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "考试成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 4000);
          break;
        case 1:
          sheet.setColumnWidth(1, 4000);
          break;
        case 2:
          sheet.setColumnWidth(2, 8000);
          break;
        case 3:
          sheet.setColumnWidth(3, 10000);
          break;
        case 4:
          sheet.setColumnWidth(4, 4000);
          break;
        case 5:
          sheet.setColumnWidth(5, 4000);
          break;
        case 6:
          sheet.setColumnWidth(6, 4000);
          break;
        case 7:
          sheet.setColumnWidth(7, 4000);
          break;
        case 8:
          sheet.setColumnWidth(7, 4000);
          break;
        case 9:
          sheet.setColumnWidth(7, 4000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue(cellTitle[i]);
      }

      if ((list != null) && (!list.isEmpty())) {
        XSSFCellStyle style = workBook.createCellStyle();
        int i1 = 0; for (int size1 = list.size(); i1 < size1; i1++) {
          Student entity = (Student)list.get(i1);
          XSSFRow row = sheet.createRow((short)i1 + 1);
          int j = 0; for (int length = cellTitle.length; j < length; j++) {
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            switch (j)
            {
            case 0:
              cell.setCellValue(entity.getSid());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 1:
              cell.setCellValue(entity.getName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 2:
              cell.setCellValue(entity.getClassname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 3:
              cell.setCellValue(exam.getSubjectname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 4:
              String phaseName = "";
              if (exam.getPhaseid().intValue() == 0)
                phaseName = "无";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment1";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment2";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment3";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment4";
              else
                phaseName = "Assessment5";
              cell.setCellValue(phaseName);
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 5:
              cell.setCellValue(exam.getScoreTypeName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 6:
              if (exam.getExamtype().intValue() == 1)
                cell.setCellValue(entity.getZk());
              else if (exam.getExamtype().intValue() == 2)
                cell.setCellValue(entity.getZkbz());
              else if (exam.getExamtype().intValue() == 3)
                cell.setCellValue(entity.getZkbk());
              else if (exam.getExamtype().intValue() == 4)
                cell.setCellValue(entity.getZkbkbz());
              else if (exam.getExamtype().intValue() == 5)
                cell.setCellValue(entity.getCx());
              else if (exam.getExamtype().intValue() == 6)
                cell.setCellValue(entity.getCxbz());
              else if (exam.getExamtype().intValue() == 7)
                cell.setCellValue(entity.getBqk());
              else if (exam.getExamtype().intValue() == 8)
                cell.setCellValue(entity.getBqkbz());
              else if (exam.getExamtype().intValue() == 9)
                cell.setCellValue(entity.getQt());
              else if (exam.getExamtype().intValue() == 10)
                cell.setCellValue(entity.getQtbz());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 7:
              cell.setCellValue(entity.getBaifenscore().doubleValue());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
            }
          }
        }

      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }

  public String exportCurrSubjectResultExcelFeibaifenzhi(String[] cellTitle, List<Student> list, Exam exam)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());
    String basePath = "D:/download/";
    String exportFileName = exam.getScoreTypeName() + "-" + exam.getExamTypeName() + "-" + "本次考试成绩" + now + ".xlsx";
    XSSFWorkbook workBook = null;
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "考试成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 4000);
          break;
        case 1:
          sheet.setColumnWidth(1, 4000);
          break;
        case 2:
          sheet.setColumnWidth(2, 4000);
          break;
        case 3:
          sheet.setColumnWidth(3, 4000);
          break;
        case 4:
          sheet.setColumnWidth(4, 10000);
          break;
        case 5:
          sheet.setColumnWidth(5, 4000);
          break;
        case 6:
          sheet.setColumnWidth(6, 6000);
          break;
        case 7:
          sheet.setColumnWidth(7, 6000);
          break;
        case 8:
          sheet.setColumnWidth(7, 6000);
          break;
        case 9:
          sheet.setColumnWidth(7, 6000);
          break;
        case 10:
          sheet.setColumnWidth(7, 6000);
          break;
        case 11:
          sheet.setColumnWidth(7, 6000);
          break;
        case 12:
          sheet.setColumnWidth(7, 6000);
          break;
        case 13:
          sheet.setColumnWidth(7, 6000);
          break;
        case 14:
          sheet.setColumnWidth(7, 6000);
          break;
        case 15:
          sheet.setColumnWidth(7, 6000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue(cellTitle[i]);
      }

      if ((list != null) && (!list.isEmpty())) {
        XSSFCellStyle style = workBook.createCellStyle();
        int i1 = 0; for (int size1 = list.size(); i1 < size1; i1++) {
          Student entity = (Student)list.get(i1);
          XSSFRow row = sheet.createRow((short)i1 + 1);
          int j = 0; for (int length = cellTitle.length; j < length; j++) {
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            switch (j)
            {
            case 0:
              cell.setCellValue(entity.getSid());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 1:
              cell.setCellValue(entity.getName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 2:
              cell.setCellValue(entity.getClassname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 3:
              cell.setCellValue(exam.getSubjectname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 4:
              String phaseName = "";
              if (exam.getPhaseid().intValue() == 0)
                phaseName = "无";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment1";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment2";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment3";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment4";
              else
                phaseName = "Assessment5";
              cell.setCellValue(phaseName);
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 5:
              cell.setCellValue(exam.getScoreTypeName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 6:
              cell.setCellValue(entity.getZk());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 7:
              cell.setCellValue(entity.getZkbz());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 8:
              cell.setCellValue(entity.getZkbk());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 9:
              cell.setCellValue(entity.getZkbkbz());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 10:
              cell.setCellValue(entity.getCx());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 11:
              cell.setCellValue(entity.getCxbz());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 12:
              cell.setCellValue(entity.getBqk());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 13:
              cell.setCellValue(entity.getBqkbz());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 14:
              cell.setCellValue(entity.getQt());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 15:
              cell.setCellValue(entity.getQtbz());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
            }
          }
        }

      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }

  public String exportCurrSubjectResultExcelJifendanyuanAndBaifenzhi(String[] cellTitle, List<Student> list, Exam exam)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());
    String basePath = "D:/download/";
    String exportFileName = exam.getScoreTypeName() + "-" + exam.getExamTypeName() + "-" + "本次考试成绩" + now + ".xlsx";
    XSSFWorkbook workBook = null;
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "考试成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 4000);
          break;
        case 1:
          sheet.setColumnWidth(1, 4000);
          break;
        case 2:
          sheet.setColumnWidth(2, 8000);
          break;
        case 3:
          sheet.setColumnWidth(3, 10000);
          break;
        case 4:
          sheet.setColumnWidth(4, 4000);
          break;
        case 5:
          sheet.setColumnWidth(5, 4000);
          break;
        case 6:
          sheet.setColumnWidth(6, 4000);
          break;
        case 7:
          sheet.setColumnWidth(7, 4000);
          break;
        case 8:
          sheet.setColumnWidth(7, 4000);
          break;
        case 9:
          sheet.setColumnWidth(7, 4000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue(cellTitle[i]);
      }

      if ((list != null) && (!list.isEmpty())) {
        XSSFCellStyle style = workBook.createCellStyle();
        int i1 = 0; for (int size1 = list.size(); i1 < size1; i1++) {
          Student entity = (Student)list.get(i1);
          XSSFRow row = sheet.createRow((short)i1 + 1);
          int j = 0; for (int length = cellTitle.length; j < length; j++) {
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            switch (j)
            {
            case 0:
              cell.setCellValue(entity.getSid());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 1:
              cell.setCellValue(entity.getName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 2:
              cell.setCellValue(entity.getClassname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 3:
              cell.setCellValue(exam.getSubjectname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 4:
              String phaseName = "";
              if (exam.getPhaseid().intValue() == 0)
                phaseName = "无";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment1";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment2";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment3";
              else if (exam.getPhaseid().intValue() == 1)
                phaseName = "Assessment4";
              else
                phaseName = "Assessment5";
              cell.setCellValue(phaseName);
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 5:
              cell.setCellValue(exam.getScoreTypeName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 6:
              cell.setCellValue(entity.getZk());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 7:
              cell.setCellValue(entity.getZkbk());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 8:
              cell.setCellValue(entity.getBqk());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 9:
              cell.setCellValue(entity.getQt());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
            }
          }
        }

      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }

  public String exportAbsenceExcel(String[] cellTitle, List<Absence> list, String name)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    String now = format.format(new Date());
    String basePath = "D:/download/";
    String exportFileName = name + "-考勤记录-" + now + ".xlsx";
    XSSFWorkbook workBook = null;
    try {
      workBook = new XSSFWorkbook();
      XSSFSheet sheet = workBook.createSheet();
      workBook.setSheetName(0, "考试成绩");
      XSSFFont font = workBook.createFont();
      font.setColor((short)32767);
      font.setBoldweight((short)700);
      XSSFCellStyle cellStyle = workBook.createCellStyle();
      cellStyle.setFont(font);
      cellStyle.setAlignment((short)2);
      cellStyle.setVerticalAlignment((short)1);

      XSSFRow titleRow = sheet.createRow(0);
      int i = 0; for (int size = cellTitle.length; i < size; i++) {
        switch (i) {
        case 0:
          sheet.setColumnWidth(0, 4000);
          break;
        case 1:
          sheet.setColumnWidth(1, 4000);
          break;
        case 2:
          sheet.setColumnWidth(2, 4000);
          break;
        case 3:
          sheet.setColumnWidth(3, 8000);
          break;
        case 4:
          sheet.setColumnWidth(4, 4000);
          break;
        case 5:
          sheet.setColumnWidth(5, 6000);
        }

        XSSFCell cell = titleRow.createCell(i, 0);
        cell.setCellStyle(cellStyle);
        cell.setCellType(1);
        cell.setCellValue(cellTitle[i]);
      }

      if ((list != null) && (!list.isEmpty())) {
        XSSFCellStyle style = workBook.createCellStyle();
        int i1 = 0; for (int size1 = list.size(); i1 < size1; i1++) {
          Absence entity = (Absence)list.get(i1);
          XSSFRow row = sheet.createRow((short)i1 + 1);
          int j = 0; for (int length = cellTitle.length; j < length; j++) {
            XSSFCell cell = row.createCell(j, 0);
            cell.setCellType(1);
            switch (j)
            {
            case 0:
              cell.setCellValue(entity.getSid());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 1:
              cell.setCellValue(entity.getStudent().getName());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 2:
           //   cell.setCellValue(entity.getStudent().getClassname());
              cell.setCellValue(entity.getClassname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 3:
              cell.setCellValue(entity.getSubjectname());
              style.setAlignment((short)1);
              cell.setCellStyle(style);
              break;
            case 4:
              String absencetype = "";
              if (entity.getType().intValue() == 1)
                absencetype = "迟到";
              else if (entity.getType().intValue() == 2)
                absencetype = "旷课";
              else if (entity.getType().intValue() == 3)
                absencetype = "请假";
              else if (entity.getType().intValue() == 4)
                absencetype = "早退";
              else if (entity.getType().intValue() == 5) {
                absencetype = "迟到-早退";
              }
              cell.setCellValue(absencetype);
              style.setAlignment((short)2);
              cell.setCellStyle(style);
              break;
            case 5:
              cell.setCellValue(entity.getTempdate());
              style.setAlignment((short)2);
              cell.setCellStyle(style);
            }
          }
        }

      }

      File bolfile = new File(basePath);
      if (!bolfile.exists()) {
        bolfile.mkdir();
      }
      File file = new File(basePath + exportFileName);
      FileOutputStream outStream = new FileOutputStream(file);
      workBook.write(outStream);
      outStream.flush();
      outStream.close();
      return exportFileName;
    } catch (IOException e) {
      System.out.println("生成成绩Excel发生IO 异常！" + e.getMessage());
      e.printStackTrace();
      return "false";
    } catch (Exception e) {
      System.out.println("文件导出发生异常！异常原因：" + e.getMessage());
      e.printStackTrace();
    }return "false";
  }
}