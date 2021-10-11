package com.java.inkathon.dao;
import java.util.List;
import javax.persistence.Query;
import com.java.inkathon.model.IncidentDo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class IncidentDao { 
	
	@Autowired(required=true)
	private SessionFactory factory;
	
	//creating an incident - user to manager dash board
	public String saveIncident(IncidentDo incident){
		
		if(incident!=null){
			incident.setStatus("In Progress");
			incident.setActionTeamStatus("No Action");
			incident.setManagerID(500);
			incident.setFlag(0);
			factory.getCurrentSession().save(incident);
			return "Succesfully inserted into DB";
		}
		return "object not found";
	}
	
	//get incident in ascending order
	@SuppressWarnings("unchecked")
	public List<IncidentDo> getAllincidents() {
		try{
		Session session = this.factory.getCurrentSession();
		List<IncidentDo> incidentList = session.createQuery("from IncidentDo order by INCIDENT_ID asc").list();
		return incidentList;
		}
		catch(Exception e){
		System.err.println("ERROR:---"+ e);
		}
		return null;
	}
	
	//get incident whose risk level is greater than 2
	@SuppressWarnings("unchecked")
	public List<IncidentDo> sortrisklevel() {
		try{
		Session session = this.factory.getCurrentSession();
		List<IncidentDo> incidentList = session.createQuery("from IncidentDo where riskLevel > 5 order by INCIDENT_ID asc").list();
		return incidentList;
		}
		catch(Exception e){
		System.err.println("ERROR:---"+ e);
		}
		return null;
	}
	
	//sort incidents whose risk level is set
	@SuppressWarnings("unchecked")
	public List<IncidentDo> getNewIncidents(){
		try{
		Session session = this.factory.getCurrentSession();
		List<IncidentDo> incidentList = session.createQuery("from IncidentDo where flag = 0 OR riskLevel < 5 order by INCIDENT_ID asc").list();
		return incidentList;
		}
		catch(Exception e){
		System.err.println("ERROR:---"+ e);
		}
		return null;
	}
	
	//update risk - manager
	public String updateRisk(IncidentDo incident){
		if(incident!=null){
			Session session = this.factory.getCurrentSession();
			Query query = session.createQuery("update IncidentDo set RISK_LEVEL=:RISK_LEVEL,FLAG=:FLAG where INCIDENT_ID=:INCIDENT_ID");
	        query.setParameter("RISK_LEVEL",incident.getRiskLevel());
			query.setParameter("FLAG",incident.getFlag());
	        query.setParameter("INCIDENT_ID",incident.getId());
	        int result = query.executeUpdate();
	        // Commit the transaction and close the session
	        System.err.println("No of rows updated: "+result);
			return "Succesfully updated risk";
		}
		return "object not found";
	}
	
	//approve incident - audit team
	
	public String updateStatus(IncidentDo incident){
		if(incident!=null){
			Session session = this.factory.getCurrentSession();
			Query query = session.createQuery("update IncidentDo set STATUS=:STATUS where INCIDENT_ID=:INCIDENT_ID");
	        query.setParameter("STATUS","Approved");
	        query.setParameter("INCIDENT_ID",incident.getId());
	        int result = query.executeUpdate();
	        System.err.println("No of rows updated: "+result);
			return "Succesfully approved incident";
		}
		return "object not found";
	}
	
	//reject incident -audit team
	
	public String rejectStatus(IncidentDo incident){
		if(incident!=null){
			Session session = this.factory.getCurrentSession();
			Query query = session.createQuery("update IncidentDo set STATUS=:STATUS,ACTION_TEAM_STATUS=:ACTION_TEAM_STATUS where INCIDENT_ID=:INCIDENT_ID");
	        query.setParameter("STATUS","Rejected");
	        query.setParameter("ACTION_TEAM_STATUS","No Action");
	        query.setParameter("INCIDENT_ID",incident.getId());
	        int result = query.executeUpdate();
	        System.err.println("No of rows updated: "+result);
			return "Succesfully rejected incident";
		}
		return "object not found";
	}
	
	//delete incident - unused at the moment
	public String deleteIncident(int id){
		Session session = this.factory.getCurrentSession();
		Query query = session.createQuery("delete IncidentDo where INCIDENT_ID=:INCIDENT_ID");
	    query.setParameter("INCIDENT_ID",id);
	    int result = query.executeUpdate();
	    System.err.println("No of rows updated: "+result);
	    return "Succesfully deleted incident";
	}
	  
	//save comment auditor to action team
	public String saveComments(IncidentDo incident){
		if(incident!=null){
			Session session = this.factory.getCurrentSession();
			Query query = session.createQuery("update IncidentDo set COMMENTS=:COMMENTS where INCIDENT_ID=:INCIDENT_ID");
	        query.setParameter("COMMENTS",incident.getComments());
	        query.setParameter("INCIDENT_ID",incident.getId());

	        int result = query.executeUpdate();
	        System.err.println("No of rows updated: "+result);
			return "Succesfully added Comments";
		}
		return "object not found";

	}
	
	//update table - auditor
	
	public String updateAll(IncidentDo incident){
		if(incident!=null){
			Session session = this.factory.getCurrentSession();
			Query query = session.createQuery("update IncidentDo set LOCATION=:LOCATION, DESCRIPTION=:DESCRIPTION,INCIDENT_TYPE=:INCIDENT_TYPE,INCIDENT_DATE=:INCIDENT_DATE,SECTOR=:SECTOR,RISK_LEVEL=:RISK_LEVEL,EMPLOYEE_NAME=:EMPLOYEE_NAME,INJURY=:INJURY,ACTION_NEEDED=:ACTION_NEEDED where INCIDENT_ID=:INCIDENT_ID");
	        query.setParameter("LOCATION",incident.getLocation());
	        query.setParameter("DESCRIPTION",incident.getDescription());
	        query.setParameter("INCIDENT_TYPE",incident.getIncidentType());
	        query.setParameter("INCIDENT_DATE",incident.getIncidentDate());
	        query.setParameter("SECTOR",incident.getSector());
	        query.setParameter("RISK_LEVEL",incident.getRiskLevel());
	        query.setParameter("EMPLOYEE_NAME",incident.getEmpname());
	        query.setParameter("ACTION_NEEDED",incident.getAction());
	        query.setParameter("INJURY",incident.getInjury());
	        query.setParameter("INCIDENT_ID",incident.getId());
	        int result = query.executeUpdate();
	        System.err.println("No of rows updated: "+result);
			return "Succesfully updated all the values";
		}
		return "object not found";
	}
	
	
	//action team
	//update actionTeamStatus
	
	
	public String updateAction(IncidentDo incident){
		if(incident!=null){
			Session session = this.factory.getCurrentSession();
			Query query = session.createQuery("update IncidentDo set ACTION_TEAM_STATUS=:ACTION_TEAM_STATUS where INCIDENT_ID=:INCIDENT_ID");
	        query.setParameter("ACTION_TEAM_STATUS",incident.getActionTeamStatus());
	        query.setParameter("INCIDENT_ID",incident.getId());
	        int result = query.executeUpdate();
	        System.err.println("No of rows updated: "+result);
			return "Succesfully completed incident";
		}
		return "object not found";
	}
	
	//get action team completed incidents
	@SuppressWarnings("unchecked")
	public List<IncidentDo> getDoneincidents() {
		try{
		Session session = this.factory.getCurrentSession();
		List<IncidentDo> incidentList = session.createQuery("from IncidentDo where actionTeamStatus='Completed' order by INCIDENT_ID asc").list();
		return incidentList;
		}
		catch(Exception e){
		System.err.println("ERROR:---"+ e);
		}
		return null;
	}
	
	//get audit team approved incidents
		@SuppressWarnings("unchecked")
		public List<IncidentDo> getApprovedincidents() {
			try{
			Session session = this.factory.getCurrentSession();
			List<IncidentDo> incidentList = session.createQuery("from IncidentDo where status='Approved' order by INCIDENT_ID asc").list();
			return incidentList;
			}
			catch(Exception e){
			System.err.println("ERROR:---"+ e);
			}
			return null;
		}
	//getting graph data	
		@SuppressWarnings("unchecked")
		public List<IncidentDo> getGraphdata() {
			try{
			Session session = this.factory.getCurrentSession();
			List<IncidentDo> incidentList = session.createQuery("SELECT incidentType, MAX(riskLevel) FROM IncidentDo GROUP BY incidentType").list();
			return incidentList;
			}
			catch(Exception e){
			System.err.println("ERROR:---"+ e);
			}
			return null;
		}
		
//		public String savePhoto(MultipartFile multipartImage, int id) throws IOException{
//			
//			Session session = this.factory.getCurrentSession();
//			Query query = session.createQuery("update IncidentDo set PHOTO=:PHOTO where INCIDENT_ID=:INCIDENT_ID");
//		    query.setParameter("PHOTO",multipartImage.getBytes());
//		    query.setParameter("INCIDENT_ID",id);
//		    int result = query.executeUpdate();
//		    System.err.println("No of rows updated: "+result);
//		    return "Succesfully uploaded photo";
//		}
		
		
		
	
}