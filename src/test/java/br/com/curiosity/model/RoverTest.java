package br.com.curiosity.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.curiosity.entity.Direction;
import br.com.curiosity.entity.Ground;
import br.com.curiosity.entity.Position;
import br.com.curiosity.entity.Rover;

public class RoverTest {
	
	@Test
    public void dontGoAwayTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "LMMMMMMMM";
        Rover rover = new Rover(ground, Direction.N, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("0 2 W", rover.currentLocation());
    }
	
	@Test
    public void moveToNorthTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "M";
        Rover rover = new Rover(ground, Direction.N, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 3 N", rover.currentLocation());
    }
	
	@Test
    public void moveToSouthTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "M";
        Rover rover = new Rover(ground, Direction.S, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 1 S", rover.currentLocation());
    }
	
	@Test
    public void moveToWestTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "M";
        Rover rover = new Rover(ground, Direction.W, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("0 2 W", rover.currentLocation());
    }
	
	@Test
    public void moveToEastTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "M";
        Rover rover = new Rover(ground, Direction.E, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("2 2 E", rover.currentLocation());
    }
	
	@Test
    public void turnLeftFromNorthTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "L";
        Rover rover = new Rover(ground, Direction.N, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 2 W", rover.currentLocation());
    }
	
	@Test
    public void turnLeftFromWestTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "L";
        Rover rover = new Rover(ground, Direction.W, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 2 S", rover.currentLocation());
    }
	
	@Test
    public void turnLeftFromSouthTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "L";
        Rover rover = new Rover(ground, Direction.S, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 2 E", rover.currentLocation());
    }
	
	@Test
    public void turnLeftFromEastTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "L";
        Rover rover = new Rover(ground, Direction.E, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 2 N", rover.currentLocation());
    }
	
	@Test
    public void turnRightFromNorthTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "R";
        Rover rover = new Rover(ground, Direction.N, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 2 E", rover.currentLocation());
    }
	
	@Test
    public void turnRightFromEastTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "R";
        Rover rover = new Rover(ground, Direction.E, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 2 S", rover.currentLocation());
    }
	
	@Test
    public void turnRightFromSouthTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "R";
        Rover rover = new Rover(ground, Direction.S, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 2 W", rover.currentLocation());
    }
	
	@Test
    public void turnRightFromWestTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "R";
        Rover rover = new Rover(ground, Direction.W, position, instruction);
        
        //When
        rover.executeInstructions();
        //then
        Assert.assertEquals("1 2 N", rover.currentLocation());
    }
	
	@Test
    public void currentPositionTest() {
        //Given
        Ground ground = new Ground(5,5);
        Position position = new Position(1,2);
        String instruction = "R";
       
        //When
        Rover rover = new Rover(ground, Direction.N, position, instruction);
        
        //then
        Assert.assertEquals("1 2 N", rover.currentLocation());
    }


}