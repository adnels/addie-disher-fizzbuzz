package net.yorksolutions.fizzbuzz;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {

    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @JsonProperty
    public String username;
    public String password;

    public UserEntity() {}

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
