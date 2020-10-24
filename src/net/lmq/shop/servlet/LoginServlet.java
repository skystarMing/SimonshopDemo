package net.lmq.shop.servlet;

import net.lmq.shop.bean.User;
import net.lmq.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求对象的编码
        request.setCharacterEncoding("utf-8");
        //获取会话对象session
        HttpSession session = request.getSession();
        //得到用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //定义用户服务对象
        UserService userService = new UserService();
        //执行登录方法，返回结果
        User user = userService.login(username,password);
        //判断用户是否登录成功
        if(user != null){
            //设置session属性
            session.setMaxInactiveInterval(5*60);
            session.setAttribute("username",username);
            session.removeAttribute("loginMsg");
            if(user.getPopedom() == 0){
                System.out.println("用户登录成功，进入后台管理");
                response.sendRedirect(request.getContextPath()+"/backend/management.jsp");
            }else if(user.getPopedom() == 1){
                System.out.println("用户登录成功，进入前台显示类别");
                response.sendRedirect(request.getContextPath()+"/showCategory");
            }
        }else{
            System.out.println("用户名或密码错误，请重新登录");
            session.setAttribute("loginMsg","用户名或密码错误");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
