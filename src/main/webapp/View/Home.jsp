<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/15/2023
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action='AddNewCusTomer-servlet' method='POST'>
    <label>First name:</label><br>
    <input type='text' name='FirstName'/>
    <br><label>Last Name:</label><br>
    <input type='text' name='LastName'/>
    <br><label>Address:</label><br>
    <input type='text' name='Address'/>
    <br><label>Birthday:</label><br>
    <input type='date' name='Birthday'/>
    <br><label>Select Gender:</label><br>
    <select name='Gender' id="cars">
        <option value="1">Nam</option>
        <option value="0">Nữ</option>
    </select> /><br>
    <input type='submit' value='Submit'/>
</form>
</body>
</html>
