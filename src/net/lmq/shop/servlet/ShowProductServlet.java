package net.lmq.shop.servlet;

import net.lmq.shop.bean.Category;
import net.lmq.shop.bean.Product;
import net.lmq.shop.service.CategoryService;
import net.lmq.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/showProduct")
public class ShowProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品类别标识
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        //创建商品类别服务对象
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.findCategoryById(categoryId);
        if(category != null) {
            //由标识得到商品类别名称
            String categoryName = category.getName();
            //创建商品服务对象
            ProductService productService = new ProductService();
            //获取指定商品类别的商品
            List<Product> products = productService.findProductsByCategoryId(categoryId);
            //获取session
            HttpSession session = request.getSession();
            //将商品信息放到session
            session.setAttribute("products", products);
            //商品类别名字放到session里
            session.setAttribute("categoryName",categoryName);
            //重定向到显示商品信息页面
            response.sendRedirect(request.getContextPath() + "/frontend/showProduct.jsp?");

            //在控制台显示商品信息
            for (Product product : products) {
                System.out.println(product);
            }
        }else {
            System.out.println("没有该商品类别");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
