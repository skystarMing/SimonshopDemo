package net.lmq.shop.service;

/**
 * 功能：用户服务类
 * 作者：赖明庆
 * 日期：2019.12.4
 */

import java.util.List;

import net.lmq.shop.bean.User;
import net.lmq.shop.dao.UserDao;
import net.lmq.shop.dao.impl.UserDaoImpl;

public class UserService {
    /**
     * 声明用户访问对象
     */
    private UserDao userDao = new UserDaoImpl();

    public int addUser(User user) {
        return userDao.insert(user);
    }

    public int deleteUserById(int id) {
        return userDao.deleteById(id);
    }

    public int updateUser(User user) {
        return userDao.update(user);
    }

    public User findUserById(int id) {
        return userDao.findById(id);
    }

    public List<User> findUsersByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User login(String username, String password) {

        return userDao.login(username, password);
    }
}