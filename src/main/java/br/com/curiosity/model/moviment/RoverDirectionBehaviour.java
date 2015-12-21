package br.com.curiosity.model.moviment;

import br.com.curiosity.model.Rover;

public class RoverDirectionBehaviour implements RoverBehaviour {
	
	public static final char MOVE = 'M';
	public static final char RIGHT = 'R';
	public static final char LEFT = 'L';
	public static final char NORTH = 'N';
	public static final char WEST = 'W';
	public static final char SOUTH = 'S';
	public static final char EAST = 'E';

	private Rover rover;
	private char direction;
	
	public RoverDirectionBehaviour(Rover rover, char direction) {
		this.rover = rover;
		this.direction = direction;
	}

	@Override
	public void executeCommand() {
		if ( direction == LEFT) {
			switch (rover.getDirection()) {
				case NORTH:
					changeRoverDirectionTo(WEST);
					break;
				case WEST:
					changeRoverDirectionTo(SOUTH);
					break;
				case SOUTH:
					changeRoverDirectionTo(EAST);
					break;	
				case EAST:
					changeRoverDirectionTo(NORTH);
					break;	
			}
		} else {
			switch (rover.getDirection()) {
				case NORTH:
					changeRoverDirectionTo(EAST);
					break;
				case EAST:
					changeRoverDirectionTo(SOUTH);
					break;
				case SOUTH:
					changeRoverDirectionTo(WEST);
					break;	
				case WEST:
					changeRoverDirectionTo(NORTH);
					break;	
			}
		}
	}
	
	private void changeRoverDirectionTo(char direction) {
		rover.setDirection(direction);
	}
}