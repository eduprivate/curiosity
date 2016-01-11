package br.com.curiosity.model.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.curiosity.utils.Normalize;

public class NormalizeTest {

	@Test
	public void testValidInstructions() {
		String instructions = "LMLMLMLMM";
		String normalizedInstructions = Normalize.normalize(instructions);
		
		assertEquals(instructions, normalizedInstructions);
		
	}
	
	@Test
	public void testInvalidInstructions() {
		String instructions = "LMLMLMLMMA";
		String normalizedInstructions = Normalize.normalize(instructions);
		String expectedInstructions = "LMLMLMLMM";
		
		assertEquals(expectedInstructions, normalizedInstructions);
		
	}

}
