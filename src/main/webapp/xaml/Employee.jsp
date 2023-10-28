<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/28/2023
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action='Employee-servlet' method='POST'>
    <div class="form-group">
        <label for="FullName">Email address</label>
        <input type="text" class="form-control" id="FullName" name="FullName" aria-describedby="emailHelp" placeholder="">
<%--        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
    </div>
    <div class="form-group">
        <label for="Birthday">Birthday</label>
        <input type="date" class="form-control" name="Birthday" id="Birthday" placeholder="Birthday">
    </div>
    <div class="form-group">
        <label for="Addres">Address</label>
        <input type="text" class="form-control" name="Addres" id="Addres" placeholder="Address">
    </div>
    <div class="form-group">
        <label for="Positon">Positon</label>
        <input type="text" class="form-control" name="Positon" id="Positon" placeholder="Positon">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="button" onclick="SetAll()" class="btn btn-danger">Resetdata</button>
</form>
<script>
    var fullname = document.getElementById("FullName");
    var Birthday = document.getElementById("Birthday");
    var Addres = document.getElementById("Addres");
    var Positon = document.getElementById("Positon");
    function SetAll(){
        fullname.value = "";
        Birthday.value="";
        Addres.value ="";
        Positon.value ="";
    }
</script>
</body>
</html>
