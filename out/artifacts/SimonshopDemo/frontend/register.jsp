<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>用户注册</title>
    <base href="${basePath}">
    <script src="styles/scripts/check.js" type="text/javascript"></script>
    <link href="styles/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="register">
    <div class="websiteTitle">
        <h1>西蒙购物</h1>
    </div>
    <div class="title">
        <h3>用户注册</h3>
    </div>
    <div class="main">
        <form action="register" method="post">
            <table>
                <tr>
                    <td>账号</td>
                    <td><input id="username" type="text" name="username"/> </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input id="password" type="password" name="password"/> </td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td><input id="telephone" type="text" name="telephone"/> </td>
                </tr>
                <tr>
                    <td colspan="2">
                       <input type="submit" value="注册" onclick="return checkRegisterForm();"/>
                        <input type="reset" value="重置"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<c:if test="${registerMsg!=null}">
    <script type="text/javascript">alert("${registerMsg}")</script>
    <c:set var="registerMsg" value=""/>
</c:if>
</body>
</html>
