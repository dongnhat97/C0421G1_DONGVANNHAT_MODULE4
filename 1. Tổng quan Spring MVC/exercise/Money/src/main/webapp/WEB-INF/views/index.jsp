<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<fieldset>
<form action="/money" method="post">
   <input type="text" name="rate" value="${rate}">
   <input type="text" name="usd"  value="${usd}">
    <input type="submit" value="Check">
    <c:if test="${vnd!=null}">
        <p>
        <input type="text" name="vnd" value="${vnd}">
        </p>
    </c:if>
</form>
</fieldset>
</body>
</html>