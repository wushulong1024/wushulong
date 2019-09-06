package com.qs.userdao;

import com.qs.entity.Car;
import com.qs.entity.Userti;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-08-10 13:50
 */
public interface UserDao {
    /**
     * 查询所有信息
     */
    List<Userti> getuser();

    /**
     * 添加信息
     */
     void adduser(Userti user);

    /**
     * 修改信息
     */
    void updateuser(Userti user);

    /**
     * 删除信息
     */
    void deleteuser(Integer id);

    /**
     * 根据用户名查找信息
     */
    List<Userti> getIdMyuser(Userti user);

    /*
        通过查询条件插入数据
        QueryVO   查询的值对象
        查询
        VO：value object 说明当前对象所在的类，没有对应的表
    */
    void addcar(Car c);
}
