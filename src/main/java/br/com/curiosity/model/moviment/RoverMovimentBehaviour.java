package br.com.curiosity.model.moviment;

import br.com.curiosity.model.Rover;

public class RoverMovimentBehaviour implements RoverBehaviour {

	private Rover rover;
	private int[][] ground;

	public static final char NORTH = 'N';
	public static final char WEST = 'W';
	public static final char SOUTH = 'S';
	public static final char EAST = 'E';
	
	public RoverMovimentBehaviour(Rover rover, int[][] ground) {
		this.rover = rover;
		this.ground = ground;
	}

	@Override
	public void executeCommand() {
		if(rover.getDirection() == NORTH && canMoveToNorth())
			moveToNorth();
		if(rover.getDirection() == SOUTH && canMoveToSouth())
			moveToSouth();
		if(rover.getDirection() == EAST && canMoveToEast())
			moveToEast();
		if(rover.getDirection() == WEST && canMoveToWest())
			moveToWest();
	}

	private boolean canMoveToWest() {
		return (rover.getxPosition()-1) >= 0;
	}

	private boolean canMoveToEast() {
		return (rover.getxPosition()+1) <= ground.length-1;
	}

	private boolean canMoveToSouth() {
		return (rover.getyPosition()-1) >= 0;
	}

	private boolean canMoveToNorth() {
		return (rover.getyPosition()+1) <= ground[0].length-1;
	}

	private void moveToWest() {
		rover.setxPosition(rover.getxPosition()-1);
	}

	private void moveToEast() {
		rover.setxPosition(rover.getxPosition()+1);
	}

	private void moveToSouth() {
		rover.setyPosition(rover.getyPosition()-1);
	}

	private void moveToNorth() {
		rover.setyPosition(rover.getyPosition()+1);
	}
}
