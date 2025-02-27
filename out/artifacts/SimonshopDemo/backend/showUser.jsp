<%@ page import="java.util.List" %>
<%@ page import="net.lmq.shop.bean.User" %>
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
<table border="1" width="90%" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>电话</th>
        <th>注册时间</th>
        <th>权限</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr align="center">
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.telephone}</td>
            <td><fmt:formatDate value="${user.registerTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            <td>
                <c:choose>
                    <c:when test="${user.popedom==0}">
                        管理员
                    </c:when>
                    <c:otherwise>
                        普通用户
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

<%--//实现分页操作【首页、上一页、下一页、末页--%>
<p style="text-align: center">
    <a href="showUser?pageIndex=1">[首页]</a>&nbsp;&nbsp;
    <a href="showUser?pageIndex=<%= Integer.parseInt(request.getParameter("pageIndex"))-1%>">[上一页]</a>&nbsp;&nbsp;
    <a href="showUser?pageIndex=<%= Integer.parseInt(request.getParameter("pageIndex"))+1%>">[下一页]</a>&nbsp;&nbsp;
    <a href="showUser?pageIndex=<%= Integer.parseInt(request.getParameter("totalPage"))%>">[末页]</a>&nbsp;&nbsp;
    <%=request.getParameter("pageIndex")%>/ <%=request.getParameter("totalPage")%>
</p>
<hr>

</body>
</html>
