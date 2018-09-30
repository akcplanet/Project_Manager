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
import org.springframework.transaction.annotation.Transactional;

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
		return taskDAO.getAllTasks();
	}

	@Override
	public Task getTaskById(String taskId) {
		return taskDAO.getTaskById(taskId);
	}

	@Override
	public void addTask(TaskDTO input) {
		taskDAO.addTask(input);
	}

	@Override
	public void updateTask(TaskDTO input) {
		taskDAO.updateTask(input);
	}

	@Override
	public void deleteTask(String taskId) {
		taskDAO.deleteTask(taskId);
	}

	@Override
	public List<ParentTask> getAllParentTasks() {
		return taskDAO.getAllParentTasks();
	}

}
