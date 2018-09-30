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
		return projectDAO.getAllProjects();
	}

	@Override
	public Project getProjectById(String projectId) {
		return projectDAO.getProjectById(projectId);
	}

	@Override
	public void addProject(Project project, String userId) {
		projectDAO.addProject(project,  userId);
	}

	@Override
	public void updateProject(Project project, String userId) {
		projectDAO.updateProject(project,  userId);
	}

	@Override
	public void deleteProject(String projectId) {
		projectDAO.deleteProject(projectId);
	}

}