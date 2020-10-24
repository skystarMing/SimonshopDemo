package net.lmq.shop.dao.impl;
/**
 * 作者：赖明庆
 * 日期：2019.12.4
 */
import net.lmq.shop.bean.User;
import net.lmq.shop.dao.UserDao;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TestUserDaoImpl {
    @Test
    public void testLogin(){
        String username,password;
        username = "admin";
        password = "123456";

        //创建数据访问对象
        UserDao userDao=new UserDaoImpl();
        User user = userDao.login(username,password);

        //判断
        if(user != null){
            System.out.println("恭喜，登录成功");
        }else {
            System.out.println("抱歉，登录失败");
        }
    }
    @Test
    public void testUpdate(){
        //创建用户数据访问对象
        UserDao userDao = new UserDaoImpl();

        //寻找用户
        User user = userDao.findById(4);
        //修改密码与电话
        user.setPassword("0987");
        user.setTelephone("13928374654");
        int count = userDao.update(user);
        if(count > 0){
            System.out.println("恭喜，用户数据修改成功");
        }else {
            System.out.println("抱歉，用户数据修改失败");
        }
        System.out.println(user);
    }

    @Test
    public void testiInsert(){
        //创建实例
        UserDao userDao = new UserDaoImpl();

        User user = new User();
        String username = "lmq";
        user.setId(4);
        user.setUsername(username);
        user.setPassword("123");
        user.setTelephone("19282737485");
        user.setRegisterTime(Timestamp.valueOf(LocalDateTime.now()));
        user.setPopedom(1);

        List<User> coun = userDao.findByUsername(username);
        //判断用户是否已存在
        if(coun.size() > 0 ){
            System.out.println("已经有此用户"+coun);
        }else {
            int count = userDao.insert(user);
            //判断插入是否成功
            if(count >0){
                System.out.println("恭喜，用户数据插入成功");
            }else {
                System.out.println("抱歉，用户数据插入失败");
            }
        }
    }

    @Test
    public void testDeleteByid(){
        //创建数据访问对象
        UserDao userDao = new UserDaoImpl();
        int id = 4;

        //调用
        int count = userDao.deleteById(id);
        if(count > 0){
            System.out.println("恭喜，用户数据删除成功");
        }else {
            System.out.println("抱歉，用户数据删除失败");
        }
    }

    @Test
    public void testFindById(){
        //创建数据访问对象
        UserDao userDao = new UserDaoImpl();
        int id = 1;

        //调用
        User count = userDao.findById(id);
        if(count != null){
            System.out.println("用户信息："+count);
        }else {
            System.out.println("抱歉，没有该用户");
        }
    }

    @Test
    public void testFindByname(){
        //创建访问对象
        UserDao userDao = new UserDaoImpl();
        String username = "赖明庆";

        //调用
        List<User> users = userDao.findByUsername(username);
        if(users.size() >0 ){
            System.out.println("用户信息："+ users);
        }else {
            System.out.println("抱歉，没有该用户");
        }
    }

    @Test
    public void testFindAll(){
        //创建访问对象
        UserDao userDao = new UserDaoImpl();

        //调用
        List<User> users = userDao.findAll();
        if(users.size() > 0){
            System.out.println("用户列表：");
            for(User user:users){
                System.out.println(user);
            }
        }else {
            System.out.println("抱歉，程序错误");
        }
    }
}
