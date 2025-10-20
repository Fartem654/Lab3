package ru.fadeev.geometry;

import ru.fadeev.geometry.PointDefault.Point;
import java.util.Arrays;

public class Polyline {

	private Point[] arrayOfPoint;

	public void setArrayOfPoint(Point[] arrayOfPoint) {
		if (arrayOfPoint == null) {
			this.arrayOfPoint = new Point[0];
		} else {
			this.arrayOfPoint = new Point[arrayOfPoint.length];
			for (int i = 0; i < arrayOfPoint.length; i++) {
				if (arrayOfPoint[i] != null) {
					this.arrayOfPoint[i] = new Point(arrayOfPoint[i]);
				} else {
					this.arrayOfPoint[i] = new Point(0, 0);
				}
			}
		}
	}

	public Polyline() {
		setArrayOfPoint(new Point[0]);
	}

	public Polyline(Point[] arrayOfPoint) {
		setArrayOfPoint(arrayOfPoint);
	}

	public int contOfIndex(){
		return arrayOfPoint.length;
	}

	public void addPoint(Point point) {
		if (point == null) {
			return;
		}
		Point[] newArray = new Point[arrayOfPoint.length + 1];

		for (int i = 0; i < arrayOfPoint.length; i++) {
			newArray[i] = new Point(arrayOfPoint[i]);
		}

		newArray[arrayOfPoint.length] = new Point(point);
		this.arrayOfPoint = newArray;
	}

	public void addPoints(Point[] newPoints) {
		if (newPoints == null || newPoints.length == 0) {
			return;
		}

		Point[] newArray = new Point[arrayOfPoint.length + newPoints.length];
		int index = 0;

		for (Point p : arrayOfPoint) {
			newArray[index++] = new Point(p);
		}

		for (Point p : newPoints) {
			if (p != null) {
				newArray[index++] = new Point(p);
			} else {
				newArray[index++] = new Point(0, 0);
			}
		}

		this.arrayOfPoint = newArray;
	}

	public double getLength() {
		double totalLength = 0;
		if (arrayOfPoint.length >= 2) {
			double dx;
			double dy;
			for (int i = 0; i < arrayOfPoint.length - 1; i++) {
				dx = arrayOfPoint[i + 1].getX() - arrayOfPoint[i].getX();
				dy = arrayOfPoint[i + 1].getY() - arrayOfPoint[i].getY();
				totalLength += Math.sqrt(dx * dx + dy * dy);
			}
		}
		return totalLength;
	}

	public void changePoint(int indexOfPoint, double newX, double newY) {
		if (indexOfPoint < 0 || indexOfPoint >= arrayOfPoint.length) {
			throw new IllegalArgumentException("Точки с индексом " + indexOfPoint + " не существует!");
		} else {
			arrayOfPoint[indexOfPoint].setX(newX);
			arrayOfPoint[indexOfPoint].setY(newY);
		}
	}

	@Override
	public String toString() {
		return "Линия " + Arrays.toString(arrayOfPoint);
	}
}