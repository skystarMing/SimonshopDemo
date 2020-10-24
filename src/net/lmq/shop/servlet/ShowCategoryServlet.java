package net.lmq.shop.servlet;

import net.lmq.shop.bean.Category;
import net.lmq.shop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/showCategory")
public class ShowCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建商品类别服务对象
        CategoryService categoryService = new CategoryService();
        //获取全部商品类别
        List<Category> categories = categoryService.findAllCategories();
        //获得session
        HttpSession session = request.getSession();
        //将商品类别放到session里
        session.setAttribute("categories",categories);
        //重定向跳转到显示商品类别显示页面
        response.sendRedirect(request.getContextPath()+"/frontend/showCategory.jsp");
        //在控制台输出测试信息
        for(Category category:categories){
            System.out.println(category);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
