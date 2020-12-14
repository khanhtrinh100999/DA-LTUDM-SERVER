/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Khanh Trinh
 */
package nuce.edu.daltudm.springdaltudm.Entity;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class Wallet {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long money;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wallet", cascade = CascadeType.ALL)
    private Set<Detail> detail;

    public Set<Detail> getDetail() {
        return detail;
    }

    public void setDetail(Set<Detail> detail) {
        this.detail = detail;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
