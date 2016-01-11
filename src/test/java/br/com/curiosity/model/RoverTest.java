package br.com.curiosity.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.curiosity.entity.Rover;
import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.exception.UnknownInstructionException;

public class RoverTest {
	
	private int[][] ground;
	
	@Before
	public void setup(){
		ground = new int[5][5];
	}

	@Test
	public void walkTest() throws OutOfGroundException, UnknownInstructionException {
		// Given
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM", new int[5][5]);
		
		// When 
		rover.executeInstruction();
		
		// Then 
		assertEquals("1 3 N", rover.toString());
	}
	
	@Test
	public void avoidCollisionTest() throws OutOfGroundException, UnknownInstructionException {
		// Given
		Rover rover1 = new Rover(1, 2, 'N', "LMLMLMLMM", new int[5][5]);
		Rover rover2 = new Rover(1, 1, 'N', "MMMLMLMML", new int[5][5]);
		
		// When 
		rover1.executeInstruction();
		rover2.executeInstruction();
		// Then 
		assertEquals("1 3 N", rover1.toString());
		assertEquals("0 0 E", rover2.toString());
	}

}