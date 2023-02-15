<%@ page import="java.util.ArrayList" %>
<%@ page import="webapp.se.webappse.model.EmployeeEntity" %>
<%@ page import="java.util.Collection" %><%--
    Purpose  : APR course - 2023
    Author   : JAA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<style>
  table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
  }
</style>

<h3>${messageKey}</h3>
<br/>
<body>
<form>
  <table>
    <tr>
      <th><b>First name</b></th>
      <th><b>Last name</b></th>
      <th><b>Address</b></th>
      <th><b>Postal code</b></th>
      <th><b>City</b></th>
      <th><b>Home phone</b></th>
      <th><b>Mobile phone</b></th>
      <th><b>Work phone</b></th>
      <th><b>Email</b></th>
    </tr>


    <c:forEach items="${allEmployees}" var="employee">
      <tr>
        <td> <c:out value="${employee.firstname}"/> </td>
        <td> <c:out value="${employee.lastname}"/> </td>
        <td> <c:out value="${employee.address}"/> </td>
        <td> <c:out value="${employee.postalcode}"/> </td>
        <td> <c:out value="${employee.city}"/> </td>
        <td> <c:out value="${employee.mobilephone}"/> </td>
        <td> <c:out value="${employee.workphone}"/> </td>
        <td> <c:out value="${employee.mobilephone}"/> </td>
        <td> <c:out value="${employee.email}"/> </td>
      </tr>
    </c:forEach>


  </table>

</form>
</body>
</html>
