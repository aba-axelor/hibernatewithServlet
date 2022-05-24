package com.axelor.EmpServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.axelor.Empmain.EmpCrud;

@WebServlet("/delete")
public class DeleteEmpServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out= res.getWriter();
		int eid= Integer.parseInt(req.getParameter("eid"));
		
		EmpCrud ec= new EmpCrud();
		if(ec.DeleteEmployee(eid))
		{
			out.println("Employee Successfully deleted");
			res.sendRedirect("index.jsp");
		}
		else
		{
			out.println("Error Deleting Employee");
		}
		
		
		
		
	}
	
	
	
	
	
}
