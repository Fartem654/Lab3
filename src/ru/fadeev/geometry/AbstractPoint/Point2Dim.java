package ru.fadeev.geometry.AbstractPoint;

public class Point2Dim extends PointProperty {
	private int x;
	private int y;

	// Get Set
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//Constructors
	public Point2Dim() {
		setX(0);
		setY(0);
	}

	public Point2Dim(String color, String creationTime) {
		setX(0);
		setY(0);
		setColor(color);
		setCreationTime(creationTime);
	}
	public Point2Dim(int x, int y) {
		setX(x);
		setY(y);
	}

	public Point2Dim(int x, int y, String color, String creationTime) {
		setX(x);
		setY(y);
		setColor(color);
		setCreationTime(creationTime);
	}

	public Point2Dim(Point2Dim point) {
		setX(point.x);
		setY(point.y);
	}

	public Point2Dim(Point2Dim point, String color, String creationTime) {
		setX(point.x);
		setY(point.y);
		setColor(color);
		setCreationTime(creationTime);
	}

	//Methods
	@Override
	public String showCoordinates() {
		return "{" + x + ";" + y + "}";
	}
}
