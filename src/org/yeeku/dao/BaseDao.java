package org.yeeku.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.yeeku.util.PageResult;

/**
 * 通用基础Dao实现类 作者：曾九洲 2009-7-21
 */
public class BaseDao extends HibernateDaoSupport implements IBaseDao {
	public BaseDao() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bw.common.dao.IBaseDao#save(java.lang.Object)
	 */
	public void save(Object entity) {
		log.debug("保存对象实例");
		try {
			super.getHibernateTemplate().save(entity);
			log.debug("保存成功");
		} catch (RuntimeException re) {
			log.error("保存失败", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bw.common.dao.IBaseDao#delete(java.lang.Object)
	 */
	public void delete(Object entity) {

		log.debug("删除对象实例！");
		try {
			super.getHibernateTemplate().delete(entity);
			log.debug("删除成功");
		} catch (RuntimeException re) {
			log.error("删除失败", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bw.common.dao.IBaseDao#update(java.lang.Object)
	 */
	public void update(Object entity) {
		log.debug("更新对象实例！");
		try {
			super.getHibernateTemplate().update(entity);
			log.debug("更新成功");
		} catch (RuntimeException re) {
			log.error("更新失败", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bw.common.dao.IBaseDao#findALL(java.lang.String)
	 */
	public List findALL(String className) {
		log.debug("查询所有对象");
		try {
			return getHibernateTemplate().find("from " + className);
		} catch (RuntimeException re) {
			log.error("查询失败", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bw.common.dao.IBaseDao#findById(java.lang.Class,
	 * java.io.Serializable)
	 */
	public Object findById(Class entityClass, Serializable id) {
		log.debug("对象Id为: " + id);
		try {
			Object instance = super.getHibernateTemplate().get(entityClass, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("获取失败", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bw.common.dao.IBaseDao#find(java.lang.String,
	 * java.lang.Object[])
	 */
	public List find(String queryString, Object[] values) {
		log.debug("执行多条件对象查询");
		try {
			return super.getHibernateTemplate().find(queryString, values);
		} catch (RuntimeException re) {
			log.error("执行多条件对象查询失败", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bw.common.dao.IBaseDao#findByProperty(java.lang.String,
	 * java.lang.String[], java.lang.Object)
	 */
	public List findByProperty(String entityName, String propertyName,
			Object value) {
		log.debug("查找Obj对象propertyName为: " + propertyName + ", value: "
						+ value);
		try {
			String queryString = "from " + entityName
					+ "  where " + propertyName + "= ?";
			
			return super.getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("按属性名查找失败", re);
			throw re;
		}
	}
	
	public List findUserForLogin(String entityName, String usrName, String email, String cellphone,
			Object value) {
		log.debug("查找Obj对象propertyName为: " + usrName + ", value: "
						+ value);
		try {
			Object values[] = {value, value};
			String queryString = "from " + entityName
					+ "  where " + usrName + "= ? or email = ?";
			
			return super.getHibernateTemplate().find(queryString, values);
		} catch (RuntimeException re) {
			log.error("按属性名查找失败", re);
			throw re;
		}
	}
	
	public List findTUserForLogin(String entityName, String mobilePhone, String email, String cellphone,
			Object value) {
		log.debug("查找Obj对象propertyName为: " + mobilePhone + ", value: "
						+ value);
		try {
			//Object value2 = value;
			Object values[] = {value,value};
			String queryString = "from " + entityName
			+ " where " + mobilePhone + "= ? or mail = ?";
	
			return super.getHibernateTemplate().find(queryString, values);
		} catch (RuntimeException re) {
			log.error("按属性名查找失败", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.bw.common.dao.IBaseDao#findByCriteria(org.hibernate.criterion.
	 * DetachedCriteria)
	 */
	public List findByCriteria(DetachedCriteria criteria) {
		List result = super.getHibernateTemplate().findByCriteria(criteria);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.bw.common.dao.IBaseDao#findByCriteria(org.hibernate.criterion.
	 * DetachedCriteria, org.bw.common.util.PageResult, java.lang.String,
	 * java.lang.Object[])
	 */
	public PageResult findByCriteria(DetachedCriteria criteria,
			PageResult pageResult, String queryString, Object[] values) {
		log.debug("多条件分页查询开始");
		try {
			List result = super.getHibernateTemplate().findByCriteria(criteria,
					pageResult.getBefRecordNum(), pageResult.getPageSize());

			if (result.size() > 0)
				pageResult.setData(result);

			Object obj = getUniqueResult(queryString, values);

			if (obj != null)
				pageResult.setObj(obj);

			log.debug("多条件分页查询成功");
			return pageResult;

		} catch (RuntimeException re) {
			log.error("多条件分页失败");
			throw re;
		}

	}

	/**
	 * 自定义排序方法
	 * 
	 * @param criteria
	 *            DetachedCriteria对象
	 * @param pageResult
	 *            PageResult对象
	 * @param defaultSort
	 *            默认排序类型数组
	 * @param defaultOrderby
	 *            默认排序字段
	 * @param flag
	 *            true: criteria排序 false:hql排序
	 * 
	 * @return 对于Hql返回Order BY 语句 其它无效
	 */
	public String OrderBy(DetachedCriteria criteria, PageResult pageResult,
			boolean flag, String[] defaultSort, String[] defaultOrderby) {
		// 自定义排序
		if (criteria != null) {
			if (pageResult != null) {
				if (pageResult.getSort() != null) {
					if (pageResult.getOrderBy() != null) {
						if (pageResult.getSort().length > 1
								&& pageResult.getOrderBy().length > 1
								&& pageResult.getOrderBy().length == pageResult
										.getSort().length) {
							for (int i = 0; i < pageResult.getSort().length; i++) {
								if (pageResult.getSort()[i].equals("asc")) {
									criteria.addOrder(Order.asc(pageResult
											.getOrderBy()[i]));
								} else {
									criteria.addOrder(Order.desc(pageResult
											.getOrderBy()[i]));
								}
							}

							// 排序字段数为1
						} else if (pageResult.getSort().length > 0
								&& pageResult.getOrderBy().length > 0) {
							if (pageResult.getSort()[0].equals("asc")) {
								criteria.addOrder(Order.desc(pageResult
										.getOrderBy()[0]));
							} else {
								criteria.addOrder(Order.asc(pageResult
										.getOrderBy()[0]));
							}
						}
					}
				}
			}
		}

		// 默认排序
		String orderBy = "  order by  ";
		if (defaultSort != null) {
			if (defaultOrderby != null) {
				if (defaultSort.length > 0 && defaultOrderby.length > 0
						&& defaultOrderby.length == defaultSort.length) {
					for (int i = 0; i < defaultSort.length; i++) {
						// 自定义分页默认排序（criteria等于null）
						if (flag) {
							if (defaultSort[i].equals("asc")) {
								criteria.addOrder(Order.asc(defaultOrderby[i]));
							} else {
								criteria
										.addOrder(Order.desc(defaultOrderby[i]));
							}
						} else {

							if (defaultSort[i].equals("asc")
									|| defaultSort[i].equals("desc")) {
								orderBy = orderBy + defaultOrderby[i] + " "
										+ defaultSort[i] + ",";
							}

						}
					}

					return orderBy.substring(0, orderBy.length() - 1);
				}
			}
			// 自定义分页排序PageResult不为空（criteria等于null）
		} else {
			if (pageResult.getSort() != null && pageResult.getOrderBy() != null) {
				if ((pageResult.getSort().length == pageResult.getOrderBy().length)
						&& pageResult.getOrderBy().length > 0) {
					for (int i = 0; i < pageResult.getSort().length; i++) {
						if (pageResult.getSort()[i].equals("asc")
								|| pageResult.getSort()[i].equals("desc")) {
							orderBy = orderBy + pageResult.getOrderBy()[i]
									+ " " + pageResult.getSort()[i] + ",";
						}

					}

					return orderBy.substring(0, orderBy.length() - 1);
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bw.common.dao.IBaseDao#getUniqueResult(java.lang.String,
	 * java.lang.Object[])
	 */
	public Object getUniqueResult(String queryString, Object[] values) {
		log.debug("执行聚会函数开始");
		try {
			List list = find(queryString, values);
			Object obj = null;
			if (list.size() > 0)
				obj = list.get(0);

			log.debug("执行聚会函数成功");
			return obj;
		} catch (RuntimeException re) {
			log.error("执行聚会函数失败");
		}
		return null;
	}

	/**
	 * 多功能Query查询方法（分页和普通）
	 * 
	 * @param pageResult
	 *            结果实例对象
	 * @param hql
	 *            hql语句：select p from Product p
	 * @param function
	 *            聚合函数如：count(p.prodId)
	 * @return 结果对象
	 */
	public PageResult findByQuery(final PageResult pageResult,
			final String hql, final String function) {
		super.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session arg0)
					throws HibernateException, SQLException {

				if (hql != null) {
					// 分页
					Query query = arg0.createQuery(hql);

					// 当页数和页码小于等于0时，不进行分页
					if (pageResult.getPageNo() > 0
							&& pageResult.getPageSize() > 0) {
						query.setFirstResult(pageResult.getBefRecordNum());
						query.setMaxResults(pageResult.getPageSize());
					}

					List data = query.list();
					if (data != null)
						pageResult.setData(data);

					// 聚合函数
					if (function != null) {
						String urHql = "select " + function + " "
								+ hql.substring(hql.indexOf("from"));
						query = arg0.createQuery(urHql);
						Object obj = query.uniqueResult();
						if (obj != null)
							pageResult.setObj(obj);
					}
				}
				return null;
			}
		});
		return pageResult;
	}
	
	public PageResult findByQueryNoPage(final PageResult pageResult,
			final String hql, final String function) {
		super.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session arg0)
					throws HibernateException, SQLException {

				if (hql != null) {
					// 分页
					Query query = arg0.createQuery(hql);

					// 当页数和页码小于等于0时，不进行分页
					/*if (pageResult.getPageNo() > 0
							&& pageResult.getPageSize() > 0) {
						query.setFirstResult(pageResult.getBefRecordNum());
						query.setMaxResults(pageResult.getPageSize());
					}*/

					List data = query.list();
					if (data != null)
						pageResult.setData(data);

					// 聚合函数
					if (function != null) {
						String urHql = "select " + function + " "
								+ hql.substring(hql.indexOf("from"));
						query = arg0.createQuery(urHql);
						Object obj = query.uniqueResult();
						if (obj != null)
							pageResult.setObj(obj);
					}
				}
				return null;
			}
		});
		return pageResult;
	}

	/**
	 * 保存（没有的数据）并且更新（数据）
	 * 
	 * @param entity
	 */
	public void saveOrupdate(Object entity) {
		log.debug("保存更新对象实例");
		try {
			this.getHibernateTemplate().saveOrUpdate(entity);
			log.debug("保存更新成功");
		} catch (RuntimeException re) {
			log.error("保存更新失败", re);
			throw re;
		}
	}
	
	/**
	 * 可执行SQL语句的增删改
	 * @param sql 语句
	 * @return 影响的行数
	 */
	public int executeSql(final String sql) {
		int fag = (Integer) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session arg0)
							throws HibernateException, SQLException {
						int success = arg0.connection().prepareStatement(sql)
								.executeUpdate();
						return success;
					}
				});
		return fag;
	}
	
	/**
	 * 大批量保存
	 * @param entities 实体集合
	 */
	public void saveOrUpdateAll(Collection entities){
		log.debug("批量保存开始");
		try {
			this.getHibernateTemplate().saveOrUpdateAll(entities);
			log.debug("批量保存成功");
		} catch (RuntimeException re) {
			log.error("批量保存失败", re);
			throw re;
		}
	}
}
