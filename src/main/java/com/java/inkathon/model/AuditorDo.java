package com.java.inkathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Auditor")
public class AuditorDo {
	// 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="AUDITOR ID")
	private Long auditor_id;
	
	@Column(name="INCIDENT ID")
	private int incidentId;
	
	@Column(name="COMMENTS")
	private String Comments;

	public Long getAuditor_id() {
		return auditor_id;
	}

	public void setAuditor_id(Long auditor_id) {
		this.auditor_id = auditor_id;
	}

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	@Override
	public String toString() {
		return "AuditorDo [auditor_id=" + auditor_id + ", incidentId=" + incidentId + ", Comments=" + Comments + "]";
	}

	




}