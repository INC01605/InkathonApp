package com.java.inkathon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.inkathon.dao.IncidentDao;
import com.java.inkathon.model.IncidentDo;
import com.java.inkathon.service.IncidentService;

@Service
public class IncidentServiceImpl implements IncidentService {
	
	@Autowired
	IncidentDao incidentDao;

	
	public String saveIncident(IncidentDo incident) {
		return incidentDao.saveIncident(incident);
	}

	@Override
	public List<IncidentDo> listIncidents() {
		return incidentDao.getAllincidents();
	}
	
	public List<IncidentDo> sortrisklevel() {
		return incidentDao.sortrisklevel();
	}
	
	public String updateRisk(IncidentDo incident){
		return incidentDao.updateRisk(incident);
	}
	
	public String updateStatus(IncidentDo incident){
		return incidentDao.updateStatus(incident);
	}
	
	public String rejectStatus(IncidentDo incident){
		return incidentDao.rejectStatus(incident);
	}
	
	public String deleteById(int id){
		return incidentDao.deleteIncident(id);
	}

	public String saveComments(IncidentDo incident){
		return incidentDao.saveComments(incident);
	}
	

	public String updateall(IncidentDo incident){
		return incidentDao.updateAll(incident);
	}
	public String updateaction(IncidentDo incident){
		return incidentDao.updateAction(incident);
	}
	
	@Override
	public List<IncidentDo> getDoneIncidents() {
		return incidentDao.getDoneincidents();
	}
	@Override
	public List<IncidentDo> getApprovedIncidents() {
		return incidentDao.getApprovedincidents();
	}

	@Override
	public List<IncidentDo> getNewIncidents() {
		return incidentDao.getNewIncidents();
	}
	@Override
	public List<IncidentDo> getGraphData() {
		return incidentDao.getGraphdata();
	}
	
//	public String savePhoto(MultipartFile multipartImage, int id) throws IOException{
//		return incidentDao.savePhoto(multipartImage,id);
//	}
//	
//	
//	
	

	
	
	
}