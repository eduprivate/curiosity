package br.com.curiosity.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curiosity.entity.Ground;
import br.com.curiosity.entity.Mission;
import br.com.curiosity.entity.Position;
import br.com.curiosity.entity.Rover;
import br.com.curiosity.repository.GroundRepository;
import br.com.curiosity.repository.MissionRepository;
import br.com.curiosity.repository.PositionRepository;
import br.com.curiosity.repository.RoverRepository;

@Service
public class MissionControllService {

	private Logger logger = LogManager.getLogger(MissionControllService.class);

	private MissionRepository missionRepository;
	private RoverRepository roverRepository;
	private GroundRepository groundRepository;
	private PositionRepository positionRepository;

	public List<Rover> executeMission(Mission mission) {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers = mission.executeMission();
		saveGroundPosition(mission.getGround());
		groundRepository.save(mission.getGround());
		saveRoversPosition(rovers);
		missionRepository.save(mission);
		roverRepository.save(rovers);
		return rovers;
	}

	private void saveGroundPosition(Ground ground) {
		positionRepository.save(ground.getBottomLeftPosition());
		positionRepository.save(ground.getTopRightPosition());
		
	}

	private void saveRoversPosition(List<Rover> rovers) {
		for (Rover rover : rovers) {
			positionRepository.save(rover.getPosition());
		}
	}

	public void execute(Mission mission) {
		List<Rover> rovers = new ArrayList<Rover>();
		rovers = mission.executeMission();
		missionRepository.save(mission);
		// roverRepository.save(rovers);

	}

	public Mission retrieveMission(Long missionId) {

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
	
	@Autowired
	public void setGroundRepository(GroundRepository groundRepository) {
		this.groundRepository = groundRepository;
	}
	
	@Autowired
	public void setPositionRepository(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}

}