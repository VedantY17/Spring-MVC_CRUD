<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Students</title>
</head>
<body>

	<table border="1" cellspacing="5" cellpadding="6" style="border-collapse: collapse;">

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<c:forEach var="s" items="${students}">
			<tr>
				<td>${s.getId()}</td>
				<td>${s.getName()}</td>
				<td>${s.getEmail()}</td>
				<td><a href="delete?id=${s.getId()}">Delete</a></td>
				<td><a href="update?id=${s.getId()}">Update</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>