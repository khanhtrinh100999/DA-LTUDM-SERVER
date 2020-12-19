/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuce.edu.ltudm.demo.repository;

/**
 *
 * @author Khanh Trinh
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nuce.edu.ltudm.demo.entity.User;
import org.yaml.snakeyaml.events.Event;

/* this the user  Repository interface  */ 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

public User findOneByUsername(String username);
//public User getOne(Event.ID id);

}
