package nuce.edu.ltudm.demo.services;

import java.util.List;
import nuce.edu.ltudm.demo.entity.Detail;
import nuce.edu.ltudm.demo.entity.Wallet;
import nuce.edu.ltudm.demo.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nuce.edu.ltudm.demo.repository.WalletRepository;

@Service
public class DetailService {

    @Autowired
    DetailRepository detailRepository;
    
    @Autowired
    WalletRepository walletResponsitory;

    public Detail save(Detail detail) {
        Wallet wallet = walletResponsitory.findOne(detail.getUsername());
        if(detail.getStatus_detail().toLowerCase().equals("chi")) {
            wallet.setMoney(wallet.getMoney() - detail.getMoney_detail());
        }
        if(detail.getStatus_detail().toLowerCase().equals("thu")) {
            wallet.setMoney(wallet.getMoney() + detail.getMoney_detail());
        }
        walletResponsitory.saveAndFlush(wallet);
        return detailRepository.saveAndFlush(detail);
    }
    
    public Detail find(Long id) {
        return detailRepository.findOneById(id);
    }
    
    public void deleteDetail(Long id) {
        detailRepository.deleteById(id);
    }
    
     public List<Detail> findAll(String userName) {
        return detailRepository.findAll(userName);
    }

//    public Detail update(Detail detail) {
//        return detailRepository.save(detail);
//    }

    

//    public Detail find(Long id_detail) { 
//       return (Detail) detailRepository.getOne(id_detail);
//      //  return detailRepository.findOneById(id_detail);//.getOne(id_detail);
//    }
   

}
