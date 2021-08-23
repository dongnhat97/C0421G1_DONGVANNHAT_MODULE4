<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MR DONG NHAT
  Date: 8/23/2021
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <fieldset>
    <form method="post" action="/calculate">
      <p>
      <input type="text" name="a" value="${a}">
      <input type="text" name="b" value="${b}">
      </p>
      <button type="submit" name="operator" value="+">Addition</button>
      <button type="submit" name="operator" value="-">Subtraction</button>
      <button type="submit" name="operator" value="*">Multiplication</button>
      <button type="submit" name="operator" value="/">Division</button>


      <c:if test="${result!=null}">
        <p>
          ${result}
        </p>
      </c:if>
    </form>
  </fieldset>
  </body>
</html>
