<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 3/29/2022
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TIME</title>
    <style type="text/css">
        select {
            width: 200px;
            height:20px;
        }
    </style>
</head>
<body>
<h2>Current local times around the world</h2>
<span>Current Time in ${city} :
    <strong>${date}</strong>
</span>
<form action="world-clock" id="locale">
    <select name="city" onchange="document.getElementById('locale').submit()" >
        <option >Select a city</option>
        <option value="Asia/Ho_Chi_Minh" >Ho Chi Minh</option>
        <option value="Singapore">Singapore</option>
        <option value="Asia/Hong_Kong">Hong Kong</option>
        <option value="Asia/Tokyo">Tokyo</option>
        <option value="Asia/Seoul">Seoul</option>
        <option value="Europe/London">London</option>
        <option value="Europe/Madrid">Madrid</option>
        <option value="America/New_York">New York</option>
        <option value="Australia/Sydney">Sydney</option>
        <option value="Argentina/Buenos_Aires">Buenos Aires</option>
    </select>
</form>
</body>
</html>
