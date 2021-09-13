package com.java.inkathon.controller;
import com.java.inkathon.dto.ResponseDto;
import com.java.inkathon.model.IncidentDo;
import com.java.inkathon.service.IncidentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping(value="/Inkathon", produces="application/json")
public class IncidentController {
	
	@Autowired
	private IncidentService incidentService;
	
	ResponseDto rdto = new ResponseDto();
	
	@RequestMapping(value="/saveIncident", method= RequestMethod.POST)
	@ResponseBody 
	public String save(@RequestBody IncidentDo incident){
		return incidentService.saveIncident(incident);
	}
	
	@GetMapping("/test2")
	@ResponseBody
	public ResponseDto methodTest() {

		List<IncidentDo> rsE = incidentService.listIncidents();
		System.out.println("data " + rsE);
		rdto.setData(rsE);
		return rdto;
	}
	
	@RequestMapping(value="/updatedRisk", method= RequestMethod.POST)
	@ResponseBody
	public String updaterisk(@RequestBody IncidentDo incident){
		return incidentService.updateRisk(incident);
	}
	
}
