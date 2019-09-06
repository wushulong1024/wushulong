package com.qs.Test1;

import com.qs.entity.Car;
import com.qs.entity.Userti;
import com.qs.userdao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

    /**
    * @author shkstart
    * @create 2019-08-10 14:12
    */
public class Test1 {

   private SqlSession session;
    private InputStream in;

    @Before // 在测试方法前执行
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMspConfiq.xml");
        // 2.招聘施工队
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3.构建会话工厂
        SqlSessionFactory factory = builder.build(in);
        // 4.创建会话
        session = factory.openSession();
    }

    @After
    public void release() throws Exception {
        // 默认情况下mybatis的是始终打开的，但是并不会自动提交，所有在我们做增删改操作时，如果没有手动commit，那么会自动回滚数据
        session.commit();
        session.close();
        in.close();

    }


        @Test//查询所有
        public  void getuser() throws Exception {

              // 5.通过会话对象得到dao层的代理对象
              UserDao mapper = session.getMapper(UserDao.class);
            // 代理对象：org.apache.ibatis.binding.MapperProxy@369f73a2
               // System.out.println(mapper);
              // 6.执行sql语句
                    List<Userti> list = mapper.getuser();
                    for (Userti userti : list) {
                        System.out.println(userti);
                    }

        }
          @Test//添加信息
        public  void adduser()  {

              // 5.通过会话对象得到dao层的代理对象
              UserDao mapper = session.getMapper(UserDao.class);
              // 6.执行sql语句
                Userti user=new Userti();
                user.setUsername("wsl");
                user.setPassword("123");
                user.setNicheng("邬大爷");
                user.setType(2);
              //System.out.println("1---"+user);
              mapper.adduser(user);
             // System.out.println("2---"+user);
              // mysql自增主键返回  获取主键值  SELECT LAST_INSERT_ID()
              Integer id = user.getId();
              System.out.println(id);
          }

          @Test//添加信息
        public  void updateuser()  {

              // 5.通过会话对象得到dao层的代理对象
              UserDao mapper = session.getMapper(UserDao.class);
              // 6.执行sql语句
                Userti user=new Userti();
                user.setId(2);
                user.setUsername("wsl");
                user.setPassword("123");
                user.setNicheng("邬二爷");
                user.setType(0);
                mapper.updateuser(user);
        }
          @Test//删除信息
        public  void deleteuser()  {
              // 5.通过会话对象得到dao层的代理对象
              UserDao mapper = session.getMapper(UserDao.class);
              // 6.执行sql语句
              mapper.deleteuser(3);
        }

          @Test//根据用户名查找信息
        public  void getIdMyuser()  {
              // 5.通过会话对象得到dao层的代理对象
              UserDao mapper = session.getMapper(UserDao.class);
              // 6.执行sql语句
              Userti user=new Userti();
              user.setNicheng("%邬%");
              List<Userti> list = mapper.getIdMyuser(user);
              for (Userti userti : list) {
                  System.out.println(userti);
              }
          }

    @Test//根据值对象来封装数据
    public  void addcar() {

        // 5.通过会话对象得到dao层的代理对象
        UserDao mapper = session.getMapper(UserDao.class);
        // 代理对象：org.apache.ibatis.binding.MapperProxy@369f73a2
        // 6.执行sql语句
        Userti userti=new Userti();
        userti.setUsername("xiaoque");
        userti.setPassword("888");
        userti.setType(0);
        userti.setNicheng("大雀雀");
        Car c=new Car();
        c.setUserti(userti);
        mapper.addcar(c);
    }

}
