/**
 * 
 */
package org.cts.pm.dao;

import java.util.List;

import org.cts.pm.entity.Project;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */

public interface ProjectDAO {

	List<Project> getAllProjects();

	Project getProjectById(String projectId);

	void addProject(Project project, String userId);

	void updateProject(Project project , String userId);

	void deleteProject(String projectId);

}