/**
 * 功能：类别数据访问接口
 * 作者：赖明庆
 * 日期：2019.12.4
 */
package net.lmq.shop.dao;

import java.util.List;

import net.lmq.shop.bean.Category;

public interface CategoryDao {
    // 插入类别
    int insert(Category category);
    // 按标识符删除类别
    int deleteById(int id);
    // 更新类别
    int update(Category category);
    // 按标识符查询类别
    Category findById(int id);
    // 查询全部类别
    List<Category> findAll();
}