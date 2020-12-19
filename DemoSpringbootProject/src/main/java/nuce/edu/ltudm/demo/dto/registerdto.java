package nuce.edu.ltudm.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import nuce.edu.ltudm.demo.entity.User;

public class registerdto extends User {

    private Long id;
    private String username;
    private String fullname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
