/**
 * 
 */
package org.cts.pm.dao;

import java.util.List;

import org.cts.pm.entity.User;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */
public interface UserDAO {

	List<User> getAllUsers();

	User getUserById(String userId);

	void addUser(User user);

	void updateUser(User user);

	void deleteUser(String userId);
}