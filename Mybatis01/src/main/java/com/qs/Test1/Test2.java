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
 * 手动配置
 * @author shkstart
 * @create 2019-08-10 14:12
 */
public class Test2 {

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


        @Test//手动查询所有
        public  void getuser() {
         List<Userti> list = session.selectList("com.qs.userdao.UserDao.getuser");
            for (Object userti : list) {
                System.out.println(userti);
            }

        }
          @Test//手动添加信息
        public  void adduser()  {
            Userti user=new Userti();
            user.setUsername("zs");
            user.setPassword("123");
            user.setNicheng("真神");
            user.setType(2);
            session.insert("com.qs.userdao.UserDao.adduser",user);
          }

          @Test//手动修改信息
        public  void updateuser()  {
                Userti user=new Userti();
                user.setId(1);
                user.setUsername("wsl");
                user.setPassword("123");
                user.setNicheng("二爷");
                user.setType(0);
              session.update("com.qs.userdao.UserDao.updateuser",user);

        }
          @Test//手动删除信息
        public  void deleteuser()  {
              session.delete("com.qs.userdao.UserDao.deleteuser",29);
        }

          @Test//手动根据用户名查找信息
        public  void getIdMyuser()  {
              Userti user=new Userti();
              user.setNicheng("%爷%");
              List<Userti> list = session.selectList("com.qs.userdao.UserDao.getIdMyuser", user);
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
        userti.setNicheng("小雀雀");
        Car c=new Car();
        c.setUserti(userti);
        mapper.addcar(c);
    }

}
