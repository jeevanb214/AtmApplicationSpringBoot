<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
	<!-- <h1>Students List</h1> -->
	<h1>Customers List</h1>
	<!-- <form action = "updateOrDelete" method = "post"> -->
	<table border="5" cellpadding='8'>
		<tr>

			<!-- <th>Select</th> -->
			<th>A/C No</th>
			<th>Name</th>
			<th>Age</th>
			<th>City</th>
			<th>Balance</th>
			<th>Pin</th>
		</tr>
		<c:forEach var="customer" items="${list}">
			<tr>


				<!-- <td><input type = "radio" name = "key" value = "${emp.id}" ></td> -->
				<td>${customer.acno}</td>
				<td>${customer.name}</td>
				<td>${customer.age}</td>
				<td>${customer.city}</td>
				<td>${customer.balance}</td>
				<td>${customer.pin}</td>

			</tr>
		</c:forEach>
	</table>
	<br> <br>
	<!-- <input type = "submit" name = "action" value = "update"> 
      <input type = "submit" name = "action" value = "delete"> -->

	<br />
	<!-- <form action = "updateStudent">
   <input type = "submit" value = "update">
    <form action = "deleteStudent">
   <input type = "submit" value = "delete"> -->
	<br>
	<form action="index">
		<input type="submit" value="Homepage">
	</form>

</center>