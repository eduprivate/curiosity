package br.com.curiosity.model;

import java.util.List;

import br.com.curiosity.exception.OutOfGroundException;

public class Mission {
	private LowLand lowLand;
	private List<Rover> rovers;

	public Mission() {
	}
	
	public Mission(LowLand lowLand, List<Rover> rovers) {
		super();
		this.lowLand = lowLand;
		this.rovers = rovers;
	}
	
	public List<Rover> executeMission() throws OutOfGroundException{
		for (Rover rover : rovers) {
			rover.walk(lowLand.getGround());
		}
		return rovers;
	}

	public LowLand getLowLand() {
		return lowLand;
	}

	public void setLowLand(LowLand lowLand) {
		this.lowLand = lowLand;
	}

	public List<Rover> getRovers() {
		return rovers;
	}

	public void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
	}
	
}