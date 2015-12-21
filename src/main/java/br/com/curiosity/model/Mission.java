package br.com.curiosity.model;

import java.util.List;

import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.exception.UnknownInstructionException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Mission {
	private int[][] ground;
	private List<Rover> rovers;
	
	@JsonCreator
	public Mission(@JsonProperty("xPosition") Integer xPosition, @JsonProperty("yPosition") Integer yPosition, 
			@JsonProperty("rovers") List<Rover> rovers) {
		this.ground = new int[xPosition][yPosition];
		this.rovers = rovers;
	}
	
	public List<Rover> executeMission() throws OutOfGroundException, UnknownInstructionException{
		for (Rover rover : rovers) {
			rover.executeMission(ground);
		}
		return rovers;
	}
	
}