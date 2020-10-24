package net.lmq.shop.servlet;

import net.lmq.shop.bean.Order;
import net.lmq.shop.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/makeOrder")
public class MakeOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求对象的字符编码
        request.setCharacterEncoding("utf-8");
        // 获取表单提交数据
        String username = request.getParameter("username");
        String telephone = request.getParameter("telephone");
        Double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        String deliveryAddress = request.getParameter("deliveryAddress");
        // 创建订单对象
        Order order = new Order();
        // 设置订单属性
        order.setUsername(username);
        order.setTotalPrice(totalPrice);
        order.setTelephone(telephone);
        order.setDeliveryAddress(deliveryAddress);
        order.setOrderTime(new Date());
        // 创建订单服务
        OrderService orderService = new OrderService();
        // 添加订单
        orderService.addOrder(order);
        // 获取最后一个订单
        Order lastOrder = orderService.findLastOrder();
        // 保存到session里
        request.getSession().setAttribute("lastOrder", lastOrder);
        // 重定向到显示订单页面
        response.sendRedirect(request.getContextPath() + "/frontend/showOrder.jsp");
        System.out.println(lastOrder);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
