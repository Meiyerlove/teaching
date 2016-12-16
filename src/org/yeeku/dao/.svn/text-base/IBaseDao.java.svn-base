package org.yeeku.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.yeeku.util.PageResult;

/**
 * ͨ�û�Dao�ӿ��� ���ߣ������ 2009-7-21
 */
public interface IBaseDao {

	public static final Log log = LogFactory.getLog(BaseDao.class);


	public abstract void save(Object entity);
	

	public abstract void  saveOrupdate(Object entity);


	public abstract void delete(Object entity);


	public abstract void update(Object entity);


	public abstract List findALL(String entityName);

	public abstract Object findById(Class entityClass, Serializable id);


	public abstract List find(String queryString, Object[] values);


	public abstract List findByProperty(String entityName, String propertyName,
			Object value);


	public abstract List findByCriteria(DetachedCriteria criteria);


	public abstract PageResult findByCriteria(DetachedCriteria criteria,
			PageResult pageResult, String queryString, Object[] values);


	public String OrderBy(DetachedCriteria criteria, PageResult pageResult,
			boolean flag, String[] defaultSort, String[] defaultOrderby);


	public abstract Object getUniqueResult(String queryString, Object[] values);


	public PageResult findByQuery(final PageResult pageResult,
			final String hql, final String function);
	
	public PageResult findByQueryNoPage(final PageResult pageResult,
			final String hql, final String function);
	
	public int executeSql(final String sql);
	
	public void saveOrUpdateAll(Collection entities);
}