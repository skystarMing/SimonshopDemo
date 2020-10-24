package net.lmq.shop.servlet;

import net.lmq.shop.bean.Product;
import net.lmq.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;

@WebServlet("/operateCart")
public class OperateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品标识符
        int id = Integer.parseInt(request.getParameter("id"));
        //获取商品操作
        String operation = request.getParameter("operation");
        //获取session
        HttpSession session = request.getSession();

        //从session里获取购物车（键：商品标识符，值：购买数量）
        LinkedHashMap<Integer,Integer> cart = (LinkedHashMap<Integer, Integer>) session.getAttribute("cart");
        //判断购物车是否为空
        if(cart == null){
            //创建购物车
            cart = new LinkedHashMap<Integer, Integer>();
            //将购物车保存到session里，便于在不同页面访问购物车
            session.setAttribute("cart",cart);
        }
        if(operation.equals("add")){
            //将商品添加到购物车
            if(cart.containsValue(id)){//该商品已经购买过
                //购买数量增加1
                cart.put(id,cart.get(id)+1);
            }else {
                cart.put(id,1);
            }
        }else if(operation.equals("delete")){
            //将商品从购物车删除
            if(cart.get(id)>1){
                cart.put(id,cart.get(id)-1);
            }else {
                cart.remove(id);
            }
        }

        //创建商品服务对象
        ProductService productService = new ProductService();
        //获取该商品标识符
        int categoryId = productService.findProductById(id).getCategoryId();
        //重定向到显示购物车控制程序
        response.sendRedirect(request.getContextPath()+"/showCart?categoryId="+categoryId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
