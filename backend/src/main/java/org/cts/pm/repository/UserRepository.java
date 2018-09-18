/**
 * 
 */
package org.cts.pm.repository;

import org.cts.pm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author  Amit Chaudhary
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
