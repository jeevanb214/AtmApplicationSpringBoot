<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		Fill the Student Details

		<form:form action="registerSuccess" method="post"
			modelAttribute="customer">
			<table>


				<tr>
					<td>Name</td>
					<td><form:input path="name" /></td>
				</tr>


				<tr>
					<td>Age</td>
					<td><form:input path="age" /></td>
				</tr>

				<tr>
					<td>City</td>
					<td><form:input path="city" /></td>
				</tr>

				<tr>

					<td>Balance</td>
					<td><form:input path="balance" /></td>
				</tr>

				<tr>

					<td>Pin</td>
					<td><form:password path="pin" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>