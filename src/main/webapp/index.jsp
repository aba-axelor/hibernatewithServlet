<%@page import="com.axelor.Empmain.EmpCrud, java.util.List, com.axelor.EmpEntities.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="UTF-8">
<title>Employees</title>
</head>
<body>

<%

EmpCrud ec = new EmpCrud();
List<Employee> emps=ec.ListEmp();

session.setAttribute("emps", emps);


%>




<h2>List of Employee: </h2>
<table data-role="table" id="table-1" class="ui-responsive">
	<thead>
		<tr>
			<th>Employee ID</th>
			<th data-priority="1">Name</th>
			<th data-priority="2">DOB</th>
			<th data-priority="3">Department</th>
			<th data-priority="4">Salary</th>
			<th data-priority="5">Date of Joining</th>
			<th data-priority="6">Casual Leaves</th>
			<th data-priority="7">Sick Leaves</th>
			<th data-priority="8">Operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${emps}">
			<tr>
				<td>  <c:out value="${e.getEid()}"></c:out>	</td>
				<td>  <c:out value="${e.getEname()}"></c:out>	</td>
				<td>  <c:out value="${e.getDob()}"></c:out>	</td>
				<td>  <c:out value="${e.getDept().getDname()}"></c:out>	</td>
				<td>  <c:out value="${e.getSalary()}"></c:out>	</td>
				<td>  <c:out value="${e.getDateofjoining()}"></c:out>	</td>
				<td>  <c:out value="${e.getLeaves().getCasualleave()}"></c:out>	</td>
				<td>  <c:out value="${e.getLeaves().getSickleave()}"></c:out>	</td>
				<td>
				
				<a href="createupdateemp.jsp?ueid=${e.getEid()}">Edit</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="delete?eid=${e.getEid()}">Delete</a>
				
				
				</td>
				<td>
			</tr>
		</c:forEach>			
		
	</tbody>
</table>

<br>
<br>
<br>
<form action="createupdateemp.jsp?ueid=0">
   <input type="submit" value="Add an Employee" />
</form>


<br>
<br>

</body>
</html>