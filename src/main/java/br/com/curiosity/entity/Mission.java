package br.com.curiosity.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Mission {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mission_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ground_id")
	private Ground ground;

	@OneToMany(mappedBy = "mission", targetEntity = Rover.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Rover> rovers;

	public Mission() {
	}

	public Mission(Ground ground, List<Rover> rovers) {
		super();
		this.ground = ground;
		this.rovers = rovers;
	}

	public List<Rover> executeMission() {
		for (Rover rover : rovers) {
			rover.setGround(ground);
			rover.setMission(this);
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

	public Ground getGround() {
		return ground;
	}

	public List<Rover> getRovers() {
		return rovers;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}