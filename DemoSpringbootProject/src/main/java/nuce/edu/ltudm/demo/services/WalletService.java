package nuce.edu.ltudm.demo.services;

import nuce.edu.ltudm.demo.entity.User;
import nuce.edu.ltudm.demo.repository.WalletResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    
    @Autowired
    WalletResponsitory walletResponsitory;
    public User save(User user) {
        return walletResponsitory.saveAndFlush(user);
    }

    public User update(User user) {
        return walletResponsitory.save(user);
    }

    public User find(String userName) {
        return walletResponsitory.findOneByUsername(userName);
    }

    public User find(Long id) {
        return walletResponsitory.getOne(id);
    }

}
