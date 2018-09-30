/**
 * 
 */
package org.cts.pm.controller;

import java.util.List;

import javax.validation.Valid;

import org.cts.pm.entity.Task;
import org.cts.pm.service.TaskService;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerTest  {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 TaskService taskService;
	 
	
}
