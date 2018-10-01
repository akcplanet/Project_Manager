/**
 * 
 */
package org.cts.pm.service.impl;

import java.util.List;

import org.cts.pm.dao.TaskDAO;
import org.cts.pm.dto.TaskDTO;
import org.cts.pm.entity.ParentTask;
import org.cts.pm.entity.Task;
import org.cts.pm.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */
@Service
public class TaskServiceImpl implements TaskService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TaskDAO taskDAO;

	@Override
	public List<Task> getAllTasks() {
		logger.info("Logging in  Service  @@Service getAllTasks");
		return taskDAO.getAllTasks();
	}

	@Override
	public Task getTaskById(String taskId) {
		logger.info("Logging in  Service  @@Service getTaskById method for taskId: " + taskId);
		return taskDAO.getTaskById(taskId);
	}

	@Override
	public void addTask(TaskDTO input) {
		logger.info("Logging in  Service  @@Service addTask method for input: " + input.getUserId());
		taskDAO.addTask(input);
	}

	@Override
	public void updateTask(TaskDTO input) {
		logger.info("Logging in  Service  @@Service updateTask method for input: " + input.getUserId());
		taskDAO.updateTask(input);
	}

	@Override
	public void deleteTask(String taskId) {
		logger.info("Logging in  Service  @@Service deleteTask method for taskId: " + taskId);
		taskDAO.deleteTask(taskId);
	}

	@Override
	public List<ParentTask> getAllParentTasks() {
		logger.info("Logging in  Service  @@Service getAllParentTasks");
		return taskDAO.getAllParentTasks();
	}

}
