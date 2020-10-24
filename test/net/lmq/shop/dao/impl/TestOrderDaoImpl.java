package net.lmq.shop.dao.impl;
/**
 * 作者：赖明庆
 * 日期：2019.12.4
 */
import net.lmq.shop.bean.Order;
import net.lmq.shop.dao.OrderDao;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TestOrderDaoImpl {
    @Test
    public void testFindAll(){
        //创建订单数据访问对象
        OrderDao orderDao = new OrderDaoImpl();
        //获取全部订单
        List<Order> orders = orderDao.findAll();
        if(orders.size() >0){
            for(Order order:orders){
                System.out.println(order);
            }
        }else {
            System.out.println("没有订单");
        }
    }

    //插入订单
    @Test
    public void testInsert(){
        //创建订单数据访问对象
        OrderDao orderDao = new OrderDaoImpl();
        //创建订单对象
        Order order = new Order();
        order.setUsername("lmq");
        order.setTotalPrice(2000);
        order.setTelephone("123123122");
        order.setOrderTime(Timestamp.valueOf(LocalDateTime.now()));
        order.setDeliveryAddress("泸职院");
        //调用
        int count = orderDao.insert(order);
        if(count >0){
            System.out.println("订单数据插入成功");
        }else{
            System.out.println("抱歉，订单数据插入失败");
        }
    }

    //删除
    @Test
    public void testDeleteByid() {
        //创建商品数据访问对象
        OrderDao order = new OrderDaoImpl();

        //调用
        int id = 1;
        int count = order.deleteById(id);
        if (count > 0) {
            System.out.println("删除订单数据成功");
        } else {
            System.out.println("错误，删除订单数据失败");
        }
    }

    //更新商品数据
    @Test
    public void testUpdate(){
        //创建商品数据访问对象
        OrderDao orderDao = new OrderDaoImpl();
        //寻找商品
        Order order = orderDao.findById(3);
        order.setTelephone("12345672132");
        order.setTotalPrice(122);
        int count = orderDao.update(order);
        if(count >0){
            System.out.println("更新商品数据成功");
        }else {
            System.out.println("错误，更新商品数据失败");
        }
    }

    //查询最后一个订单
    @Test
    public void testListOrder(){
        //创建商品数据访问对象
        OrderDao orderDao = new OrderDaoImpl();
        //获取全部订单
        List<Order> orders = orderDao.findAll();
        if(orders.size() >0){
            for(Order order:orders){
                System.out.println(order);
            }
        }else {
            System.out.println("没有订单");
        }

    }
}


