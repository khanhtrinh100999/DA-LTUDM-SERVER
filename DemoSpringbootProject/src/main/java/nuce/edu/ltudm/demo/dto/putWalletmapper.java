package nuce.edu.ltudm.demo.dto;

import nuce.edu.ltudm.demo.entity.Wallet;

/**
 *
 * @author Khanh Trinh
 */
public class putWalletmapper {

    public static putWalletDto todoWalletDto(Wallet wallet) {
        putWalletDto tmp = new putWalletDto();
        tmp.setMoney(wallet.getMoney());
        tmp.setUsername(wallet.getUsername());
        return tmp;
    }
}
