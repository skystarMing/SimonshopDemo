<%@ page import="net.lmq.shop.service.UserService" %>
<%@ page import="net.lmq.shop.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>显示用户信息</title>
    <base href="${basePath}">
    <link href="styles/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<hr>
<table width="90%" border="0px">
    <tr>
        <td align="left">登录用户：<span style="color: red;">${username}</span></td>
        <td align="right"><a href="logout" target="_parent">注销</a></td>
    </tr>
</table>
<hr>
<h3>用户列表</h3>
<hr>
<%
    //创建用户服务对象
    UserService userService = new UserService();
    //获取全部用户
    List<User> users = userService.findAllUsers();

    //总页数
    int totalPage = users.size() % 5 ==0 ? users.size()/5 :users.size()/5 +1;
    //得到当前页数
    int pageIndex =request.getParameter("pageIndex") == null? 1: Integer.parseInt(request.getParameter("pageIndex"));
    //限制首页和末页
    if(pageIndex <1){
        pageIndex = 1;
    }else if(pageIndex > totalPage){
        pageIndex = totalPage;
    }

    //创建放用户的新列表
    List<User> users1 = new ArrayList<>();
    //得到页面要显示的用户
    for(int  i = (pageIndex -1)*5;i<pageIndex*5;i++){
        if(i<users.size()){
            users1.add(users.get(i));
        }
    }

%>
<table border="1" width="90%" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>是否删除</th>
    </tr>
    <c:forEach var="user" items="<%=users1%>">
        <tr align="center">
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><a href="deleteUser?id=${user.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<hr>
<p style="text-align: center">
    <a href="backend/deteleUser.jsp?pageIndex=1">[首页]</a>&nbsp;&nbsp;
    <a href="backend/deteleUser.jsp?pageIndex=<%= pageIndex-1%>">[上一页]</a>&nbsp;&nbsp;
    <a href="backend/deteleUser.jsp?pageIndex=<%= pageIndex+1%>">[下一页]</a>&nbsp;&nbsp;
    <a href="backend/deteleUser.jsp?pageIndex=<%= totalPage%>">[末页]</a>&nbsp;&nbsp;
    <%= pageIndex%>/ <%=totalPage%>
</p>
</body>
</html>
