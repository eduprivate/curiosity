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
		
		markRoverPosition();
	}
	
	private boolean canMoveToWest() {
		return (rover.getxPosition()-1) >= 0 
				&& verifyCollision(rover.getxPosition()-1, rover.getyPosition());
	}

	private boolean canMoveToEast() {
		return (rover.getxPosition()+1) <= ground.length-1
				&& verifyCollision(rover.getxPosition()+1, rover.getyPosition());
	}

	private boolean canMoveToSouth() {
		return (rover.getyPosition()-1) >= 0
				&& verifyCollision(rover.getxPosition(), rover.getyPosition()-1);
	}

	private boolean canMoveToNorth() {
		return (rover.getyPosition()+1) <= ground[0].length-1 
				&& verifyCollision(rover.getxPosition(), rover.getyPosition()+1);
	}

	private boolean verifyCollision(Integer xPosition, Integer yPosition) {
		return ground[xPosition][yPosition] != 1;
	}

	private void moveToWest() {
		unmarkRoverPosition(rover.getxPosition(), rover.getyPosition());
		rover.setxPosition(rover.getxPosition()-1);
	}

	private void moveToEast() {
		unmarkRoverPosition(rover.getxPosition(), rover.getyPosition());
		rover.setxPosition(rover.getxPosition()+1);
	}

	private void moveToSouth() {
		unmarkRoverPosition(rover.getxPosition(), rover.getyPosition());
		rover.setyPosition(rover.getyPosition()-1);
	}

	private void moveToNorth() {
		unmarkRoverPosition(rover.getxPosition(), rover.getyPosition());
		rover.setyPosition(rover.getyPosition()+1);
	}
	
	private void unmarkRoverPosition(Integer xPosition, Integer yPosition) {
		ground[xPosition][yPosition] = 0;
	}

	private void markRoverPosition() {
		ground[rover.getxPosition()][rover.getyPosition()] = 1;
	}
}
