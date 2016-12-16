package org.yeeku.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.yeeku.dao.BaseDao;
import org.yeeku.model.User;

/**
 * ����ҵ�񷽷��� ���ߣ������
 */
public class CommonBiz implements ICommonBiz{
	private BaseDao baseDao = null;

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#getBaseDao()
	 */
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#getBaseDao()
	 */
	public BaseDao getBaseDao() {
		return baseDao;
	}

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#setBaseDao(org.bw.common.dao.BaseDao)
	 */
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#setBaseDao(org.bw.common.dao.BaseDao)
	 */
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#login(javax.servlet.http.HttpServletRequest)
	 */
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#login(javax.servlet.http.HttpServletRequest)
	 */
	public int login(HttpServletRequest request) {
		int fag = -1;
		HttpSession session = request.getSession(false);

		return fag;
	}

	/**
	 * ��ɲ˵�
	 */
	public void builtMenu(HttpServletRequest request) {
	     User user=(User) request.getSession().getAttribute(Global.LOGIN_USER_KEY);
		 if(user.getUserType()!=null && !user.getUserType().equals("")){
			 //if(user.getRole().getRoleRight()!=null && !user.getRole().getRoleRight().equals("")){
				
				//request.getSession().setAttribute(Global.LOGIN_MENU_KEY,sb.toString());
			// }
		 }
	}

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#saveLog(org.bw.team6.entity.User, int)
	 */
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#saveLog(org.bw.team6.entity.User, int)
	 */
	public void saveLog(User user, int logType) {

	}

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#get(java.lang.Class, java.io.Serializable)
	 */
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#get(java.lang.Class, java.io.Serializable)
	 */
	public Object get(Class entityClass, Serializable id) {
		return baseDao.findById(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#save(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#save(java.lang.Object)
	 */
	public void save(Object entity) {
		baseDao.save(entity);
	}

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#update(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#update(java.lang.Object)
	 */
	public void update(Object entity) {
		baseDao.update(entity);
	}
	
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#delete(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#delete(java.lang.Object)
	 */
	public void delete(Object entity) {
		baseDao.delete(entity);
	}
	
    /* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#deleteService(java.lang.String, java.lang.String)
	 */
	public void deleteService(String entityName,String flag) {
		List objList = baseDao.findByProperty(entityName,flag, Global.DATA_DELETE_FLAG);
		if (objList != null) {
			for (int i = 0; i < objList.size(); i++) {
				delete(objList.get(i));
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#find(java.lang.String, java.lang.Object[])
	 */
	public List find(String hql, Object[] obj) {
		return baseDao.find(hql, obj);
	}
	
	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#saveOrupate(java.lang.Object)
	 */
	public void saveOrupate(Object entity){
	    baseDao.saveOrupdate(entity);
	}

	/**
	 * ��ִ��SQL������ɾ��
	 * @param sql ���
	 * @return Ӱ�������
	 */
	public int updateSql(String sql) {
		return baseDao.executeSql(sql);
	}
    
	/**
	 * ����������
	 */
	public void saveOrUpdateAll(Collection entities) {
		this.saveOrUpdateAll(entities);
	}
	
	/**
	 * ���µ�¼���ںʹ���
	 */
	public void updateLoginCountOrDate(Long userId){
		User user=(User) this.get(User.class,userId);
		//user.setLoginCount(user.getLoginCount()+1);
		//user.setLastDateTime(new Date());
		this.update(user);
	}
}
