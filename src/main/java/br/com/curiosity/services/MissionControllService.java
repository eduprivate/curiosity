package br.com.curiosity.services;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.model.Mission;
import br.com.curiosity.model.Rover;

@Service
public class MissionControllService {
	
	private Logger logger = LogManager.getLogger(MissionControllService.class);
	
	public List<Rover> execute(Mission mission)  {
		try {
    		List<Rover> rovers = mission.executeMission();
			return rovers;
		} catch (OutOfGroundException e) {
			logger.error("An error occurred while executing mission. Malfunction of the on-board computer!", e);
		} 
    	return null; 
	}

}
