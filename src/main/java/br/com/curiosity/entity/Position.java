package br.com.curiosity.entity;



public class Position {

    private int xPosition;
    private int yPosition;
    
    public Position() {
	}

    public Position( int xPosition,  int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public Position getNewPosition( int xPositionStepValue,  int yPositionStepValue) {
        return new Position(this.xPosition + xPositionStepValue, this.yPosition + yPositionStepValue);
    }

    @Override
    public String toString() {
        return xPosition + " " + yPosition;
    }

    public boolean isPositionWithinLimits( Position Positions) {
        return isXMovimentValid(Positions.xPosition) && isYMovimentValid(Positions.yPosition);
    }

    public boolean exceededLimits( Position Positions) {
        return xMovimentExceededLimits(Positions.xPosition) && yMovimentExceededLimits(Positions.yPosition);
    }

    private boolean xMovimentExceededLimits( int xPosition) {
        return xPosition >= this.xPosition;
    }

    private boolean yMovimentExceededLimits( int yPosition) {
        return yPosition >= this.yPosition;
    }

    private boolean isYMovimentValid( int yPosition) {
        return yPosition <= this.yPosition;
    }

    private boolean isXMovimentValid( int xPosition) {
        return xPosition <= this.xPosition;
    }

    public Position getNewPositionAfterMoviment( int xPositionStepValue,  int yPositionStepValue) {
        return new Position(xPosition+xPositionStepValue, yPosition+yPositionStepValue);
    }

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
}
