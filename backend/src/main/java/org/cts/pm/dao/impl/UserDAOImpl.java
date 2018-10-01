/**
 * 
 */
package org.cts.pm.dao.impl;

import java.util.List;

import org.cts.pm.dao.UserDAO;
import org.cts.pm.entity.User;
import org.cts.pm.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		logger.info("Logging in  DAO @Repository getAllUsers");
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		logger.info("Logging in  DAO @Repository getUserById  method for userId" + userId);
		return userRepository.getOne(userId);
	}

	@Override
	public void addUser(User user) {
		logger.info("Logging in  DAO @Repository addUser  method");
		userRepository.saveAndFlush(user);
	}

	@Override
	public void updateUser(User user) {
		logger.info("Logging in  DAO @Repository updateUser  method");
		User existing = getUserById(user.getUserId());
		if (existing != null) {
			user.setUserId(existing.getUserId());
			user.setTaskId(existing.getTaskId());
			user.setProjectId(existing.getProjectId());
		}
		userRepository.saveAndFlush(user);
	}

	@Override
	public void deleteUser(String userId) {
		logger.info("Logging in  DAO @Repository deleteUser  method");
		userRepository.deleteById(userId);
	}

}