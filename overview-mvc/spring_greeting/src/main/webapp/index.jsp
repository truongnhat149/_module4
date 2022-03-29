<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 3/28/2022
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
<%--<h1>Hello Wolrd</h1>--%>
<%--<h1>Hello: ${hello}</h1>--%>
<form action="/result">
    <label >Enter your word</label> <br>
    <input type="text" name="hello" required>
    <button type="submit" value="Result">Result</button>
</form>
</body>
</html>
