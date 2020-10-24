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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet("/showCart")
public class ShowCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品类别标识符
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        //获取session对象
        HttpSession session = request.getSession();
        //获取购物车
        LinkedHashMap<Integer,Integer> cart = (LinkedHashMap<Integer, Integer>) session.getAttribute("cart");

        //判断购物车是否为空
        if(cart != null){
            //定义购物表
            List<HashMap<String,Object>> shoppingTable = new ArrayList<HashMap<String,Object>>();
            //创建商品服务对象
            ProductService productService = new ProductService();
            //购物总金额
            double totalPrice = 0.0;
            //遍历购物车
            for(Integer id:cart.keySet()){//这个id是什么
                //获取商品对象
                Product product = productService.findProductById(id);
                //生成购物表记录
                HashMap<String,Object> shoppingItem = new HashMap<String, Object>();
                shoppingItem.put("id",product.getId());
                shoppingItem.put("name",product.getName());
                shoppingItem.put("price",product.getPrice());
                shoppingItem.put("amount",cart.get(id));
                shoppingItem.put("sum",product.getPrice()*cart.get(id));
                //将购物表记录添加到购物表中
                shoppingTable.add(shoppingItem);
                //累加购买金额
                totalPrice = totalPrice + (Double) shoppingItem.get("sum");
            }
            //将购物表和购物总金额保存到session里
            session.setAttribute("shoppingTable",shoppingTable);
            session.setAttribute("totalPrice",totalPrice);

            //重定向跳转
            response.sendRedirect(request.getContextPath()+"/showProduct?categoryId="+categoryId);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
