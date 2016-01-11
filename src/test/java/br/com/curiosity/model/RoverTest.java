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
		System.out.println("End");
		// Then 
		assertEquals("1 3 N", rover.toString());
	}

}