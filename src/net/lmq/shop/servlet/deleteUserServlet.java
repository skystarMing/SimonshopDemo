package net.lmq.shop.servlet;

import net.lmq.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class deleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //得到用户编号
        int id = Integer.parseInt(request.getParameter("id"));
        //创建用户服务对象
        UserService userService= new UserService();
        int count =userService.deleteUserById(id);
        if(count>0){
            //重定向跳转
            response.sendRedirect(request.getContextPath()+"/backend/deteleUser.jsp");
        }else {
            response.sendRedirect(request.getContextPath()+"/backend/deteleUser.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
