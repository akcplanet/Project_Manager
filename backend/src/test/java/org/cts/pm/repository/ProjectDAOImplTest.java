package org.cts.pm.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.cts.pm.entity.Project;
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
public class ProjectDAOImplTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	ProjectRepository projectRepositoryMock;

	
	@Test
	public void test_Get_All_Projects() throws Exception{
		 this.entityManager.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10));
		 this.entityManager.persistAndGetId(new Project("Test2 Project", new Date(), new Date(), 10));
		 this.entityManager.persistAndGetId(new Project("Test3 Project", new Date(), new Date(), 10));
		List<Project> actual = this.projectRepositoryMock.findAll();
		 assertThat(actual.size(), is(3));
	}

	@Test
	public void test_Get_Project_By_Id() throws Exception {
		String projectId = (String) this.entityManager.persistAndGetId(new Project("Test Project", new Date(), new Date(), 10));
		Optional<Project> actual = this.projectRepositoryMock.findById(projectId);
		assertEquals("Test Project", actual.get().getProject());
	}

	@Test
	public void test_Add_Project() throws Exception{
		String projectId = (String) this.entityManager.persistAndGetId(new Project("Test_ADD_Project", new Date(), new Date(), 10));
		Optional<Project> actual = this.projectRepositoryMock.findById(projectId);
		assertEquals("Test_ADD_Project", actual.get().getProject());
	}

	@Test
	public void test_Update_Project() throws Exception{
		String projectId = (String) this.entityManager.persistAndGetId(new Project("Test_Project", new Date(), new Date(), 10));
		Optional<Project> actual = this.projectRepositoryMock.findById(projectId);
		actual.get().setProject("PROJECT_UPDATED_TEST");
		this.projectRepositoryMock.saveAndFlush(actual.get());
		assertEquals("PROJECT_UPDATED_TEST", actual.get().getProject());
	}

	@Test
	public void test_Delete_Project() {
		String projectId = (String) this.entityManager.persistAndGetId(new Project("Test_DELETE_Project", new Date(), new Date(), 10));
	     this.projectRepositoryMock.deleteById(projectId);
	     Optional<Project> actual = this.projectRepositoryMock.findById(projectId);
	     assertEquals(Optional.empty(), actual);
	}

}
