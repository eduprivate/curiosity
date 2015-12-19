package br.com.curiosity.model.moviment;

import br.com.curiosity.model.Rover;

public class MovimentFactory {

	public MovimentFactory() {
	}
	
	public static RoverBehaviour getRoverBehaviour(char instruction, Rover rover, int[][] ground) {
		switch (instruction) {
			case 'M':
				return new RoverMovimentBehaviour(rover, ground);
			case 'L':
				return new RoverDirectionBehaviour(rover, 'L');
			case 'R':
				return new RoverDirectionBehaviour(rover, 'R');
			default:
				return null;
		}
	}

}
