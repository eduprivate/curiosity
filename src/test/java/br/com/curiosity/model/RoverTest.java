package br.com.curiosity.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.curiosity.exception.OutOfGroundException;

public class RoverTest {

	@Test
	public void walkTest() throws OutOfGroundException {
		// Given
		LowLand lowLand = new LowLand(5, 5);
		Rover rover = new Rover(1, 2, 'N', "LMLMLMLMM");
		
		// When 
		rover.walk(lowLand.getGround());
		
		// Then 
		assertEquals("1 3 N", rover.toString());
	}

}
