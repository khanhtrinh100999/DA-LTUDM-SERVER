/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuce.edu.ltudm.demo.controller;

import java.util.List;
import static nuce.edu.ltudm.demo.controller.AccountController.logger;
//import nuce.edu.ltudm.demo.dto.addDetailDto;
import nuce.edu.ltudm.demo.entity.Detail;
import nuce.edu.ltudm.demo.repository.DetailRepository;
import nuce.edu.ltudm.demo.services.DetailService;
import nuce.edu.ltudm.demo.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khanh Trinh
 */
@RestController
@RequestMapping("detail")
public class DetailController {

    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private DetailService detailService;
    private DetailRepository detailRepository;

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addDetail(@RequestBody Detail newDetail){
        detailService.save(newDetail);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/all/{username}")
    public List<Detail> getAll(@PathVariable String username) {
        return detailService.findAll(username);
    }
    
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deleteDetail(@PathVariable String id) {
        detailService.deleteDetail(Long.parseLong(id));
    }
    

    
}
