
package nuce.edu.ltudm.demo.dto;

import nuce.edu.ltudm.demo.entity.User;

public class loginMapper {
  public static logindto tologindto(User user){
      logindto tmp = new logindto() ;
      tmp.setUsername(user.getUsername());
      tmp.setPassword(user.getPassword());
//      tmp.setGmail(user.getGmail());
      return tmp;
  }  
}
