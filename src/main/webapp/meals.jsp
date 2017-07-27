<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>

<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>

<c:if test="${!empty meals}">
    <table class="tg">


        <tr>
            <th width="80">dateTime</th>
            <th width="120">description</th>
            <th width="120">calories</th>
            <th width="120">exceed</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${meals}" var="meal">

            <c:choose>
                <c:when test="${meal.exceed}">
                    <tr bgcolor="red">
                </c:when>
                <c:otherwise>
                    <tr bgcolor="green">
                </c:otherwise>
            </c:choose>
            <td>${meal.dateTime}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td>${meal.exceed}</td>
            <%--                <td><a href="<c:url value='/edit/${meal.id}'/>">Edit </a></td>
                            <td><a href="<c:url value='/remove/${meal.id}'/>">Delete ${person.id}</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
