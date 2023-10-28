<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/28/2023
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<a href='/demo/Employee-servlet'>Add new Customer</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">FullName</th>
        <th scope="col">Birthday</th>
        <th scope="col">Addres</th>
        <th scope="col">Positon</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${ListEmployee}">
        <tr>
            <td><c:out value="${item.getId()}" /></td>
            <td><c:out value="${item.getFullName()}" /></td>
            <td><c:out value="${item.getBirthday()}" /></td>
            <td><c:out value="${item.getAddres()}" /></td>
            <td><c:out value="${item.getPositon()}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
