/**
 * 
 */
package org.cts.pm.controller;

import java.util.List;

import org.cts.pm.dto.TaskDTO;
import org.cts.pm.entity.ParentTask;
import org.cts.pm.entity.Task;
import org.cts.pm.service.TaskService;
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
@RequestMapping("/task")
@CrossOrigin(origins="*")
public class TaskController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TaskService taskService;

	@GetMapping
	public  @ResponseBody  ResponseEntity<List<Task>> getAllTasks() {
		logger.info("Logging in @RestController getAllTasks method");
		List<Task> tasks = taskService.getAllTasks();
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public  @ResponseBody  ResponseEntity<Task> getTaskById(@PathVariable("id") String taskId) {
		logger.info("Logging in @RestController getTaskById  method for taskId: " + taskId);
		Task task = taskService.getTaskById(taskId);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}

	@PostMapping("/")
	public  @ResponseBody  ResponseEntity<?> createProject(@RequestBody TaskDTO task) {
		logger.info("Logging in @RestController createProject  method for userId: " + task.getUserId());
		taskService.addTask(task);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/")
	public  @ResponseBody  ResponseEntity<?> updateTask(@RequestBody TaskDTO task) {
		logger.info("Logging in @RestController updateTask  method for task: " + task.getUserId());
		taskService.updateTask(task);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public  @ResponseBody  ResponseEntity<?> deleteTask(@PathVariable(value = "id") String taskId) {
		logger.info("Logging in @RestController deleteTask  method for taskId: " + taskId);
		taskService.deleteTask(taskId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/parent")
	public  @ResponseBody  ResponseEntity<List<ParentTask>> getAllParentTasks() {
		logger.info("Logging in @RestController getAllParentTasks  method ");
		List<ParentTask> ptasks = taskService.getAllParentTasks();
		return new ResponseEntity<List<ParentTask>>(ptasks, HttpStatus.OK);
	}


}
