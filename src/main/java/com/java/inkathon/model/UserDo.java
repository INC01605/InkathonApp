package com.java.inkathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 

@Entity
@Table(name="USER")
public class UserDo{
 
    @Id
    @Column(name="UID")
    private int uid;
    
    @Column(name="INCIDENT ID")
    private int incidentId;
 
    @Column(name="NAME")
    private String name; 
 
    @Column(name="JOB ROLE") 
    private String role;
    
    @Override
	public String toString() {
		return "UserDo [uid=" + uid + ", incidentId=" + incidentId + ", name=" + name + ", role=" + role + ", exp="
				+ exp + ", phoneNumber=" + phoneNumber + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name="EXPERIENCE")
    private String exp;
    
    @Column(name="CONTACT")
    private String phoneNumber;
    
    
}
    
 