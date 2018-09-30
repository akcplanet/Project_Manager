/**
 * 
 */
package org.cts.pm.controller;

import java.util.List;

import javax.validation.Valid;

import org.cts.pm.entity.Project;
import org.cts.pm.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */
@RestController
@RequestMapping("/project")
@CrossOrigin(origins="*")
public class ProjectController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProjectService projectService;

	@GetMapping
	public  @ResponseBody  ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public  @ResponseBody  ResponseEntity<Project> getProjectById(@PathVariable("id") String projectId) {
		Project project = projectService.getProjectById(projectId);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public  @ResponseBody  ResponseEntity<?> createProject(@PathVariable("id") String userId , @RequestBody Project project) {
		projectService.addProject(project, userId);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public  @ResponseBody  ResponseEntity<Project> updateProject(@PathVariable("id") String userId, @RequestBody Project project) {
		projectService.updateProject(project , userId);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public  @ResponseBody  ResponseEntity<?> deleteProject(@PathVariable(value = "id") String projectId) {
		projectService.deleteProject(projectId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}