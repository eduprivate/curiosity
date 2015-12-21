package br.com.curiosity.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.exception.UnknownInstructionException;
import br.com.curiosity.model.Mission;
import br.com.curiosity.model.Rover;

@Service
public class MissionControllService {
	
	private Logger logger = LogManager.getLogger(MissionControllService.class);
	
	public List<Rover> executeMission(Mission mission)  {
		List<Rover> rovers = new ArrayList<Rover>();
		try {
    		rovers = mission.executeMission();
		} catch (OutOfGroundException e) {
			logger.error("An error occurred while executing mission. Review your mission!", e);
		} catch (UnknownInstructionException e) {
			logger.error("An error occurred while executing mission. Unknown Instruction!", e);
		} 
    	return rovers; 
	}

}
