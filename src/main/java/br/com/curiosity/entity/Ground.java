package br.com.curiosity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ground {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ground_id")
	private Long id;
	
	@OneToOne
	private Position topRightPosition = new Position(0, 0);
	
	@OneToOne
    private Position bottomLeftPosition = new Position(0, 0);
    
    public Ground() {
		// TODO Auto-generated constructor stub
	}

    public Ground(int topRightXCoordinate, int topRightYCoordinate) {
        this.topRightPosition = this.topRightPosition.getNewPosition(topRightXCoordinate, topRightYCoordinate);
    }

    public boolean isValidMoviment(final Position Position) {
        return this.bottomLeftPosition.exceededLimits(Position) && this.topRightPosition.isPositionWithinLimits(Position);
    }

	public void setTopRightPosition(Position topRightPosition) {
		this.topRightPosition = topRightPosition;
	}

	public void setBottomLeftPosition(Position bottomLeftPosition) {
		this.bottomLeftPosition = bottomLeftPosition;
	}

	public Position getTopRightPosition() {
		return topRightPosition;
	}

	public Position getBottomLeftPosition() {
		return bottomLeftPosition;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
}
