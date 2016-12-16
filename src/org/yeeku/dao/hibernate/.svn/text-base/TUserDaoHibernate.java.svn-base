package org.yeeku.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.yeeku.model.Student;

public class TUserDaoHibernate extends HibernateDaoSupport{
	
	public List<Student> getStudentList(String sid) {
		List rl = getHibernateTemplate().
		   find("from Student student where sid=?", new Object[]{sid});
		return rl;
	}

}
