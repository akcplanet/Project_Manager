/**
 * 
 */
package org.cts.pm.dao.impl;

import java.util.List;

import org.cts.pm.dao.ProjectDAO;
import org.cts.pm.entity.Project;
import org.cts.pm.entity.User;
import org.cts.pm.repository.ProjectRepository;
import org.cts.pm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */


@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(String projectId) {
		return projectRepository.getOne(projectId);
	}

	@Transactional
	@Override
	public void addProject(Project project , String userId) {
		User user=userRepository.getOne(userId);
		user.setProjectId(project);
		userRepository.saveAndFlush(user);
	}

	@Transactional
	@Override
	public void updateProject(Project project , String userId) {
		Project existing = getProjectById(project.getProjectId());
		if (existing != null) {
			project.setProjectId(existing.getProjectId());
			User user=userRepository.getOne(userId);
			user.setProjectId(project);
			userRepository.saveAndFlush(user);
		}
	}

	@Transactional
	@Override
	public void deleteProject(String projectId) {
		projectRepository.deleteById(projectId);
	}

}