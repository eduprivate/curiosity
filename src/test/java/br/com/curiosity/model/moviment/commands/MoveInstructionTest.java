package br.com.curiosity.model.moviment.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.curiosity.entity.Direction;
import br.com.curiosity.entity.Ground;
import br.com.curiosity.entity.Position;
import br.com.curiosity.entity.Rover;

public class MoveInstructionTest {

	@Test
    public void moveRoverToNorthTest() {
        //Given
        MoveInstruction instruction = new MoveInstruction();
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        Rover rover = new Rover(ground, Direction.N, position, "LM");

        //When
        instruction.executeInstruction(rover);

        //Then
        assertEquals("1 3 N", rover.currentLocation());
    }
	
	@Test
    public void moveRoverToSouthTest() {
        //Given
        MoveInstruction instruction = new MoveInstruction();
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        Rover rover = new Rover(ground, Direction.S, position, "LM");

        //When
        instruction.executeInstruction(rover);

        //Then
        assertEquals("1 1 S", rover.currentLocation());
    }
	
	@Test
    public void moveRoverToWestTest() {
        //Given
        MoveInstruction instruction = new MoveInstruction();
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        Rover rover = new Rover(ground, Direction.W, position, "LM");

        //When
        instruction.executeInstruction(rover);

        //Then
        assertEquals("0 2 W", rover.currentLocation());
    }
	
	@Test
    public void moveRoverToEastTest() {
        //Given
        MoveInstruction instruction = new MoveInstruction();
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        Rover rover = new Rover(ground, Direction.E, position, "LM");

        //When
        instruction.executeInstruction(rover);

        //Then
        assertEquals("2 2 E", rover.currentLocation());
    }

}
