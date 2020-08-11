<%--
  Created by IntelliJ IDEA.
  User: XLJ
  Date: 2020/7/2
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>

<div style="text-align: center;margin: 0px auto">
    <h2>所有文件</h2>
    <table align="center" border="1" cellpadding="5" cellspacing="0">
        <c:forEach items="${list}" var="f">
            <tr>
                <td>${f.fileId}</td>
                <td>${f.fileName}</td>
                <td><a href="download?fileId=${f.fileId}">下载</a></td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
