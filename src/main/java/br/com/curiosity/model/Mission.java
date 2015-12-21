package br.com.curiosity.model;

import java.util.List;

import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.exception.UnknownInstructionException;

public class Mission {
	private Integer xPosition;
	private Integer yPosition;
	private int[][] ground;
	private List<Rover> rovers;

	public Mission() {
	}
	
	public Mission(Integer xPosition, Integer yPosition, List<Rover> rovers) {
		super();
		this.ground = new int[xPosition][yPosition];
		this.rovers = rovers;
	}
	
	public List<Rover> executeMission() throws OutOfGroundException, UnknownInstructionException{
		for (Rover rover : rovers) {
			rover.executeMission(getGround());
		}
		return rovers;
	}

	public Integer getxPosition() {
		return xPosition;
	}

	public void setxPosition(Integer xPosition) {
		this.xPosition = xPosition;
	}

	public Integer getyPosition() {
		return yPosition;
	}

	public void setyPosition(Integer yPosition) {
		this.yPosition = yPosition;
	}

	public int[][] getGround() {
		if (ground == null)
			ground = new int[xPosition][yPosition];
		return ground;
	}

	public void setGround(int[][] ground) {
		this.ground = ground;
	}

	public List<Rover> getRovers() {
		return rovers;
	}

	public void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
	}
	
}