package br.com.curiosity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.curiosity.model.moviment.commands.Instruction;
import br.com.curiosity.model.moviment.reader.InstructionReader;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Rover {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="position_id")
	private Position position;
	
	@Column(name="direction")
	private Direction direction;
	
	@OneToOne
	@JoinColumn(name="ground_id")
	private Ground ground;
	
	@Column(name="instructions")
	private String instructions;
	
	@ManyToOne
	@JoinColumn(name="mission_id")
	@JsonBackReference
	private Mission mission;

	public Rover() {
	}
	
	public Rover(Direction direction, Position position,
			String instruction) {
		this.direction = direction;
		this.position = position;
		this.instructions = instruction;
	}

	public Rover(Ground ground, Direction direction, Position position,
			String instruction) {
		this.ground = ground;
		this.direction = direction;
		this.position = position;
		this.instructions = instruction;
	}

	public void executeInstructions() {
		InstructionReader instructionReader = new InstructionReader(
				this.instructions);
		List<Instruction> instructions = instructionReader.getInstructions();
		for (Instruction instruction : instructions) {
			instruction.executeInstruction(this);
		}
	}

	public String currentLocation() {
		return position.toString() + " " + direction.toString();
	}

	public void turnRight() {
		this.direction = this.direction.right();
	}

	public void turnLeft() {
		this.direction = this.direction.left();
	}

	public void move() {
		Position newPosition = position.getNewPositionAfterMoviment(
				direction.xMove(), direction.yMove());

		if (ground.isValidMoviment(newPosition))
			position = position.getNewPosition(direction.xMove(),
					direction.yMove());
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Ground getGround() {
		return ground;
	}

	public void setGround(Ground ground) {
		this.ground = ground;
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

}