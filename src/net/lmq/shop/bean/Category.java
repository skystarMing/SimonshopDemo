/**
 * 功能：商品类别实体类
 * 作者：赖明庆
 * 日期：2019.12.4
 */
package net.lmq.shop.bean;

public class Category {
    /**
     * 类别标识符
     */
    private int id;
    /**
     * 类别名称
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}