package br.com.curiosity.model.moviment;

import br.com.curiosity.exception.UnknownInstructionException;
import br.com.curiosity.model.Rover;

public class MovimentFactory {
	
	public static final char MOVE = 'M';
	public static final char RIGHT = 'R';
	public static final char LEFT = 'L';

	public MovimentFactory() {
	}
	
	public static RoverBehaviour getRoverBehaviour(char instruction, Rover rover, int[][] ground) throws UnknownInstructionException {
		switch (instruction) {
			case MOVE:
				return new RoverMovimentBehaviour(rover, ground);
			case LEFT:
				return new RoverDirectionBehaviour(rover, LEFT);
			case RIGHT:
				return new RoverDirectionBehaviour(rover, RIGHT);
			default:
				throw new UnknownInstructionException();
		}
	}

}
