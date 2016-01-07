package br.com.curiosity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.exception.UnknownInstructionException;
import br.com.curiosity.model.moviment.MovimentFactory;
import br.com.curiosity.model.moviment.RoverBehaviour;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Rover {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="xPosition")
	private Integer xPosition;
	
	@Column(name="yPosition")
	private Integer yPosition;
	
	@Column(name="direction")
	private Character direction;
	
	@Column(name="instructions")
	private String instructions;
	
	@ManyToOne
	@JoinColumn(name="mission_id")
	@JsonBackReference
	private Mission mission;

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
	
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	public Mission getMission() {
		return mission;
	}

	public void executeMission(int[][] ground) throws OutOfGroundException, UnknownInstructionException {
		
		checkGroundLimits(ground);
		char[] instructionsArray = readInstructions();
		
		executeInstructions(ground, instructionsArray);
	}


	private void executeInstructions(int[][] ground,
			char[] instructionsArray) throws UnknownInstructionException {
		RoverBehaviour roverBehaviour;
		for (int i = 0; i < instructionsArray.length; i++) {
			roverBehaviour = MovimentFactory.getRoverBehaviour(instructionsArray[i],
					this, ground);
			roverBehaviour.executeCommand();
		}
	}


	private void checkGroundLimits(int[][] ground) throws OutOfGroundException {
		if (xPosition > ground.length || yPosition > ground[0].length)
			throw new OutOfGroundException("Review your mission. OutOfGround."
					+ toString());
	}

	private char[] readInstructions() {
		return instructions.toCharArray();
	}

	@Override
	public String toString() {
		return xPosition + " " + yPosition + " " + direction;
	}
}