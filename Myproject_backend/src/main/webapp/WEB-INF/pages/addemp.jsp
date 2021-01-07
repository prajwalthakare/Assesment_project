<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Details</title>
</head>
<body>
	<center>
	<h2>Add Employees Details </h2>
	<form action="addemp">

	<table border="1">
	<tr>
		<td>Enter Name:-</td>
		<td><input type="text" name="Name" value="Name"></td>
	</tr>
	<tr>
		<td>Enter Contact No:-</td>
		<td><input type="text" name="ContactNo" value="ContactNo"></td>
	</tr>
	<tr>
		<td>Email:-</td>
		<td><input type="text" name="Email" value="Email"></td>
	</tr>
	
	<tr>
		<td></td>
		<td><input type="submit" value="save"></td>
	</tr>
	</table>
	
	</form>
	
	</center>
</body>
</html>