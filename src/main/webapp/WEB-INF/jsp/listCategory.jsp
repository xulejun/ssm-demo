<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="/js/jquery.min.js"></script>

<script>
    // 将post方法改为delete
    $(function () {
        // 获取到《删除》的点击事件执行方法
        $(".delete").click(function () {
            var href = $(this).attr("href");
            // 以form表单的形式提交
            $("#formdelete").attr("action", href).submit();
            return false;
        })

    })
</script>


<div style="width: 500px; margin: 0px auto;text-align: center">

    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="categories/${c.id}">编辑</a></td>
                <td><a class="delete" href="categories/${c.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <div style="text-align: center">
        <a href="?start=0">首页</a>
        <a href="?start=${pageUtil.start-pageUtil.count}">上一页</a>
        <a href="?start=${pageUtil.start+pageUtil.count}">下一页</a>
        <a href="?start=${pageUtil.last}">末页</a>
    </div>

    <div style="text-align: center;margin-top: 40px">
        <form method="POST" action="categories">
            分类名称：<input name="name" value="" type="text">
            <input type="submit" value="增加分类">
        </form>
    </div>
</div>
<%--    尽管是method是post，但_method的值是delete，springmvc会以method=delete处理--%>
<form id="formdelete" action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>