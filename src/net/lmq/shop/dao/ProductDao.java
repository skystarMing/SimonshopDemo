/**
 * 功能：商品数据访问接口
 * 作者：赖明庆
 * 日期：2019.12.4
 */
package net.lmq.shop.dao;

import java.util.List;

import net.lmq.shop.bean.Product;

public interface ProductDao {
    // 插入商品
    int insert(Product product);
    // 按标识符删除商品
    int deleteById(int id);
    // 更新商品
    int update(Product product);
    // 按标识符查询商品
    Product findById(int id);
    // 按类别查询商品
    List<Product> findByCategoryId(int categoryId);
    // 查询全部商品
    List<Product> findAll();
}