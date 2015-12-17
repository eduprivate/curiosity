package br.com.curiosity.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curiosity.model.Mission;
import br.com.curiosity.services.MissionControllService;

@RestController
public class MissionController {
	
	private MissionControllService missionControllService;
	
	private Logger logger = LogManager.getLogger(MissionController.class);
	
	@RequestMapping(value="/mission", method = RequestMethod.POST )
    public ResponseEntity<String> executeMission(@RequestBody Mission mission) {
    	try {
    		missionControllService.execute(mission);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("An error occurred while executing mission. Malfunction of the on-board computer!", e);
		} 
    	return new ResponseEntity<String>(HttpStatus.PRECONDITION_FAILED); 
    }

	
	@Autowired
	public void setMissionControllService(
			MissionControllService missionControllService) {
		this.missionControllService = missionControllService;
	}
}