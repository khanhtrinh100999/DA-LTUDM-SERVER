/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuce.edu.daltudm.springdaltudm.Repository;

import nuce.edu.daltudm.springdaltudm.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Khanh Trinh
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

public User findOneByUsername(String username);

}
