<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
<%--There are ${requestScope.customers.size()} customer(s) in list.--%>
There are ${customers.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cus" items="${customers}">
        <tr>
            <td>
                <c:out value="${cus.id}"/>
            </td>
            <td>
                <a href="/customers/info.jsp?id=${cus.id}">${cus.name}</a>
            </td>
            <td>
                <c:out value="${cus.email}"/>
            </td>
            <td>
                <c:out value="${cus.address}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
