<%@ page import="net.lmq.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="net.lmq.dao.CategoryDao" %>
<%@ page import="net.lmq.dao.impl.CategoryDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 明明明
  Date: 2019/11/16
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<h3>显示商品类别信息</h3>
<%
    CategoryDao categoryDao = new CategoryDaoImpl();
    List<Category> categories = categoryDao.findAll();
    for(Category category:categories){
        out.print(category.getId());
        out.print(category.getName());
    }
%>
</body>
</html>
