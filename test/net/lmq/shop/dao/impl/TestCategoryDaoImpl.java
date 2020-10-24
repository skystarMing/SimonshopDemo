package net.lmq.shop.dao.impl;
/**
 * 作者：赖明庆
 * 日期：2019.12.4
 */
import net.lmq.shop.bean.Category;
import net.lmq.shop.dao.CategoryDao;
import org.junit.Test;

import java.util.List;

public class TestCategoryDaoImpl {
    @Test
    public void testFindAll(){
        //创建类别数据访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<Category>  categories = categoryDao.findAll();
        //判断是否有类别
        if(!categories.isEmpty() ){
            for(Category category:categories){
                System.out.println(category);
            }
        }else {
            System.out.println("没有商品类别");
        }
    }

    //插入类别
    @Test
    public void testCategoryInsert(){
        //创建数据访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();
        //创建类别信息
        Category category = new Category();
        category.setId(5);
        category.setName("服装");

        int count = categoryDao.insert(category);
        if(count > 0){
            System.out.println("恭喜，插入数据成功");
        }else {
            System.out.println("抱歉，插入数据失败");
        }
    }

    //删除类别
    @Test
    public void testCategoryDeleteByid(){
        //创建类别数据访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();
        //id
        int id = 6;
        //调用
        int count = categoryDao.deleteById(id);
        //判断删除是否成功
        if(count > 0){
            System.out.println("删除成功");
        }else {
            System.out.println("抱歉，删除失败");
        }
    }

    //更新类别
    @Test
    public void testCategoryUpdate(){
        //创建类别数据访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();

        //创建类别对象
        Category category = categoryDao.findById(3);
        category.setName("电子产品");

        //调用
        int count = categoryDao.update(category);
        if(count > 0){
            System.out.println("恭喜，更新数据成功");
        }else {
            System.out.println("抱歉，更新数据失败");
        }
    }

    //按标识符查类别
    @Test
    public void testCategoryFindByid(){
        //创建类别访问对象
        CategoryDao categoryDao = new CategoryDaoImpl();
        int id = 1;
        Category category = categoryDao.findById(id);
        if(category !=null){
            System.out.println(category);
        }else {
            System.out.println("抱歉，没有该类别");
        }
    }
}
