<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MR DONG NHAT
  Date: 8/23/2021
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<fieldset>
    <form action="/save" method="post">
        <p>
            <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
        </p>
        <p>
            <input type="checkbox" name="condiment" value="Tomato"> Tomato
        </p>
        <p>
            <input type="checkbox" name="condiment" value="Mustard"> Mustard
        </p>
        <p>
            <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
        </p>
        <button type="submit">Save</button>

        <c:if test="${save!=null}">
            <c:forEach var="sandwich" items="${save}">
              <p style="color: red;font-size: 50px">${sandwich}</p>
            </c:forEach>
        </c:if>
    </form>
    <c:if test="${empty save}">
        <p>${message}</p>
    </c:if>
</fieldset>
  </body>
</html>
