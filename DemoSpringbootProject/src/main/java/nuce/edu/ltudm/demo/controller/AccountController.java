 package nuce.edu.ltudm.demo.controller;

/**
 *
 * @author Khanh Trinh
 */
import java.security.Principal;
import java.util.Properties;
import nuce.edu.ltudm.demo.dto.logindto;
import nuce.edu.ltudm.demo.dto.registerdto;
import nuce.edu.ltudm.demo.entity.User;
import nuce.edu.ltudm.demo.services.UserService;
import nuce.edu.ltudm.demo.util.CustomErrorType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserService userService;

    // request method to create a new account by a guest
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        if (userService.find(newUser.getUsername()) != null) {
            logger.error("username Already exist " + newUser.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + newUser.getUsername() + " already exist "),
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> Login(@RequestBody logindto user) {
        if (userService.find(user.getUsername()) == null) {
            logger.error("username not exist " + user.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("user with username " + user.getUsername() + " not exist "),
                    HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.find(user.getUsername()), HttpStatus.OK);
    }

}
