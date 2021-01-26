package nuce.edu.ltudm.demo.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Khanh Trinh
 */

@Entity
@Table
public class Wallet {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long money;
    private String username;
    private Long thu = 0L;
    private Long chi = 0L;

    public Long getThu() {
        return thu;
    }

    public void setThu(Long thu) {
        this.thu = thu;
    }

    public Long getChi() {
        return chi;
    }

    public void setChi(Long chi) {
        this.chi = chi;
    }

    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}

