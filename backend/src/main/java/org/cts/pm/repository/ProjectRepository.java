/**
 * 
 */
package org.cts.pm.repository;

import org.cts.pm.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author  Amit Chaudhary
 *
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{

}
