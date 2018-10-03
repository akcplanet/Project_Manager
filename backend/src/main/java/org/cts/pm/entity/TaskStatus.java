/**
 * 
 */
package org.cts.pm.entity;

/**
 * @author Amit Chaudhary
 *
 */
public enum TaskStatus {

	COMPLETED("COMPLETED"), INPROGRESS("INPROGRESS");

	private String status;

	TaskStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

}
