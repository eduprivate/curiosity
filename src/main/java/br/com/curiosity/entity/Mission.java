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

@Entity
public class Mission {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="xPosition")
	private Integer xPosition;
	
	@Column(name="yPosition")
	private Integer yPosition;
	
	@OneToMany(mappedBy = "mission", targetEntity = Rover.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Rover> rovers;
	
	public Mission() {
	}
	
	@JsonCreator
	public Mission(@JsonProperty("xPosition") Integer xPosition, @JsonProperty("yPosition") Integer yPosition, 
			@JsonProperty("rovers") List<Rover> rovers) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.rovers = rovers;
	}
	
	public List<Rover> executeMission() throws OutOfGroundException, UnknownInstructionException{
		int[][] ground = new int[xPosition][yPosition];
		for (Rover rover : rovers) {
			rover.executeMission(ground);
			rover.setMission(this);
		}
		return rovers;
	}
	
	public Long getId() {
		return id;
	}

	public Integer getxPosition() {
		return xPosition;
	}

	public Integer getyPosition() {
		return yPosition;
	}

	public List<Rover> getRovers() {
		return rovers;
	}

}