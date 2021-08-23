<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MR DONG NHAT
  Date: 8/22/2021
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <fieldset>
    <form method="post" action="/search">
      <input type="text" name="english" value="${english}">
      <input type="submit" value="Search">
      <c:if test="${result!=null}">
        <h3>
          ${result}
        </h3>
      </c:if>
    </form>
  </fieldset>
  </body>
</html>
