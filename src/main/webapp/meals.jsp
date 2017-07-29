<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<style>
    .normal {
        color: green;
    }

    .exceeded {
        color: red;
    }
</style>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>

<c:if test="${!empty meals}">

    <form name="form" method="post">
        <input type="submit" value="create" name="act"/>
    </form>

    <table class="tg" border="1">
        <tr>
            <th width="80" hidden>id</th>
            <th width="80">dateTime</th>
            <th width="120">description</th>
            <th width="120">calories</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${meals}" var="meal">
        <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
            <td hidden>${meal.id}</td>
            <td>${meal.getDateTimeWithoutT()}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=update&id=${meal.id}">Edit</a></td>
            <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
