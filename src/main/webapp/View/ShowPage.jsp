<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Entities.CustomerEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/17/2023
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .button {
            border: none;
            /*color: white;*/
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
    <title>Title</title>
</head>
<body>
<a href='/demo/AddNewCusTomer-servlet'>Add new Customer</a>
<table>
    <tr>
       <th>CusID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Address</th>
        <th>Birthday</th>
        <th>Gender</th>
    </tr>
<%--    for ( int i = 0; i <Listuuu.size(); i++){ %>--%>
<%--   <tr>--%>
<%--        <td><%=Listuuu.get(i).getCusId()%></td>--%>
<%--        <td><%=Listuuu.get(i).getFirstName()%></td>--%>
<%--        <td><%=Listuuu.get(i).getLastName()%></td>--%>
<%--        <td><%=Listuuu.get(i).getAddress()%></td>--%>
<%--        <td><%=Listuuu.get(i).getBirthday()%></td>--%>
<%--        <td><%=Listuuu.get(i).getGender()%></td>--%>
<%--        <td><button onclick="" type="button">Delete Me!</button></td>--%>
<%--    </tr>--%>
<%--<%}%>--%>
<%--        <jsp:useBean id="Listuuu" scope="request" type="java.util.List"/>--%>
        <c:forEach var="item" items="${List}">
            <tr>
                <td><c:out value="${item.getCusId()}" /></td>
                <td><c:out value="${item.getFirstName()}" /></td>
                <td><c:out value="${item.getLastName()}" /></td>
                <td><c:out value="${item.getAddress()}" /></td>
                <td><c:out value="${item.getBirthday()}" /></td>
                <td>
                    <c:if test="${item.getGender() == false}">
                        <c:out value="Female" />
                    </c:if>
                    <c:if test="${item.getGender() == true}">
                        <c:out value="male" />
                    </c:if>
                </td>
                <td><a href="/demo/DeleteCustomerServlet?sid=${item.getCusId()}">Delete Me!</a></td>
            </tr>
        </c:forEach>
</table>
<div>
    <c:choose>
        <c:when test="${CountPage > 1}">
            <a href="pagingServlet?idpage=${CountPage-1}">Trang trước</a>
        </c:when>
        <c:otherwise>
            Trang trước
        </c:otherwise>
    </c:choose>

    <c:out value="${CountPage}"/>

    <c:choose>
        <c:when test="${CountPage < 2}">
            <a href="pagingServlet?page=${page+1}">Trang sau</a>
        </c:when>
        <c:otherwise>
            Trang sau
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
