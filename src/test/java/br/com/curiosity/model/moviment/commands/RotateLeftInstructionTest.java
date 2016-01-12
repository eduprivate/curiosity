package br.com.curiosity.model.moviment.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.curiosity.entity.Direction;
import br.com.curiosity.entity.Ground;
import br.com.curiosity.entity.Position;
import br.com.curiosity.entity.Rover;

public class RotateLeftInstructionTest {

	@Test
    public void rotateToLeftFromNorthTest() {
        //Given
        RotateLeftInstruction instruction = new RotateLeftInstruction();
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        Rover rover = new Rover(ground, Direction.N, position, "LM");

        //When
        instruction.executeInstruction(rover);

        //Then
        assertEquals("1 2 W", rover.currentLocation());
    }
	
	@Test
    public void rotateToLeftFromSouthTest() {
        //Given
        RotateLeftInstruction instruction = new RotateLeftInstruction();
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        Rover rover = new Rover(ground, Direction.S, position, "LM");

        //When
        instruction.executeInstruction(rover);

        //Then
        assertEquals("1 2 E", rover.currentLocation());
    }
	
	@Test
    public void rotateToLeftFromWestTest() {
        //Given
        RotateLeftInstruction instruction = new RotateLeftInstruction();
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        Rover rover = new Rover(ground, Direction.W, position, "LM");

        //When
        instruction.executeInstruction(rover);

        //Then
        assertEquals("1 2 S", rover.currentLocation());
    }
	
	@Test
    public void rotateToLeftFromEastTest() {
        //Given
        RotateLeftInstruction instruction = new RotateLeftInstruction();
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        Rover rover = new Rover(ground, Direction.E, position, "LM");

        //When
        instruction.executeInstruction(rover);

        //Then
        assertEquals("1 2 N", rover.currentLocation());
    }

}
