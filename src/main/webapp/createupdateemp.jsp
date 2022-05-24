<%@page import="com.axelor.Empmain.EmpCrud"%>
<%@page import="com.axelor.EmpEntities.Employee"%>
<%@page import="com.axelor.EmpEntities.*, java.util.List, org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create/Update an Employee</title>
</head>
<body>

<%
	
	EmpCrud ec= new EmpCrud();
	List<Department> depts= ec.ListDept();
	session.setAttribute("depts",depts);
	
	if(request.getParameter("ueid")!=null||request.getParameter("ueid")!="0")
	{
		int ueid=Integer.parseInt(request.getParameter("ueid"));
		Employee e= ec.getEmployee(ueid);
		session.setAttribute("emp", e);
	}
	
%>


<h2>Create/Update an Employee:</h2>
<br>
<br>
Please Enter The Employee Details:
<br><br>

<form action="createorupdate?ueid=${emp.getEid()}" method="post">

Name:<br>
<input type="text" name="ename" value="${emp.getEname()}">
<br><br>
Department No.:
<br>
<select name="did"  >
<c:forEach var="d" items="${depts}">
<option value="${d.getDid()}">
<c:out value="${d.getDname()}"></c:out>
 </option>
</c:forEach>
</select>
<br><br>
Date of Birth:
<br>
<input type="date" name="dob" value="${emp.getDob()}">
<br><br>
Salary:
<br>
<input type="text" name="salary" value="${emp.getSalary()}">
<br><br>
Casual Leaves): (For existing Employee*)
<br>
<input type="text" name="cl" value="${emp.getLeaves().getCasualleave() }">
<br><br>
Sick Leaves: (For existing Employee*)
<br>
<input type="text" name="sl" value="${emp.getLeaves().getSickleave()}">
<br><br>
<input type="submit" value="Create/Update Employee">

</form>











</body>
</html>