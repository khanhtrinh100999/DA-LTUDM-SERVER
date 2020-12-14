/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuce.edu.ltudm.demo.dao;

/**
 *
 * @author Khanh Trinh
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nuce.edu.ltudm.demo.entity.User;

/* this the user  Repository interface  */ 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

public User findOneByUsername(String username);

}
