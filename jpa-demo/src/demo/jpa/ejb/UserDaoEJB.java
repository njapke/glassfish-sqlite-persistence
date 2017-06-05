package demo.jpa.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import demo.jpa.model.User;

/**
 * Session Bean implementation class UserDaoEJB
 */
@Stateless
public class UserDaoEJB implements UserDaoEJBLocal {
	@PersistenceContext(unitName = "glassfish-sqlite")
	EntityManager em;

	public void persist(User user) {
		em.persist(user);
	}

	public List<User> getAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
		return query.getResultList();
	}
}
