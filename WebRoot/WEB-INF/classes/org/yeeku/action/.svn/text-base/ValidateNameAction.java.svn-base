package org.yeeku.action;

import com.opensymphony.xwork2.Action;

import java.util.*;
import org.yeeku.service.UserManager;
/**
 * @author  yeeku.H.lee zengjiuzhou@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */

public class ValidateNameAction implements Action
{
	private String user;
	private String tip;
	private UserManager mgr;
	public void setMgr(UserManager mgr)
	{
		this.mgr = mgr;
	}

	public String execute()
	{
		try
		{
			if (mgr.validateName(user))
			{
				setTip( "��ã�" + user + ", ����û�����ã�");
			}
			else
			{
				setTip( "ϵͳ������" + user + "�û���������ѡ��һ����");
			}
		}
		catch (Exception e)
		{
			setTip(e.getMessage());
		}
		return SUCCESS;
	}

	public void setUser(String user)
	{
		this.user = user;
	}
	public String getUser()
	{
		 return this.user;
	}

	public void setTip(String tip)
	{
		this.tip = tip;
	}
	public String getTip()
	{
		 return this.tip;
	}
}