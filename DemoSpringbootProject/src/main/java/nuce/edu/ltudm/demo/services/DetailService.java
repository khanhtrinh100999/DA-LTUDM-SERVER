package nuce.edu.ltudm.demo.services;

import nuce.edu.ltudm.demo.entity.User;
import nuce.edu.ltudm.demo.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {

    @Autowired
    DetailRepository detailRepository;

    public User save(User user) {
        return detailRepository.saveAndFlush(user);
    }

    public User update(User user) {
        return detailRepository.save(user);
    }

    public User find(String userName) {
        return detailRepository.findOneByUsername(userName);
    }

    public User find(Long id) {
        return detailRepository.getOne(id);
    }

}
