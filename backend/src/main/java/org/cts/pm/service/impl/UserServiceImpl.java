/**
 * 
 */
package org.cts.pm.service.impl;

import java.util.List;

import org.cts.pm.dao.UserDAO;
import org.cts.pm.entity.User;
import org.cts.pm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */
@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserDAO usersDAO;

	@Override
	public List<User> getAllUsers() {
		return usersDAO.getAllUsers();
	}

	@Override
	public User getUserById(String userId) {
		return usersDAO.getUserById(userId);
	}

	@Override
	public void addUser(User user) {
		usersDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		usersDAO.updateUser(user);
	}

	@Override
	public void deleteUser(String userId) {
		usersDAO.deleteUser(userId);
	}

}