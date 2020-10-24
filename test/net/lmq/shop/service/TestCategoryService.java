package net.lmq.shop.service;

        import net.lmq.shop.bean.Category;
        import org.junit.Test;

        import java.util.ArrayList;
        import java.util.List;

public class TestCategoryService {
    @Test
    public void testAddCategory(){
        //创建数据访问对象
        CategoryService categoryService = new CategoryService();
        //创建类别对象
        String name = "书籍类别";
        Category category = new Category();
        category.setName(name);
        List<String> categName = new ArrayList<>();
        //得到类别列表，将每个类别的名称拿出来放到一个列表，判断
        List<Category> categories = categoryService.findAllCategories();
        for(Category category1:categories){
            categName.add(category1.getName());
        }
        if (categName.contains(name)) {
            System.out.println("抱歉，该类别已经存在");
        }else {
            int count = categoryService.addCategory(category);
            if(count > 0){
                System.out.println("恭喜，插入数据成功");
            }else{
                System.out.println("抱歉，插入数据失败");
            }
        }
    }

    @Test
    public void testUpdateCategory(){
        //创建数据访问对象
        CategoryService categoryService = new CategoryService();
        //创建类别对象
        Category category = categoryService.findCategoryById(3);
        category.setName("电子产品");

        //调用
        int count = categoryService.updateCategory(category);
        if(count > 0){
            System.out.println("恭喜，更新数据成功");
        }else {
            System.out.println("抱歉，更新数据失败");
        }

    }

    @Test
    public void testdeleteCategoryById(){
        //创建数据访问对象
        CategoryService categoryService = new CategoryService();
        int id = 3;
        int count = categoryService.deleteCategoryById(id);
        if(count > 0){
            System.out.println("恭喜数据删除成功");
        }else{
            System.out.println("抱歉数据删除失败");
        }
    }

    @Test
    public void testFindCategoryById(){
        //创建数据访问对象
        CategoryService categoryService = new CategoryService();
        int id = 1;
        Category category = categoryService.findCategoryById(id);
        if(category !=null){
            System.out.println(category);
        }else {
            System.out.println("抱歉，没有该类别");
        }
    }

    @Test
    public void testFindAllCategories(){
        //创建数据访问对象
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.findAllCategories();
        //判断是否有类别
        if(!categories.isEmpty() ){
            for(Category category:categories){
                System.out.println(category);
            }
        }else {
            System.out.println("没有商品类别");
        }
    }



}
