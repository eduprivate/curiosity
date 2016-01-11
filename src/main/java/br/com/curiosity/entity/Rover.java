package br.com.curiosity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.curiosity.model.moviment.RoverDirectionBehaviour;
import br.com.curiosity.model.moviment.RoverMovimentBehaviour;
import br.com.curiosity.model.moviment.commands.Instruction;
import br.com.curiosity.model.moviment.parser.InstructionReader;

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
	
	private int[][] ground;
	
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
	
	public Rover(Integer xPosition, Integer yPosition, Character direction,
			String instructions, int[][] ground) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.direction = direction;
		this.instructions = instructions;
		this.ground = ground;
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
	
	public void setGround(int[][] ground) {
		this.ground = ground;
	}
		
	public void executeInstruction()  {
		InstructionReader instructionReader = new InstructionReader(instructions);
		List<Instruction> instructions = instructionReader.getInstructions();
		for (Instruction instruction : instructions) {
			instruction.executeInstruction(this);
		}
	}
	
	public void move(){
		RoverMovimentBehaviour movimentBehaviour = new RoverMovimentBehaviour(this, ground);
		movimentBehaviour.executeCommand();
	}
	
	public void turnLeft() {
		RoverDirectionBehaviour directionBehaviour = new  RoverDirectionBehaviour(this, 'L');
		directionBehaviour.executeCommand();
	}

	public void turnRight() {
		RoverDirectionBehaviour directionBehaviour = new  RoverDirectionBehaviour(this, 'R');
		directionBehaviour.executeCommand();
	}
	
	@Override
	public String toString() {
		return xPosition + " " + yPosition + " " + direction;
	}

}