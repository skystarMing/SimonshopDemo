package net.lmq.shop.service;

import net.lmq.shop.bean.User;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 作者：赖明庆
 * 日期：2019.12.4
 */
public class TestUserService {
    @Test
    public void testAddUser(){
        //创建数据访问对象
        UserService userService = new UserService();
        User user = new User();
        String username = "小黑";
        user.setId(9);
        user.setUsername(username);
        user.setPassword("123");
        user.setTelephone("19282737485");
        user.setRegisterTime(Timestamp.valueOf(LocalDateTime.now()));
        user.setPopedom(1);
        List<User> coun = userService.findUsersByUsername(username);
        //判断用户是否已存在
        if(coun.size() > 0 ){
            System.out.println("已经有此用户"+coun);
        }else {
            int count = userService.addUser(user);
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
        UserService userService = new UserService();
        int id = 6;
        //调用
        int count = userService.deleteUserById(id);
        if(count > 0){
            System.out.println("恭喜，用户数据删除成功");
        }else {
            System.out.println("抱歉，用户数据删除失败");
        }
    }

    @Test
    public void testUpdate(){
        //创建数据访问对象
        UserService userService = new UserService();
        //寻找用户
        User user = userService.findUserById(3);
        //修改密码与电话
        user.setPassword("0987");
        user.setTelephone("13928374654");
        int count = userService.updateUser(user);
        if(count > 0){
            System.out.println("恭喜，用户数据修改成功");
        }else {
            System.out.println("抱歉，用户数据修改失败");
        }
        System.out.println(user);
    }

    @Test
    public void testFindUserById(){
        //创建数据访问对象
        UserService userService = new UserService();
        int id = 2;

        //调用
        User count = userService.findUserById(id);
        if(count != null){
            System.out.println("用户信息："+count);
        }else {
            System.out.println("抱歉，没有该用户");
        }
    }

    @Test
    public void testFindUsersByUsername(){
        //创建数据访问对象
        UserService userService = new UserService();
        String username = "赖明庆";

        //调用
        List<User> users = userService.findUsersByUsername(username);
        if(users.size() >0 ){
            System.out.println("用户信息："+ users);
        }else {
            System.out.println("抱歉，没有该用户");
        }
    }

    @Test
    public void testFindAllUsers(){
        //创建数据访问对象
        UserService userService = new UserService();
        //调用
        List<User> users = userService.findAllUsers();
        if(users.size() > 0){
            System.out.println("用户列表：");
            for(User user:users){
                System.out.println(user);
            }
        }else {
            System.out.println("抱歉，程序错误");
        }
    }



    @Test
    public void testlogin(){
        //创建数据访问对象
        UserService userService = new UserService();
        String username = "小黑";
        String password = "123";


        User user = userService.login(username,password);

        //判断
        if(user != null){
            System.out.println("恭喜，登录成功");
        }else {
            System.out.println("抱歉，登录失败");
        }
    }


}
