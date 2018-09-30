/**
 * 
 */
package org.cts.pm.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.cts.pm.entity.Project;
import org.cts.pm.repository.ProjectRepository;
import org.cts.pm.service.ProjectService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	    MockMvc mockMvc;
	 
	 @Autowired
	    ObjectMapper objectMapper;
	 
	 @MockBean
	 ProjectService projectService;
	 
	 ProjectRepository  projectRepositoryMock;
	 
	 @Before
	    public void setUp() {
		 projectRepositoryMock = Mockito.mock(ProjectRepository.class);
	     //   projectService = new ProjectService(projectRepositoryMock);
	    }
	 
	 

	 
	 
/*	 @Test
	 public void givenProject_whenGetProject_thenReturnJsonArray()
	   throws Exception {
	      
		 Project project = new Project();
		 project.setProjectId("402823816618701401661879da340009");
		 project.setProject("SECOND TASK");
	  
	     Project found = projectService.getProjectById(project.getProjectId());
	  
	     // then
	     assertThat(found.getProject())
	       .isEqualTo(project.getProject());
	 }*/

}