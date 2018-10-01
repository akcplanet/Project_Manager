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

import org.cts.pm.entity.Project;
import org.cts.pm.repository.ProjectRepository;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {


	@Autowired
	MockMvc mockMvc;

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	ProjectRepository projectRepositoryMock;

	@Test
	public void test_Get_All_Projects() {
		try {
			this.entityManager.persistAndGetId(new Project("Test1 Project", new Date(), new Date(), 10));
			this.mockMvc
					.perform(get("/project").content("{\"project\":\"Test1 Project\"}")
							.contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.priority").value(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Get_Project_By_Id() {
		try {
			String projectId = (String) this.entityManager
					.persistAndGetId(new Project("Test ID Project", new Date(), new Date(), 20));
			this.mockMvc
					.perform(get("/project/{id}", projectId).content("{\"project\":\"Test ID Project\"}")
							.contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.priority").value(20));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Add_Project() {
		try {
			String projectId = (String) this.entityManager
					.persistAndGetId(new Project("Test_ADD_Project", new Date(), new Date(), 21));
			this.mockMvc
					.perform(post("/project/{id}", projectId).content("{\"project\":\"Test_ADD_Project\"}")
							.contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.priority").value(21));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Update_Project() {
		try {
			String projectId = (String) this.entityManager
					.persistAndGetId(new Project("Test_Project", new Date(), new Date(), 9));
			Optional<Project> actual = this.projectRepositoryMock.findById(projectId);
			actual.get().setProject("PROJECT_UPDATED_TEST");
			this.projectRepositoryMock.saveAndFlush(actual.get());
			this.mockMvc
					.perform(put("/project/{id}", projectId).content("{\"project\":\"PROJECT_UPDATED_TEST\"}")
							.contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.priority").value(9));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Delete_Project() {
		try {
			String projectId = (String) this.entityManager
					.persistAndGetId(new Project("Test_DELETE_Project", new Date(), new Date(), 10));
			this.projectRepositoryMock.deleteById(projectId);
			this.mockMvc.perform(delete("/project/{id}", projectId).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}