package net.lmq.shop.service;

import net.lmq.shop.bean.Product;
import net.lmq.shop.dao.CategoryDao;
import net.lmq.shop.dao.impl.CategoryDaoImpl;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestProderService {
    @Test
    public void testAddProduct(){
        //创建数据访问对象
        ProductService productService = new ProductService();
        //创建商品对象
        String name = "计算机";
        Product product = new Product();
        product.setName(name);
        product.setPrice(112);
        product.setAddTime(Timestamp.valueOf(LocalDateTime.now()));
        product.setCategoryId(7);
        List<String> proName = new ArrayList<>();
        List<Product> products = productService.findAllProducts();
        for(Product product1: products){
            proName.add(product1.getName());
        }
        if(proName.contains(name)){
            System.out.println("该商品已经存在");
        }else{
            //调用
            int count = productService.addProduct(product);
            if(count >0){
                System.out.println("恭喜，插入商品数据成功");
            }else {
                System.out.println("抱歉，插入商品数据失败");
            }
        }
    }

    @Test
    public void testDeleteProductById(){
        //创建数据访问对象
        ProductService productService = new ProductService();
        //调用
        int id = 12;
        int count = productService.deleteProductById(id);
        if(count >0){
            System.out.println("删除商品数据成功");
        }else {
            System.out.println("错误，删除商品数据失败");
        }
    }

    @Test
    public void testUpdateProduct(){
        //创建数据访问对象
        ProductService productService = new ProductService();
        //寻找商品
        Product product = productService.findProductById(3);
        product.setPrice(4567);
        int count = productService.updateProduct(product);
        if(count >0){
            System.out.println("更新商品数据成功");
        }else {
            System.out.println("错误，更新商品数据失败");
        }
    }

    @Test
    public void testFindProductById(){
        //创建数据访问对象
        ProductService productService = new ProductService();
        //调用
        int id = 4;
        Product product = productService.findProductById(id);
        if(product != null){
            System.out.println(product);
        }else {
            System.out.println("没有该商品");
        }
    }

    @Test
    public void testFindProductsByCategoryId(){
        //创建数据访问对象
        ProductService productService = new ProductService();
        //定义商品类别编号
        int categoryId = 4;
        //创建类别数据访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();
        //判断类别是否存在
        if(categoryDao.findById(categoryId) != null){
            //获取该类别全部商品
            List<Product> products = productService.findProductsByCategoryId(categoryId);
            //判断商品是否存在
            if(!products.isEmpty()){
                for(Product product:products){
                    System.out.println(product);
                }
            }else {
                String cattegoryName = categoryDao.findById(categoryId).getName();
                System.out.println(cattegoryName+"类别没有商品");
            }
        }else {
            System.out.println("类别编号"+categoryId +"不存在");
        }
    }

    @Test
    public void testFindAllProducts(){
        //创建数据访问对象
        ProductService productService = new ProductService();
        //调用
        List<Product> products = productService.findAllProducts();
        if(!products.isEmpty()){
            for(Product product:products){
                System.out.println(product);
            }
        }else {
            System.out.println("抱歉，没有商品");
        }
    }


}
