package br.com.curiosity.model;

public class Rover {
	
	private Integer xPosition;
	private Integer yPosition;
	private String direction;
	private String instructions;
	
	public Rover(Integer xPosition, Integer yPosition, String direction,
			String instructions) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.direction = direction;
		this.instructions = instructions;
	}
	
	
}
