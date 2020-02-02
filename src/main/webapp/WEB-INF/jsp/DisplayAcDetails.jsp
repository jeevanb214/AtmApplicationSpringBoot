<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Account Successfully Created !!</h2>
		<table border="5" cellpadding='8'>

			<tr>
				<th>Name</th>
				<th>Value</th>
			</tr>

			<tr>
				<td>Account No</td>
				<td>${customer.acNo}</td>
			</tr>

			<tr>
				<td>Name</td>
				<td>${customer.name}</td>
			</tr>

			<tr>
				<td>age</td>
				<td>${customer.age}</td>
			</tr>

			<tr>
				<td>City</td>
				<td>${customer.city}</td>
			</tr>

			<tr>
				<td>Balance</td>
				<td>${customer.balance}</td>
			</tr>

			<tr>
				<td>Pin</td>
				<td>${customer.pin}</td>
			</tr>
		</table>
		<br>
		<br>
		<form action="index">
			<input type="submit" value="Homepage">
		</form>
	</center>
</body>
</html>