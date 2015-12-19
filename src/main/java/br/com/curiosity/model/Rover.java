package br.com.curiosity.model;

import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.model.moviment.MovimentFactory;
import br.com.curiosity.model.moviment.RoverBehaviour;

public class Rover {

	private Integer xPosition;
	private Integer yPosition;
	private Character direction;
	private String instructions;

	public Rover() {
	}

	public Rover(Integer xPosition, Integer yPosition, Character direction,
			String instructions) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.direction = direction;
		this.instructions = instructions;
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

	public Character getDirection() {
		return direction;
	}

	public void setDirection(Character direction) {
		this.direction = direction;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public void walk(int[][] ground) throws OutOfGroundException {
		if (xPosition > ground.length && yPosition > ground[0].length)
			throw new OutOfGroundException("Review your mission. OutOfGround."
					+ toString());

		char[] instructionsArray = readInstruction();
		RoverBehaviour roverBehaviour;
		for (int i = 0; i < instructionsArray.length; i++) {

			roverBehaviour = MovimentFactory.getRoverBehaviour(instructionsArray[i],
					this, ground);
			roverBehaviour.executeCommand();
		}
	}

	private char[] readInstruction() {
		return instructions.toCharArray();
	}

	@Override
	public String toString() {
		return xPosition + " " + yPosition + " " + direction;
	}
}