package de.hska.iwi.vslab.userservice.db.dataAccessObjects;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import de.hska.iwi.vslab.userservice.db.GenericHibernateDAO;
import de.hska.iwi.vslab.userservice.db.HibernateUtil;
import de.hska.iwi.vslab.userservice.db.dataobjects.User;

@Component
public class UserDAO extends GenericHibernateDAO<User, Integer> {

	public User getUserByUsername(String name) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try
		{
			User user = null;
			session.beginTransaction();
            Criteria crit = session.createCriteria(User.class);
            crit.add(Restrictions.eq("username",name));
            List<User> resultList = crit.list();
            if (resultList.size() > 0) {
            	user = (User) crit.list().get(0);
            }
            session.getTransaction().commit();
            return user;
		}
		catch (HibernateException e)
		{
			System.out.println("Hibernate Exception" + e.getMessage());
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}



}
