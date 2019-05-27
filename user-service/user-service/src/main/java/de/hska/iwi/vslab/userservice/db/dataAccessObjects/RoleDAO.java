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

import de.hska.iwi.vslab.userservice.db.dataobjects.Role;

@Repository
public class RoleDAO {

	private final EntityManager entityManager;

	@Autowired
	public RoleDAO(final EntityManagerFactory factory) {
		entityManager = factory.createEntityManager();
	}

	public Role getRoleByLevel(int roleLevel) {
		entityManager.getTransaction().begin();

		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Role> query = queryBuilder.createQuery(Role.class);
		Root<Role> root = query.from(Role.class);

		ParameterExpression<Integer> expression = queryBuilder.parameter(Integer.class);
		query.select(root).where(queryBuilder.equal(root.get("level"), expression));

		TypedQuery<Role> typedQuery = entityManager.createQuery(query);
		typedQuery.setParameter(expression, roleLevel);
		List<Role> results = typedQuery.getResultList();

		entityManager.getTransaction().commit();

		if (results.size() > 0)
			return results.get(0);

		return null;
	}

}
