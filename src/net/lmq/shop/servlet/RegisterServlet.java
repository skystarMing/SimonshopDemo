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
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求对象的编码
        request.setCharacterEncoding("utf-8");
        //获取session
        HttpSession session = request.getSession();

        //获取页面用户信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        Timestamp registerTime = new Timestamp(System.currentTimeMillis());
        //设置为普通用户
        int popedom = 1;

        //创建用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setTelephone(telephone);
        user.setRegisterTime(registerTime);
        user.setPopedom(popedom);

        //创建用户服务对象
        UserService userService = new UserService();
        List<User> coun = userService.findUsersByUsername(username);
        //判断用户是否已存在
        if(coun.size() > 0 ){
            System.out.println("已经有此用户"+coun);
            //设置session
            session.setAttribute("registerMsg","抱歉，用户注册失败");
            //重定向跳转注册页面
            response.sendRedirect(request.getContextPath()+"/frontend/register.jsp");
            //控制台输出
            System.out.println("用户已存在，注册失败，跳转到注册页面");
        }else {
            //调用添加用户方法
            int count = userService.addUser(user);
            //判断是否注册成功
            if(count > 0){
                //设置session
                session.setAttribute("registerMsg","恭喜注册成功");
                //重定向跳转
                response.sendRedirect(request.getContextPath()+"/login.jsp");
                //控制台输出
                System.out.println("恭喜，用户注册成功，跳转到登录页面");
            }else {
                //设置session
                session.setAttribute("registerMsg","抱歉，用户注册失败");
                //重定向跳转注册页面
                response.sendRedirect(request.getContextPath()+"/frontend/register.jsp");
                //控制台输出
                System.out.println("抱歉，用户注册失败，跳转到注册页面");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
