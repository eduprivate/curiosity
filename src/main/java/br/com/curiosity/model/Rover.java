package br.com.curiosity.model;

import br.com.curiosity.exception.OutOfGroundException;

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
			throw new OutOfGroundException("Review your mission. OutOfGround." + toString());
		
		char[] instructionsArray = readInstruction();
 		
		for(int i = 0; i < instructionsArray.length -1 ;i++){
			switch (instructionsArray[i]) {
				case 'M':
					moveRover(ground);
					break;
				case 'L':
					changeDirection(instructionsArray[i]);
					break;
				case 'R':
					changeDirection(instructionsArray[i]);
					break;
			}
		}
	}
	
	private void changeDirection(Character c) {
		if (c == 'L') {
			switch (direction) {
				case 'N':
					direction = 'W';
					break;
				case 'W':
					direction = 'S';
					break;
				case 'S':
					direction = 'E';
					break;	
				case 'E':
					direction = 'N';
					break;	
			}
		} else {
			switch (direction) {
				case 'N':
					direction = 'E';
					break;
				case 'E':
					direction = 'S';
					break;
				case 'S':
					direction = 'W';
					break;	
				case 'W':
					direction = 'N';
					break;	
			}
		}
	}

	private void moveRover(int[][] ground) {
		if(direction == 'N' && (yPosition+1) <= ground[0].length-1)
			yPosition+=1;
		if(direction == 'S' && (yPosition-1) > 0)
			yPosition-=1;
		if(direction == 'E' && (xPosition+1) <= ground.length-1)
			yPosition+=1;
		if(direction == 'W' && (xPosition-1) > 0)
			yPosition-=1;
	}

	private char[] readInstruction(){
		return instructions.toCharArray();
	}
	
	@Override
	public String toString() {
		return xPosition + " " + yPosition + " " + direction;
	}
}