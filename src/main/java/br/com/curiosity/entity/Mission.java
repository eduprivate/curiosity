package br.com.curiosity.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.curiosity.exception.OutOfGroundException;
import br.com.curiosity.exception.UnknownInstructionException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Mission {
	
	private Ground ground;
	
	/*@OneToMany(mappedBy = "mission", targetEntity = Rover.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference*/
	private List<Rover> rovers;
	
	public Mission() {
	}
	
	public List<Rover> executeMission() throws OutOfGroundException, UnknownInstructionException{
		for (Rover rover : rovers) {
			rover.setGround(ground);
			rover.executeInstructions();
		}
		return rovers;
	}
	
	public void setGround(Ground ground) {
		this.ground = ground;
	}
	
	public void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
	}

}