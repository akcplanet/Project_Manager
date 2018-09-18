/**
 * 
 */
package org.cts.pm.service.impl;

import org.cts.pm.repository.ProjectRepository;
import org.cts.pm.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService  {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 
	 @Autowired
	 ProjectRepository projectRepository;



}