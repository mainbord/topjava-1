<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>

<body>
<h3><a href="index.html">Home</a></h3>
<h2>${param.action == 'create' ? 'Create meal' : 'Edit meal'}</h2>

<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
<form action="" method="POST">
    <input type="text" name="id" hidden value=${meal.id}>
    <br/>
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
