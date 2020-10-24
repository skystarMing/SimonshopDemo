package net.lmq.shop.dao.impl;
/**
 * 作者：赖明庆
 * 日期：2019.12.4
 */
import net.lmq.shop.bean.Product;
import net.lmq.shop.dao.CategoryDao;
import net.lmq.shop.dao.ProductDao;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TestProductDaoImpl {
    @Test
    public void testFindByCategoryId(){
        //创建商品数据访问对象
        ProductDao productDao = new ProductDaoImpl();
        //定义商品类别编号
        int categoryId = 3;
        //创建类别数据访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();
        //判断类别是否存在
        if(categoryDao.findById(categoryId) != null){
            //获取该类别全部商品
            List<Product> products = productDao.findByCategoryId(categoryId);
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

    //插入商品
    @Test
    public void testProduceInsert(){
        //创建商品数据访问对象
        ProductDao productDao = new ProductDaoImpl();
        //创建商品对象
        Product product = new Product();
        product.setName("计算机");
        product.setPrice(112);
        product.setAddTime(Timestamp.valueOf(LocalDateTime.now()));
        product.setCategoryId(7);
        //调用
        int count = productDao.insert(product);
        if(count >0){
            System.out.println("恭喜，插入商品数据成功");
        }else {
            System.out.println("抱歉，插入商品数据失败");
        }
    }

    //通过id删除商品
    @Test
    public void testProduceDeleteByid(){
        //创建商品数据访问对象
        ProductDao productDao = new ProductDaoImpl();

        //调用
        int id = 1;
        int count = productDao.deleteById(id);
        if(count >0){
            System.out.println("删除商品数据成功");
        }else {
            System.out.println("错误，删除商品数据失败");
        }
    }

    //更新商品数据
    @Test
    public void testUpdate(){
        //创建商品数据访问对象
        ProductDao productDao = new ProductDaoImpl();
        //寻找商品
        Product product = productDao.findById(3);
        product.setPrice(4567);
        int count = productDao.update(product);
        if(count >0){
            System.out.println("更新商品数据成功");
        }else {
            System.out.println("错误，更新商品数据失败");
        }
    }

    //通过id查找商品
    @Test
    public void testFindByid(){
        //创建商品数据访问对象
        ProductDao productDao = new ProductDaoImpl();
        //调用
        int id = 4;
        Product product = productDao.findById(id);
        if(product != null){
            System.out.println(product);
        }else {
            System.out.println("没有该商品");
        }
    }

    //查询全部商品
    @Test
    public void testFindAll(){
        //创建商品数据访问对象
        ProductDao productDao = new ProductDaoImpl();
        //调用
        List<Product> products = productDao.findAll();
        if(!products.isEmpty()){
            for(Product product:products){
                System.out.println(product);
            }
        }else {
            System.out.println("抱歉，没有商品");
        }
    }

}
