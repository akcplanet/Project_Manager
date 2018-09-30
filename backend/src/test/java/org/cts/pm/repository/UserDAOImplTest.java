package org.cts.pm.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.cts.pm.entity.User;
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
public class UserDAOImplTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	ProjectRepository projectRepositoryMock;
	

	@Autowired
	UserRepository userRepositoryMock;

	
	@Test
	public void test_Get_All_Users() throws Exception{
		 this.entityManager.persistAndGetId(new User("Amit", "Chaudhary",  "E4146788"));
		 this.entityManager.persistAndGetId(new User("Sumit", "Kimling",  "A4146788"));
		 this.entityManager.persistAndGetId(new User("Karna", "Tinkle",  "T4146788"));
		List<User> actual = this.userRepositoryMock.findAll();
		 assertThat(actual.size(), is(3));
	}

	@Test
	public void test_Get_User_By_Id() throws Exception {
		String userId = (String)  this.entityManager.persistAndGetId(new User("Amit", "Chaudhary",  "E4146788"));
		Optional<User> actual = this.userRepositoryMock.findById(userId);
		assertEquals("Amit", actual.get().getFirstName());
	}

	@Test
	public void test_Add_User() throws Exception{
		String userId = (String)  this.entityManager.persistAndGetId(new User("Amit", "Chaudhary",  "E4146788"));
		Optional<User> actual = this.userRepositoryMock.findById(userId);
		assertEquals("Amit", actual.get().getFirstName());
	}

	@Test
	public void test_Update_User() throws Exception{
		String userId = (String)  this.entityManager.persistAndGetId(new User("Amit", "Chaudhary",  "E4146788"));
		Optional<User> actual = this.userRepositoryMock.findById(userId);
		actual.get().setFirstName("ALEXIS");;
		this.userRepositoryMock.saveAndFlush(actual.get());
		assertEquals("ALEXIS", actual.get().getFirstName());
	}

	@Test
	public void test_Delete_User() {
		String userId = (String)  this.entityManager.persistAndGetId(new User("Amit", "Chaudhary",  "E4146788"));
	     this.userRepositoryMock.deleteById(userId);
	     Optional<User> actual = this.userRepositoryMock.findById(userId);
	     assertEquals(Optional.empty(), actual);
	}

}
