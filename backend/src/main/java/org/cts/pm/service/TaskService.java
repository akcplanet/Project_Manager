/**
 * 
 */
package org.cts.pm.service;

import java.util.List;

import org.cts.pm.dto.TaskDTO;
import org.cts.pm.entity.ParentTask;
import org.cts.pm.entity.Task;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */

public interface TaskService{

	List<Task> getAllTasks();

	Task getTaskById(String taskId);

	void addTask(TaskDTO input);

	void updateTask(TaskDTO input);

	void deleteTask(String taskId);
	
	List<ParentTask> getAllParentTasks();

}
