package com.java.inkathon.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ActionTeam")
public class ActionTeamDo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="status")
	private String status;
	
	public ActionTeamDo() {
		super();
	}
	
	public ActionTeamDo(String status) {
		super();
		this.status = status;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	

	@Override
	public String toString() {
		return "ActionTeam [id=" + id + ", status=" + status +" ]";
	}
	
	

}


