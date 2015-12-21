package br.com.curiosity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.curiosity.model.Mission;
import br.com.curiosity.model.Rover;
import br.com.curiosity.services.MissionControllService;

@RestController
public class MissionController {
	
	private MissionControllService missionControllService;
	
	@RequestMapping(value="/mission", method = RequestMethod.POST )
    public @ResponseBody List<Rover> executeMission(@RequestBody Mission mission) {
		
		return missionControllService.executeMission(mission);		
    }

	
	@Autowired
	public void setMissionControllService(
			MissionControllService missionControllService) {
		this.missionControllService = missionControllService;
	}
}