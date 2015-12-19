package br.com.curiosity.model.moviment;

import br.com.curiosity.model.Rover;

public class RoverMovimentBehaviour implements RoverBehaviour {

	private Rover rover;
	private int[][] ground;
	
	public RoverMovimentBehaviour(Rover rover, int[][] ground) {
		this.rover = rover;
		this.ground = ground;
	}

	@Override
	public void executeCommand() {
		if(rover.getDirection() == 'N' && (rover.getyPosition()+1) <= ground[0].length-1)
			rover.setyPosition(rover.getyPosition()+1);
		if(rover.getDirection() == 'S' && (rover.getyPosition()-1) >= 0)
			rover.setyPosition(rover.getyPosition()-1);
		if(rover.getDirection() == 'E' && (rover.getxPosition()+1) <= ground.length-1)
			rover.setxPosition(rover.getxPosition()+1);
		if(rover.getDirection() == 'W' && (rover.getxPosition()-1) >= 0)
			rover.setxPosition(rover.getxPosition()-1);
	}
}
