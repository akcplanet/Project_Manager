/**
 * 
 */
package org.cts.pm.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.Optional;

import org.cts.pm.entity.ParentTask;
import org.cts.pm.entity.Project;
import org.cts.pm.entity.Task;
import org.cts.pm.entity.TaskStatus;
import org.cts.pm.repository.ParentTaskRepository;
import org.cts.pm.repository.ProjectRepository;
import org.cts.pm.repository.TaskRepository;
import org.cts.pm.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */
@SpringBootTest
@DataJpaTest
@AutoConfigureTestEntityManager
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	ProjectRepository projectRepositoryMock;

	@Autowired
	TaskRepository taskRepositoryMock;

	@Autowired
	UserRepository userRepositoryMock;

	@Autowired
	ParentTaskRepository parentRepositoryMock;

	@Test
	public void test_Get_All_Tasks() {
		try {
			Optional<Project> project = this.projectRepositoryMock.findById((String) this.entityManager
					.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
			Optional<ParentTask> task = this.parentRepositoryMock
					.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
			this.entityManager.persistAndGetId(new Task(project.get(), task.get(), "TASK1 for H2 Testing", new Date(),
					new Date(), 10, TaskStatus.COMPLETED));
			this.mockMvc
					.perform(get("/task").content("{\"task\":\"TASK1 for H2 Testing\"}")
							.contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.priority").value(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Get_Task_By_Id() {
		try {
			Optional<Project> project = this.projectRepositoryMock.findById((String) this.entityManager
					.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
			Optional<ParentTask> task = this.parentRepositoryMock
					.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
			String taskID = (String) this.entityManager.persistAndGetId(new Task(project.get(), task.get(),
					"ID TASK1 for H2 Testing", new Date(), new Date(), 20, TaskStatus.COMPLETED));
			this.mockMvc
					.perform(get("/task/{id}", taskID).content("{\"task\":\"ID TASK1 for H2 Testing\"}")
							.contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.priority").value(20));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Add_Task() {
		try {
			Optional<Project> project = this.projectRepositoryMock.findById((String) this.entityManager
					.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
			Optional<ParentTask> task = this.parentRepositoryMock
					.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
			String taskID = (String) this.entityManager.persistAndGetId(new Task(project.get(), task.get(),
					"ADD TASK1 for H2 Testing", new Date(), new Date(), 21, TaskStatus.INPROGRESS));
			this.mockMvc
					.perform(post("/task").content("{\"task\":\"ADD TASK1 for H2 Testing\"}")
							.contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.priority").value(21));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Update_Task() {
		try {
			Optional<Project> project = this.projectRepositoryMock.findById((String) this.entityManager
					.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
			Optional<ParentTask> task = this.parentRepositoryMock
					.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
			String taskID = (String) this.entityManager.persistAndGetId(new Task(project.get(), task.get(),
					"TASK1 for H2 Testing", new Date(), new Date(), 9, TaskStatus.INPROGRESS));
			Optional<Task> actual = this.taskRepositoryMock.findById(taskID);
			actual.get().setTask("TASK Updated  for H2 Testing");
			this.taskRepositoryMock.saveAndFlush(actual.get());
			this.mockMvc
					.perform(put("/task").content("{\"task\":\"TASK Updated  for H2 Testing\"}")
							.contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.priority").value(9));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Delete_Task() {
		try {
			Optional<Project> project = this.projectRepositoryMock.findById((String) this.entityManager
					.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
			Optional<ParentTask> task = this.parentRepositoryMock
					.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
			String taskID = (String) this.entityManager.persistAndGetId(new Task(project.get(), task.get(),
					"TASK1 for H2 Testing", new Date(), new Date(), 10, TaskStatus.INPROGRESS));
			this.taskRepositoryMock.deleteById(taskID);
			this.mockMvc.perform(delete("/task/{id}", taskID).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Get_All_Parent_Tasks() {
		try {
			this.parentRepositoryMock
					.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent One Test H2 Task")));
			this.mockMvc.perform(get("/task/parent").content("{\"parentTask\":\"Parent One Test H2 Task\"}")
					.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
