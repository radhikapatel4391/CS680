package hw5;

import java.awt.Point;
import java.util.ArrayList;

public class Polygon {
	private ArrayList<Point> points;
	
	public ArrayList<Point> getPoints() {
		return points;
	}

	private AreaCalculator areaCalc;

	

	public AreaCalculator getAreaCalc() {
		return areaCalc;
	}
	public Polygon(ArrayList<Point> points, AreaCalculator areaCalc) {
		this.points = points;
		this.areaCalc = areaCalc;
	}
	public void setAreaCalc(AreaCalculator areaCalc) {
		this.areaCalc = areaCalc;
	}
	public void addPoint(Point point ) {
		points.add(point);
	}
	
	public float getArea() {
		return areaCalc.getArea(points);
	}
}
