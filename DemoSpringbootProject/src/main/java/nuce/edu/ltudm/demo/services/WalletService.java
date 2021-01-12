package nuce.edu.ltudm.demo.services;

import java.util.ArrayList;
import java.util.List;
import nuce.edu.ltudm.demo.entity.User;
import nuce.edu.ltudm.demo.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nuce.edu.ltudm.demo.repository.WalletRepository;

@Service
public class WalletService {
    
    @Autowired
    WalletRepository walletResponsitory;
    
    
    public Wallet find(String userName) {
		return walletResponsitory.findOneByUsername(userName);
	}
    
    public List<Wallet> findAll(String userName) {
        return walletResponsitory.findAll(userName);
    }

    
    public Wallet save(Wallet wallet) {
        return walletResponsitory.saveAndFlush(wallet);
    }
//
//    public User update(User user) {
//        return walletResponsitory.save(user);
//    }
//
//
//    public User find(Long id) {
//        return walletResponsitory.getOne(id);
//    }

}
