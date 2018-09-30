/**
 * 
 */
package org.cts.pm.repository;

import org.cts.pm.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author  Amit Chaudhary
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String>{

}
