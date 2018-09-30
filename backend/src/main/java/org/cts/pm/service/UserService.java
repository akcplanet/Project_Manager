/**
 * 
 */
package org.cts.pm.service;

import java.util.List;

import org.cts.pm.entity.User;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */
public interface UserService {

	List<User> getAllUsers();

	User getUserById(String userId);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(String userId);
}