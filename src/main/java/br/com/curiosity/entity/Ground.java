package br.com.curiosity.entity;


public class Ground {
	
	private Position topRightPosition = new Position(0, 0);
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
    
	
    
}
