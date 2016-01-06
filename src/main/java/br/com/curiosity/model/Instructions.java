package br.com.curiosity.model;

public enum Instructions {

	LEFT('L'), RIGHT('R'), MOVE('M'), NORTH('N'), WEST('W'), SOUTH('S'), EAST('E');

	char c;

	Instructions(char c) {
		this.c = c;
	}

	public char getChar() {
		return c;
	}
}
