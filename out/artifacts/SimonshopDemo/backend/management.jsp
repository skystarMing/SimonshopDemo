<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="basePath"
       value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${path}/"/>
<!DOCTYPE html>
<html>
<head>
    <title>西蒙购物网站后台管理</title>
    <base href="${basePath}">
</head>
<frameset rows="30%,70%" cols="*">
    <frame src="backend/top.jsp" name="top_frame" scrolling="no">
    <frameset rows="*" cols="25%,75%">
        <frame src="backend/left.jsp" name="left_frame" scrolling="yes">
        <frame src="backend/main.jsp" name="main_frame" scrolling="yes">
    </frameset>
</frameset>
</html>
