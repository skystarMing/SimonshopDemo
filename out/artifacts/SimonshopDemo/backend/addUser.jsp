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
    <script src="styles/scripts/check.js" type="text/javascript"></script>
</head>
<body>
<hr>
<table width="90%" border="0px">
    <tr>
        <td align="left">登录用户：<span style="color: red;">${username}</span></td>
        <td align="right"><a href="logout" target="_parent">注销</a></td>
    </tr>
</table>
<form action="addUser" method="post">
    <table>
        <tr>
            <td>用户名</td>
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
            <td>权限（1/0）</td>
            <td><input id="popedom" type="text" name="popedom"></td>

        </tr>
        <tr>
            <td colspan="2">
                <input id="tj" type="submit" value="添加" onclick="return checkRegisterForm();"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
<script>
    document.getElementById("tj").onclick = function () {
        var popedom = document.getElementById("popedom");
        if (popedom.value == "") {
            alert("权限不能为空！");
            password.focus();
            return false;
        }
        switch (popedom.value) {
            case "1":
                return true;
                break;
            case "0":
                return true;
                break;
            default:
                alert("1：普通用户，0：管理员权限，其他不可以");
                popedom.focus();
                return false;
        }
    }
</script>


<c:if test="${registerMsg!=null}">
    <script type="text/javascript">alert("${registerMsg}")</script>
    <c:set var="registerMsg" value=""/>
</c:if>
</body>
</html>
