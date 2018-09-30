/**
 * 
 */
package org.cts.pm.controller;

import java.util.List;

import javax.validation.Valid;

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
		List<Task> tasks = taskService.getAllTasks();
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public  @ResponseBody  ResponseEntity<Task> getTaskById(@PathVariable("id") String taskId) {
		Task task = taskService.getTaskById(taskId);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}

	@PostMapping("/")
	public  @ResponseBody  ResponseEntity<?> createProject(@RequestBody TaskDTO task) {
		taskService.addTask(task);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/")
	public  @ResponseBody  ResponseEntity<?> updateTask(@RequestBody TaskDTO task) {
		taskService.updateTask(task);
		//return new ResponseEntity<TaskDTO>(task, HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public  @ResponseBody  ResponseEntity<?> deleteTask(@PathVariable(value = "id") String taskId) {
		taskService.deleteTask(taskId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/parent")
	public  @ResponseBody  ResponseEntity<List<ParentTask>> getAllParentTasks() {
		List<ParentTask> ptasks = taskService.getAllParentTasks();
		return new ResponseEntity<List<ParentTask>>(ptasks, HttpStatus.OK);
	}


}
