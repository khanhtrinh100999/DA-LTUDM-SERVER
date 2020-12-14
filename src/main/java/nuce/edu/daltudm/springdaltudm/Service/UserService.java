package nuce.edu.daltudm.springdaltudm.Service;

import nuce.edu.daltudm.springdaltudm.Entity.User;
import nuce.edu.daltudm.springdaltudm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

        @Autowired
        UserRepository userRepository;

        public User save(User user) {
            return userRepository.saveAndFlush(user);
        }

        public User update(User user) {
            return userRepository.save(user);
        }

        public User find(String username) {
            return userRepository.findOneByUsername(username);
        }

        public User find(Long id) {
            return userRepository.getOne(id);
        }
}
