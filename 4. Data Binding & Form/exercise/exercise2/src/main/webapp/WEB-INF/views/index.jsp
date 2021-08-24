<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MR DONG NHAT
  Date: 8/24/2021
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/WEB-INF/assert/untitled/css/bootstrap.min.css">

</head>
<body>
<form:form action="/save" modelAttribute="people">
    <div class="container-fluid">
        <div class="row">
            <h3 style="text-align: center">Tờ khai báo y tế</h3>
        </div>
    </div>
    <div class="row">
        <h4 style="text-align: center">Đây là tài liệu quan trọng, thông tin của anh chị sẽ giúp cơ quan y tế liên lạc khi cần thiết </h4>
    </div>
   <div class="row">
     <h4 style="color: red;text-align: center">Khuyến cáo: Khai báo sai thông tin là vi phạm luật pháp Việt Nam</h4>
   </div>
  <div class="row">
    <p>Họ tên (ghi chữ in hoa)</p>
  </div>
    <div class="row">
     <div class="col-12">
    <form:input path="name" />
     </div>
  </div>
    </div>
</form:form>
</body>
</html>
