
package nuce.edu.ltudm.demo.controller;

import nuce.edu.ltudm.demo.services.WalletService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wallet")
public class WalletController {
    WalletService walletService ;
    
}
