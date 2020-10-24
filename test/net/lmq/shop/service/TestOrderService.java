package net.lmq.shop.service;

import net.lmq.shop.bean.Order;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TestOrderService {
    @Test
    public void testAddOrder(){
        //创建数据访问对象
        OrderService orderService = new OrderService();
        //创建订单对象
        Order order = new Order();
        order.setUsername("lmq");
        order.setTotalPrice(2000);
        order.setTelephone("123123122");
        order.setOrderTime(Timestamp.valueOf(LocalDateTime.now()));
        order.setDeliveryAddress("泸职院");
        //调用
        int count = orderService.addOrder(order);
        if(count >0){
            System.out.println("订单数据插入成功");
        }else{
            System.out.println("抱歉，订单数据插入失败");
        }
    }

    @Test
    public void testDeleteOrderById(){
        //创建数据访问对象
        OrderService orderService = new OrderService();
        //调用
        int id = 1;
        int count = orderService.deleteOrderById(id);
        if (count > 0) {
            System.out.println("删除订单数据成功");
        } else {
            System.out.println("错误，删除订单数据失败");
        }
    }

    @Test
    public void testUpdateOrder(){
        //创建数据访问对象
        OrderService orderService = new OrderService();
        //寻找商品
        Order order = orderService.findOrderById(3);
        order.setTelephone("12345672132");
        order.setTotalPrice(122);
        int count = orderService.updateOrder(order);
        if(count >0){
            System.out.println("更新商品数据成功");
        }else {
            System.out.println("错误，更新商品数据失败");
        }
    }

    @Test
    public void testFindOrderById(){
        //创建数据访问对象
        OrderService orderService = new OrderService();
        //获取全部订单
        Order order = orderService.findOrderById(3);
        if(order != null){
            System.out.println(order);
        }else {
            System.out.println("没有订单");
        }
    }

    @Test
    public void testFindLastOrder(){
        //创建数据访问对象
        OrderService orderService = new OrderService();
        //调用
        List<Order> orders = orderService.findAllOrders();
        if(orders.size() > 0){
            int i = orders.size()-1;
            Order order = orders.get(i);
            System.out.println(order);
        }
    }

    @Test
    public void testFindAllOrders(){
        //创建数据访问对象
        OrderService orderService = new OrderService();
        //获取全部订单
        List<Order> orders = orderService.findAllOrders();
        if(orders.size() >0){
            for(Order order:orders){
                System.out.println(order);
            }
        }else {
            System.out.println("没有订单");
        }
    }

}
