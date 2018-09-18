/**
 * 
 */
package org.cts.pm.controller;

import java.util.List;

import javax.validation.Valid;

import org.cts.pm.entity.User;
import org.cts.pm.repository.UserRepository;
import org.cts.pm.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */
@RestController
@RequestMapping("/user")
public class UsersController  {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UsersService usersService;


	@GetMapping("/")
	public List<User> getAllUsers() {
		logger.debug("In method getAllUsers");
		return usersService.getAllUsers();
	}

	@PostMapping("/")
	public User createUser(@Valid @RequestBody User user) {

		return null;
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
		return null;
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {

		return null;

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {

		return ResponseEntity.ok().build();
	}

}