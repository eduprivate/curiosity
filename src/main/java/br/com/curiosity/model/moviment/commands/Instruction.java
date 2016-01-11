package br.com.curiosity.model.moviment.commands;

import br.com.curiosity.entity.Rover;

public interface Instruction {

    public void executeInstruction(Rover rover);

}