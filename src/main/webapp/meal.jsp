<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>

<body>
<h3><a href="index.html">Home</a></h3>
<h2>Update or Create Meal</h2>


<form action="" method="POST">


    <c:choose>
        <c:when test="${meal.id == null}">
            <input type="text" name="id" hidden value=${meal.id}>
            <br/>
        </c:when>
        <c:otherwise>
            ID: <input type="text" name="id" readonly value=${meal.id}>
            <br/>
        </c:otherwise>
    </c:choose>

    Date: <input type="datetime-local" name="datetime" value=${meal.dateTime}>
    <br/>
    Description: <input type="text" name="description" value=${meal.description}>
    <br/>
    Calories: <input type="text" name="calories" value=${meal.calories}>
    <br/>
    <input type="submit" value="Submit">
</form>

</body>
</html>
