package exercise.ex2;

import java.awt.Point;
import java.util.ArrayList;



public class Triangle extends Polygon {
	
	private ArrayList<Point> pointsAL = new ArrayList<Point>();
	public Triangle(Point a, Point b, Point c) {
		pointsAL.add(a);
		pointsAL.add(b);
		pointsAL.add(c);
		
	}
	@Override
	public ArrayList<Point> getPoints() {
		
		return pointsAL;
	}

	@Override
	public float getArea() {
		
		float ax =  (float) pointsAL.get(0).getX();
		float ay =  (float) pointsAL.get(0).getY();
		float bx =  (float) pointsAL.get(1).getX();
		float by =  (float) pointsAL.get(1).getY();
		float cx =  (float) pointsAL.get(2).getX();
		float cy =  (float) pointsAL.get(2).getY();
		
		return Math.abs(((ax*(by-cy) + bx*(cy-ay) + cx*(ay-by))/2));
	}

	@Override
	public Point getCentroid() {
		
		return null;
	}

}
