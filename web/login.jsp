<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <base href="${basePath}">
    <script src="styles/scripts/check.js" type="text/javascript"></script>
    <link href="styles/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="login">
    <div class="websiteTitle">
        <h1>西蒙购物网</h1>
    </div>
    <div class="title">
        <h3>用户登录</h3>
    </div>
    <div class="main">
        <form id="frmLogin" action="login" method="post">
            <table>
                <tr>
                    <td align="center">账号</td>
                    <td><input id="username" type="text" name="username"/></td>
                </tr>
                <tr>
                    <td align="center">密码</td>
                    <td><input id="password" type="password" name="password"/></td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="登录" onclick="return checkLoginForm();"/>
                        <input type="reset" value="重置"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div class="footer">
        <p>如果你不是本站用户，单击<a href="frontend/register.jsp">此处</a>注册。</p>
    </div>
</div>

<c:if test="${registerMsg!=null}">
    <script type="text/javascript">alert("${registerMsg}")</script>
    <c:remove var="registerMsg"/>
</c:if>

<c:if test="${loginMsg!=null}">
    <script type="text/javascript">alert("${loginMsg}")</script>
    <c:remove var="loginMsg"/>
</c:if>
</body>
</html>

