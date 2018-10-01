/**
 * 
 */
package org.cts.pm.service.impl;

import java.util.List;

import org.cts.pm.dao.ProjectDAO;
import org.cts.pm.entity.Project;
import org.cts.pm.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProjectDAO projectDAO;

	@Override
	public List<Project> getAllProjects() {
		logger.info("Logging in  Service  @@Service getAllProjects");
		return projectDAO.getAllProjects();
	}

	@Override
	public Project getProjectById(String projectId) {
		logger.info("Logging in  Service  @@Service getProjectById method for projectId: " + projectId);
		return projectDAO.getProjectById(projectId);
	}

	@Override
	public void addProject(Project project, String userId) {
		logger.info("Logging in  Service  @@Service addProject method for userId: " + userId);
		projectDAO.addProject(project, userId);
	}

	@Override
	public void updateProject(Project project, String userId) {
		logger.info("Logging in  Service  @@Service updateProject method for userId: " + userId);
		projectDAO.updateProject(project, userId);
	}

	@Override
	public void deleteProject(String projectId) {
		logger.info("Logging in  Service  @@Service deleteProject method for projectId: " + projectId);
		projectDAO.deleteProject(projectId);
	}

}