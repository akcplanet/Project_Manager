/**
 * 
 */
package org.cts.pm.repository;

import java.util.List;

import org.cts.pm.entity.Project;
import org.cts.pm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author  Amit Chaudhary
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public List<User> findByProjectId(Project projectId);
}
