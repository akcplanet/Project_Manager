package org.cts.pm.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.cts.pm.entity.ParentTask;
import org.cts.pm.entity.Project;
import org.cts.pm.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestEntityManager
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class TaskDAOImplTest {

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
	public void test_Get_All_Tasks() throws Exception{
		Optional<Project> project=	this.projectRepositoryMock.findById((String) this.entityManager.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
		Optional<ParentTask> task=	this.parentRepositoryMock.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
		 this.entityManager.persistAndGetId(new Task(project.get(),task.get(), "TASK1 for H2 Testing", new Date(), new Date(), 10, "COMPLETED"));
		 this.entityManager.persistAndGetId(new Task(project.get(),task.get(), "TASK2 for H2 Testing", new Date(), new Date(), 9, null));
		 this.entityManager.persistAndGetId(new Task(project.get(),task.get(), "TASK3 for H2 Testing", new Date(), new Date(), 0, "PENDING"));
		List<Task> actual = this.taskRepositoryMock.findAll();
		 assertThat(actual.size(), is(3));
	}

	@Test
	public void test_Get_Task_By_Id() throws Exception {
		Optional<Project> project=	this.projectRepositoryMock.findById((String) this.entityManager.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
		Optional<ParentTask> task=	this.parentRepositoryMock.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
		String taskID = (String) 	 this.entityManager.persistAndGetId(new Task(project.get(),task.get(), "ID TASK1 for H2 Testing", new Date(), new Date(), 10, "COMPLETED"));
		Optional<Task> actual = this.taskRepositoryMock.findById(taskID);
		assertEquals("ID TASK1 for H2 Testing", actual.get().getTask());
	}

	@Test
	public void test_Add_Task() throws Exception{
		Optional<Project> project=	this.projectRepositoryMock.findById((String) this.entityManager.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
		Optional<ParentTask> task=	this.parentRepositoryMock.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
		String taskID = (String) 	 this.entityManager.persistAndGetId(new Task(project.get(),task.get(), "ADD TASK1 for H2 Testing", new Date(), new Date(), 10, "COMPLETED"));
		Optional<Task> actual = this.taskRepositoryMock.findById(taskID);
		assertEquals("ADD TASK1 for H2 Testing", actual.get().getTask());
	}

	@Test
	public void test_Update_Task() throws Exception{		
		Optional<Project> project=	this.projectRepositoryMock.findById((String) this.entityManager.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
		Optional<ParentTask> task=	this.parentRepositoryMock.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
		String taskID = (String) 	 this.entityManager.persistAndGetId(new Task(project.get(),task.get(), "TASK1 for H2 Testing", new Date(), new Date(), 10, "COMPLETED"));
		Optional<Task> actual = this.taskRepositoryMock.findById(taskID);
		actual.get().setTask("TASK Updated  for H2 Testing");
		this.taskRepositoryMock.saveAndFlush(actual.get());
		assertEquals("TASK Updated  for H2 Testing", actual.get().getTask());
	}

	@Test
	public void test_Delete_Task() {
		Optional<Project> project=	this.projectRepositoryMock.findById((String) this.entityManager.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10)));
		Optional<ParentTask> task=	this.parentRepositoryMock.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Test H2 Task")));
		String taskID = (String) 	 this.entityManager.persistAndGetId(new Task(project.get(),task.get(), "TASK1 for H2 Testing", new Date(), new Date(), 10, "COMPLETED"));
		this.taskRepositoryMock.deleteById(taskID);
	    Optional<Task> actual = this.taskRepositoryMock.findById(taskID);
	     assertEquals(Optional.empty(), actual);
	}
	
	@Test
	public void test_Get_All_Parent_Tasks() throws Exception{
		this.parentRepositoryMock.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent One Test H2 Task")));
		this.parentRepositoryMock.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Two Test H2 Task")));
		this.parentRepositoryMock.findById((String) this.entityManager.persistAndGetId(new ParentTask("Parent Three Test H2 Task")));
		List<ParentTask> actual = this.parentRepositoryMock.findAll();
		 assertThat(actual.size(), is(3));
	}

}
