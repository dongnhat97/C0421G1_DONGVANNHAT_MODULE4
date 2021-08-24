<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MR DONG NHAT
  Date: 8/24/2021
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form:form action="/save" modelAttribute="email">
  <table>
    <tr>
      <td><p><strong>Languages:</strong></p></td>
      <td>
        <form:select path="language" class="form-control">
          <form:option value="English"/>
          <form:option value="Vietnamese"/>
          <form:option value="Chinese"/>
          <form:option value="Japanese"/>
        </form:select>
      </td>
    </tr>
    <tr>
      <td><p><strong>Page Size:</strong></td>
      <td>
        <span>Show</span>
        <form:select path="pageSize">
          <form:option value="5"/>
          <form:option value="10"/>
          <form:option value="15"/>
          <form:option value="25"/>
        </form:select>
        <span>emails per page</span>
      </td>

    </tr>
    <tr>
      <td><p><strong>Spam Filter:</strong></td>
      <td>
        <form:checkbox path="spamsFilter"/>
        <span>Enable spams filter</span>
      </td>

    </tr>

    <tr>
      <td><p><strong>Signature:</strong></td>
      <td>
        <form:textarea path="signature" rows="5"/>
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <button type="submit">Update</button>
        <button type="reset">Cancel</button>
      </td>
    </tr>
  </table>
  </form:form>

  </body>
</html>
