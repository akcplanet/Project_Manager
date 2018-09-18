/**
 * 
 */
package org.cts.pm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.cts.pm.entity.User;
import org.cts.pm.repository.UserRepository;
import org.cts.pm.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */
@Service
public class UsersServiceImpl  implements UsersService{
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		logger.debug("Inside getAllUsers service" );
		List<User> user= new ArrayList<User>();
		User user2 = new User();
		user2.setFirstName("Amit");
		user2.setLastName("Chaudhary");
		user2.setProjectId("T@");
		user2.setEmployeeId("414566");
		user2.setTaskId("L1");
		user.add(user2);
		logger.debug("user data", user);
		return user;
	}

}