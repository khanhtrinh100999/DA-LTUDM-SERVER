
package nuce.edu.ltudm.demo.controller;

import java.util.List;
import nuce.edu.ltudm.demo.entity.Wallet;
import nuce.edu.ltudm.demo.repository.WalletRepository;
import nuce.edu.ltudm.demo.services.WalletService;
import nuce.edu.ltudm.demo.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wallet")
public class WalletController {
    
    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    
    @Autowired
    private WalletService walletService ;
    private WalletRepository walletRepository;
    
    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addWallet(@RequestBody Wallet newWallet){
         if (walletService.find(newWallet.getUsername()) != null) {
            logger.error("wallet Already exist " + newWallet.getUsername());
            return new ResponseEntity(
                    new CustomErrorType("The wallet is with username " + newWallet.getUsername() + " already exist "),
                    HttpStatus.CONFLICT);
        }
        
        walletService.save(newWallet);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/get/{username}")
    public List<Wallet> get(@PathVariable String username) {
        return walletService.findAll(username);
    }
    
    
    @CrossOrigin
    @PutMapping("/put/{username}")
    public ResponseEntity<?> put(@PathVariable String username, @RequestBody Wallet input) {
        walletService.save(input);
        return new ResponseEntity<>(null,HttpStatus.valueOf(303));
    }
}
    
