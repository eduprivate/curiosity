package br.com.curiosity.model;

public class LowLand {
	private Integer xPosition;
	private Integer yPosition;
	private int[][] ground;
	
	public LowLand() {
	}
	
	public LowLand(Integer xPosition, Integer yPosition) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		ground = new int[xPosition][yPosition];
	}
	
	public Integer getxPosition() {
		return xPosition;
	}

	public void setxPosition(Integer xPosition) {
		this.xPosition = xPosition;
	}

	public Integer getyPosition() {
		return yPosition;
	}

	public void setyPosition(Integer yPosition) {
		this.yPosition = yPosition;
	}

	public void setGround(int[][] ground) {
		this.ground = ground;
	}

	public int[][] getGround() {
		if (ground == null)
			ground = new int[xPosition][yPosition];
		return ground;
	}

}