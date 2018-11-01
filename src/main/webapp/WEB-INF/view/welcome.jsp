<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h3 align="right">
		<a href="/Spring_Orm_Test_App">Back</a>
	</h3>
	<h3 align="center">${header}</h3>
	<h3 align="center">You have registered with following Info::::</h3>
	<table align="center" border="5px">

		<tr>
			<td>Student name:</td>  
			<td>${student.name}</td>
		</tr>

		<tr>
			<td>Student Password:</td>
			<td>${student.password}</td>
		</tr>

		<tr>
			<td>Student cinfirmPassword:</td>
			<td>${student.confirmPassword}</td>
		</tr>
		
		<tr>
			<td>Student email:</td>
			<td>${student.email}</td>
		</tr>
		
		<tr>
			<td>Student Phone:</td>
			<td>${student.phone}</td>
		</tr>

		<tr>
			<td>Student sex</td>
			<td>${student.sex}</td>
		</tr>

		
		<tr>
			<td>Selected branch:</td>
			<td>${student.branch}</td>
		</tr>

		<tr>
			<td>Country</td>
			<td>${student.country}</td>
		</tr>

	</table>
</body>
</html>