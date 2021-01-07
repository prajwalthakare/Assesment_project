<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import ="com.extc.entity.Empolyeesdetails" %>
<%@page import ="java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<Empolyeesdetails> emplist=(ArrayList<Empolyeesdetails>)request.getAttribute("list"); %>

<%
String msg=(String)request.getAttribute("msg");

out.println(msg);
%>	
	<center>
	<h2>Employees List</h2>
	
	<table border="1">
	
	
	<tr>
		<th>SrNo</th>
		<th>Name</th>
		<th>Contact NO.</th>
		<th>Email</th>
		
	</tr>
	<%
	for(Empolyeesdetails emp:emplist)
	{
	%>
	<tr>
		<td><%out.println(emp.getSrNo()); %></td>
		<td><%out.println(emp.getName()); %></td>
		<td><%out.println(emp.getContactNo()); %></td>
		<td><%out.println(emp.getEmail()); %></td>
		
		<td><a href="deleteempolyee?SrNo=<%=emp.getSrNo() %>">Delete</a></td>
		<td><a href="update?SrNo=<%=emp.getSrNo() %>">Update</a></td>
	<td><a href="addempolyee?SrNo=<%=emp.getSrNo() %>">Add Employee</a></td>
	</tr>
	<%
	}
	%>
	</table>
	
	</center>
</body>
</html>