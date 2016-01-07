package br.com.curiosity.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curiosity.entity.Mission;
import br.com.curiosity.entity.Rover;
import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.exception.UnknownInstructionException;
import br.com.curiosity.repository.MissionRepository;
import br.com.curiosity.repository.RoverRepository;

@Service
public class MissionControllService {
	
	private Logger logger = LogManager.getLogger(MissionControllService.class);
	
	private MissionRepository missionRepository;
	private RoverRepository roverRepository;
	
	public List<Rover> executeMission(Mission mission)  {
		List<Rover> rovers = new ArrayList<Rover>();
		try {
    		rovers = mission.executeMission();
    		missionRepository.save(mission);
    		roverRepository.save(rovers);
		} catch (OutOfGroundException e) {
			logger.error("An error occurred while executing mission. Review your mission!", e);
		} catch (UnknownInstructionException e) {
			logger.error("An error occurred while executing mission. Unknown Instruction!", e);
		} 
    	return rovers; 
	}
	
	public void execute(Mission mission)  {
		List<Rover> rovers = new ArrayList<Rover>();
		try {
    		rovers = mission.executeMission();
    		missionRepository.save(mission);
    		roverRepository.save(rovers);
		} catch (OutOfGroundException e) {
			logger.error("An error occurred while executing mission. Review your mission!", e);
		} catch (UnknownInstructionException e) {
			logger.error("An error occurred while executing mission. Unknown Instruction!", e);
		} 
	}
	
	public Mission retrieveMission(Long missionId)  {
		
		return missionRepository.findOne(missionId);
	}
	
	@Autowired
	public void setMissionRepository(MissionRepository missionRepository) {
		this.missionRepository = missionRepository;
	}
	
	@Autowired
	public void setRoverRepository(RoverRepository roverRepository) {
		this.roverRepository = roverRepository;
	}
}