package br.com.curiosity.model.moviment;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.curiosity.exception.UnknownInstructionException;
import br.com.curiosity.model.LowLand;
import br.com.curiosity.model.Rover;

public class MovimentFactoryTest {

	@Test
	public void movimentFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'M';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		
		// Then
		assertTrue(roverBehaviour instanceof RoverMovimentBehaviour);
	}
	
	@Test
	public void leftNorthToWestDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'L';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('W'), rover.getDirection());
	}
	
	@Test
	public void leftWestToSouthDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'W', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'L';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('S'), rover.getDirection());
	}
	
	@Test
	public void leftSouthToEastDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'S', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'L';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('E'), rover.getDirection());
	}
	
	@Test
	public void rightNorthToEastDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('E'), rover.getDirection());
	}
	
	@Test
	public void rightEastToSouthDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'E', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('S'), rover.getDirection());
	}
	
	@Test
	public void rightSouthToWestDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'S', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('W'), rover.getDirection());
	}
	
	@Test
	public void rightWestToNorthDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'W', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
		assertEquals( new Character('N'), rover.getDirection());
	}
	
	@Test
	public void rightDirectionFactoryTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'R';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		
		// Then
		assertTrue(roverBehaviour instanceof RoverDirectionBehaviour);
	}
	
	@Test
	public void moveRoverOverYAxisTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'M';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		// Then
		assertTrue(roverBehaviour instanceof RoverMovimentBehaviour);
		assertEquals("1 3 N", rover.toString());
	}
	
	@Test
	public void moveRoverOverXAxisTest() throws UnknownInstructionException {
		//Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		RoverBehaviour roverBehaviour;
		char movimentInstruction = 'L';
		
		// When
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		movimentInstruction = 'M';
		roverBehaviour = MovimentFactory.getRoverBehaviour(movimentInstruction, rover, lowLand.getGround());
		roverBehaviour.executeCommand();
		
		// Then
		assertTrue(roverBehaviour instanceof RoverMovimentBehaviour);
		assertEquals("0 2 W", rover.toString());
	}
}