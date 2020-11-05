package com.example.test.service;

import com.example.test.bean.Person;
import com.example.test.bean.Users;
import com.example.test.mapper.PersonMapper;
import com.example.test.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    @Autowired(required = false)
    private PersonMapper personMapper;
    @Autowired(required = false)
    private UsersService usersService;

    /**
     * 获取全部的用户
     *
     * @return List
     */
    public List<Person> findAll() {
        return personMapper.findAll();
    }

    /**
     * 添加或者更新用户，添加的时候还会在users表中添加
     *
     * @param person
     *
     */
    @Transactional
    public void addOrUpdatePerson(Person person) {
        Person p;
        p = personMapper.findByUsername(person.getUsername());
        if (p == null){
            // person表中没有这个username，在person和users表中都执行添加
            System.out.println("数据库：Person表新增数据");
            System.out.printf("username: %s\t",person.getUsername());
            System.out.printf("name: %s\t",person.getName());
            if (person.getAge() == -1){
                System.out.print("age: \t");
            }else{
                System.out.printf("age: %d\t",person.getAge());
            }
            System.out.printf("teleno: %s\n",person.getTeleno());

            // 针对不同数据调用不同函数
            if (!person.getTeleno().equals("") && person.getAge() != -1){
                // 四个值都有
                personMapper.addPersonFourParams(person);
            }
            else if(!person.getTeleno().equals("") && person.getAge() == -1){
                personMapper.addPersonThreeParamsWithTeleno(person);
            }
            else if(person.getTeleno().equals("") && person.getAge() != -1){
                personMapper.addPersonThreeParamsWithAge(person);
            }
            else{
                personMapper.addPersonTwoParams(person);
            }

            //添加的时候需要在users表中也添加数据，下面的修改则不需要，耦合问题
            System.out.println("数据库：Users表新增数据");
            System.out.printf("username: %s\t",person.getUsername());
            System.out.println("pass: 88888888");

            Users users = new Users();
            users.setPass("88888888");
            users.setUsername(person.getUsername());
            usersService.addUsers(users);
        }
        else{
            // person表中有这个username，执行修改
            System.out.println("数据库：Person表修改数据");
            System.out.printf("username: %s\t",person.getUsername());
            System.out.printf("name: %s\t",person.getName());
            if (person.getAge() == -1){
                System.out.print("age: \t");
            }else{
                System.out.printf("age: %d\t",person.getAge());
            }
            System.out.printf("teleno: %s\n",person.getTeleno());
            personMapper.updatePerson(person);
        }
    }

    /**
     * 修改用户
     *
     * @param person
     */
    @Transactional
    public void updatePerson(Person person) {
        personMapper.updatePerson(person);
    }

    /**
     * 删除用户
     *
     * @param username
     */
    @Transactional
    public void deletePerson(String username) {
        personMapper.deletePerson(username);
    }

    /**
     * 查询指定用户
     *
     * @param username
     * @return
     */
    public Person findByUsername(String username) {
        return personMapper.findByUsername(username);
    }
}
