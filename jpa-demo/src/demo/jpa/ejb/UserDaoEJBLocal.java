package demo.jpa.ejb;

import java.util.List;

import javax.ejb.Local;

import demo.jpa.model.User;

@Local
public interface UserDaoEJBLocal {
	public void persist(User user);

	public List<User> getAllUsers();
}
