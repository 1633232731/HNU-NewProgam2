package com.example.test.service;


import com.example.test.bean.Users;
import com.example.test.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService {
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Autowired(required = false)
    private PersonService personService;
    /**
     * 获取全部的用户
     *
     * @return
     */
    public List<Users> findAll() {
        return usersMapper.findAll();
    }

    /**
     * 添加用户
     *
     * @param users
     */
    @Transactional
    public void addUsers(Users users) {
        usersMapper.addUsers(users);
    }

    /**
     * 修改用户
     *
     * @param users
     */
    @Transactional
    public void updateUsers(Users users) {
        usersMapper.updateUsers(users);
    }

    /**
     * 在user和person中删除数据
     *
     * @param username
     */
    @Transactional
    public void deleteUsers(String username) {
        System.out.println("数据库：users表删除数据  "+username);
        usersMapper.deleteUsers(username);
        System.out.println("数据库：person表删除数据  "+username);
        personService.deletePerson(username);
    }

    /**
     * 查询指定用户
     *
     * @param username
     * @return
     */
    public Users findByUsername(String username) {
        return usersMapper.findByUsername(username);
    }
}
