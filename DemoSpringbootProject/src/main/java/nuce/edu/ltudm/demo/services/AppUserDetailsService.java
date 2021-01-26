package nuce.edu.ltudm.demo.services;

/**
 *
 * @author Khanh Trinh
 */

import nuce.edu.ltudm.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.find(username);
                UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.roles("USER");
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
		//return  user;
	}

}
