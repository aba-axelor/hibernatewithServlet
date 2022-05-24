package com.axelor.Empmain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.axelor.EmpEntities.Department;
import com.axelor.EmpEntities.Employee;
import com.axelor.EmpEntities.Leave;
import com.axelor.EmpEntities.OfficeLocation;

public class EmpCrud {

	Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class)
			.addAnnotatedClass(Department.class).addAnnotatedClass(OfficeLocation.class).addAnnotatedClass(Leave.class);
	SessionFactory sf = con.buildSessionFactory();


	public boolean createEmployee(String ename, double salary, int did, LocalDate dob) {
		Session s2 = sf.openSession();

		Employee e1 = new Employee();
		Department d1 = s2.get(Department.class, did);
		
		e1=sete(e1,d1,ename,salary, dob);
		
		LocalDateTime ldt = LocalDateTime.now();
		e1.setDateofjoining(ldt);

		Leave l1 = new Leave(e1, e1.getEid());
		e1.setLeaves(l1);
		l1.setOnleave(false);

		s2.beginTransaction();
		s2.save(e1);
		s2.save(d1);
		s2.getTransaction().commit();
		s2.close();

		return true;

	}
	
	
	public List<Employee> ListEmp()
	{
		Session s = sf.openSession();
		Query q = s.createQuery("from Employee");
		List<Employee> emps = q.getResultList();
		
		return emps;
		
	}
	
	public List<Department> ListDept()
    {
        Session s = sf.openSession();
        Query q = s.createQuery("from Department");
        List<Department> depts = q.getResultList();
        
        return depts;
        
    }
	
	public boolean UpdateEmployee(int eid, String ename, double salary, int did,LocalDate dob, int cl, int sl)
	{
		
		Session s3= sf.openSession();

		Employee e= s3.get(Employee.class, eid);
		Department d = s3.get(Department.class, did);

		if(e==null)
		{
			System.out.println("Employee not found");
			return false;
		}
		
		e=sete(e,d,ename,salary, dob);
		
		Leave l= s3.get(Leave.class,eid);
		l.setCasualleave(cl);
		l.setSickleave(sl);

		s3.beginTransaction();
		s3.save(e);
		s3.getTransaction().commit();
		s3.close();

		return true;
	
	}
	
	public boolean DeleteEmployee(int eid)
	{
		Session s4= sf.openSession();
		Employee e1= s4.get(Employee.class,eid);
		if(e1==null)
		{
			System.out.println("Employee Not Found");
			return false;
		}
		s4.beginTransaction();
		s4.delete(e1);
		s4.getTransaction().commit();
		s4.close();
		return true;
		
		
	}
	
	private Employee sete(Employee e1, Department d, String ename,double salary, LocalDate dob)
	{

		if (d == null) {
			System.out.println("Department not found");
			return null;
		}
		e1.setEname(ename);
		e1.setSalary(salary);
		e1.setDept(d);
		e1.setDob(dob);
		
		return e1;
	}
	public Employee getEmployee(int eid)
	{
		Session s4= sf.openSession();
		Employee e1= s4.get(Employee.class,eid);
		return e1;
	}
}
