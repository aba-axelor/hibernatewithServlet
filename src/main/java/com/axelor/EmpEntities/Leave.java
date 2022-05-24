package com.axelor.EmpEntities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Leave {

	@Id
	private int lid;
	@OneToOne
	@JoinColumn(name = "eid")
	@MapsId
	private Employee eid;
	
	private int casualleave;
	
	private int sickleave;
	
	private boolean isOnleave;

	
	
	public Leave()
	{
		super();
	}
	
	public Leave(Employee eid, int lid) {
		this.lid =lid;
		this.eid= eid;
		this.casualleave = 12;
		this.sickleave = 10;
	}





	public Employee getEid() {
		return eid;
	}





	public void setEid(Employee eid) {
		this.eid = eid;
	}





	public int getCasualleave() {
		return casualleave;
	}





	public void setCasualleave(int casualleave) {
		this.casualleave = casualleave;
	}





	public int getSickleave() {
		return sickleave;
	}





	public void setSickleave(int sickleave) {
		this.sickleave = sickleave;
	}





	public boolean isOnleave() {
		return isOnleave;
	}





	public void setOnleave(boolean isOnleave) {
		this.isOnleave = isOnleave;
	}





	@Override
	public String toString() {
		return "Leave [eid=" + eid + ", casualleave=" + casualleave + ", sickleave=" + sickleave + "]";
	}
	
	
}
