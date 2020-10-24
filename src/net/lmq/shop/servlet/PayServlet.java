/**
 * 功能：生成订单控制程序
 * 作者：赖明庆
 * 日期：2019.12.18
 */
package net.lmq.shop.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求对象的字符编码
        request.setCharacterEncoding("utf-8");
        //待做

        //让session失效
        request.getSession().invalidate();
        //重定向到登录页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
