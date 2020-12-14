package nuce.edu.daltudm.springdaltudm.Entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table
public class Detail {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_detail;
    
    private String name_detail;
    private Date date_detail;
    private Long money_detail;
    private String status_detail;
    
    @ManyToOne
    @JoinColumn(name="user_Id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name="wallet_id")
    private Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    

    public Long getId_detail() {
        return id_detail;
    }

    public void setId_detail(Long Id_detail) {
        this.id_detail = Id_detail;
    }

    public String getName_detail() {
        return name_detail;
    }

    public void setName_detail(String name_detail) {
        this.name_detail = name_detail;
    }

    public Date getDate_detail() {
        return date_detail;
    }

    public void setDate_detail(Date date_detail) {
        this.date_detail = date_detail;
    }

    public Long getMoney_detail() {
        return money_detail;
    }

    public void setMoney_detail(Long money_detail) {
        this.money_detail = money_detail;
    }

    public String getStatus_detail() {
        return status_detail;
    }

    public void setStatus_detail(String status_detail) {
        this.status_detail = status_detail;
    }
    
    
    
}
