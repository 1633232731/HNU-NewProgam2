package com.example.test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    private String username;
    private String pass;

    public Users() {
    }

    public String getUsername(){return username;}

    public void setUsername(String username){this.username = username;}

    public String getPass(){return pass;}

    public void setPass(String pass){this.pass = pass;}

}
