
package nuce.edu.ltudm.demo.repository;

import java.util.List;
import nuce.edu.ltudm.demo.entity.User;
import nuce.edu.ltudm.demo.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>{
    @Query("select u from Wallet u where u.username=?1")
    public Wallet findOne(String username);
    
    public Wallet findOneByUsername(String username);
    
     @Query("select d from Wallet d where d.username = :name")
    public List<Wallet> findAll(@Param("name") String username);
}
