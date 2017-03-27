package com.archer.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import java.io.IOException;

/**
 * Created by git on 2017/3/27.
 */
public class Main {

    private static SqlSessionFactory sqlSessionFactory;
    public static void main(String[] args) {
        SqlSession sqlSession;
        try {
//            sqlSessionFactory = Utils.getSqlSessionFactory();
//            sqlSession = sqlSessionFactory.openSession(true);
//            Person p = new Person(-1, "老刘", 152, SEX.MAN);
//            sqlSession.insert("insertPerson",p);
//
//            Person s = sqlSession.selectOne("selectPersonByName", p.getName());
//            System.out.println(s);
//
//            s.setAge(260);
//            sqlSession.update("updatePerson", s);
//            Person s2 = sqlSession.selectOne("selectPersonByName", p.getName());
//            System.out.println(s2);
//
//            sqlSession.delete("deletePerson", s.getId());


            sqlSessionFactory = Utils.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession(true);
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person p = new Person(-1, "老刘", 152, SEX.MAN);
            mapper.insertPerson(p);

            Person s = mapper.selectPersonByName(p.getName());
            System.out.println(s);
            s.setAge(52);
            mapper.updatePerson(s);
            System.out.println(s);

            mapper.deletePerson(s);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//在创建SQLSessionFactory之后，我们需要获取MyBatis最核心的对象SqlSession，所有操作都需要SqlSession来进行。另外它是非线程安全的对象，不能放在类的静态字段上，最好也不要作为实例字段。我们要在需要的时候创建它，不用的时候及时释放。

