/**
 * 
 */
package org.cts.pm.service.impl;

import org.cts.pm.repository.ParentTaskRepository;
import org.cts.pm.repository.TaskRepository;
import org.cts.pm.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */
@Service
public class TaskServiceImpl  implements TaskService {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 TaskRepository taskRepository;
	 
	 @Autowired
	 ParentTaskRepository parentTaskRepository;

}
