/**
 * 
 */
package org.cts.pm.controller;

import java.util.List;

import org.cts.pm.entity.User;
import org.cts.pm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserService userService;

	@GetMapping
	public @ResponseBody ResponseEntity<List<User>> getAllUsers() {
		logger.info("Logging in @RestController getAllUsers  method");
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<User> getUserById(@PathVariable("id") String userId) {
		logger.info("Logging in @RestController getUserById  method for userId: " + userId);
		User user = userService.getUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping
	public @ResponseBody ResponseEntity<User> createProject(@RequestBody User user) {
		logger.info("Create @RestController Project Value" + user.getFirstName());
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PutMapping
	public @ResponseBody ResponseEntity<User> updateTask(@RequestBody User user) {
		logger.info("Logging in @RestController updateTask  method for userId: " + user.getUserId());
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<?> deleteTask(@PathVariable(value = "id") String userId) {
		logger.info("Logging in @RestController deleteTask	  method for userId: " + userId);
		userService.deleteUser(userId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}