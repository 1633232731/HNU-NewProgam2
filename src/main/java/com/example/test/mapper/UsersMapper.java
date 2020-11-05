package com.example.test.mapper;

import com.example.test.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    /**
     * 全部用户查询
     * @return List
     */
    @Select("SELECT username,pass FROM users")
    List<Users> findAll();

    /**
     * 新增用户，提供四个值
     */
    @Insert("INSERT INTO users(username,pass)VALUES(#{username}, #{pass})")
    void addUsers(Users users);


    /**
     * 修改用户
     */
    @Update("UPDATE users SET username=#{username}, pass=#{pass} WHERE username=#{username}")
    void updateUsers(Users users);

    /**
     * 删除用户
     */
    @Delete("DELETE FROM users WHERE username=#{username}")
    void deleteUsers(String username);

    @Select("SELECT username,pass FROM users WHERE username=#{username}")
    Users findByUsername(@Param("username")String username);
}
