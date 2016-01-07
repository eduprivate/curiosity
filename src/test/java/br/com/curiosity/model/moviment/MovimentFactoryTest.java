package br.com.curiosity.model.moviment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.curiosity.entity.Rover;
import br.com.curiosity.exception.UnknownInstructionException;

public class MovimentFactoryTest {
	
private int[][] ground;
	
	@Before
	public void setup(){
		this.ground = new int[5][5];
	}

	@Test
	public void movimentFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'M';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		
		// Then
		assertTrue(roverBehaviour instanceof RoverMovimentBehaviour);
	}
	
	@Test
	public void leftNorthToWestDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'L';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('W'), rover.getDirection());
	}
	
	@Test
	public void leftWestToSouthDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'W', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'L';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('S'), rover.getDirection());
	}
	
	@Test
	public void leftSouthToEastDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'S', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'L';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('E'), rover.getDirection());
	}
	
	@Test
	public void rightNorthToEastDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('E'), rover.getDirection());
	}
	
	@Test
	public void rightEastToSouthDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'E', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('S'), rover.getDirection());
	}
	
	@Test
	public void rightSouthToWestDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'S', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('W'), rover.getDirection());
	}
	
	@Test
	public void rightWestToNorthDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'W', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('N'), rover.getDirection());
	}
	
	@Test
	public void rightDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
	}
	
	@Test
	public void moveRoverOverYAxisTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'M';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		// Then
		assertTrue(roverBehaviour instanceof RoverMovimentBehaviour);
		assertEquals("1 3 N", rover.toString());
	}
	
	@Test
	public void moveRoverOverXAxisTest() throws UnknownInstructionException {
		//Given
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'L';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		movimentInstruction = 'M';
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, this.ground);
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverMovimentBehaviour);
		assertEquals("0 2 W", rover.toString());
	}
}