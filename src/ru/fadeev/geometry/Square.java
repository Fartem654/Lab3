package ru.fadeev.geometry;

import ru.fadeev.geometry.PointDefault.Point;

public class Square {
	private Point leftTopCorner;
	private double sideLength;

	//GET SET
	public void setLeftTopCorner(double x, double y) {
		if (this.leftTopCorner != null) {
			this.leftTopCorner.setX(x);
			this.leftTopCorner.setY(y);
		} else {
			this.leftTopCorner = new Point(x, y);
		}
	}

	public void setLeftTopCorner(Point LeftTopCorner) {
		this.leftTopCorner = new Point(LeftTopCorner);
	}

	public Point getLeftTopCorner() {
		return leftTopCorner;
	}

	public void setSideLength(double sideLength) {
		if(sideLength <= 0){
			throw new IllegalArgumentException("Длина стороны квадрата не может быть отрицательной или равной 0");
		}
		this.sideLength = sideLength;
	}

	//Constructors
	public Square(Point leftTopCorner, double sideLength){
		setLeftTopCorner(leftTopCorner);
		setSideLength(sideLength);
	}

	public Square(double leftTopCornerX, double leftTopCornerY, double sideLength){
		setLeftTopCorner(leftTopCornerX, leftTopCornerY);
		setSideLength(sideLength);
	}

	//Methods

	public Polyline getPolyline(){
		Point[] points = {leftTopCorner,
				new Point(leftTopCorner.getX()+sideLength, leftTopCorner.getY()),
				new Point(leftTopCorner.getX()+sideLength, leftTopCorner.getY()-sideLength),
				new Point(leftTopCorner.getX(), leftTopCorner.getY()-sideLength)};
		return new Polyline(points);
	}

	@Override
	public String toString() {
		return "Квадрат в точке" + this.leftTopCorner + " со стороной " + this.sideLength;
	}
}
