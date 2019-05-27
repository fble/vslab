package de.hska.iwi.vslab.userservice.db.dataAccessObjects;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.hska.iwi.vslab.userservice.db.dataobjects.User;

@Repository
public class UserDAO {

	private final EntityManager entityManager;

	@Autowired
	public UserDAO(final EntityManagerFactory factory) {
		entityManager = factory.createEntityManager();
	}

	public void registerUser(final User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	public void deleteUserById(int id) {
		entityManager.getTransaction().begin();
		
		User user = entityManager.find(User.class, id);

		if (user != null)
			entityManager.remove(user);
		
		entityManager.getTransaction().commit();
	}

	public User getUserByUsername(final String username) {
		entityManager.getTransaction().begin();
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> query = queryBuilder.createQuery(User.class);
		Root<User> root = query.from(User.class);

		ParameterExpression<String> expression = queryBuilder.parameter(String.class);
		query.select(root).where(queryBuilder.equal(root.get("username"), expression));

		TypedQuery<User> typedQuery = entityManager.createQuery(query);
		typedQuery.setParameter(expression, username);
		List<User> results = typedQuery.getResultList();
		
		entityManager.getTransaction().commit();

		if (results.size() > 0)
			return results.get(0);

		return null;
	}

//	public User getUserByUsername(String name) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		try {
//			User user = null;
//			session.beginTransaction();
//			Criteria crit = session.createCriteria(User.class);
//			crit.add(Restrictions.eq("username", name));
//			List<User> resultList = crit.list();
//			if (resultList.size() > 0) {
//				user = (User) crit.list().get(0);
//			}
//			session.getTransaction().commit();
//			return user;
//		} catch (HibernateException e) {
//			System.out.println("Hibernate Exception" + e.getMessage());
//			session.getTransaction().rollback();
//			throw new RuntimeException(e);
//		}
//	}

}
