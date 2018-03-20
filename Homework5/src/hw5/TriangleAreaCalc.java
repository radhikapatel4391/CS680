package hw5;

import java.awt.Point;
import java.util.ArrayList;

public class TriangleAreaCalc implements AreaCalculator {

	

	@Override
	public float getArea(ArrayList<Point> points) {
		// TODO Auto-generated method stub
		float ax =  (float) points.get(0).getX();
		float ay =  (float) points.get(0).getY();
		float bx =  (float) points.get(1).getX();
		float by =  (float) points.get(1).getY();
		float cx =  (float) points.get(2).getX();
		float cy =  (float) points.get(2).getY();
		
		return Math.abs(((ax*(by-cy) + bx*(cy-ay) + cx*(ay-by))/2));
	}

}
