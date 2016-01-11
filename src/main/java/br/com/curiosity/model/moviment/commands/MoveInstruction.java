package br.com.curiosity.model.moviment.commands;

import br.com.curiosity.entity.Rover;

public class MoveInstruction implements Instruction {

    @Override
    public void executeInstruction(Rover rover) {
        rover.move();
    }
}