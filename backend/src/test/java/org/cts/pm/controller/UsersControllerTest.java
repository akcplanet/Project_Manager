/**
 * 
 */
package org.cts.pm.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.cts.pm.entity.User;
import org.cts.pm.service.UsersService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author ALEXIS
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsersService service;
	List<User> user;

	@BeforeClass
	public void init() {
		user = new ArrayList<User>();
		User user2 = new User();
		user2.setFirstName("Amit");
		user2.setLastName("Chaudhary");
		user2.setProjectId("T@");
		user2.setEmployeeId("414566");
		user2.setTaskId("L1");
		user.add(user2);
	}

	@Test
	public void getAllUsersShouldReturnListOfUserFromService() throws Exception {
		when(service.getAllUsers()).thenReturn(user);
		this.mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Get User")));
	}

}
