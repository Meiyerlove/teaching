package org.yeeku.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 注销登录动作类<br>
 * 
 * @author gaozhigang<br>
 */
public class LogoffAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户注销动作执行方法<br>
	 */
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession(); // 获取session
		session.clear(); // 清除session
		return SUCCESS; // 返回
	}
}
