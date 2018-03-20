package hw5;

import java.awt.Point;
import java.util.ArrayList;

public class RectangleAreaCalc implements AreaCalculator {

	@Override
	public float getArea(ArrayList<Point> points) {
		double height=0, length=0;
		Point ur = points.get(0);
		Point ul = points.get(1);
		Point lr = points.get(2);
		Point ll = points.get(3);
//length calculations
		if (ur.getX() == ul.getX()) {
			length = Math.abs((ur.getY() - ul.getY()));

		} else if (ur.getX() == lr.getX()) {
			length = Math.abs((ur.getY() - lr.getY()));
		} else {
			length = Math.abs((ur.getY() - ll.getY()));			
		}
//height calculations
		
		if (ur.getY() == ul.getY()) {
			height = Math.abs((ur.getX() - ul.getX()));

		} else if (ur.getY() == lr.getY()) {
			height = Math.abs((ur.getX() - lr.getX()));
		} else {
			height = Math.abs((ur.getX() - ll.getX()));
			
		}		
	
		//System.out.println("length:  " + length+"  height: "+height);
		
		return (float) (length * height);
	}

}
