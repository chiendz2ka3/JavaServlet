<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/21/2023
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action='UploadImagServlet-servlet' method='POST' enctype='multipart/form-data'>
    Select Image to Upload:
    <input type="file" id="ajaxfile" name="photo" path="photo">
    <br>
    <button type='submit' onclick="uploadFile()" value='Submit'>Submit</button>
</form>
<script>
    async function uploadFile() {
        console.log("ffffffffffffffff");
        let formData = new FormData();
        formData.append("file", ajaxfile.files[0]);
        await fetch('UploadImagServlet-servlet', {
            method: "POST",
            body: formData
        });
        alert('The file upload with Ajax and Java was a success!');
    }
</script>
</body>
</html>
