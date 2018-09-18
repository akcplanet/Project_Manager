/**
 * 
 */
package org.cts.pm.repository;

import org.cts.pm.entity.ParentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Amit Chaudhary
 *
 */
@Repository
public interface ParentTaskRepository  extends JpaRepository<ParentTask, String> {

}
