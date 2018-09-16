/**
 * 
 */
package org.cts.pm.service.impl;

import org.cts.pm.dao.TaskDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */
public class TaskServiceImpl  extends BaseServiceImpl{
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 TaskDAO taskDAO;

}
