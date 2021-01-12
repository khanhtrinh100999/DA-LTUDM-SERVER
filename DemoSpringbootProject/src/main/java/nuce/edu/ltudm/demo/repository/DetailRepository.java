
package nuce.edu.ltudm.demo.repository;

import java.util.List;
import nuce.edu.ltudm.demo.entity.Detail;
import nuce.edu.ltudm.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

//@Repository
//public interface DetailRepository extends JpaRepository<User, Long> {
//    
//    public User findOneByUsername(String username);
////    public User getOne(ID id);
//}

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

//    public List<Detail> findAllById(Long id_detail);
    
//    public Detail findOneByID (Long id_detail);
   //   public Detail getOne(ID id);
    public Detail findOneByUsername(String username);
    public Detail findAllByUsername(String username);
    
//    @Query("select u from Detail u where u.username=?1")
//    public List<Detail> findAll(String username);
    
    @Query("select d from Detail d where d.username = :name")
    public List<Detail> findAll(@Param("name") String username);
    
//    @Query("select u from Detail u where u.id_detail=1")
//    public Detail findOne(String username);
    
    @Query("select u from Detail u where u.id_detail=?1")
    public Detail findOneById(Long id);
    
    
    
    
     //@Query("select u from Detail u where u.username=?1")
//    public Detail findOne(String username);
    
}
