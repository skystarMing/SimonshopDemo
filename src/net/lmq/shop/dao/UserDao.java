/**
 * 功能：用户数据访问接口
 * 作者：赖明庆
 * 日期：2019.12.4
 */
package net.lmq.shop.dao;

import java.util.List;

import net.lmq.shop.bean.User;

public interface UserDao {
    // 插入用户
    int insert(User user);
    // 按标识符删除用户
    int deleteById(int id);
    // 更新用户
    int update(User user);
    // 按标识符查询用户
    User findById(int id);
    // 按用户名查询用户
    List<User> findByUsername(String username);
    // 查询全部用户
    List<User> findAll();
    // 用户登录
    User login(String username, String password);
}