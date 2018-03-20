package exercise.ex2;

import java.awt.Point;
import java.util.ArrayList;

public class Rectangle extends Polygon {
	
	private ArrayList<Point> pointsAL = new ArrayList<Point>();
	public Rectangle(Point a, Point b, Point c,Point d) {
		pointsAL.add(a);
		pointsAL.add(b);
		pointsAL.add(c);
		pointsAL.add(d);
		
	}

	@Override
	public ArrayList<Point> getPoints() {
		// TODO Auto-generated method stub
		return pointsAL;
	}

	@Override
	public float getArea() {
		Point ur = pointsAL.get(0);
		Point ul = pointsAL.get(1);
		Point lr = pointsAL.get(2);
		Point ll = pointsAL.get(3);
		
		double length = Math.sqrt( (ur.getX()-ul.getX()) * (ur.getX()-ul.getX()) ) + ( (ur.getY()-ul.getY()) * (ur.getY()-ul.getY()) ); //calculates length
	    double height = Math.sqrt( (lr.getX()-ll.getX()) * (lr.getX()-ll.getX()) ) + ( (lr.getY()-ll.getY()) * (lr.getY()-ll.getY()) ); //calculates height

	    return (float) (length * height);
	}

	@Override
	public Point getCentroid() {
		// TODO Auto-generated method stub
		return null;
	}

}
