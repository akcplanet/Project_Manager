/**
 * 
 */
package org.cts.pm.entity;

import javax.persistence.MappedSuperclass;

/**
 * @author Amit Chaudhary
 *
 */
@MappedSuperclass
public  class AbstractBaseModel<T> {
	protected T primaryKey;
}