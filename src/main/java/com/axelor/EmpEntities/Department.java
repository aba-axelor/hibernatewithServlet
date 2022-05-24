package com.axelor.EmpEntities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int did;
	
	private String dname;
	
	@OneToOne
	private Employee mgr;
	
	@OneToMany(mappedBy = "dept")
	private List<Employee> employees = new ArrayList<Employee>();
	
	@ManyToMany(mappedBy = "depts")
	private Set<OfficeLocation> locs = new HashSet<OfficeLocation>();

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Employee getMgr() {
		return mgr;
	}

	public void setMgr(Employee mgr) {
		this.mgr = mgr;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Employee e) {
		this.employees.add(e);
	}

	public Set<OfficeLocation> getLocs() {
		return locs;
	}

	public void setLocs(OfficeLocation locs) {
		this.locs.add(locs);
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", mgr=" + mgr + ", employees=" + employees + ", locs="
				+ locs + "]";
	}
	
	

}
