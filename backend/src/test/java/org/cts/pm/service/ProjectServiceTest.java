/**
 * 
 */
package org.cts.pm.service;

import java.util.List;

import org.cts.pm.dao.ProjectDAO;
import org.cts.pm.entity.Project;
import org.cts.pm.repository.ProjectDAOImplTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest{
	
	
	@Autowired
	ProjectDAOImplTest projectRepositoryTest;

	@Test
	public void getAllProjects() throws Exception {
		projectRepositoryTest.test_Get_All_Projects();
	}

	@Test
	public void getProjectById() throws Exception {
		
	}

	@Test
	public void addProject() throws Exception {
		
	}

	@Test
	public void updateProject() throws Exception {
		
	}

	@Test
	public void deleteProject(String projectId) throws Exception {
	
	}
	
	
}