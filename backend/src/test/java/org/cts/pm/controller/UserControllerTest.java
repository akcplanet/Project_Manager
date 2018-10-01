/**
 * 
 */
package org.cts.pm.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.cts.pm.entity.User;
import org.cts.pm.repository.ProjectRepository;
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
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	ProjectRepository projectRepositoryMock;

	@Autowired
	UserRepository userRepositoryMock;

	@Test
	public void test_Get_All_Users() {
		try {
			this.entityManager.persistAndGetId(new User("Amit", "Chaudhary", "E4146788"));
			this.mockMvc
					.perform(get("/user").content("{\"firstName\":\"Amit\"}").contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Get_User_By_Id() {
		try {
			String userId = (String) this.entityManager.persistAndGetId(new User("Alexis", "Leon", "E4146788"));
			this.mockMvc.perform(get("/user/{id}", userId).content("{\"firstName\":\"Alexis\"}")
					.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Add_User() {
		try {
			String userId = (String) this.entityManager.persistAndGetId(new User("Sumit", "Jakson", "E4146788"));
			this.mockMvc.perform(
					post("/user", userId).content("{\"firstName\":\"Sumit\"}").contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Update_User() {
		try {
			String userId = (String) this.entityManager.persistAndGetId(new User("Amit", "Chaudhary", "E4146788"));
			Optional<User> actual = this.userRepositoryMock.findById(userId);
			actual.get().setFirstName("TESTALEXIS");
			;
			this.userRepositoryMock.saveAndFlush(actual.get());
			this.mockMvc.perform(
					put("/user").content("{\"firstName\":\"TESTALEXIS\"}").contentType(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_Delete_User() {
		try {
			String userId = (String) this.entityManager.persistAndGetId(new User("Amit", "Chaudhary", "E4146788"));
			this.userRepositoryMock.deleteById(userId);
			this.mockMvc.perform(delete("/user/{id}", userId).contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}