/**
 * 功能：生成订单控制程序
 * 作者：赖明庆
 * 日期：2019.12.18
 */
package net.lmq.shop.servlet;

import net.lmq.shop.bean.User;
import net.lmq.shop.service.UserService;
import org.omg.PortableInterceptor.INACTIVE;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showUser")
public class ShowUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建用户服务对象
        UserService userService = new UserService();
        //获取全部用户
        List<User> users = userService.findAllUsers();

        //总页数
        int totalPage = users.size() % 5 ==0 ? users.size()/5 :users.size()/5 +1;
        //得到当前页数
        int pageIndex =request.getParameter("pageIndex") == null? 1: Integer.parseInt(request.getParameter("pageIndex"));
        //限制首页和末页
        if(pageIndex <1){
            pageIndex = 1;
        }else if(pageIndex > totalPage){
            pageIndex = totalPage;
        }

        //创建放用户的新列表
        List<User> users1 = new ArrayList<>();
        //得到页面要显示的用户
        for(int  i = (pageIndex -1)*5;i<pageIndex*5;i++){
            if(i<users.size()){
                users1.add(users.get(i));
            }
        }

        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("users",users1);
        //重定向到显示用户页面
        response.sendRedirect(request.getContextPath()+"/backend/showUser.jsp?pageIndex="+pageIndex+"&totalPage="+totalPage);
        for(User user:users){
            System.out.println(user);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
