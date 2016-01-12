package br.com.curiosity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.curiosity.entity.Mission;
import br.com.curiosity.entity.Rover;
import br.com.curiosity.services.MissionControllService;

@RestController
public class MissionController {
	
	private MissionControllService missionControllService;
	
	@RequestMapping(value="/mission", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE} )
    public @ResponseBody List<Rover> executeMission(@RequestBody Mission mission) {
		
		return missionControllService.executeMission(mission);		
    }
	
	@RequestMapping(value="/executemission", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE} )
    public @ResponseBody Mission execute(@RequestBody Mission mission) {
		
		missionControllService.execute(mission);
		return mission;
    }
	
	@RequestMapping(value="/mission/{missionId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public @ResponseBody Mission retrieveMission(@PathVariable Long missionId) {
		
		//return missionControllService.retrieveMission(missionId);		
		return null;
    }

	
	@Autowired
	public void setMissionControllService(
			MissionControllService missionControllService) {
		this.missionControllService = missionControllService;
	}
}