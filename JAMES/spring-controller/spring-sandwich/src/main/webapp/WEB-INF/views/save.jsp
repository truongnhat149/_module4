<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 3/29/2022
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SANDWICH</title>
</head>
<body>
    <h1>Sandwich</h1>
<c:forEach items="${condiment}" var="condiment">
    <h2>${condiment}</h2>
</c:forEach>
</body>
</html>
