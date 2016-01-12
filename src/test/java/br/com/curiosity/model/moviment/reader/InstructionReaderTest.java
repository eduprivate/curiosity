package br.com.curiosity.model.moviment.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.curiosity.model.moviment.commands.Instruction;
import br.com.curiosity.model.moviment.commands.MoveInstruction;
import br.com.curiosity.model.moviment.commands.RotateLeftInstruction;
import br.com.curiosity.model.moviment.commands.RotateRightInstruction;

public class InstructionReaderTest {

	@Test
	public void readInstructionTest() {
		//Given
		String instructions = "LMLMLMLMM";
		InstructionReader instructionReader = new InstructionReader(instructions);
		
		//When
		List<Instruction> instructionsList = instructionReader.getInstructions();
		
		//Then
		assertNotNull(instructionsList);
		assertEquals(9, instructionsList.size());
	}
	
	@Test
	public void readTurnToLeftInstructionTest() {
		//Given
		String instructions = "L";
		InstructionReader instructionReader = new InstructionReader(instructions);
		
		//When
		List<Instruction> instructionsList = instructionReader.getInstructions();
		
		//Then
		assertTrue(instructionsList.get(0) instanceof RotateLeftInstruction);
		assertNotNull(instructionsList);
		assertEquals(1, instructionsList.size());
	}
	
	@Test
	public void readTurnToRightInstructionTest() {
		//Given
		String instructions = "R";
		InstructionReader instructionReader = new InstructionReader(instructions);
		
		//When
		List<Instruction> instructionsList = instructionReader.getInstructions();
		
		//Then
		assertTrue(instructionsList.get(0) instanceof RotateRightInstruction);
		assertNotNull(instructionsList);
		assertEquals(1, instructionsList.size());
	}
	
	@Test
	public void readMoveInstructionTest() {
		//Given
		String instructions = "M";
		InstructionReader instructionReader = new InstructionReader(instructions);
		
		//When
		List<Instruction> instructionsList = instructionReader.getInstructions();
		
		//Then
		assertTrue(instructionsList.get(0) instanceof MoveInstruction);
		assertNotNull(instructionsList);
		assertEquals(1, instructionsList.size());
	}

}
