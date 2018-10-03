/**
 * 
 */
package org.cts.pm.dao.impl;

import java.util.List;

import org.cts.pm.dao.TaskDAO;
import org.cts.pm.dto.TaskDTO;
import org.cts.pm.entity.ParentTask;
import org.cts.pm.entity.Task;
import org.cts.pm.entity.TaskStatus;
import org.cts.pm.entity.User;
import org.cts.pm.repository.ParentTaskRepository;
import org.cts.pm.repository.ProjectRepository;
import org.cts.pm.repository.TaskRepository;
import org.cts.pm.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */

@Repository
public class TaskDAOImpl implements TaskDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ParentTaskRepository parentRepository;

	@Override
	public List<Task> getAllTasks() {
		logger.info("Logging in  DAO @Repository getAllTasks");
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskById(String taskId) {
		logger.info("Logging in  DAO @Repository getTaskById  method for taskId" + taskId);
		return taskRepository.getOne(taskId);
	}

	@Transactional
	@Override
	public void addTask(TaskDTO input, boolean flag) {
		logger.info("Logging in  DAO @Repository addTask");
		if (flag) {
			ParentTask ptask = new ParentTask();
			ptask.setParentTask(input.getTask());
			ptask = parentRepository.saveAndFlush(ptask);
			logger.info("Logging in  DAO @Repository added Parent Task");
		} else {
			User user = userRepository.getOne(input.getUserId());
			user.setProjectId(projectRepository.getOne(input.getProjectId()));
			Task tasknew = new Task();
			tasknew.setEndDate(input.getEndDate());
			tasknew.setPriority(input.getPriority());
			tasknew.setStartDate(input.getStartDate());
			tasknew.setStatus(TaskStatus.INPROGRESS);
			tasknew.setTask(input.getTask());
			tasknew.setProjectId(projectRepository.getOne(input.getProjectId()));
			tasknew.setParentTaskId(parentRepository.getOne(input.getParentId()));
			user.setTaskId(tasknew);
			userRepository.saveAndFlush(user);
			logger.info("Logging in  DAO @Repository added Task");
		}
	}

	@Transactional
	@Override
	public void updateTask(TaskDTO input, boolean flag) {
		logger.info("Logging in  DAO @Repository updateTask");
		if (flag) {
			ParentTask ptask = parentRepository.getOne(input.getParentId());
			ptask.setParentTask(input.getTask());
			ptask = parentRepository.saveAndFlush(ptask);
			logger.info("Logging in  DAO @Repository added Parent Task");
		} else {
			User user = userRepository.getOne(input.getUserId());
			Task tasknew = user.getTaskId();
			tasknew.setEndDate(input.getEndDate());
			tasknew.setPriority(input.getPriority());
			tasknew.setStartDate(input.getStartDate());
			tasknew.setTask(input.getTask());
			user.setTaskId(tasknew);
			userRepository.saveAndFlush(user);
			logger.info("Logging in  DAO @Repository Updated Task");
		}
	}

	@Transactional
	@Override
	public void endTask(String taskId) {
		logger.info("Logging in  DAO @Repository endTask");
		Task task = taskRepository.getOne(taskId);
		task.setStatus(TaskStatus.COMPLETED);
		taskRepository.saveAndFlush(task);
	}

	@Override
	public List<ParentTask> getAllParentTasks() {
		logger.info("Logging in  DAO @Repository getAllParentTasks");
		return parentRepository.findAll();
	}

}
