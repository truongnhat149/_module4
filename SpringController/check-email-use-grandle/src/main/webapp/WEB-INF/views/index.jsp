<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 3/29/2022
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Validate Email</title>
  </head>
  <body>
 <h3 style="color:red">
     ${message}
 </h3>
 <form action="/validate">
     <label >Type Email HERE</label><br>
     <input type="text" name="email" required><br>
     <button type="submit">SUBMIT</button>
 </form>
  </body>
</html>
