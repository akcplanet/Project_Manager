/**
 * 
 */
package org.cts.pm.dao.impl;

import java.util.List;

import org.cts.pm.dao.UserDAO;
import org.cts.pm.entity.Task;
import org.cts.pm.entity.User;
import org.cts.pm.repository.UserRepository;
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

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		return userRepository.getOne(userId);
	}

	@Override
	public void addUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public void updateUser(User user) {
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
		userRepository.deleteById(userId);
	}

}