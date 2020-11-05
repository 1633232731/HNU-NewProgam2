package com.example.test.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private String username;
    private String name;
    private String teleno ;
    private int age;

    {
        age = -1;
    }

    public Person() {
    }

    public String getUsername(){return username;}

    public void setUsername(String username){this.username = username;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getTeleno(){return teleno;}

    public void setTeleno(String teleno){this.teleno = teleno;}

    public int getAge(){return age;}

    public void setAge(String age){
        if (age != "")
            this.age = Integer.parseInt(age);
    }
}
