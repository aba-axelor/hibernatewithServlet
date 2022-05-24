package com.axelor.Empmain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.axelor.EmpEntities.Department;
import com.axelor.EmpEntities.Employee;
import com.axelor.EmpEntities.Leave;
import com.axelor.EmpEntities.OfficeLocation;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class).addAnnotatedClass(OfficeLocation.class)
				.addAnnotatedClass(Leave.class);
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();

		Employee e1 = new Employee();
		e1.setEname("Arun");
		e1.setSalary(15000.76);
		LocalDate ld = LocalDate.of(2000, 4, 3);
		e1.setDob(ld);
		LocalDateTime ldt= LocalDateTime.now();
		e1.setDateofjoining(ldt);
		
		
		Leave l1 = new Leave(e1,e1.getEid());
		e1.setLeaves(l1);
		l1.setOnleave(false);
		
		
		Department d1 = new Department();
		d1.setDid(101);
		d1.setDname("FrontEnd");
		d1.setMgr(e1);
		d1.setEmployees(e1);
		
		e1.setDept(d1);
	
		
		OfficeLocation o1 = new OfficeLocation();
		o1.setOid(1001);
		o1.setOname("Bangalore");
		o1.setDepts(d1);
		
		d1.setLocs(o1);

		s.beginTransaction();
		
		s.save(o1);
		s.save(d1);
		s.save(l1);
		s.save(e1);
		

		
		s.getTransaction().commit();
//
//		EmpCrud ec = new EmpCrud();
//		
//		ec.readallEmp();

//		if (ec.createEmployee("Arun Balouria", 15000.23, 101, 2005, 5, 4)) {
//			System.out.println("Employee Successfully created");
//		}
//		ec.readallEmp();
//
//		
//		Query q=s.createQuery("select eid from Employee where ename=?1");
//		q.setParameter(1,"Arun Balouria");
//		int eid= (int)q.uniqueResult();
//		System.out.println(eid);
//				
//
//				
//		if (ec.UpdateEmployee(eid,"Dev", 30000.23, 101, 2005, 5, 4)) {
//			System.out.println("Employee Successfully updated");
//		}
//
//		if(ec.DeleteEmployee(eid))
//		{
//			System.out.println("Employee Successfully deleted");
//		}

//		List<Integer> empids= new ArrayList<Integer>();
//		empids.add(1);
//		empids.add(10);
//		empids.add(11);
//		List<Integer> locids= new ArrayList<Integer>();
//		locids.add(1001);
//		locids.add(1002);
		
//		DeptCrud dc= new DeptCrud();
//		if(dc.CreateDepartment("demoo", 1, empids, locids))
//		{
//			System.out.println("Department Successfully Created");
//		}
//		else
//		{
//			System.out.println("Error Creating Departments");
//		}
//	
	}
	
}
