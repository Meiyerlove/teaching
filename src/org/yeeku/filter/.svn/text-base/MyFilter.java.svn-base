package org.yeeku.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charSet=utf-8");
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 加载配置文件
		// String
		// filePath=filterConfig.getServletContext().getInitParameter("configPath");
		// String path=filterConfig.getServletContext().getRealPath(filePath) ;
		// try {
		// Config.init(path);
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// //获得项目名 格式:/AllocationHouse 没有后面斜杠
		// String projectName =
		// filterConfig.getServletContext().getContextPath();
		// //获得所有文件路径 + "images/css"
		// String folderPath =
		// filterConfig.getServletContext().getRealPath("/");
		// try {
		// //后缀 css js
		// String[] fix = new String[2];
		// fix[0] = "css";
		// fix[1] = "js";
		// //文件夹路径,需要匹配的后缀数组,被替换的内容,需要替换的内容
		// replace2(folderPath, fix, "/OA/", projectName + "/");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// System.out.println("转换失败了!");
		// e.printStackTrace();
		// }
	}
	//   
	// /**
	// * 替换文件
	// * @param folderPath
	// * @param fix
	// * @param reg
	// * @param content
	// * @throws Exception
	// */
	// public void replace2(String folderPath, String[] fix, String reg, String
	// content) throws Exception{
	// File f = new File(folderPath);
	// //如果是目录
	// if(f.isDirectory()){
	// //递归
	// for(String s : f.list()){
	// replace2(folderPath + "/" + s, fix, reg, content);
	// }
	// }
	// //如果是文件
	// if(f.isFile()){
	// //判断是否是匹配的后缀
	// boolean bol = false;
	// for(String fi : fix){
	// int index = f.getName().lastIndexOf(".");
	// if(index != -1){
	// String fileFix = f.getName().substringing(index + 1);
	// if(fi.equals(fileFix)){
	// bol = true;
	// break;
	// }
	// }
	// }
	// //是标准的后缀
	// if(bol){
	// //替换
	// replace(folderPath, reg, content);
	// }
	// }
	// }
	//	
	// /**
	// * 替换文件
	// * @param folderPath 文件的物理完整路径加后缀名的
	// * @param reg 查询的正则表达式
	// * @param content 需要替换的内容
	// * @throws Exception
	// */
	// public void replace(String folderPath, String reg, String content) throws
	// Exception{
	// //传路径读取
	// InputStreamReader ir=new InputStreamReader(new
	// FileInputStream(folderPath),"UTF-8");
	// StringBuffer sb = new StringBuffer("");
	// char[] ch=new char[1024];
	// int len=-1;
	// //读入的字符数目
	// while((len=ir.read(ch))!=-1){
	// //写入字符输出流，
	// sb.append(ch,0,len);
	// }
	// ir.close();
	// //传路径写入
	// OutputStreamWriter ow=new OutputStreamWriter(new
	// FileOutputStream(folderPath),"UTF-8");
	// Pattern p = Pattern.compile(reg);
	// Matcher m = p.matcher(sb.toString());
	// //替换 content 替换成什么字符串
	// String replaceStr = m.replaceAll(content);
	// ow.write(replaceStr);
	// ow.close();
	// }
}
