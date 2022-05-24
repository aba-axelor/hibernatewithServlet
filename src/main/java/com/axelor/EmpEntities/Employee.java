package com.axelor.EmpEntities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	
	private String ename;
	
	private double salary;
	
	@OneToOne(mappedBy = "eid")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private Leave leaves;
	
	@ManyToOne
	private Department dept;
	
	private LocalDate dob;
	
	private LocalDateTime dateofjoining;
	
	
	public int getEid() {
		return eid;
	}

	

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}



	public Leave getLeaves() {
		return leaves;
	}


	public void setLeaves(Leave leaves) {
		this.leaves = leaves;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public LocalDateTime getDateofjoining() {
		return dateofjoining;
	}



	public void setDateofjoining(LocalDateTime dateofjoining) {
		this.dateofjoining = dateofjoining;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", leaves=" + leaves + ", dept="
				+ dept + ", dob=" + dob + ", dateofjoining=" + dateofjoining + "]";
	}


	

	
	
	
	
	
}
