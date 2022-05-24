package com.axelor.EmpServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.axelor.Empmain.EmpCrud;

@WebServlet("/createorupdate")
public class CreateUpdateEmpServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String ename = req.getParameter("ename");
		double salary = Double.parseDouble(req.getParameter("salary"));
		int did = Integer.parseInt(req.getParameter("did"));
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		int eid;
		if (req.getParameter("ueid")!="")
			eid = Integer.parseInt(req.getParameter("ueid"));
		else
			eid = 0;
		System.out.println(dob);

		EmpCrud ec = new EmpCrud();
		if (eid == 0) {
			if (ec.createEmployee(ename, salary, did, dob)) {
				out.println("Employee Successfully Created");
				res.sendRedirect("index.jsp");
			} else {
				out.println("Error Creating Employee");
			}

		} else {
			int cl = Integer.parseInt(req.getParameter("cl"));
			int sl = Integer.parseInt(req.getParameter("sl"));
			if (ec.UpdateEmployee(eid, ename, salary, did, dob, cl, sl)) {
				out.println("Employee Successfully Updated");
				res.sendRedirect("index.jsp");
			} else {
				out.println("Error Updating Employee");
			}
		}

	}

}
