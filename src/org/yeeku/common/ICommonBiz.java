package org.yeeku.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.yeeku.dao.BaseDao;
import org.yeeku.model.User;

public interface ICommonBiz {

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#getBaseDao()
	 */
	public abstract BaseDao getBaseDao();

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#setBaseDao(org.bw.common.dao.BaseDao)
	 */
	public abstract void setBaseDao(BaseDao baseDao);

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#login(javax.servlet.http.HttpServletRequest)
	 */
	public abstract int login(HttpServletRequest request);

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#buildMenu()
	 */
	public void builtMenu(HttpServletRequest request);

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#saveLog(org.bw.team6.entity.User, int)
	 */
	public abstract void saveLog(User user, int logType);

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#get(java.lang.Class, java.io.Serializable)
	 */
	public abstract Object get(Class entityClass, Serializable id);

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#save(java.lang.Object)
	 */
	public abstract void save(Object entity);

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#update(java.lang.Object)
	 */
	public abstract void update(Object entity);

	/* (non-Javadoc)
	 * @see org.bw.common.biz.ICommonBiz#delete(java.lang.Object)
	 */
	public abstract void delete(Object entity);

	/**
	 * ������վ
	 * @param entityName ʵ����
	 * @param flag ״̬�ֶ���
	 */
	public abstract void deleteService(String entityName, String flag);

	/**
	 * �Զ����ѯ
	 * @param hql hql���
	 * @param obj ��������
	 * @return
	 */
	public abstract List find(String hql, Object[] obj);

	/**
	 * ���棨û�е���ݣ����Ҹ��£���ݣ�
	 * @param entity
	 */
	public abstract void saveOrupate(Object entity);

	/**
	 * ��ִ��SQL������ɾ��
	 * @param sql ���
	 * @return Ӱ�������
	 */
	public int updateSql(final String sql);
	
	/**
	 * ����������
	 * @param entities ʵ�弯��
	 */
	public void saveOrUpdateAll(Collection entities);
    
	/**
	 * ���µ�¼���ںʹ���
	 */
	public void updateLoginCountOrDate(Long userId);
}