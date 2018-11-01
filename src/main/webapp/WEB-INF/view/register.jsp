<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h3 align="center">${header1}</h3>
	<form:form action="/Spring_Orm_Test_App/registerSuccess" method="post"
		modelAttribute="student" enctype="multipart/form-data">
		<table align="center">
			<caption align="top">Student registration form</caption>
			<tr>
				<td>Enter your name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Enter confirm Password:</td>
				<td><form:input path="confirmPassword" /></td>
				<td><form:errors path="confirmPassword" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Enter Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Enter Phone No:</td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td>Sex:</td>
				<td><form:radiobutton path="sex" value="Male" label="Male" />
					<form:radiobutton path="sex" value="Female" label="Female" /></td>
				<td><form:errors path="sex" cssClass="error" /></td>

			</tr>

			<!--  <tr>
				<td>Upload Image</td>
				<td><input type="file" name="file"></td>
			</tr>-->

			<tr>
				<td>Select Branch:</td>
				<td><form:select path="branch">
						<form:options items="${branchList}" />
					</form:select></td>
				<td><form:errors path="branch" cssClass="error" /></td>

			</tr>

			<tr>
				<td>Select country:</td>
				<td><form:select path="country">
						<form:options items="${countryList}" />
					</form:select></td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>

	</form:form>

</body>
</html>