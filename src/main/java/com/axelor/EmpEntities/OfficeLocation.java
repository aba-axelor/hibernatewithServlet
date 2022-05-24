package com.axelor.EmpEntities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class OfficeLocation {

	
	@Id
	private int oid;
	
	private String oname;
	
	@ManyToMany
	private Set<Department> depts = new HashSet<Department>();
	
	
	

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	
	public Set<Department> getDepts() {
		return depts;
	}

	public void setDepts(Department depts) {
		this.depts.add(depts);
	}

	

	@Override
	public String toString() {
		return "OfficeLocation [oid=" + oid + ", oname=" + oname + ", depts=" + depts 
				+ "]";
	}






	
	
			
	
}
