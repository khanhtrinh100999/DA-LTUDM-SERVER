
package nuce.edu.ltudm.demo.repository;

import nuce.edu.ltudm.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

@Repository
public interface WalletResponsitory extends JpaRepository<User, Long>{
    public User findOneByUsername(String username);
//    public User getOne(ID id);
}
