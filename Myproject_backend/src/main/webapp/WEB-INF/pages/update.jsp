<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.extc.entity.Empolyeesdetails" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<% ArrayList<Empolyeesdetails> listuser=(ArrayList<Empolyeesdetails>)request.getAttribute("list");  %>
<body>
	<center>
	<form action="/updatepage">
	<%
	for(Empolyeesdetails empl:listuser)
	{
	 %>
	<table border="1">
	<tr>
		<td>Enter Name:-</td>
		<td><input type="text" name="name" value="<%out.println(empl.getName());%>"></td>
	</tr>
	<tr>
		<td>Enter ContactNo:-</td>
		<td><input type="text" name="ContactNo" value="<%out.println(empl.getContactNo());%>"></td>
	</tr>
	<tr>
		<td>Enter Email:-</td>
		<td><input type="text" name="Email" value="<%out.println(empl.getEmail());%>"></td>
	</tr>
	
	<tr>
		
		<td><input type="hidden" name="SrNo" value="<% out.println(empl.getSrNo());%>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Submit"></td>
	</tr>
	</table>
	<%
	
	}
	%>
	</form>
	
	</center>
</body>
</html>