<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>商品显示信息</title>
    <base href="${basePath}">
    <link href="styles/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>西蒙购物</h1>
<hr width="700px"/>
登录用户;<span style="color:red">${username}</span>
<c:forEach var="i" begin="1" end="5">
</c:forEach>
<a href="login">注销</a>
<hr width="700px"/>
欢迎选购【<span style="color:blue;;font-weight: bold;">${categoryName}</span>  】
<table border="0">
    <c:forEach varStatus="status" var="product" items="${products}">
        <c:if test="${status.count%5==0}">
            <tr>
        </c:if>
        <td>
            <table border="0">
                <tr><img src="images/product${product.id}.jpg" width="60px" height="60px"></tr>
                <tr>
                    <td><b>商品编号：</b></td>
                    <td>${product.id}</td>
                </tr>
                <tr>
                    <td><b>商品名称：</b></td>
                    <td>${product.name}</td>
                </tr>
                <tr>
                    <td><b>销售价格：</b></td>
                    <td>${product.price}</td>
                </tr>
                <tr>
                    <td><b>上架时间：</b></td>
                    <td><fmt:formatDate value="${product.addTime}" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td><b>用户操作：</b></td>
                    <td><a href="operateCart?id=${product.id}&operation=add">加入购物车</a></td>
                </tr>
            </table>
        </td>
        <c:if test="${status.count%4==0}">
            </tr>
        </c:if>
    </c:forEach>
</table>
<hr width="700px">
<a href="showCategory">返回商品类别展示页面</a>
<hr width="700px">
<jsp:include page="showCart.jsp"/>
</body>
</html>
