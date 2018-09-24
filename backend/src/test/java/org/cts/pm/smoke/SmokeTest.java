/**
 * 
 */
package org.cts.pm.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import org.cts.pm.controller.ProjectController;
import org.cts.pm.controller.TaskController;
import org.cts.pm.controller.UsersController;
import org.cts.pm.service.ProjectService;
import org.cts.pm.service.TaskService;
import org.cts.pm.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Amit Chaudhary
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

	@Autowired
	private ProjectController projectController;

	@Autowired
	private TaskController taskController;

	@Autowired
	private UsersController usersController;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private UsersService usersService;

	@Test
	public void contexLoadsTestForProjectController() throws Exception {
		assertThat(projectController).isNotNull();
	}

	@Test
	public void contexLoadsTestForTaskController() throws Exception {
		assertThat(taskController).isNotNull();
	}

	@Test
	public void contexLoadsTestForUsersController() throws Exception {
		assertThat(usersController).isNotNull();
	}

	@Test
	public void contexLoadsTestForProjectService() throws Exception {
		assertThat(projectService).isNotNull();
	}

	@Test
	public void contexLoadsTestForTaskService() throws Exception {
		assertThat(taskService).isNotNull();
	}

	@Test
	public void contexLoadsTestForUsersService() throws Exception {
		assertThat(usersService).isNotNull();
	}
}
