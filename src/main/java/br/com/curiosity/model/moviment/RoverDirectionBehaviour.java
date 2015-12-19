package br.com.curiosity.model.moviment;

import br.com.curiosity.model.Rover;

public class RoverDirectionBehaviour implements RoverBehaviour {

	private Rover rover;
	private char direction;
	
	public RoverDirectionBehaviour(Rover rover, char direction) {
		this.rover = rover;
		this.direction = direction;
	}

	@Override
	public void executeCommand() {
		if ( direction == 'L') {
			switch (rover.getDirection()) {
				case 'N':
					rover.setDirection('W');
					break;
				case 'W':
					rover.setDirection('S');
					break;
				case 'S':
					rover.setDirection('E');
					break;	
				case 'E':
					rover.setDirection('N');
					break;	
			}
		} else {
			switch (rover.getDirection()) {
				case 'N':
					rover.setDirection('E');
					break;
				case 'E':
					rover.setDirection('S');
					break;
				case 'S':
					rover.setDirection('W');
					break;	
				case 'W':
					rover.setDirection('N');
					break;	
			}
		}
	}
}