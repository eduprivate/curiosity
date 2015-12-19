package br.com.curiosity.model.moviment;

import br.com.curiosity.exception.UnknownInstructionException;
import br.com.curiosity.model.Rover;

public class MovimentFactory {

	public MovimentFactory() {
	}
	
	public static RoverBehaviour getRoverBehaviour(char instruction, Rover rover, int[][] ground) throws UnknownInstructionException {
		switch (instruction) {
			case 'M':
				return new RoverMovimentBehaviour(rover, ground);
			case 'L':
				return new RoverDirectionBehaviour(rover, 'L');
			case 'R':
				return new RoverDirectionBehaviour(rover, 'R');
			default:
				throw new UnknownInstructionException();
		}
	}

}
