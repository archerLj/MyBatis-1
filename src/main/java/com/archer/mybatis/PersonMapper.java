package com.archer.mybatis;

/**
 * Created by git on 2017/3/27.
 */
public interface PersonMapper {
    Person selectPerson(int id);
    Person selectPersonByName(String name);

    void insertPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}
