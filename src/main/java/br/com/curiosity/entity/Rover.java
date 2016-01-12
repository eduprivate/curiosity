package br.com.curiosity.entity;

import java.util.List;

import br.com.curiosity.model.moviment.commands.Instruction;
import br.com.curiosity.model.moviment.parser.InstructionReader;

public class Rover {

	private Position position;
	private Direction direction;
	private Ground ground;
	private String instructions;

	public Rover() {
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


}