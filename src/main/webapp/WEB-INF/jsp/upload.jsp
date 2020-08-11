<%--
  Created by IntelliJ IDEA.
  User: XLJ
  Date: 2020/6/28
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>图片上传</title>
</head>
<body>

<form action="uploadImage" method="post" enctype="multipart/form-data">
    <%--    accept="image/*" 表示只能选择图片进行上传--%>
    选择图片：<input type="file" name="image" accept="image/*"> <br>
    <input type="submit" value="上传">
</form>

</body>
</html>
