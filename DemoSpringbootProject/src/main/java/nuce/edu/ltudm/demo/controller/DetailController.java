/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuce.edu.ltudm.demo.controller;

import nuce.edu.ltudm.demo.entity.Detail;
import nuce.edu.ltudm.demo.services.DetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khanh Trinh
 */
@RestController
@RequestMapping("detail")
public class DetailController {
    private DetailService detaiService;
    
//    @PostMapping("/add")
////    public ResponseEntity<?> addDetail(@RequestBody Detail newDetail){
////     
////        
////    }
}
