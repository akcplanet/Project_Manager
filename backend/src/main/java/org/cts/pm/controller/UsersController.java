/**
 * 
 */
package org.cts.pm.controller;

import org.cts.pm.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author {Amit Kumar chaudhary}
 *
 * {CTS}
 */
public class UsersController extends BaseController{
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 UsersService usersService;


}