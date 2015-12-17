package br.com.curiosity.model;

import java.util.List;

public class Mission {
	private LowLand lowLand;
	private List<Rover> rovers;
	
	public Mission() {
	}

	public Mission(LowLand lowLand, List<Rover> rovers) {
		super();
		this.lowLand = lowLand;
		this.rovers = rovers;
	}
		
}