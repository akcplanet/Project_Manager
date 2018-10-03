/**
 * 
 */
package org.cts.pm.dao;

import java.util.List;

import org.cts.pm.dto.TaskDTO;
import org.cts.pm.entity.ParentTask;
import org.cts.pm.entity.Task;

/**
 * @author {Amit Kumar chaudhary}
 *
 *         {CTS}
 */

public interface TaskDAO {

	List<Task> getAllTasks();

	Task getTaskById(String taskId);

	void addTask(TaskDTO input, boolean flag);

	void updateTask(TaskDTO input , boolean flag);

	void endTask(String taskId);
	
	List<ParentTask> getAllParentTasks();

}
