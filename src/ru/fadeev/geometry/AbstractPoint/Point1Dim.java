package ru.fadeev.geometry.AbstractPoint;

public class Point1Dim extends PointProperty {
	private int x;

	// Get Set
	public void setX(int x) {
		this.x = x;
	}

	public int getX() { return x; }

	//Constructors
	public Point1Dim() {
		setX(x);
	}

	public Point1Dim(String color, String creationTime) {
		setX(0);
		setColor(color);
		setCreationTime(creationTime);
	}

	public Point1Dim(int x) {
		setX(x);
	}
	public Point1Dim(int x, String color, String creationTime) {
		setX(0);
		setColor(color);
		setCreationTime(creationTime);
	}

	public Point1Dim(Point1Dim point) {
		setX(point.x);
	}

	public Point1Dim(Point1Dim point, String color, String creationTime) {
		setX(point.x);
		setColor(color);
		setCreationTime(creationTime);
	}

	//Methods
	@Override
	public String showCoordinates() {
		return "{" + x + '}';
	}
}
