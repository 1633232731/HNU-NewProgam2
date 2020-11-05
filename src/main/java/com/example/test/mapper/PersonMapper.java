package com.example.test.mapper;

import com.example.test.bean.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface PersonMapper {
    /**
     * 全部用户查询
     * @return
     */
    @Select("SELECT username,name,age,teleno FROM person")
    List<Person> findAll();

    /**
     * 新增用户，提供四个值
     */
    @Insert("INSERT INTO person(username,name,age,teleno)VALUES(#{username}, #{name}, #{age}, #{teleno})")
    void addPersonFourParams(Person person);

    /**
     * 新增用户，提供三个值，age
     */
    @Insert("INSERT INTO person(username,name,age)VALUES(#{username}, #{name}, #{age})")
    void addPersonThreeParamsWithAge(Person person);

    /**
     * 新增用户，提供三个值，teleno
     */
    @Insert("INSERT INTO person(username,name,teleno)VALUES(#{username}, #{name}, #{teleno})")
    void addPersonThreeParamsWithTeleno(Person person);

    /**
     * 新增用户，提供两个值
     */
    @Insert("INSERT INTO person(username,name)VALUES(#{username}, #{name})")
    void addPersonTwoParams(Person person);



    /**
     * 修改用户
     */
    @Update("UPDATE person SET username=#{username}, name=#{name}, age=#{age}, teleno=#{teleno} WHERE username=#{username}")
    void updatePerson(Person person);

    /**
     * 删除用户
     */
    @Delete("DELETE FROM person WHERE username=#{username}")
    void deletePerson(String username);

    @Select("SELECT username,name,age,teleno FROM person WHERE username=#{username}")
    Person findByUsername(@Param("username")String username);

}
