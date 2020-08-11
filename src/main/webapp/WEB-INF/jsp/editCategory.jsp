<%--
  Created by IntelliJ IDEA.
  User: XLJ
  Date: 2020/6/27
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>editCategory</title>
</head>
<body>

<div style="width: 500px;margin:0px auto;text-align: center">

    <div style="text-align: center;margin-top: 40px">

        <form method="post" action="../categories/${c.id}">
            <input type="hidden" name="_method" value="put">
            分类名称：<input name="name" value="${c.name}" type="text"><br>
            <input type="submit" value="修改分类">
        </form>

    </div>

</div>

</body>
</html>
