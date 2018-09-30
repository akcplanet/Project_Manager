/**
 * 
 */
package org.cts.pm.dao.impl;

import java.util.List;

import org.cts.pm.dao.TaskDAO;
import org.cts.pm.dto.TaskDTO;
import org.cts.pm.entity.ParentTask;
import org.cts.pm.entity.Project;
import org.cts.pm.entity.Task;
import org.cts.pm.entity.User;
import org.cts.pm.repository.ParentTaskRepository;
import org.cts.pm.repository.ProjectRepository;
import org.cts.pm.repository.TaskRepository;
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
public class TaskDAOImpl implements TaskDAO {

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
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskById(String taskId) {
		return taskRepository.getOne(taskId);
	}

	@Transactional
	@Override
	public void addTask(TaskDTO input) {
		User user = userRepository.getOne(input.getUserId());
		Task tasknew= new Task();
		tasknew.setEndDate(input.getEndDate());
		tasknew.setPriority(input.getPriority());
		tasknew.setStartDate(input.getStartDate());
		tasknew.setStatus(input.getStatus());
		tasknew.setTask(input.getTask());
		tasknew.setProjectId(projectRepository.getOne(input.getProjectId()));
		tasknew.setParentTaskId(parentRepository.getOne(input.getParentId()));
		user.setTaskId(tasknew);
		userRepository.saveAndFlush(user);
	}

	@Transactional
	@Override
	public void updateTask(TaskDTO input) {
		/*Task existing = getTaskById(task.getTaskId());
		if (existing != null)
			task.setTaskId(existing.getTaskId());
		taskRepository.saveAndFlush(task);*/
	}

	@Transactional
	@Override
	public void deleteTask(String taskId) {
		taskRepository.deleteById(taskId);
	}

	@Override
	public List<ParentTask> getAllParentTasks() {
		return parentRepository.findAll();
	}

}
