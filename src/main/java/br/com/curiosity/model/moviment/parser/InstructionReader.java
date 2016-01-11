package br.com.curiosity.model.moviment.parser;

import java.util.ArrayList;
import java.util.List;

import br.com.curiosity.model.moviment.commands.Instruction;
import br.com.curiosity.model.moviment.commands.MoveInstruction;
import br.com.curiosity.model.moviment.commands.RotateLeftInstruction;
import br.com.curiosity.model.moviment.commands.RotateRightInstruction;

public class InstructionReader {

    private static final String RIGHT = "R";
	private static final String LEFT = "L";
	private static final String EMPTY_STRING = "";

    private String instructions;

    public InstructionReader( String instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        if(instructions.isEmpty()) 
        	return new ArrayList<Instruction>();
        return buildInstructionsList(instructions);
    }

    private List<Instruction> buildInstructionsList(String instructionsString) {
        List<Instruction> instructions = new ArrayList<Instruction>();

        for(String instructionCharacter : commandCharactersFrom(instructionsString)) {
        	Instruction instruction = findInstruction(instructionCharacter.toUpperCase());
        	instructions.add(instruction);
        }

        return instructions;
    }

    private String[] commandCharactersFrom( String instructions) {
        return instructions.split(EMPTY_STRING);
    }

    private Instruction findInstruction(String instruction) {
        if (instruction.equalsIgnoreCase(LEFT))
        	return new RotateLeftInstruction();
        else if (instruction.equalsIgnoreCase(RIGHT))
        	return new RotateRightInstruction();
        else 
        	return new MoveInstruction();
    }

}