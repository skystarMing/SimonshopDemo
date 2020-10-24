package net.lmq.shop.service;

/**
 * 功能：订单服务类
 * 作者：赖明庆
 * 日期：2019.12.4
 */

import java.util.List;

import net.lmq.shop.bean.Order;
import net.lmq.shop.dao.OrderDao;
import net.lmq.shop.dao.impl.OrderDaoImpl;

public class OrderService {
    /**
     * 声明订单数据访问对象
     */
    OrderDao orderDao = new OrderDaoImpl();

    public int addOrder(Order order) {
        return orderDao.insert(order);
    }

    public int deleteOrderById(int id) {
        return orderDao.deleteById(id);
    }

    public int updateOrder(Order order) {
        return orderDao.update(order);
    }

    public Order findOrderById(int id) {
        return orderDao.findById(id);
    }

    public Order findLastOrder() {
        return orderDao.findLast();
    }

    public List<Order> findAllOrders() {
        return orderDao.findAll();
    }
}